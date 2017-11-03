package net.marco27.aem6.components.migrationtool;

import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Reference;
import org.apache.sling.api.resource.LoginException;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ResourceResolverFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.marco27.aem6.components.migrationtool.model.MigrationResult;

/**
 * Migration Bundle Abstract Class
 */
@Component
public abstract class AbstractMigration implements Migration {

    protected static final Logger LOG = LoggerFactory.getLogger(AbstractMigration.class);

    protected static final String PARAM_NAME = "NAME";
    protected static final String PARAM_PATHS = "PATHS";

    protected static final String NOT_FOUND = "Name not found";
    protected static final String NEW_LINE = "\n";

    protected String migrationName;

    protected String[] paths = new String[0];

    @Reference
    private ResourceResolverFactory resourceResolverFactory;

    @Override
    public String getMigrationName() {
        return migrationName;
    }

    @Override
    public int getPathsNumber() {
        return paths.length;
    }

    @Override
    public String getDefaultPaths() {
        StringBuilder stringBuilder = new StringBuilder();
        for (String path : paths) {
            stringBuilder.append(path);
            stringBuilder.append(NEW_LINE);
        }
        return stringBuilder.toString();
    }

    @Override
    public MigrationResult migrate(final String[] paths, final boolean dryRun) {
        MigrationResult result = new MigrationResult();

        ResourceResolver resourceResolver = null;
        try {
            resourceResolver = this.resourceResolverFactory.getAdministrativeResourceResolver(null);
            AbstractMigrationController migrationController = getControllerInstance(resourceResolver, dryRun);
            for (String path : paths) {
                result.getPathResults().addAll(migrationController.migratePath(path).getPathResults());
            }
        } catch (LoginException e) {
            LOG.error("LoginException Error", e);
        } catch (Exception e) {
            LOG.error("Migrate Error", e);
        } finally {
            resourceResolver.close();
        }

        return result;
    }

    protected abstract AbstractMigrationController getControllerInstance(final ResourceResolver resourceResolver,
            final boolean dryRun);

    @Override
    public MigrationResult migrate(boolean dryRun) {
        return migrate(paths, dryRun);
    }
}
