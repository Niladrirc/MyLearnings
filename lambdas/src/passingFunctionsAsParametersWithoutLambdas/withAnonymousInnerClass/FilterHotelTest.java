package passingFunctionsAsParametersWithoutLambdas.withAnonymousInnerClass;

import passingFunctionsAsParametersWithoutLambdas.Hotel;
import passingFunctionsAsParametersWithoutLambdas.HotelService;
import passingFunctionsAsParametersWithoutLambdas.HotelType;
import passingFunctionsAsParametersWithoutLambdas.IFilterHotel;

import java.util.List;

public class FilterHotelTest {
    public static void main(String[] args) {
        HotelService service = new HotelService();

        // Filter hotels with price less than 2000
        List<Hotel> hotels = service.filterHotels(new IFilterHotel() {
            @Override
            public boolean doFilter(Hotel hotel) {
                return hotel.getPricePerNight() <= 2000;
            }
        });

        System.out.println("List of hotels with price per night less than 2000: " + hotels);


        // Filter 5 star hotels
        List<Hotel> fiveStarHotels = service.filterHotels(new IFilterHotel() {
            @Override
            public boolean doFilter(Hotel hotel) {
                return hotel.getType().equals(HotelType.FIVE_STAR);
            }
        });
        System.out.println("List of hotels with 5 star rating: " + fiveStarHotels);

    }
}
