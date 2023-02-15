package com.prosoft;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * java-72-jdbc
 *
 */
public class Main {
    public static void main(String[] args) throws SQLException {
        DbManager dbManager = new DbManager("", "sa", "sa", "dbName");

        Connection connection = dbManager.connect();

        dbManager.doExecuteUpdate("create table author (id bigint, fullname varchar(255));", connection);

        dbManager.doExecuteUpdate("insert into author (id, fullname) values (1, 'John Bunyan');", connection);

        ResultSet resultSet = dbManager.doExecuteQuery("select * from author", connection);

        int columns = resultSet.getMetaData().getColumnCount(); // Количество колонок в результирующем запросе
        while(resultSet.next()){
            for (int i = 1; i <= columns; i++) {
                System.out.print(resultSet.getString(i) + "\t");
            }
            System.out.println();
        }

    }
}
