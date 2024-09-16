package com.u2team.huansync.event.workerRoles.controller;

import com.u2team.huansync.event.workerRoles.model.DAO.WorkerRoleDAO;
import com.u2team.huansync.event.workerRoles.model.classes.WorkerRole;
import java.util.List;

/**
 *
 * @author Cristina Jerez Salas
 */
/**
 * Controller class for managing WorkerRole entities.
 */
public class WorkerRolesController {

    private static WorkerRoleDAO workerRoleDao = new WorkerRoleDAO();

    /**
     * Retrieves a WorkerRole by its ID.
     *
     * @param workerRoleId The ID of the WorkerRole to retrieve.
     * @return The WorkerRole associated with the given ID, or null if not
     * found.
     */
    public static WorkerRole getByIdWorkerRole(long workerRoleId) {
        return workerRoleDao.getById(workerRoleId);
    }

    /**
     * Retrieves a list of all WorkerRoles.
     *
     * @return A List of all WorkerRoles.
     */
    public static List<WorkerRole> getAllWorkerRoles() {
        return workerRoleDao.getAll();
    }

    /**
     * Inserts a new WorkerRole into the database.
     *
     * @param workerRole The WorkerRole object to insert.
     */
    public static void insertWorkerRole(WorkerRole workerRole) {
        workerRoleDao.save(workerRole);
    }

    /**
     * Updates an existing WorkerRole in the database.
     *
     * @param workerRole The WorkerRole object to update.
     */
    public static void updateWorkerRole(WorkerRole workerRole) {
        workerRoleDao.update(workerRole);
    }

    /**
     * Deletes a WorkerRole from the database by its ID.
     *
     * @param workerRoleId The ID of the WorkerRole to delete.
     */
    public static void deleteWorkerRole(long workerRoleId) {
        workerRoleDao.delete(workerRoleId);
    }

}
