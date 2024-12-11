package basic;

import com.google.inject.ImplementedBy;
import basic.impl.impl.NightOwlDiscount;

@ImplementedBy(NightOwlDiscount.class)
public interface Discountable {
    double getDiscount();
}
