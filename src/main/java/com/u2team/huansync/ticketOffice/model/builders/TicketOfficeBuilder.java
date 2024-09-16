package com.u2team.huansync.ticketOffice.model.builders;

import com.u2team.huansync.ticketOffice.model.classes.TicketOffice;

/**
 * Interface for building instances of TicketOffice entities.
 */
public interface TicketOfficeBuilder {

    /**
     * Sets the ticket office ID for the TicketOffice being constructed.
     *
     * @param ticketOfficeId The unique identifier of the TicketOffice.
     * @return The TicketOfficeBuilder instance.
     */
    TicketOfficeBuilder ticketOfficeId(long ticketOfficeId);

    /**
     * Sets the event ID for the TicketOffice being constructed.
     *
     * @param eventId The unique identifier of the event associated with the TicketOffice.
     * @return The TicketOfficeBuilder instance.
     */
    TicketOfficeBuilder eventId(long eventId);

    /**
     * Sets the location for the TicketOffice being constructed.
     *
     * @param location The location status of the TicketOffice.
     * @return The TicketOfficeBuilder instance.
     */
    TicketOfficeBuilder location(boolean location);

    /**
     * Sets the address for the TicketOffice being constructed.
     *
     * @param address The address of the TicketOffice.
     * @return The TicketOfficeBuilder instance.
     */
    TicketOfficeBuilder address(String address);

    /**
     * Sets the contact number for the TicketOffice being constructed.
     *
     * @param contactNumber The contact number of the TicketOffice.
     * @return The TicketOfficeBuilder instance.
     */
    TicketOfficeBuilder contactNumber(String contactNumber);

    /**
     * Sets the staff ID for the TicketOffice being constructed.
     *
     * @param staffId The unique identifier of the staff associated with the TicketOffice.
     * @return The TicketOfficeBuilder instance.
     */
    TicketOfficeBuilder staffId(long staffId);

    /**
     * Builds and returns the fully constructed TicketOffice entity.
     *
     * @return The constructed TicketOffice entity.
     */
    TicketOffice build();
}
