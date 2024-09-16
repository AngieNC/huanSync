package com.u2team.huansync.ticketOffice.controller;

import java.util.List;

import com.u2team.huansync.ticketOffice.model.DAO.TicketOfficeDAO;
import com.u2team.huansync.ticketOffice.model.classes.TicketOffice;

/**
 * Controller class for managing operations related to TicketOffice entities.
 */
public class TicketOfficeController {

    private static TicketOfficeDAO ticketOfficeDAO = new TicketOfficeDAO();

    /**
     * Retrieves a TicketOffice entity based on the provided ticket office ID.
     *
     * @param ticketOfficeId The unique identifier of the TicketOffice to be retrieved.
     * @return The TicketOffice entity if found, or null if not found.
     */
    public static TicketOffice getByIdTicketOffice(long ticketOfficeId) {
        return ticketOfficeDAO.getById(ticketOfficeId);
    }

    /**
     * Retrieves a list of all TicketOffice entities.
     *
     * @return A List containing all TicketOffice entities.
     */
    public static List<TicketOffice> getAllTicketOffice() {
        return ticketOfficeDAO.getAllTicketOffice();
    }

    /**
     * Inserts a new TicketOffice entity into the data store.
     *
     * @param ticketOffice The TicketOffice entity to be inserted.
     */
    public static void insertTicketOffice(TicketOffice ticketOffice) {
        ticketOfficeDAO.insertTicketOffice(ticketOffice);
    }

    /**
     * Updates an existing TicketOffice entity in the data store.
     *
     * @param ticketOffice The TicketOffice entity to be updated.
     */
    public static void updateTicketOffice(TicketOffice ticketOffice) {
        ticketOfficeDAO.updateTicketOffice(ticketOffice);
    }

    /**
     * Deletes a TicketOffice entity based on the provided ticket office ID.
     *
     * @param ticketOfficeId The unique identifier of the TicketOffice to be deleted.
     */
    public static void deleteTicketOffice(long ticketOfficeId) {
        ticketOfficeDAO.deleteTicketOffice(ticketOfficeId);
    }
}

