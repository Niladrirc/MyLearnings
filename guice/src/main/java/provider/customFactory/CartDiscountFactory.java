package provider.customFactory;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import java.util.Map;

import static provider.customFactory.DiscountOption.*;

@Singleton
public class CartDiscountFactory implements DiscountFactory {

    private final Map<DiscountOption, Discountable> discountMap;

    @Inject
    public CartDiscountFactory(Map<DiscountOption, Discountable> discountMap) {
        this.discountMap = discountMap;
    }

    @Override
    public Discountable getDiscountableImpl(ShoppingCart cart) {
        int currentHour = cart.getTimeOfCheckout().getHour();

        if (isEearlyMorning(currentHour))
            return discountMap.get(EARLY_BIRD);
        else if (isLateNight(currentHour)) {
            return discountMap.get(NIGHT_OWL);
        }
        return discountMap.get(NO_DISCOUNT);
    }

    private boolean isLateNight(int currentHour) {
        return (currentHour >= 0 && currentHour < 4);
    }

    private boolean isEearlyMorning(int currentHour) {
        return (currentHour >= 4 && currentHour < 9);
    }
}
