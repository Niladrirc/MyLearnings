package provider.customFactory;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.sun.jdi.IntegerValue;
import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalTime;

@Slf4j
public class BasicApplication {
    private final CheckoutService service;
    private final ShoppingCart cart;

    @Inject
    public BasicApplication(CheckoutService service, ShoppingCart cart) {
        this.service = service;
        this.cart = cart;
    }

    public static void main(String[] args) {
        Injector injector = Guice.createInjector(new DiscountGuiceModule());
        BasicApplication application = injector.getInstance(BasicApplication.class);
        application.run();
    }

    private void run() {
        while (true) {
            service.checkout(getNewUserCheckout());
        }
    }

    /**********************************************************/
    /****************  Our GUI simulator **********************/
    /**********************************************************/

    ShoppingCart getNewUserCheckout() {
        cart.setCartTotal(getTotalFromInput());
        cart.setTimeOfCheckout(getCheckoutTimeFromInput());

        return cart;
    }

    private LocalTime getCheckoutTimeFromInput() {
        LocalTime checkoutTime = null;
        String hour = null;

        System.out.print("Enter checkout hour: ");

        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            hour = reader.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return LocalTime.of(Integer.parseInt(hour), 0);
    }

    private double getTotalFromInput() {
        String total = null;
        System.out.print("Enter cart total: ");

        try {
            BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
            total = bufferRead.readLine();
        } catch (IOException doh) {
            log.error("Error in accepting cart total from console", doh);
        }

        return Double.parseDouble(total);
    }
}
