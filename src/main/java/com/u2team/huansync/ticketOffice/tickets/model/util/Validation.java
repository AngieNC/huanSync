package com.u2team.huansync.ticketOffice.tickets.model.util;

import com.u2team.huansync.persistence.BDConnection;
import com.u2team.huansync.persistence.Operations;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Utility class for validation operations related to event capacity and ticket sales.
 */
public class Validation {

    /**
     * Validates if the current ticket sales for an event do not exceed its people capacity.
     *
     * @param eventId The ID of the event to validate.
     * @return True if the ticket sales are within the people capacity, false otherwise.
     */
    public boolean validatePeopleCapacity(long eventId) {
        Operations.setConnection(BDConnection.MySQLConnection());

        String stm = """
                SELECT
                    e.eventId,
                    e.nameEvent,
                    e.peopleCapacity,
                    COUNT(t.ticketId) AS ticketCount
                FROM
                    tbl_events e
                    LEFT JOIN db_huansync.tbl_ticketoffice tof ON e.eventId = tof.eventId
                    LEFT JOIN db_huansync.tbl_tickets t ON tof.ticketOfficeId = t.ticketOfficeId
                WHERE e.eventId = ?
                GROUP BY
                    e.eventId, e.nameEvent;
                """;

        Boolean request = null;

        try (PreparedStatement ps = Operations.getConnection().prepareStatement(stm)) {
            ps.setLong(1, eventId);
            ResultSet rs = Operations.query_db(ps);

            if (rs.next()) {
                int peopleCapacity = rs.getInt("peopleCapacity");
                int ticketSold = rs.getInt("ticketCount");
                return peopleCapacity >= ticketSold;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        System.out.println(request);
        return request;
    }
}
