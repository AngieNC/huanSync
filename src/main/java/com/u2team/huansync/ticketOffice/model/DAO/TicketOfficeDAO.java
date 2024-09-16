package com.u2team.huansync.ticketOffice.model.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import com.u2team.huansync.event.controller.EventController;
import com.u2team.huansync.event.model.classes.Event;
import com.u2team.huansync.event.staff.controller.StaffController;
import com.u2team.huansync.event.staff.model.classes.Staff;
import com.u2team.huansync.persistence.BDConnection;
import com.u2team.huansync.persistence.Operations;
import com.u2team.huansync.ticketOffice.model.classes.TicketOffice;
import com.u2team.huansync.ticketOffice.model.builders.TicketOfficeBuilder;
import com.u2team.huansync.ticketOffice.model.builders.TicketOfficeBuilderOficial;
import com.u2team.huansync.ticketOffice.model.util.Validations;

public class TicketOfficeDAO implements IDao<TicketOffice> {

    /**
     * Retrieves and returns an instance of TicketOffice based on the provided ID.
     *
     * @param id The unique identifier of the TicketOffice to be retrieved.
     * @return An instance of TicketOffice if a record with the provided ID is
     *         found, or null if not found.
     * @throws SQLException If an error occurs while interacting with the database.
     */
    @Override
    public TicketOffice getById(long id) {

        Operations.setConnection(BDConnection.MySQLConnection());
        String stm = "SELECT * FROM tbl_ticketOffice where ticketOfficeId = ?;";

        try (PreparedStatement ps = Operations.getConnection().prepareStatement(stm)) {
            ps.setLong(1, id);
            ResultSet rs = Operations.query_db(ps);
            if (rs.next()) {
                TicketOfficeBuilder ticketOfficeBuilder = new TicketOfficeBuilderOficial();
                TicketOffice sqlTicketOffice = ticketOfficeBuilder

                        .ticketOfficeId(rs.getLong("ticketOfficeId"))
                        .eventId(rs.getLong("eventId"))
                        .location(rs.getBoolean("location"))
                        .address(rs.getString("address"))
                        .contactNumber(rs.getString("contactNumber"))
                        .staffId(rs.getLong("staffId"))
                        .build();

                return sqlTicketOffice;
            } else {
                System.out.println("ERROR: The id hasn't been found");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Retrieves a list of all TicketOffice entities from the data source.
     *
     * @return A List containing all TicketOffice entities.
     */
    @Override
    public List<TicketOffice> getAllTicketOffice() {
        List<TicketOffice> ticketList = new ArrayList<>();

        Operations.setConnection(BDConnection.MySQLConnection());
        String stm = "SELECT * FROM tbl_ticketOffice";

        try (PreparedStatement ps = Operations.getConnection().prepareStatement(stm)) {
            ResultSet rs = Operations.query_db(ps);

            while (rs.next()) {

                TicketOfficeBuilder ticketOfficeBuilder = new TicketOfficeBuilderOficial();

                TicketOffice sqlTicketOffice = ticketOfficeBuilder
                        .ticketOfficeId(rs.getLong("ticketOfficeId"))
                        .eventId(rs.getLong("eventId"))
                        .location(rs.getBoolean("location"))
                        .address(rs.getString("address"))
                        .contactNumber(rs.getString("contactNumber"))
                        .staffId(rs.getLong("staffId"))
                        .build();
                ticketList.add(sqlTicketOffice);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ticketList;
    }

    /**
     * Inserts a new TicketOffice entity into the data source.
     *
     * @param ticketOffice The TicketOffice entity to be inserted.
     */
    @Override
    public void insertTicketOffice(TicketOffice ticketOffice) {
        Event eventDatas = EventController.getByIdEvent(ticketOffice.getEventId());
        Staff staffDatas = StaffController.getByIdStaff(ticketOffice.getStaffId());
        LocalDate startDate = eventDatas.getDateEvent();
        LocalTime startHour = eventDatas.getTimeEvent();

        if (Validations.isValidDateTime(startHour, startDate)) {
            System.out.println("This ticketOffice was impossible to add because the event has already started");
            return;
        } else if (Validations.checkedEvent(eventDatas.getEventId())) {
            System.out.println("That event was assigned to another ticket office");
            return;
        } else if (Validations.checkedStaff(staffDatas.getStaffId())) {
            System.out.println("That staff was assigned to another ticket office");
            return;
        } else if (eventDatas.getStatusEnum().name().equalsIgnoreCase("finished")) {
            System.out.println("Sorry, the event was finished, so create one ticket office with another active event");
            return;
        } else if (Validations.checkedStaffStatus(staffDatas.getStaffId())){
            System.out.println("Sorry, that staff was assigned or dismissed or incapacited");
            return;
        } else {

            String ticketOfficeStm = "INSERT INTO tbl_ticketOffice(eventId, location, address, contactNumber, staffId) VALUES(?,?,?,?,?)";
            try (PreparedStatement ps = Operations.getConnection().prepareStatement(ticketOfficeStm)) {
                ps.setLong(1, ticketOffice.getEventId());
                ps.setBoolean(2, ticketOffice.isLocation());
                if (ticketOffice.isLocation()) {
                    ps.setString(3, eventDatas.getAddress());
                } else {
                    ps.setString(3, ticketOffice.getAddress());
                }
                ps.setString(4, ticketOffice.getContactNumber());
                ps.setLong(5, ticketOffice.getStaffId());

                int rows = Operations.insert_update_delete_db(ps);
                if (rows <= 0) {
                    System.out.println("Cannot push ticketOffice");
                } else {
                    System.out.println("Successful push ticketOffice");
                    Validations.updateStaff(ticketOffice.getStaffId());
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Updates an existing TicketOffice entity in the data source.
     *
     * @param ticketOffice The TicketOffice entity to be updated.
     */
    @Override
    public void updateTicketOffice(TicketOffice ticketOffice) {
        // Retrieve existing TicketOffice entity from the data source
        TicketOffice sqlTicketOffice = getById(ticketOffice.getTicketOfficeId());
        
        // Retrieve associated data for validation purposes
        Event eventDatas = EventController.getByIdEvent(ticketOffice.getEventId());
        Staff staffDatas = StaffController.getByIdStaff(ticketOffice.getStaffId());
        LocalDate startDate = eventDatas.getDateEvent();
        LocalTime startHour = eventDatas.getTimeEvent();

        // Check if the existing TicketOffice entity is found
        if (sqlTicketOffice != null) {
            // Update fields of the existing TicketOffice entity with new values
            sqlTicketOffice.setEventId(ticketOffice.getEventId());
            sqlTicketOffice.setLocation(ticketOffice.isLocation());
            sqlTicketOffice.setAddress(ticketOffice.getAddress());
            sqlTicketOffice.setContactNumber(ticketOffice.getContactNumber());
            sqlTicketOffice.setStaffId(ticketOffice.getStaffId());

            // Perform validations before the update
            if (Validations.isValidDateTime(startHour, startDate)) {
                System.out.println("This ticketOffice was impossible to update because the event has already started");
                return;
            } else if (eventDatas.getStatusEnum().name().equalsIgnoreCase("finished")) {
                System.out.println("Sorry, the event was finished, so create one ticket office with another active event");
                return;
            } else if (Validations.checkedStaffStatus(staffDatas.getStaffId())){
                System.out.println("Sorry, that staff was assigned or dismissed or incapacited");
                return;
            } else {
                // If validations pass, proceed with the update
                String ticketOfficeStm = "UPDATE tbl_ticketOffice SET eventId = ?, location = ?, address = ?, contactNumber = ?, staffId = ? WHERE ticketOfficeId = ?; ";

                try (PreparedStatement ps = Operations.getConnection().prepareStatement(ticketOfficeStm)) {
                    ps.setLong(1, sqlTicketOffice.getEventId());
                    ps.setBoolean(2, sqlTicketOffice.isLocation());
                    if (sqlTicketOffice.isLocation()) {
                        ps.setString(3, eventDatas.getAddress());
                    } else {
                        ps.setString(3, sqlTicketOffice.getAddress());
                    }
                    ps.setString(4, sqlTicketOffice.getContactNumber());
                    ps.setLong(5, sqlTicketOffice.getStaffId());
                    ps.setLong(6, sqlTicketOffice.getTicketOfficeId());
                    
                    int rows = Operations.insert_update_delete_db(ps);
                    if (rows <= 0) {
                        System.out.println("Cannot update ticketOffice");
                    } else {
                        ps.execute();
                        System.out.println("Successful update ticketOffice");
                        Validations.updateStaff(ticketOffice.getStaffId());
                    }

                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        } else {
            System.out.println("Not found results ticketOffice");
        }
    }


    /**
     * Deletes a TicketOffice entity from the data source based on the provided ticketOfficeId.
     *
     * @param ticketOfficeId The unique identifier of the TicketOffice entity to be deleted.
     */
    @Override
    public void deleteTicketOffice(long ticketOfficeId) {
        // Create a dummy TicketOffice instance to retrieve associated event data for validation
        TicketOffice eventId = new TicketOffice();
        Event eventDatas = EventController.getByIdEvent(eventId.getEventId());

        // Check if the associated event's status is finished
        if (eventDatas.getStatusEnum().name().equalsIgnoreCase("finished")) {
            Operations.setConnection(BDConnection.MySQLConnection());
            String ticketOfficeStm = "DELETE FROM tbl_ticketOffice WHERE ticketOfficeId = ?";
            try (PreparedStatement ps = Operations.getConnection().prepareStatement(ticketOfficeStm)) {
                ps.setLong(1, ticketOfficeId);

                // Perform deletion operation
                int rows = Operations.insert_update_delete_db(ps);
                if (rows > 0) {
                    System.out.println("Successful delete ticketOffice");
                    return;
                } else {
                    System.out.println("TicketOffice with the specified ID does not exist");
                    return;
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Event's status hasn't finished");
        }
        
        // Output message if the deletion operation encounters issues
        System.out.println("Something was wrong during delete ticketOffice");
    }
}