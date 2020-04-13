import java.util.*;
import hs.res.*;
import hs.db.*;

public class Testing
{
    public static void main(String[] args)
    {
        HotelDB hotelDB = new HotelDB("Reykjavík", "2020-04-12", "2020-04-20", "2-bedroom");     
        ArrayList<Hotel> hotel = hotelDB.getHotels();
        for (int i = 0; i < hotel.size(); i++)
        {
            String s = "%-25s";
            System.out.printf(s, hotel.get(i).getName());
            System.out.printf(s, hotel.get(i).getCity());
            System.out.printf(s, hotel.get(i).getAddress());
            System.out.printf(s + "\n", hotel.get(i).getHotelID());
        } 

        for (int i = 0; i < hotel.size(); i++)
        {
            ArrayList<Room> room = hotel.get(i).getRooms();
            for (int j = 0; j < room.size(); j++)
            {
                String s = "%-18s";
                if (j == 0)
                {
                    System.out.printf(s, room.get(j).getHotel().getName());
                    System.out.printf(s, room.get(j).getHotel().getCity());
                    System.out.printf(s, room.get(j).getHotel().getAddress());
                    System.out.println();
                }
                System.out.printf(s, room.get(j).getPrice());
                System.out.printf(s, room.get(j).getRoomID());
                System.out.printf(s, room.get(j).getRoomNumber());
                System.out.printf(s, room.get(j).getRoomType());
                System.out.println();
            }
            System.out.println();
        }
    }
}
