package Tieto.tests;

import Tieto.helpers.Asserts;
import Tieto.helpers.DBHelper;
import Tieto.helpers.GetDataHelper;
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
    private GetDataHelper dh = new GetDataHelper();
    private DBHelper db = new DBHelper();
    private Properties properties = new Properties();

    private Map<String, Object> mapForSource = new HashMap<String, Object>();
    private Map<String, Object> mapForSA = new HashMap<String, Object>();


    @Description("Сравнение данных записей таблиц BOOKGODS ")
    @Title("Сравнение данных записей таблиц BOOKGODS в RTest и MSCRUS")
    @Test
    public void RTestVsMSCRUS() throws SQLException, IOException {
        getPropertiesFile();
//Для маленьких таблиц должен быть выбран count(*). Менять параметр тут.
        int countRowsInSource = Integer.parseInt(properties.getProperty("system.RownumPool"));
        //
        String countSelectedRows = dh.getRoonumPool("bookgods.SOURCE.CountRowForPool");
        ArrayList arrayRows = dh.getArray(countRowsInSource);
//Change ParamNames
        String sqlfromSource = (properties.getProperty("bookgods.SOURCE.RowByRownumPart1") + countRowsInSource
                + properties.getProperty("bookgods.SOURCE.RowByRownumPart2"));
//Сравнение кол-ва строк в таблицах
        //countRowsInSA = getCountRows(statmentForSA, properties.getProperty("bookgods.MSCRUS.CountRows"));
        // asserts.assertRowCount(countRowsInSource, countRowsInSA);
//Сравнение данных
        Connection connectionToRTest = db.connToRTest();
        Statement statmentForRTest = db.stFromConnection(connectionToRTest);
        ResultSet rsCountRowFromRTest = db.rsFromDB(statmentForRTest, countSelectedRows);

        while (rsCountRowFromRTest.next()) {
            for (int i = 0; i < arrayRows.size(); i++) {
                String sqlRowByRownum = sqlfromSource + arrayRows.get(i);
                System.out.println("SQL from Source:" + sqlRowByRownum);
                ResultSet rsFromRTest = db.rsFromDB(statmentForRTest, sqlRowByRownum);
                while (rsFromRTest.next()) {
                    mapForSource = dh.getMapFromSource(rsFromRTest);
                    // У таблицы собственные ключи. Если менять, то тут.
                    String sqlFromSA = (properties.getProperty("bookgods.MSCRUS.RowByPKFromSA") + " SELSKAB = " + rsFromRTest.getString("SELSKAB")
                            + " and BOOK_NR = " + rsFromRTest.getString("BOOK_NR") + " and VAREPOST_NR = " + rsFromRTest.getString("VAREPOST_NR"));
                    mapForSA = dh.getMapFromSA(mapForSource.size(), sqlFromSA);
                }
                rsFromRTest.close();
                if (mapForSA == null) {
                    //System.out.println("Map will not matches!");
                }
                else
                    asserts.matchMaps(mapForSource, mapForSA);
            }
        }
        rsCountRowFromRTest.close();
        statmentForRTest.close();
        connectionToRTest.close();
    }

    @Description("Сравнение данных записей таблиц BOOKGODS ")
    @Title("Сравнение данных записей таблиц BOOKGODS в RTest и UNITY")
    @Test
    public void ITestVsUNITY() throws SQLException, IOException {
        getPropertiesFile();
//Для маленьких таблиц должен быть выбран count(*). Менять параметр тут.
        int countRowsInSource = Integer.parseInt(properties.getProperty("system.RownumPool"));
        //
        String countSelectedRows = dh.getRoonumPool("bookgods.SOURCE.CountRowForPool");
        ArrayList arrayRows = dh.getArray(countRowsInSource);
//Change ParamNames
        String sqlfromSource = (properties.getProperty("bookgods.SOURCE.RowByRownumPart1") + countRowsInSource
                + properties.getProperty("bookgods.SOURCE.RowByRownumPart2"));
//Сравнение кол-ва строк в таблицах
        // int counRowsInSource = dh.getCountRowsInITest("bookgods.SOURCE.CountRow");
        // int counRowsInSA = dh.getCountRowsInSA("bookgods.UNITY.CountRows");
        // asserts.assertRowCount(counRowsInSource, counRowsInSA);
//Сравнение данных
        Connection connectionToITest = db.connToITest();
        Statement statmentForITest = db.stFromConnection(connectionToITest);
        ResultSet rsCountRowFromITest = db.rsFromDB(statmentForITest, countSelectedRows);

        while (rsCountRowFromITest.next()) {
            for (int i = 0; i < arrayRows.size(); i++) {
                String sqlRowByRownum = sqlfromSource + arrayRows.get(i);
                ResultSet rsFromITest = db.rsFromDB(statmentForITest, sqlRowByRownum);
                while (rsFromITest.next()) {
                    mapForSource = dh.getMapFromSource(rsFromITest);
//Параметр в запросе к SA должен быть соответвующим
// У таблицы собственные ключи. Если менять, то тут.
                    String sqlFromSA = (properties.getProperty("bookgods.UNITY.RowByPKFromSA") + " SELSKAB = " + rsFromITest.getString("SELSKAB")
                            + " and BOOK_NR = " + rsFromITest.getString("BOOK_NR") + " and VAREPOST_NR = " + rsFromITest.getString("VAREPOST_NR"));
                    mapForSA = dh.getMapFromSA(mapForSource.size(), sqlFromSA);
                }
                rsFromITest.close();
                if (mapForSA == null) {
                   // System.out.println("Map will not matches!");
                 }
                 else
                asserts.matchMaps(mapForSource, mapForSA);
            }

        }
        rsCountRowFromITest.close();
        statmentForITest.close();
        connectionToITest.close();
    }

    private void getPropertiesFile() throws IOException {
        properties.load(new FileReader(new File(String.format("src/test/resources/sql.properties"))));
    }

    private int getCountRows(Statement statment, String sql) throws SQLException {
        ResultSet rsCountRowsFromSA = db.rsFromDB(statment, sql);
        while (rsCountRowsFromSA.next()) {
            //countRowsInSource = rsCountRowsFromSA.getInt("c");
            //return countRowsInSource;
        }
        return 0;
    }


}

