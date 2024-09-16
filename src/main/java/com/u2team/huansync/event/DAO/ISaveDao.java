package com.u2team.huansync.event.DAO;

public interface ISaveDao<T> extends IDao{
    /**
     * Saves a new object to the database.
     *
     * @param t The object to be saved.
     */
    void save(T t);
}
