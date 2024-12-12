package provider.customFactory;

import com.google.inject.ImplementedBy;

@ImplementedBy(CartDiscountFactory.class)
public interface DiscountFactory {
    Discountable getDiscountableImpl(ShoppingCart cart);
}
