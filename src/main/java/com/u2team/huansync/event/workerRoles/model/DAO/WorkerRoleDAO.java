package com.u2team.huansync.event.workerRoles.model.DAO;

import com.u2team.huansync.event.DAO.*;
import com.u2team.huansync.event.workerRoles.model.classes.WorkerRole;
import com.u2team.huansync.persistence.BDConnection;
import com.u2team.huansync.persistence.Operations;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Edgar Pinzon
 */
public class WorkerRoleDAO implements IGetByIdDao<WorkerRole>, IGetAllDao<WorkerRole>, ISaveDao<WorkerRole>, IUpdateDao<WorkerRole>, IDeleteDao<WorkerRole> {

    @Override
    public WorkerRole getById(long workerRoleid) {
        Operations.setConnection(BDConnection.MySQLConnection());
        String stm = "select * from tbl_workerRoles where workerRoleId = ? ;";
        try (PreparedStatement ps = Operations.getConnection().prepareStatement(stm)) {
            ps.setLong(1, workerRoleid);
            ResultSet rs = Operations.query_db(ps);
            if (rs.next()) {
                WorkerRole workerRole = new WorkerRole();
                workerRole.setWorkerRoleId(rs.getLong("workerRoleId"));

                workerRole.setWorkerRoleName(rs.getString("nameWorkerRole"));
                List<String> listActivities = Arrays.asList(rs.getString("activitiesWorkerRole").split("\\|"));
                workerRole.setWorkerRoleActivities(listActivities);
                return workerRole;
            } else {
                System.out.println("ERROR: The id has not been found");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<WorkerRole> getAll() {
        List<WorkerRole> workerRolesList = new ArrayList<>();
        Operations.setConnection(BDConnection.MySQLConnection());
        String stm = "select * from tbl_workerRoles ;";
        try (PreparedStatement ps = Operations.getConnection().prepareStatement(stm)) {

            ResultSet rs = Operations.query_db(ps);

            while (rs.next()) {
                WorkerRole workerRole = new WorkerRole();
                workerRole.setWorkerRoleId(rs.getLong("workerRoleId"));
                workerRole.setWorkerRoleName(rs.getString("nameWorkerRole"));
                List<String> listActivities = Arrays.asList(rs.getString("activitiesWorkerRole").split("\\|"));
                workerRole.setWorkerRoleActivities(listActivities);
                workerRolesList.add(workerRole);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return workerRolesList;
    }

    @Override
    public void save(WorkerRole workerRole) {
        Operations.setConnection(BDConnection.MySQLConnection());
        String stmInsert = "INSERT INTO tbl_workerRoles (nameWorkerRole,activitiesWorkerRole) VALUES (?,?);";
        try (PreparedStatement ps = Operations.getConnection().prepareStatement(stmInsert)) {
            ps.setString(1, workerRole.getWorkerRoleName());
            String activitiesWorkerRole = String.join("|", workerRole.getActivitiesWorkerRole());
            ps.setString(2, activitiesWorkerRole);

            int rows = Operations.insert_update_delete_db(ps);
            if (rows <= 0) {
                System.out.println("Cannot insert worker role");
            } else {
                System.out.println("Successful insert of worker role");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void update(WorkerRole workerRole) {

        WorkerRole sqlWorkerRole = getById(workerRole.getWorkerRoleId());

        if (sqlWorkerRole != null) {
            sqlWorkerRole.setWorkerRoleName(workerRole.getWorkerRoleName());
            sqlWorkerRole.setWorkerRoleActivities(workerRole.getActivitiesWorkerRole());
            String stmUpdate = """
            UPDATE tbl_workerRoles
            SET nameWorkerRole = ?,
                activitiesWorkerRole = ?
            WHERE workerRoleId = ?;
                               """;

            try (PreparedStatement ps = Operations.getConnection().prepareStatement(stmUpdate)) {

                ps.setString(1, sqlWorkerRole.getWorkerRoleName());
                String activitiesWorkerRole = String.join("|", sqlWorkerRole.getActivitiesWorkerRole());
                ps.setString(2, activitiesWorkerRole);
                ps.setLong(3, sqlWorkerRole.getWorkerRoleId());
                System.out.println(ps.toString());
                int rows = Operations.insert_update_delete_db(ps);
                if (rows <= 0) {
                    System.out.println("Cannot update worker role");
                } else {
                    System.out.println("Successful update of worker role");
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    @Override
    public void delete(long workerRoleId) {
        Operations.setConnection(BDConnection.MySQLConnection());
        String stm = "DELETE FROM tbl_workerRoles WHERE workerRoleId = ?;";

        try (PreparedStatement ps = Operations.getConnection().prepareStatement(stm)) {
            ps.setLong(1, workerRoleId);
            int rows = Operations.insert_update_delete_db(ps);
            if (rows > 0) {
                System.out.println("succesful delete workerRole");
                return;
            } else {
                System.out.println("not exists workerRole");
                return;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("something was wrong on delete workerRole");
        return;

    }

}
 
