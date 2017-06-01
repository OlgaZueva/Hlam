package Tieto.tests;

import Tieto.helpers.Asserts;
import Tieto.helpers.DBHelper;
import Tieto.helpers.GetDataHelper;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class ZQueriesWithSums {

    private Properties properties = new Properties();
    private Asserts asserts = new Asserts();
    private GetDataHelper dh = new GetDataHelper();
    private DBHelper db = new DBHelper();

    private Map<String, Object> mapForSource = new HashMap<String, Object>();
    private Map<String, Object> mapForSA = new HashMap<String, Object>();

    @Test
    public void ORDRE_LIN_CountFromRTest() throws SQLException, IOException {
        getPropertiesFile();
        int countRowsInRTest = dh.getCountRowsInRTest("ORDRE_LIN.recordCountFromSource");
        int countRowsInSA = dh.getCountRowsInSA("ORDRE_LIN.recordCountFromSA_RTEST");
        asserts.assertRowCount(countRowsInRTest, countRowsInSA);
    }

    @Test
    public void ORDRE_LIN_CountFromTTest() throws SQLException, IOException {
        getPropertiesFile();
        int countRowsInITest = dh.getCountRowsInITest("ORDRE_LIN.recordCountFromSource");
        int countRowsInSA = dh.getCountRowsInSA("ORDRE_LIN.recordCountFromSA_ITEST");
        asserts.assertRowCount(countRowsInITest, countRowsInSA);
    }

    @Test
    public void ORDRE_LIN_TestParameterFromRTest() throws SQLException, IOException {
        getPropertiesFile();
        String sqlFromSource = (properties.getProperty("ORDRE_LIN.testParameterFromSource"));
        Connection connectionToRTest = db.connToRTest();
        Statement stForRTest = db.stFromConnection(connectionToRTest);
        ResultSet rsFromRTest = db.rsFromDB(stForRTest, sqlFromSource);
        while (rsFromRTest.next()) {
            mapForSource = dh.getMapFromSourceForSumm(rsFromRTest);
            System.out.println("mapForSource.size(): " + mapForSource.size());
            String sqlFromSA = (properties.getProperty("ORDRE_LIN.TestParameterFromSA_RTEST"));
            mapForSA = dh.getMapFromSAForSum(mapForSource.size(), sqlFromSA);
        }
        rsFromRTest.close();
        asserts.matchMaps(mapForSource, mapForSA);
    }

    @Test
    public void ORDRE_LIN_TestParameterFromITest() throws SQLException, IOException {
        getPropertiesFile();
        String sqlFromSource = (properties.getProperty("ORDRE_LIN.testParameterFromSource"));
        Connection connectionToITest = db.connToITest();
        Statement stForITest = db.stFromConnection(connectionToITest);
        ResultSet rsFromITest = db.rsFromDB(stForITest, sqlFromSource);
        while (rsFromITest.next()) {
            mapForSource = dh.getMapFromSourceForSumm(rsFromITest);
            System.out.println("mapForSource.size: " + mapForSource.size());
            String sqlFromSA = (properties.getProperty("ORDRE_LIN.TestParameterFromSA_ITEST"));
            mapForSA = dh.getMapFromSAForSum(mapForSource.size(), sqlFromSA);
        }
        rsFromITest.close();
        asserts.matchMaps(mapForSource, mapForSA);
    }

    @Test
    public void BOGF_TRANS_CountFromRTest() throws SQLException, IOException {
        getPropertiesFile();
        int countRowsInRTest = dh.getCountRowsInRTest("BOGF_TRANS.recordCountFromSource");
        int countRowsInSA = dh.getCountRowsInSA("BOGF_TRANS.recordCountFromSA_RTEST");
        asserts.assertRowCount(countRowsInRTest, countRowsInSA);
    }

    @Test
    public void BOGF_TRANS_CountFromTTest() throws SQLException, IOException {
        getPropertiesFile();
        int countRowsInITest = dh.getCountRowsInITest("BOGF_TRANS.recordCountFromSource");
        int countRowsInSA = dh.getCountRowsInSA("BOGF_TRANS.recordCountFromSA_ITEST");
        asserts.assertRowCount(countRowsInITest, countRowsInSA);
    }

    @Test
    public void BOGF_TRANS_TestParameterFromRTest() throws SQLException, IOException {
        getPropertiesFile();
        String sqlFromSource = (properties.getProperty("BOGF_TRANS.testParameterFromSource"));
        Connection connectionToRTest = db.connToRTest();
        Statement stForRTest = db.stFromConnection(connectionToRTest);
        ResultSet rsFromRTest = db.rsFromDB(stForRTest, sqlFromSource);
        while (rsFromRTest.next()) {
            mapForSource = dh.getMapFromSourceForSumm(rsFromRTest);
            System.out.println("mapForSource.size(): " + mapForSource.size());
            String sqlFromSA = (properties.getProperty("BOGF_TRANS.TestParameterFromSA_RTEST"));
            mapForSA = dh.getMapFromSAForSum(mapForSource.size(), sqlFromSA);
        }
        rsFromRTest.close();
        asserts.matchMaps(mapForSource, mapForSA);
    }

    @Test
    public void BOGF_TRANS_TestParameterFromITest() throws SQLException, IOException {
        getPropertiesFile();
        String sqlFromSource = (properties.getProperty("BOGF_TRANS.testParameterFromSource"));
        Connection connectionToITest = db.connToITest();
        Statement stForITest = db.stFromConnection(connectionToITest);
        ResultSet rsFromITest = db.rsFromDB(stForITest, sqlFromSource);
        while (rsFromITest.next()) {
            mapForSource = dh.getMapFromSourceForSumm(rsFromITest);
            System.out.println("mapForSource.size: " + mapForSource.size());
            String sqlFromSA = (properties.getProperty("BOGF_TRANS.TestParameterFromSA_ITEST"));
            mapForSA = dh.getMapFromSAForSum(mapForSource.size(), sqlFromSA);
        }
        rsFromITest.close();
        asserts.matchMaps(mapForSource, mapForSA);
    }

    @Test
    public void AB_POST_CountFromRTest() throws SQLException, IOException {
        getPropertiesFile();
        int countRowsInRTest = dh.getCountRowsInRTest("AB_POST.recordCountFromSource");
        int countRowsInSA = dh.getCountRowsInSA("AB_POST.recordCountFromSA_RTEST");
        asserts.assertRowCount(countRowsInRTest, countRowsInSA);
    }

    @Test
    public void AB_POST_CountFromTTest() throws SQLException, IOException {
        getPropertiesFile();
        int countRowsInITest = dh.getCountRowsInITest("AB_POST.recordCountFromSource");
        int countRowsInSA = dh.getCountRowsInSA("AB_POST.recordCountFromSA_ITEST");
        asserts.assertRowCount(countRowsInITest, countRowsInSA);
    }

    @Test
    public void AB_POST_TestParameterFromRTest() throws SQLException, IOException {
        getPropertiesFile();
        String sqlFromSource = (properties.getProperty("AB_POST.testParameterFromSource"));
        Connection connectionToRTest = db.connToRTest();
        Statement stForRTest = db.stFromConnection(connectionToRTest);
        ResultSet rsFromRTest = db.rsFromDB(stForRTest, sqlFromSource);
        while (rsFromRTest.next()) {
            mapForSource = dh.getMapFromSourceForSumm(rsFromRTest);
            System.out.println("mapForSource.size(): " + mapForSource.size());
            String sqlFromSA = (properties.getProperty("AB_POST.TestParameterFromSA_RTEST"));
            mapForSA = dh.getMapFromSAForSum(mapForSource.size(), sqlFromSA);
        }
        rsFromRTest.close();
        asserts.matchMaps(mapForSource, mapForSA);
    }

    @Test
    public void AB_POST_TestParameterFromITest() throws SQLException, IOException {
        getPropertiesFile();
        String sqlFromSource = (properties.getProperty("AB_POST.testParameterFromSource"));
        Connection connectionToITest = db.connToITest();
        Statement stForITest = db.stFromConnection(connectionToITest);
        ResultSet rsFromITest = db.rsFromDB(stForITest, sqlFromSource);
        while (rsFromITest.next()) {
            mapForSource = dh.getMapFromSourceForSumm(rsFromITest);
            String sqlFromSA = (properties.getProperty("AB_POST.TestParameterFromSA_ITEST"));
            mapForSA = dh.getMapFromSAForSum(mapForSource.size(), sqlFromSA);
        }
        rsFromITest.close();
        asserts.matchMaps(mapForSource, mapForSA);
    }


    @Test
    public void FAKT_POST_CountFromRTest() throws SQLException, IOException {
        getPropertiesFile();
        int countRowsInRTest = dh.getCountRowsInRTest("FAKT_POST.recordCountFromSource");
        int countRowsInSA = dh.getCountRowsInSA("FAKT_POST.recordCountFromSA_RTEST");
        asserts.assertRowCount(countRowsInRTest, countRowsInSA);
    }

    @Test
    public void FAKT_POST_CountFromTTest() throws SQLException, IOException {
        getPropertiesFile();
        int countRowsInITest = dh.getCountRowsInITest("FAKT_POST.recordCountFromSource");
        int countRowsInSA = dh.getCountRowsInSA("FAKT_POST.recordCountFromSA_ITEST");
        asserts.assertRowCount(countRowsInITest, countRowsInSA);
    }

    @Test
    public void FAKT_POST_TestParameterFromRTest() throws SQLException, IOException {
        getPropertiesFile();
        String sqlFromSource = (properties.getProperty("FAKT_POST.testParameterFromSource"));
        Connection connectionToRTest = db.connToRTest();
        Statement stForRTest = db.stFromConnection(connectionToRTest);
        ResultSet rsFromRTest = db.rsFromDB(stForRTest, sqlFromSource);
        while (rsFromRTest.next()) {
            mapForSource = dh.getMapFromSourceForSumm(rsFromRTest);
            System.out.println("mapForSource.size(): " + mapForSource.size());
            String sqlFromSA = (properties.getProperty("FAKT_POST.TestParameterFromSA_RTEST"));
            mapForSA = dh.getMapFromSAForSum(mapForSource.size(), sqlFromSA);
        }
        rsFromRTest.close();
        asserts.matchMaps(mapForSource, mapForSA);
    }

    @Test
    public void FAKT_POST_TestParameterFromITest() throws SQLException, IOException {
        getPropertiesFile();
        String sqlFromSource = (properties.getProperty("FAKT_POST.testParameterFromSource"));
        Connection connectionToITest = db.connToITest();
        Statement stForITest = db.stFromConnection(connectionToITest);
        ResultSet rsFromITest = db.rsFromDB(stForITest, sqlFromSource);
        while (rsFromITest.next()) {
            mapForSource = dh.getMapFromSourceForSumm(rsFromITest);
            System.out.println("mapForSource.size: " + mapForSource.size());
            String sqlFromSA = (properties.getProperty("FAKT_POST.TestParameterFromSA_ITEST"));
            mapForSA = dh.getMapFromSAForSum(mapForSource.size(), sqlFromSA);
        }
        rsFromITest.close();
        asserts.matchMaps(mapForSource, mapForSA);
    }

    private void getPropertiesFile() throws IOException {
        properties.load(new FileReader(new File(String.format("src/test/resources/sql.properties"))));
    }
}
