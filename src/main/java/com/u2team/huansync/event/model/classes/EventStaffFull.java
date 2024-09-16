package com.u2team.huansync.event.model.classes;

import com.u2team.huansync.event.staff.model.classes.Staff;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;


/**
 * The code defines a class called EventStaffFull that extends the Event class.
 * class represents an event along with detailed information about the staff members associated with that event.
 * In addition to inheriting attributes from the base class Event, the EventStaffFull class includes a list of Staff
 * objects representing the staff members associated with the event.
 * */
public class EventStaffFull extends Event{

    // List of staff members associated with the event.
    private List<Staff> staff;

    // Constructor Default with no arguments.
    public EventStaffFull() {
    }

    /**
     * Constructs an EventStaffFull object with the specified event details, including staff information.
     *
     * @param eventId              Unique identifier for the event.
     * @param nameEvent            Name of the event.
     * @param country              Country where the event is held.
     * @param city                 City where the event takes place.
     * @param address              Address of the event.
     * @param peopleCapacity      Capacity of people allowed at the event.
     * @param storeCapacity        Capacity of stores allowed at the event.
     * @param restaurantCapacity   Capacity of restaurants allowed at the event.
     * @param dateEvent            Date of the event.
     * @param timeEvent            Time of the event.
     * @param organizerId          Organizer's identifier for the event.
     * @param ageClassification    Age classification of the event.
     * @param statusEnum           Status enumeration of the event.
     * @param staff                List of staff members associated with the event.
     */
    public EventStaffFull(long eventId, String nameEvent, String country, String city, String address, int peopleCapacity, int storeCapacity, int restaurantCapacity, LocalDate dateEvent, LocalTime timeEvent, long organizerId, AgeClassificationEnum ageClassification, StatusEnum statusEnum, List<Staff> staff) {
        super(eventId, nameEvent, country, city, address, peopleCapacity, storeCapacity, restaurantCapacity, dateEvent, timeEvent, organizerId, ageClassification, statusEnum);
        this.staff = staff;
    }

    /**
     * Retrieves the list of staff members associated with the event.
     *
     * @return The list of staff members.
     */
    public List<Staff> getStaff() {
        return staff;
    }


    /**
     * Sets the list of staff members associated with the event.
     *
     * @param staff The list of staff members to set.
     */
    public void setStaff(List<Staff> staff) {
        this.staff = staff;
    }


    // toString method
    /**
     * Overrides the default toString method to provide a string representation of the EventStaffFull object.
     *
     * @return A string representation of the EventStaffFull object.
     */

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("\n ===== \n");
        if(staff != null){
            for (Staff s : staff){
                sb.append(s + "\n");
            }
        }
        return sb.toString();
    }
}
