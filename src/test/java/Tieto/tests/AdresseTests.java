package Tieto.tests;

import Tieto.helpers.Asserts;
import Tieto.helpers.DBHelper;
import Tieto.models.Adresse;
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
import java.util.Properties;

public class AdresseTests {
    private Asserts asserts = new Asserts();
    private DBHelper db = new DBHelper();
    private Properties properties = new Properties();
    private Adresse adresseRTest = null;
    private Adresse adresseSaMSCRUS = null;
    private Adresse adresseITest = null;
    private Adresse adresseSaUNITY = null;

    @Description("Сравнение данных записей таблиц ADRESSE ")
    @Title("Сравнение данных записей таблиц ADRESSE в RTest и MSCRUS")
    @Test
    public void RTestVsMSCRUS() throws SQLException, IOException {
        properties.load(new FileReader(new File(String.format("src/test/resources/sql.properties"))));

        Connection connectionToRTest = db.connToRTest();
        Statement statmentForRTest = db.stFromConnection(connectionToRTest);
        ResultSet rsCountRowFromRTest = db.rsFromDB(statmentForRTest, properties.getProperty("adresse.SOURCE.CountRow")
                + properties.getProperty("system.RownumPool"));

        while (rsCountRowFromRTest.next()) {
            int pool = Integer.parseInt(properties.getProperty("system.RownumPool"));
            int[] array = new int[]{(pool - (pool - 1)), (pool - (pool - 2)), (pool / 2 - 1), (pool / 2), (pool - 2), (pool - 1)};

            for (int i = 0; i < array.length; i++) {
                ResultSet rsFromRTest = db.rsFromDB(statmentForRTest, properties.getProperty("adresse.SOURCE.RowByRownum")
                        + pool + ") where rn = " + array[i]);
                while (rsFromRTest.next()) {
                    adresseRTest = new Adresse().setNR(rsFromRTest.getInt("NR")).setREF_NR(rsFromRTest.getInt("REF_NR"))
                            .setREF_TYPE(rsFromRTest.getString("REF_TYPE")).setSELSKAB(rsFromRTest.getInt("SELSKAB"))
                            .setADRESSE1(rsFromRTest.getString("ADRESSE1")).setADRESSE2(rsFromRTest.getString("ADRESSE2"))
                            .setADRESSE3(rsFromRTest.getString("ADRESSE3")).setAMS_FLAG(rsFromRTest.getString("AMS_FLAG"))
                            .setBYNAVN(rsFromRTest.getString("BYNAVN")).setCITY_CODE(rsFromRTest.getString("CITY_CODE"))
                            .setCUSTOMER_NUMBER(rsFromRTest.getString("CUSTOMER_NUMBER")).setDEB_LAND(rsFromRTest.getString("DEB_LAND"))
                            .setEMAILADR(rsFromRTest.getString("EMAILADR")).setENF_FLAG(rsFromRTest.getString("ENF_FLAG"))
                            .setGLOBAL_AC(rsFromRTest.getString("GLOBAL_AC")).setINTTRA_CODE(rsFromRTest.getString("INTTRA_CODE"))
                            .setNAVN(rsFromRTest.getString("NAVN")).setPOSTNR(rsFromRTest.getString("POSTNR"))
                            .setSCAC_CODE(rsFromRTest.getString("SCAC_CODE")).setTELEFAX(rsFromRTest.getString("TELEFAX"))
                            .setTELEFON(rsFromRTest.getString("TELEFON")).setVIRKNR1(rsFromRTest.getString("VIRKNR1"))
                            .setVIRKNR2(rsFromRTest.getString("VIRKNR2"));
                }
                rsFromRTest.close();
                Connection connectionToSA = db.connToSA();
                Statement statmentForSA = db.stFromConnection(connectionToSA);
                ResultSet rsFromSA = db.rsFromDB(statmentForSA, properties.getProperty("adresse.MSCRUS.RowByPKFromRTest")
                        + adresseRTest.getSELSKAB() + " and REF_TYPE = '" + adresseRTest.getREF_TYPE() + "' and REF_NR ="
                        + adresseRTest.getREF_NR() + " and NR=" + adresseRTest.getNR());

                while (rsFromSA.next()) {
                    adresseSaMSCRUS = new Adresse().setNR(rsFromSA.getInt("NR")).setREF_NR(rsFromSA.getInt("REF_NR"))
                            .setREF_TYPE(rsFromSA.getString("REF_TYPE")).setSELSKAB(rsFromSA.getInt("SELSKAB"))
                            .setADRESSE1(rsFromSA.getString("ADRESSE1")).setADRESSE2(rsFromSA.getString("ADRESSE2"))
                            .setADRESSE3(rsFromSA.getString("ADRESSE3")).setAMS_FLAG(rsFromSA.getString("AMS_FLAG"))
                            .setBYNAVN(rsFromSA.getString("BYNAVN")).setCITY_CODE(rsFromSA.getString("CITY_CODE"))
                            .setCUSTOMER_NUMBER(rsFromSA.getString("CUSTOMER_NUMBER")).setDEB_LAND(rsFromSA.getString("DEB_LAND"))
                            .setEMAILADR(rsFromSA.getString("EMAILADR")).setENF_FLAG(rsFromSA.getString("ENF_FLAG"))
                            .setGLOBAL_AC(rsFromSA.getString("GLOBAL_AC")).setINTTRA_CODE(rsFromSA.getString("INTTRA_CODE"))
                            .setNAVN(rsFromSA.getString("NAVN")).setPOSTNR(rsFromSA.getString("POSTNR"))
                            .setSCAC_CODE(rsFromSA.getString("SCAC_CODE")).setTELEFAX(rsFromSA.getString("TELEFAX"))
                            .setTELEFON(rsFromSA.getString("TELEFON")).setVIRKNR1(rsFromSA.getString("VIRKNR1"))
                            .setVIRKNR2(rsFromSA.getString("VIRKNR2"));
                }
                rsFromSA.close();
                statmentForSA.close();
                connectionToSA.close();

                asserts.assertRowsAdresse(adresseSaMSCRUS, adresseRTest);

            }

        }
        rsCountRowFromRTest.close();
        statmentForRTest.close();
        connectionToRTest.close();
    }

