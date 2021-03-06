import hs.res.*;
import hs.db.*;
import java.util.*;
import java.sql.*;
import java.sql.DriverManager;
import org.junit.*;
import static org.junit.Assert.*;

public class TestDB
{
    private HotelDB hotelDB; 
    private ArrayList<Hotel> hotel_v; 
    private ArrayList<Hotel> hotel_o; 
    private ArrayList<Room> room_v;   
    private ArrayList<Room> room_o;   
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
            
            // We start by inserting our test hotel into 
            // the database, placing it in the HOTEL 
            // table.
            Statement stmt = conn.createStatement();
            String s = "INSERT INTO HOTELS (Name, City, Address) " + 
                       "VALUES ('Hotel Somewhere', " + 
                       "'Somewhere City', 'Somewhere Street')";
            stmt.executeUpdate(s);
            stmt = null;

            // Now that our test hotel has been placed in
            // the database, we need to get its hotelID,
            // which is generated by defining the 
            // PRIMARY KEY as an INTEGER and AUTOINCREMENT-ing 
            // it every time a new row is added to the table.
            // We'll use it when inserting a test room in the
            // next step.
            stmt = conn.createStatement();
            s = "SELECT HotelID FROM HOTELS WHERE City = 'Somewhere City'";
            ResultSet rs = stmt.executeQuery(s);
            hotelID = rs.getInt(1); 
            stmt = null;
            rs = null;

            // With the hotelID in hand, we insert our
            // test room into the ROOMS table.
            stmt = conn.createStatement();
            s = "INSERT INTO ROOMS (RoomType, RoomNum, rHotelID, Price) " +
                "VALUES ('2-bedroom', 101, " + hotelID + ", 20000)";
            stmt.executeUpdate(s);
            stmt = null;

            // Again we'll need to fetch an ID, this time
            // the newly created roomID, generated in the 
            // same manner as the hotelID described earlier.
            // We'll use the roomID in the next step.
            stmt = conn.createStatement();
            s = "SELECT RoomID FROM ROOMS WHERE rHotelID = " + hotelID;
            rs = stmt.executeQuery(s);
            roomID = rs.getInt(1);
            stmt = null;
            rs = null;

            // Finally, we insert check in and check out dates
            // into the OCCUPANCY table, booking our room, by
            // using the roomID, at some arbitrary time. 
            stmt = conn.createStatement();
            s = "INSERT INTO OCCUPANCY (oRoomID, oCheckIn, oCheckOut)" + 
                "VALUES (" + roomID + ", '2020-04-01', '2020-04-07')";
            stmt.executeUpdate(s);
            stmt = null;
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

        // Now, we can create an instance of 
        // our hotel database class that'll 
        // fetch the data we just entered into
        // the database and create an array
        // of hotel objects, where every 
        // hotel object in the array contains
        // an array of room objects. In our
        // case, the hotel array should only
        // contain 1 hotel and its room array
        // should only contain 1 room.

        // First we'll search for a hotel at a time we know
        // the room isn't occupied.  
        hotelDB = new HotelDB("Somewhere City", "2020-04-07", 
                              "2020-04-15", "2-bedroom");

        hotel_v = hotelDB.getHotels();
        room_v = hotel_v.get(0).getRooms(); 

        hotelDB = null;
       
        // Now we'll search for a hotel when we know 
        // the room is occupied.
        hotelDB = new HotelDB("Somewhere City", "2020-04-06",
                              "2020-04-15", "2-bedroom");
        
        hotel_o = hotelDB.getHotels();
        room_o = hotel_o.get(0).getRooms();

