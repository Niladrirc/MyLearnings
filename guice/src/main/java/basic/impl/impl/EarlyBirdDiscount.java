package basic.impl.impl;

import basic.Discountable;

public class EarlyBirdDiscount implements Discountable {
    @Override
    public double getDiscount() {
        return 0.25;
    }
}
