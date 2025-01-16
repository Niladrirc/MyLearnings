package motivation;

import java.util.ArrayList;
import java.util.List;

/**
 * Here we see a lot of code deduplication
 * Same type of filter methods called again and again with very small changes
 * as the project grows this class will get very bloated
 */
public class HotelService {
    List<Hotel> hotels = new ArrayList<>();

    public HotelService() {
        hotels.add(new Hotel(2000, 2, HotelType.THREE_STAR));
        hotels.add(new Hotel(1000, 1, HotelType.THREE_STAR));
        hotels.add(new Hotel(10000, 4, HotelType.FOUR_STAR));
        hotels.add(new Hotel(20000, 5, HotelType.FIVE_STAR));
        hotels.add(new Hotel(5000, 3, HotelType.FOUR_STAR));
    }

    private boolean isHotelPriceLessThan(double price, Hotel hotel) {
        return hotel.getPricePerNight() <= price;
    }

    public List<Hotel> filterHotelLessThan(double price) {
        List<Hotel> filteredHotels = new ArrayList<>();

        for (Hotel hotel : hotels) {
            if (isHotelPriceLessThan(price, hotel))
                filteredHotels.add(hotel);
        }

        return filteredHotels;
    }

    private boolean isHotel5Star(Hotel hotel) {
        return hotel.getType() == HotelType.FIVE_STAR;
    }

    public List<Hotel> filterHotelBy5Star() {
        List<Hotel> filteredHotels = new ArrayList<>();

        for (Hotel hotel : hotels) {
            if (isHotel5Star(hotel))
                filteredHotels.add(hotel);
        }

        return filteredHotels;
    }
}
