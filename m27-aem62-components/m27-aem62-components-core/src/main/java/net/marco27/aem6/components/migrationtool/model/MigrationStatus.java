package net.marco27.aem6.components.migrationtool.model;

/**
 * enum with the statuses of the migration
 */
public enum MigrationStatus {
    RUNNING, EXCEPTION, MANDATORY_PATHS, PATH_NOT_FOUND, COMPONENT_NOT_FOUND, COMPONENT_EMPTY, COMPONENT_MIGRATED, COMPONENT_ALREADY_MIGRATED, NO_MIGRATION_NEEDED, DRYRUN, COMMIT_OK
}