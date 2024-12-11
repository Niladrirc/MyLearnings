package discount_example.basic.impl.impl;

import discount_example.basic.Discountable;

public class NightOwlDiscount implements Discountable {
    @Override
    public double getDiscount() {
        return 0.35;
    }
}
