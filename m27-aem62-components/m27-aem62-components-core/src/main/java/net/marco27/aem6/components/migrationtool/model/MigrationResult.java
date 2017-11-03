package net.marco27.aem6.components.migrationtool.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Model object containing the result of the migration process
 */
public class MigrationResult {
    private List<MigrationResultPath> pathResults;

    /**
     * Creates a new MigrationResult with default values
     */
    public MigrationResult() {
        this.pathResults = new ArrayList<>();
    }

    public List<MigrationResultPath> getPathResults() {
        return pathResults;
    }

    public void setPathResults(List<MigrationResultPath> paths) {
        this.pathResults = paths;
    }

}