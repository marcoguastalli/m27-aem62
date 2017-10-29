package net.marco27.aem6.components.osgi;

import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Service;

@Component
@Service(value = HelloOsgiService.class)
public class HelloOsgiServiceImpl implements HelloOsgiService {

    @Override
    public String helloOsgi(final String name) {
        return "Hello " + name;
    }
}
