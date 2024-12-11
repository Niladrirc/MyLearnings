package provider.diIntoProvider.impl;

import provider.diIntoProvider.Discountable;

public class BigDiscount implements Discountable {
    @Override
    public double getDiscount() {
        return 0.35D;
    }
}
