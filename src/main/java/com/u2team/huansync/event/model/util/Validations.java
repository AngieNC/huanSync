package com.u2team.huansync.event.model.util;

import com.u2team.huansync.persistence.BDConnection;
import com.u2team.huansync.persistence.Operations;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 *
 * @author Cristina Jerez Salas
 */
public class Validations {
    
    public static boolean dateBetween(LocalDate initialDate, LocalDate finalDate, int minDays, int maxDays){
        long difDate = ChronoUnit.DAYS.between(initialDate, finalDate);
        return !(difDate < minDays || difDate > maxDays);
    }
    
    public static int counterRepeated(String table, String column, String value){
        Operations.setConnection(BDConnection.MySQLConnection());
        String stm = "select count(" + column + ") as repeated from " + table + " WHERE " + column + " = ?;";

        try (PreparedStatement ps = Operations.getConnection().prepareStatement(stm)) {
            ps.setString(1, value);
            ResultSet rs = Operations.query_db(ps);
            if (rs != null) {
                if(rs.next()){
                    int repeated = rs.getInt("repeated");
                    return repeated;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }
    
}
