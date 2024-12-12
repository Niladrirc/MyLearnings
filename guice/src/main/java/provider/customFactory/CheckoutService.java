package provider.customFactory;

import com.google.inject.Inject;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CheckoutService {
    private final DiscountFactory discountFactory;

    @Inject
    public CheckoutService(DiscountFactory discountFactory) {
        this.discountFactory = discountFactory;
    }

    public double checkout(ShoppingCart cartDetails) {
        Discountable discountable = discountFactory.getDiscountableImpl(cartDetails);
        double discount = discountable.getDiscount();
        double cartTotal = cartDetails.getCartTotal();

        double totalCartValue = cartTotal - (cartTotal * discount);
        log.info("Shopping cart initially ₹{}/- with a discount of {}% = ₹{}/-",
                cartTotal,
                discount*100,
                totalCartValue
        );

        return totalCartValue;
    }
}
