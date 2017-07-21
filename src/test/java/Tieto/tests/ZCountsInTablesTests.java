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

public class ZCountsInTablesTests {
    private Properties properties = new Properties();
    private Asserts asserts = new Asserts();
    private GetDataHelper dh = new GetDataHelper();
    private DBHelper db = new DBHelper();

    @Test (enabled = true)
    public void AbPostRTestVsMSCRUS() throws SQLException, IOException {
        getPropertiesFile();
        int counRowsInSource = dh.getCountRowsInRTest("abpost.SOURCE.CountRow");
        int counRowsInSA = dh.getCountRowsInSA("abpost.MSCRUS.CountRows");
        asserts.assertRowCount(counRowsInSource, counRowsInSA);
    }

    @Test (enabled = true)
    public void AbPostITestVsUNITY() throws SQLException, IOException {
        getPropertiesFile();
        int counRowsInSource = dh.getCountRowsInITest("abpost.SOURCE.CountRow");
        int counRowsInSA = dh.getCountRowsInSA("abpost.UNITY.CountRows");
        asserts.assertRowCount(counRowsInSource, counRowsInSA);
    }

    @Test (enabled = true)
    public void AdgangLinRTestVsMSCRUS() throws SQLException, IOException {
        getPropertiesFile();
        int counRowsInSource = dh.getCountRowsInRTest("adganglin.SOURCE.CountRow");
        int counRowsInSA = dh.getCountRowsInSA("adganglin.MSCRUS.CountRows");
        asserts.assertRowCount(counRowsInSource, counRowsInSA);
    }

    @Test (enabled = true)
    public void AdgangLinITestVsUNITY() throws SQLException, IOException {
        getPropertiesFile();
        int counRowsInSource = dh.getCountRowsInITest("adganglin.SOURCE.CountRow");
        int counRowsInSA = dh.getCountRowsInSA("adganglin.UNITY.CountRows");
        asserts.assertRowCount(counRowsInSource, counRowsInSA);
    }

    @Test (enabled = true)
    public void AdgangRTestVsMSCRUS() throws SQLException, IOException {
        getPropertiesFile();
        int counRowsInSource = dh.getCountRowsInRTest("adgang.SOURCE.CountRow");
        int counRowsInSA = dh.getCountRowsInSA("adgang.MSCRUS.CountRows");
        asserts.assertRowCount(counRowsInSource, counRowsInSA);
    }

    @Test (enabled = true)
    public void AdgangITestVsUNITY() throws SQLException, IOException {
        getPropertiesFile();
        int counRowsInSource = dh.getCountRowsInITest("adgang.SOURCE.CountRow");
        int counRowsInSA = dh.getCountRowsInSA("adgang.UNITY.CountRows");
        asserts.assertRowCount(counRowsInSource, counRowsInSA);
    }


    @Test (enabled = true)
    public void AdresseRTestVsMSCRUS() throws SQLException, IOException {
        getPropertiesFile();
        int counRowsInSource = dh.getCountRowsInRTest("adresse.SOURCE.CountRow");
        int counRowsInSA = dh.getCountRowsInSA("adresse.MSCRUS.CountRows");
        asserts.assertRowCount(counRowsInSource, counRowsInSA);
    }

    @Test(enabled = true)
    public void AdresseITestVsUNITY() throws SQLException, IOException {
        getPropertiesFile();
        int counRowsInSource = dh.getCountRowsInITest("adresse.SOURCE.CountRow");
        int counRowsInSA = dh.getCountRowsInSA("adresse.UNITY.CountRows");
        asserts.assertRowCount(counRowsInSource, counRowsInSA);
    }

    @Test(enabled = true)
    public void BogfTransRTestVsMSCRUS() throws SQLException, IOException {
        getPropertiesFile();
        int counRowsInSource = dh.getCountRowsInRTest("bogftrans.SOURCE.CountRow");
        int counRowsInSA = dh.getCountRowsInSA("bogftrans.MSCRUS.CountRows");
        asserts.assertRowCount(counRowsInSource, counRowsInSA);
    }

    @Test(enabled = true)
    public void BogfTransITestVsUNITY() throws SQLException, IOException {
        getPropertiesFile();
        int counRowsInSource = dh.getCountRowsInITest("bogftrans.SOURCE.CountRow");
        int counRowsInSA = dh.getCountRowsInSA("bogftrans.UNITY.CountRows");
        asserts.assertRowCount(counRowsInSource, counRowsInSA);
    }

