package net.marco27.aem6.components.osgi.serviceuser;

import java.util.HashMap;
import java.util.Map;

import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Reference;
import org.apache.felix.scr.annotations.Service;
import org.apache.sling.api.resource.LoginException;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ResourceResolverFactory;

/**
 * Returns service resource resolvers.
 **/
@Component
@Service
public class ServiceResourceResolverServiceImpl implements ServiceResourceResolverService {

    @Reference
    ResourceResolverFactory resourceResolverFactory;

    @Override
    public ResourceResolver getServiceResourceResolver(final ResolverType type) throws LoginException {
        return getResolver(type.getSubService());
    }

    private ResourceResolver getResolver(final String subService) throws LoginException {
        final Map<String, Object> authenticationInfo = new HashMap<>();
        authenticationInfo.put(ResourceResolverFactory.SUBSERVICE, subService);
        return resourceResolverFactory.getServiceResourceResolver(authenticationInfo);
    }

}
