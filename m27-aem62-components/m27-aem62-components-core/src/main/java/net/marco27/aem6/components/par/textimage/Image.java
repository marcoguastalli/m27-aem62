package net.marco27.aem6.components.par.textimage;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

@Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class Image {

    @ValueMapValue
    private String fileReference;

    @ValueMapValue
    private String alt;

    @ValueMapValue
    private String linkURL;

    @ValueMapValue
    private String width;

    @ValueMapValue
    private String height;

    public String getFileReference() {
        return fileReference;
    }

    public String getAlt() {
        return alt;
    }

    public String getLinkURL() {
        return linkURL;
    }

    public String getWidth() {
        return width;
    }

    public String getHeight() {
        return height;
    }
}
