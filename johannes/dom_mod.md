# Classes

## Hotel

```
+-------------+
|  Hotel      |
+-------------+
| -hotelType  |
| -hotelId    |
| -room[]     |
| -starRating |
| -location   |
| -filters    |
+-------------+
```

## Room

```
+----------------+
|  Room          |
+----------------+
| -roomType      |
| -roomId        |
| -pricePerNight |
| -hotelId       |
| -filters       |
+----------------+
```

## Booking

```
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
```

## User

```
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
```

## Availability

```
+----------------+
|  Availability  |
+----------------+ 
| -roomId[]      |
| -checkIn       |
| -checkOut      |
| -hotelId       |
| -location      |
+----------------+
```
