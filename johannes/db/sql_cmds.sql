INSERT INTO HOTELS (Name, City, Address)
VALUES ('Hotel Somewhere', 'Somewhere City', 'Somewherestreet');

SELECT Name, HotelID, RoomID
FROM HOTELS, ROOMS
WHERE City = 'Reykjavík' AND
    HotelID = rHotelID AND 
    RoomID NOT IN
        (SELECT oRoomID
        FROM OCCUPANCY
        WHERE oCheckIn >= date('2020-03-30') AND
            oCheckOut < date('2020-04-05'))
    GROUP BY RoomID;

-- Öll bókuð herbergi
-- frá 2020-03-30
-- til 2020-04-05 
SELECT *
FROM OCCUPANCY  
WHERE oCheckIn >= date('2020-03-30') AND
    oCheckOut < date('2020-04-05');

SELECT RoomID, Name, City 
FROM HOTELS, ROOMS
WHERE HotelID = rHotelID AND
    RoomID IN
        (SELECT oRoomID
        FROM OCCUPANCY 
        WHERE oCheckIN >= date('2020-03-30') AND
            oCheckOut < date('2020-04-05'));

SELECT * FROM HOTELS WHERE City = 'Somewhere City';

DELETE FROM HOTELS WHERE Name = 'Hotel Somewhere'; 
