package com.u2team.huansync.ticketOffice.tickets.model.DAO;

import com.u2team.huansync.persistence.BDConnection;
import com.u2team.huansync.persistence.Operations;
import com.u2team.huansync.ticketOffice.tickets.model.classes.Tickets;
import com.u2team.huansync.ticketOffice.tickets.model.classes.builders.TicketBuilder;
import com.u2team.huansync.ticketOffice.tickets.model.classes.builders.TicketConcreteBuilder;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Data Access Object (DAO) for handling operations related to Tickets in the database.
 */
public class TicketsDAO implements IDao<Tickets> {

    /**
     * Retrieves a Tickets object by its ID from the database.
     *
     * @param id The ID of the Tickets object to retrieve.
     * @return The Tickets object with the specified ID.
     */
    @Override
    public Tickets getById(long id) {
        Operations.setConnection(BDConnection.MySQLConnection());
        String stm = "SELECT * FROM tbl_tickets WHERE ticketId = ?;";

        try (PreparedStatement ps = Operations.getConnection().prepareStatement(stm)) {
            ps.setLong(1, id);
            ResultSet rs = Operations.query_db(ps);
            if (rs.next()) {
                TicketBuilder ticketBuilder = new TicketConcreteBuilder();

                Tickets sqlTickets = ticketBuilder.ticketId(rs.getLong("ticketId"))
                        .nameTicket(rs.getString("nameTicket"))
                        .statusEnum(rs.getString("status"))
                        .additionalCost(rs.getDouble("additionalCost"))
                        .customerId(rs.getLong("customerId"))
                        .ticketOfficeId(rs.getLong("ticketOfficeId"))
                        .ticketTypeId(rs.getLong("ticketTypeId"))
                        .buid();

                return sqlTickets;
            } else {
                System.out.println("ERROR: The id has not been found");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Retrieves a list of all Tickets objects from the database.
     *
     * @return A list containing all Tickets objects.
     */
    @Override
    public List<Tickets> getAll() {
        List<Tickets> ticketsList = new ArrayList<>();

        Operations.setConnection(BDConnection.MySQLConnection());
        String stm = "SELECT * FROM tbl_tickets;";

        try (PreparedStatement ps = Operations.getConnection().prepareStatement(stm)) {
            ResultSet rs = Operations.query_db(ps);

            while (rs.next()) {
                TicketBuilder ticketBuilder = new TicketConcreteBuilder();

                Tickets sqlTickets = ticketBuilder.ticketId(rs.getLong("ticketId"))
                        .nameTicket(rs.getString("nameTicket"))
                        .statusEnum(rs.getString("status"))
                        .additionalCost(rs.getDouble("additionalCost"))
                        .customerId(rs.getLong("customerId"))
                        .ticketOfficeId(rs.getLong("ticketOfficeId"))
                        .ticketTypeId(rs.getLong("ticketTypeId"))
                        .buid();

                ticketsList.add(sqlTickets);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ticketsList;
    }

    /**
     * Saves a Tickets object to the database.
     *
     * @param tickets The Tickets object to save.
     */
    @Override
    public void save(Tickets tickets) {
        String stmInsert = "INSERT INTO tbl_tickets(nameTicket, status, additionalCost, customerId, ticketOfficeId, ticketTypeId) VALUES(?,?,?,?,?,?);";
        try (Connection connection = BDConnection.MySQLConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(stmInsert)) {
                ps.setString(1, tickets.getNameTicket());
                ps.setString(2, tickets.getStatusEnum().name());
                ps.setDouble(3, tickets.getAdditionalCost());
                ps.setLong(4, tickets.getCustomerId());
                ps.setLong(5, tickets.getTicketOfficeId());
                ps.setLong(6, tickets.getTicketTypeId());

                int rows = Operations.insert_update_delete_db(ps);

                if (rows <= 0) {
                    System.out.println("Cannot push ticket");
                } else {
                    System.out.println("Successful push ticket");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Updates a Tickets object in the database.
     *
     * @param tickets The Tickets object to update.
     */
    @Override
    public void update(Tickets tickets) {
        Tickets sqlTicket = getById(tickets.getTicketId());

        if (sqlTicket != null) {
            sqlTicket.setNameTicket(tickets.getNameTicket());
            sqlTicket.setStatusEnum(tickets.getStatusEnum());
            sqlTicket.setAdditionalCost(tickets.getAdditionalCost());
            sqlTicket.setCustomerId(sqlTicket.getCustomerId());
            sqlTicket.setTicketOfficeId(sqlTicket.getTicketOfficeId());
            sqlTicket.setTicketTypeId(sqlTicket.getTicketTypeId());

            String stmInsert = """
            UPDATE tbl_tickets
            SET nameTicket = ?,
                status = ?,
                additionalCost = ?,
                customerId = ?,
                ticketOfficeId = ?,
                ticketTypeId = ?
            WHERE ticketId = ?;
            """;

            try (PreparedStatement ps = Operations.getConnection().prepareStatement(stmInsert)) {
                ps.setString(1, tickets.getNameTicket());
                ps.setString(2, tickets.getStatusEnum().name());
                ps.setDouble(3, tickets.getAdditionalCost());
                ps.setLong(4, tickets.getCustomerId());
                ps.setLong(5, tickets.getTicketOfficeId());
                ps.setLong(6, tickets.getTicketTypeId());
                ps.setLong(7, tickets.getTicketId());

                System.out.println(ps.toString());

                int rows = Operations.insert_update_delete_db(ps);
                if (rows <= 0) {
                    System.out.println("Cannot update ticket");
                } else {
                    System.out.println("Successful update ticket");
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("not found results ticket");
        }
    }

    /**
     * Deletes a Tickets object from the database by its ID.
     *
     * @param ticketId The ID of the Tickets object to delete.
     */
    @Override
    public void delete(long ticketId) {
        Operations.setConnection(BDConnection.MySQLConnection());
        String stm = "DELETE FROM tbl_tickets WHERE ticketId = ?;";

        try (PreparedStatement ps = Operations.getConnection().prepareStatement(stm)) {
            ps.setLong(1, ticketId);
            int rows = Operations.insert_update_delete_db(ps);
            if (rows > 0) {
                System.out.println("successful delete ticket");
                return;
            } else {
                System.out.println("not exists ticket");
                return;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("something was wrong on delete ticket");
        return;
    }
}
