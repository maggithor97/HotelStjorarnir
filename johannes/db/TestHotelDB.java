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

        hotelDB = new HotelDB("Somewhere City");
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
        Hotel[] hotel = hotelDB.getHotels();
        String name = hotel[0].getName();
        assertEquals("Hotel Somewhere", name);
    }

    @Test
    public void testCity()
    {
        Hotel[] hotel = hotelDB.getHotels();
        String city = hotel[0].getCity();
        assertEquals("Somewhere City", city);
    }

    @Test
    public void testAddress()
    {
        Hotel[] hotel = hotelDB.getHotels();
        String address = hotel[0].getAddress();
        assertEquals("Somewhere Street", address);
    }
}
