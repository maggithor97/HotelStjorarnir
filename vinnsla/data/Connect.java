import java.sql.Connection;
import java.io.File;
import java.sql.*;
import java.util.*;
import java.util.Scanner;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connect 
{
    public static void init() 
    {
        Connection conn = null;
        try
        {
            String url = "jdbc:sqlite:../hotels.db";
            conn = DriverManager.getConnection(url);
            Statement stmt = conn.createStatement();
            PreparedStatement pstmt = conn.prepareStatement(
                    "INSERT INTO HOTELS (Name, City, Address) " +
                    "VALUES (?,?,?)");
            PreparedStatement pstmt2 = conn.prepareStatement(
                    "INSERT INTO ROOMS (RoomType, RoomNum, rHotelID, Price) " +
                    "VALUES (?,?,?,?)");
            try 
            {
                Scanner listOfHotels = new Scanner(new File("list_of_hotels"), "UTF-8");
                StringTokenizer st;
                while (listOfHotels.hasNextLine())
                {
                    String path = listOfHotels.nextLine();
                    Scanner hotel = new Scanner(new File(path), "UTF-8");
                    String s = hotel.nextLine();
                    
                    st = new StringTokenizer(s);
                    String name = st.nextToken(";");
                    String city = st.nextToken(";");
                    String addr = st.nextToken(";");
                    
                    pstmt.setString(1, name);
                    pstmt.setString(2, city);
                    pstmt.setString(3, addr);
                    pstmt.executeUpdate();
                    
                    String sel = "SELECT HotelID " + 
                                 "FROM HOTELS " +
                                 "WHERE Name = '" + name + "' AND " +
                                 "City = '" + city + "' AND " + 
                                 "Address = '" + addr + "'";

                    ResultSet rs = stmt.executeQuery(sel);
                    int hotelID = Integer.parseInt(rs.getString("HotelID"));
                    while (hotel.hasNextLine())
                    {
                        s = hotel.nextLine();

                        st = new StringTokenizer(s);
                        String roomType = st.nextToken(";");
                        int roomNum = Integer.parseInt(st.nextToken(";"));
                        int price = Integer.parseInt(st.nextToken(";"));

                        pstmt2.setString(1, roomType);
                        pstmt2.setInt(2, roomNum);
                        pstmt2.setInt(3, hotelID);
                        pstmt2.setInt(4, price);
                        pstmt2.executeUpdate();
                    }
                }
            }
            catch (Exception e) 
            {      
                System.err.println(e.getMessage()); 
            }
        }
        catch (SQLException e)
        {
            System.out.println(e.getMessage());
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
            catch (SQLException e) 
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
