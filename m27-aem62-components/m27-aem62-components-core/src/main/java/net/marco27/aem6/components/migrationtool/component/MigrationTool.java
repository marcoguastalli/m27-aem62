package net.marco27.aem6.components.migrationtool.component;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.Self;

import net.marco27.aem6.components.migrationtool.Migration;
import net.marco27.aem6.components.migrationtool.config.MigrationConfiguration;

/**
 * Migration Bundle Tool
 */
@Model(adaptables = { Resource.class }, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class MigrationTool {

    @Self
    private Resource resource;

    @Inject
    private MigrationConfiguration migrationConfiguration;

    private List<Migration> migrationsAvailable;

    @PostConstruct
    protected void init() {
        migrationsAvailable = migrationConfiguration.getImplementations();
    }

    public List<Migration> getMigrations() {
        return migrationsAvailable;
    }
}