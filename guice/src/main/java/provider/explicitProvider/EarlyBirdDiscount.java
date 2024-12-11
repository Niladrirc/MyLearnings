package provider.explicitProvider;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class EarlyBirdDiscount implements Discountable {
    @Override
    public double getDiscount() {
        log.info("Providing Early bird discount");
        return 0.25D;
    }
}
