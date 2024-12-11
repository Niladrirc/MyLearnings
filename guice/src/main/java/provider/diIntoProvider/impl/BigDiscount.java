package discount_example.provider.diIntoProvider.impl;

import discount_example.provider.diIntoProvider.Discountable;

public class BigDiscount implements Discountable {
    @Override
    public double getDiscount() {
        return 0.35D;
    }
}
