package net.marco27.aem6.components.migrationtool.migrations.resourcetype;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;

import javax.jcr.query.Query;

import org.apache.commons.lang3.StringUtils;
import org.apache.sling.api.SlingConstants;
import org.apache.sling.api.resource.ModifiableValueMap;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ValueMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.marco27.aem6.components.migrationtool.AbstractMigrationController;
import net.marco27.aem6.components.migrationtool.model.MigrationResult;
import net.marco27.aem6.components.migrationtool.model.MigrationResultPath;
import net.marco27.aem6.components.migrationtool.model.MigrationStatus;

/**
 * This controller replaces resource types based on a a mapping. Inheriting classes must define the mapping.
 */
public abstract class ResourceTypeMigratorController extends AbstractMigrationController {

    private static final Logger LOG = LoggerFactory.getLogger(ResourceTypeMigratorController.class);
    private static final String PROPERTY_RESOURCE_TYPE = SlingConstants.NAMESPACE_PREFIX + ":"
            + SlingConstants.PROPERTY_RESOURCE_TYPE;

    protected ResourceTypeMigratorController(ResourceResolver resourceResolver, boolean dryRun) {
        super(resourceResolver, dryRun);
    }

    /**
     * @return the mapping of resource types to replace: key: old resource type, value: new resource type.
     */
    protected abstract Map<String, String> getResourceTypeMapping();

    @Override
    public MigrationResult migratePath(String path) {
        MigrationResult migrationResult = new MigrationResult();
        MigrationResultPath result = new MigrationResultPath(path);

        Iterator<Resource> iterator = getResourceResolver().findResources(generateQuery(path), Query.JCR_SQL2);
        while (iterator.hasNext()) {
            migrateResource(iterator.next());
        }

        result.addMigrationResultResource(getMigratedResources());
        result.setMigrationStatus(finalCommit());
        migrationResult.setPathResults(Collections.singletonList(result));
        return migrationResult;
    }

    @Override
    protected void migrateResource(final Resource resource) {
        LOG.trace("Migrating: [{}]", resource.getPath());
        Map<String, String> resourceTypeMap = getResourceTypeMapping();
        if (resourceTypeMap.keySet().contains(resource.getResourceType())) {
            LOG.trace("found type [{}]", resource.getResourceType());
            ValueMap valueMap = resource.adaptTo(ModifiableValueMap.class);
            valueMap.put(PROPERTY_RESOURCE_TYPE, resourceTypeMap.get(resource.getResourceType()));
            addResourceResult(resource, MigrationStatus.COMPONENT_MIGRATED);
            commit();
        } else if (resourceTypeMap.values().contains(resource.getResourceType())) {
            LOG.trace("found type already migrated [{}]", resource.getResourceType());
            addResourceResult(resource, MigrationStatus.COMPONENT_ALREADY_MIGRATED);
        } else {
            LOG.debug("Ignoring [{}] of type [{}]", resource.getPath(), resource.getResourceType());
        }

    }

    private String generateQuery(final String path) {
        Collection<String> values = new ArrayList<>();
        values.addAll(getResourceTypeMapping().values());
        values.addAll(getResourceTypeMapping().keySet());
        String query = "SELECT * from [nt:unstructured] WHERE isdescendantnode('" + path
                + "') and [sling:resourceType] in ('"
                + StringUtils.join(values, "','") + "')";
        LOG.debug("QUERY [{}]", query);
        return query;
    }
}