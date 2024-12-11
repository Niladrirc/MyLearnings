package provider.diIntoProvider;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;

public class DiscountApplication {
    private final CheckoutService service;

    @Inject
    public DiscountApplication(CheckoutService service) {
        this.service = service;
    } 

    public static void main(String[] args) {
        // the main() should do 3 things:
        // 1. Inject the masterFactory (Guice in this case) -> This creates the object graph of all the factories.
        // 2. Create a separate object graph by instantiating the application -> this object graphs contains the business and application logic
        // 3. Start the application
        Injector injector = Guice.createInjector();
        DiscountApplication application = injector.getInstance(DiscountApplication.class);
        application.run();
    }

    private void run() {
        service.checkout(100.00D);
    }
}
