package Tieto.helpers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.*;


public class DBHelper {

    public Connection connToITest() throws SQLException {
        //return DriverManager.getConnection("jdbc:oracle:thin:dwh_etl/T4M2iJfRGw@10.45.101.220:1551:ITEST"); // Oracle9
        return DriverManager.getConnection("jdbc:oracle:thin:dwh_etl/T4M2iJfRGw@10.45.101.53:1551:ITEST"); // Oracle12
    }

    public Connection connToRTest() throws SQLException {
        //return DriverManager.getConnection("jdbc:oracle:thin:dwh_etl/T4M2iJfRGw@10.45.1.223:1566:RTEST"); // Oracle9
        return DriverManager.getConnection("jdbc:oracle:thin:dwh_etl/T4M2iJfRGw@10.45.1.224:1566:RTEST"); // Oracle12
    }

    public Connection connToSA() throws SQLException {
       //return DriverManager.getConnection("jdbc:sqlserver://10.45.1.122;databaseName=StagingAreaTest;user=ssis;password=ssis");
        return DriverManager.getConnection("jdbc:sqlserver://10.21.11.11;databaseName=StagingAreaTest;user=ssis;password=ssis");
        //return DriverManager.getConnection("jdbc:sqlserver://10.21.11.15;databaseName=StagingAreaTest;user=ssis;password=ssis");
        //return DriverManager.getConnection("jdbc:sqlserver://10.21.11.11;databaseName=StagingAreaTest_new;user=ssis;password=ssis");
    }

    public  Statement stFromConnection(Connection connection) throws SQLException {
        return connection.createStatement();
    }

    public  ResultSet rsFromDB(Statement statement, String sql) throws SQLException {
        return statement.executeQuery(sql);
    }


}
