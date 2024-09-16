package com.u2team.huansync.event.staff.model.classes;

import com.u2team.huansync.event.workerRoles.model.classes.WorkerRole;
import java.time.LocalDate;

/**
 *
 * @author Cristina Jerez Salas
 */
/**
 * Extends the Staff class to include full details about the staff member. This
 * class includes all fields from Staff, with the addition of the worker's role.
 */
public class StaffFull extends Staff {

    private WorkerRole workerRole;

    public StaffFull() {
    }

    /**
     * Constructs a StaffFull instance with specified details, including the
     * staff member's role.
     *
     * @param staffId Unique identifier for the staff member.
     * @param staffNumberId Staff number identifier.
     * @param nameStaff Name of the staff member.
     * @param birthdayStaff Birthday of the staff member.
     * @param statusStaffEnum String representation of the staff status enum.
     * @param workerRoleId Worker role ID associated with the staff member.
     * @param workerRole WorkerRole object representing the staff member's role.
     */
    public StaffFull(long staffId, String staffNumberId, String nameStaff, LocalDate birthdayStaff, String statusStaffEnum, long workerRoleId, WorkerRole workerRole) {
        super(staffId, staffNumberId, nameStaff, birthdayStaff, statusStaffEnum, workerRoleId);
        this.workerRole = workerRole;
    }

    /**
     * Gets the worker role of the staff member.
     *
     * @return The WorkerRole object associated with the staff member.
     */
    public WorkerRole getWorkerRole() {
        return workerRole;
    }

    /**
     * Sets the worker role for this staff member.
     *
     * @param workerRole The WorkerRole object to set.
     */
    public void setWorkerRole(WorkerRole workerRole) {
        this.workerRole = workerRole;
    }

    /**
     * Returns a string representation of the StaffFull object, including worker
     * role details.
     *
     * @return String containing the staff member's full details.
     */
    @Override
    public String toString() {
        return super.toString()
                + " " + workerRole
                + '}';
    }
}
