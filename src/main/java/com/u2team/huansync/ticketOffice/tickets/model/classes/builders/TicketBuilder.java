package com.u2team.huansync.ticketOffice.tickets.model.classes.builders;

import com.u2team.huansync.ticketOffice.tickets.model.classes.Tickets;

/**
 * Interface for building Ticket objects with a fluent builder pattern.
 */
public interface TicketBuilder {
    /**
     * Sets the ticket ID for the ticket being built.
     *
     * @param ticketId The ID to set for the ticket.
     * @return The current TicketBuilder instance.
     */
    TicketBuilder ticketId(long ticketId);

    /**
     * Sets the name of the ticket being built.
     *
     * @param nameTicket The name to set for the ticket.
     * @return The current TicketBuilder instance.
     */
    TicketBuilder nameTicket(String nameTicket);

    /**
     * Sets the additional cost for the ticket being built.
     *
     * @param additionalCost The additional cost to set for the ticket.
     * @return The current TicketBuilder instance.
     */
    TicketBuilder additionalCost(double additionalCost);

    /**
     * Sets the status enumeration for the ticket being built.
     *
     * @param statusEnum The status enumeration to set for the ticket.
     * @return The current TicketBuilder instance.
     */
    TicketBuilder statusEnum(String statusEnum);

    /**
     * Sets the ticket type ID for the ticket being built.
     *
     * @param ticketTypeId The ticket type ID to set for the ticket.
     * @return The current TicketBuilder instance.
     */
    TicketBuilder ticketTypeId(long ticketTypeId);

    /**
     * Sets the customer ID for the ticket being built.
     *
     * @param customerId The customer ID to set for the ticket.
     * @return The current TicketBuilder instance.
     */
    TicketBuilder customerId(long customerId);

    /**
     * Sets the ticket office ID for the ticket being built.
     *
     * @param ticketOfficeId The ticket office ID to set for the ticket.
     * @return The current TicketBuilder instance.
     */
    TicketBuilder ticketOfficeId(long ticketOfficeId);

    /**
     * Builds and returns the Ticket object with the configured properties.
     *
     * @return The constructed Tickets object.
     */
    Tickets buid();


}
