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
import java.util.jar.Attributes;

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

    //private Map<String, Object> mapForRTest = new TreeMap4<String, Object>();
    private Map<String, Object> mapForRTest = new HashMap<String, Object>();
    //private Map<String, Object> mapForMSIRUS = new TreeMap<String, Object>();
    private Map<String, Object> mapForMSIRUS = new HashMap<String, Object>();

    ArrayList arrayColumsNames;


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
            ArrayList arrayRows = ar.getArray(countRowsInSource, Integer.parseInt(properties.getProperty("system.PercentOfRows")));

            for (int i = 0; i < arrayRows.size(); i++) {
                System.out.println(properties.getProperty("adgang.SOURCE.RowByRownum") + arrayRows.get(i));
                ResultSet rsFromRTest = db.rsFromDB(statmentForRTest, properties.getProperty("adgang.SOURCE.RowByRownum") + arrayRows.get(i));
                while (rsFromRTest.next()) {
                    for (int k = 1; k <= rsFromRTest.getMetaData().getColumnCount(); k++) {
                        //columNames = rsFromRTest.getMetaData().getColumnName(k);
                        //arrayColumsNames = new ArrayList();
                        //arrayColumsNames.add(rsFromRTest.getMetaData().getColumnName(k));
                        mapForRTest.put(rsFromRTest.getMetaData().getColumnName(k), rsFromRTest.getObject(k));
                    }

                    mapForRTest.remove("RN");

                    connectionToSA = db.connToSA();
                    statmentForSA = db.stFromConnection(connectionToSA);
                    String sql = (properties.getProperty("adgang.MSCRUS.RowByPKFromSA") + rsFromRTest.getString("VOR_REF") + "'");
                    rsFromSA = db.rsFromDB(statmentForSA, sql);
                    System.out.println("SQL: " + sql);

                    while (rsFromSA.next()) {
                        for (int l = 1; l <= mapForRTest.size(); l++) {
                            //for (int l = 1; l <= arrayColumsNames.size(); l++) {
                            mapForMSIRUS.put(rsFromSA.getMetaData().getColumnName(l), rsFromSA.getObject(l));
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
                    if (q2 == null) {
                        if (mapForMSIRUS.get(q1) != null || mapForMSIRUS.keySet().contains(q1)) {
                            //error
                        }
                    } else {
                        if(!q2.equals(mapForMSIRUS.get(q1))){
                            Object secondValue = mapForMSIRUS.get(q1);
                            System.out.println(q2.toString().equals(secondValue!=null?secondValue.toString():null));
                        }
                    }
                }
            }



/*
                    System.out.println(mapForRTest.get(entry.getValue()));
                    System.out.println(mapForMSIRUS.get(entry.getKey()));
                    System.out.println(mapForMSIRUS.keySet().contains(entry.getKey()));
                    System.out.println(mapForMSIRUS.values().contains(entry.getValue()));
                    System.out.println(mapForMSIRUS.entrySet().contains(entry.getValue()));
                    */


            //System.out.println(mapForMSIRUS.entrySet().containsAll(mapForRTest.entrySet()));

//                assertThat(mapForRTest, equalTo(mapForMSIRUS));
            //assertThat(arrayFromRTest, equalTo(arrayFromSA));

        }



   // countRowsInSA = getCountRows(statmentForSA, properties.getProperty("adgang.MSCRUS.CountRows"));
    //asserts.assertRowCount(countRowsInSource, countRowsInSA);

    //getCountRows(statmentForSA, properties.getProperty("adgang.MSCRUS.CountRows"));
        //asserts.assertRowCount(countRowsInSource,countRowsInSA);

        statmentForSA.close();
        connectionToSA.close();

        rsCountRowFromRTest.close();
        statmentForRTest.close();
        connectionToRTest.close();
}



    private boolean compareMaps(Map<String, Object> map1, Map<String, Object> map2) {
        return map1.entrySet().containsAll(map2.entrySet()) && map2.entrySet().containsAll(map1.entrySet());
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

