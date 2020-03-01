```
+-------------+
|  Hotel      |
+-------------+
| -hotelType  |
| -hotelId    |
| -room[]     |
| -booking[]  |
| -starRating |
| -location   |
| -filters    |
+-------------+

+----------------+
|  Room          |
+----------------+
| -roomType      |
| -roomId        |
| -roomCount     |
| -bedType       |
| -bedCount      |
| -pricePerNight |
| -hotelId       |
+----------------+

+-------------+
|  Booking    |
+-------------+
| -hotelId    |
| -roomId     |
| -checkIn    |
| -checkOut   |
| -bookingId  |
| -firstName  |
| -lastName   |
| -middleName |
| -email      |
| -hasPaid    |
+-------------+

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

+----------------+
|  Availability  |
+----------------+ 
| -roomId[]      |
| -checkIn       |
| -checkOut      |
| -hotelId       |
| -location      |
+----------------+
| +setDates      |
| +setHotel      |
| +setLocation   |
| +getRooms      |
+----------------+
```
