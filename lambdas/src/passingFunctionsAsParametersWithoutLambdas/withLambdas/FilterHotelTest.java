package passingFunctionsAsParametersWithoutLambdas.withLambdas;

import passingFunctionsAsParametersWithoutLambdas.Hotel;
import passingFunctionsAsParametersWithoutLambdas.HotelService;
import passingFunctionsAsParametersWithoutLambdas.HotelType;

import java.util.List;

public class FilterHotelTest {
    public static void main(String[] args) {
        HotelService hotelService = new HotelService();

        // Filter hotels where pricePerNight is less than 2000
        List<Hotel> hotels = hotelService.filterHotels((Hotel hotel) -> {
            return hotel.getPricePerNight() <= 2000;
        });
        System.out.println("List of hotels with price less than 2000: ");
        hotels.forEach(System.out::println);

        //Filter 5 star hotels
        List<Hotel> fiveStarHotels = hotelService.filterHotels((Hotel hotel) -> {
            return hotel.getType().equals(HotelType.FIVE_STAR);
        });
        System.out.println("\nList of 5 star hotels: ");
        fiveStarHotels.forEach(System.out::println);
    }
}
