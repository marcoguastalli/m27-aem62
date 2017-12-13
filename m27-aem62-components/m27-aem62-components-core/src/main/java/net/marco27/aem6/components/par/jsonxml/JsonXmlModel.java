package net.marco27.aem6.components.par.jsonxml;

import javax.annotation.PostConstruct;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.OSGiService;
import org.apache.sling.models.annotations.injectorspecific.Self;

import net.marco27.aem6.components.osgi.jsonxml.JsonXmlService;

@Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.REQUIRED)
public class JsonXmlModel {

    @OSGiService
    private JsonXmlService jsonXmlService;

    @Self
    private Resource resource;

    private String path;

    @PostConstruct
    public void init() {
        path = resource.getPath();
    }

    public String getPath() {
        return path;
    }
}
