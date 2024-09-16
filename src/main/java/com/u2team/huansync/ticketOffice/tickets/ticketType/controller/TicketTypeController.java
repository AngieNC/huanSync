package com.u2team.huansync.ticketOffice.tickets.ticketType.controller;

import com.u2team.huansync.ticketOffice.tickets.ticketType.model.DAO.TicketTypeDAO;
import com.u2team.huansync.ticketOffice.tickets.ticketType.model.classes.TicketType;

import java.util.List;

/**
 * Controller class for managing operations related to TicketType entities.
 */
public class TicketTypeController {

    private static TicketTypeDAO ticketTypeDAO = new TicketTypeDAO();

    /**
     * Retrieves a TicketType by its ID.
     * @param ticketTypeId The ID of the TicketType to retrieve.
     * @return The TicketType with the specified ID.
     */
    public static TicketType getByIdTicketType(long ticketTypeId) {
        return ticketTypeDAO.getById(ticketTypeId);
    }

    /**
     * Retrieves a list of all TicketTypes.
     * @return A list containing all TicketTypes.
     */
    public static List<TicketType> getAllTicketType() {
        return ticketTypeDAO.getAll();
    }

    /**
     * Inserts a new TicketType into the database.
     * @param ticketType The TicketType object to insert.
     */
    public static void insertTicketType(TicketType ticketType) {
        ticketTypeDAO.save(ticketType);
    }

    /**
     * Updates an existing TicketType in the database.
     * @param ticketType The TicketType object to update.
     */
    public static void updateTicketType(TicketType ticketType) {
        ticketTypeDAO.update(ticketType);
    }

    /**
     * Deletes a TicketType by its ID.
     * @param ticketTypeId The ID of the TicketType to delete.
     */
    public static void deleteTicketType(long ticketTypeId) {
        ticketTypeDAO.delete(ticketTypeId);
    }
}
