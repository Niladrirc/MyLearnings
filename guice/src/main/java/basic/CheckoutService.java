package basic;

import com.google.inject.Inject;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CheckoutService {

    private final Discountable discount;

    @Inject
    public CheckoutService(Discountable discount) {
        this.discount = discount;
    }

    public double checkout(double shoppingCartTotal) {
        double totalAfterDiscount = shoppingCartTotal - (shoppingCartTotal * discount.getDiscount());
        log.info("Shopping cart initially {} with a discount of {}% = {}", shoppingCartTotal, discount.getDiscount()*100, totalAfterDiscount);
        return totalAfterDiscount;
    }
}
