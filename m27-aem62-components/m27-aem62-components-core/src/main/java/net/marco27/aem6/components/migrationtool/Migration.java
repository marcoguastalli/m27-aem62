package net.marco27.aem6.components.migrationtool;

import net.marco27.aem6.components.migrationtool.model.MigrationResult;

public interface Migration {
    /**
     * Each migration has a name, which is a property configured through OSGI.
     *
     * @return name of the migration
     */
    String getMigrationName();

    /**
     * Each migration has some default paths under which it works, configured through OSGI. This function returns how
     * many of them are.
     *
     * @return number of paths to search in the migration
     */
    int getPathsNumber();

    /**
     * This function returns the default paths configured in OSGI for the migration. They are returned in a single
     * string and concatenated by a "\n" character.
     *
     * @return default paths
     */
    String getDefaultPaths();

    /**
     * Executes the migration with the default paths configured in OSGI.
     *
     * @param dryRun do a dry run of the migration
     * @return a string with all the pages that have been modified
     */
    MigrationResult migrate(final boolean dryRun);

    /**
     * Executes the migration in the given paths entered by the user manually.
     *
     * @param paths  array of paths in which to execute the migration
     * @param dryRun do a dry run of the migration
     * @return a string with all the pages that have been modified
     */
    MigrationResult migrate(final String[] paths, final boolean dryRun);
}
