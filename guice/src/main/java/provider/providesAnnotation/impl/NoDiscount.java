package provider.providesAnnotation.impl;

import provider.providesAnnotation.Discountable;

public class NoDiscount implements Discountable {
    @Override
    public double getDiscount() {
        return 0;
    }
}
