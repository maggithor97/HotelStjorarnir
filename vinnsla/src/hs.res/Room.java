package hs.res;

public class Room
{
    private int roomID;
    private String roomType;
    private int roomNumber;
    private int pricePerNight;
    private Hotel hotel;
    
    /**
    *@param roomID room's unique ID number
    *@param roomType 1-bed, 2-bed, 3-bed or Suite
    *@param roomNumber room number (not to be confused with room ID)
    *@param pricePerNight price per night in isk
    *@param hotel hotel that room is in
    */
    public Room (int roomID, String roomType, int roomNumber, 
                 int pricePerNight, Hotel hotel)  
    {
        this.roomID = roomID;
        this.roomType = roomType;
        this.roomNumber = roomNumber;
        this.pricePerNight = pricePerNight;
        this.hotel = hotel;
    }

    /**
    *@return room's unique ID number
    */
    public int getRoomID()
    {
        return roomID;
    }

    /**
    *@return 1-bed, 2-bed, 3-bed or Suite
    */
    public String getRoomType()
    {
        return roomType;
    }

    /**
    *@return room number (not to be confused with room ID)
    */
    public int getRoomNumber()
    {
        return roomNumber;
    } 
    
    /**
    *@return price per night in isk
    */
    public int getPrice()
    {
        return pricePerNight;
    }

    /**
    *@return hotel that room is in
    */
    public Hotel getHotel()
    {
        return hotel;
    }
}
