package net.marco27.aem6.components.migrationtool.migrations.messagestage;

import org.apache.felix.scr.annotations.Activate;
import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Properties;
import org.apache.felix.scr.annotations.Property;
import org.apache.felix.scr.annotations.Service;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.commons.osgi.PropertiesUtil;
import org.osgi.service.component.ComponentContext;

import net.marco27.aem6.components.migrationtool.AbstractMigration;
import net.marco27.aem6.components.migrationtool.AbstractMigrationController;

/**
 * Migrates message stage and message teaser.
 */
@Component(metatype = true)
@Properties({
        @Property(name = "PATHS", label = "PATHS", description = "Defines the paths where the migration will be launched", value = {
                "/content/microsites/"
        }),
        @Property(name = "NAME", label = "NAME", description = "Change the resourceType of the sectionheader component", value = "UBSFITREQ-26804 - Magazine - Enable MS6 Message Stage and Teaser"),
})
@Service
public class MessageStageMigration extends AbstractMigration {

    @Activate
    private void init(final ComponentContext context) {
        paths = PropertiesUtil.toStringArray(context.getProperties().get(PARAM_PATHS));
        migrationName = PropertiesUtil.toString(context.getProperties().get(PARAM_NAME), AbstractMigration.NOT_FOUND);
    }

    @Override
    protected AbstractMigrationController getControllerInstance(ResourceResolver resourceResolver,
            final boolean dryRun) {
        return new MessageStageMigrationController(resourceResolver, dryRun);
    }
}
