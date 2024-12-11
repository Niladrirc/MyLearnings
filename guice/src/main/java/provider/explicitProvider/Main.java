package provider.explicitProvider;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException {
        Injector injector = Guice.createInjector(new DiscountGuiceModule());
        CheckoutService service = injector.getInstance(CheckoutService.class);
        service.checkout(100.00D);
    }
}
