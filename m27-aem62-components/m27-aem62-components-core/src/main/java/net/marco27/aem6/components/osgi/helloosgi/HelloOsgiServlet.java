package net.marco27.aem6.components.osgi.helloosgi;

import java.io.IOException;

import javax.servlet.ServletException;

import org.apache.felix.scr.annotations.sling.SlingServlet;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SlingServlet(paths = "/bin/helloosgiservlet", methods = "GET", extensions = "json")
//@SlingServlet(resourceTypes = "sling/servlet/default", methods = "GET", extensions = "json")
//@SlingServlet(resourceTypes = "m27/website/osgi/helloservlet", methods = "GET", extensions = "txt")
public class HelloOsgiServlet extends SlingSafeMethodsServlet {

	private static final Logger LOG = LoggerFactory.getLogger(HelloOsgiServlet.class);

	/**
	 * http://localhost:6200/system/console/servletresolver <br/>
	 * http://localhost:6200/bin/helloosgiservlet <br/>
	 * http://localhost:6200/libs/m27/website/osgi/helloservlet/html.GET.servlet
	 */
	@Override
	protected void doGet(final SlingHttpServletRequest request, final SlingHttpServletResponse response) throws ServletException, IOException {
		final Resource resource = request.getResource();
		response.setContentType("text/plain");
		response.getWriter().write("resource = " + resource.getPath());
	}
}
