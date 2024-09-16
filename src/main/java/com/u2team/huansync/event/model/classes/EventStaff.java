package com.u2team.huansync.event.model.classes;


/**
 * Represents the association between an event and a staff member. 
 * It contains information about the event and the staff member's identifier.
 */
public class EventStaff {
    
    // Unique identifier for the event associated with the staff member.
    private long eventId;
    
    // Unique identifier for the staff member associated with the event.
    private long staffId;


    /**
     * Constructs an EventStaff object with the specified event and staff identifiers.
     *
     * @param eventId The unique identifier for the event.
     * @param staffId The unique identifier for the staff member.
     */
    public EventStaff(long eventId, long staffId) {
        this.eventId = eventId;
        this.staffId = staffId;
    }
    public long getEventId() {
        return eventId;
    }

    public void setEventId(long eventId) {
        this.eventId = eventId;
    }

    public long getStaffId() {
        return staffId;
    }

    public void setStaffId(long staffId) {
        this.staffId = staffId;
    }

    /**
     * Overrides the default toString method to provide a string representation of the EventStaff object.
     *
     * @return A string representation of the EventStaff object.
     */
    @Override
    public String toString() {
        return "EventStaff{" +
                "eventId=" + eventId +
                ", staffId=" + staffId +
                '}';
    }
}
