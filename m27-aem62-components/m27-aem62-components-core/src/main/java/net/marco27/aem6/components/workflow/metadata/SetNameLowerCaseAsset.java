package net.marco27.aem6.components.workflow.metadata;

import javax.jcr.Session;
import javax.jcr.Workspace;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolverFactory;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.day.cq.commons.jcr.JcrConstants;
import com.day.cq.dam.commons.process.AbstractAssetWorkflowProcess;
import com.day.cq.dam.commons.util.DamUtil;
import com.day.cq.workflow.WorkflowException;
import com.day.cq.workflow.WorkflowSession;
import com.day.cq.workflow.exec.WorkItem;
import com.day.cq.workflow.exec.WorkflowProcess;
import com.day.cq.workflow.metadata.MetaDataMap;

@Component(service = WorkflowProcess.class, immediate = true, name = "SetNameLowerCaseAsset",
        property = "process.label=Save Asset With LowerCase")
public class SetNameLowerCaseAsset extends AbstractAssetWorkflowProcess {

    private static final Logger log = LoggerFactory.getLogger(SetNameLowerCaseAsset.class);

    @Reference
    private ResourceResolverFactory resourceResolverFactory;

    public void execute(WorkItem workItem, WorkflowSession workflowSession, MetaDataMap metaData) throws WorkflowException {
        try {
            final Session e = workflowSession.getSession();
            final Resource resource = this.getPayloadResource(workItem, e);
            if (null != resource) {
                if (DamUtil.isAsset(resource)) {
                    final String assetPath = resource.getPath().substring(0, resource.getPath().lastIndexOf("/"));
                    final String assetNameLowerCase = resource.getName().toLowerCase();

                    final Session session = resourceResolverFactory.getThreadResourceResolver().adaptTo(Session.class);
                    if (session != null) {
                        final Workspace workspace = session.getWorkspace();
                        workspace.copy(resource.getPath(), assetPath + "/" + assetNameLowerCase);
                    }
                    resourceResolverFactory.getThreadResourceResolver().delete(resource);
                    resourceResolverFactory.getThreadResourceResolver().commit();
                }
                e.save();
            } else {
                log.error("Content root could not be resolved");
            }
        } catch (Exception var9) {
            log.warn("unexpected error occurred during adding Property. Cause: {}", var9.getMessage(), var9);
        }
    }

    private Resource getPayloadResource(WorkItem item, Session session) {
        if (item.getWorkflowData().getPayloadType().equals("JCR_PATH")) {
            final String path = item.getWorkflowData().getPayload().toString();
            final String assetPath = path.substring(0, path.indexOf("/" + JcrConstants.JCR_CONTENT));
            return resourceResolverFactory.getThreadResourceResolver().getResource(assetPath);
        }
        return null;
    }
}