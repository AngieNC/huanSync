package com.u2team.huansync.ticketOffice.tickets.model.classes;

/**
 * Class representing a ticket with various properties.
 */
public class Tickets {
    private long ticketId;
    private String nameTicket;
    private double additionalCost;
    private StatusEnum statusEnum;
    private long ticketTypeId;
    private long customerId;
    private long ticketOfficeId;

    /**
     * Gets the ticket type ID.
     * @return The ticket type ID.
     */
    public long getTicketTypeId() {
        return ticketTypeId;
    }

    /**
     * Sets the ticket type ID.
     * @param ticketTypeId The ticket type ID to set.
     */
    public void setTicketTypeId(long ticketTypeId) {
        this.ticketTypeId = ticketTypeId;
    }

    /**
     * Gets the customer ID.
     * @return The customer ID.
     */
    public long getCustomerId() {
        return customerId;
    }

    /**
     * Sets the customer ID.
     * @param customerId The customer ID to set.
     */
    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    /**
     * Gets the ticket office ID.
     * @return The ticket office ID.
     */
    public long getTicketOfficeId() {
        return ticketOfficeId;
    }

    /**
     * Sets the ticket office ID.
     * @param ticketOfficeId The ticket office ID to set.
     */
    public void setTicketOfficeId(long ticketOfficeId) {
        this.ticketOfficeId = ticketOfficeId;
    }

    /**
     * Gets the status enum of the ticket.
     * @return The status enum of the ticket.
     */
    public StatusEnum getStatusEnum() {
        return statusEnum;
    }

    /**
     * Sets the status enum of the ticket.
     * @param statusEnum The status enum to set.
     */
    public void setStatusEnum(StatusEnum statusEnum) {
        this.statusEnum = statusEnum;
    }

    /**
     * Gets the name of the ticket.
     * @return The name of the ticket.
     */
    public String getNameTicket() {
        return nameTicket;
    }

    /**
     * Sets the name of the ticket.
     * @param nameTicket The name of the ticket to set.
     */
    public void setNameTicket(String nameTicket) {
        this.nameTicket = nameTicket;
    }

    /**
     * Gets the additional cost of the ticket.
     * @return The additional cost of the ticket.
     */
    public double getAdditionalCost() {
        return additionalCost;
    }

    /**
     * Sets the additional cost of the ticket.
     * @param additionalCost The additional cost to set.
     */
    public void setAdditionalCost(double additionalCost) {
        this.additionalCost = additionalCost;
    }

    /**
     * Gets the ticket ID.
     * @return The ticket ID.
     */
    public long getTicketId() {
        return ticketId;
    }

    /**
     * Sets the ticket ID.
     * @param ticketId The ticket ID to set.
     */
    public void setTicketId(long ticketId) {
        this.ticketId = ticketId;
    }

    /**
     * Provides a string representation of the Tickets object.
     * @return A string representation of the Tickets object.
     */
    @Override
    public String toString() {
        return "Tickets{" +
                "ticketId=" + ticketId +
                ", nameTicket='" + nameTicket + '\'' +
                ", additionalCost=" + additionalCost +
                ", statusEnum=" + statusEnum +
                ", ticketTypeId=" + ticketTypeId +
                ", customerId=" + customerId +
                ", ticketOfficeId=" + ticketOfficeId +
                '}';
    }
}
