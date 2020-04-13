package hs.res;

public class Booking 
{
    private int ref;
    private String hotelName;
    private String hotelCity;
    private String hotelAddr;
    private int roomNum;
    private String roomType;
    private String checkIn;
    private String checkOut;
    private String fName;
    private String mName;
    private String lName;
    private String email;

    /**
    *@param ref booking's unique reference number
    *@param room room that's being booked
    *@param checkIn check in date, YYYY-MM-DD
    *@param checkOut check out date, YYYY-MM-DD
    *@param fName customer's first name
    *@param mName customer's middle name (empty string allowed, not null)
    *@param lName customer's last name 
    *@param email customer's e-mail address
    */
    public Booking (
            int ref, 
            Room room, 
            String checkIn, 
            String checkOut, 
            String fName, 
            String mName, 
            String lName,
            String email) 
    {
        this.ref       = ref;
        this.hotelName = room.getHotel().getName();
        this.hotelCity = room.getHotel().getCity();
        this.hotelAddr = room.getHotel().getAddress();
        this.roomNum   = room.getRoomNumber();
        this.roomType  = room.getRoomType();
        this.checkIn   = checkIn;
        this.checkOut  = checkOut;
        this.fName     = fName;
        this.mName     = mName;
        this.lName     = lName;
        this.email     = email;      
    }

    /**
    *@param ref booking's unique reference number
    *@param hotelName name of hotel
    *@param hotelCity city where hotel is located
    *@param hotelAddr street where hotel is located
    *@param roomNum room number (not to be confused with room ID)
    *@param roomType 1-bed, 2-bed, 3-bed or suite
    *@param checkIn check in date, YYYY-MM-DD
    *@param checkOut check out date, YYYY-MM-DD
    *@param fName customer's first name
    *@param mName customer's middle name (empty string allowed, not null)
    *@param lName customer's last name 
    *@param email customer's e-mail address
    */
    public Booking (
            int ref, 
            String hotelName,
            String hotelCity,
            String hotelAddr,
            int roomNum,
            String roomType, 
            String checkIn, 
            String checkOut, 
            String fName, 
            String mName, 
            String lName,
            String email) 
    {
        this.ref       = ref;
        this.hotelName = hotelName;
        this.hotelCity = hotelCity;
        this.hotelAddr = hotelAddr;
        this.roomNum   = roomNum;
        this.roomType  = roomType;
        this.checkIn   = checkIn;
        this.checkOut  = checkOut;
        this.fName     = fName;
        this.mName     = mName;
        this.lName     = lName;
        this.email     = email;      
    }

    /**
    *@return booking's unique reference number
    */
    public int getReferenceNumber() 
    {
        return ref;
    }
   
    /**
    *@return name of hotel
    */ 
    public String getHotel()
    {
        return hotelName;
    }

    /**
    *@return city where hotel is located
    */
    public String getCity()
    {
        return hotelCity;
    }

    /**
    *@return street where hotel is located
    */
    public String getAddress()
    {
        return hotelAddr;
    } 

    /**
    *@return room number (not to be confused with room ID)
    */
    public int getRoomNumber() 
    {
        return roomNum;
    }

    /**
    *@return type of room, e.g. 2-bedroom etc.
    */
    public String getRoomType()
    {
        return roomType;
    }

    /**
    *@return check in date
    */
    public String getCheckIn() 
    {
        return checkIn;
    }

    /**
    *@return check out date
    */
    public String getCheckOut() 
    {
        return checkOut;
    }

    /**
    *@return customer's first name
    */
    public String getFirstName() 
    {
        return fName;
    }

    /**
    *@return customer's middle name
    */
    public String getMiddleName() 
    {
        return mName;
    }

    /**
    *@return customer's last name
    */
    public String getLastName() 
    {
        return lName;
    }

    /**
    *@return customer's e-mail address
    */
    public String getEmail() 
    {
        return email;
    }
}

