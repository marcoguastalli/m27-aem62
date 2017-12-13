package net.marco27.aem6.components.osgi.jsonxml.store;

import javax.jcr.Node;

import net.marco27.aem6.components.osgi.jsonxml.exception.JsonXmlException;

/**
 * OSGi Service used to persist in a Node a Json|XML Object
 */
public interface JsonXmlStore {

    public void storeJsonXml(final Node node, final String jsonxml, final String jcrTitle, final String jcrDescription)
            throws JsonXmlException;

    public String readJsonXml(final Node node) throws JsonXmlException;
}
