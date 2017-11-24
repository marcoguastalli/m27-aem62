package net.marco27.aem6.components.osgi.isbn;

import org.apache.felix.scr.annotations.Activate;
import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Reference;
import org.apache.felix.scr.annotations.Service;
import org.osgi.framework.BundleContext;
import org.osgi.service.component.ComponentContext;

/**
 * http://isbndb.com/api/v2/docs
 */
@Component(immediate = true)
@Service
public class IsbnWebServiceClient implements IsbnWebService {

    @Reference
    private IsbnWebServiceConfiguration isbnWebServiceConfiguration;

    private String apiKey;

    @Activate
    protected void activate(BundleContext bundleContext, ComponentContext componentContext) {
        apiKey = isbnWebServiceConfiguration.getApiKey();
    }

    @Override
    public String getBook(final String bookIsbnCode) {
        return "TODO CALL TO http://isbndb.com/api/v2/docs/books using apiKey " + apiKey;
    }
}
