package provider.implicitProvider.impl;


import provider.implicitProvider.Discountable;

public class EarlyBirdDiscount implements Discountable {
    @Override
    public double getDiscount() {
        return 0.25;
    }
}
