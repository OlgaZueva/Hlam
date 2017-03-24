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

/**
 * Created by HOME on 23.03.2017.
 */
public class BookGodsOZ {
    private Asserts asserts = new Asserts();
    private DBHelper db = new DBHelper();
    private ArrayRownums ar = new ArrayRownums();
    private Properties properties = new Properties();

    private int countRowsInSource;
    private int countRowsInSA;
    private Statement statmentForSA;
    private Connection connectionToSA;
    private ResultSet rsFromSA;

    private Map<String, Object> mapForRTest = new TreeMap<String, Object>();
    private Map<String, Object> mapForMSIRUS = new TreeMap<String, Object>();

    private ArrayList<Object> arrayFromRTest = new ArrayList();
    private ArrayList<Object> arrayFromSA = new ArrayList();

    @Description("Сравнение данных записей таблиц ADGAND ")
    @Title("Сравнение данных записей таблиц ADGAND в RTest и MSCRUS")
    @Test
    public void RTestVsMSCRUS() throws SQLException, IOException {
        properties.load(new FileReader(new File(String.format("src/test/resources/sql.properties"))));

        Connection connectionToRTest = db.connToRTest();
        Statement statmentForRTest = db.stFromConnection(connectionToRTest);
        ResultSet rsCountRowFromRTest = db.rsFromDB(statmentForRTest, properties.getProperty("bookgods.SOURCE.CountRow"));


        while (rsCountRowFromRTest.next()) {
            //countRowsInSource = rsCountRowFromRTest.getInt("c");
            countRowsInSource = 100;
            System.out.println("All count:" + countRowsInSource);
            ArrayList arrayRows = ar.getArray(countRowsInSource, Integer.parseInt(properties.getProperty("system.PercentOfRows")));

            //for (int i = 0; i < arrayRows.size(); i++) {
            // System.out.println(properties.getProperty("bookgods.SOURCE.RowByRownum") + arrayRows.get(i));
            //ResultSet rsFromRTest = db.rsFromDB(statmentForRTest, properties.getProperty("bookgods.SOURCE.RowByRownum") + arrayRows.get(i));
            ResultSet rsFromRTest = db.rsFromDB(statmentForRTest, properties.getProperty("bookgods.SOURCE.RowByRownum") + "13");

            while (rsFromRTest.next()) {
                System.out.println("ColumnCount: " + rsFromRTest.getMetaData().getColumnCount());

                for (int k = 1; k <= rsFromRTest.getMetaData().getColumnCount(); k++) {
                    mapForRTest.put(rsFromRTest.getMetaData().getColumnName(k), rsFromRTest.getObject(k));
                    //arrayFromRTest.add(rsFromRTest.getObject(k));
                }
                connectionToSA = db.connToSA();
                statmentForSA = db.stFromConnection(connectionToSA);
                System.out.println("SQL: " + properties.getProperty("bookgods.MSCRUS.RowByPKFromRTest")
                        + rsFromRTest.getObject("SELSKAB") + " and BOOK_NR = " + rsFromRTest.getObject("BOOK_NR")
                        + " and VAREPOST_NR = " + rsFromRTest.getObject("VAREPOST_NR"));

                rsFromSA = db.rsFromDB(statmentForSA, properties.getProperty("bookgods.MSCRUS.RowByPKFromRTest")
                        + rsFromRTest.getObject("SELSKAB") + " and BOOK_NR = " + rsFromRTest.getObject("BOOK_NR")
                        + " and VAREPOST_NR = " + rsFromRTest.getObject("VAREPOST_NR"));


                while (rsFromSA.next()) {
                    //System.out.println("ArraySizeBefore: " + arrayFromSA.size());
                    for (int l = 1; l <= rsFromRTest.getMetaData().getColumnCount(); l++) {
                        mapForMSIRUS.put(rsFromSA.getMetaData().getColumnName(l), rsFromSA.getObject(l));
                        arrayFromSA.add(rsFromSA.getObject(l));

                    }
                }
                rsFromSA.close();


            }
            rsFromRTest.close();

            System.out.println("Map1 = " + mapForRTest);
            System.out.println("Map2 = " + mapForMSIRUS);


            for (Map.Entry entry : mapForRTest.entrySet()) {
                Object q1 = entry.getKey();
                Object q2 = entry.getValue();

                System.out.println("q1: " + q1 + " | q1 from MSCRUS: " + mapForMSIRUS.get(q1));
                // System.out.println("q1: " + q1 + " | q2 from MSCRUS: " + mapForMSIRUS.get(q2));
                //System.out.println("q1: " + q1 + " | q2 from RTest: " + q2);

                q2.equals(mapForMSIRUS.get(q1));
//                    q2.equals(mapForMSIRUS.get(q1));

                //q1.equals(mapForMSIRUS.get(q2));
                //assertThat(q2, equalTo(mapForMSIRUS.get(q1)));

            }


            //countRowsInSA = getCountRows(statmentForSA, properties.getProperty("adgang.MSCRUS.CountRows"));
            //asserts.assertRowCount(countRowsInSource, countRowsInSA);

            statmentForSA.close();
            connectionToSA.close();

            rsCountRowFromRTest.close();
            statmentForRTest.close();
            connectionToRTest.close();
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
