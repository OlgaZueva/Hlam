package Tieto.tests;

import Tieto.helpers.ArrayRownums;
import Tieto.helpers.Asserts;
import Tieto.helpers.DBHelper;
import Tieto.models.Adgang;
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

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class qwe {
    private Asserts asserts = new Asserts();
    private DBHelper db = new DBHelper();
    private ArrayRownums ar = new ArrayRownums();
    private Properties properties = new Properties();
    private Adgang adgangRTest = null;
    private Adgang adgangSaMSCRUS = null;
    private Adgang adgangITest = null;
    private Adgang adgangSaUNITY = null;
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
        ResultSet rsCountRowFromRTest = db.rsFromDB(statmentForRTest, properties.getProperty("adgang.SOURCE.CountRow"));


        while (rsCountRowFromRTest.next()) {
            countRowsInSource = rsCountRowFromRTest.getInt("c");
            //ArrayList arrayRows = ar.getArrayRownums(countRowsInSource, Integer.parseInt(properties.getProperty("system.PercentOfRows")));

            int[] array = new int[]{(countRowsInSource - (countRowsInSource - 1)),
                    (countRowsInSource - (countRowsInSource - 2)), (countRowsInSource / 2 - 1), (countRowsInSource / 2),
                    (countRowsInSource - 1), countRowsInSource};
            //for (int i = 0; i <arrayRows.size(); i++) {
            for (int i = 0; i < array.length; i++) {
                ResultSet rsFromRTest = db.rsFromDB(statmentForRTest, properties.getProperty("adgang.SOURCE.RowByRownum") + array[i]);
                while (rsFromRTest.next()) {

                    for (int k = 1; k <= rsFromRTest.getMetaData().getColumnCount(); k++) {
                        String columNames = rsFromRTest.getMetaData().getColumnName(k);

                        mapForRTest.put(rsFromRTest.getMetaData().getColumnName(k), rsFromRTest.getObject(k));

                        arrayFromRTest.add(rsFromRTest.getObject(k));


                    }
                    connectionToSA = db.connToSA();
                    statmentForSA = db.stFromConnection(connectionToSA);
                    rsFromSA = db.rsFromDB(statmentForSA, properties.getProperty("adgang.MSCRUS.RowByPKFromRTest") +
                            rsFromRTest.getObject(1) + "'");
                    System.out.println("SQL: " + properties.getProperty("adgang.MSCRUS.RowByPKFromRTest") + rsFromRTest.getString("VOR_REF") + "'");

                    //System.out.println(rsFromRTest.getString("VOR_REF"));
                    //rsFromRTest.getString("VOR_REF") + "'");
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
                System.out.println("Equality: " + mapForMSIRUS.equals(mapForRTest));
                System.out.println("Comparison: " + mapForRTest.entrySet().containsAll(mapForMSIRUS.entrySet()));
                System.out.println("Comparison1: " + mapForMSIRUS.entrySet().containsAll(mapForRTest.entrySet()));
                        //compareMaps(mapForRTest, mapForMSIRUS));
/*
                private static boolean compareMaps(Map<String, Object> map1,
                        Map<String, Object> map2) {
                    return map1.entrySet().containsAll(map2.entrySet())
                            && map2.entrySet().containsAll(map1.entrySet());
                }
*/



                assertThat(mapForRTest.containsValue("KLDATI"), equalTo(mapForMSIRUS.containsValue("KLDATI")));



                for (Map.Entry entry : mapForRTest.entrySet()) {
                    Object q1 = entry.getKey();
                    Object q2 = entry.getValue();
                    System.out.println(mapForMSIRUS.get(q1));
                    //q1.equals(mapForMSIRUS.get(q1));
                    q2.equals(mapForMSIRUS.get(q1));
/*
                    System.out.println(mapForRTest.get(entry.getValue()));
                    System.out.println(mapForMSIRUS.get(entry.getKey()));
                    System.out.println(mapForMSIRUS.keySet().contains(entry.getKey()));
                    System.out.println(mapForMSIRUS.values().contains(entry.getValue()));
                    System.out.println(mapForMSIRUS.entrySet().contains(entry.getValue()));
                    */
                }

                //System.out.println(mapForMSIRUS.entrySet().containsAll(mapForRTest.entrySet()));

//                assertThat(mapForRTest, equalTo(mapForMSIRUS));
                //assertThat(arrayFromRTest, equalTo(arrayFromSA));
            }
        }


        countRowsInSA = getCountRows(statmentForSA, properties.getProperty("adgang.MSCRUS.CountRows"));
        asserts.assertRowCount(countRowsInSource, countRowsInSA);

        statmentForSA.close();
        connectionToSA.close();

        rsCountRowFromRTest.close();
        statmentForRTest.close();
        connectionToRTest.close();
    }


    @Description("Сравнение данных записей таблиц ADGAND ")
    @Title("Сравнение данных записей таблиц ADGAND в ITest и UNITY")
    @Test(enabled = false)
    public void ITestVsUNITY() throws SQLException, IOException {
        properties.load(new FileReader(new File(String.format("src/test/resources/sql.properties"))));
        Connection connectionToUNITY = db.connToITest();
        Statement statmentForUNITY = db.stFromConnection(connectionToUNITY);
        ResultSet rsCountFromUNITY = db.rsFromDB(statmentForUNITY, properties.getProperty("adgang.SOURCE.CountRow"));

        while (rsCountFromUNITY.next()) {
            countRowsInSource = rsCountFromUNITY.getInt("c");
            System.out.println("In ITest: " + countRowsInSource);
            int[] array = new int[]{(countRowsInSource - (countRowsInSource - 1)), (countRowsInSource - (countRowsInSource - 2)),
                    (countRowsInSource / 2 - 1), (countRowsInSource / 2), (countRowsInSource - 1), countRowsInSource};

            for (int i = 0; i < array.length; i++) {
                ResultSet rsFromITest = db.rsFromDB(statmentForUNITY, properties.getProperty("adgang.SOURCE.RowByRownum") + array[i]);
                while (rsFromITest.next()) {
                    adgangITest = new Adgang().setVOR_REF(rsFromITest.getString("VOR_REF")).setUTS_LEVEL(rsFromITest.getInt("UTS_LEVEL"))
                            .setUTS_ADMIN(rsFromITest.getString("UTS_ADMIN")).setSTART_SEL(rsFromITest.getByte("START_SEL"))
                            .setUTS_GROUP(rsFromITest.getString("UTS_GROUP")).setFGAC(rsFromITest.getString("FGAC"))
                            .setACCOUNTANT(rsFromITest.getString("ACCOUNTANT")).setAD_LOGIN(rsFromITest.getString("AD_LOGIN"))
                            .setAD_USER_ONLY(rsFromITest.getString("AD_USER_ONLY"));
                }
                rsFromITest.close();
                connectionToSA = db.connToSA();
                statmentForSA = db.stFromConnection(connectionToSA);
                String sqlFromUNITY = properties.getProperty("adgang.UNITY.RowByPKFromITest") + adgangITest.getVOR_REF() + "'";
                rsFromSA = db.rsFromDB(statmentForSA, sqlFromUNITY);

                while (rsFromSA.next()) {
                    adgangSaUNITY = new Adgang().setVOR_REF(rsFromSA.getString("VOR_REF")).setUTS_LEVEL(rsFromSA.getInt("UTS_LEVEL"))
                            .setUTS_ADMIN(rsFromSA.getString("UTS_ADMIN")).setSTART_SEL(rsFromSA.getInt("START_SEL"))
                            .setUTS_GROUP(rsFromSA.getString("UTS_GROUP")).setFGAC(rsFromSA.getString("FGAC"))
                            .setACCOUNTANT(rsFromSA.getString("ACCOUNTANT")).setAD_LOGIN(rsFromSA.getString("AD_LOGIN"))
                            .setAD_USER_ONLY(rsFromSA.getString("AD_USER_ONLY"));
                }
                asserts.assertRowsAdgang(adgangSaUNITY, adgangITest);
            }

        }

        countRowsInSA = getCountRows(statmentForSA, properties.getProperty("adgang.UNITY.CountRows"));
        asserts.assertRowCount(countRowsInSource, countRowsInSA);

        statmentForSA.close();
        connectionToSA.close();
        rsFromSA.close();

        rsCountFromUNITY.close();
        statmentForUNITY.close();
        connectionToUNITY.close();
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

