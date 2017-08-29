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

public class ZCountsInTablesTests_2stStage {

    private Properties properties = new Properties();
    private Asserts asserts = new Asserts();
    private GetDataHelper dh = new GetDataHelper();
    private DBHelper db = new DBHelper();

    @Test(enabled = true)
    public void ContBevRTestVsMSCRUS() throws SQLException, IOException {
        getPropertiesFile();
        int counRowsInSource = dh.getCountRowsInRTest("contBev.SOURCE.CountRow");
        int counRowsInSA = dh.getCountRowsInSA("contBev.MSCRUS.CountRows");
        asserts.assertRowCount(counRowsInSource, counRowsInSA);
    }

    @Test (enabled = true)
    public void ContBevITestVsUNITY() throws SQLException, IOException {
        getPropertiesFile();
        int counRowsInSource = dh.getCountRowsInITest("contBev.SOURCE.CountRow");
        int counRowsInSA = dh.getCountRowsInSA("contBev.UNITY.CountRows");
        asserts.assertRowCount(counRowsInSource, counRowsInSA);
    }

    @Test(enabled = true)
    public void ContRulesRTestVsMSCRUS() throws SQLException, IOException {
        getPropertiesFile();
        int counRowsInSource = dh.getCountRowsInRTest("contRules.SOURCE.CountRow");
        int counRowsInSA = dh.getCountRowsInSA("contRules.MSCRUS.CountRows");
        asserts.assertRowCount(counRowsInSource, counRowsInSA);
    }

    @Test (enabled = true)
    public void ContRulesITestVsUNITY() throws SQLException, IOException {
        getPropertiesFile();
        int counRowsInSource = dh.getCountRowsInITest("contRules.SOURCE.CountRow");
        int counRowsInSA = dh.getCountRowsInSA("contRules.UNITY.CountRows");
        asserts.assertRowCount(counRowsInSource, counRowsInSA);
    }

    @Test(enabled = true)
    public void ContMasterRTestVsMSCRUS() throws SQLException, IOException {
        getPropertiesFile();
        int counRowsInSource = dh.getCountRowsInRTest("contMaster.SOURCE.CountRow");
        int counRowsInSA = dh.getCountRowsInSA("contMaster.MSCRUS.CountRows");
        asserts.assertRowCount(counRowsInSource, counRowsInSA);
    }

    @Test (enabled = true)
    public void ContMasterITestVsUNITY() throws SQLException, IOException {
        getPropertiesFile();
        int counRowsInSource = dh.getCountRowsInITest("contMaster.SOURCE.CountRow");
        int counRowsInSA = dh.getCountRowsInSA("contMaster.UNITY.CountRows");
        asserts.assertRowCount(counRowsInSource, counRowsInSA);
    }

    @Test (enabled = true)
    public void CtsContEventITestVsUNITY() throws SQLException, IOException {
        getPropertiesFile();
        int counRowsInSource = dh.getCountRowsInITest("ctsContEvent.SOURCE.CountRow");
        int counRowsInSA = dh.getCountRowsInSA("ctsContEvent.UNITY.CountRows");
        asserts.assertRowCount(counRowsInSource, counRowsInSA);
    }


    @Test(enabled = true)
    public void CtsContEventRTestVsMSCRUS() throws SQLException, IOException {
        getPropertiesFile();
        int counRowsInSource = dh.getCountRowsInRTest("ctsContEvent.SOURCE.CountRow");
        int counRowsInSA = dh.getCountRowsInSA("ctsContEvent.MSCRUS.CountRows");
        asserts.assertRowCount(counRowsInSource, counRowsInSA);
    }

    @Test (enabled = true)
    public void DemurrageITestVsUNITY() throws SQLException, IOException {
        getPropertiesFile();
        int counRowsInSource = dh.getCountRowsInITest("demurrage.SOURCE.CountRow");
        int counRowsInSA = dh.getCountRowsInSA("demurrage.UNITY.CountRows");
        asserts.assertRowCount(counRowsInSource, counRowsInSA);
    }


    @Test(enabled = true)
    public void DemurrageRTestVsMSCRUS() throws SQLException, IOException {
        getPropertiesFile();
        int counRowsInSource = dh.getCountRowsInRTest("demurrage.SOURCE.CountRow");
        int counRowsInSA = dh.getCountRowsInSA("demurrage.MSCRUS.CountRows");
        asserts.assertRowCount(counRowsInSource, counRowsInSA);
    }

    @Test (enabled = true)
    public void VgmITestVsUNITY() throws SQLException, IOException {
        getPropertiesFile();
        int counRowsInSource = dh.getCountRowsInITest("vgm.SOURCE.CountRow");
        int counRowsInSA = dh.getCountRowsInSA("vgm.UNITY.CountRows");
        asserts.assertRowCount(counRowsInSource, counRowsInSA);
    }


    @Test(enabled = true)
    public void VgmRTestVsMSCRUS() throws SQLException, IOException {
        getPropertiesFile();
        int counRowsInSource = dh.getCountRowsInRTest("vgm.SOURCE.CountRow");
        int counRowsInSA = dh.getCountRowsInSA("vgm.MSCRUS.CountRows");
        asserts.assertRowCount(counRowsInSource, counRowsInSA);
    }

