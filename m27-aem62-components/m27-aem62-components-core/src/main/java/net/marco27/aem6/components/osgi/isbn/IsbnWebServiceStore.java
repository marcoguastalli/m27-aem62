package net.marco27.aem6.components.osgi.isbn;

import java.util.Map;

import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Service;

@Component
@Service(value = IsbnWebServiceStore.class)
public class IsbnWebServiceStore {

    private Map<String, String> isbnBooks;
}
