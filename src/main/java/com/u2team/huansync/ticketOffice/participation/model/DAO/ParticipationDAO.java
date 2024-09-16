package com.u2team.huansync.ticketOffice.participation.model.DAO;

import com.u2team.huansync.persistence.BDConnection;
import com.u2team.huansync.persistence.Operations;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 * The ParticipationDAO class provides data access operations for the Participation entity.
 */
public class ParticipationDAO implements IDao {

    /**
     * Inserts a new Participation record into the data store.
     *
     * @param activityId        The activity ID associated with the participation.
     * @param customerId        The customer ID associated with the participation.
     * @param customerTypeEnum  The type of customer (e.g., customer category or role).
     */
    @Override
    public void insertParticipation(int activityId, int customerId, String customerTypeEnum) {
        if (!hasWonAndParticipatedInSameType(activityId, customerId, customerTypeEnum)) {

            try {
                String status = (customerTypeEnum.equals("participant") && hasPaidAdditionalCost(customerId)) ? "participate" : "not participate";
                String insertQuery = "INSERT INTO tbl_participation (activityId, customerId, statusParticipation) VALUES (?, ?, ?)";
                try (PreparedStatement ps = Operations.getConnection().prepareStatement(insertQuery)) {
                    ps.setInt(1, activityId);
                    ps.setInt(2, customerId);
                    ps.setString(3, status);
                    ps.executeUpdate();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Error: Customer has already won and participated in an activity of the same type.");
        }
    }

    /**
     * Checks if a customer has won and participated in an activity of the same type.
     *
     * @param activityId        The activity ID to check.
     * @param customerId        The customer ID to check.
     * @param customerTypeEnum  The type of customer (e.g., customer category or role).
     * @return True if the customer has won and participated in the same type of activity; otherwise, false.
     */
    public boolean hasWonAndParticipatedInSameType(int activityId, int customerId, String customerTypeEnum) {

        boolean result = false;

        Operations.setConnection(BDConnection.MySQLConnection());

        try {
            String query = "SELECT COUNT(*) AS count FROM tbl_participation " +
                    "WHERE customerId = ? AND statusParticipation = 'winner' AND activityId != ?";

            try (PreparedStatement ps = Operations.getConnection().prepareStatement(query)) {
                ps.setInt(1, customerId);
                ps.setInt(2, activityId);

                try (ResultSet rs = ps.executeQuery()) {
                    if (rs.next()) {
                        int count = rs.getInt("count");
                        result = count > 0;
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }
    /**
     * Checks if a customer has paid an additional cost.
     *
     * @param customerId The customer ID to check.
     * @return True if the customer has paid an additional cost; otherwise, false.
     */
    public boolean hasPaidAdditionalCost(int customerId) {
        boolean result = false;

        try {
            String query = "SELECT COUNT(*) AS count FROM tbl_tickets WHERE customerId = ? AND additionalCost IS NOT NULL";

            try (PreparedStatement ps = Operations.getConnection().prepareStatement(query)) {
                ps.setInt(1, customerId);

                try (ResultSet rs = ps.executeQuery()) {
                    if (rs.next()) {
                        int count = rs.getInt("count");
                        result = count > 0;
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }
    /**
     * Changes the status of a customer to 'participant' if they have paid an additional cost.
     *
     * @param customerId The customer ID for which to change the status.
     */
    public void changeStatusToParticipantIfPaidAdditionalCost(int customerId) {
        if (hasPaidAdditionalCost(customerId)) {
            try {
                String updateQuery = "UPDATE tbl_customers SET typeCustomer = 'participant' WHERE customerId = ?";
                try (PreparedStatement ps = Operations.getConnection().prepareStatement(updateQuery)) {
                    ps.setInt(1, customerId);
                    ps.executeUpdate();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("The customer has not paid an additional cost.");
        }
    }
}
