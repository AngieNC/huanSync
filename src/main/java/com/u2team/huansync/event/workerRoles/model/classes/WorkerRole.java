package com.u2team.huansync.event.workerRoles.model.classes;

import java.util.List;

/**
 *
 * @author Edgar Pinzon
 */

public class WorkerRole {

    private long workerRoleId;
    private String workerRoleName;
    private List<String> workerRoleActivities;

    public WorkerRole() {
    }

    public WorkerRole(String workerRoleName, List<String> Activites) {
        this.workerRoleName = workerRoleName;
        this.workerRoleActivities = Activites;
    }

    public long getWorkerRoleId() {
        return workerRoleId;
    }

    public void setWorkerRoleId(long workerRoleId) {
        this.workerRoleId = workerRoleId;
    }

    public String getWorkerRoleName() {
        return workerRoleName;
    }

    public void setWorkerRoleName(String workerRoleName) {
        this.workerRoleName = workerRoleName;
    }

    public List<String> getActivitiesWorkerRole() {
        return workerRoleActivities;
    }

    public void setWorkerRoleActivities(List<String> workerRoleActivities) {
        this.workerRoleActivities = workerRoleActivities;
    }

    @Override
    public String toString() {
        return "WorkerRole{" + "workerRoleId=" + workerRoleId + ", workerRoleName=" + workerRoleName + ", workerRoleActivities=" + workerRoleActivities + '}';
    }

    
}
