package com.u2team.huansync.event.controller;

import com.u2team.huansync.event.model.DAO.EventDAO;
import com.u2team.huansync.event.model.DAO.EventStaffDAO;
import com.u2team.huansync.event.model.classes.Event;
import com.u2team.huansync.event.model.classes.EventStaff;
import com.u2team.huansync.event.model.classes.EventStaffFull;
import java.util.List;

/**
 * Controller class for managing event-related operations.
 * This class provides methods to interact with the EventDAO and EventStaffDAO
 * for CRUD operations on events and their associated staff.
 *
 * @author Christian Pardo
 */
public class EventController {

    private static EventDAO eventDao = new EventDAO();
    private static EventStaffDAO eventStaffDao = new EventStaffDAO();

    /**
     * Retrieves an event by its ID.
     *
     * @param eventId The ID of the event to retrieve.
     * @return Event object corresponding to the specified ID, or null if not found.
     */
    public static Event getByIdEvent(long eventId) {
        return eventDao.getById(eventId);
    }

    /**
     * Retrieves a list of all events.
     *
     * @return List of all Event objects in the database.
     */
    public static List<Event> getAllEvents() {
        return eventDao.getAll();
    }

    /**
     * Inserts a new event into the database.
     *
     * @param event Event object to be inserted.
     */
    public static void insertEvent(Event event) {
        eventDao.save(event);
    }

    /**
     * Updates an existing event in the database.
     *
     * @param event Event object containing updated information.
     */
    public static void updateEvent(Event event) {
        eventDao.update(event);
    }

    /**
     * Deletes an event from the database using its ID.
     *
     * @param eventId ID of the event to be deleted.
     */
    public static void deleteEvent(long eventId) {
        eventDao.delete(eventId);
    }

    /**
     * Retrieves a list of all events, including detailed information about the staff
     * associated with each event.
     *
     * @return List of EventStaffFull objects, each representing an event with its
     *         associated staff details.
     */
    public static List<EventStaffFull> getAllFullEvents() {
        return eventDao.getAllFull();
    }

    /**
     * Inserts a new EventStaff record into the database.
     *
     * @param eventStaff EventStaff object to be inserted.
     */
    public static void insertEventStaffDAO(EventStaff eventStaff) {
        eventStaffDao.save(eventStaff);
    }
}
