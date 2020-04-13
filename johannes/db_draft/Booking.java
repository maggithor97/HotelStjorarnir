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

    public int getReferenceNumber() 
    {
        return ref;
    }
    
    public String getHotel()
    {
        return hotelName;
    }

    public String getCity()
    {
        return hotelCity;
    }

    public String getAddress()
    {
        return hotelAddr;
    } 

    public int getRoomNumber() 
    {
        return roomNum;
    }

    public String getRoomType()
    {
        return roomType;
    }

    public String getCheckIn() 
    {
        return checkIn;
    }

    public String getCheckOut() 
    {
        return checkOut;
    }

    public String getFirstName() 
    {
        return fName;
    }

    public String getMiddleName() 
    {
        return mName;
    }

    public String getLastName() 
    {
        return lName;
    }

    public String getEmail() 
    {
        return email;
    }

    public String toString()
    {
        String s = "Reference no. " + ref       + "\n" + 
                   "Hotel name    " + hotelName + "\n" +
                   "City          " + hotelCity + "\n" +
                   "Address       " + hotelAddr + "\n" + 
                   "Room no.      " + roomNum   + "\n" + 
                   "Room type     " + roomType  + "\n" +
                   "CheckIn       " + checkIn   + "\n" +
                   "CheckOut      " + checkOut  + "\n" +
                   "First name    " + fName     + "\n" +
                   "Middle name   " + mName     + "\n" +
                   "Last name     " + lName     + "\n" +
                   "E-mail        " + email     + "\n";
        return s;
    }
}

