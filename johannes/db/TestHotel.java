import org.junit.*;
import static org.junit.Assert.*;

public class TestHotel
{
    private Hotel someHotel;

    @Before
    public void setUp()
    {
        someHotel = new Hotel(1, "Hotel Somewhere", "Somewhere City", "Somewhere street");
    }

    @After
    public void tearDown() 
    {
        someHotel = null;
    }

    @Test
    public void testName()
    {
        assertEquals("Hotel Somewhere", someHotel.getName());
    }

    @Test
    public void testCity()
    {
        assertEquals("Somewhere City", someHotel.getCity());
    }

    @Test
    public void testAddress()
    {
        assertEquals("Somewhere street", someHotel.getAddress());
    }
    
}