    @Test (enabled = true)
    public void BookDetailsRTestVsMSCRUS() throws SQLException, IOException {
        getPropertiesFile();
        int counRowsInSource = dh.getCountRowsInRTest("bookdetails.SOURCE.CountRow");
        int counRowsInSA = dh.getCountRowsInSA("bookdetails.MSCRUS.CountRows");
        asserts.assertRowCount(counRowsInSource, counRowsInSA);
    }

    @Test (enabled = true)
    public void BookDetailsITestVsUNITY() throws SQLException, IOException {
        getPropertiesFile();
        int counRowsInSource = dh.getCountRowsInITest("bookdetails.SOURCE.CountRow");
        int counRowsInSA = dh.getCountRowsInSA("bookdetails.UNITY.CountRows");
        asserts.assertRowCount(counRowsInSource, counRowsInSA);
    }

    @Test (enabled = true)
    public void BookDetailsMofRTestVsMSCRUS() throws SQLException, IOException {
        getPropertiesFile();
        int counRowsInSource = dh.getCountRowsInRTest("bookdetailsmof.SOURCE.CountRow");
        int counRowsInSA = dh.getCountRowsInSA("bookdetailsmof.MSCRUS.CountRows");
        asserts.assertRowCount(counRowsInSource, counRowsInSA);
    }

    @Test (enabled = true)
    public void BookDetailsMofITestVsUNITY() throws SQLException, IOException {
        getPropertiesFile();
        int counRowsInSource = dh.getCountRowsInITest("bookdetailsmof.SOURCE.CountRow");
        int counRowsInSA = dh.getCountRowsInSA("bookdetailsmof.UNITY.CountRows");
        asserts.assertRowCount(counRowsInSource, counRowsInSA);
    }

    @Test(enabled = true)
    public void BookDryPortsRTestVsMSCRUS() throws SQLException, IOException {
        getPropertiesFile();
        int counRowsInSource = dh.getCountRowsInRTest("bookdryport.SOURCE.CountRow");
        int counRowsInSA = dh.getCountRowsInSA("bookdryport.MSCRUS.CountRows");
        asserts.assertRowCount(counRowsInSource, counRowsInSA);
    }

    @Test(enabled = true)
    public void BookDryPortsVsUNITY() throws SQLException, IOException {
        getPropertiesFile();
        int counRowsInSource = dh.getCountRowsInITest("bookdryport.SOURCE.CountRow");
        int counRowsInSA = dh.getCountRowsInSA("bookdryport.UNITY.CountRows");
        asserts.assertRowCount(counRowsInSource, counRowsInSA);
    }

    @Test(enabled = true)
    public void BookEventRTestVsMSCRUS() throws SQLException, IOException {
        getPropertiesFile();
        int counRowsInSource = dh.getCountRowsInRTest("bookevent.SOURCE.CountRow");
        int counRowsInSA = dh.getCountRowsInSA("bookevent.MSCRUS.CountRows");
        asserts.assertRowCount(counRowsInSource, counRowsInSA);
    }

    @Test(enabled = true)
    public void BookEventITestVsUNITY() throws SQLException, IOException {
        getPropertiesFile();
        int counRowsInSource = dh.getCountRowsInITest("bookevent.SOURCE.CountRow");
        int counRowsInSA = dh.getCountRowsInSA("bookevent.UNITY.CountRows");
        asserts.assertRowCount(counRowsInSource, counRowsInSA);
    }

    @Test (enabled = true)
    public void BookFakRTestVsMSCRUS() throws SQLException, IOException {
        getPropertiesFile();
        int counRowsInSource = dh.getCountRowsInRTest("bookfak.SOURCE.CountRow");
        int counRowsInSA = dh.getCountRowsInSA("bookfak.MSCRUS.CountRows");
        asserts.assertRowCount(counRowsInSource, counRowsInSA);
    }

    @Test (enabled = true)
    public void BookFakITestVsUNITY() throws SQLException, IOException {
        getPropertiesFile();
        int counRowsInSource = dh.getCountRowsInITest("bookfak.SOURCE.CountRow");
        int counRowsInSA = dh.getCountRowsInSA("bookfak.UNITY.CountRows");
        asserts.assertRowCount(counRowsInSource, counRowsInSA);
    }

