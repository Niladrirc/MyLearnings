package basic;

import com.google.inject.Guice;
import com.google.inject.Injector;
import basic.guice.DiscountGuiceModule;

public class Main {
    public static void main(String[] args) {
        Injector injector = Guice.createInjector(new DiscountGuiceModule());
        CheckoutService service = injector.getInstance(CheckoutService.class);

        service.checkout(100.00D);
    }
}
