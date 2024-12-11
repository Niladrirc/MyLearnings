package provider.providesAnnotation.guice;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import provider.providesAnnotation.Discountable;
import provider.providesAnnotation.impl.EarlyBirdDiscount;
import provider.providesAnnotation.impl.NightOwlDiscount;
import provider.providesAnnotation.impl.NoDiscount;

import java.time.LocalDateTime;

public class DiscountModule extends AbstractModule {

//    @Override
//    protected void configure() {
//        bind(Discountable.class).to(EarlyBirdDiscount.class);
//    }

    @Provides
    public Discountable get() {
        long currentHour = LocalDateTime.now().getHour();
//        currentHour = 02L;
        if (isEarlyHour(currentHour))
            return new EarlyBirdDiscount();
        else if (isLateNight(currentHour))
            return new NightOwlDiscount();
        return new NoDiscount();
    }

    private boolean isLateNight(long currentHour) {
        return (currentHour >= 0 && currentHour < 4);
    }

    private boolean isEarlyHour(long currentHour) {
        return (currentHour >= 4 && currentHour < 9);
    }
}
