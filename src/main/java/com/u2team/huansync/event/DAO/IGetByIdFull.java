package com.u2team.huansync.event.DAO;

/**
 * An interface that extends IDao, providing a method to retrieve an entity by its ID with full details.
 * This interface is generic, allowing for any type of entity to be retrieved.
 *
 * @param <T> The type of the entity to be retrieved.
 */
public interface IGetByIdFull <T> extends IDao {

    /**
     * Retrieves an entity of type T by its ID, potentially including all its detailed information.
     * 
     * @param id The unique identifier of the entity to be retrieved.
     * @return An instance of type T corresponding to the provided ID, or null if not found.
     */
    T getById(long id);
}
