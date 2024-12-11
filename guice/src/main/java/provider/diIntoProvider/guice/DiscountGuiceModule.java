package provider.diIntoProvider.guice;

import com.google.inject.AbstractModule;
import com.google.inject.multibindings.MapBinder;
import provider.diIntoProvider.DiscountProvider;
import provider.diIntoProvider.Discountable;
import provider.diIntoProvider.impl.BigDiscount;
import provider.diIntoProvider.impl.NoDiscount;
import provider.diIntoProvider.impl.SmallDiscount;

import java.util.Random;

public class DiscountGuiceModule extends AbstractModule {

    @Override
    protected void configure() {
        // MapBinder -> it is a way for Guice to house the different types of implementation without you having to write your own map
        // it maps the key (here an integer) to one of the implementation of Discountable
        MapBinder<Integer, Discountable> mapBinder = MapBinder.newMapBinder(
                binder(), // -> this automatically binds the mapBinder to a map if you want it injected automatically
                Integer.class,
                Discountable.class
        );

        mapBinder.addBinding(0).to(NoDiscount.class);
        mapBinder.addBinding(1).to(SmallDiscount.class);
        mapBinder.addBinding(2).to(BigDiscount.class);

        bind(Random.class).toInstance(new Random()); // this is automatically done for you, hence redundant

        bind(Discountable.class).toProvider(DiscountProvider.class);

    }
}
