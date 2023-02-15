package com.prosoft;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Hello world!
 *
 */
public class Main {
    public static void main(String[] args) throws SQLException {
        DbManager dbManager = new DbManager("", "sa", "sa", "dbName");
        Connection connection = dbManager.connect();
        dbManager.doExecute("create table author (id bigint, fullname varchar(255));", connection);
        dbManager.doExecute("insert into author (id, fullname) values (1, 'John Bunyan');", connection);
        ResultSet resultSet = dbManager.getSelectQuery("select * from author", connection);

        // Количество колонок в результирующем запросе
        int columns = resultSet.getMetaData().getColumnCount();
        // Перебор строк с данными
        while(resultSet.next()){
            for (int i = 1; i <= columns; i++){
                System.out.print(resultSet.getString(i) + "\t");
            }
            System.out.println();
        }

    }
}
