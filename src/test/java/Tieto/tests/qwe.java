package Tieto.tests;

import Tieto.helpers.ArrayRownums;
import Tieto.helpers.Asserts;
import Tieto.helpers.DBHelper;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Title;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

public class qwe {
    private Asserts asserts = new Asserts();
    private DBHelper db = new DBHelper();
    private ArrayRownums ar = new ArrayRownums();
    private Properties properties = new Properties();


    private int countRowsInSource;
    private int countRowsInSA;
    private Statement statmentForSA;
    private Connection connectionToSA;
    private ResultSet rsFromSA;

    private Map<String, Object> mapForRTest = new HashMap<String, Object>();
    private Map<String, Object> mapForMSCRUS = new HashMap<String, Object>();
    private Map<String, Object> mapForITest = new HashMap<String, Object>();
    private Map<String, Object> mapForUNITY = new HashMap<String, Object>();


    @Description("Сравнение данных записей таблиц BOOKGODS ")
    @Title("Сравнение данных записей таблиц BOOKGODS в RTest и MSCRUS")
    @Test
    public void RTestVsMSCRUS() throws SQLException, IOException {
        properties.load(new FileReader(new File(String.format("src/test/resources/sql.properties"))));

        Connection connectionToRTest = db.connToRTest();
        Statement statmentForRTest = db.stFromConnection(connectionToRTest);
//BIG TABLE. Own its algoritm!
        String countSelectedRows = properties.getProperty("bookgods.SOURCE.CountRow") + properties.getProperty("system.RownumPool");
        System.out.println("Ограничение на выбор записей: " + countSelectedRows);
        ResultSet rsCountRowFromRTest = db.rsFromDB(statmentForRTest, countSelectedRows);

        while (rsCountRowFromRTest.next()) {
//BIG TABLE. Own its algoritm!
            countRowsInSource = Integer.parseInt(properties.getProperty("system.RownumPool"));
            ArrayList arrayRows = ar.getArray(countRowsInSource, Integer.parseInt(properties.getProperty("system.PercentOfRows")));

            for (int i = 0; i < arrayRows.size(); i++) {
                String sqlRowByRownum = (properties.getProperty("bookgods.SOURCE.RowByRownumPart1") + countRowsInSource
                        + properties.getProperty("bookgods.SOURCE.RowByRownumPart2") + arrayRows.get(i));
                System.out.println(sqlRowByRownum);
                ResultSet rsFromRTest = db.rsFromDB(statmentForRTest, sqlRowByRownum);

                while (rsFromRTest.next()) {
                    for (int k = 1; k <= rsFromRTest.getMetaData().getColumnCount(); k++) {
                        mapForRTest.put(rsFromRTest.getMetaData().getColumnName(k), rsFromRTest.getObject(k));
                    }
                    mapForRTest.remove("RN");

                    connectionToSA = db.connToSA();
                    statmentForSA = db.stFromConnection(connectionToSA);
//change sql
                    String sql = (properties.getProperty("bookgods.MSCRUS.RowByPKFromSA") + rsFromRTest.getString("SELSKAB")
                            + " and BOOK_NR = " + rsFromRTest.getString("BOOK_NR") + " and VAREPOST_NR = " + rsFromRTest.getString("VAREPOST_NR"));

                    System.out.println("SQL из MSCRUS: " + sql);
                    rsFromSA = db.rsFromDB(statmentForSA, sql);
                    while (rsFromSA.next()) {
                        if (rsFromSA.getRow() == 0 || rsFromSA.getRow() > 1){
                            System.err.println("Count rows got from SA: " + rsFromSA.getRow()
                                    + ". If its > 1 check the unique key in sql query to SA! SQL: " + sql);
                        }
                        else {
                            for (int l = 1; l <= mapForRTest.size(); l++) {
                                mapForMSCRUS.put(rsFromSA.getMetaData().getColumnName(l), rsFromSA.getObject(l));
                            }
                        }
                    }
                    rsFromSA.close();
                }

                rsFromRTest.close();

                asserts.matchMaps(mapForRTest, mapForMSCRUS);


            }
        }
        //countRowsInSA = getCountRows(statmentForSA, properties.getProperty("bookgods.MSCRUS.CountRows"));
        //asserts.assertRowCount(countRowsInSource, countRowsInSA);
        statmentForSA.close();
        connectionToSA.close();
        rsCountRowFromRTest.close();
        statmentForRTest.close();
        connectionToRTest.close();
    }




