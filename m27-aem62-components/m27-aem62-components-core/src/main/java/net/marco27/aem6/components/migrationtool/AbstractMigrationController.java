package net.marco27.aem6.components.migrationtool;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.sling.api.resource.PersistenceException;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.day.cq.wcm.api.Page;
import com.day.cq.wcm.api.PageManager;

import net.marco27.aem6.components.migrationtool.model.MigrationResult;
import net.marco27.aem6.components.migrationtool.model.MigrationResultPath;
import net.marco27.aem6.components.migrationtool.model.MigrationResultResource;
import net.marco27.aem6.components.migrationtool.model.MigrationStatus;

/**
 * Migration Controller. The entry point is the migratePath method. It takes the starting path and migrates the pages in the subtree. To do
 * this, it calls the migratePagesRecursively and migratePage methods. The migratePage is one possible extension point. migratePage calls
 * the methods migrateResourcesRecursively and migrateResource. The migrateResource is the other extension point, the method is abstract and
 * must be implemented by any extending class.
 */
public abstract class AbstractMigrationController {
    private static final Logger LOG = LoggerFactory.getLogger(AbstractMigrationController.class);
    private static final int MAX_WRITES_PER_COMMIT = 1000;

    private final boolean dryRun;
    private final ResourceResolver resourceResolver;
    private final PageManager pageManager;

    private int commitCount;
    private List<MigrationResultPath> pathResults;
    private List<MigrationResultResource> migratedResources = new ArrayList<>();

    protected AbstractMigrationController(final ResourceResolver resourceResolver, final boolean dryRun) {
        this.resourceResolver = resourceResolver;
        this.dryRun = dryRun;
        this.pageManager = resourceResolver.adaptTo(PageManager.class);
    }

    /**
     * Migrates the subtree starting by the given path
     *
     * @param path the path defining the subtree to migrate.
     * @return the MigrationResult representing the outcome.
     */
    public MigrationResult migratePath(final String path) {
        pathResults = new ArrayList<>();
        MigrationResult result = new MigrationResult();
        Page rootPage = pageManager.getPage(path);
        migratePagesRecursively(rootPage);
        finalCommit();
        result.setPathResults(pathResults);
        return result;
    }

    /**
     * Migrates a page and its children.
     *
     * @param page the page to migrate.
     */
    protected final void migratePagesRecursively(final Page page) {
        migratePage(page);
        Iterator<Page> listChildren = page.listChildren();
        while (listChildren.hasNext()) {
            Page child = listChildren.next();
            this.migratePagesRecursively(child);
        }
    }

    /**
     * Migrates a page
     *
     * @param page the page to migrate.
     */
    protected void migratePage(final Page page) {
        MigrationResultPath result = new MigrationResultPath(page.getPath());
        Resource contentResource = page.getContentResource();
        if (contentResource != null) {
            migratedResources = new ArrayList<>();
            migrateResourcesRecursively(contentResource);
            if (!migratedResources.isEmpty()) {
                result.addMigrationResultResource(migratedResources);
            }
        }
        result.setMigrationStatus(commit());
        if (!result.getResources().isEmpty()) {
            this.pathResults.add(result);
        }
    }

    /**
     * Migrates a resource and recursively its children.
     *
     * @param resource the resource to migrate.
     */
    protected void migrateResourcesRecursively(final Resource resource) {
        for (Resource child : resource.getChildren()) {
            migrateResource(child);
            if (child.hasChildren()) {
                migrateResourcesRecursively(child);
            }
        }
    }

    /**
     * Migrates a resource.
     *
     * @param resource the resource to migrate.
     */
    protected abstract void migrateResource(final Resource resource);

    protected MigrationStatus finalCommit() {
        commitCount = MAX_WRITES_PER_COMMIT;
        return commit();
    }

    protected final void addResourceResult(final Resource resource, final MigrationStatus status) {
        migratedResources.add(new MigrationResultResource(resource.getPath(), status));
    }

    /**
     * call to clean result list for current path and enable new results for next path
     */
    protected final void cleanResourceResults() {
        migratedResources = new ArrayList<>();
    }

    protected MigrationStatus commit() {
        MigrationStatus result = MigrationStatus.RUNNING;

        if (commitCount == MAX_WRITES_PER_COMMIT) {
            if (dryRun) {
                result = MigrationStatus.DRYRUN;
            } else {
                try {
                    resourceResolver.commit();
                    result = MigrationStatus.COMMIT_OK;
                } catch (PersistenceException e) {
                    LOG.error("Error Commit", e);
                    result = MigrationStatus.EXCEPTION;
                }
            }
            commitCount = -1;
        }
        commitCount++;
        LOG.debug("Migration status::  [{}]", result);
        return result;
    }

    protected ResourceResolver getResourceResolver() {
        return resourceResolver;
    }

    protected List<MigrationResultResource> getMigratedResources() {
        return migratedResources;
    }
}