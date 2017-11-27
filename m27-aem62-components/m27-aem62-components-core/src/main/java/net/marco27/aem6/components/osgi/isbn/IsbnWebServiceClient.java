package net.marco27.aem6.components.osgi.isbn;

import java.io.IOException;

import org.apache.felix.scr.annotations.Activate;
import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Reference;
import org.apache.felix.scr.annotations.Service;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.osgi.framework.BundleContext;
import org.osgi.service.component.ComponentContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * http://isbndb.com/api/v2/docs
 * <p>
 * http://www.isbndb.com/api/books.xml
 * http://www.isbndb.com/api/books.xml?access_key=ZA7KWZ3X&index1=isbn&value1=0061031321
 * <p>
 * https://github.com/IvoNet/isbndb
 */
@Component(immediate = true)
@Service
public class IsbnWebServiceClient implements IsbnWebService {

    private static final Logger LOG = LoggerFactory.getLogger(IsbnWebServiceClient.class);

    @Reference
    private IsbnWebServiceStore isbnWebServiceStore;

    @Reference
    private IsbnWebServiceConfiguration isbnWebServiceConfiguration;

    private String apiKey;

    @Activate
    protected void activate(BundleContext bundleContext, ComponentContext componentContext) {
        apiKey = isbnWebServiceConfiguration.getApiKey();
    }

    @Override
    public String getBook(final String bookIsbnCode) {
        //String uri = String.format("http://isbndb.com/api/books.xml?access_key=%s&index1=isbn&value1=0061031321", apiKey);
        String uri = String.format("http://isbndb.com/api/books.xml?access_key=%s&index1=isbn&value1=%s", apiKey, bookIsbnCode);
        String xml = callApi(uri);
        isbnWebServiceStore.addIsbnBook(bookIsbnCode, xml);
        return xml;
    }

    private String callApi(final String uri) {
        String result = null;
        CloseableHttpClient httpclient = HttpClients.createDefault();
        try {
            HttpGet httpGet = new HttpGet(uri);
            httpGet.addHeader("Accept", "application/json");
            HttpResponse response = httpclient.execute(httpGet);
            if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                result = EntityUtils.toString(response.getEntity(), "UTF-8");
            }
        } catch (Exception e) {
            LOG.error("Error callApi", e);
            result = e.getLocalizedMessage();
        } finally {
            try {
                httpclient.close();
            } catch (IOException e) {
                LOG.error("Error closing HttpClient", e);
            }
        }
        return result;
    }
}