    @Description("Сравнение данных записей таблиц BOOKGODS ")
    @Title("Сравнение данных записей таблиц BOOKGODS в ITest и UNITY")
    @Test (enabled = false)
    public void ITestVsUNIT() throws SQLException, IOException {
        properties.load(new FileReader(new File(String.format("src/test/resources/sql.properties"))));

        Connection connectionToITest = db.connToITest();
        Statement statmentForRTest = db.stFromConnection(connectionToITest);
//BIG TABLE. Own its algoritm!
        String countSelectedRows = properties.getProperty("bookgods.SOURCE.CountRow") + properties.getProperty("system.RownumPool");
        System.out.println("Ограничение на выбор записей: " + countSelectedRows);
        ResultSet rsCountRowFromITest = db.rsFromDB(statmentForRTest, countSelectedRows);

        while (rsCountRowFromITest.next()) {
//BIG TABLE. Own its algoritm!
            countRowsInSource = Integer.parseInt(properties.getProperty("system.RownumPool"));
            ArrayList arrayRows = ar.getArray(countRowsInSource, Integer.parseInt(properties.getProperty("system.PercentOfRows")));

            for (int i = 0; i < arrayRows.size(); i++) {
                //ResultSet rsFromITest = db.rsFromDB(statmentForRTest, properties.getProperty("bookgods.SOURCE.RowByRownum") + "13");
                String sqlRowByRownum = (properties.getProperty("bookgods.SOURCE.RowByRownumPart1") + countRowsInSource
                        + properties.getProperty("bookgods.SOURCE.RowByRownumPart2") + arrayRows.get(i));
                System.out.println(sqlRowByRownum);
                ResultSet rsFromITest = db.rsFromDB(statmentForRTest, sqlRowByRownum);
                while (rsFromITest.next()) {
                    for (int k = 1; k <= rsFromITest.getMetaData().getColumnCount(); k++) {
                        mapForITest.put(rsFromITest.getMetaData().getColumnName(k), rsFromITest.getObject(k));
                    }

                    mapForITest.remove("RN");

                    connectionToSA = db.connToSA();
                    statmentForSA = db.stFromConnection(connectionToSA);
//change sql
                    String sql = (properties.getProperty("bookgods.UNITY.RowByPKFromSA") + rsFromITest.getString("SELSKAB")
                            + " and BOOK_NR = " + rsFromITest.getString("BOOK_NR") + " and VAREPOST_NR = " + rsFromITest.getString("VAREPOST_NR"));

                    System.out.println("SQL из UNITY: " + sql);
                    rsFromSA = db.rsFromDB(statmentForSA, sql);
                    while (rsFromSA.next()) {
                        for (int l = 1; l <= mapForITest.size(); l++) {
                            mapForUNITY.put(rsFromSA.getMetaData().getColumnName(l), rsFromSA.getObject(l));
                        }
                    }
                    rsFromSA.close();
                }

                rsFromITest.close();
                asserts.matchMaps(mapForITest, mapForUNITY);

            }
            // }
            //countRowsInSA = getCountRows(statmentForSA, properties.getProperty("bookgods.MSCRUS.CountRows"));
            //asserts.assertRowCount(countRowsInSource, countRowsInSA);

            statmentForSA.close();
            connectionToSA.close();
            rsCountRowFromITest.close();
            statmentForRTest.close();
            connectionToITest.close();
        }

    }

    private int getCountRows(Statement statment, String sql) throws SQLException {
        ResultSet rsCountRowsFromSA = db.rsFromDB(statment, sql);
        while (rsCountRowsFromSA.next()) {
            countRowsInSource = rsCountRowsFromSA.getInt("c");
            return countRowsInSource;
        }
        return 0;
    }


}

