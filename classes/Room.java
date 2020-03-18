/*****************************************************
* This is a object class of a Room
**************************************************** */
public class Room {
    private int roomNumber;
    private String roomType;
    private int pricePerNight;
    private Hotel hotel;

    /*Constructor */
    public Room(int roomNumber, String roomType, int pricePerNight,
    Hotel hotel) {
        this.roomNumber = roomNumber;
        this.roomType = roomType;
        this.pricePerNight = pricePerNight;
        this.hotel = hotel;
    }
    /*Getters */
    public int getRoomNumber() {
        return this.roomNumber;
    }
    public String getRoomType() {
        return this.roomType;
    }
    public int getPrice () {
        return this.pricePerNight;
    }
    public Hotel getHotel() {
        return this.hotel;
    }

    public static void main(String[] args) {

    }
}