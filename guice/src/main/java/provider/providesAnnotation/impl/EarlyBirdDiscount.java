package provider.providesAnnotation.impl;

import provider.providesAnnotation.Discountable;

public class EarlyBirdDiscount implements Discountable {
    @Override
    public double getDiscount() {
        return 0.25D;
    }
}
