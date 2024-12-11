package provider.providedByAnnotation.impl;

import provider.providedByAnnotation.Discountable;

public class NoDiscount implements Discountable {
    @Override
    public double getDiscount() {
        return 0;
    }
}
