package com.u2team.huansync.ticketOffice.accounting.model.classes;

import com.u2team.huansync.persistence.BDConnection;
import com.u2team.huansync.persistence.Operations;
import com.u2team.huansync.ticketOffice.accounting.model.DAO.InterfaceAccountingDAO;

import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * The AccountingDAO class implements the InterfaceAccountingDAO interface
 * and provides methods for generating various accounting reports.
 */
public class AccountingDAO implements InterfaceAccountingDAO {

    /**
     * Generates a total sales report.
     */
    @Override
    public void generateTotalSalesReport() {
        Operations.setConnection(BDConnection.MySQLConnection());
        String query = "SELECT COUNT(*) AS total_tickets_sold, " +
                "SUM(tt.price) AS total_revenue " +
                "FROM tbl_tickets t " +
                "JOIN tbl_ticketType tt ON t.ticketTypeId = tt.ticketTypeId;";

        try (PreparedStatement ps = Operations.getConnection().prepareStatement(query)) {
            ResultSet rs = Operations.query_db(ps);

            while (rs.next()) {
                int totalTicketsSold = rs.getInt("total_tickets_sold");
                BigDecimal totalRevenue = rs.getBigDecimal("total_revenue");

                System.out.println("Total tickets sold: " + totalTicketsSold);
                System.out.println("Total revenue: $" + totalRevenue);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Generates a category sales report.
     */
    @Override
    public void generateCategorySalesReport() {
        Operations.setConnection(BDConnection.MySQLConnection());
        String query = "SELECT tt.nameTicketType, COUNT(t.ticketId) AS tickets_sold, " +
                "SUM(tt.price) AS revenue " +
                "FROM tbl_tickets t " +
                "JOIN tbl_ticketType tt ON t.ticketTypeId = tt.ticketTypeId " +
                "GROUP BY tt.nameTicketType;";

        try (PreparedStatement ps = Operations.getConnection().prepareStatement(query)) {
            ResultSet rs = Operations.query_db(ps);

            System.out.println("Category Sales Report:");
            System.out.println("----------------------");

            while (rs.next()) {
                String ticketType = rs.getString("nameTicketType");
                int ticketsSold = rs.getInt("tickets_sold");
                BigDecimal revenue = rs.getBigDecimal("revenue");

                System.out.println(ticketType + ": " + ticketsSold + " tickets sold, Revenue: $" + revenue);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Generates an availability report.
     */
    @Override
    public void generateAvailabilityReport() {
        Operations.setConnection(BDConnection.MySQLConnection());
        String query = "SELECT tt.nameTicketType, COUNT(t.ticketId) AS available_quantity " +
                "FROM tbl_ticketType tt " +
                "LEFT JOIN tbl_tickets t ON tt.ticketTypeId = t.ticketTypeId AND t.status = 'reserved' " +
                "GROUP BY tt.nameTicketType;";

        try (PreparedStatement ps = Operations.getConnection().prepareStatement(query)) {
            ResultSet rs = Operations.query_db(ps);

            System.out.println("Availability Report:");
            System.out.println("--------------------");

            while (rs.next()) {
                String ticketType = rs.getString("nameTicketType");
                int availableQuantity = rs.getInt("available_quantity");

                System.out.println(ticketType + ": " + availableQuantity + " available tickets");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Generates a participants report.
     */
    @Override
    public void generateParticipantsReport() {
        Operations.setConnection(BDConnection.MySQLConnection());
        String query = "SELECT\n" +
                "    a.nameActivity AS activity,\n" +
                "    COUNT(p.customerId) AS participant_count\n" +
                "FROM\n" +
                "    tbl_activities a\n" +
                "LEFT JOIN\n" +
                "    tbl_participation p ON a.activityId = p.activityId\n" +
                "GROUP BY\n" +
                "    a.nameActivity;";

        try (PreparedStatement ps = Operations.getConnection().prepareStatement(query)) {
            ResultSet rs = Operations.query_db(ps);

            System.out.println("Participants Report:");
            System.out.println("--------------------");

            // Verificar si el ResultSet no es nulo
            if (rs != null) {
                while (rs.next()) {
                    String activity = rs.getString("activity");
                    int participantCount = rs.getInt("participant_count");

                    System.out.println(activity + ": " + participantCount + " participants");
                }
            } else {
                System.out.println("No results found for the query.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
