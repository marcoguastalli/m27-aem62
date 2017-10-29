package net.marco27.aem6.components.osgi;

import static net.marco27.aem6.components.osgi.HelloOsgiServletWithProperties.PROPERTY_NAME;
import static net.marco27.aem6.components.osgi.HelloOsgiServletWithProperties.PROPERTY_SURNAME;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Dictionary;

import javax.servlet.ServletException;

import org.apache.felix.scr.annotations.Activate;
import org.apache.felix.scr.annotations.Properties;
import org.apache.felix.scr.annotations.Reference;
import org.apache.felix.scr.annotations.sling.SlingServlet;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.apache.sling.commons.osgi.PropertiesUtil;
import org.osgi.framework.BundleContext;
import org.osgi.service.component.ComponentContext;

/**
 * http://localhost:6200/bin/helloosgiservletprop
 */
@SlingServlet(paths = "/bin/helloosgiservletprop", methods = "GET", extensions = "json", metatype = true)
@Properties({ @org.apache.felix.scr.annotations.Property(name = PROPERTY_NAME, description = "Insert your name", value = "Marco"),
        @org.apache.felix.scr.annotations.Property(name = PROPERTY_SURNAME, description = "Insert your surname", value = " Guastalli") })
public class HelloOsgiServletWithProperties extends SlingSafeMethodsServlet {

    protected static final String PROPERTY_NAME = "name";
    protected static final String PROPERTY_SURNAME = "surname";

    @Reference
    private HelloOsgiService helloOsgiService;

    private String nameSurname;

    @Activate
    protected void activate(BundleContext bundleContext, ComponentContext componentContext) {
        Dictionary<?, ?> properties = componentContext.getProperties();
        nameSurname =
                PropertiesUtil.toString(properties.get(PROPERTY_NAME), "") + PropertiesUtil.toString(properties.get(PROPERTY_SURNAME), "");
    }

    @Override
    public void doGet(final SlingHttpServletRequest request, final SlingHttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        out.print(helloOsgiService.helloOsgi(nameSurname));
    }

}
