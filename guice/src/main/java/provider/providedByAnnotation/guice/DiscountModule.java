package provider.providedByAnnotation.guice;



import com.google.inject.AbstractModule;

public class DiscountModule extends AbstractModule {

    @Override
    protected void configure() {
//        bind(Discountable.class).toProvider(DiscountProvider.class);
    }
}
