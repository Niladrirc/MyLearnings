package discount_example.basic.impl.impl;

import discount_example.basic.Discountable;

public class EarlyBirdDiscount implements Discountable {
    @Override
    public double getDiscount() {
        return 0.25;
    }
}
