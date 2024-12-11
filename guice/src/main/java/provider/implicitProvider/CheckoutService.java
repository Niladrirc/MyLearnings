package provider.implicitProvider;

import com.google.inject.Inject;
import com.google.inject.Provider;
import lombok.extern.slf4j.Slf4j;



@Slf4j
public class CheckoutService {
    private final Provider<Discountable> discountableProvider;

    @Inject
    public CheckoutService(Provider<Discountable> discountableProvider) {
        this.discountableProvider = discountableProvider;
    }

    public void checkout(double shoppingCartTotal) {
        // only when this method is called that we make use of the discountable object
        // Hence, it is a good idea that only when this method is called and object of discountable is instantiated
        // here, the provider.get() -> creates the instance of the class by 1st invoking the provider and then
        // creating the instance of the provider type class.
        double discount = discountableProvider.get().getDiscount();
        double totalAfterDiscount = shoppingCartTotal - (shoppingCartTotal * discount);
        log.info("Shopping cart initially {} with a discount of {}% = {}",
                shoppingCartTotal,
                discount*100,
                totalAfterDiscount
        );
    }
}
