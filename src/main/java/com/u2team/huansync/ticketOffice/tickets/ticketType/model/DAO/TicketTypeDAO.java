package com.u2team.huansync.ticketOffice.tickets.ticketType.model.DAO;

import com.u2team.huansync.persistence.BDConnection;
import com.u2team.huansync.persistence.Operations;
import com.u2team.huansync.ticketOffice.tickets.ticketType.model.classes.TicketType;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Data Access Object (DAO) for handling operations related to TicketType in the database.
 */
public class TicketTypeDAO implements IDao<TicketType> {

    /**
     * Retrieves a TicketType object by its ID from the database.
     *
     * @param id The ID of the TicketType object to retrieve.
     * @return The TicketType object with the specified ID.
     */
    @Override
    public TicketType getById(long id) {
        Operations.setConnection(BDConnection.MySQLConnection());
        String stm = "SELECT * FROM tbl_ticketType where ticketTypeId = ?;";

        try (PreparedStatement ps = Operations.getConnection().prepareStatement(stm)) {
            ps.setLong(1, id);
            ResultSet rs = Operations.query_db(ps);
            if (rs.next()) {
                TicketType ticketType = new TicketType();
                ticketType.setTicketTypeId(rs.getLong("ticketTypeId"));
                ticketType.setNameTicketType(rs.getString("nameTicketType"));
                ticketType.setDescription(rs.getString("description"));
                ticketType.setPrice(rs.getDouble("price"));
                return ticketType;
            } else {
                System.out.println("ERROR: The id has not been found");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Retrieves a list of all TicketType objects from the database.
     *
     * @return A list containing all TicketType objects.
     */
    @Override
    public List<TicketType> getAll() {
        List<TicketType> listTicketType = new ArrayList<>();
        Operations.setConnection(BDConnection.MySQLConnection());
        String stm = "SELECT * FROM tbl_ticketType;";

        try (PreparedStatement ps = Operations.getConnection().prepareStatement(stm)) {
            ResultSet rs = Operations.query_db(ps);

            while (rs.next()) {
                TicketType ticketType = new TicketType();
                ticketType.setTicketTypeId(rs.getLong("ticketTypeId"));
                ticketType.setNameTicketType(rs.getString("nameTicketType"));
                ticketType.setDescription(rs.getString("description"));
                ticketType.setPrice(rs.getDouble("price"));
                listTicketType.add(ticketType);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listTicketType;
    }

    /**
     * Saves a TicketType object to the database.
     *
     * @param t The TicketType object to save.
     */
    @Override
    public void save(TicketType t) {
        Operations.setConnection(BDConnection.MySQLConnection());
        String stmInsert = "INSERT INTO tbl_ticketType(nameTicketType, description, price) VALUES (?,?,?);";

        try (PreparedStatement ps = Operations.getConnection().prepareStatement(stmInsert)) {
            ps.setString(1, t.getNameTicketType());
            ps.setString(2, t.getDescription());
            ps.setDouble(3, t.getPrice());

            int rows = Operations.insert_update_delete_db(ps);
            if (rows <= 0) {
                System.out.println("Cannot insert TicketType member");
            } else {
                System.out.println("Successful insert TicketType member");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Updates a TicketType object in the database.
     *
     * @param t The TicketType object to update.
     */
    @Override
    public void update(TicketType t) {
        TicketType sqlTicketType = getById(t.getTicketTypeId());

        if (sqlTicketType != null) {
            sqlTicketType.setTicketTypeId(t.getTicketTypeId());
            sqlTicketType.setNameTicketType(t.getNameTicketType());
            sqlTicketType.setPrice(t.getPrice());

            String stmUpdate = """
                               UPDATE tbl_ticketType
                               SET  nameTicketType = ?,
                                    description = ?,
                                    price = ?
                               WHERE ticketTypeId = ?;
                               """;

            try (PreparedStatement ps = Operations.getConnection().prepareStatement(stmUpdate)) {
                ps.setString(1, t.getNameTicketType());
                ps.setString(2, t.getDescription());
                ps.setDouble(3, t.getPrice());
                ps.setLong(4, t.getTicketTypeId());

                int rows = Operations.insert_update_delete_db(ps);
                if (rows <= 0) {
                    System.out.println("Cannot update ticketType");
                } else {
                    System.out.println("Successful update ticketType");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Not found results ticketType");
        }
    }

    /**
     * Deletes a TicketType object from the database by its ID.
     *
     * @param tycketTypeId The ID of the TicketType object to delete.
     */
    @Override
    public void delete(long tycketTypeId) {
        Operations.setConnection(BDConnection.MySQLConnection());
        String stm = "DELETE FROM tbl_ticketType WHERE ticketTypeId = ?;";

        try (PreparedStatement ps = Operations.getConnection().prepareStatement(stm)) {
            ps.setLong(1, tycketTypeId);
            int rows = Operations.insert_update_delete_db(ps);
            if (rows > 0) {
                System.out.println("successful delete tycketType");
                return;
            } else {
                System.out.println("not exists tycketType");
                return;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Something was wrong on delete tycketType");
    }
}
