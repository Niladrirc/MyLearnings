package provider.explicitProvider;

import com.google.inject.Inject;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CheckoutService {
    // private final Provider<Discountable> discountableProvider; -> not necessary, if a provider class is defined then it will be invoked
    private Discountable discountable;

    @Inject
    //public CheckoutService(Provider<Discountable> discountableProvider) {
    public CheckoutService(Discountable discountable) {
        this.discountable = discountable;
    }

    public void checkout(double cartValue) {
        // double discount = discountableProvider.get().getDiscount();
        double discount = discountable.getDiscount();
        double totalAfterDiscount = cartValue - (cartValue * discount);
        log.info("Shopping cart initially {} with a discount of {}% = {}",
                cartValue,
                discount*100,
                totalAfterDiscount
        );
    }
}
