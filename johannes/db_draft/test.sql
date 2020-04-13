SELECT Name, RoomID, RoomType, RoomNum, rHotelID, Price
FROM HOTELS, ROOMS, OCCUPANCY
WHERE HotelID = 1 AND
      HotelID = rHotelID AND
      RoomID NOT IN
        (SELECT oRoomID
        FROM OCCUPANCY
        WHERE oCheckIn >= date('2020-03-30') AND
              oCheckIn < date('2020-04-05') OR
              oCheckOut > date('2020-03-30') AND
              oCheckOut < date('2020-04-05'))
        GROUP BY RoomID;

SELECT RoomID, Name, City, oCheckIn, oCheckOut
FROM HOTELS, ROOMS, OCCUPANCY
WHERE HotelID = 1 AND 
    HotelID = rHotelID AND
    RoomID IN
        (SELECT oRoomID
        FROM OCCUPANCY
        WHERE oCheckIn >= date('2020-03-30') AND
              oCheckIn < date('2020-04-05') OR
              oCheckOut > date('2020-03-30') AND
              oCheckOut < date('2020-04-05'))
    GROUP BY oCheckIn;
    --GROUP BY RoomID;

SELECT oRoomID, oCheckIn, oCheckOut
FROM OCCUPANCY
WHERE (oCheckIn >= date('2020-03-30') AND
       oCheckIn < date('2020-04-05')) OR
      (oCheckOut > date('2020-03-30') AND
       oCheckOut < date('2020-04-05'))
ORDER BY oRoomID;
