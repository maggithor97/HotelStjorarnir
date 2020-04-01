import java.sql.*;
import java.sql.DriverManager;
import org.junit.*;
import static org.junit.Assert.*;

public class TestHotelDB
{
    private HotelDB hotelDB;

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

        hotelDB = new HotelDB();
        hotelDB.findHotel("Somewhere City");
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
        assertEquals("Hotel Somewhere", hotelDB.getName());
    }

    @Test 
    public void testWrongName()
    {
        assertEquals("Hotel Nowhere", hotelDB.getName());
    }

    @Test
    public void testCity()
    {
        assertEquals("Somewhere City", hotelDB.getCity());
    }

    @Test
    public void testWrongCity()
    {
        assertEquals("Nowhere City", hotelDB.getName());
    }

    @Test
    public void testAddress()
    {
        assertEquals("Somewhere Street", hotelDB.getAddress());
    }

    @Test
    public void testWrongAddress()
    {
        assertEquals("Nowhere Street", hotelDB.getAddress());
    }

    @Test
    public void testWrongParam()
    {
        assertEquals(1000, hotelDB.getName());
    }
}
