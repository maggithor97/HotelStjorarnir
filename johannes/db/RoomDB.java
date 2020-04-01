import java.sql.*;

public class RoomDB
{
    private Room[] room;
    private int numberOfRooms;

    public RoomDB(Hotel hotel)
    {
        Connection conn = null;
        try
        {
            String url = "jdbc:sqlite:hotels.db";
            conn = DriverManager.getConnection(url);
            Statement stmt = conn.createStatement();
            String s = "SELECT COUNT(1) FROM ROOMS " +
                       "WHERE rHotelID = " + hotel.getHotelID();

            ResultSet rs = stmt.executeQuery(s);
            numberOfRooms = rs.getInt(1);
            room = new Room[numberOfRooms];
            rs = null;
            stmt = null;

            stmt = conn.createStatement();            
            s = "SELECT RoomID, RoomType, " + 
                "RoomNum, Price " + 
                "FROM ROOMS " + 
                "WHERE rHotelID = " + hotel.getHotelID();
            rs = stmt.executeQuery(s);
            
            int i = 0;
            while(rs.next() && i < numberOfRooms)
            {
                int roomID = rs.getInt(1);
                String roomType = rs.getString(2);
                int roomNumber = rs.getInt(3);
                int price = rs.getInt(4);

                room[i] = new Room(roomID, roomType, roomNumber, price, hotel);
                i++;
            }
        }
        catch (Exception e) 
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
            catch (Exception e)
            { 
                System.err.println(e.getMessage()); 
            }
        }
    }

    public Room[] getRooms()
    {
        return this.room;
    }
}
           
