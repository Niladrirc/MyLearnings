package provider.providedByAnnotation;

import com.google.inject.Inject;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CheckoutService {
    private final Discountable discountable;

    @Inject
    public CheckoutService(Discountable discountable) {
        this.discountable = discountable;
    }

    public double checkout(double cartAmount) {
        double discount = discountable.getDiscount();
        double totalAfterDiscount = cartAmount - (cartAmount * discount);
        log.info("Shopping cart initially {} with a discount of {}% = {}",
                cartAmount,
                discount*100,
                totalAfterDiscount
        );
        return totalAfterDiscount;
    }
}
