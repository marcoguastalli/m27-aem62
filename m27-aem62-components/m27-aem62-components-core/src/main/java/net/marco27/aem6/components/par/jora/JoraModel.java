package net.marco27.aem6.components.par.jora;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Default;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.OSGiService;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

import net.marco27.aem6.components.osgi.jora.Jora;

@Model(adaptables = { Resource.class }, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class JoraModel {

    @Inject
    private Resource resource;

    /*
    @OSGiService
    private Jora joraOsgiComponent;
*/
    /**
     * jora means in wrong-spanish hora, time in english
     */
    private String jora;

    @Default(values = "yyyy-MM-dd HH:mm:ss")
    @ValueMapValue(optional = false)
    private String dateTimeFormatterPattern;

    @PostConstruct
    public void init() {
        //this.jora = joraOsgiComponent.getJora(dateTimeFormatterPattern);
        jora = "TODO";
    }

    public String getJora() {
        return jora;
    }

    public String getDateTimeFormatterPattern() {
        return dateTimeFormatterPattern;
    }
}
