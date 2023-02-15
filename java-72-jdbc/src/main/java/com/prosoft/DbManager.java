package com.prosoft;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Класс DbManager
 */
public class DbManager {
    private String host; //server address
    private String user; //user name
    private String pass; //user password
    private String dbName; //DB name
    private Connection conn; //connection object

    public DbManager(String host, String user, String pass, String dbName) {
        this.conn = null;
        this.host = host;
        this.user = user;
        this.pass = pass;
        this.dbName = dbName;
        try {
            Class.forName("org.h2.Driver"); //driver registration
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DbManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Connection connect() {
        String url = "jdbc:h2:mem:dbname";
        try {
            this.conn = DriverManager.getConnection(url, this.user, this.pass);
            return this.conn;
        } catch (SQLException ex) {
            Logger.getLogger(DbManager.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public ResultSet doExecuteQuery(String sql, Connection connection) {
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            statement = (Statement) connection.createStatement();
            resultSet = statement.executeQuery(sql);
        } catch (SQLException ex) {
            Logger.getLogger(DbManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultSet;
    }

    public void doExecuteUpdate(String sql, Connection connection) {
        Statement statement = null;
        try {
            statement = (Statement) connection.createStatement();
            statement.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(DbManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
