package net.marco27.aem6.components.migrationtool.config;

import java.util.ArrayList;
import java.util.List;

import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Reference;
import org.apache.felix.scr.annotations.ReferenceCardinality;
import org.apache.felix.scr.annotations.ReferencePolicy;
import org.apache.felix.scr.annotations.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.marco27.aem6.components.migrationtool.Migration;

/**
 * Migration Bundle Configuration This component is loaded as OSGi bundle. It loads all implementations of the
 * net.marco27.aem6.components.migrationtool.Migration interface in a List of Migration Two methods are exposed to get all the
 * implementations or a specifyc one using its name
 */
@Component
@Service({ MigrationConfiguration.class })
public class MigrationConfiguration {
    private static final Logger LOG = LoggerFactory.getLogger(MigrationConfiguration.class);

    @Reference(referenceInterface = Migration.class, cardinality = ReferenceCardinality.OPTIONAL_MULTIPLE, policy = ReferencePolicy.DYNAMIC)
    private List<Migration> implementations = new ArrayList<>();

    protected void bindImplementations(final Migration mappingService) {
        this.implementations.add(mappingService);
    }

    protected void unbindImplementations(final Migration mappingService) {
        this.implementations.remove(mappingService);
    }

    public List<Migration> getImplementations() {
        return implementations;
    }

    /**
     * Return the Migration implementation by name
     *
     * @param name of the implementation
     * @return the Migration Implementation
     */
    public Migration getMigration(final String name) {
        Migration res = null;
        if (name != null) {
            for (Migration m : implementations) {
                String migrationName = m.getMigrationName();
                if (name.equals(migrationName)) {
                    res = m;
                    break;
                }
            }
        }
        return res;
    }

}