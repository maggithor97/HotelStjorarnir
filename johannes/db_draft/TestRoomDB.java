import java.sql.*;
import org.junit.*;
import static org.junit.Assert.*;

public class TestRoomDB
{
    private Hotel hotel;
    private RoomDB roomDB;
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
            s = "SELECT HotelID, Name, City, Address " + 
                "FROM HOTELS " + 
                "WHERE City = 'Somewhere City'";
            ResultSet rs = stmt.executeQuery(s);
            hotelID = rs.getInt(1);
            String name = rs.getString(2);
            String city = rs.getString(3);
            String addr = rs.getString(4);
            hotel = new Hotel(hotelID, name, city, addr);
            rs = null;
            stmt = null;

            stmt = conn.createStatement();
            s = "INSERT INTO ROOMS (RoomType, RoomNum, rHotelID, Price) " +
                "VALUES ('2-bedroom', 101, " + hotelID + ", 2000)";
            stmt.executeUpdate(s);
        }
        catch (Exception e) { System.err.println(e.getMessage()); }
        finally
        {
            try
            {
                if (conn != null)
                    conn.close();
            }
            catch (Exception e) { System.err.println(e.getMessage()); }
        }
        
        roomDB = new RoomDB(hotel);
        room = roomDB.getRooms();
    }

    @After
    public void tearDown()
    {
        Connection conn = null;
        Room[] room = new Room[1];
        int roomID;
        try
        {
            String url = "jdbc:sqlite:hotels.db";
            conn = DriverManager.getConnection(url);
            Statement stmt = conn.createStatement();
            room = roomDB.getRooms();
            roomID = room[0].getRoomID();
            String s = "DELETE FROM ROOMS WHERE RoomID = " + roomID;
            stmt.executeUpdate(s);
        }
        catch (Exception e) { System.err.println(e.getMessage()); }
        finally 
        {
            try
            {
                if (conn != null)
                    conn.close();
            }
            catch (Exception e) { System.out.println(e.getMessage()); }
        }
        
        roomDB = null;
    }        

    @Test
    public void testRooms()
    {
        assertEquals(1, room.length);
    }

    @Test
    public void testRoomType()
    {
        String roomType = room[0].getRoomType();
        assertEquals("2-bedroom", roomType);
    }

    @Test
    public void testRoomNumber()
    {
        int roomNumber = room[0].getRoomNumber();
        assertEquals(101, roomNumber);
    }
    
    @Test
    public void testHotelID()
    {
        int rHotelID = room[0].getHotel().getHotelID();
        assertEquals(hotelID, rHotelID);
    }
}
