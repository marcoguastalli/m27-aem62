package net.marco27.aem6.components.migrationtool.migrations.custom;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import javax.jcr.query.Query;

import org.apache.commons.lang3.StringUtils;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.marco27.aem6.components.migrationtool.AbstractMigrationController;
import net.marco27.aem6.components.migrationtool.model.MigrationResult;
import net.marco27.aem6.components.migrationtool.model.MigrationResultPath;

/**
 * This controller only searches for resource types and invokes the abstract migrate resource.
 */
public abstract class ResourceTypeMigrationController extends AbstractMigrationController {

    private static final Logger LOG = LoggerFactory.getLogger(ResourceTypeMigrationController.class);

    protected ResourceTypeMigrationController(ResourceResolver resourceResolver, boolean dryRun) {
        super(resourceResolver, dryRun);
    }

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

    /**
     * @return the list of resource types to be searched.
     */
    protected abstract List<String> getResourceTypeMapping();

    private String generateQuery(final String path) {
        String query = "SELECT * from [nt:unstructured] WHERE isdescendantnode('" + path
                + "') and [sling:resourceType] in ('"
                + StringUtils.join(getResourceTypeMapping(), "','") + "')";
        LOG.debug("QUERY [{}]", query);
        return query;
    }

}