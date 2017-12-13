package net.marco27.aem6.components.osgi.jsonxml;

import org.apache.felix.scr.annotations.Reference;
import org.apache.felix.scr.annotations.Service;
import org.apache.sling.api.resource.LoginException;
import org.apache.sling.api.resource.ResourceResolver;
import org.osgi.service.component.annotations.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.marco27.aem6.components.osgi.jsonxml.store.JsonXmlStore;
import net.marco27.aem6.components.osgi.serviceuser.ResolverType;
import net.marco27.aem6.components.osgi.serviceuser.ServiceResourceResolverService;

@Component
@Service
public class JsonXmlServiceImpl implements JsonXmlService {

    private static final Logger LOG = LoggerFactory.getLogger(JsonXmlServiceImpl.class);

    @Reference
    private JsonXmlStore jsonXmlStore;

    @Reference
    private ServiceResourceResolverService resourceResolverService;

    @Override
    public void storeJsonXml(final String jsonxml, final String path, final String jcrTitle, final String jcrDescription) {
        ResourceResolver resourceResolver = null;
        try {
            resourceResolver = resourceResolverService.getServiceResourceResolver(ResolverType.CONTENT_WRITE);

            //resourceResolver.getResource()
        } catch (LoginException e) {
            LOG.error("Error store JsonXml", e);
        } finally {
            if (resourceResolver != null) {
                resourceResolver.close();
            }
        }

    }
}
