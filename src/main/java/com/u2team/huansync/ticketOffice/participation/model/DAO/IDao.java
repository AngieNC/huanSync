package com.u2team.huansync.ticketOffice.participation.model.DAO;

/**
 * The IDao interface defines the contract for data access operations related to Participation entities.
 *
 * @param <T> The type of entity that this DAO operates on.
 */
public interface IDao<T> {

    /**
     * Inserts a new Participation record into the data store.
     *
     * @param activityId        The activity ID associated with the participation.
     * @param customerId        The customer ID associated with the participation.
     * @param customerTypeEnum  The type of customer (e.g., customer category or role).
     */
    void insertParticipation(int activityId, int customerId, String customerTypeEnum);

}
