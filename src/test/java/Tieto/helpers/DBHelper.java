package Tieto.helpers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.*;


public class DBHelper {

    public Connection connToITest() throws SQLException {
        return DriverManager.getConnection("jdbc:oracle:thin:dwh_etl/T4M2iJfRGw@10.45.101.220:1551:ITEST");
    }

    public Connection connToRTest() throws SQLException {
        return DriverManager.getConnection("jdbc:oracle:thin:dwh_etl/T4M2iJfRGw@10.45.1.223:1566:RTEST");
    }

    public Connection connToSA() throws SQLException {
        return DriverManager.getConnection("jdbc:sqlserver://10.45.1.122;databaseName=BIFROST;user=sa;password=JGdedf&#fsqwhdc");
    }

    public  Statement stFromConnection(Connection connection) throws SQLException {
        return connection.createStatement();
    }

    public  ResultSet rsFromDB(Statement statement, String sql) throws SQLException {
        return statement.executeQuery(sql);
    }




}
