package discount_example.provider.diIntoProvider.guice;

import com.google.inject.AbstractModule;
import com.google.inject.multibindings.MapBinder;
import discount_example.provider.diIntoProvider.Discountable;
import discount_example.provider.diIntoProvider.impl.BigDiscount;
import discount_example.provider.diIntoProvider.impl.NoDiscount;
import discount_example.provider.diIntoProvider.impl.SmallDiscount;

public class DiscountGuiceModule extends AbstractModule {

    @Override
    protected void configure() {
        // MapBinder -> it is a way for Guice to house the different types of implementation without you having to write your own map
        // it maps the key (here an integer) to one of the implementation of Discountable
        MapBinder<Integer, Discountable> mapBinder = MapBinder.newMapBinder(
                binder(), // -> this automatically binds the mapBinder to a map if you want to get it injected automatically without explicit binding
                Integer.class,
                Discountable.class
        );

        mapBinder.addBinding(0).to(NoDiscount.class);
        mapBinder.addBinding(1).to(SmallDiscount.class);
        mapBinder.addBinding(2).to(BigDiscount.class);
    }
}
