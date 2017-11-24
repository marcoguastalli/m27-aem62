package net.marco27.aem6.components.par.isbn;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.OSGiService;
import org.apache.sling.models.annotations.injectorspecific.Self;

import net.marco27.aem6.components.osgi.isbn.IsbnWebService;
import net.marco27.aem6.components.osgi.isbn.IsbnWebServiceStore;

@Model(adaptables = { SlingHttpServletRequest.class })
public class IsbnModel {
    @Self
    private SlingHttpServletRequest slingHttpServletRequest;

    @OSGiService
    private IsbnWebService isbnWebService;

    @Inject
    private IsbnWebServiceStore isbnWebServiceStore;

    @PostConstruct
    public void init() {

    }

    public String getIsbnBook() {
        return isbnWebService.getBook("TODO");
    }

    public String getIsbnBook(final String bookIsbnCode) {
        return isbnWebService.getBook(bookIsbnCode);
    }
}
