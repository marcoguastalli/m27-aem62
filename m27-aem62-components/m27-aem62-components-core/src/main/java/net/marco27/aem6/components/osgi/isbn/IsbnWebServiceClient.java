package net.marco27.aem6.components.osgi.isbn;

import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Service;

/**
 * http://isbndb.com/api/v2/docs
 */
@Component
@Service(value = IsbnWebServiceClient.class)
public class IsbnWebServiceClient {

    public String getBook(final String apiKey, final String bookIsbnCode) {
        return "TODO CALL TO http://isbndb.com/api/v2/docs/books";
    }
}