    @Test (enabled = true)
    public void BookGodsRTestVsMSCRUS() throws SQLException, IOException {
        getPropertiesFile();
        int counRowsInSource = dh.getCountRowsInRTest("bookgods.SOURCE.CountRow");
        int counRowsInSA = dh.getCountRowsInSA("bookgods.MSCRUS.CountRows");
        asserts.assertRowCount(counRowsInSource, counRowsInSA);
    }

    @Test (enabled = true)
    public void BookGodsITestVsUNITY() throws SQLException, IOException {
        getPropertiesFile();
        int counRowsInSource = dh.getCountRowsInITest("bookgods.SOURCE.CountRow");
        int counRowsInSA = dh.getCountRowsInSA("bookgods.UNITY.CountRows");
        asserts.assertRowCount(counRowsInSource, counRowsInSA);
    }

    @Test (enabled = true)
    public void BookKorRTestVsMSCRUS() throws SQLException, IOException {
        getPropertiesFile();
        int counRowsInSource = dh.getCountRowsInRTest("bookkor.SOURCE.CountRow");
        int counRowsInSA = dh.getCountRowsInSA("bookkor.MSCRUS.CountRows");
        asserts.assertRowCount(counRowsInSource, counRowsInSA);
    }

    @Test (enabled = true)
    public void BookKorITestVsUNITY() throws SQLException, IOException {
        getPropertiesFile();
        int counRowsInSource = dh.getCountRowsInITest("bookkor.SOURCE.CountRow");
        int counRowsInSA = dh.getCountRowsInSA("bookkor.UNITY.CountRows");
        asserts.assertRowCount(counRowsInSource, counRowsInSA);
    }

    @Test (enabled = true)
    public void BookLinRTestVsMSCRUS() throws SQLException, IOException {
        getPropertiesFile();
        int counRowsInSource = dh.getCountRowsInRTest("booklin.SOURCE.CountRow");
        int counRowsInSA = dh.getCountRowsInSA("booklin.MSCRUS.CountRows");
        asserts.assertRowCount(counRowsInSource, counRowsInSA);
    }

    @Test (enabled = true)
    public void BookLinITestVsUNITY() throws SQLException, IOException {
        getPropertiesFile();
        int counRowsInSource = dh.getCountRowsInITest("booklin.SOURCE.CountRow");
        int counRowsInSA = dh.getCountRowsInSA("booklin.UNITY.CountRows");
        asserts.assertRowCount(counRowsInSource, counRowsInSA);
    }

    @Test (enabled = true)
    public void BookManifestsRTestVsMSCRUS() throws SQLException, IOException {
        getPropertiesFile();
        int counRowsInSource = dh.getCountRowsInRTest("bookmanifests.SOURCE.CountRow");
        int counRowsInSA = dh.getCountRowsInSA("bookmanifests.MSCRUS.CountRows");
        asserts.assertRowCount(counRowsInSource, counRowsInSA);
    }

    @Test (enabled = true)
    public void BookManifestsITestVsUNITY() throws SQLException, IOException {
        getPropertiesFile();
        int counRowsInSource = dh.getCountRowsInITest("bookmanifests.SOURCE.CountRow");
        int counRowsInSA = dh.getCountRowsInSA("bookmanifests.UNITY.CountRows");
        asserts.assertRowCount(counRowsInSource, counRowsInSA);
    }

    @Test (enabled = true)
    public void BookMftFileRTestVsMSCRUS() throws SQLException, IOException {
        getPropertiesFile();
        int counRowsInSource = dh.getCountRowsInRTest("bookmftfile.SOURCE.CountRow");
        int counRowsInSA = dh.getCountRowsInSA("bookmftfile.MSCRUS.CountRows");
        asserts.assertRowCount(counRowsInSource, counRowsInSA);
    }

    @Test (enabled = true)
    public void BookMftFileITestVsUNITY() throws SQLException, IOException {
        getPropertiesFile();
        int counRowsInSource = dh.getCountRowsInITest("bookmftfile.SOURCE.CountRow");
        int counRowsInSA = dh.getCountRowsInSA("bookmftfile.UNITY.CountRows");
        asserts.assertRowCount(counRowsInSource, counRowsInSA);
    }

