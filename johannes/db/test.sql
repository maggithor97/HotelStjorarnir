DROP TABLE O;

-- Finds booked rooms on given dates
CREATE TEMPORARY TABLE O AS 
    SELECT ocRoomID
    FROM Occupancy
    WHERE CheckIn BETWEEN '20200504' AND '20200515' OR 
          CheckOut BETWEEN '20200504' AND '20200514';

SELECT *
FROM O;

DROP TABLE R;

-- Find rooms of given type 
-- in a given location
CREATE TEMPORARY TABLE R AS
    SELECT * 
    FROM ROOMS
    WHERE RoomType = '2-bedroom' AND
          rHotelID IN
          (SELECT HotelID
           FROM Hotels
           WHERE City = 'Reykjavík');

-- Available rooms from R
SELECT *
FROM R
WHERE RoomID NOT IN O;
