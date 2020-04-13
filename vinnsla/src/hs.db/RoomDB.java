package hs.db;

import java.util.*;
import java.sql.*;
import hs.res.*;

public class RoomDB
{
    private ArrayList<Room> room;

    /**
    *@param checkIn check in date, YYYY-MM-DD
    *@param checkOut check out date, YYYY-MM-DD
    *@param roomType 1-bed, 2-bed, 3-bed or Suite
    *@param hotel hotel that room is in
    */
    public RoomDB(String checkIn, String checkOut, 
                  String roomType, Hotel hotel)
    {
        room = new ArrayList<Room>();
        Connection conn = null;
        try
        {
            String url = "jdbc:sqlite:hotels.db";
            conn = DriverManager.getConnection(url);
        
            Statement stmt = conn.createStatement();            
            String s;
            s = "SELECT RoomID, RoomNum, Price " + 
                "FROM ROOMS, HOTELS " +
                "WHERE HotelID = " + hotel.getHotelID() + " AND " +
                "HotelID = rHotelID AND " + 
                "RoomID NOT IN " +
                "(SELECT oRoomID " +
                "FROM OCCUPANCY " +
                "WHERE oCheckIn >= date('" + checkIn + "') AND " +
                "oCheckIn < date('" + checkOut + "') OR " +
                "oCheckOut > date('" + checkIn + "') AND " +
                "oCheckOut < date('" + checkOut + "'))" +
                "GROUP BY RoomID";
            ResultSet rs = stmt.executeQuery(s);
            
            for (int i = 0; rs.next(); i++)
            {
                int roomID = rs.getInt(1);
                int roomNumber = rs.getInt(2);
                int price = rs.getInt(3);

                Room tmp = new Room(roomID, roomType, roomNumber, price, hotel);
                room.add(i, tmp);
            }
        }
        catch (Exception e) 
        { 
            room = new ArrayList<Room>();
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

    /**
    *@return list of available rooms of specified type in given hotel
    */
    public ArrayList<Room> getRooms()
    {
        return this.room;
    }
}
           
