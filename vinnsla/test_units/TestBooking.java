import hs.res.*;
import hs.db.*;
import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;

public class TestBooking
{
    private Booking booking;
    private Room room;
    private Hotel hotel;
    
    @Before
    public void setUp()
    {
        hotel = new Hotel(1, "Hotel Somewhere", "Somewhere City", "Somewhere Street");
        room = new Room(1, "2-bedroom",101,20000,hotel);
        ArrayList<Room> rooms = new ArrayList<Room>();
        rooms.add(room);
        hotel.setRooms(rooms);
        booking = new Booking(2, room, "2020-04-04", "2020-04-15", 
                              "John", "", "Doe", "joedoe@email.com");
    }

    @After
    public void tearDown()
    {
        booking = null;
        room = null;
    }

    @Test
    public void testRef()  
    {
        assertEquals(2,booking.getReferenceNumber());
    }

    @Test
    public void testHotelName()
    {
        assertEquals("Hotel Somewhere", booking.getHotel());
    }

    @Test
    public void testHotelCity()
    {
        assertEquals("Somewhere City", booking.getCity());
    }

    @Test
    public void testHotelAddress()
    {  
        assertEquals("Somewhere Street", booking.getAddress());
    }

    @Test 
    public void testRoomNumber()
    {
        assertEquals(101, booking.getRoomNumber());
    }

    @Test
    public void testRoomType()
    {
        assertEquals("2-bedroom", booking.getRoomType());
    }

    @Test
    public void testCheckIn()
    {
        assertEquals("2020-04-04", booking.getCheckIn());
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
        assertEquals("joedoe@email.com", booking.getEmail());
    }

}
