package provider.explicitProvider;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class NoDiscount implements Discountable {
    @Override
    public double getDiscount() {
        log.info("No Discount will be provided");
        return 0D;
    }
}