    @Test (enabled = true)
    public void BookMftRemarksRTestVsMSCRUS() throws SQLException, IOException {
        getPropertiesFile();
        int counRowsInSource = dh.getCountRowsInRTest("bookmftremarks.SOURCE.CountRow");
        int counRowsInSA = dh.getCountRowsInSA("bookmftremarks.MSCRUS.CountRows");
        asserts.assertRowCount(counRowsInSource, counRowsInSA);
    }

    @Test (enabled = true)
    public void BookMftRemarksITestVsUNITY() throws SQLException, IOException {
        getPropertiesFile();
        int counRowsInSource = dh.getCountRowsInITest("bookmftremarks.SOURCE.CountRow");
        int counRowsInSA = dh.getCountRowsInSA("bookmftremarks.UNITY.CountRows");
        asserts.assertRowCount(counRowsInSource, counRowsInSA);
    }

    @Test (enabled = true)
    public void BookRTestVsMSCRUS() throws SQLException, IOException {
        getPropertiesFile();
        int counRowsInSource = dh.getCountRowsInRTest("book.SOURCE.CountRow");
        int counRowsInSA = dh.getCountRowsInSA("book.MSCRUS.CountRows");
        asserts.assertRowCount(counRowsInSource, counRowsInSA);
    }

    @Test (enabled = true)
    public void BookITestVsUNITY() throws SQLException, IOException {
        getPropertiesFile();
        int counRowsInSource = dh.getCountRowsInITest("book.SOURCE.CountRow");
        int counRowsInSA = dh.getCountRowsInSA("book.UNITY.CountRows");
        asserts.assertRowCount(counRowsInSource, counRowsInSA);
    }

    @Test (enabled = true)
    public void BookVesselRTestVsMSCRUS() throws SQLException, IOException {
        getPropertiesFile();
        int counRowsInSource = dh.getCountRowsInRTest("bookvessel.SOURCE.CountRow");
        int counRowsInSA = dh.getCountRowsInSA("bookvessel.MSCRUS.CountRows");
        asserts.assertRowCount(counRowsInSource, counRowsInSA);
    }

    @Test (enabled = true)
    public void BookVesselITestVsUNITY() throws SQLException, IOException {
        getPropertiesFile();
        int counRowsInSource = dh.getCountRowsInITest("bookvessel.SOURCE.CountRow");
        int counRowsInSA = dh.getCountRowsInSA("bookvessel.UNITY.CountRows");
        asserts.assertRowCount(counRowsInSource, counRowsInSA);
    }

    @Test(enabled = true)
    public void ContHollidayRTestVsMSCRUS() throws SQLException, IOException {
        getPropertiesFile();
        int counRowsInSource = dh.getCountRowsInRTest("contholliday.SOURCE.CountRow");
        int counRowsInSA = dh.getCountRowsInSA("contholliday.MSCRUS.CountRows");
        asserts.assertRowCount(counRowsInSource, counRowsInSA);
    }

    @Test (enabled = true)
    public void ContHollidayITestVsUNITY() throws SQLException, IOException {
        getPropertiesFile();
        int counRowsInSource = dh.getCountRowsInITest("contholliday.SOURCE.CountRow");
        int counRowsInSA = dh.getCountRowsInSA("contholliday.UNITY.CountRows");
        asserts.assertRowCount(counRowsInSource, counRowsInSA);
    }

    @Test (enabled = true)
    public void ContRepRTestVsMSCRUS() throws SQLException, IOException {
        getPropertiesFile();
        int counRowsInSource = dh.getCountRowsInRTest("contrep.SOURCE.CountRow");
        int counRowsInSA = dh.getCountRowsInSA("contrep.MSCRUS.CountRows");
        asserts.assertRowCount(counRowsInSource, counRowsInSA);
    }

    @Test (enabled = true)
    public void ContRepITestVsUNITY() throws SQLException, IOException {
        getPropertiesFile();
        int counRowsInSource = dh.getCountRowsInITest("contrep.SOURCE.CountRow");
        int counRowsInSA = dh.getCountRowsInSA("contrep.UNITY.CountRows");
        asserts.assertRowCount(counRowsInSource, counRowsInSA);
    }

    @Test (enabled = true)
    public void ControlOfficeRTestVsMSCRUS() throws SQLException, IOException {
        getPropertiesFile();
        int counRowsInSource = dh.getCountRowsInRTest("controloffice.SOURCE.CountRow");
        int counRowsInSA = dh.getCountRowsInSA("controloffice.MSCRUS.CountRows");
        asserts.assertRowCount(counRowsInSource, counRowsInSA);
    }

