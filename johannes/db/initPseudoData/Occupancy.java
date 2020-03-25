import java.sql.*;
import java.util.*;
import java.io.*;

public class Occupancy
{
    public static void init()
    {
        Connection conn = null;
        try
        {
            String url = "jdbc:sqlite:../hotels.db";
            conn = DriverManager.getConnection(url);
            PreparedStatement pstmt = conn.prepareStatement(
            "INSERT INTO OCCUPANCY (oRoomID, oCheckIn, " +
            "oCheckOut) VALUES (?,?,?)");

            Statement stmt = conn.createStatement();
            String s = "SELECT RoomID FROM ROOMS";
            ResultSet rs = stmt.executeQuery(s);
            ArrayList<Integer> roomID = new ArrayList<Integer>();

            while (rs.next())
            {
                roomID.add(rs.getInt("RoomID"));
            }

            rs.close();
            Random r = new Random();
            int numOfRoomIDs = roomID.size();
            try 
            {
                Scanner scanner = new Scanner(new File("list_of_dates"));
                StringTokenizer st;
                while (scanner.hasNextLine())
                {
                    String dates = scanner.nextLine();
                    st = new StringTokenizer(dates);
                    String checkIn = st.nextToken(";");
                    String checkOut = st.nextToken(";");

                    boolean looking = true;
                    int lim = 1;
                    while (looking && lim < numOfRoomIDs)
                    { 
                        int i = r.nextInt(numOfRoomIDs); 
                        String checkBooking = 
                            "SELECT COUNT(1) FROM OCCUPANCY WHERE " +
                            "oRoomID = " + i + " AND " +
                            "oCheckIn BETWEEN '" + checkIn + "' AND '" + checkOut + "' AND " +
                            "oCheckOut BETWEEN '" + checkIn + "' AND '" + checkOut + "'";
                        rs = stmt.executeQuery(checkBooking);
                        int isBooked = rs.getInt("COUNT(1)");
                        if (isBooked == 0)
                        {
                            pstmt.setInt(1, i);
                            pstmt.setString(2, checkIn); 
                            pstmt.setString(3, checkOut);
                            pstmt.executeUpdate();
                            looking = false;
                        }
                        lim++;
                    }
                }
            }
            catch (Exception e) { System.err.println(e.getMessage()); }
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
                {
                    conn.close();
                }
            }
            catch (Exception e) 
            { 
                System.err.println(e.getMessage()); 
            }
        }   
    }

    public static void main (String[] args) 
    {
        init();
    }
}
          
      
