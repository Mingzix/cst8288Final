# cst8288 Final project
# High-Level Design For Food Wate Reduce Platform 


Team members: 

  Tao Chen
  
  Shuting Wang 
  
  Mingzi Xu 
  
  Zoe Zhou

 
CST8288_030 OOP with Design Patterns 2024 Winter Term 
​​ 


**Version History**

**Version #**  **Author**   **Modified Time**  

  Version 1.0 	Mingzi Xu 		2024/03/15  
  
  Version 1.2 	Zoe Zhou 		  2024/03/18  
  
  Version 1.3 	Tao Chen 		  2024/03/18  
  
  Version 1.4 	Shuting Wang 	2024/03/18  
  
  Version 2.0 	Zoe Zhou 		  2024/03/21  
  
  Version 2.1 	Shuting Wang 	2024/03/21  
  
  Version 2.2	  Tao Chen 		  2024/03/22  
  
  Version 2.3 	Mingzi Xu 		2024/03/22  


**Introduction**  

  This platform is dedicated to reducing food waste. Its goal is to tackle the global issue of food waste by offering a solution that links food retailers, consumers, and charitable organizations. A food waste reduction platform plays a crucial role in advancing sustainability, alleviating hunger, and fostering more robust food systems. It fosters cooperation among stakeholders throughout the food supply chain and promotes unified efforts to confront one of the most significant challenges of our era. 


**Targeted Audience** 

    Developers: Developers need to ensure the platform runs smoothly. 
    
    Consumers:  Food consumers want to purchase discounted food items, lower their cost of living and contribute to reducing food waste. 
    
    Project managers: Project managers need to ensure the platform addresses the needs of all stakeholders and maintains a positive impact on food waste reduction and community welfare. 
    
    Retailers:  Retailers are interested in managing their surplus food efficiently to reduce waste and potentially gain benefits by selling them at a discount price or by donating them for public goodwill. 
    
    Charitable organizations: Charitable organizations are interested in accessing surplus food to distribute to those in need, reducing their operational costs. 


**Scope**

  In Scope: Functional requirements 
  
    Users Registration and Authentication: Registration and authentication functionality for different users (retailers, consumers, charitable organizations). 
    
    Retailers: Inventory management, surplus food identification, and listing surplus food items for donation or sale. 
    
    Charitable Organization: Claiming food items listed by retailers and updating retailer inventory. 
    
    Consumers: Purchasing items listed by retailers at a discount rate and updating retailer inventory.   
    
    Surplus Food Alert: User subscription to receive alerts and automatic notifications for surplus food items.  
    
    Bonus Functionality: UserLogs Record

  
  Out of Scope: Any functionalities not mentioned in the project requirements. 
   
    UI/UX Design:  Detailed user interface or user experience design is not included. 
    
    Deployment Plan:  The deployment strategy or plan is not discussed. 
    
    Other functionalities: Other functionalities that are not mentioned in the scope. 


**Application Architecture** 


This Food Wate Platform uses the 3-Tier Architecture model, a common methodology in designing a scalable application. 


  _Presentation Layer_

    Responsible for interacting with users through a user-friendly interface. 
    
    Implements the Model-View-Controller (MVC) design pattern for separation of concerns. 
    
    Components: 
    
      User interface elements for user registration, login/logout, browsing surplus food items, and subscribing to surplus food alerts. 
      
      Views for displaying inventory management interfaces for retailers, claiming food interfaces for charitable organizations, and purchasing interfaces for consumers. 
  
  
  _Business Layer_
    
    Contains the core business logic and functionalities of the application. 
    
    Handles processing of user requests and orchestrates interactions between different components. 
    
    Implements various design patterns for scalability, maintainability, and extensibility. 
    
    Components: 
     
      User registration and authentication services. 
      
      Inventory management services for retailers, including adding new items, updating quantities, and identifying surplus food items. 
      
      Claiming food services for charitable organizations. 
      
      Purchasing services for consumers. 
      
      Surplus food alert services for notifying subscribed users about surplus food items. 

 
  _Database Layer_
  
    Stores and manages persistent data used by the application. 
    
    Utilizes a relational database management system (RDBMS) named "FWRP" for data storage and management. 
    
    Components: 
    
      Database schema (FWRP) containing tables/entities to store user information, inventory data, claimed food items, and subscription preferences. 
    
      Entity-Relationship Diagram (ERD) illustrating the relationships between different entities. 
      
      Physical/Logical Data Model outlining the structure of the database schema. 


