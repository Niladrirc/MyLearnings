package motivation;

public class Hotel {
    private double pricePerNight;
    private double rating;
    private HotelType type;

    public Hotel(double pricePerNight, double rating, HotelType type) {
        this.pricePerNight = pricePerNight;
        this.rating = rating;
        this.type = type;
    }

    public double getPricePerNight() {
        return pricePerNight;
    }

    public void setPricePerNight(double pricePerNight) {
        this.pricePerNight = pricePerNight;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public HotelType getType() {
        return type;
    }

    public void setType(HotelType type) {
        this.type = type;
    }
}
