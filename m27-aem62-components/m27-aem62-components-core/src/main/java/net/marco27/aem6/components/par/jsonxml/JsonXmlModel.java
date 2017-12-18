package net.marco27.aem6.components.par.jsonxml;

import javax.annotation.PostConstruct;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.Self;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

@Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.REQUIRED)
public class JsonXmlModel {

    @Self
    private Resource resource;

    private String path;

    @ValueMapValue
    private String textJsonXMl;

    @PostConstruct
    public void init() {
        path = resource.getPath();
    }

    public String getPath() {
        return path;
    }

    public String getTextJsonXMl() {
        return textJsonXMl;
    }
}
