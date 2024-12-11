package provider.providedByAnnotation.impl;


import provider.providedByAnnotation.Discountable;

public class EarlyBirdDiscount implements Discountable {
    @Override
    public double getDiscount() {
        return 0.25D;
    }
}