    @Test (enabled = true)
    public void VgmCodesITestVsUNITY() throws SQLException, IOException {
        getPropertiesFile();
        int counRowsInSource = dh.getCountRowsInITest("vgmCodes.SOURCE.CountRow");
        int counRowsInSA = dh.getCountRowsInSA("vgmCodes.UNITY.CountRows");
        asserts.assertRowCount(counRowsInSource, counRowsInSA);
    }

    @Test(enabled = true)
    public void VgmCodesRTestVsMSCRUS() throws SQLException, IOException {
        getPropertiesFile();
        int counRowsInSource = dh.getCountRowsInRTest("vgmCodes.SOURCE.CountRow");
        int counRowsInSA = dh.getCountRowsInSA("vgmCodes.MSCRUS.CountRows");
        asserts.assertRowCount(counRowsInSource, counRowsInSA);
    }

    @Test (enabled = true)
    public void ServiceITestVsUNITY() throws SQLException, IOException {
        getPropertiesFile();
        int counRowsInSource = dh.getCountRowsInITest("service.SOURCE.CountRow");
        int counRowsInSA = dh.getCountRowsInSA("service.UNITY.CountRows");
        asserts.assertRowCount(counRowsInSource, counRowsInSA);
    }

    @Test(enabled = true)
    public void ServiceRTestVsMSCRUS() throws SQLException, IOException {
        getPropertiesFile();
        int counRowsInSource = dh.getCountRowsInRTest("service.SOURCE.CountRow");
        int counRowsInSA = dh.getCountRowsInSA("service.MSCRUS.CountRows");
        asserts.assertRowCount(counRowsInSource, counRowsInSA);
    }

    @Test (enabled = true)
    public void BookBemInternalITestVsUNITY() throws SQLException, IOException {
        getPropertiesFile();
        int counRowsInSource = dh.getCountRowsInITest("bookBemInternal.SOURCE.CountRow");
        int counRowsInSA = dh.getCountRowsInSA("bookBemInternal.UNITY.CountRows");
        asserts.assertRowCount(counRowsInSource, counRowsInSA);
    }

    @Test(enabled = true)
    public void BookBemInternalRTestVsMSCRUS() throws SQLException, IOException {
        getPropertiesFile();
        int counRowsInSource = dh.getCountRowsInRTest("bookBemInternal.SOURCE.CountRow");
        int counRowsInSA = dh.getCountRowsInSA("bookBemInternal.MSCRUS.CountRows");
        asserts.assertRowCount(counRowsInSource, counRowsInSA);
    }

    @Test (enabled = true)
    public void KontorITestVsUNITY() throws SQLException, IOException {
        getPropertiesFile();
        int counRowsInSource = dh.getCountRowsInITest("kontor.SOURCE.CountRow");
        int counRowsInSA = dh.getCountRowsInSA("kontor.UNITY.CountRows");
        asserts.assertRowCount(counRowsInSource, counRowsInSA);
    }

    @Test(enabled = true)
    public void KontorRTestVsMSCRUS() throws SQLException, IOException {
        getPropertiesFile();
        int counRowsInSource = dh.getCountRowsInRTest("kontor.SOURCE.CountRow");
        int counRowsInSA = dh.getCountRowsInSA("kontor.MSCRUS.CountRows");
        asserts.assertRowCount(counRowsInSource, counRowsInSA);
    }


    @Test (enabled = true)
    public void CommodityITestVsUNITY() throws SQLException, IOException {
        getPropertiesFile();
        int counRowsInSource = dh.getCountRowsInITest("commodity.SOURCE.CountRow");
        int counRowsInSA = dh.getCountRowsInSA("commodity.UNITY.CountRows");
        asserts.assertRowCount(counRowsInSource, counRowsInSA);
    }

    @Test(enabled = true)
    public void CommodityRTestVsMSCRUS() throws SQLException, IOException {
        getPropertiesFile();
        int counRowsInSource = dh.getCountRowsInRTest("commodity.SOURCE.CountRow");
        int counRowsInSA = dh.getCountRowsInSA("commodity.MSCRUS.CountRows");
        asserts.assertRowCount(counRowsInSource, counRowsInSA);
    }


    @Test (enabled = true)
    public void StedBarITestVsUNITY() throws SQLException, IOException {
        getPropertiesFile();
        int counRowsInSource = dh.getCountRowsInITest("stedBar.SOURCE.CountRow");
        int counRowsInSA = dh.getCountRowsInSA("stedBar.UNITY.CountRows");
        asserts.assertRowCount(counRowsInSource, counRowsInSA);
    }

    @Test(enabled = true)
    public void StedBarRTestVsMSCRUS() throws SQLException, IOException {
        getPropertiesFile();
        int counRowsInSource = dh.getCountRowsInRTest("stedBar.SOURCE.CountRow");
        int counRowsInSA = dh.getCountRowsInSA("stedBar.MSCRUS.CountRows");
        asserts.assertRowCount(counRowsInSource, counRowsInSA);
    }

    private void getPropertiesFile() throws IOException {
        properties.load(new FileReader(new File(String.format("src/test/resources/sql.properties"))));
    }
}
