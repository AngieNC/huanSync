/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.u2team.huansync.ticketOffice.client.model.DAO;

import java.util.List;

/**
 * Generic interface for Data Access Objects (DAO) providing basic CRUD (Create, Read, Update, Delete) operations.
 *
 * @param <T> The type of entity handled by the DAO.
 * @author SANTOS
 */
public interface IDao<T> {

    /**
     * Retrieves an entity by its unique identifier.
     *
     * @param id The unique identifier of the entity.
     * @return The entity with the specified identifier, or null if not found.
     */
    T getById(long id);

    /**
     * Retrieves a list of all entities of type T.
     *
     * @return A list containing all entities of type T.
     */
    List<T> getAll();

    /**
     * Saves a new entity or updates an existing one.
     *
     * @param t The entity to be saved or updated.
     */
    void save(T t);

    /**
     * Updates an existing entity.
     *
     * @param t The entity to be updated.
     */
    void update(T t);

    /**
     * Deletes an entity by its unique identifier.
     *
     * @param id The unique identifier of the entity to be deleted.
     */
    void delete(long id);

    /**
     * Searches for a participant with the specified identifier.
     *
     * @param id The identifier of the participant to be searched.
     * @return true if the participant is found, false otherwise.
     */
    boolean searchParticipant(int id);
}
