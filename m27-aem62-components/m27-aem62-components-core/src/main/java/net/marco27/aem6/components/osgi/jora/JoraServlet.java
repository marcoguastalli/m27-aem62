package net.marco27.aem6.components.osgi.jora;

import java.io.IOException;
import java.util.Dictionary;

import javax.annotation.Nonnull;
import javax.servlet.Servlet;
import javax.servlet.ServletException;

import org.apache.felix.scr.annotations.Activate;
import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Properties;
import org.apache.felix.scr.annotations.Property;
import org.apache.felix.scr.annotations.Reference;
import org.apache.felix.scr.annotations.Service;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.osgi.service.component.ComponentContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service(Servlet.class)
@Component(metatype = false)
@Properties(value = { @Property(name = "sling.servlet.resourceTypes", value = "sling/servlet/default"),
        @Property(name = "sling.servlet.selectors", value = { JoraServlet.SELECTOR_JORA }),
        @Property(name = "sling.servlet.extensions", value = { "html" }),
        @Property(name = "sling.servlet.methods", value = { "GET"}) })
public class JoraServlet extends SlingSafeMethodsServlet {

    private static final Logger LOG = LoggerFactory.getLogger(JoraServlet.class);
    public static final String SELECTOR_JORA = "jora";

    @Reference
    private JoraService joraService;

    @Activate
    public void activate(final ComponentContext componentContext) {
        final Dictionary<?, ?> properties = componentContext.getProperties();
        String selectors = (String) properties.get("sling.servlet.selectors");
        LOG.info("JoraServlet selector: " + selectors);
    }

    @Override
    protected void doGet(@Nonnull SlingHttpServletRequest request, @Nonnull SlingHttpServletResponse response) throws ServletException,
            IOException {
        LOG.debug("Jora: " + joraService.getJora());
        response.getWriter().print(joraService.getJora());
    }

}
