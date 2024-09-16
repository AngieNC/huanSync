package com.u2team.huansync.event.staff.model.DAO;

import com.u2team.huansync.event.DAO.*;
import com.u2team.huansync.event.staff.model.classes.Staff;
import com.u2team.huansync.event.staff.model.classes.StaffFull;
import com.u2team.huansync.event.workerRoles.model.DAO.WorkerRoleDAO;
import com.u2team.huansync.event.workerRoles.model.classes.WorkerRole;
import com.u2team.huansync.persistence.BDConnection;
import com.u2team.huansync.persistence.Operations;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Cristina Jerez Salas
 */
/**
 * Data Access Object (DAO) class for Staff. Implements various interfaces for
 * CRUD operations and data retrieval for Staff entities.
 */
public class StaffDAO implements IGetByIdDao<Staff>, IGetAllDao<Staff>, ISaveDao<Staff>, IUpdateDao<Staff>, IDeleteDao<Staff>, IGetByIdFull<Staff> {

    /**
     * Retrieves a Staff member by their ID.
     *
     * @param staffId The ID of the Staff member to retrieve.
     * @return Staff object if found, or null if not found.
     */
    @Override
    public Staff getById(long staffId) {
        Operations.setConnection(BDConnection.MySQLConnection());
        String stm = "select * from tbl_staff where staffId = ? ;";

        try (PreparedStatement ps = Operations.getConnection().prepareStatement(stm)) {
            ps.setLong(1, staffId);
            ResultSet rs = Operations.query_db(ps);
            if (rs.next()) {
                Staff staff = new Staff();
                staff.setStaffId(rs.getLong("staffId"));
                staff.setStaffNumberId(rs.getString("staffNumberId"));
                staff.setNameStaff(rs.getString("nameStaff"));
                staff.setBirthdayStaff(LocalDate.parse(rs.getString("birthdayStaff")));
                staff.setStatusStaffEnum(staff.getStatusStaffEnum(rs.getString("statusStaff")));
                staff.setWorkerRoleId(rs.getInt("roleWorkId"));

                return staff;
            } else {
                System.out.println("ERROR: The id has not been found");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Retrieves a Staff member by their ID including full details.
     *
     * @param staffId The ID of the Staff member to retrieve.
     * @return StaffFull object if found, or null if not found.
     */
    public Staff getByIdFull(long staffId) {

        Staff staff = getById(staffId);
        StaffFull staffFull = new StaffFull();
        staffFull.setStaffId(staff.getStaffId());
        staffFull.setStaffNumberId(staff.getStaffNumberId());
        staffFull.setNameStaff(staff.getNameStaff());
        staffFull.setBirthdayStaff(staff.getBirthdayStaff());
        staffFull.setStatusStaffEnum(staff.getStatusStaffEnum());
        staffFull.setWorkerRoleId(staff.getWorkerRoleId());

        WorkerRoleDAO workerRoleDao = new WorkerRoleDAO();
        WorkerRole workerRole = workerRoleDao.getById(staff.getWorkerRoleId());
        staffFull.setWorkerRole(workerRole);

        return staffFull;
    }

    /**
     * Retrieves all Staff members from the database.
     *
     * @return List of Staff objects.
     */
    @Override
    public List<Staff> getAll() {
        List<Staff> listStaff = new ArrayList<>();
        Operations.setConnection(BDConnection.MySQLConnection());
        String stm = "SELECT * FROM tbl_staff";

        try (PreparedStatement ps = Operations.getConnection().prepareStatement(stm)) {
            ResultSet rs = Operations.query_db(ps);
            while (rs.next()) {
                Staff staff = new Staff();
                staff.setStaffId(rs.getLong("staffId"));
                staff.setStaffNumberId(rs.getString("staffNumberId"));
                staff.setNameStaff(rs.getString("nameStaff"));
                staff.setBirthdayStaff(LocalDate.parse(rs.getString("birthdayStaff")));
                staff.setStatusStaffEnum(staff.getStatusStaffEnum(rs.getString("statusStaff")));
                staff.setWorkerRoleId(rs.getInt("roleWorkId"));
                listStaff.add(staff);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listStaff;
    }

    /**
     * Saves a Staff member to the database. Inserts a new Staff member or
     * updates an existing one based on the provided Staff object.
     *
     * @param staff The Staff object to be saved.
     */
    @Override
    public void save(Staff t) {
        Operations.setConnection(BDConnection.MySQLConnection());
        String stmInsert = "INSERT INTO tbl_staff(staffNumberId, nameStaff, birthdayStaff, statusStaff, roleWorkID) VALUES (?,?,?,?,?);";

        try (PreparedStatement ps = Operations.getConnection().prepareStatement(stmInsert)) {
            ps.setString(1, t.getStaffNumberId());
            ps.setString(2, t.getNameStaff());
            ps.setString(3, t.getBirthdayStaff().toString());
            ps.setString(4, t.getStatusStaffEnum().name());
            ps.setLong(5, t.getWorkerRoleId());

            int rows = Operations.insert_update_delete_db(ps);
            if (rows <= 0) {
                System.out.println("Cannot insert Staff member");
            } else {
                System.out.println("Successful insert of Staff member");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Updates an existing Staff member in the database.
     *
     * @param staff The Staff object containing updated information.
     */
    @Override
    public void update(Staff t) {

        Staff sqlStaff = getById(t.getStaffId());

        if (sqlStaff != null) {

            sqlStaff.setStaffNumberId(t.getStaffNumberId());
            sqlStaff.setNameStaff(t.getNameStaff());
            sqlStaff.setBirthdayStaff(t.getBirthdayStaff());
            sqlStaff.setStatusStaffEnum(t.getStatusStaffEnum());
            sqlStaff.setWorkerRoleId(t.getWorkerRoleId());

            String stmUpdate = """
                    UPDATE tbl_staff
                    SET staffNumberId = ?,
                        nameStaff = ?,
                        birthdayStaff = ?,
                        statusStaff = ?,
                        roleWorkId = ?
                    WHERE staffId = ?;
                                 """;
 
            try (PreparedStatement ps = Operations.getConnection().prepareStatement(stmUpdate)) {
                ps.setString(1, t.getStaffNumberId());
                ps.setString(2, t.getNameStaff());
                ps.setString(3, t.getBirthdayStaff().toString());
                ps.setString(4, t.getStatusStaffEnum().name());
                ps.setLong(5, t.getWorkerRoleId());
                ps.setLong(6, t.getStaffId());

                // use Operation class with insert_update_delete and verify if the rows in database are affected
                int rows = Operations.insert_update_delete_db(ps);
                if (rows <= 0) {
                    System.out.println("Cannot update event");
                } else {
                    System.out.println("Successful update event");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("not found results event");
        }
    }

    /**
     * Deletes a Staff member from the database using their ID.
     *
     * @param staffId The ID of the Staff member to be deleted.
     */
    @Override
    public void delete(long staffId) {
        // Class Operations are used to configure the connection with database and send a Query saved in variable stm
        Operations.setConnection(BDConnection.MySQLConnection());
        String stm = "DELETE FROM tbl_staff WHERE staffId = ?;";

        // use Operation class with insert_update_delete and verify if the rows in database are affected
        try (PreparedStatement ps = Operations.getConnection().prepareStatement(stm)) {
            ps.setLong(1, staffId);
            int rows = Operations.insert_update_delete_db(ps);
            if (rows > 0) {
                System.out.println("successful delete staff");
                return;
            } else {
                System.out.println("not exists staff");
                return;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("something was wrong on delete staff");
        return;
    }

}
