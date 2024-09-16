package com.u2team.huansync.ticketOffice.participation.model.classes.buildes;

import com.u2team.huansync.ticketOffice.participation.model.classes.Participation;
/**
 * The ParticipationBuilder interface provides a set of methods to build Participation objects.
 */
public interface ParticipationBuilder {
    /**
     * Sets the activity ID for the Participation being built.
     *
     * @param activityId The activity ID to set.
     * @return This ParticipationBuilder instance for method chaining.
     */
    ParticipationBuilder activityId(int activityId);

    /**
     * Sets the customer ID for the Participation being built.
     *
     * @param customerId The customer ID to set.
     * @return This ParticipationBuilder instance for method chaining.
     */
    ParticipationBuilder customerId(int customerId);

    /**
     * Builds and returns a Participation object with the configured properties.
     *
     * @return A Participation object with the specified activity ID and customer ID.
     */
    Participation build();
}
