package net.marco27.aem6.components.migrationtool.migrations.textandimage;

import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.sling.api.resource.ResourceResolver;

import net.marco27.aem6.components.migrationtool.migrations.resourcetype.ResourceTypeMigratorController;

/**
 * Migrates textandimage and message teaser resource types.
 */
public class TextAndImageMigrationController extends ResourceTypeMigratorController {

    private static final Map<String, String> MAPPING = new LinkedHashMap<>();

    static {
        MAPPING.put("m27/website/components/par/textandimage", "m27/website/components/par/textimage");
    }

    /**
     * Create a new thread-safe instance of the Controller
     *
     * @param dryRun           if no commit is needed
     * @param resourceResolver with the injection
     */
    public TextAndImageMigrationController(final ResourceResolver resourceResolver, final boolean dryRun) {
        super(resourceResolver, dryRun);
    }

    @Override
    protected Map<String, String> getResourceTypeMapping() {
        return MAPPING;
    }
}
