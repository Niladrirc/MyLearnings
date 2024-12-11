package discount_example.basic;

import com.google.inject.ImplementedBy;
import discount_example.basic.impl.impl.NightOwlDiscount;

@ImplementedBy(NightOwlDiscount.class)
public interface Discountable {
    double getDiscount();
}
