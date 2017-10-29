package net.marco27.aem6.components.par.jora;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Default;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

@Model(adaptables = Resource.class)
public class JoraModel {

    /**
     * jora means in wrong-spanish hora, time in english
     */
    private String jora;

    @Default(values = "yyyy-MM-dd HH:mm:ss")
    @ValueMapValue(optional = false)
    private String dateTimeFormatterPattern;

    public String getJora() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(dateTimeFormatterPattern);
        jora = now.format(formatter);
        return jora;
    }

    public String getDateTimeFormatterPattern() {
        return dateTimeFormatterPattern;
    }
}
