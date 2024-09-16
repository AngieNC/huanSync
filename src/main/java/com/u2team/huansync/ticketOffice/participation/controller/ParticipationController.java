package com.u2team.huansync.ticketOffice.participation.controller;

import com.u2team.huansync.ticketOffice.participation.model.DAO.ParticipationDAO;

/**
 * The ParticipationController class serves as a controller for managing Participation-related operations.
 */
public class ParticipationController {

    // Instance of the ParticipationDAO for data access operations.
    private static ParticipationDAO participationDAO = new ParticipationDAO();

    /**
     * Inserts a new Participation record into the data store.
     *
     * @param activityId        The activity ID associated with the participation.
     * @param customerId        The customer ID associated with the participation.
     * @param customerTypeEnum  The type of customer (e.g., customer category or role).
     */
    public static void insertParticipation(int activityId, int customerId, String customerTypeEnum) {
        participationDAO.insertParticipation(activityId, customerId, customerTypeEnum);
    }

    /**
     * Changes the status of a customer to 'participant' if they have paid an additional cost.
     *
     * @param customerId The customer ID for which to change the status.
     */
    public static void changeStatusToParticipantIfPaidAdditionalCost(int customerId) {
        participationDAO.changeStatusToParticipantIfPaidAdditionalCost(customerId);
    }

    /**
     * Checks if a customer has won and participated in an activity of the same type.
     *
     * @param activityId        The activity ID to check.
     * @param customerId        The customer ID to check.
     * @param customerTypeEnum  The type of customer (e.g., customer category or role).
     * @return True if the customer has won and participated in the same type of activity; otherwise, false.
     */
    public static boolean hasWonAndParticipatedInSameType(int activityId, int customerId, String customerTypeEnum) {
        return participationDAO.hasWonAndParticipatedInSameType(activityId, customerId, customerTypeEnum);
    }

    /**
     * Checks if a customer has paid an additional cost.
     *
     * @param customerId The customer ID to check.
     * @return True if the customer has paid an additional cost; otherwise, false.
     */
    public static boolean hasPaidAdditionalCost(int customerId) {
        return participationDAO.hasPaidAdditionalCost(customerId);
    }
}
