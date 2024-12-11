package provider.diIntoProvider.impl;

import provider.diIntoProvider.Discountable;

public class SmallDiscount implements Discountable {
    @Override
    public double getDiscount() {
        return 0.05D;
    }
}
