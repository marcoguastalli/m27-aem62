package net.marco27.aem6.components.par.isbn;

import java.util.Map;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.OSGiService;
import org.apache.sling.models.annotations.injectorspecific.ScriptVariable;
import org.apache.sling.models.annotations.injectorspecific.Self;

import com.day.cq.wcm.api.Page;

import net.marco27.aem6.components.osgi.isbn.IsbnWebService;
import net.marco27.aem6.components.osgi.isbn.IsbnWebServiceStore;

@Model(adaptables = { SlingHttpServletRequest.class })
public class IsbnModel {

    @Self
    private SlingHttpServletRequest request;

    @OSGiService
    private IsbnWebService isbnWebService;

    @Inject
    private IsbnWebServiceStore isbnWebServiceStore;

    @ScriptVariable
    private Page currentPage;

    private String mappedUri;

    @PostConstruct
    public void init() {
        this.mappedUri = this.request.getResourceResolver().map(currentPage.getPath());
    }

    public String getMappedUri() {
        return mappedUri;
    }

    public Map<String, String> getIsbnBooks() {
        return isbnWebServiceStore.getIsbnBooks();
    }

}
