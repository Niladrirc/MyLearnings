package discount_example.provider.diIntoProvider.impl;

import discount_example.provider.diIntoProvider.Discountable;

public class SmallDiscount implements Discountable {
    @Override
    public double getDiscount() {
        return 0.05D;
    }
}
