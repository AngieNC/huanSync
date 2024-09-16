package com.u2team.huansync.ticketOffice.model.builders;

import com.u2team.huansync.ticketOffice.model.classes.TicketOffice;

/**
 * Implementation of the TicketOfficeBuilder interface for constructing instances of TicketOffice entities.
 */
public class TicketOfficeBuilderOficial implements TicketOfficeBuilder {

    private TicketOffice ticketOffice = new TicketOffice();

    /**
     * Sets the ticket office ID for the TicketOffice being constructed.
     *
     * @param ticketOfficeId The unique identifier of the TicketOffice.
     * @return The TicketOfficeBuilder instance.
     */
    @Override
    public TicketOfficeBuilder ticketOfficeId(long ticketOfficeId) {
        ticketOffice.setTicketOfficeId(ticketOfficeId);
        return this;
    }

    /**
     * Sets the event ID for the TicketOffice being constructed.
     *
     * @param eventId The unique identifier of the event associated with the TicketOffice.
     * @return The TicketOfficeBuilder instance.
     */
    @Override
    public TicketOfficeBuilder eventId(long eventId) {
        ticketOffice.setEventId(eventId);
        return this;
    }

    /**
     * Sets the location for the TicketOffice being constructed.
     *
     * @param location The location status of the TicketOffice.
     * @return The TicketOfficeBuilder instance.
     */
    @Override
    public TicketOfficeBuilder location(boolean location) {
        ticketOffice.setLocation(location);
        return this;
    }

    /**
     * Sets the address for the TicketOffice being constructed.
     *
     * @param address The address of the TicketOffice.
     * @return The TicketOfficeBuilder instance.
     */
    @Override
    public TicketOfficeBuilder address(String address) {
        ticketOffice.setAddress(address);
        return this;
    }

    /**
     * Sets the contact number for the TicketOffice being constructed.
     *
     * @param contactNumber The contact number of the TicketOffice.
     * @return The TicketOfficeBuilder instance.
     */
    @Override
    public TicketOfficeBuilder contactNumber(String contactNumber) {
        ticketOffice.setContactNumber(contactNumber);
        return this;
    }

    /**
     * Sets the staff ID for the TicketOffice being constructed.
     *
     * @param staffId The unique identifier of the staff associated with the TicketOffice.
     * @return The TicketOfficeBuilder instance.
     */
    @Override
    public TicketOfficeBuilder staffId(long staffId) {
        ticketOffice.setStaffId(staffId);
        return this;
    }

    /**
     * Builds and returns the fully constructed TicketOffice entity.
     *
     * @return The constructed TicketOffice entity.
     */
    @Override
    public TicketOffice build() {
        return ticketOffice;
    }
}
