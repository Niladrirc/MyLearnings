package provider.providedByAnnotation.impl;

import provider.providedByAnnotation.Discountable;

public class NightOwlDiscount implements Discountable {
    @Override
    public double getDiscount() {
        return 0.35D;
    }
}
