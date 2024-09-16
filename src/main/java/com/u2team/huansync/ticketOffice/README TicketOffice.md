
# TicketOffice

## Description
This module is responsible for creating ticket offices for specific events, since its objective is to register visitors and participants so that they can later be distributed in various activities, in addition to creating tickets for them. Finally, accounting reports are made such as the number of tickets sold in total.

## OOP (Object Oriented Programming)

We implement classes, interfaces and polymorphism.

### Classes

**1. [Customer.java](src\main\java\com\u2team\huansync\ticketOffice\client\model\classes\Customer.java)**

   This class manages the registration of clients that can arrive at an event and that can be divided by activities. Getters, Setters and attributes can be found like:

      - name:                       Client name
      - clientId:                   Client ID
      - gender:                     Gender of the person, it can be the one that the person themselves wants
      - birthdate:                  Date of birth of the person
      - email:                      Client's email
      - phoneNumber:                Customer's phone number
      - participationActivity:      Activity in which you participate
      - clientType:                 Type of client, if it is (Participant or Visitor)
   
**2. [TicketOffice.java](src\main\java\com\u2team\huansync\ticketOffice\model\classes\TicketOffice.java)**
   
   This class is responsible for registering a locker for a single event, in addition to confirming the status of the staff and that there is only one event per locker, which is why it is related to the Event and Staff class; They also have Getters, Setters and attributes like:

         - eventId:        ID of the event to be handled
         - location:       Yes or no option regarding the location of an event
         - address:        Complement of the above and if the previous one enters the code, it therefore has to write an address
         - contactNumber:  Write the contact number of the person
         - staffId:        ID of the staff that is going to work

**3. [Tickets.java](src\main\java\com\u2team\huansync\ticketOffice\tickets\model\classes\Tickets.java)**

   This class is responsible for selling tickets for the proposed activities, for which they will have an additional cost. It has attributes like.

         - ticketTypeId:         ID of the type of ticket you wish to purchase
         - price:                Default ticket cost, no additional cost
         - name:                 Ticket name
         - ageClassification:    Ages of those who can access a ticket
         - additionalCost:       Additional cost if you want to pay for activities
         - statusEnum:           It has various options that will be seen later.
         - peopleCapacity:       Capacity of people for an event
         - customerId:           Customer ID

### Enum

   You see some options for the Client class or in the Customer database such as:

   - [CustomerTypeEnum](src\main\java\com\u2team\huansync\ticketOffice\client\model\classes\CustomerTypeEnum.java):

      - PARTICIPANT("Is a participant")
      - VISITOR("Is a visitor")
      - WINNER("Is a winner")

   For the Tickets class its enum is like this:

   - [StatusEnum](src\main\java\com\u2team\huansync\ticketOffice\tickets\model\classes\StatusEnum.java):

      - RESERVED("It is reserved")
      - PAID("It is paid")

### Interfaces

   Interfaces such as **ParticipationBuilder** and **InterfaceAccountingDAO** are used to define contracts that classes must implement.

   Other interfaces were **TicketOfficeBuilder** and **IDao** by TicketOffice as such and finally, **TicketBuilder** and **TicketTypeDAO** were also used, in order to have greater control over how to call the CRUD and have everything separated according to responsibility.


## Design pattern

Creationals:

- Builder

We have worked with this design pattern because it can facilitate encapsulation, creation of objects and lastly, they can insert various objects and accept booleans.
 
Structural:

- Data Access Object (DAO)

It was applied in our DAO code since it separates the logic from data access, in addition to allowing us to make queries in a less complex and direct way.

## SOLID application 

We applied SOLID principles as the single responsibility since we divided folders if necessary and tried to leave the [classes] folders only for the main classes, in addition open/closed was also used to obtain greater clarity in the code and segregation of interfaces to have a specific interface for method control.


## Package Structure  
The Ticket Office source code is located at: *src\main\java\com\u2team\huansync\ticketOffice* and the file structure is:


**[TicketOffice](src\main\java\com\u2team\huansync\ticketOffice)**
   - [Accounting](src\main\java\com\u2team\huansync\ticketOffice\accounting)
      - controller
      - model
         - classes
         - DAO
   - [Client](src\main\java\com\u2team\huansync\ticketOffice\client)
      - controller
      - model
         - classes
            - builders
         - DAO
   - [Controller](src\main\java\com\u2team\huansync\ticketOffice\controller)
   - [img](src\main\java\com\u2team\huansync\ticketOffice\img)
   - [Model](src\main\java\com\u2team\huansync\ticketOffice\model)
      - builders
      - classes
      - DAO
      - util
   - [Participation](src\main\java\com\u2team\huansync\ticketOffice\participation)
      - controller
      - model
         - classes
            - builders
         - DAO
   - [Tickets](src\main\java\com\u2team\huansync\ticketOffice\tickets)
      - controller
      - model
         - classes
            - builders
         - DAO
         - util
      - ticketType
         - controller
         - model
            - classes
            - DAO

### Class Diagram

![Class Diagram](/src/main/java/com/u2team/huansync/ticketOffice/img/UML.jpg)