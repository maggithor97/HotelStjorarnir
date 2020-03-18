CREATE TABLE HOTELS (
    HotelID INTEGER PRIMARY KEY AUTOINCREMENT,
    Name    CHAR(100),
    City    CHAR(100),
    Address CHAR(100)
);

CREATE TABLE ROOMS (
    RoomID      INTEGER PRIMARY KEY AUTOINCREMENT,
    RoomType    CHAR(50),
    RoomNum     INTEGER,
    rHotelID    INTEGER,
    Price       INTEGER,
    FOREIGN KEY (rHotelID) REFERENCES HOTELS (HotelID)
);

CREATE TABLE OCCUPANCY (
    oRoomID     INTEGER,
    oCheckIn    DATE,
    oCheckOut   DATE,
    FOREIGN KEY (oCheckIn) REFERENCES BOOKING (CheckIn),
    FOREIGN KEY (oCheckOut) REFERENCES BOOKING (CheckOut),
    FOREIGN KEY (oRoomID) REFERENCES ROOM (RoomID),
    PRIMARY KEY (oRoomID, oCheckIn, oCheckOut)
);

CREATE TABLE BOOKING (
    ReferenceNo INTEGER PRIMARY KEY AUTOINCREMENT,
    bHotelID    INTEGER,
    bRoomID     INTEGER,
    CheckIn     DATE,
    CheckOut    DATE,
    FirstName   CHAR(100),
    LastName    CHAR(100),
    MiddleName  CHAR(100),
    Email       CHAR(100),
    HasPaid     BOOLEAN
);
