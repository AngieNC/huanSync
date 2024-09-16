package com.u2team.huansync.event.staff.model.classes;

import java.time.LocalDate;

/**
 *
 * @author Cristina Jerez Salas
 */
/**
 * Represents a staff member in the system. This class holds details about a
 * staff member such as ID, staff number, name, birthday, status, and worker
 * role ID.
 */
public class Staff {

    private long staffId;
    private String staffNumberId;
    private String nameStaff;
    private LocalDate birthdayStaff;
    private StatusStaffEnum statusStaffEnum;
    private long workerRoleId;

    //Construter
    public Staff() {
    }

    /**
     * Constructs a Staff instance with specified details.
     *
     * @param staffId Unique identifier for the staff member.
     * @param staffNumberId Staff number identifier.
     * @param nameStaff Name of the staff member.
     * @param birthdayStaff Birthday of the staff member.
     * @param statusStaffEnum String representation of the staff status enum.
     * @param workerRoleId Worker role ID associated with the staff member.
     */
    public Staff(long staffId, String staffNumberId, String nameStaff, LocalDate birthdayStaff, String statusStaffEnum, long workerRoleId) {
        this.staffId = staffId;
        this.staffNumberId = staffNumberId;
        this.nameStaff = nameStaff;
        this.birthdayStaff = birthdayStaff;
        this.statusStaffEnum = getStatusStaffEnum(statusStaffEnum);
        this.workerRoleId = workerRoleId;
    }

    //Getter and Setters
    public long getStaffId() {
        return staffId;
    }

    public void setStaffId(long staffId) {
        this.staffId = staffId;
    }

    public String getStaffNumberId() {
        return staffNumberId;
    }

    public void setStaffNumberId(String staffNumberId) {
        this.staffNumberId = staffNumberId;
    }

    public String getNameStaff() {
        return nameStaff;
    }

    public void setNameStaff(String nameStaff) {
        this.nameStaff = nameStaff;
    }

    public LocalDate getBirthdayStaff() {
        return birthdayStaff;
    }

    public void setBirthdayStaff(LocalDate birthdayStaff) {
        this.birthdayStaff = birthdayStaff;
    }

    public StatusStaffEnum getStatusStaffEnum() {
        return statusStaffEnum;
    }

    public void setStatusStaffEnum(StatusStaffEnum statusStaffEnum) {
        this.statusStaffEnum = statusStaffEnum;
    }

    public long getWorkerRoleId() {
        return workerRoleId;
    }

    public void setWorkerRoleId(long workerRoleId) {
        this.workerRoleId = workerRoleId;
    }

    /**
     * Converts a string representation of staff status to its corresponding
     * StatusStaffEnum value.
     *
     * @param statusStaffEnum The string representation of the staff status.
     * @return The corresponding StatusStaffEnum value, or null if the input
     * does not match any status.
     */
    public StatusStaffEnum getStatusStaffEnum(String statusStaffEnum) {
        StatusStaffEnum statusEnum = null;

        if (statusStaffEnum.equalsIgnoreCase("task_assigned")) {
            statusEnum = StatusStaffEnum.TASK_ASSIGNED;
        }
        if (statusStaffEnum.equalsIgnoreCase("no_task_assigned")) {
            statusEnum = StatusStaffEnum.NO_TASK_ASSIGNED;
        }
        if (statusStaffEnum.equalsIgnoreCase("dismissed")) {
            statusEnum = StatusStaffEnum.DISMISSED;
        }
        if (statusStaffEnum.equalsIgnoreCase("incapacited")) {
            statusEnum = StatusStaffEnum.INCAPACITED;
        }

        return statusEnum;
    }

    //toString
    /**
     * Returns a string representation of the Staff object.
     *
     * @return String containing the staff member's details.
     */
    @Override
    public String toString() {
        return "Staff{"
                + "staffId=" + staffId
                + ", staffNumberId='" + staffNumberId + '\''
                + ", nameStaff='" + nameStaff + '\''
                + ", birthdayStaff=" + birthdayStaff
                + ", statusStaffEnum=" + statusStaffEnum
                + ", workerRoleId=" + workerRoleId
                + '}';
    }
}
