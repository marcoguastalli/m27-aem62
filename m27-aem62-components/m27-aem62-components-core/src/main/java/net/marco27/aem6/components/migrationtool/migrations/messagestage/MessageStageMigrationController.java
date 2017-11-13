package net.marco27.aem6.components.migrationtool.migrations.messagestage;

import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.sling.api.resource.ResourceResolver;

import net.marco27.aem6.components.migrationtool.migrations.resourcetype.ResourceTypeMigratorController;

/**
 * Migrates messagestage and message teaser resource types.
 */
public class MessageStageMigrationController extends ResourceTypeMigratorController {

    private static final Map<String, String> MAPPING = new LinkedHashMap<>();

    static {
        MAPPING.put("ubs/fit/components/par/microsite6/messagestage", "ubs/fit/components/par/messagestage");
        MAPPING.put("ubs/fit/components/par/microsite6/messageteaser", "ubs/fit/components/par/messageteaser");
    }

    /**
     * Create a new thread-safe instance of the Controller
     *
     * @param dryRun           if no commit is needed
     * @param resourceResolver with the injection
     */
    public MessageStageMigrationController(final ResourceResolver resourceResolver, final boolean dryRun) {
        super(resourceResolver, dryRun);
    }

    @Override
    protected Map<String, String> getResourceTypeMapping() {
        return MAPPING;
    }
}
