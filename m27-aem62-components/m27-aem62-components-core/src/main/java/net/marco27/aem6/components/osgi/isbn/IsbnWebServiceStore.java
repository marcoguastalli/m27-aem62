package net.marco27.aem6.components.osgi.isbn;

import java.util.HashMap;
import java.util.Map;

import org.apache.felix.scr.annotations.Activate;
import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Service;
import org.osgi.framework.BundleContext;
import org.osgi.service.component.ComponentContext;

@Component
@Service(value = IsbnWebServiceStore.class)
public class IsbnWebServiceStore {

    private Map<String, String> isbnBooks;

    @Activate
    protected void activate(BundleContext bundleContext, ComponentContext componentContext) {
        this.isbnBooks = new HashMap<>();
    }

    public Map<String, String> getIsbnBooks() {
        return isbnBooks;
    }

    public void addIsbnBook(final String bookIsbnCode, final String xml) {
        isbnBooks.put(bookIsbnCode, xml);
    }
}
