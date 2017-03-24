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

public class BogfTransTests {
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



    @Description("Сравнение данных записей таблиц BOGF_TRANS ")
    @Title("Сравнение данных записей таблиц BOGF_TRANS в RTest и MSCRUS")
    @Test
    public void RTestVsMSCRUS() throws SQLException, IOException {
        properties.load(new FileReader(new File(String.format("src/test/resources/sql.properties"))));

        Connection connectionToRTest = db.connToRTest();
        Statement statmentForRTest = db.stFromConnection(connectionToRTest);
        ResultSet rsCountRowFromRTest = db.rsFromDB(statmentForRTest, properties.getProperty("bogftrans.SOURCE.CountRow"));


        while (rsCountRowFromRTest.next()) {
            countRowsInSource = rsCountRowFromRTest.getInt("c");
            System.out.println("Кол-во записей в таблице: " + countRowsInSource);
            ArrayList arrayRows = ar.getArray(countRowsInSource, Integer.parseInt(properties.getProperty("system.PercentOfRows")));

            for (int i = 0; i < arrayRows.size(); i++) {
                System.out.println(properties.getProperty("bogftrans.SOURCE.RowByRownum") + arrayRows.get(i));
                ResultSet rsFromRTest = db.rsFromDB(statmentForRTest, properties.getProperty("bogftrans.SOURCE.RowByRownum") + arrayRows.get(i));
                while (rsFromRTest.next()) {
                    for (int k = 1; k <= rsFromRTest.getMetaData().getColumnCount(); k++) {
                        mapForRTest.put(rsFromRTest.getMetaData().getColumnName(k), rsFromRTest.getObject(k));
                    }

                    mapForRTest.remove("RN");

                    connectionToSA = db.connToSA();
                    statmentForSA = db.stFromConnection(connectionToSA);
//change sql
                    String sql = (properties.getProperty("bogftrans.MSCRUS.RowByPKFromSA") + rsFromRTest.getString("SELSKAB")
                            + " and LOBE_NR = " + rsFromRTest.getString("LOBE_NR") + " and BILAGSNR = "
                            + rsFromRTest.getString("BILAGSNR") );


                    rsFromSA = db.rsFromDB(statmentForSA, sql);
                    System.out.println("SQL: " + sql);

                    while (rsFromSA.next()) {
                        for (int l = 1; l <= mapForRTest.size(); l++) {
                            mapForMSCRUS.put(rsFromSA.getMetaData().getColumnName(l), rsFromSA.getObject(l));
                        }
                    }
                    rsFromSA.close();

                }

                rsFromRTest.close();

                System.out.println("Map1 = " + mapForRTest);
                System.out.println("Map2 = " + mapForMSCRUS);


                for (Map.Entry entry : mapForRTest.entrySet()) {
                    Object q1 = entry.getKey();
                    Object q2 = entry.getValue();
                    if (q2 == null) {
                        if (mapForMSCRUS.get(q1) != null || mapForMSCRUS.keySet().contains(q1)) {
                            // error
                            // System.err.println("Value in <...> is Null!!!");
                        }
                    } else {
                        if(!q2.equals(mapForMSCRUS.get(q1))){
                            Object secondValue = mapForMSCRUS.get(q1);
                            //System.out.println(q2.toString().equals(secondValue!=null?secondValue.toString():null));
                        }
                    }
                }
            }
        }


        // countRowsInSA = getCountRows(statmentForSA, properties.getProperty("bogftrans.MSCRUS.CountRows"));
        //asserts.assertRowCount(countRowsInSource, countRowsInSA);


        statmentForSA.close();
        connectionToSA.close();

        rsCountRowFromRTest.close();
        statmentForRTest.close();
        connectionToRTest.close();
    }


    @Description("Сравнение данных записей таблиц BOGF_TRANS ")
    @Title("Сравнение данных записей таблиц BOG_TRANS в ITest и UNITY")
    @Test
    public void ITestVsUNITY() throws SQLException, IOException {
        properties.load(new FileReader(new File(String.format("src/test/resources/sql.properties"))));

        Connection connectionToITest = db.connToITest();
        Statement statmentForRTest = db.stFromConnection(connectionToITest);
        ResultSet rsCountRowFromITest = db.rsFromDB(statmentForRTest, properties.getProperty("bogftrans.SOURCE.CountRow"));


        while (rsCountRowFromITest.next()) {
            countRowsInSource = rsCountRowFromITest.getInt("c");
            System.out.println("Кол-во записей в таблице: " + countRowsInSource);
            ArrayList arrayRows = ar.getArray(countRowsInSource, Integer.parseInt(properties.getProperty("system.PercentOfRows")));

            for (int i = 0; i < arrayRows.size(); i++) {
                System.out.println(properties.getProperty("bogftrans.SOURCE.RowByRownum") + arrayRows.get(i));

                ResultSet rsFromITest = db.rsFromDB(statmentForRTest, properties.getProperty("bogftrans.SOURCE.RowByRownum") + arrayRows.get(i));
                while (rsFromITest.next()) {
                    for (int k = 1; k <= rsFromITest.getMetaData().getColumnCount(); k++) {
                        mapForITest.put(rsFromITest.getMetaData().getColumnName(k), rsFromITest.getObject(k));
                    }

                    mapForITest.remove("RN");

                    connectionToSA = db.connToSA();
                    statmentForSA = db.stFromConnection(connectionToSA);
//change sql
                    String sql = (properties.getProperty("bogftrans.MSCRUS.RowByPKFromSA") + rsFromITest.getString("SELSKAB")
                            + " and LOBE_NR = " + rsFromITest.getString("LOBE_NR") + " and BILAGSNR = "
                            + rsFromITest.getString("BILAGSNR") );

                    System.out.println("SQL: " + sql);
                    rsFromSA = db.rsFromDB(statmentForSA, sql);


                    while (rsFromSA.next()) {
                        for (int l = 1; l <= mapForITest.size(); l++) {
                            mapForUNITY.put(rsFromSA.getMetaData().getColumnName(l), rsFromSA.getObject(l));
                        }
                    }
                    rsFromSA.close();

                }

                rsFromITest.close();


                System.out.println("Map1 = " + mapForITest);
                System.out.println("Map2 = " + mapForUNITY);


                for (Map.Entry entry : mapForITest.entrySet()) {
                    Object q1 = entry.getKey();
                    Object q2 = entry.getValue();
                    if (q2 == null) {
                        if (mapForUNITY.get(q1) != null || mapForUNITY.keySet().contains(q1)) {
                            // error
                            // System.err.println("Value in <...> is Null!!!");
                        }
                    } else {
                        if(!q2.equals(mapForUNITY.get(q1))){
                            Object secondValue = mapForUNITY.get(q1);
                            // System.out.println(q2.toString().equals(secondValue!=null?secondValue.toString():null));
                        }
                    }
                }

            }
        }
        // countRowsInSA = getCountRows(statmentForSA, properties.getProperty("bogftrans.UNITY.CountRows"));
        //asserts.assertRowCount(countRowsInSource, countRowsInSA);


        statmentForSA.close();
        connectionToSA.close();

        rsCountRowFromITest.close();
        statmentForRTest.close();
        connectionToITest.close();
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

