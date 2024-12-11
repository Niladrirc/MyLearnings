package discount_example.basic.guice;

import com.google.inject.AbstractModule;
import discount_example.basic.Discountable;
import discount_example.basic.impl.impl.EarlyBirdDiscount;

public class DiscountGuiceModule extends AbstractModule {

    @Override
    protected void configure() {
        // This takes preference over @ImplementedBy annotation
        bind(Discountable.class).to(EarlyBirdDiscount.class);
    }
}
