package provider.providesAnnotation.impl;

import provider.providesAnnotation.Discountable;

public class NightOwlDiscount implements Discountable {
    @Override
    public double getDiscount() {
        return 0.35D;
    }
}
