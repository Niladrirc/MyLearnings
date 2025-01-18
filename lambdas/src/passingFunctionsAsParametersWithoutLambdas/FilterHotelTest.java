package passingFunctionsAsParametersWithoutLambdas;

import java.util.List;

public class FilterHotelTest {
    public static void main(String[] args) {
        HotelService hotelService = new HotelService();

        // Filter hotels with pricePerNight <= 2000
        List<Hotel> hotels = hotelService.filterHotels(new HotelsLessThan2000());
        System.out.println(hotels);

        // Filter 5 star hotels
        List<Hotel> fiveStarHotels = hotelService.filterHotels(new FiveStarHotels());
        System.out.println(fiveStarHotels);

        /**
         * How to pass functions as method arguments or parameters:
         * 1. Create an interface
         * 2. Instantiate a class implementing the interface
         * 3. implement the method of the interface, where the method body = function body which you want to pass as paramater
         * 4. pass an object of concrete implementation of the interface
         *
         * basically if you want to pass functions as method arguments then,
         * wrap it inside the interface
         * because, functions cannot be directly passed as arguments but objects can
         * we just wrap the function with the interface so that it can be passed as method argument
         */
    }
}
