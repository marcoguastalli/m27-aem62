package net.marco27.aem6.components.osgi.jsonxml;

import org.apache.felix.scr.annotations.Reference;

import net.marco27.aem6.components.osgi.jsonxml.store.JsonXmlStore;

public interface JsonXmlService {

    public void storeJsonXml(final String jsonxml, final String path, final String jcrTitle, final String jcrDescription);
}
