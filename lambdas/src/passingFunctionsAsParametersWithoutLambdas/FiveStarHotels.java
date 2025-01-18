package passingFunctionsAsParametersWithoutLambdas;

public class FiveStarHotels implements IFilterHotel {
    @Override
    public boolean doFilter(Hotel hotel) {
        return hotel.getType() == HotelType.FIVE_STAR;
    }
}
