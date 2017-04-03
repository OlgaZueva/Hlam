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

public class AdresseTests {
    private Asserts asserts = new Asserts();
    private GetDataHelper dh = new GetDataHelper();
    private DBHelper db = new DBHelper();
    private Properties properties = new Properties();

    private Map<String, Object> mapForSource = new HashMap<String, Object>();
    private Map<String, Object> mapForSA = new HashMap<String, Object>();


    @Description("Сравнение данных записей таблиц ADRESSE ")
    @Title("Сравнение данных записей таблиц ADRESSE в RTest и MSCRUS")
    @Test
    public void RTestVsMSCRUS() throws SQLException, IOException {
        getPropertiesFile();
//Для маленьких таблиц должен быть выбран count(*). Менять параметр тут.
        int countRowsInSource = Integer.parseInt(properties.getProperty("system.RownumPool"));
        String countSelectedRows = dh.getRoonumPool("adresse.SOURCE.CountRowForPool");
        ArrayList arrayRows = dh.getArray(countRowsInSource);
        String sqlfromSource = (properties.getProperty("adresse.SOURCE.RowByRownumPart1") + countRowsInSource
                + properties.getProperty("adresse.SOURCE.RowByRownumPart2"));
//Сравнение данных
        Connection connectionToRTest = db.connToRTest();
        Statement statmentForRTest = db.stFromConnection(connectionToRTest);
        ResultSet rsCountRowFromRTest = db.rsFromDB(statmentForRTest, countSelectedRows);
        while (rsCountRowFromRTest.next()) {
            for (int i = 0; i < arrayRows.size(); i++) {
                String sqlRowByRownum = sqlfromSource + arrayRows.get(i);
                //System.out.println("SQL from Source:" + sqlRowByRownum);
                ResultSet rsFromRTest = db.rsFromDB(statmentForRTest, sqlRowByRownum);
                while (rsFromRTest.next()) {
                    mapForSource = dh.getMapFromSource(rsFromRTest);
// У таблицы собственные ключи. Если менять, то тут.
                    String sqlFromSA = (properties.getProperty("adresse.MSCRUS.RowByPKFromSA") + " SELSKAB = " + rsFromRTest.getString("SELSKAB")
                            + " and REF_TYPE = '" + rsFromRTest.getString("REF_TYPE") + "' and REF_NR = " + rsFromRTest.getString("REF_NR")
                            + " and NR = " + rsFromRTest.getString("NR"));

                    mapForSA = dh.getMapFromSA(mapForSource.size(), sqlFromSA);
                }
                rsFromRTest.close();
                asserts.matchMaps(mapForSource, mapForSA);
            }
        }
        rsCountRowFromRTest.close();
        statmentForRTest.close();
        connectionToRTest.close();
    }

    @Description("Сравнение данных записей таблиц ADRESSE ")
    @Title("Сравнение данных записей таблиц ADRESSE в ITest и UNITY")
    @Test
    public void ITestVsUNITY() throws SQLException, IOException {
        getPropertiesFile();
//Для маленьких таблиц должен быть выбран count(*). Менять параметр тут.
        int countRowsInSource = Integer.parseInt(properties.getProperty("system.RownumPool"));
        String countSelectedRows = dh.getRoonumPool("adresse.SOURCE.CountRowForPool");
        ArrayList arrayRows = dh.getArray(countRowsInSource);
        String sqlfromSource = (properties.getProperty("adresse.SOURCE.RowByRownumPart1") + countRowsInSource
                + properties.getProperty("adresse.SOURCE.RowByRownumPart2"));
//Сравнение данных
        Connection connectionToITest = db.connToITest();
        Statement statmentForITest = db.stFromConnection(connectionToITest);
        ResultSet rsCountRowFromITest = db.rsFromDB(statmentForITest, countSelectedRows);
        while (rsCountRowFromITest.next()) {
            for (int i = 0; i < arrayRows.size(); i++) {
                String sqlRowByRownum = sqlfromSource + arrayRows.get(i);
                //System.out.println("SQL from Source:" + sqlRowByRownum);
                ResultSet rsFromITest = db.rsFromDB(statmentForITest, sqlRowByRownum);
                while (rsFromITest.next()) {
                    mapForSource = dh.getMapFromSource(rsFromITest);
// У таблицы собственные ключи. Если менять, то тут.
                    String sqlFromSA = (properties.getProperty("adresse.UNITY.RowByPKFromSA") + " SELSKAB = " + rsFromITest.getString("SELSKAB")
                            + " and REF_TYPE = '" + rsFromITest.getString("REF_TYPE") + "' and REF_NR = " + rsFromITest.getString("REF_NR")
                            + " and NR = " + rsFromITest.getString("NR"));

                    mapForSA = dh.getMapFromSA(mapForSource.size(), sqlFromSA);
                }
                rsFromITest.close();
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
}

