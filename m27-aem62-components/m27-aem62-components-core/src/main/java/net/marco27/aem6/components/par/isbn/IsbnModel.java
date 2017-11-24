package net.marco27.aem6.components.par.isbn;

import javax.annotation.PostConstruct;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.OSGiService;

import net.marco27.aem6.components.osgi.isbn.IsbnWebServiceClient;

@Model(adaptables = { SlingHttpServletRequest.class })
public class IsbnModel {

    @OSGiService
    private IsbnWebServiceClient isbnWebServiceClient;

    private String apiKey;

    @PostConstruct
    public void init() {
        apiKey = "TODO WITH CONFIG CLASS";
    }

    public String getIsbnBook() {
        return isbnWebServiceClient.getBook(apiKey, "TODO");
    }

    public String getIsbnBook(final String bookIsbnCode) {
        return isbnWebServiceClient.getBook(apiKey, bookIsbnCode);
    }
}
