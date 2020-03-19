import java.sql.*;

public class FindRooms
{
    public static void main (String[] args)
    {
        Connection conn = null;
        try
        {
            String url = "jdbc:sqlite:hotels.db";
            conn = DriverManager.getConnection(url);
            
            String s = 
                "SELECT COUNT(1) FROM ROOMS WHERE rHotelID = " +
                "(SELECT HotelID FROM HOTELS WHERE City = ?) " +
                "AND RoomID NOT IN " +
                "(SELECT oRoomID FROM OCCUPANCY " +
                "WHERE oCheckIn BETWEEN ? AND ? OR " +
                "oCheckOut BETWEEN ? AND ?)";
            
            PreparedStatement pstmt = conn.prepareStatement(s);

            String city = args[0];
            String checkIn = args[1];
            String checkOut = args[2];

            pstmt.setString(1, city);
            pstmt.setString(2, checkIn);
            pstmt.setString(3, checkOut);
            pstmt.setString(4, checkIn);
            pstmt.setString(5, checkOut);
            ResultSet rs = pstmt.executeQuery();

            System.out.println(rs.getInt("COUNT(1)"));
            /*
            while (rs.next())
            {
                System.out.print(rs.getInt("RoomID") + " ");
                System.out.print(rs.getString("RoomType") + " ");
                System.out.print(rs.getInt("RoomNum" ) + " ");
                System.out.print(rs.getInt("rHotelID") + " ");
                System.out.print(rs.getInt("Price") + " ");
                System.out.println();
            }*/
            rs.close();
        }
        catch (SQLException e) 
        {
            System.err.println(e);
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
                System.err.println(e);
            }
        }
    }
}
