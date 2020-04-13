public class Room
{
    private int roomID;
    private String roomType;
    private int roomNumber;
    private int pricePerNight;
    private Hotel hotel;

    public Room (
            int roomID, 
            String roomType, 
            int roomNumber, 
            int pricePerNight, 
            Hotel hotel)  
    {
        this.roomID = roomID;
        this.roomType = roomType;
        this.roomNumber = roomNumber;
        this.pricePerNight = pricePerNight;
        this.hotel = hotel;
    }

    public int getRoomID()
    {
        return roomID;
    }

    public String getRoomType()
    {
        return roomType;
    }

    public int getRoomNumber()
    {
        return roomNumber;
    } 
    
    public int getPrice()
    {
        return pricePerNight;
    }

    public Hotel getHotel()
    {
        return hotel;
    }
}
