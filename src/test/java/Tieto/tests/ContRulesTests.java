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

public class ContRulesTests {
    private Asserts asserts = new Asserts();
    private GetDataHelper dh = new GetDataHelper();
    private DBHelper db = new DBHelper();
    private Properties properties = new Properties();

    private Map<String, Object> mapForSource = new HashMap<String, Object>();
    private Map<String, Object> mapForSA = new HashMap<String, Object>();


    @Description("Сравнение данных записей таблиц CONTRULES ")
    @Title("Сравнение данных записей таблиц CONTRULES в RTest и MSCRUS")
    @Test
    public void RTestVsMSCRUS() throws SQLException, IOException {
        getPropertiesFile();
//Для маленьких таблиц должен быть выбран count(*). Менять параметр тут.
        int countRowsInSource = Integer.parseInt(properties.getProperty("system.RownumPool"));
        String countSelectedRows = dh.getRoonumPool("contRules.SOURCE.CountRowForPool");
        ArrayList arrayRows = dh.getArray(countRowsInSource);
        String sqlfromSource = (properties.getProperty("contRules.SOURCE.RowByRownumPart1") + countRowsInSource
                + properties.getProperty("contRules.SOURCE.RowByRownumPart2"));
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
                    String sqlFromSA = (properties.getProperty("contRules.MSCRUS.RowByPKFromSA") + " SELSKAB = " + rsFromRTest.getString("SELSKAB")
                            + " and AFDELING = '" + rsFromRTest.getString("AFDELING") + "' and AFG_ZONE = '" + rsFromRTest.getString("AFG_ZONE")
                            + "' and AFSENDER = '" + rsFromRTest.getString("AFSENDER") + "' and ANK_ZONE = '" + rsFromRTest.getString("ANK_ZONE")
                            + "' and CONT_TYPE = '" + rsFromRTest.getString("CONT_TYPE") + "' and CUST_COUNTRY = '" + rsFromRTest.getString("CUST_COUNTRY")
                            + "' and FORWARDER = '" + rsFromRTest.getString("FORWARDER") + "' and FRA_DATO = '" + rsFromRTest.getString("FRA_DATO")
                            + "' and IMP_EXP = '" + rsFromRTest.getString("IMP_EXP") + "' and KODE = '" + rsFromRTest.getString("KODE")
                            + "' and KUNDE = '" + rsFromRTest.getString("KUNDE") + "' and LOC = '" + rsFromRTest.getString("LOC")
                            + "' and MODTAGER = '" + rsFromRTest.getString("MODTAGER") + "' and NOTIFY3 = '" + rsFromRTest.getString("NOTIFY3")
                            + "' and PLACE_OF_STUFFING = '" + rsFromRTest.getString("PLACE_OF_STUFFING") + "' and POD = '" + rsFromRTest.getString("POD")
                            + "' and PORT = '" + rsFromRTest.getString("PORT") + "' and REF_NR = '" + rsFromRTest.getString("REF_NR")
                            + "' and REF_TYPE = '" + rsFromRTest.getString("REF_TYPE") + "' and SPEC_REF_NUMBER = '" + rsFromRTest.getString("SPEC_REF_NUMBER")
                            + "' and TIL_DATO = '" + rsFromRTest.getString("TIL_DATO") + "'");
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

    @Description("Сравнение данных записей таблиц CONTRULES ")
    @Title("Сравнение данных записей таблиц CONTRULES в RTest и UNITY")
    @Test
    public void ITestVsUNITY() throws SQLException, IOException {
        getPropertiesFile();
//Для маленьких таблиц должен быть выбран count(*). Менять параметр тут.
        int countRowsInSource = Integer.parseInt(properties.getProperty("system.RownumPool"));
        String countSelectedRows = dh.getRoonumPool("contRules.SOURCE.CountRowForPool");
        ArrayList arrayRows = dh.getArray(countRowsInSource);
        String sqlfromSource = (properties.getProperty("contRules.SOURCE.RowByRownumPart1") + countRowsInSource
                + properties.getProperty("contRules.SOURCE.RowByRownumPart2"));
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
                    String sqlFromSA = (properties.getProperty("contRules.UNITY.RowByPKFromSA") + " SELSKAB = " + rsFromITest.getString("SELSKAB")
                            + " and AFDELING = '" + rsFromITest.getString("AFDELING") + "' and AFG_ZONE = '" + rsFromITest.getString("AFG_ZONE")
                            + "' and AFSENDER = '" + rsFromITest.getString("AFSENDER") + "' and ANK_ZONE = '" + rsFromITest.getString("ANK_ZONE")
                            + "' and CONT_TYPE = '" + rsFromITest.getString("CONT_TYPE") + "' and CUST_COUNTRY = '" + rsFromITest.getString("CUST_COUNTRY")
                            + "' and FORWARDER = '" + rsFromITest.getString("FORWARDER") + "' and FRA_DATO = '" + rsFromITest.getString("FRA_DATO")
                            + "' and IMP_EXP = '" + rsFromITest.getString("IMP_EXP") + "' and KODE = '" + rsFromITest.getString("KODE")
                            + "' and KUNDE = '" + rsFromITest.getString("KUNDE") + "' and LOC = '" + rsFromITest.getString("LOC")
                            + "' and MODTAGER = '" + rsFromITest.getString("MODTAGER") + "' and NOTIFY3 = '" + rsFromITest.getString("NOTIFY3")
                            + "' and PLACE_OF_STUFFING = '" + rsFromITest.getString("PLACE_OF_STUFFING") + "' and POD = '" + rsFromITest.getString("POD")
                            + "' and PORT = '" + rsFromITest.getString("PORT") + "' and REF_NR = '" + rsFromITest.getString("REF_NR")
                            + "' and REF_TYPE = '" + rsFromITest.getString("REF_TYPE") + "' and SPEC_REF_NUMBER = '" + rsFromITest.getString("SPEC_REF_NUMBER")
                            + "' and TIL_DATO = '" + rsFromITest.getString("TIL_DATO") + "'");
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


