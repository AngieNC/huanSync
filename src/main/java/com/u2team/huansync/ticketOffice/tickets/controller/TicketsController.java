package com.u2team.huansync.ticketOffice.tickets.controller;

import com.u2team.huansync.ticketOffice.tickets.model.DAO.TicketsDAO;
import com.u2team.huansync.ticketOffice.tickets.model.classes.Tickets;

import java.util.List;

/**
 * Controlador para manejar operaciones relacionadas con los tickets.
 */
public class TicketsController {

    // Objeto TicketsDAO para realizar operaciones de acceso a datos
    private static TicketsDAO ticketsDAO = new TicketsDAO();

    /**
     * Obtiene un ticket por su ID.
     *
     * @param ticketsId ID del ticket que se desea obtener.
     * @return Objeto Tickets correspondiente al ID proporcionado.
     */
    public static Tickets getById(long ticketsId) {
        return ticketsDAO.getById(ticketsId);
    }

    /**
     * Obtiene todos los tickets.
     *
     * @return Lista de objetos Tickets que representan todos los tickets disponibles.
     */
    public static List<Tickets> getAllTickets() {
        return ticketsDAO.getAll();
    }

    /**
     * Inserta un nuevo ticket en la base de datos.
     *
     * @param tickets Objeto Tickets que se va a insertar.
     */
    public static void insertTickets(Tickets tickets) {
        ticketsDAO.save(tickets);
    }

    /**
     * Elimina un ticket por su ID.
     *
     * @param ticketsId ID del ticket que se desea eliminar.
     */
    public static void deleteTickets(long ticketsId) {
        ticketsDAO.delete(ticketsId);
    }

    /**
     * Actualiza la información de un ticket existente.
     *
     * @param tickets Objeto Tickets con la información actualizada.
     */
    public static void updateTickets(Tickets tickets) {
        ticketsDAO.update(tickets);
    }
}
