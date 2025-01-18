package passingFunctionsAsParametersWithoutLambdas.withConcreteImpl;

import passingFunctionsAsParametersWithoutLambdas.Hotel;
import passingFunctionsAsParametersWithoutLambdas.HotelType;
import passingFunctionsAsParametersWithoutLambdas.IFilterHotel;

public class FiveStarHotels implements IFilterHotel {
    @Override
    public boolean doFilter(Hotel hotel) {
        return hotel.getType() == HotelType.FIVE_STAR;
    }
}
