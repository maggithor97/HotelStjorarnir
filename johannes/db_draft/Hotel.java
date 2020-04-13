public class Hotel 
{
    private int hotelID;
    private String name;
    private String city;
    private String address;
    private Room[] room;

    public Hotel(int hotelID, String name, String city, String address) 
    {
        this.hotelID = hotelID;
        this.name = name;
        this.city = city;
        this.address = address;
    }

    public int getHotelID()
    {
        return hotelID;
    }

    public String getName() 
    {
        return this.name;
    }
    public String getCity() 
    {
        return this.city;
    }
    public String getAddress() 
    {
        return this.address;
    }

    public void setRooms(Room[] room)
    {
        this.room = room;
    }
    
    public Room[] getRooms()
    {
        return this.room;
    }
}
