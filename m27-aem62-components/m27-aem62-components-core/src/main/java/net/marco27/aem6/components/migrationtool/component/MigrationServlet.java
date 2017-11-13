package net.marco27.aem6.components.migrationtool.component;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;

import org.apache.commons.lang3.StringUtils;
import org.apache.felix.scr.annotations.Reference;
import org.apache.felix.scr.annotations.sling.SlingServlet;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.marco27.aem6.components.migrationtool.Migration;
import net.marco27.aem6.components.migrationtool.config.MigrationConfiguration;
import net.marco27.aem6.components.migrationtool.model.MigrationResult;
import net.marco27.aem6.components.migrationtool.model.MigrationResultPath;
import net.marco27.aem6.components.migrationtool.model.MigrationResultResource;
import net.marco27.aem6.components.migrationtool.model.MigrationStatus;

/**
 * Migration Bundle Component Servlet
 */
@SlingServlet(methods = { "GET" }, paths = { "/bin/m27/migration" })
public class MigrationServlet extends SlingAllMethodsServlet {

    private static final Logger LOG = LoggerFactory.getLogger(MigrationServlet.class);

    private static final String MIGRATION_PARAMETER_NAME = "migrationToDo";
    private static final String DRY_RUN_PARAMETER = "dryRun";
    private static final String PATHS_PARAMETER_NAME = "paths";
    private static final String NEW_LINE = "\n";
    private static final String CHECKED = "true";
    private static final String USER_ADMIN = "admin";

    @Reference
    private MigrationConfiguration migrationConfiguration;

    @Override
    protected void doGet(final SlingHttpServletRequest request, final SlingHttpServletResponse response)
            throws ServletException, IOException {

        if (this.isValidUser(request)) {
            Migration migration = migrationConfiguration.getMigration(request.getParameter(MIGRATION_PARAMETER_NAME));
            String[] paths = getMigrationPaths(request);

            // To set the dryRun or the execution mode
            boolean dryRunParam = CHECKED.equals(request.getParameter(DRY_RUN_PARAMETER));

            MigrationResult migrationResult;
            if (paths == null) {
                migrationResult = migration.migrate(dryRunParam);
            } else {
                migrationResult = migration.migrate(paths, dryRunParam);
            }
            writeResponse(response, migrationResult);
        }
    }

    protected boolean isValidUser(SlingHttpServletRequest request) {
        if (USER_ADMIN.equals(request.getUserPrincipal().getName())) {
            return true;
        } else {
            LOG.warn("Security breach: User [{}] tried to call this servlet.", request.getUserPrincipal().getName());
            return false;
        }
    }

    private String[] getMigrationPaths(final SlingHttpServletRequest request) {
        String textArea = request.getParameter(PATHS_PARAMETER_NAME);
        String[] paths = null;
        if (StringUtils.isNotBlank(textArea)) {
            paths = textArea.split(NEW_LINE);
        }
        return paths;
    }

    private void writeResponse(final SlingHttpServletResponse response, final MigrationResult migrationResult) {
        try {
            PrintWriter out = response.getWriter();
            out.print("<div class='dataResponse'>");

            for (MigrationResultPath migrationResultPath : migrationResult.getPathResults()) {
                out.print("<div class='dataResponse__path'><div class='dataResponse__path__text'><p>Migrating path: "
                        + migrationResultPath.getPath() + "</p></div>");
                for (MigrationResultResource resource : migrationResultPath.getResources()) {
                    out.print("<div class='dataResponse__path__text'><p>" + resource.getName() + "</p></div>");
                    out.println(formatMigrationStatus(resource.getMigrationStatus()));
                }
                out.print("<div class='dataResponse__path'>"
                        + formatMigrationStatus(migrationResultPath.getMigrationStatus()) + "</div>");
                out.print("</div>");
            }
            out.print("</div><div class='dataResponse__end'>PROCESS ENDED </div>");
        } catch (IOException e) {
            LOG.debug("Error getting the writer for the response");
        }
    }

    private String formatMigrationStatus(final MigrationStatus migrationStatus) {
        String cssStatus = migrationStatus == MigrationStatus.EXCEPTION ? "error" : "done";
        return "<span class='" + cssStatus + "' >" + migrationStatus.name() + "</span>";
    }
}