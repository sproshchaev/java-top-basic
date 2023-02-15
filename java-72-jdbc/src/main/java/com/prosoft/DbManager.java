package com.prosoft;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

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

    public ResultSet getSelectQuery(String sql, Connection conn) {
        Statement comm = null;
        ResultSet set = null;
        try {
            comm = (Statement) conn.createStatement();
            set = comm.executeQuery(sql);
        } catch (SQLException ex) {
            Logger.getLogger(DbManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return set;
    }

    public void doExecute(String sql, Connection conn) {
        Statement comm = null;
        try {
            comm = (Statement) conn.createStatement();
            comm.execute(sql);
        } catch (SQLException ex) {
            Logger.getLogger(DbManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
