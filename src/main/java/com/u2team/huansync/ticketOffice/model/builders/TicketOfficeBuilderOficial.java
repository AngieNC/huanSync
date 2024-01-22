package com.u2team.huansync.ticketOffice.model.builders;

import com.u2team.huansync.ticketOffice.model.*;
import com.u2team.huansync.ticketOffice.model.Event;


public class TicketOfficeBuilderOficial implements TicketOfficeBuilder {

    private TicketOffice ticketOffice = new TicketOffice();

    @Override
    public TicketOfficeBuilder ticketOfficeId(long ticketOfficeId) {
        ticketOffice.setTicketOfficeId(ticketOfficeId);
        return this;
    }

    @Override
    public TicketOfficeBuilder eventId(Event eventId) {
        ticketOffice.setEventId(eventId);
        return this;
    }

    @Override
    public TicketOfficeBuilder location(boolean location) {
        ticketOffice.setLocation(location);
        return this;
    }

    @Override
    public TicketOfficeBuilder address(String address) {

        ticketOffice.setAddress(address);
        return this;
    }

    @Override
    public TicketOfficeBuilder contactNumber(String contactNumber) {
        ticketOffice.setContactNumber(contactNumber);
        return this;
    }

    @Override
    public TicketOfficeBuilder staffId(Event staffId) {

        ticketOffice.setStaffId(staffId);
        return this;
    }

    @Override
    public TicketOffice build() {
        return ticketOffice;
    }

    
}
