package net.marco27.aem6.components.osgi.isbn;

import java.io.IOException;

import javax.annotation.Nonnull;
import javax.servlet.ServletException;

import org.apache.felix.scr.annotations.Reference;
import org.apache.felix.scr.annotations.sling.SlingServlet;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;

import net.marco27.aem6.components.osgi.isbn.books.xml.model.ISBNdb;
import net.marco27.aem6.components.osgi.isbn.books.xml.service.IsbnBooksXmlService;

@SlingServlet(methods = "GET", paths = "/bin/m27/getIsbnBook")
public class IsbnWebServiceServlet extends SlingAllMethodsServlet {

    private static final String REQ_PARM_MAPPED_URI = "mappedUri";
    private static final String REQ_PARM_ISBN_CODE = "isbnCode";

    @Reference
    private IsbnWebService isbnWebService;

    @Reference
    private IsbnBooksXmlService isbnBooksXmlService;

    @Override
    protected void doGet(@Nonnull SlingHttpServletRequest request, @Nonnull SlingHttpServletResponse response) throws ServletException,
            IOException {
        String mappedUri = request.getParameter(REQ_PARM_MAPPED_URI);
        String isbnCode = request.getParameter(REQ_PARM_ISBN_CODE);

        //TODO add input Validation
        final String xml = isbnWebService.getBookXml(isbnCode);

        ISBNdb isbNdb = isbnBooksXmlService.getISBNdbFromIsbnWebServiceResult(xml);

        //TODO add xml/isbNdb validation
        response.getWriter().print(xml);

    }

}