    @Description("Сравнение данных записей таблиц ADGAND ")
    @Title("Сравнение данных записей таблиц ADGAND в ITest и UNITY")
    @Test
    public void ITestVsUNITY() throws SQLException, IOException {
        properties.load(new FileReader(new File(String.format("src/test/resources/sql.properties"))));
        int pool = Integer.parseInt(properties.getProperty("system.RownumPool"));
        Connection connectionToUNITY = db.connToITest();
        Statement statmentForUNITY = db.stFromConnection(connectionToUNITY);
        ResultSet rsCountFromUNITY = db.rsFromDB(statmentForUNITY, properties.getProperty("adresse.SOURCE.CountRow") + pool);

        while (rsCountFromUNITY.next()) {

            int[] array = new int[]{(pool - (pool - 1)), (pool - (pool - 2)), (pool / 2 - 1), (pool / 2), (pool - 1), pool};

            for (int i = 0; i < array.length; i++) {

                ResultSet rsFromITest = db.rsFromDB(statmentForUNITY, properties.getProperty("adresse.SOURCE.RowByRownum")
                        + pool + ") where rn = "  + array[i]);
                while (rsFromITest.next()) {
                    adresseITest = new Adresse().setNR(rsFromITest.getInt("NR")).setREF_NR(rsFromITest.getInt("REF_NR"))
                            .setREF_TYPE(rsFromITest.getString("REF_TYPE")).setSELSKAB(rsFromITest.getInt("SELSKAB"))
                            .setADRESSE1(rsFromITest.getString("ADRESSE1")).setADRESSE2(rsFromITest.getString("ADRESSE2"))
                            .setADRESSE3(rsFromITest.getString("ADRESSE3")).setAMS_FLAG(rsFromITest.getString("AMS_FLAG"))
                            .setBYNAVN(rsFromITest.getString("BYNAVN")).setCITY_CODE(rsFromITest.getString("CITY_CODE"))
                            .setCUSTOMER_NUMBER(rsFromITest.getString("CUSTOMER_NUMBER")).setDEB_LAND(rsFromITest.getString("DEB_LAND"))
                            .setEMAILADR(rsFromITest.getString("EMAILADR")).setENF_FLAG(rsFromITest.getString("ENF_FLAG"))
                            .setGLOBAL_AC(rsFromITest.getString("GLOBAL_AC")).setINTTRA_CODE(rsFromITest.getString("INTTRA_CODE"))
                            .setNAVN(rsFromITest.getString("NAVN")).setPOSTNR(rsFromITest.getString("POSTNR"))
                            .setSCAC_CODE(rsFromITest.getString("SCAC_CODE")).setTELEFAX(rsFromITest.getString("TELEFAX"))
                            .setTELEFON(rsFromITest.getString("TELEFON")).setVIRKNR1(rsFromITest.getString("VIRKNR1"))
                            .setVIRKNR2(rsFromITest.getString("VIRKNR2"));
                }
                rsFromITest.close();
                Connection connectionToSA = db.connToSA();
                Statement statmentForSA = db.stFromConnection(connectionToSA);
                String sqlFromUNITY = properties.getProperty("adresse.UNITY.RowByPKFromITest")
                        + adresseITest.getSELSKAB() + " and REF_TYPE = '" + adresseITest.getREF_TYPE() + "' and REF_NR ="
                        + adresseITest.getREF_NR() + " and NR=" + adresseITest.getNR();
                ResultSet rsFromSA = db.rsFromDB(statmentForSA, sqlFromUNITY);

                while (rsFromSA.next()) {
                    adresseSaUNITY = new Adresse().setNR(rsFromSA.getInt("NR")).setREF_NR(rsFromSA.getInt("REF_NR"))
                            .setREF_TYPE(rsFromSA.getString("REF_TYPE")).setSELSKAB(rsFromSA.getInt("SELSKAB"))
                            .setADRESSE1(rsFromSA.getString("ADRESSE1")).setADRESSE2(rsFromSA.getString("ADRESSE2"))
                            .setADRESSE3(rsFromSA.getString("ADRESSE3")).setAMS_FLAG(rsFromSA.getString("AMS_FLAG"))
                            .setBYNAVN(rsFromSA.getString("BYNAVN")).setCITY_CODE(rsFromSA.getString("CITY_CODE"))
                            .setCUSTOMER_NUMBER(rsFromSA.getString("CUSTOMER_NUMBER")).setDEB_LAND(rsFromSA.getString("DEB_LAND"))
                            .setEMAILADR(rsFromSA.getString("EMAILADR")).setENF_FLAG(rsFromSA.getString("ENF_FLAG"))
                            .setGLOBAL_AC(rsFromSA.getString("GLOBAL_AC")).setINTTRA_CODE(rsFromSA.getString("INTTRA_CODE"))
                            .setNAVN(rsFromSA.getString("NAVN")).setPOSTNR(rsFromSA.getString("POSTNR"))
                            .setSCAC_CODE(rsFromSA.getString("SCAC_CODE")).setTELEFAX(rsFromSA.getString("TELEFAX"))
                            .setTELEFON(rsFromSA.getString("TELEFON")).setVIRKNR1(rsFromSA.getString("VIRKNR1"))
                            .setVIRKNR2(rsFromSA.getString("VIRKNR2"));
                }
                rsFromSA.close();
                statmentForSA.close();
                connectionToSA.close();

                asserts.assertRowsAdresse(adresseSaUNITY, adresseITest);

            }

        }
        rsCountFromUNITY.close();
        statmentForUNITY.close();
        connectionToUNITY.close();
    }
}

