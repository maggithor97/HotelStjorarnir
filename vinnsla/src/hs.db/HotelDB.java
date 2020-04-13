package hs.db;

import hs.res.*;
import java.util.*;
import java.sql.*;

public class HotelDB
{
    private ArrayList<Hotel> hotels;

    /**
    *@param city city where hotel is located 
    *@param checkIn check in date, YYYY-MM-DD
    *@param checkOut check out date, YYYY-MM-DD
    *@param roomType 1-bed, 2-bed, 3-bed or Suite
    */
    public HotelDB (String city, String checkIn, 
                    String checkOut, String roomType)
    {
        hotels = new ArrayList<Hotel>();
        Connection conn = null;
        try
        {
            String url = "jdbc:sqlite:hotels.db";
            conn = DriverManager.getConnection(url);
        
            String s = "SELECT HotelID, Name, Address " + 
                       "FROM HOTELS WHERE City = ?";
            PreparedStatement pstmt = conn.prepareStatement(s);
            pstmt = conn.prepareStatement(s);
            pstmt.setString(1,city);
            ResultSet rs = pstmt.executeQuery();
                    
            for (int i = 0; rs.next(); i++)
            {
                int hotelID = rs.getInt(1);
                String name = rs.getString(2);
                String addr = rs.getString(3);
            
                Hotel hotel = new Hotel(hotelID, name, city, addr);
                RoomDB roomDB = new RoomDB(checkIn, checkOut, roomType, hotel);
                hotel.setRooms(roomDB.getRooms());
                hotels.add(i, hotel);
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
        
    /**
    *@return hotels with available rooms of specified type in given city
    */
    public ArrayList<Hotel> getHotels()
    {
        return this.hotels;
    }
}
