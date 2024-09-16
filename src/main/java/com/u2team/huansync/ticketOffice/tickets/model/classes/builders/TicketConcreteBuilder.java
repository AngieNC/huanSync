package com.u2team.huansync.ticketOffice.tickets.model.classes.builders;

import com.u2team.huansync.ticketOffice.tickets.model.classes.StatusEnum;
import com.u2team.huansync.ticketOffice.tickets.model.classes.Tickets;

/**
 * Interface for building Ticket objects with a fluent builder pattern.
 */

public class TicketConcreteBuilder implements TicketBuilder{

    private Tickets tickets = new Tickets();

    /**
     * Sets the ticket ID for the Tickets object.
     * @param ticketId The ticket ID to set.
     * @return The current TicketBuilder instance.
     */
    @Override
    public TicketBuilder ticketId(long ticketId) {
        tickets.setTicketId(ticketId);
        return this;
    }

    /**
     * Sets the name of the ticket for the Tickets object.
     * @param nameTicket The name of the ticket to set.
     * @return The current TicketBuilder instance.
     */
    @Override
    public TicketBuilder nameTicket(String nameTicket) {
        tickets.setNameTicket(nameTicket);
        return this;
    }

    /**
     * Sets the additional cost for the Tickets object.
     * @param additionalCost The additional cost to set.
     * @return The current TicketBuilder instance.
     */
    @Override
    public TicketBuilder additionalCost(double additionalCost) {
        tickets.setAdditionalCost(additionalCost);
        return this;
    }

    /**
     * Sets the ticket type ID for the Tickets object.
     * @param ticketTypeId The ticket type ID to set.
     * @return The current TicketBuilder instance.
     */
    @Override
    public TicketBuilder ticketTypeId(long ticketTypeId) {
        tickets.setTicketTypeId(ticketTypeId);
        return this;
    }

    /**
     * Sets the customer ID for the Tickets object.
     * @param customerId The customer ID to set.
     * @return The current TicketBuilder instance.
     */
    @Override
    public TicketBuilder customerId(long customerId) {
        tickets.setCustomerId(customerId);
        return this;
    }

    /**
     * Sets the ticket office ID for the Tickets object.
     * @param ticketOfficeId The ticket office ID to set.
     * @return The current TicketBuilder instance.
     */
    @Override
    public TicketBuilder ticketOfficeId(long ticketOfficeId) {
        tickets.setTicketOfficeId(ticketOfficeId);
        return this;
    }

    /**
     * Sets the status enum for the Tickets object based on the provided status string.
     * @param statusEnum The status string to set. Should be "reserved" or "paid".
     * @return The current TicketBuilder instance.
     */
    @Override
    public TicketBuilder statusEnum(String statusEnum) {
        if (statusEnum.equalsIgnoreCase("reserved")){
            tickets.setStatusEnum(StatusEnum.RESERVED);
        }
        if (statusEnum.equalsIgnoreCase("paid")){
            tickets.setStatusEnum(StatusEnum.PAID);
        }
        return this;
    }

    /**
     * Builds and returns the Tickets object.
     * @return The Tickets object with the configured properties.
     */
    @Override
    public Tickets buid() {
        return tickets;
    }

}
