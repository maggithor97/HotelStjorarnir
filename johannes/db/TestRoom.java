import org.junit.*;
import static org.junit.Assert.*;

public class TestRoom
{
    private Room room;

    @Before
    public void setUp()
    {
        Hotel hotel = new Hotel(1,"Hotel Somewhere","Somewhere City","Somewhere Street");
        room = new Room(1,"2-bedroom",101,20000,hotel);
    }

    @After 
    public void tearDown()
    {
        room = null;
    }

    @Test
    public void testRoomID()
    {
        assertEquals(1,room.getRoomID());
    }

    @Test
    public void testRoomType()
    {
        assertEquals("2-bedroom",room.getRoomType());
    }

    @Test
    public void testRoomNumber()
    {
        assertEquals(101,room.getRoomNumber());
    }

    @Test
    public void testPrice()
    {
        assertEquals(20000,room.getPrice());
    }

    @Test
    public void testHotelID()
    {
        assertEquals(1,room.getHotel().getHotelID());
    }

    @Test
    public void testHotelName()
    {
        assertEquals("Hotel Somewhere", room.getHotel().getName());
    }

    @Test
    public void testHotelCity()
    {
        assertEquals("Somewhere City", room.getHotel().getCity());
    }

    @Test
    public void testHotelAddress()
    {
        assertEquals("Somewhere Street", room.getHotel().getAddress());
    }
} 
