package com.u2team.huansync.ticketOffice.participation.model.classes.buildes;

import com.u2team.huansync.ticketOffice.participation.model.classes.Participation;

/**
 * The ParticipationConcreteBuilder class implements the ParticipationBuilder interface
 * and is responsible for constructing Participation objects with specific configurations.
 */
public class ParticipationConcreteBuilder implements ParticipationBuilder {

    // Instance variable to hold the Participation object being constructed.
    private Participation participation = new Participation();

    /**
     * Sets the activity ID for the Participation being built.
     *
     * @param activityId The activity ID to set.
     * @return This ParticipationConcreteBuilder instance for method chaining.
     */
    @Override
    public ParticipationBuilder activityId(int activityId) {
        participation.setActivityId(activityId);
        return this;
    }

    /**
     * Sets the customer ID for the Participation being built.
     *
     * @param customerId The customer ID to set.
     * @return This ParticipationConcreteBuilder instance for method chaining.
     */
    @Override
    public ParticipationBuilder customerId(int customerId) {
        participation.setCustomerId(customerId);
        return this;
    }

    /**
     * Builds and returns a Participation object with the configured properties.
     *
     * @return A Participation object with the specified activity ID and customer ID.
     */
    @Override
    public Participation build() {
    return participation;
    }
}
