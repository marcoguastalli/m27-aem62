package net.marco27.aem6.components.migrationtool.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Model object containing the migrated path
 */
public class MigrationResultPath {
    private final String path;
    private final List<MigrationResultResource> resources;
    private MigrationStatus migrationStatus;

    /**
     * Creates a new MigrationResultPath
     *
     * @param path the page path.
     */
    public MigrationResultPath(final String path) {
        this.path = path;
        this.resources = new ArrayList<>();
    }

    public String getPath() {
        return path;
    }

    public MigrationStatus getMigrationStatus() {
        return migrationStatus;
    }

    public void setMigrationStatus(MigrationStatus migrationStatus) {
        this.migrationStatus = migrationStatus;
    }

    public List<MigrationResultResource> getResources() {
        return Collections.unmodifiableList(this.resources);
    }

    /**
     * @param resourceResults to be add to the existing list
     */
    public void addMigrationResultResource(final List<MigrationResultResource> resourceResults) {
        this.resources.addAll(resourceResults);
    }
}