package net.marco27.aem6.components.osgi.isbn.books.xml.service;

import net.marco27.aem6.components.osgi.isbn.books.xml.model.ISBNdb;

public interface IsbnBooksXmlService {

    ISBNdb getISBNdbFromIsbnWebServiceResult(String xml);
}
