package com.u2team.huansync.event.model.classes;

import java.time.*;

/**
 *
 * @author Cristian Pardo
 */


/**
 * Represents an event with various properties such as name, location, capacity, date, etc.
 * This class provides methods to access and modify the attributes of the event.
 */
public class Event {

    // Class Attributes
    
    // Unique identifier for the event.
    private long eventId;

    
    // Name of the event.
    private String nameEvent;

    
    // Country where the event is held.
    private String country;

    
    // City where the event takes place.
    private String city;

    
    // Address of the event.
    private String address;

    
    // Capacity of people allowed at the event.
    private int peopleCapacity;

    
    // Capacity of stores allowed at the event.
    private int storeCapacity;

    
    // Capacity of restaurants allowed at the event.
    private int restaurantCapacity;

    
    // Date of the event.
    private LocalDate dateEvent;

    
    // Time of the event.
    private LocalTime timeEvent;

    
    // Organizer's identifier for the event.
    private long organizerId;

    
    // Age classification of the event.
    private AgeClassificationEnum ageClassification;

    
    // Status enumeration of the event.
    private StatusEnum statusEnum;


    // Constructor without arguments.

    /**
     * Parameterized constructor to initialize all attributes with provided values.
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
     */
    public Event() {
    }

    public Event(long eventId, String nameEvent, String country, String city, String address, int peopleCapacity, int storeCapacity, int restaurantCapacity, LocalDate dateEvent, LocalTime timeEvent, long organizerId, AgeClassificationEnum ageClassification, StatusEnum statusEnum) {
        this.eventId = eventId;
        this.nameEvent = nameEvent;
        this.country = country;
        this.city = city;
        this.address = address;
        this.peopleCapacity = peopleCapacity;
        this.storeCapacity = storeCapacity;
        this.restaurantCapacity = restaurantCapacity;
        this.dateEvent = dateEvent;
        this.timeEvent = timeEvent;
        this.organizerId = organizerId;
        this.ageClassification = ageClassification;
        this.statusEnum = statusEnum;
    }

    // Get and set methods for eventId
    public long getEventId() {
        return eventId;
    }

    public void setEventId(long eventId) {
        this.eventId = eventId;
    }

    // Get and set methods for nameEvent
    public String getNameEvent() {
        return nameEvent;
    }

    public void setNameEvent(String nameEvent) {
        this.nameEvent = nameEvent;
    }

    // Get and set methods for country
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    // Get and set methods for city
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    // Get and set methods for address
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    // Get and set methods for peopleCapacity
    public int getPeopleCapacity() {
        return peopleCapacity;
    }

    public void setPeopleCapacity(int peopleCapacity) {
        this.peopleCapacity = peopleCapacity;
    }

    // Get and set methods for storeCapacity
    public int getStoreCapacity() {
        return storeCapacity;
    }

    public void setStoreCapacity(int storeCapacity) {
        this.storeCapacity = storeCapacity;
    }

    // Get and set methods for restaurantCapacity
    public int getRestaurantCapacity() {
        return restaurantCapacity;
    }

    public void setRestaurantCapacity(int restaurantCapacity) {
        this.restaurantCapacity = restaurantCapacity;
    }

    // Get and set methods for dateEvent
    public LocalDate getDateEvent() {
        return dateEvent;
    }

    public void setDateEvent(LocalDate dateEvent) {
        this.dateEvent = dateEvent;
    }

    // Get and set methods for timeEvent
    public LocalTime getTimeEvent() {
        return timeEvent;
    }

    public void setTimeEvent(LocalTime timeEvent) {
        this.timeEvent = timeEvent;
    }

    // Get and set methods for organizerId
    public long getOrganizerId() {
        return organizerId;
    }

    public void setOrganizerId(long organizerId) {
        this.organizerId = organizerId;
    }

    // Get and set methods for ageClassification
    public AgeClassificationEnum getAgeClassification() {
        return ageClassification;
    }

    public void setAgeClassification(AgeClassificationEnum ageClassification) {
        this.ageClassification = ageClassification;
    }

    // Get and set methods for statusEnum
    public StatusEnum getStatusEnum() {
        return statusEnum;
    }

    public void setStatusEnum(StatusEnum statusEnum) {
        this.statusEnum = statusEnum;
    }

    /**
     * Overrides the default toString method to provide a string representation of the Event object.
     *
     * @return A string representation of the Event object.
     */
    @Override
    public String toString() {
        return "Event{" + "eventId=" + eventId + ", nameEvent=" + nameEvent + ", country=" + country + ", city=" + city + ", address=" + address + ", peopleCapacity=" + peopleCapacity + ", storeCapacity=" + storeCapacity + ", restaurantCapacity=" + restaurantCapacity + ", dateEvent=" + dateEvent + ", timeEvent=" + timeEvent + ", organizerId=" + organizerId + ", ageClassification=" + ageClassification + ", statusEnum=" + statusEnum + '}';
    }
    
    
    
    
}