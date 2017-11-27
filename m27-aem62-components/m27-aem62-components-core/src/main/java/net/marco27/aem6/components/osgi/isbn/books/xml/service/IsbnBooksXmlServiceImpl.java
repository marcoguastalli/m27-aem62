package net.marco27.aem6.components.osgi.isbn.books.xml.service;

import java.io.StringReader;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.marco27.aem6.components.osgi.isbn.books.xml.model.ISBNdb;

@Component
@Service(value = IsbnBooksXmlService.class)
public class IsbnBooksXmlServiceImpl implements IsbnBooksXmlService {

    private static final Logger LOG = LoggerFactory.getLogger(IsbnBooksXmlServiceImpl.class);

    @Override
    public ISBNdb getISBNdbFromIsbnWebServiceResult(final String xml) {
        ISBNdb result = null;
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(ISBNdb.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            result = (ISBNdb) jaxbUnmarshaller.unmarshal(new StringReader(xml));
        } catch (JAXBException e) {
            LOG.error("Error parsing xml", e);
        }
        return result;
    }
}
