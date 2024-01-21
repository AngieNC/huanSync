package com.u2team.huansync.persistencia;

import java.sql.*;

public abstract class Operations {

    public static Connection con;
    public static Statement stmt = null;
    public static ResultSet rs = null;

    public static Connection setConnection(Connection connection) {
        Operations.con = connection;
        return connection;
    }

    public static Connection getConnection() {
        return con;
    }

    public static void closeConnection(Connection con) {
        if (con != null) {
            try {
                con.close();
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    public static ResultSet consultar_BD(PreparedStatement sentencia) {
        try {
            rs = sentencia.executeQuery();
        } catch (SQLException | RuntimeException sqlex) {
            System.out.println("Runtime Error: " + sqlex);
            return null;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return null;
        }
        return rs;
    }

    public static int insertar_actualizar_borrar_BD(PreparedStatement sentencia) {
        int filas;
        try {
            filas = sentencia.executeUpdate();
        } catch (SQLException | RuntimeException sqlex) {
            System.out.println("Error" + sqlex);
            return 0;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return 0;
        }
        return filas;
    }

    public static boolean setAutoCommitBD(boolean parametro) {
        try {
            con.setAutoCommit(parametro);
        } catch (SQLException sqlex) {
            System.out.println("Error configuration autocommit " + sqlex.getMessage());
            return false;
        }
        return true;
    }

    public static void cerrarConexion() {
        closeConnection(con);
    }

    public static boolean commitBD() {
        try {
            con.commit();
            return true;
        } catch (SQLException sqlex) {
            System.out.println("Error in commit " + sqlex.getMessage());
            return false;
        }
    }

    public static boolean rollbackBD() {
        try {
            con.rollback();
            return true;
        } catch (SQLException sqlex) {
            System.out.println("Error in rollback " + sqlex.getMessage());
            return false;
        }
    }
}