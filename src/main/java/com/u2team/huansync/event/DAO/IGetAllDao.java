package com.u2team.huansync.event.DAO;

import java.util.List;

public interface IGetAllDao<T> extends IDao{
    /**
     * Retrieves a list of all objects of the specified type.
     *
     * @return A list containing all objects of the specified type.
     */
    List<T> getAll();
}
