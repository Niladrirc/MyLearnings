package discount_example.provider.diIntoProvider;

import com.google.inject.Inject;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CheckoutService {
    private final Discountable discountable;

    @Inject
    public CheckoutService(Discountable discountable) {
        this.discountable = discountable;
    }

    public double checkout(double cartTotal) {
        double discount = discountable.getDiscount();

        double totalCartValue = cartTotal - (cartTotal * discount);
        log.info("Shopping cart initially {} with a discount of {}% = {}",
                cartTotal,
                discount*100,
                totalCartValue
        );

        return totalCartValue;
    }
}
