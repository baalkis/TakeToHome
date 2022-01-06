# TakeToHome

## _creditcard Service_

Spring Boot REST API for credit card processing This Api should allow to add new credit card accounts and view them as a list.  

 REST Endpoints was be implemented  

 “SaveCreditcard" will create a new credit card for a given cardNum,name,email, securityCode, expiration, maxCredit, availableCredit and status
Card numbers are be validated using Mod 10 algorithm (Hand code , didn’t use a library)  
New cards start with a £0 balance
for cards not compatible with Mod 10 , return an error  
 "GetByName" returns all cards in the system for the user name given  

 "Get all" returns all cards in the system    

Use an in-memory DB to store the information while the API is running, so that it can store the credit card information  

Don’t achieve yet : Create a pattern given in Card_Type class to differentiate between Visa_Card and Master_Card  
Validation  
   - All input and output will be JSON  
   - Credit card numbers may vary in length, up to 19 characters  
   - Credit card numbers will always be numeric  

## _User Service_  

Spring Boot REST API for User credit card ,This Api should allow to add new User credit card accounts and view them as a list.  
 Two REST Endpoints was be implemented  
 “SaveUser" will create a new User for a given name,email and password  
email is verified   
 Name can't be empty   
 Accept strong password  
 "Get credit card for specific user " returns all cards in the system for this user passed in path  

Don’t achieve yet : users can manage their credit cards  
Validation  
    -All input and output will be JSON  
