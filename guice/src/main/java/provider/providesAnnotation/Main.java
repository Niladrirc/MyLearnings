package provider.providesAnnotation;

import com.google.inject.Guice;
import com.google.inject.Injector;
import provider.providesAnnotation.guice.DiscountModule;

public class Main {
    public static void main(String[] args) {
        Injector injector = Guice.createInjector(new DiscountModule());
        CheckoutService service = injector.getInstance(CheckoutService.class);
        service.checkout(100.00D);
    }
}