    @Test (enabled = true)
    public void ControlOfficeITestVsUNITY() throws SQLException, IOException {
        getPropertiesFile();
        int counRowsInSource = dh.getCountRowsInITest("controloffice.SOURCE.CountRow");
        int counRowsInSA = dh.getCountRowsInSA("controloffice.UNITY.CountRows");
        asserts.assertRowCount(counRowsInSource, counRowsInSA);
    }

    @Test (enabled = true)
    public void ContTypeRTestVsMSCRUS() throws SQLException, IOException {
        getPropertiesFile();
        int counRowsInSource = dh.getCountRowsInRTest("conttype.SOURCE.CountRow");
        int counRowsInSA = dh.getCountRowsInSA("conttype.MSCRUS.CountRows");
        asserts.assertRowCount(counRowsInSource, counRowsInSA);
    }

    @Test (enabled = true)
    public void ContTypeITestVsUNITY() throws SQLException, IOException {
        getPropertiesFile();
        int counRowsInSource = dh.getCountRowsInITest("conttype.SOURCE.CountRow");
        int counRowsInSA = dh.getCountRowsInSA("conttype.UNITY.CountRows");
        asserts.assertRowCount(counRowsInSource, counRowsInSA);
    }

    @Test (enabled = true)
    public void EdiKonvRTestVsMSCRUS() throws SQLException, IOException {
        getPropertiesFile();
        int counRowsInSource = dh.getCountRowsInRTest("edikonv.SOURCE.CountRow");
        int counRowsInSA = dh.getCountRowsInSA("edikonv.MSCRUS.CountRows");
        asserts.assertRowCount(counRowsInSource, counRowsInSA);
    }

    @Test (enabled = true)
    public void EdiKonvITestVsUNITY() throws SQLException, IOException {
        getPropertiesFile();
        int counRowsInSource = dh.getCountRowsInITest("edikonv.SOURCE.CountRow");
        int counRowsInSA = dh.getCountRowsInSA("edikonv.UNITY.CountRows");
        asserts.assertRowCount(counRowsInSource, counRowsInSA);
    }

    @Test (enabled = true)
    public void ExpVesselRTestVsMSCRUS() throws SQLException, IOException {
        getPropertiesFile();
        int counRowsInSource = dh.getCountRowsInRTest("expvessel.SOURCE.CountRow");
        int counRowsInSA = dh.getCountRowsInSA("expvessel.MSCRUS.CountRows");
        asserts.assertRowCount(counRowsInSource, counRowsInSA);
    }

    @Test (enabled = true)
    public void ExpVesselITestVsUNITY() throws SQLException, IOException {
        getPropertiesFile();
        int counRowsInSource = dh.getCountRowsInITest("expvessel.SOURCE.CountRow");
        int counRowsInSA = dh.getCountRowsInSA("expvessel.UNITY.CountRows");
        asserts.assertRowCount(counRowsInSource, counRowsInSA);
    }

    @Test (enabled = true)
    public void FaktPostRTestVsMSCRUS() throws SQLException, IOException {
        getPropertiesFile();
        int counRowsInSource = dh.getCountRowsInRTest("faktpost.SOURCE.CountRow");
        int counRowsInSA = dh.getCountRowsInSA("faktpost.MSCRUS.CountRows");
        asserts.assertRowCount(counRowsInSource, counRowsInSA);
    }

    @Test (enabled = true)
    public void FaktPostlITestVsUNITY() throws SQLException, IOException {
        getPropertiesFile();
        int counRowsInSource = dh.getCountRowsInITest("faktpost.SOURCE.CountRow");
        int counRowsInSA = dh.getCountRowsInSA("faktpost.UNITY.CountRows");
        asserts.assertRowCount(counRowsInSource, counRowsInSA);
    }

    @Test (enabled = false)
    public void getChargesRTestVsMSCRUS() throws SQLException, IOException {
        getPropertiesFile();
        int counRowsInSource = dh.getCountRowsInRTest("getCharges.SOURCE.CountRow");
        int counRowsInSA = dh.getCountRowsInSA("getCharges.MSCRUS.CountRows");
        asserts.assertRowCount(counRowsInSource, counRowsInSA);
    }

