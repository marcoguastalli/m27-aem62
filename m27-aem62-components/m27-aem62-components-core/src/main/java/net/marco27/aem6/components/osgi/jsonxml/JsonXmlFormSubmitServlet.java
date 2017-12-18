package net.marco27.aem6.components.osgi.jsonxml;

import java.io.IOException;

import javax.annotation.Nonnull;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.felix.scr.annotations.sling.SlingServlet;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.resource.ModifiableValueMap;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;

@SlingServlet(paths = "/bin/m27/jsonxml", methods = "POST")
public class JsonXmlFormSubmitServlet extends SlingAllMethodsServlet {

    private static final String PROPERTY_TEXT_JSON_XML = "textJsonXMl";

    protected void doPost(@Nonnull SlingHttpServletRequest request, @Nonnull SlingHttpServletResponse response) throws ServletException,
            IOException {

        Resource resourceServlet = request.getResource();
        String path = request.getParameter("path");
        String textJsonXMl = request.getParameter(PROPERTY_TEXT_JSON_XML);

        ResourceResolver resourceResolver = request.getResourceResolver();
        Resource resource = resourceResolver.getResource(path+ "/jcr:content/par/jsonxml");
        ModifiableValueMap modifiableValueMap = resource.adaptTo(ModifiableValueMap.class);
        modifiableValueMap.put(PROPERTY_TEXT_JSON_XML, textJsonXMl);
        resourceResolver.commit();

        //forward(request, response, "/content/m27/jsonxml/jcr%3Acontent/par/jsonxml");
        redirect(response, path);
    }

    protected void forward(HttpServletRequest request, HttpServletResponse response, String pathToForwardTo)
            throws IOException, ServletException {
        getServletContext().getRequestDispatcher(pathToForwardTo).forward(request, response);
    }

    protected void redirect(HttpServletResponse response, String pathToRedirectTo) throws IOException {
        String encodeUrl = response.encodeRedirectURL(pathToRedirectTo)  + ".html";
        response.sendRedirect(encodeUrl);
    }
}
