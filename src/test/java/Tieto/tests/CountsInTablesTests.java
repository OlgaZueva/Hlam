package Tieto.tests;

import Tieto.helpers.Asserts;
import Tieto.helpers.DBHelper;
import Tieto.helpers.GetDataHelper;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Created by zuevaolg on 03.04.2017.
 */
public class CountsInTablesTests {
    private Properties properties = new Properties();
    private Asserts asserts = new Asserts();
    private GetDataHelper dh = new GetDataHelper();
    private DBHelper db = new DBHelper();

    @Test
    public void AbPostRTestVsMSCRUS() throws SQLException, IOException {
        getPropertiesFile();
        int counRowsInSource = dh.getCountRowsInRTest("abpost.SOURCE.CountRow");
        int counRowsInSA = dh.getCountRowsInSA("abpost.MSCRUS.CountRows");
        asserts.assertRowCount(counRowsInSource, counRowsInSA);
    }

    @Test
    public void AbPostITestVsUNITY() throws SQLException, IOException {
        getPropertiesFile();
        int counRowsInSource = dh.getCountRowsInITest("abpost.SOURCE.CountRow");
        int counRowsInSA = dh.getCountRowsInSA("abpost.UNITY.CountRows");
        asserts.assertRowCount(counRowsInSource, counRowsInSA);
    }

    @Test
    public void AdgangLinRTestVsMSCRUS() throws SQLException, IOException {
        getPropertiesFile();
        int counRowsInSource = dh.getCountRowsInRTest("adganglin.SOURCE.CountRow");
        int counRowsInSA = dh.getCountRowsInSA("adganglin.MSCRUS.CountRows");
        asserts.assertRowCount(counRowsInSource, counRowsInSA);
    }

    @Test
    public void AdgangITestLinVsUNITY() throws SQLException, IOException {
        getPropertiesFile();
        int counRowsInSource = dh.getCountRowsInITest("adganglin.SOURCE.CountRow");
        int counRowsInSA = dh.getCountRowsInSA("adganglin.UNITY.CountRows");
        asserts.assertRowCount(counRowsInSource, counRowsInSA);
    }

    @Test
    public void AdgangRTestVsMSCRUS() throws SQLException, IOException {
        getPropertiesFile();
        int counRowsInSource = dh.getCountRowsInRTest("adgang.SOURCE.CountRow");
        int counRowsInSA = dh.getCountRowsInSA("adgang.MSCRUS.CountRows");
        asserts.assertRowCount(counRowsInSource, counRowsInSA);
    }

    @Test
    public void AdgangITestVsUNITY() throws SQLException, IOException {
        getPropertiesFile();
        int counRowsInSource = dh.getCountRowsInITest("adgang.SOURCE.CountRow");
        int counRowsInSA = dh.getCountRowsInSA("adgang.UNITY.CountRows");
        asserts.assertRowCount(counRowsInSource, counRowsInSA);
    }


    @Test
    public void AdresseRTestVsMSCRUS() throws SQLException, IOException {
        getPropertiesFile();
        int counRowsInSource = dh.getCountRowsInRTest("adresse.SOURCE.CountRow");
        int counRowsInSA = dh.getCountRowsInSA("adresse.MCSRUS.CountRows");
        asserts.assertRowCount(counRowsInSource, counRowsInSA);
    }

    @Test
    public void AdresseITestVsUNITY() throws SQLException, IOException {
        getPropertiesFile();
        int counRowsInSource = dh.getCountRowsInITest("adresse.SOURCE.CountRow");
        int counRowsInSA = dh.getCountRowsInSA("adresse.UNITY.CountRows");
        asserts.assertRowCount(counRowsInSource, counRowsInSA);
    }

    @Test
    public void BookGodsRTestVsMSCRUS() throws SQLException, IOException {
        getPropertiesFile();
        int counRowsInSource = dh.getCountRowsInRTest("bookgods.SOURCE.CountRow");
        int counRowsInSA = dh.getCountRowsInSA("bookgods.MCSRUS.CountRows");
        asserts.assertRowCount(counRowsInSource, counRowsInSA);
    }

    @Test
    public void BookGodsITestVsUNITY() throws SQLException, IOException {
        getPropertiesFile();
        int counRowsInSource = dh.getCountRowsInITest("bookgods.SOURCE.CountRow");
        int counRowsInSA = dh.getCountRowsInSA("bookgods.UNITY.CountRows");
        asserts.assertRowCount(counRowsInSource, counRowsInSA);
    }

    private void getPropertiesFile() throws IOException {
        properties.load(new FileReader(new File(String.format("src/test/resources/sql.properties"))));
    }
}
