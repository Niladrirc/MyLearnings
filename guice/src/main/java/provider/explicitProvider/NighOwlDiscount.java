package provider.explicitProvider;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class NighOwlDiscount implements Discountable {
    @Override
    public double getDiscount() {
        log.info("Providing Night Owl Discount");
        return 0.35D;
    }
}
