package com.u2team.huansync.ticketOffice.tickets.model.DAO;

import java.util.List;

/**
 * Generic interface for Data Access Objects (DAOs).
 *
 * @param <T> The type of object the DAO deals with.
 */
public interface IDao<T> {

    /**
     * Retrieves an object by its ID.
     *
     * @param id The ID of the object to retrieve.
     * @return The object with the specified ID.
     */
    T getById(long id);

    /**
     * Retrieves a list of all objects.
     *
     * @return A list containing all objects of type T.
     */
    List<T> getAll();

    /**
     * Saves a new object.
     *
     * @param t The object to save.
     */
    void save(T t);

    /**
     * Updates an existing object.
     *
     * @param t The object to update.
     */
    void update(T t);

    /**
     * Deletes an object by its ID.
     *
     * @param id The ID of the object to delete.
     */
    void delete(long id);
}
