package net.marco27.aem6.components.osgi.jsonxml.store;

import java.io.IOException;
import java.io.InputStream;

import javax.jcr.Binary;
import javax.jcr.Node;
import javax.jcr.RepositoryException;
import javax.jcr.Value;
import javax.jcr.ValueFactory;

import org.apache.commons.io.IOUtils;
import org.apache.felix.scr.annotations.Service;
import org.apache.jackrabbit.value.ValueFactoryImpl;
import org.osgi.service.component.annotations.Component;

import net.marco27.aem6.components.osgi.jsonxml.exception.JsonXmlException;

@Component
@Service
public class JsonXmlStoreImpl implements JsonXmlStore {

    private static final String ENCODING = "UTF-8";
    private static final String JCR_CONTENT = "jcr:content";
    private static final String JCR_DATA = "jcr:data";
    private static final String JCR_DESCRIPTION = "jcr:description";
    private static final String JCR_TITLE = "jcr:title";

    @Override
    public void storeJsonXml(final Node node, final String jsonxml, final String jcrTitle, final String jcrDescription)
            throws JsonXmlException {
        try {
            final ValueFactory valueFactory = ValueFactoryImpl.getInstance();
            InputStream inputStream = IOUtils.toInputStream(jsonxml, ENCODING);
            Binary binary = valueFactory.createBinary(inputStream);
            Value value = valueFactory.createValue(binary);
            node.setProperty(JCR_DATA, value);
            node.setProperty(JCR_TITLE, jcrTitle);
            node.setProperty(JCR_DESCRIPTION, jcrDescription);
        } catch (IOException | RepositoryException e) {
            throw new JsonXmlException("Error store JsonXml with title: " + jcrTitle, e);
        }
    }

    @Override
    public String readJsonXml(final Node node) throws JsonXmlException {
        String nodeName = "";
        try {
            nodeName = node.getName();
            Node jcrContent = node.getNode(JCR_CONTENT);
            InputStream content = jcrContent.getProperty(JCR_DATA).getBinary().getStream();
            return IOUtils.toString(content, ENCODING);
        } catch (IOException | RepositoryException e) {
            throw new JsonXmlException("Error reaf JsonXml from node " + nodeName, e);
        }
    }
}
