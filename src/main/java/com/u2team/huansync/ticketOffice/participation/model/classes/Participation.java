package com.u2team.huansync.ticketOffice.participation.model.classes;

/**
 * The Participation class represents the participation of a customer in a specific activity.
 */
public class Participation {
    // Fields

    /** The unique identifier of the activity. */
    private int activityId;

    /** The unique identifier of the customer participating in the activity. */
    private int customerId;

    // Constructors (if applicable)

    // Methods

    /**
     * Gets the activity ID associated with this participation.
     *
     * @return The activity ID.
     */
    public int getActivityId() {
        return activityId;
    }

    /**
     * Sets the activity ID for this participation.
     *
     * @param activityId The activity ID to set.
     */
    public void setActivityId(int activityId) {
        this.activityId = activityId;
    }

    /**
     * Gets the customer ID associated with this participation.
     *
     * @return The customer ID.
     */
    public int getCustomerId() {
        return customerId;
    }

    /**
     * Sets the customer ID for this participation.
     *
     * @param customerId The customer ID to set.
     */
    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    /**
     * Returns a string representation of the Participation object.
     *
     * @return A string representation containing activityId and customerId.
     */
    @Override
    public String toString() {
        return "Participation{" +
                "activityId=" + activityId +
                ", customerId=" + customerId +
                '}';
    }
}