**Main Components**

  User Management Component 
    
    Responsible for user registration, login, and authentication. 
    
    Manages user accounts and permissions. 
  
  Inventory Management Component 
  
    Handles inventory operations for retailers, such as adding, updating, and listing surplus food items. 
    
    Tracks item quantities, expiration dates, and availability status. 
  
  Claiming Food Component 
    
    Facilitates the process of charitable organizations claiming surplus food items. 
    
    Updates inventory records upon successful claims. 
  
  Purchasing Component 
  
    Enables consumers to purchase surplus food items listed by retailers at discounted rates. 
    
    Manages inventory updates after purchases. 
  
  Surplus Food Alert Component 
  
    Manages user subscriptions for receiving surplus food alerts based on location, communication method, and food preferences. 
    
    Sends automatic notifications to subscribed users when retailers list surplus food items. 


**Business Architecture** 

  User Management 

    Use Case 1: User Registration 
    
    Description: Allows users to create accounts on the platform by providing their name, email, password, and selecting the user type (retailers, consumers, or charitable organizations). 
    
    Use Case 2: User Login 
    
    Description: Allows registered users to log in to the platform using their credentials. 
    
    Use Case 3: User Logout 
    
    Description: Allows logged-in users to log out from their accounts. 

  
  Retailers 
  
    Use Case 4: Inventory Management 
    
    
    Description: Enables retailers to manage their inventory of food items, including adding new items, updating quantities, and setting expiration 
dates for each item. 
    
    Use Case 5: Surplus Food Identification 
   
    Description: Allows retailers to identify and flag surplus food items that are nearing expiration or are more than demanded. 
    
    Use Case 6: Listing Surplus Food Items 
    
    Description: Enables retailers to list surplus food items on the platform for donation or sale at a discounted price. 

  
  Charitable Organizations 
    
    Use Case 7: Claim Food 
   
    Description: Allows charitable organizations such as Food Banks/Missions to claim the food items listed by retailers available for donation. 
    
    Use Case 8: Update Inventory 
    
    Description: Updates the retailer's inventory accordingly once a particular food item is claimed by a Charitable Organization. 


  Consumers 
    
    Use Case 9: Purchase 
    
    Description: Allows consumers to purchase (not real transaction) the items listed by retailers at a given discount rate. 
    
    Use Case 10: Update Inventory 
    
    Description: Updates the retailer's inventory accordingly once a particular food item is purchased by a consumer. 

  
  Surplus Food Alert 
   
    Use Case 11: User Subscription 
    
    Description: Allows users to subscribe to receive surplus food alerts based on their location, communication method (email or phone), and food preferences. 
    
    Use Case 12: Automatic Notifications 
    
    Description: Sends automatic notifications via email or phone to subscribed users whenever retailers list surplus food items on the platform. 

  
  Bonus Functionality 
  
    Use Case 13: User log information 
    
    Description: Records user activities like login and logout events. It keeps track of each user's actions with details such as activity type, timestamp, and description.

    
**Detailed Design**
![UML class](https://github.com/Mingzix/cst8288Final/blob/main/UML%20class.png )

Class diagrams: https://github.com/Mingzix/cst8288Final/blob/main/UML%20class.png 

**Data Architecture**

ERD :


**Testing Model** 

  We will use JUnit to test our Java program since it provides a simple and effective way to write and run automated tests. 
   
    _Test Classes:_
    
    The classes in our program that will be tested are: 
    	
     Database Connection class 
    
     Food class 
    
     Login class 
    
     Subscription class 
    
     All implemented Service classes 
    
     TBD... 

 
**References**


 

**List of Figures**
  
  Class diagram: https://github.com/Mingzix/cst8288Final/blob/main/UML%20class.png 
  
  Database ERD: 

 

 

**GitHub Repository**
https://github.com/Mingzix/cst8288Final 
