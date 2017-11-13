package net.marco27.aem6.components.par.textimage;

import javax.inject.Inject;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

@Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class TextImageComponent {

    @ValueMapValue
    private String text;

    @ValueMapValue
    private String richText;

    @Inject
    private Image image;

    public String getText() {
        return text;
    }

    public String getRichText() {
        return richText;
    }

    public Image getImage() {
        return image;
    }
}
