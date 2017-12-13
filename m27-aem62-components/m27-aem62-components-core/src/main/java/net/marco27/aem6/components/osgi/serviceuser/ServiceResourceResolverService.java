package net.marco27.aem6.components.osgi.serviceuser;

import org.apache.sling.api.resource.LoginException;
import org.apache.sling.api.resource.ResourceResolver;

/**
 * Returns service resource resolvers.
 */
@FunctionalInterface
public interface ServiceResourceResolverService {

    /**
     * Returns the resource resolver for the given resolver type.
     *
     * @param type resolver type
     * @return resource resolver
     * @throws LoginException error getting resource resolver
     */
    ResourceResolver getServiceResourceResolver(final ResolverType type) throws LoginException;

}
