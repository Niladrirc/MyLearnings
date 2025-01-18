package passingFunctionsAsParametersWithoutLambdas;

public class HotelsLessThan2000 implements IFilterHotel {
    @Override
    public boolean doFilter(Hotel hotel) {
        return hotel.getPricePerNight() <= 2000;
    }
}