    @Test (enabled = false)
    public void getChargesITestVsUNITY() throws SQLException, IOException {
        getPropertiesFile();
        int counRowsInSource = dh.getCountRowsInITest("getCharges.SOURCE.CountRow");
        int counRowsInSA = dh.getCountRowsInSA("getCharges.UNITY.CountRows");
        asserts.assertRowCount(counRowsInSource, counRowsInSA);
    }


    @Test (enabled = true)
    public void HenvisRTestVsMSCRUS() throws SQLException, IOException {
        getPropertiesFile();
        int counRowsInSource = dh.getCountRowsInRTest("henvis.SOURCE.CountRow");
        int counRowsInSA = dh.getCountRowsInSA("henvis.MSCRUS.CountRows");
        asserts.assertRowCount(counRowsInSource, counRowsInSA);
    }

    @Test (enabled = true)
    public void HenvisITestVsUNITY() throws SQLException, IOException {
        getPropertiesFile();
        int counRowsInSource = dh.getCountRowsInITest("henvis.SOURCE.CountRow");
        int counRowsInSA = dh.getCountRowsInSA("henvis.UNITY.CountRows");
        asserts.assertRowCount(counRowsInSource, counRowsInSA);
    }

    @Test (enabled = true)
    public void KundeRTestVsMSCRUS() throws SQLException, IOException {
        getPropertiesFile();
        int counRowsInSource = dh.getCountRowsInRTest("kunde.SOURCE.CountRow");
        int counRowsInSA = dh.getCountRowsInSA("kunde.MSCRUS.CountRows");
        asserts.assertRowCount(counRowsInSource, counRowsInSA);
    }

    @Test (enabled = true)
    public void KundeITestVsUNITY() throws SQLException, IOException {
        getPropertiesFile();
        int counRowsInSource = dh.getCountRowsInITest("kunde.SOURCE.CountRow");
        int counRowsInSA = dh.getCountRowsInSA("kunde.UNITY.CountRows");
        asserts.assertRowCount(counRowsInSource, counRowsInSA);
    }

    @Test (enabled = true)
    public void OrdreLinRTestVsMSCRUS() throws SQLException, IOException {
        getPropertiesFile();
        int counRowsInSource = dh.getCountRowsInRTest("ordrelin.SOURCE.CountRow");
        int counRowsInSA = dh.getCountRowsInSA("ordrelin.MSCRUS.CountRows");
        asserts.assertRowCount(counRowsInSource, counRowsInSA);
    }

    @Test (enabled = true)
    public void OrdreLinITestVsUNITY() throws SQLException, IOException {
        getPropertiesFile();
        int counRowsInSource = dh.getCountRowsInITest("ordrelin.SOURCE.CountRow");
        int counRowsInSA = dh.getCountRowsInSA("ordrelin.UNITY.CountRows");
        asserts.assertRowCount(counRowsInSource, counRowsInSA);
    }

    @Test (enabled = true)
    public void OrdreRTestVsMSCRUS() throws SQLException, IOException {
        getPropertiesFile();
        int counRowsInSource = dh.getCountRowsInRTest("ordre.SOURCE.CountRow");
        int counRowsInSA = dh.getCountRowsInSA("ordre.MSCRUS.CountRows");
        asserts.assertRowCount(counRowsInSource, counRowsInSA);
    }

    @Test (enabled = true)
    public void OrdreITestVsUNITY() throws SQLException, IOException {
        getPropertiesFile();
        int counRowsInSource = dh.getCountRowsInITest("ordre.SOURCE.CountRow");
        int counRowsInSA = dh.getCountRowsInSA("ordre.UNITY.CountRows");
        asserts.assertRowCount(counRowsInSource, counRowsInSA);
    }

    @Test (enabled = true)
    public void SagKursRTestVsMSCRUS() throws SQLException, IOException {
        getPropertiesFile();
        int counRowsInSource = dh.getCountRowsInRTest("sagkurs.SOURCE.CountRow");
        int counRowsInSA = dh.getCountRowsInSA("sagkurs.MSCRUS.CountRows");
        asserts.assertRowCount(counRowsInSource, counRowsInSA);
    }

    @Test (enabled = true)
    public void SagKursITestVsUNITY() throws SQLException, IOException {
        getPropertiesFile();
        int counRowsInSource = dh.getCountRowsInITest("sagkurs.SOURCE.CountRow");
        int counRowsInSA = dh.getCountRowsInSA("sagkurs.UNITY.CountRows");
        asserts.assertRowCount(counRowsInSource, counRowsInSA);
    }

