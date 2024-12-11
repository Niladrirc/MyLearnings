package basic.impl.impl;

import basic.Discountable;

public class NightOwlDiscount implements Discountable {
    @Override
    public double getDiscount() {
        return 0.35;
    }
}
