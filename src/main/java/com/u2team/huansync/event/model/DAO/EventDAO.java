package com.u2team.huansync.event.model.DAO;

import com.u2team.huansync.event.DAO.*;
import com.u2team.huansync.event.model.classes.EventStaffFull;
import com.u2team.huansync.event.model.classes.builders.EventBuilder;
import com.u2team.huansync.event.model.classes.builders.EventConcreteBuilder;
import com.u2team.huansync.event.model.classes.Event;
import com.u2team.huansync.event.model.util.Validations;
import com.u2team.huansync.event.staff.model.classes.Staff;
import com.u2team.huansync.persistence.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Christian Pardo
 *
 * EventDao =  implements abstract methods of iDao (interface)
 */
public class EventDAO implements IGetByIdDao<Event>, IGetAllDao<Event>, ISaveDao<Event>, IUpdateDao<Event>, IDeleteDao<Event>, IGetAllFull<EventStaffFull> {

    /**
     * Retrieves an event from the database based on its unique identifier (ID).
     * This method queries the database to retrieve an event with the specified ID. It establishes
     * a connection with the database, prepares a SELECT query, and executes the query with the provided
     * ID. If the query returns a result, it constructs an Event object using a builder pattern and returns
     * the populated object. If no result is found, an error message is printed to the console, and the
     * method returns null.
     *
     * @param id The unique identifier of the event to be retrieved.
     * @return An Event object representing the retrieved event, or null if the ID is not found in the database.
     */
    @Override
    public Event getById(long id) {

        //Class Operations are used to configure the connection with database and send a Query saved in variable stm
        Operations.setConnection(BDConnection.MySQLConnection());
        String stm = "SELECT * FROM tbl_events where eventId = ?;";

        //ps (prepareStatement) receives stm and replaces "?" for the variable with the index: "1" with "id"
        try (PreparedStatement ps = Operations.getConnection().prepareStatement(stm)) {
            ps.setLong(1, id);

            // The result of the query is saved in the "rs" variable to apply logic.
            ResultSet rs = Operations.query_db(ps);

            // rs.next() -> Means if there is an answer, execute logic
            if (rs.next()) {

                // Create builder with concrete Builder -> (Concrete builder creates the object step by step)
                EventBuilder eventBuilder = new EventConcreteBuilder();

                // Creates an event object and use eventBuilder for constructs it using the information from the query(rs) (field by field)
                Event sqlEvent = eventBuilder.eventId(rs.getLong("eventId"))
                        .nameEvent(rs.getString("nameEvent"))
                        .country(rs.getString("countryEvent"))
                        .city(rs.getString("cityEvent"))
                        .address(rs.getString("addressEvent"))
                        .peopleCapacity(rs.getInt("peopleCapacity"))
                        .storeCapacity(rs.getInt("storeCapacity"))
                        .restaurantCapacity(rs.getInt("restaurantCapacity"))
                        .dateEvent(LocalDate.parse(rs.getString("dateEvent")))
                        .timeEvent(LocalTime.parse(rs.getString("timeEvent")))
                        .organizerId(rs.getLong("organizerId"))
                        .ageClassificationEnum(rs.getString("ageClassification"))
                        .statusEnum(rs.getString("statusEvent"))
                        // Build object
                        .build();

                //return contructed object sqlEvent
                return sqlEvent;
            } else {
                System.out.println("ERROR: The id has not been found");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //Return null always because this method should return something
        return null;
    }

    /**
     * Retrieves a list of all events from the database.
     * This method establishes a connection to the MySQL database, executes a SELECT query
     * to fetch all events from the 'tbl_events' table, and constructs a list of Event objects
     * based on the retrieved data.
     *
     * @return A list of Event objects representing all events in the database.
     */
    @Override
    // Method: Brings a list of all registered events
    public List<Event> getAll() {

        // Create a list for events
        List<Event> eventList = new ArrayList<>();

        // Class Operations are used to configure the connection with database and send a Query saved in variable stm
        Operations.setConnection(BDConnection.MySQLConnection());
        String stm = "SELECT * FROM tbl_events";

        //ps (prepareStatement) receives stm and execute the query and save in "rs" variable.
        try (PreparedStatement ps = Operations.getConnection().prepareStatement(stm)) {
            ResultSet rs = Operations.query_db(ps);

            // As long as there is a row of data in the query, it will execute:
            while (rs.next()) {

                // Create builder with concrete Builder -> (Concrete builder creates the object step by step)
                EventBuilder eventBuilder = new EventConcreteBuilder();

                // Creates an event object and constructs it using the information from the query(rs) (field by field)
                Event sqlEvent = eventBuilder.eventId(rs.getLong("eventId"))
                        .nameEvent(rs.getString("nameEvent"))
                        .country(rs.getString("countryEvent"))
                        .city(rs.getString("cityEvent"))
                        .address(rs.getString("addressEvent"))
                        .peopleCapacity(rs.getInt("peopleCapacity"))
                        .storeCapacity(rs.getInt("storeCapacity"))
                        .restaurantCapacity(rs.getInt("restaurantCapacity"))
                        .dateEvent(LocalDate.parse(rs.getString("dateEvent")))
                        .timeEvent(LocalTime.parse(rs.getString("timeEvent")))
                        .organizerId(rs.getLong("organizerId"))
                        .ageClassificationEnum(rs.getString("ageClassification"))
                        .statusEnum(rs.getString("statusEvent"))
                        // Build object
                        .build();
                // Add each new object into the list "eventList"
                eventList.add(sqlEvent);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        // Returns the list with objects inside
        return eventList;
    }

    @Override
    /**
     * Saves an event to the database.
     * This method validates the date to ensure it is between 1 to 7 days in advance,
     * checks for repeated 'nameEvent' in the 'tbl_events' table, and inserts the event
     * information into the database.
     *
     * @param event The Event object to be saved to the database.
     */
    public void save(Event event) {

        // Use Validations Class with LocalTime Library with apply the conditions of exercise. (create an event within 1 to 7 days in advance)
        boolean validDate = Validations.dateBetween(LocalDate.now(), event.getDateEvent(), 1, 7);

        if (!validDate) {
            System.out.println("Invalid date");
            return;
        }

        // Use validation class with counterRepeated method.
        int repeated = Validations.counterRepeated("tbl_events", "nameEvent", "asdasdasd");
        if (repeated != 0) {
            System.out.println("nameEvent repeated");
            return;
        }

        // Create a query and send corresponding information in each field by replacing the character "?" with the information
        String stmInsert = "INSERT INTO tbl_events(nameEvent, countryEvent, cityEvent, addressEvent, peopleCapacity, storeCapacity, restaurantCapacity, dateEvent, timeEvent, organizerId, ageClassification, statusEvent)  VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
        try (PreparedStatement ps = Operations.getConnection().prepareStatement(stmInsert)) {
            ps.setString(1, event.getNameEvent());
            ps.setString(2, event.getCountry());
            ps.setString(3, event.getCity());
            ps.setString(4, event.getAddress());
            ps.setInt(5, event.getPeopleCapacity());
            ps.setInt(6, event.getStoreCapacity());
            ps.setInt(7, event.getRestaurantCapacity());
            ps.setString(8, event.getDateEvent().toString());
            ps.setString(9, event.getTimeEvent().toString());
            ps.setLong(10, event.getOrganizerId());
            ps.setString(11, event.getAgeClassification().name());
            ps.setString(12, event.getStatusEnum().name());

            // use Operation class with insert_update_delete and verify if the rows in database are affected
            int rows = Operations.insert_update_delete_db(ps);
            if (rows <= 0) {
                System.out.println("Cannot push event");
            } else {
                System.out.println("Successful push event");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Updates an existing event in the database.
     * This method validates the date to ensure it is between 1 to 7 days in advance,
     * checks for repeated 'nameEvent' in the 'tbl_events' table, retrieves the existing
     * event from the database, updates its information, and then updates the database record.
     *
     * @param event The Event object containing updated information to be applied to the database.
     */
    @Override
    public void update(Event event) {
        Event sqlEvent = getById(event.getEventId());

        // Use Validations Class with LocalTime Library with apply the conditions of exercise. (create an event within 1 to 7 days in advance)
        boolean validDate = Validations.dateBetween(LocalDate.now(), event.getDateEvent(), 1, 7);

        if (!validDate) {
            System.out.println("Invalid date");
            return;
        }
        // Use validation class with counterRepeated method.
        int repeated = Validations.counterRepeated("tbl_events", "nameEvent", event.getNameEvent());
        if (repeated != 0) {
            System.out.println("nameEvent repeated");
            return;
        }

        // prepare the object with set info of sqlEvent ?????????
        if (sqlEvent != null) {
            sqlEvent.setNameEvent(event.getNameEvent());
            sqlEvent.setCountry(event.getCountry());
            sqlEvent.setCity(event.getCity());
            sqlEvent.setAddress(event.getAddress());
            sqlEvent.setPeopleCapacity(event.getPeopleCapacity());
            sqlEvent.setStoreCapacity(event.getStoreCapacity());
            sqlEvent.setRestaurantCapacity(event.getRestaurantCapacity());
            sqlEvent.setDateEvent(event.getDateEvent());
            sqlEvent.setTimeEvent(event.getTimeEvent());
            sqlEvent.setOrganizerId(event.getOrganizerId());
            sqlEvent.setAgeClassification(event.getAgeClassification());
            sqlEvent.setStatusEnum(event.getStatusEnum());

            // Create a query ("stmInsert") and replace parameter "?" with each new info.
            String stmInsert = """
            UPDATE tbl_events
            SET nameEvent = ?,
                countryEvent = ?,
                cityEvent = ?,
                addressEvent = ?,
                peopleCapacity = ?,
                storeCapacity = ?,
                restaurantCapacity = ?,
                dateEvent = ?,
                timeEvent = ?,  
                organizerId = ?,
                ageClassification = ?,
                statusEstatus = ?
            WHERE eventId = ?;
                               """;

            // Replace parameter "?" with corresponding index "(1,2,3...) and set info in each one.
            try (PreparedStatement ps = Operations.getConnection().prepareStatement(stmInsert)) {
                ps.setString(1, event.getNameEvent());
                ps.setString(2, event.getCountry());
                ps.setString(3, event.getCity());
                ps.setString(4, event.getAddress());
                ps.setInt(5, event.getPeopleCapacity());
                ps.setInt(6, event.getStoreCapacity());
                ps.setInt(7, event.getRestaurantCapacity());
                ps.setString(8, event.getDateEvent().toString());
                ps.setString(9, event.getTimeEvent().toString());
                ps.setLong(10, event.getOrganizerId());
                ps.setString(11, event.getAgeClassification().name());
                ps.setString(12, event.getStatusEnum().name());
                ps.setLong(13, event.getEventId());

                // Show with toString method the ps (PrepareStatement)
                System.out.println(ps.toString());

                // use Operation class with insert_update_delete and verify if the rows in database are affected
                int rows = Operations.insert_update_delete_db(ps);
                if (rows <= 0) {
                    System.out.println("Cannot update event");
                } else {
                    System.out.println("Successful update event");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

        } else {
            System.out.println("not found results event");
        }

    }

    /**
     * Deletes an event from the database using its ID.
     * This method deletes an event from the database identified by the provided event ID.
     * It establishes a connection with the database, prepares a DELETE query, and executes
     * the query to remove the specified event. The success or failure of the operation is
     * indicated by printing appropriate messages to the console.
     *
     * @param eventId The unique identifier of the event to be deleted.
     */
    @Override
    // Method: Delete an event using an id by event.
    public void delete(long eventId) {
        // Class Operations are used to configure the connection with database and send a Query saved in variable stm
        Operations.setConnection(BDConnection.MySQLConnection());
        String stm = "DELETE FROM tbl_events WHERE eventId = ?;";

        // use Operation class with insert_update_delete and verify if the rows in database are affected
        try (PreparedStatement ps = Operations.getConnection().prepareStatement(stm)) {
            ps.setLong(1, eventId);
            int rows = Operations.insert_update_delete_db(ps);
            if (rows > 0) {
                System.out.println("successful delete event");
                return;
            } else {
                System.out.println("not exists event");
                return;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("something was wrong on delete event");
        return;
    }

    @Override
    public List<EventStaffFull> getAllFull() {

        List<Event> listEvents = getAll();
        List<EventStaffFull> listEventsFull = new ArrayList<>();
        Operations.setConnection(BDConnection.MySQLConnection());

        for (Event event : listEvents){
            EventStaffFull eventStaffFull = new EventStaffFull();

            eventStaffFull.setEventId(event.getEventId());
            eventStaffFull.setNameEvent(event.getNameEvent());
            eventStaffFull.setCountry(event.getCountry());
            eventStaffFull.setCity(event.getCity());
            eventStaffFull.setAddress(event.getAddress());
            eventStaffFull.setPeopleCapacity(event.getPeopleCapacity());
            eventStaffFull.setStoreCapacity(event.getStoreCapacity());
            eventStaffFull.setRestaurantCapacity(event.getRestaurantCapacity());
            eventStaffFull.setDateEvent(event.getDateEvent());
            eventStaffFull.setTimeEvent(event.getTimeEvent());
            eventStaffFull.setOrganizerId(event.getOrganizerId());
            eventStaffFull.setAgeClassification(event.getAgeClassification());
            eventStaffFull.setStatusEnum(event.getStatusEnum());
            listEventsFull.add(eventStaffFull);
        }

        for (EventStaffFull eventStaffFull : listEventsFull){
            String stm = """
                SELECT ts.* FROM tbl_staff_event tse
                INNER JOIN tbl_events te ON te.eventId = tse.eventId
                INNER JOIN tbl_staff ts ON ts.staffId = tse.staffId
                WHERE te.eventId = ?;
                    """;
            try (PreparedStatement ps = Operations.getConnection().prepareStatement(stm)) {
                ps.setLong(1, eventStaffFull.getEventId());
                ResultSet rs = Operations.query_db(ps);
                List<Staff> listStaff = new ArrayList<>();

                while (rs.next()) {
                    Staff staff = new Staff();
                    staff.setStaffId(rs.getLong("staffId"));
                    staff.setStaffNumberId(rs.getString("staffNumberId"));
                    staff.setNameStaff(rs.getString("nameStaff"));
                    staff.setBirthdayStaff(LocalDate.parse(rs.getString("birthdayStaff")));
                    staff.setStatusStaffEnum(staff.getStatusStaffEnum(rs.getString("statusStaff")));
                    staff.setWorkerRoleId(rs.getInt("roleWorkId"));
                    listStaff.add(staff);
                }
                eventStaffFull.setStaff(listStaff);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return listEventsFull;
    }
}
