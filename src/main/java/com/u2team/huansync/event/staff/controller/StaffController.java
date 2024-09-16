package com.u2team.huansync.event.staff.controller;

import com.u2team.huansync.event.staff.model.DAO.StaffDAO;
import com.u2team.huansync.event.staff.model.classes.Staff;
import java.util.List;

/**
 *
 * @author Cristina Jerez Salas
 */
/**
 * Controller class for managing staff-related operations.
 * This class provides methods to interact with the StaffDAO for CRUD operations.
 */
public class StaffController {
    private static StaffDAO staffDAO = new StaffDAO();

    
    /**
     * Retrieves a staff member by their ID.
     *
     * @param staffId The ID of the staff member to retrieve.
     * @return Staff object corresponding to the provided ID, or null if not found.
     */
    public static Staff getByIdStaff(long staffId){
        return staffDAO.getById(staffId);
    }
    
     /**
     * Retrieves all staff members.
     *
     * @return A list of all staff members and match the workerRoleId .
     */
    public static Staff getByIdFullStaff(long staffId){
        return staffDAO.getByIdFull(staffId);
    }
    
    /**
     * Retrieves all staff members.
     *
     * @return A list of all staff members.
     */
    public static List<Staff> getAllStaff(){
        return staffDAO.getAll();
    }
    
    /**
     * Inserts a new staff member into the database.
     *
     * @param staff The Staff object to be inserted.
     */
    public static void insertStaff(Staff staff){
        staffDAO.save(staff);
    }
    


    /**
     * Updates the information of an existing staff member in the database.
     *
     * @param staff The Staff object with updated information.
     */
    public static void updateStaff(Staff staff){
        staffDAO.update(staff);
    }
    
        /**
     * Deletes a staff member from the database by their ID.
     *
     * @param staffId The ID of the staff member to delete.
     */
    public static void deleteStaff(long staffId){
        staffDAO.delete(staffId);
    }
}
