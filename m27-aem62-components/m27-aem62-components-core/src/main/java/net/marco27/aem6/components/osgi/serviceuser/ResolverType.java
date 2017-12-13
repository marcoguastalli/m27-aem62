package net.marco27.aem6.components.osgi.serviceuser;

/**
 * Resource resolver type.
 */
public enum ResolverType {

    /**
     * sys-contentread
     */
    CONTENT_READ("contentRead"),
    /**
     * sys-contentwrite
     */
    CONTENT_WRITE("contentWrite"),
    /**
     * sys-userwrite
     */
    USER_WRITE("userWrite"),
    /**
     * sys-importer
     */
    IMPORT_USER("importUser"),
    /**
     * sys-deployer
     */
    PACKAGE_REMOVER("package-remover");

    private String subservice;

    private ResolverType(final String subService) {
        subservice = subService;
    }

    /**
     * Returns the subservice name.
     *
     * @return subservice
     */
    public String getSubService() {
        return subservice;
    }

}
