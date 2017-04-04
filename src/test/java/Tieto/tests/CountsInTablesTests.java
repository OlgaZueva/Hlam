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

    @Test (enabled = false)
    public void AbPostRTestVsMSCRUS() throws SQLException, IOException {
        getPropertiesFile();
        int counRowsInSource = dh.getCountRowsInRTest("abpost.SOURCE.CountRow");
        int counRowsInSA = dh.getCountRowsInSA("abpost.MSCRUS.CountRows");
        asserts.assertRowCount(counRowsInSource, counRowsInSA);
    }

    @Test (enabled = false)
    public void AbPostITestVsUNITY() throws SQLException, IOException {
        getPropertiesFile();
        int counRowsInSource = dh.getCountRowsInITest("abpost.SOURCE.CountRow");
        int counRowsInSA = dh.getCountRowsInSA("abpost.UNITY.CountRows");
        asserts.assertRowCount(counRowsInSource, counRowsInSA);
    }

    @Test (enabled = false)
    public void AdgangLinRTestVsMSCRUS() throws SQLException, IOException {
        getPropertiesFile();
        int counRowsInSource = dh.getCountRowsInRTest("adganglin.SOURCE.CountRow");
        int counRowsInSA = dh.getCountRowsInSA("adganglin.MSCRUS.CountRows");
        asserts.assertRowCount(counRowsInSource, counRowsInSA);
    }

    @Test (enabled = false)
    public void AdgangLinITestVsUNITY() throws SQLException, IOException {
        getPropertiesFile();
        int counRowsInSource = dh.getCountRowsInITest("adganglin.SOURCE.CountRow");
        int counRowsInSA = dh.getCountRowsInSA("adganglin.UNITY.CountRows");
        asserts.assertRowCount(counRowsInSource, counRowsInSA);
    }

    @Test (enabled = false)
    public void AdgangRTestVsMSCRUS() throws SQLException, IOException {
        getPropertiesFile();
        int counRowsInSource = dh.getCountRowsInRTest("adgang.SOURCE.CountRow");
        int counRowsInSA = dh.getCountRowsInSA("adgang.MSCRUS.CountRows");
        asserts.assertRowCount(counRowsInSource, counRowsInSA);
    }

    @Test (enabled = false)
    public void AdgangITestVsUNITY() throws SQLException, IOException {
        getPropertiesFile();
        int counRowsInSource = dh.getCountRowsInITest("adgang.SOURCE.CountRow");
        int counRowsInSA = dh.getCountRowsInSA("adgang.UNITY.CountRows");
        asserts.assertRowCount(counRowsInSource, counRowsInSA);
    }


    @Test (enabled = false)
    public void AdresseRTestVsMSCRUS() throws SQLException, IOException {
        getPropertiesFile();
        int counRowsInSource = dh.getCountRowsInRTest("adresse.SOURCE.CountRow");
        int counRowsInSA = dh.getCountRowsInSA("adresse.MSCRUS.CountRows");
        asserts.assertRowCount(counRowsInSource, counRowsInSA);
    }

    @Test(enabled = false)
    public void AdresseITestVsUNITY() throws SQLException, IOException {
        getPropertiesFile();
        int counRowsInSource = dh.getCountRowsInITest("adresse.SOURCE.CountRow");
        int counRowsInSA = dh.getCountRowsInSA("adresse.UNITY.CountRows");
        asserts.assertRowCount(counRowsInSource, counRowsInSA);
    }

    @Test(enabled = false)
    public void BogfTransRTestVsMSCRUS() throws SQLException, IOException {
        getPropertiesFile();
        int counRowsInSource = dh.getCountRowsInRTest("bogftrans.SOURCE.CountRow");
        int counRowsInSA = dh.getCountRowsInSA("bogftrans.MSCRUS.CountRows");
        asserts.assertRowCount(counRowsInSource, counRowsInSA);
    }

    @Test(enabled = false)
    public void BogfTransITestVsUNITY() throws SQLException, IOException {
        getPropertiesFile();
        int counRowsInSource = dh.getCountRowsInITest("bogftrans.SOURCE.CountRow");
        int counRowsInSA = dh.getCountRowsInSA("bogftrans.UNITY.CountRows");
        asserts.assertRowCount(counRowsInSource, counRowsInSA);
    }

    @Test (enabled = false)
    public void BookDetailsRTestVsMSCRUS() throws SQLException, IOException {
        getPropertiesFile();
        int counRowsInSource = dh.getCountRowsInRTest("bookdetails.SOURCE.CountRow");
        int counRowsInSA = dh.getCountRowsInSA("bookdetails.MSCRUS.CountRows");
        asserts.assertRowCount(counRowsInSource, counRowsInSA);
    }

    @Test (enabled = false)
    public void BookDetailsITestVsUNITY() throws SQLException, IOException {
        getPropertiesFile();
        int counRowsInSource = dh.getCountRowsInITest("bookdetails.SOURCE.CountRow");
        int counRowsInSA = dh.getCountRowsInSA("bookdetails.UNITY.CountRows");
        asserts.assertRowCount(counRowsInSource, counRowsInSA);
    }

    @Test
    public void BookDryPortsRTestVsMSCRUS() throws SQLException, IOException {
        getPropertiesFile();
        int counRowsInSource = dh.getCountRowsInRTest("bookdryport.SOURCE.CountRow");
        int counRowsInSA = dh.getCountRowsInSA("bookdryport.MSCRUS.CountRows");
        asserts.assertRowCount(counRowsInSource, counRowsInSA);
    }

    @Test
    public void BookDryPortsVsUNITY() throws SQLException, IOException {
        getPropertiesFile();
        int counRowsInSource = dh.getCountRowsInITest("bookdryport.SOURCE.CountRow");
        int counRowsInSA = dh.getCountRowsInSA("bookdryport.UNITY.CountRows");
        asserts.assertRowCount(counRowsInSource, counRowsInSA);
    }

    @Test(enabled = false)
    public void BookEventRTestVsMSCRUS() throws SQLException, IOException {
        getPropertiesFile();
        int counRowsInSource = dh.getCountRowsInRTest("bookevent.SOURCE.CountRow");
        int counRowsInSA = dh.getCountRowsInSA("bookevent.MSCRUS.CountRows");
        asserts.assertRowCount(counRowsInSource, counRowsInSA);
    }

    @Test(enabled = false)
    public void BookEventITestVsUNITY() throws SQLException, IOException {
        getPropertiesFile();
        int counRowsInSource = dh.getCountRowsInITest("bookevent.SOURCE.CountRow");
        int counRowsInSA = dh.getCountRowsInSA("bookevent.UNITY.CountRows");
        asserts.assertRowCount(counRowsInSource, counRowsInSA);
    }

    @Test (enabled = false)
    public void BookGodsRTestVsMSCRUS() throws SQLException, IOException {
        getPropertiesFile();
        int counRowsInSource = dh.getCountRowsInRTest("bookgods.SOURCE.CountRow");
        int counRowsInSA = dh.getCountRowsInSA("bookgods.MSCRUS.CountRows");
        asserts.assertRowCount(counRowsInSource, counRowsInSA);
    }

    @Test (enabled = false)
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
