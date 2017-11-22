package net.marco27.aem6.components.osgi.jora;

public interface JoraService {

    /**
     * Return the jora using the OSGi ConfigMgr dateTimeFormatterPattern
     *
     * @return jora as String
     */
    String getJora();

    /**
     * Return the jora using the input parameter dateTimeFormatterPattern
     *
     * @param dateTimeFormatterPattern with the value setted in the Dialog of the AEM Component
     * @return jora as String
     */
    String getJora(final String dateTimeFormatterPattern);
}
