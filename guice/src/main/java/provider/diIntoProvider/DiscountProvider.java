package provider.diIntoProvider;

import com.google.inject.Inject;
import com.google.inject.Provider;

import java.util.Map;
import java.util.Random;

public class DiscountProvider implements Provider<Discountable> {
    private final Random random;
    private final Map<Integer, Discountable> mapBinder;

    @Inject
    public DiscountProvider(Map<Integer, Discountable> mapBinder, Random random) {
        // The map contains all the implementations & it facilitates the Factory get method
        this.random = random;
        this.mapBinder = mapBinder;
    }

    @Override
    public Discountable get() {
        return mapBinder.get(random.nextInt(mapBinder.size()));
    }
}
