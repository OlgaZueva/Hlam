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

public class VgmTests {
    private Asserts asserts = new Asserts();
    private GetDataHelper dh = new GetDataHelper();
    private DBHelper db = new DBHelper();
    private Properties properties = new Properties();

    private Map<String, Object> mapForSource = new HashMap<String, Object>();
    private Map<String, Object> mapForSA = new HashMap<String, Object>();


    @Description("Сравнение данных записей таблиц VGM ")
    @Title("Сравнение данных записей таблиц VGM в RTest и MSCRUS")
    @Test
    public void RTestVsMSCRUS() throws SQLException, IOException {
        getPropertiesFile();
//Для маленьких таблиц должен быть выбран count(*). Менять параметр тут.
        int countRowsInSource = Integer.parseInt(properties.getProperty("system.RownumPool"));
        String countSelectedRows = dh.getRoonumPool("vgm.SOURCE.CountRowForPool");
        ArrayList arrayRows = dh.getArray(countRowsInSource);
        String sqlfromSource = (properties.getProperty("vgm.SOURCE.RowByRownumPart1") + countRowsInSource
                + properties.getProperty("vgm.SOURCE.RowByRownumPart2"));
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
                    String sqlFromSA = (properties.getProperty("vgm.MSCRUS.RowByPKFromSA") + " SELSKAB = " + rsFromRTest.getString("SELSKAB")
                            + " and ID = " + rsFromRTest.getString("ID"));
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

    @Description("Сравнение данных записей таблиц VGM ")
    @Title("Сравнение данных записей таблиц VGM в RTest и UNITY")
    @Test
    public void ITestVsUNITY() throws SQLException, IOException {
        getPropertiesFile();
//Для маленьких таблиц должен быть выбран count(*). Менять параметр тут.
        int countRowsInSource = Integer.parseInt(properties.getProperty("system.RownumPool"));
        String countSelectedRows = dh.getRoonumPool("vgm.SOURCE.CountRowForPool");
        ArrayList arrayRows = dh.getArray(countRowsInSource);
        String sqlfromSource = (properties.getProperty("vgm.SOURCE.RowByRownumPart1") + countRowsInSource
                + properties.getProperty("vgm.SOURCE.RowByRownumPart2"));
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
                    String sqlFromSA = (properties.getProperty("vgm.UNITY.RowByPKFromSA") + " SELSKAB = " + rsFromITest.getString("SELSKAB")
                            + " and ID = " + rsFromITest.getString("ID"));
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

