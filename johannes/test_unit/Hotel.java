import java.util.Date;

public class Hotel {
    private String name;
    private String hotelType;
    private Room [] rooms;
    private int starRating;
    private String city;
    private String address;

    public Hotel(String name, String hotelType, Room[] rooms, int starRating,
    String city, String address) {
        this.name = name;
        this.hotelType = hotelType;
        this.rooms = rooms;
        this.starRating = starRating;
        this.city = city;
        this.address = address;
    }

    public String getName() {
        return this.name;
    }
    public String getHotelType() {
        return this.hotelType;
    }
    public Room[] getRooms() {
        return this.rooms;
    } 
    public int getStarRating() {
        return this.starRating;
    }
    public String getCity() {
        return this.city;
    }
    public String getAddress() {
        return this.address;
    }

    public static void main(String[] args) {

    }
}
