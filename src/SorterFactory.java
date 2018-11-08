import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * A classic factory for producing concrete sorter objects implemented as a singleton.
 */
public final class SorterFactory {

    private static final Map<String, AbstractSorter> sorters = new HashMap<>();

    // Singleton implementation
    private SorterFactory() {}
    private static final SorterFactory instance = new SorterFactory();
    public static SorterFactory getInstance() {
        return instance;
    }

    AbstractSorter getObject(String name) {
        return sorters.get(name);
    }

    Collection<AbstractSorter> getAllObjects() {
        return sorters.values();
    }

    void register(AbstractSorter sorter) {
        sorters.put(sorter.name(), sorter);
    }

    void unRegister(AbstractSorter sorter) {
        sorters.remove(sorter.name(), sorter);
    }
}
