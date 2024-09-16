
package com.u2team.huansync.event.model.classes.builders;

import com.u2team.huansync.event.model.classes.AgeClassificationEnum;
import com.u2team.huansync.event.model.classes.Event;
import com.u2team.huansync.event.model.classes.StatusEnum;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 *
 * @author Cristian Pardo
 */

/**
 * This class, EventConcreteBuilder, implements the EventBuilder interface to construct instances of the Event class
 * using the builder pattern. It maintains an internal instance of the Event class and provides methods to set various
 * properties of the event.
 * 
 * The build method returns the constructed Event object.
 */
public class EventConcreteBuilder implements EventBuilder {
    
    private Event event = new Event();
    
    @Override
    public EventBuilder eventId(long eventId) {
        event.setEventId(eventId);
        return this;
    }

    @Override
    public EventBuilder nameEvent(String nameEvent) {
        event.setNameEvent(nameEvent);
        return this;
    }

    @Override
    public EventBuilder country(String country) {
        event.setCountry(country);
        return this;
    }

    @Override
    public EventBuilder city(String city) {
        event.setCity(city);
        return this;
    }

    @Override
    public EventBuilder address(String address) {
        event.setAddress(address);
        return this;
    }

    @Override
    public EventBuilder peopleCapacity(int peopleCapacity) {
        event.setPeopleCapacity(peopleCapacity);
        return this;
    }

    @Override
    public EventBuilder storeCapacity(int storeCapacity) {
        event.setStoreCapacity(storeCapacity);
        return this;
    }

    @Override
    public EventBuilder restaurantCapacity(int restaurantCapacity) {
        event.setRestaurantCapacity(restaurantCapacity);
        return this;
    }

    @Override
    public EventBuilder dateEvent(LocalDate dateEvent) {
        event.setDateEvent(dateEvent);
        return this;
    }

    @Override
    public EventBuilder timeEvent(LocalTime timeEvent) {
        event.setTimeEvent(timeEvent);
        return this;
    }

    @Override
    public EventBuilder organizerId(long organizerId) {
        event.setOrganizerId(organizerId);
        return this;
    }

    @Override
    public Event build() {
        return event;
    }

    @Override
    public EventBuilder ageClassificationEnum(String ageClassificationEnum) {

        if (ageClassificationEnum.equalsIgnoreCase("family")){
            event.setAgeClassification(AgeClassificationEnum.FAMILY);
        }
        if (ageClassificationEnum.equalsIgnoreCase("younger")){
            event.setAgeClassification(AgeClassificationEnum.YOUNGER);
        }
        if (ageClassificationEnum.equalsIgnoreCase("adult")){
            event.setAgeClassification(AgeClassificationEnum.ADULT);
        }
            return this;
    }

    @Override
    public EventBuilder statusEnum(String statusEnum) {

        if (statusEnum.equalsIgnoreCase("active")){
            event.setStatusEnum(StatusEnum.ACTIVE);
        }
        if (statusEnum.equalsIgnoreCase("pending")){
            event.setStatusEnum(StatusEnum.PENDING);
        }
        if (statusEnum.equalsIgnoreCase("finished")){
            event.setStatusEnum(StatusEnum.FINISHED);
            }
        return this;
    }
    
}
