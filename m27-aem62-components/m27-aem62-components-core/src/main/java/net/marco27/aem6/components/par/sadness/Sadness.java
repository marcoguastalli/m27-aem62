package net.marco27.aem6.components.par.sadness;

import javax.annotation.PostConstruct;

import org.apache.commons.lang3.StringUtils;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.Self;

@Model(adaptables = SlingHttpServletRequest.class)
public class Sadness {

    private static final String REQ_PARM_SADNESS = "sadness";

    @Self
    private SlingHttpServletRequest request;

    private String sadness;

    @PostConstruct
    public void init() {
        sadness = StringUtils.defaultString(request.getParameter(REQ_PARM_SADNESS), "");
    }

    public String getSadness() {
        return sadness;
    }
}
