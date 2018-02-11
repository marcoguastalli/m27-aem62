package net.marco27.aem6.components.workflow.metadata;

import java.util.Iterator;

import javax.jcr.Node;
import javax.jcr.RepositoryException;
import javax.jcr.Session;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolverFactory;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.day.cq.commons.jcr.JcrConstants;
import com.day.cq.dam.api.Asset;
import com.day.cq.dam.commons.process.AbstractAssetWorkflowProcess;
import com.day.cq.dam.commons.util.DamUtil;
import com.day.cq.workflow.WorkflowException;
import com.day.cq.workflow.WorkflowSession;
import com.day.cq.workflow.exec.WorkItem;
import com.day.cq.workflow.exec.WorkflowProcess;
import com.day.cq.workflow.metadata.MetaDataMap;

@Component(service = WorkflowProcess.class, immediate = true, name = "Add Alt Text To Asset",
        property = "process.label=Add Alt Text Property To Asset")
public class AddAltTextToAsset extends AbstractAssetWorkflowProcess {

    private static final Logger log = LoggerFactory.getLogger(AddAltTextToAsset.class);

    @Reference
    private ResourceResolverFactory resourceResolverFactory;

    public void execute(WorkItem workItem, WorkflowSession workflowSession, MetaDataMap metaData) throws WorkflowException {
        try {
            final Session e = workflowSession.getSession();
            final Resource resource = this.getPayloadResource(workItem, e);
            if (null != resource) {
                if (DamUtil.isAsset(resource)) {
                    final Asset asset = DamUtil.resolveToAsset(resource);
                    this.addAltText(asset);
                }
                final Iterator assetList = DamUtil.getAssets(resource);
                while (assetList.hasNext()) {
                    final Asset asset = (Asset) assetList.next();
                    this.addAltText(asset);
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

    private boolean addAltText(Asset asset) throws RepositoryException {
        final Resource res = asset.adaptTo(Resource.class);
        final Resource metadata = res.getChild(JcrConstants.JCR_CONTENT + "/metadata");
        if (metadata != null) {
            final Node metadataNode = metadata.adaptTo(Node.class);
            if (metadataNode != null) {
                metadataNode.setProperty("dam:alttext", asset.getName());
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
}