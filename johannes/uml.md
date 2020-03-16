```
+-------------+
|  Hotel      |
+-------------+
| -hotelType  |
| -name       |
| -room[]     |
| -starRating |
| -city       |
| -address    |
| -filters    |
+-------------+

+----------------+
|  Room          |
+----------------+
| -roomNumber    |
| -roomType      |
| -pricePerNight |
| -hotel         |
| -filters       |
+----------------+

+----------------+
|  Booking       |
+----------------+
| -hotel         |
| -room          |
| -checkIn       |
| -checkOut      |
| -bookingRef    |
| -firstName     |
| -lastName      |
| -middleName    |
| -email         |
+----------------+
| +getName       |
| +setName       |
| +getHotel      |
| +setHotel      |
| +getRoom       |
| +setRoom       |
| +setDates      |
| +getEmail      |
| +setEmail      |
| +getBookingRef |
+----------------+

+------------------+
|  User            |
+------------------+
| -firstName       |
| -lastName        |
| -middleName      |
| -discount        |
| -bookings[]      |
| -email           |
| -creditCardNo    |
| -password        |
+------------------+
| +getName         |
| +setName         |
| +getEmail        |
| +setEmail        |
| +hasDiscount     |
| +getDiscount     |
| +setDiscount     |
| +getBookings[]   |
| +getCreditCardNo |
| +setCreditCardNo |
| +getPassword     |
| +setPassword     |
+------------------+

+-------------+
|  Occupancy  |
+-------------+ 
| -roomId[]   |
| -checkIn    |
| -checkOut   |
+-------------+
```
