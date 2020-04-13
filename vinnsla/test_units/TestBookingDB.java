import hs.res.*;
import hs.db.*;
import java.sql.*;
import java.util.*;
import java.sql.DriverManager;
import org.junit.*;
import static org.junit.Assert.*;

public class TestBookingDB
{
    private HotelDB hotelDB;
    private ArrayList<Hotel> hotel;
    private ArrayList<Room> room;
    private BookingDB bookingDB;
    private Booking booking;
    private int hotelID;
    private int roomID;

    @Before
    public void setUp()
    {
        Connection conn = null;
        try
        {
            String url = "jdbc:sqlite:hotels.db";
            conn = DriverManager.getConnection(url);
            
            Statement stmt = conn.createStatement();
            String s = "INSERT INTO HOTELS (Name, City, Address) " +
                       "VALUES ('Hotel Somewhere', " +
                       "'Somewhere City', 'Somewhere Street')";
            stmt.executeUpdate(s);
            stmt = null;

            stmt = conn.createStatement();
            s = "SELECT HotelID FROM HOTELS WHERE City = 'Somewhere City'";
            ResultSet rs = stmt.executeQuery(s);
            hotelID = rs.getInt(1);
            stmt = null;
            rs = null;

            stmt = conn.createStatement();
            s = "INSERT INTO ROOMS (RoomType, RoomNum, rHotelID, Price) " +
                "VALUES ('2-bedroom', 101, " + hotelID + ", 20000)";
            stmt.executeUpdate(s);
            stmt = null; 
        }
        catch (Exception e) 
        { 
            System.err.println(e.getMessage());
            System.err.println("yo");
        }
        finally 
        {
            try
            {
                if (conn != null)
                {
                    conn.close();
                }
            }
            catch (Exception e) 
            {
                System.err.println(e.getMessage()); 
                System.err.println("hey"); 
            }
        }

        String checkIn = "2020-04-06";
        String checkOut = "2020-04-15";
        String fName = "John";
        String mName = "";
        String lName = "Doe";
        String email = "johndoe@email.com";
       
        hotelDB = new HotelDB("Somewhere City", "2020-04-06",
                              "2020-04-15", "2-bedroom");
        hotel = hotelDB.getHotels();
        room = hotel.get(0).getRooms(); 
        bookingDB = new BookingDB(room.get(0), checkIn, checkOut, 
                            fName, mName, lName, email);
        booking = bookingDB.getBooking(); 
    }
    
    @After
    public void tearDown()
    {
        Connection conn = null;
        try 
        {
            String url = "jdbc:sqlite:hotels.db";
            conn = DriverManager.getConnection(url);
            
            Statement stmt = conn.createStatement();
            String s = "DELETE FROM HOTELS WHERE Name = 'Hotel Somewhere'";
            stmt.executeUpdate(s);
            stmt = null;

            stmt = conn.createStatement();
            s = "DELETE FROM ROOMS WHERE RoomID = " + room.get(0).getRoomID();
            stmt.executeUpdate(s);
            stmt = null;

            stmt = conn.createStatement();
            s = "DELETE FROM BOOKINGS WHERE ReferenceNo = " + booking.getReferenceNumber();
            stmt.executeUpdate(s);
            stmt = null;

            stmt = conn.createStatement();
            s = "DELETE FROM OCCUPANCY WHERE oRoomID = " + room.get(0).getRoomID() +
                " AND oCheckIn = '" + booking.getCheckIn() + "' AND " + 
                "oCheckOut = '" + booking.getCheckOut() + "'";
            stmt.executeUpdate(s);
            stmt = null;
        }
        catch (Exception e) 
        {
            System.err.println(e.getMessage()); 
            System.err.println("sup"); 
        } 
        finally 
        {
            try
            {
                if (conn != null)
                {
                    conn.close();
                }
            }
            catch (Exception e) 
            {
                System.err.println(e.getMessage()); 
                System.err.println("bro"); 
            }
        }
    }

    @Test
    public void testHotel()
    {
        assertEquals("Hotel Somewhere", booking.getHotel());
    }

    @Test
    public void testCity()
    {
        assertEquals("Somewhere City", booking.getCity());
    }

    @Test
    public void testAddress()
    {
        assertEquals("Somewhere Street", booking.getAddress());
    }

    @Test
    public void testRoomNumber()
    {
        assertEquals(101, booking.getRoomNumber());
    }

    @Test
    public void testCheckIn()
    {
        assertEquals("2020-04-06", booking.getCheckIn());
    }

    @Test
    public void testCheckOut()
    {
        assertEquals("2020-04-15", booking.getCheckOut());
    }

    @Test
    public void testFirstName()
    {
        assertEquals("John", booking.getFirstName());
    }

    @Test
    public void testMiddleName()
    {
        assertEquals("", booking.getMiddleName());
    }

    @Test
    public void testLastName()
    {
        assertEquals("Doe", booking.getLastName());
    }

    @Test
    public void testEmail()
    {
        assertEquals("johndoe@email.com", booking.getEmail());
    }
}
