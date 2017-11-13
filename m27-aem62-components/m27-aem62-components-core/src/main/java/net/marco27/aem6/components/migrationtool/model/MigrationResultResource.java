package net.marco27.aem6.components.migrationtool.model;

/**
 * Model object for the migration response
 */
public class MigrationResultResource {
    private final String name;

    private final MigrationStatus migrationStatus;

    /**
     * Creates a new MigrationResultResource
     *
     * @param componentName the resource changed.
     * @param status        the Migration status
     */
    public MigrationResultResource(final String componentName, final MigrationStatus status) {
        this.name = componentName;
        this.migrationStatus = status;
    }

    public String getName() {
        return name;
    }

    public MigrationStatus getMigrationStatus() {
        return migrationStatus;
    }
}