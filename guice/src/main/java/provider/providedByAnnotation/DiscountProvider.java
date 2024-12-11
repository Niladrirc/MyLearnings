package provider.providedByAnnotation;

import com.google.inject.Provider;
import provider.providedByAnnotation.impl.EarlyBirdDiscount;
import provider.providedByAnnotation.impl.NightOwlDiscount;
import provider.providedByAnnotation.impl.NoDiscount;

import java.time.LocalTime;

public class DiscountProvider implements Provider<Discountable> {
    @Override
    public Discountable get() {
        long currentHour = LocalTime.now().getHour();
        //  currentHour = 6L;
        if (isEarlyMorning(currentHour)) {
            return new EarlyBirdDiscount();
        } else if (isLateNight(currentHour)) {
            return new NightOwlDiscount();
        }

        return new NoDiscount();
    }

    private boolean isLateNight(long currentHour) {
        return (currentHour >= 0 && currentHour < 4);
    }

    private boolean isEarlyMorning(long currentHour) {
        return (currentHour >= 4 && currentHour < 9);
    }
}
