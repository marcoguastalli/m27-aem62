package net.marco27.aem6.components.osgi.jsonxml;

import javax.jcr.Node;

import org.apache.felix.scr.annotations.Activate;
import org.apache.felix.scr.annotations.Reference;
import org.apache.felix.scr.annotations.Service;
import org.apache.sling.api.resource.LoginException;
import org.apache.sling.api.resource.PersistenceException;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.osgi.framework.BundleContext;
import org.osgi.service.component.ComponentContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.marco27.aem6.components.osgi.jsonxml.exception.JsonXmlException;
import net.marco27.aem6.components.osgi.jsonxml.store.JsonXmlStore;
import net.marco27.aem6.components.osgi.serviceuser.ResolverType;
import net.marco27.aem6.components.osgi.serviceuser.ServiceResourceResolverService;

@org.apache.felix.scr.annotations.Component(immediate = true)
@Service(value = JsonXmlService.class)
public class JsonXmlServiceImpl implements JsonXmlService {

    private static final Logger LOG = LoggerFactory.getLogger(JsonXmlServiceImpl.class);

    @Reference
    private JsonXmlStore jsonXmlStore;

    @Reference
    private ServiceResourceResolverService resourceResolverService;

    @Activate
    protected void activate(BundleContext bundleContext, ComponentContext componentContext) {
    }

    @Override
    public void storeJsonXml(final String jsonxml, final String path, final String jcrTitle, final String jcrDescription) {
        ResourceResolver resourceResolver = null;
        try {
            resourceResolver = resourceResolverService.getServiceResourceResolver(ResolverType.CONTENT_WRITE);
            Resource resource = resourceResolver.getResource(path);
            Node node = resource.adaptTo(Node.class);
            jsonXmlStore.storeJsonXml(node, jsonxml, jcrTitle, jcrDescription);
            resourceResolver.commit();
        } catch (LoginException e) {
            LOG.error("Error store JsonXml", e);
        } catch (JsonXmlException e) {
            LOG.error("Error store JsonXml", e);
        } catch (PersistenceException e) {
            LOG.error("Error store JsonXml", e);
        } finally {
            if (resourceResolver != null) {
                resourceResolver.close();
            }
        }

    }
}
