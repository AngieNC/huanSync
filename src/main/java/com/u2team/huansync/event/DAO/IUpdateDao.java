package com.u2team.huansync.event.DAO;

public interface IUpdateDao<T> extends IDao{
    /**
     * Updates an existing object in the database.
     *
     * @param t The object containing updated information.
     */
    void update(T t);
}
