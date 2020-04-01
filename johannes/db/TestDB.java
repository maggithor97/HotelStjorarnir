import java.sql.*;
import java.sql.DriverManager;
import org.junit.*;
import static org.junit.Assert.*;

public class TestDB
{
    private HotelDB hotelDB;
    private Hotel[] hotel;
    private Room[] room;
    private int hotelID;

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

            stmt = conn.createStatement();
            s = "INSERT INTO ROOMS (RoomType, RoomNum, rHotelID, Price) " +
                "VALUES ('2-bedroom', 101, " + hotelID + ", 20000)";
            stmt.executeUpdate(s);
        }
        catch (SQLException e)
        {
            System.err.println(e.getMessage());
        }
        finally
        {
            try
            {
                if (conn != null)
                    conn.close();
            }
            catch (SQLException e)
            {
                System.err.println(e.getMessage());
            }
        }

        hotelDB = new HotelDB("Somewhere City");
        hotel = hotelDB.getHotels();
        room = hotel[0].getRooms();        
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
        }
        catch(SQLException e)
        {
            System.err.println(e.getMessage());
        }
        finally
        {
            try
            {
                if (conn != null)
                    conn.close();
            }
            catch (SQLException e)
            {
                System.err.println(e.getMessage());
            }
        }   
    
        hotelDB = null;
    } 

    @Test
    public void testHotels()
    {
        assertEquals(1, hotelDB.getHotels().length);
    }

    @Test
    public void testName()
    {
        String name = hotel[0].getName();
        assertEquals("Hotel Somewhere", name);
    }

    @Test
    public void testCity()
    {
        String city = hotel[0].getCity();
        assertEquals("Somewhere City", city);
    }

    @Test
    public void testAddress()
    {
        String address = hotel[0].getAddress();
        assertEquals("Somewhere Street", address);
    }

    @Test
    public void testRooms()
    {
        Room[] room = hotel[0].getRooms();        
        assertEquals(1, room.length);
    }

    @Test
    public void testRoomType()
    {
        Room[] room = hotel[0].getRooms();
        String roomType = room[0].getRoomType();
        assertEquals("2-bedroom", roomType);
    }

    @Test
    public void testRoomNumber()
    {
        Room[] room = hotel[0].getRooms();
        int roomNumber = room[0].getRoomNumber();
        assertEquals(101, roomNumber);
    }

    @Test
    public void testPrice()
    {
        Room[] room = hotel[0].getRooms();
        int price = room[0].getPrice();
        assertEquals(20000, price);
    }
}
