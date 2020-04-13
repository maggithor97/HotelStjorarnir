package hs.res;

import java.util.*;

public class Hotel 
{
    private int hotelID;
    private String name;
    private String city;
    private String address;
    private ArrayList<Room> room;

    /**
    *@param hotelID hotel's unique ID number
    *@param name name of hotel
    *@param city city where hotel is located
    *@param address street where hotel is located
    */
    public Hotel(int hotelID, String name, String city, String address) 
    {
        this.hotelID = hotelID;
        this.name = name;
        this.city = city;
        this.address = address;
    }

    /**
    *@return hotel's unique ID number
    */
    public int getHotelID()
    {
        return hotelID;
    }

    /**
    *@return name of hotel
    */
    public String getName() 
    {
        return this.name;
    }

    /**
    *@return city where hotel is located
    */
    public String getCity() 
    {
        return this.city;
    }

    /**
    *@return street where hotel is located
    */
    public String getAddress() 
    {
        return this.address;
    }

    /**
    *@param room rooms in hotel
    */ 
    public void setRooms(ArrayList<Room> room)
    {
        this.room = room;
    }
    
    /**
    *@return rooms in hotel
    */
    public ArrayList<Room> getRooms()
    {
        return this.room;
    }
}
