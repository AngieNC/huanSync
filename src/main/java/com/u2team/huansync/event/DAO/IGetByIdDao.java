package com.u2team.huansync.event.DAO;

public interface IGetByIdDao<T> extends IDao{
    /**
     * Retrieves an object by its unique identifier.
     *
     * @param id The unique identifier of the object.
     * @return The object with the specified identifier, or null if not found.
     */
    T getById(long id);
}
