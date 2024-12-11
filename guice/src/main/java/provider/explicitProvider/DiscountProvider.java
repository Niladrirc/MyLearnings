package provider.explicitProvider;

import com.google.inject.Provider;

import java.time.LocalTime;

public class DiscountProvider implements Provider<Discountable> {
//    @Override
//    public Discountable get() {
//        return new EarlyBirdDiscount() ;
//    }

    /**
     * For 4AM to 9AM -> give early bird discount
     * For 12 AM to 4AM -> give night owl discount
     * Else give no discout
     */

    @Override
    public Discountable get() {
        long currentHour = LocalTime.now().getHour();
        //  currentHour = 6L;
        if (isEarlyMorning(currentHour)) {
            return new EarlyBirdDiscount();
        } else if (isLateNight(currentHour)) {
            return new NighOwlDiscount();
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