    @Test (enabled = true)
    public void SagRTestVsMSCRUS() throws SQLException, IOException {
        getPropertiesFile();
        int counRowsInSource = dh.getCountRowsInRTest("sag.SOURCE.CountRow");
        int counRowsInSA = dh.getCountRowsInSA("sag.MSCRUS.CountRows");
        asserts.assertRowCount(counRowsInSource, counRowsInSA);
    }

    @Test (enabled = true)
    public void SagITestVsUNITY() throws SQLException, IOException {
        getPropertiesFile();
        int counRowsInSource = dh.getCountRowsInITest("sag.SOURCE.CountRow");
        int counRowsInSA = dh.getCountRowsInSA("sag.UNITY.CountRows");
        asserts.assertRowCount(counRowsInSource, counRowsInSA);
    }

    @Test (enabled = true)
    public void SelskabRTestVsMSCRUS() throws SQLException, IOException {
        getPropertiesFile();
        int counRowsInSource = dh.getCountRowsInRTest("selskab.SOURCE.CountRow");
        int counRowsInSA = dh.getCountRowsInSA("selskab.MSCRUS.CountRows");
        asserts.assertRowCount(counRowsInSource, counRowsInSA);
    }

    @Test (enabled = true)
    public void SelsksbITestVsUNITY() throws SQLException, IOException {
        getPropertiesFile();
        int counRowsInSource = dh.getCountRowsInITest("selskab.SOURCE.CountRow");
        int counRowsInSA = dh.getCountRowsInSA("selskab.UNITY.CountRows");
        asserts.assertRowCount(counRowsInSource, counRowsInSA);
    }

    @Test (enabled = true)
    public void ShipKursRTestVsMSCRUS() throws SQLException, IOException {
        getPropertiesFile();
        int counRowsInSource = dh.getCountRowsInRTest("shipkurs.SOURCE.CountRow");
        int counRowsInSA = dh.getCountRowsInSA("shipkurs.MSCRUS.CountRows");
        asserts.assertRowCount(counRowsInSource, counRowsInSA);
    }

    @Test (enabled = true)
    public void ShipKursITestVsUNITY() throws SQLException, IOException {
        getPropertiesFile();
        int counRowsInSource = dh.getCountRowsInITest("shipkurs.SOURCE.CountRow");
        int counRowsInSA = dh.getCountRowsInSA("shipkurs.UNITY.CountRows");
        asserts.assertRowCount(counRowsInSource, counRowsInSA);
    }

    @Test (enabled = true)
    public void UtsConstantsRTestVsMSCRUS() throws SQLException, IOException {
        getPropertiesFile();
        int counRowsInSource = dh.getCountRowsInRTest("utsconstants.SOURCE.CountRow");
        int counRowsInSA = dh.getCountRowsInSA("utsconstants.MSCRUS.CountRows");
        asserts.assertRowCount(counRowsInSource, counRowsInSA);
    }

    @Test (enabled = true)
    public void UtsConstantsITestVsUNITY() throws SQLException, IOException {
        getPropertiesFile();
        int counRowsInSource = dh.getCountRowsInITest("utsconstants.SOURCE.CountRow");
        int counRowsInSA = dh.getCountRowsInSA("utsconstants.UNITY.CountRows");
        asserts.assertRowCount(counRowsInSource, counRowsInSA);
    }


    @Test (enabled = true)
    public void ValidAgencyRTestVsMSCRUS() throws SQLException, IOException {
        getPropertiesFile();
        int counRowsInSource = dh.getCountRowsInRTest("validAgency.SOURCE.CountRow");
        int counRowsInSA = dh.getCountRowsInSA("validAgency.MSCRUS.CountRows");
        asserts.assertRowCount(counRowsInSource, counRowsInSA);
    }

    @Test (enabled = true)
    public void ValidAgencyITestVsUNITY() throws SQLException, IOException {
        getPropertiesFile();
        int counRowsInSource = dh.getCountRowsInITest("validAgency.SOURCE.CountRow");
        int counRowsInSA = dh.getCountRowsInSA("validAgency.UNITY.CountRows");
        asserts.assertRowCount(counRowsInSource, counRowsInSA);
    }

    private void getPropertiesFile() throws IOException {
        properties.load(new FileReader(new File(String.format("src/test/resources/sql.properties"))));
    }
}
