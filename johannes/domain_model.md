 Hotel      
------------
- hotelType  
- hotelId    
- room[]     
- starRating 
- location   
- filters    

 Room          
---------------
-- roomType      
-- roomId        
-- roomCount     
-- bedType       
-- bedCount      
-- pricePerNight 
-- hotelId       
-- filters       

 Booking    
------------
-hotelId    
-roomId     
-checkIn    
-checkOut   
-bookingId  
-firstName  
-lastName   
-middleName 
-email      
-hasPaid    

 User            
-----------------
-firstName       
-lastName        
-middleName      
-discount        
-bookings[]      
-email           
-creditCardNo    
-password        

Availability
------------
-roomId[]   
-checkIn    
-checkOut   
-hotelId    
-location   
