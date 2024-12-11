package provider.implicitProvider;

import com.google.inject.ImplementedBy;
import provider.implicitProvider.impl.EarlyBirdDiscount;

@ImplementedBy(EarlyBirdDiscount.class)
public interface Discountable {
    double getDiscount();
}