        hotelDB = null;
    }

    @After
    public void tearDown()
    {
        Connection conn = null;
        try
        {
            String url = "jdbc:sqlite:hotels.db";
            conn = DriverManager.getConnection(url);

            // Now that we're done, remove the test
            // hotel from the database ...
            Statement stmt = conn.createStatement();
            String s = "DELETE FROM HOTELS WHERE Name = 'Hotel Somewhere'";
            stmt.executeUpdate(s);
            stmt = null;

            // ... and the test room ...
            stmt = conn.createStatement();
            s = "DELETE FROM ROOMS WHERE RoomID = " + roomID;
            stmt.executeUpdate(s);
            stmt = null;

            // ... and the test dates. 
            stmt = conn.createStatement();
            s = "DELETE FROM OCCUPANCY WHERE oRoomID = " + roomID;
            stmt.executeUpdate(s);
            stmt = null;
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
    
        hotel_v = null;
        hotel_o = null;
        room_v = null;
        room_o = null;
    } 

    // Now, the tests. We'll start with the vacant
    // instance of the hotel and then move on to 
    // the occupied one.

    // We want to make sure that the array of hotels
    // returned by our hotel database class only
    // contains the test hotel we placed in the
    // table for this test. Therefore, it should
    // be of length 1, exactly. 
    @Test
    public void testHotels_v()
    {
        assertEquals(1, hotel_v.size());
    }

    // Lets make sure the name matches ...
    @Test
    public void testName_v()
    {
        String name = hotel_v.get(0).getName();
        assertEquals("Hotel Somewhere", name);
    }

    // ... and the city ...
    @Test
    public void testCity_v()
    {
        String city = hotel_v.get(0).getCity();
        assertEquals("Somewhere City", city);
    }

    // ... and the address.
    @Test
    public void testAddress_v()
    {
        String address = hotel_v.get(0).getAddress();
        assertEquals("Somewhere Street", address);
    }

    // Here we also expect the room array, within
    // the hotel object, to be of length 1, since
    // we only inserted 1 room with a matching 
    // hotelID into the ROOMS table. 
    @Test
    public void testRooms_v()
    {
        assertEquals(1, room_v.size());
    }

    // Lets also make sure things match up in the
    // room object. Does the room type match?
    @Test
    public void testRoomType_v()
    {
        String roomType = room_v.get(0).getRoomType();
        assertEquals("2-bedroom", roomType);
    }

    // And the room number?
    @Test
    public void testRoomNumber_v()
    {
        int roomNumber = room_v.get(0).getRoomNumber();
        assertEquals(101, roomNumber);
    }

    // And the room price?
    @Test
    public void testPrice_v()
    {
        int price = room_v.get(0).getPrice();
        assertEquals(20000, price);
    }

    // And the roomID?
    @Test
    public void testRoomID_v()
    {
        assertEquals(roomID, room_v.get(0).getRoomID());
    }

    // This one is a bit tricky. Since every
    // room object contains a reference to
    // the hotel object which the room belongs
    // to, we should make sure that the hotel
    // object that the room refers to is indeed
    // the same hotel object that contains
    // the array that contains the room itself.
    @Test
    public void testRoomsInHotelInRoom()
    {
        // Lets fetch the hotel referenced in our room.
        Hotel hotelInRoom = room_v.get(0).getHotel();
        // Now we'll get the room array within that
        // hotel.
        ArrayList<Room> roomsInHotelInRoom = hotelInRoom.getRooms();
        // The first item in the array should be the
        // same room object we started with. 
        assertEquals(room_v.get(0), roomsInHotelInRoom.get(0));
    }

    // Okay. At this point most of the work is done.
    // We just need to check the occupied instance
    // of the hotel.

    // This should be the same as for the vacant
    // instance ...
    @Test
    public void testHotels_o()
    {
        assertEquals(1, hotel_o.size());
    }

    // ... and this ...
    @Test
    public void testName_o()
    {
        String name = hotel_o.get(0).getName();
        assertEquals("Hotel Somewhere", name);
    }

    // ... and this ...
    @Test
    public void testCity_o()
    {
        String city = hotel_o.get(0).getCity();
        assertEquals("Somewhere City", city);
    }

    // ... and this.
    @Test
    public void testAddress_o()
    {
        String address = hotel_o.get(0).getAddress();
        assertEquals("Somewhere Street", address);
    }

    // Not this, though. Since there are no vacant
    // rooms, the array within the hotel object should
    // be of length 0. 
    @Test
    public void testRooms_o()
    {
        assertEquals(0, room_o.size());
    }
}
