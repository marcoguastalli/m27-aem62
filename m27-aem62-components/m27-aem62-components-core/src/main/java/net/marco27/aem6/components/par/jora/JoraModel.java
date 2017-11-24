package net.marco27.aem6.components.par.jora;

import javax.annotation.PostConstruct;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Default;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.OSGiService;
import org.apache.sling.models.annotations.injectorspecific.Self;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

import net.marco27.aem6.components.osgi.jora.JoraService;

@Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.REQUIRED)
public class JoraModel {

    @OSGiService
    private JoraService joraService;

    @Default(values = "yyyy-MM-dd HH:mm:ss")
    @ValueMapValue(optional = false)
    private String dateTimeFormatterPattern;

    @Self
    private Resource resource;

    /**
     * jora means in wrong-spanish hora, time in english
     */
    private String joraFormatted;

    @PostConstruct
    public void init() {
        joraFormatted = joraService.getJora(dateTimeFormatterPattern);
    }

    public String getDateTimeFormatterPattern() {
        return dateTimeFormatterPattern;
    }

    public String getJoraFormatted() {
        return joraFormatted;
    }
}
