import java.sql.*;

public class BookingDB
{
    private Booking booking;
    private int ref;

    public BookingDB (
            Room room, 
            String checkIn, 
            String checkOut,
            String fName, 
            String mName, 
            String lName,
            String email)
    {
        Connection conn = null;
        try
        {
            String url = "jdbc:sqlite:hotels.db";
            conn = DriverManager.getConnection(url);
            
            String s = "INSERT INTO BOOKINGS (bRoomID, " +
                       "CheckIn, CheckOut, FirstName, " +
                       "LastName, MiddleName, Email) "  +
                       "VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(s);
            
            pstmt.setInt(1, room.getRoomID());
            pstmt.setString(2, checkIn);
            pstmt.setString(3, checkOut);
            pstmt.setString(4, fName);
            pstmt.setString(5, mName);
            pstmt.setString(6, lName);
            pstmt.setString(7, email);

            pstmt.executeUpdate();
            pstmt = null;

            s = "INSERT INTO OCCUPANCY (oRoomID, " +
                "oCheckIn, oCheckOut) VALUES (?, ?, ?)";
            pstmt = conn.prepareStatement(s);

            pstmt.setInt(1, room.getRoomID());
            pstmt.setString(2, checkIn);
            pstmt.setString(3, checkOut);
            
            pstmt.executeUpdate();
            pstmt = null;

            s = "SELECT ReferenceNo FROM BOOKINGS " + 
                "WHERE bRoomID = ? AND " +
                "CheckIn = ? AND CheckOut = ?";
            pstmt = conn.prepareStatement(s);

            pstmt.setInt(1, room.getRoomID());
            pstmt.setString(2, checkIn);
            pstmt.setString(3, checkOut);
            
            ResultSet rs = pstmt.executeQuery();
            ref = rs.getInt(1);

            rs = null;
            pstmt = null;

            booking = new Booking(ref, room, checkIn, checkOut,
                            fName, mName, lName, email);            
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

    public BookingDB (int ref)
    {
        Connection conn = null;
        try
        {
            int hotelID;
            int roomID;

            String checkIn;
            String checkOut;
            String firstName;
            String middleName;
            String lastName;
            String email;

            String roomType;
            int roomNum;
            int price;

            String hotelName;
            String city;
            String addr;

            String url = "jdbc:sqlite:hotels.db";
            conn = DriverManager.getConnection(url);
           
            // Booking 
            String s = "SELECT * FROM BOOKINGS " +
                       "WHERE ReferenceNo = ?";
            PreparedStatement pstmt = conn.prepareStatement(s);
            pstmt.setInt(1, ref);
            ResultSet rs = pstmt.executeQuery();

            roomID     = rs.getInt(2);
            checkIn    = rs.getString(3);
            checkOut   = rs.getString(4);
            firstName  = rs.getString(5);
            middleName = rs.getString(6);
            lastName   = rs.getString(7);
            email      = rs.getString(8);

            pstmt = null;
            rs = null;

            // Room
            s = "SELECT * FROM ROOMS " +
                "WHERE RoomID = ?";
            pstmt = conn.prepareStatement(s);
            pstmt.setInt(1, roomID);
            rs = pstmt.executeQuery();

            roomType = rs.getString(2);
            roomNum  = rs.getInt(3);
            hotelID  = rs.getInt(4);
            price    = rs.getInt(5);

            pstmt = null;
            rs = null;

            // Hotel
            s = "SELECT * FROM HOTELS " +
                "WHERE hotelID = ?";
            pstmt = conn.prepareStatement(s);
            pstmt.setInt(1, hotelID);
            rs = pstmt.executeQuery();

            hotelName = rs.getString(2);
            city      = rs.getString(3);
            addr      = rs.getString(4);

            booking = new Booking(ref, hotelName, city, addr, roomNum,
                            roomType, checkIn, checkOut, firstName,
                            middleName, lastName, email);
        }            
        catch (Exception e) { }
    }

    public Booking getBooking()
    {
        return booking;
    }
}
