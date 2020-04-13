import java.sql.*;

public class HotelDB
{
    private Hotel[] hotel;
    private int numberOfHotels;

    public HotelDB (String City, String CheckIn, 
                    String CheckOut, String RoomType)
    {
        Connection conn = null;
        try
        {
            String url = "jdbc:sqlite:hotels.db";
            conn = DriverManager.getConnection(url);

            String s = "SELECT COUNT(1) FROM HOTELS WHERE City = ?";
            PreparedStatement pstmt = conn.prepareStatement(s);
            pstmt.setString(1, City);
            ResultSet rs = pstmt.executeQuery();
            numberOfHotels = rs.getInt("COUNT(1)");
            hotel = new Hotel[numberOfHotels];
            pstmt = null;

            s = "SELECT HotelID, Name, City, Address " + 
                "FROM HOTELS WHERE City = ?";
            pstmt = conn.prepareStatement(s);
            pstmt.setString(1,City);
            rs = pstmt.executeQuery();
                    
            int i = 0;
            while(rs.next() && i < numberOfHotels)
            {
                int hotelID = rs.getInt(1);
                String name = rs.getString(2);
                String city = rs.getString(3);
                String addr = rs.getString(4);
            
                hotel[i] = new Hotel(hotelID,name,city,addr);

                RoomDB roomDB = new RoomDB(CheckIn, CheckOut, 
                                           RoomType, hotel[i]);
                hotel[i].setRooms(roomDB.getRooms());

                i++;
            }
            rs.close();
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
            catch(SQLException e)
            {
                System.err.println(e.getMessage());
            }
        }
    }
        
    public Hotel[] getHotels()
    {
        return this.hotel;
    }
}
