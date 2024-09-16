package com.u2team.huansync.ticketOffice.model.util;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;

import com.u2team.huansync.persistence.BDConnection;
import com.u2team.huansync.persistence.Operations;
import com.u2team.huansync.ticketOffice.controller.TicketOfficeController;
import com.u2team.huansync.ticketOffice.model.classes.TicketOffice;

/**
 * Utility class for performing various validations.
 */
public class Validations {

    /**
     * Checks if the provided start time and date are valid in relation to the
     * current date and time.
     *
     * @param starHour  The start time to be validated.
     * @param startDate The start date to be validated.
     * @return true if the start time and date are valid, false otherwise.
     */
    public static boolean isValidDateTime(LocalTime starHour, LocalDate startDate) {
        LocalDate currentDate = LocalDate.now();
        LocalTime currentHour = LocalTime.now();

        if (currentDate.isBefore(currentDate)) {
            return true;
        } else if (currentDate.isEqual(currentDate)) {
            if (currentHour.isBefore(currentHour)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Checks if an event with the specified event ID exists.
     *
     * @param eventId The unique identifier of the event to be checked.
     * @return true if an event with the specified ID exists, false otherwise.
     */
    public static boolean checkedEvent(long eventId) {
        for (TicketOffice repeated : TicketOfficeController.getAllTicketOffice()) {
            return repeated.getEventId() == eventId;
        }
        return false;
    }

    /**
     * Checks if a staff with the specified staff ID exists.
     *
     * @param staffId The unique identifier of the staff to be checked.
     * @return true if a staff with the specified ID exists, false otherwise.
     */
    public static boolean checkedStaff(long staffId) {
        for (TicketOffice repeated2 : TicketOfficeController.getAllTicketOffice()) {
            return repeated2.getStaffId() == staffId;
        }
        return false;
    }

    /**
     * Checks the status of the staff with the provided ID.
     *
     * @param staffId The ID of the staff to be checked.
     * @return {@code true} if the staff has the 'NO_TASK_ASSIGNED' status;
     *         otherwise, {@code false}.
     */
    public static boolean checkedStaffStatus(long staffId) {
        // Set up the connection to the MySQL database.
        Operations.setConnection(BDConnection.MySQLConnection());

        // SQL query to retrieve the staff status.
        String query = "SELECT staffId, statusStaff FROM tbl_staff WHERE statusStaff = 'NO_TASK_ASSIGNED';";

        try (PreparedStatement ps = Operations.getConnection().prepareStatement(query)) {
            // Execute the query and get the result set.
            ResultSet rs = Operations.query_db(ps);

            // Iterate through the results.
            while (rs.next()) {
                long idStaff = rs.getLong("staffId");

                // Compare the staff ID with the IDs of Tickets in the office.
                for (TicketOffice repeated3 : TicketOfficeController.getAllTicketOffice()) {
                    return repeated3.getStaffId() == idStaff;
                }
            }
        } catch (SQLException e) {
            // Handle exceptions in case of SQL error.
            e.printStackTrace();
        }

        // Return false if no match is found.
        return false;
    }

    /**
     * Updates the status of the staff with the provided ID.
     *
     * @param statusChange The new status to set for the staff.
     * @param staffId      The ID of the staff to be updated.
     * @return {@code true} if the staff status is successfully updated; otherwise,
     *         {@code false}.
     */
    public static boolean updateStaff(long staffId) {
        // Set up the connection to the MySQL database.
        Operations.setConnection(BDConnection.MySQLConnection());

        // SQL query to update the staff status.
        String query = "UPDATE tbl_staff SET statusStaff = 'TASK_ASSIGNED' WHERE staffId = ?";

        try (PreparedStatement ps = Operations.getConnection().prepareStatement(query)) {
            // Set parameters for the prepared statement.
            ps.setLong(1, staffId);

            // Execute the update query.
            ps.execute();

            // Return true indicating successful update.
            return true;
        } catch (SQLException e) {
            // Handle exceptions in case of SQL error.
            e.printStackTrace();
        }

        // Return false if the update is unsuccessful.
        return false;
    }
}
