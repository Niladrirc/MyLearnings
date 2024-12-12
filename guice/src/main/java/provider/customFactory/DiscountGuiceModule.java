package provider.customFactory;

import com.google.inject.AbstractModule;
import com.google.inject.multibindings.MapBinder;

public class DiscountGuiceModule extends AbstractModule {

    @Override
    protected void configure() {
        MapBinder<DiscountOption, Discountable> mapBinder = MapBinder.newMapBinder(
                binder(),
                DiscountOption.class,
                Discountable.class
        );
        mapBinder.addBinding(DiscountOption.EARLY_BIRD).to(EarlyBirdDiscount.class);
        mapBinder.addBinding(DiscountOption.NIGHT_OWL).to(NightOwlDiscount.class);
        mapBinder.addBinding(DiscountOption.NO_DISCOUNT).to(NoDiscount.class);
    }
}
