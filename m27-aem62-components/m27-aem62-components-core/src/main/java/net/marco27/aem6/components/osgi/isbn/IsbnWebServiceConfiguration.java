package net.marco27.aem6.components.osgi.isbn;

import java.util.Dictionary;

import org.apache.felix.scr.annotations.Activate;
import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Property;
import org.apache.felix.scr.annotations.Reference;
import org.apache.sling.commons.osgi.PropertiesUtil;
import org.osgi.framework.BundleContext;
import org.osgi.service.component.ComponentContext;

@Component(metatype = true)
@Property(name = IsbnWebServiceConfiguration.PROPERTY_API_KEY, value = { IsbnWebServiceConfiguration.PROPERTY_API_KEY_DEFAULT_VALUE })
public class IsbnWebServiceConfiguration {

    public static final String PROPERTY_API_KEY = "apiKey";
    public static final String PROPERTY_API_KEY_DEFAULT_VALUE = "";

    public String apiKey;

    @Reference
    private IsbnWebServiceClient isbnWebServiceClient;

    @Activate
    protected void activate(BundleContext bundleContext, ComponentContext componentContext) {
        Dictionary<?, ?> properties = componentContext.getProperties();
        this.apiKey = PropertiesUtil.toString(properties.get(PROPERTY_API_KEY), PROPERTY_API_KEY_DEFAULT_VALUE);
    }
}
