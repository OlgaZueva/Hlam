package Tieto.tests;


import Tieto.helpers.Asserts;
import Tieto.models.Adresse;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Title;

import java.sql.*;

public class AdresseTestsBak {
    Asserts asserts = new Asserts();

    @Description("Сравнение данных записей таблиц ADRESSE ")
    @Title("Сравнение данных записей таблиц ADRESSE в RTest и MSCRUS")
    @Test
    public void RTestVsMSCRUS() throws ClassNotFoundException {
        Connection connToRTest = null;
        Connection connToSA = null;
        try {

            connToRTest = DriverManager.getConnection("jdbc:oracle:thin:dwh_etl/T4M2iJfRGw@10.45.1.223:1566:RTEST");
            connToSA = DriverManager.getConnection("jdbc:sqlserver://10.45.1.122;databaseName=BIFROST;user=sa;password=JGdedf&#fsqwhdc");

            Statement stFromRTest = connToRTest.createStatement();
            Statement stFromSA = connToSA.createStatement();

            int pull = 1000000;
            String sql = ("select rownum rn,  t.* from adresse_etl_v t where  ROWNUM < " + pull);
            ResultSet rsRowsFromRTest = stFromRTest.executeQuery(sql);

            Adresse adresseRTest = null;
            Adresse adresseSaMSCRUS = null;

            int array[];


            while (rsRowsFromRTest.next()) {

                array = new int[]{(pull - (pull - 1)), (pull - (pull - 2)), (pull / 2 - 1), (pull / 2), (pull - 2), (pull - 1)};

                for (int i = 0; i < array.length; i++) {
                    String sql1 = "select * from (select rownum rn,  t.* from adresse_etl_v t where  ROWNUM < "
                            + pull + ") where rn = " + array[i];
                    ResultSet rsFromRTest = stFromRTest.executeQuery(sql1);

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

                    String sql2 = "select NR, REF_NR, REF_TYPE, SELSKAB, ADRESSE1, ADRESSE2, ADRESSE3, AMS_FLAG, BYNAVN," +
                            " CITY_CODE, CUSTOMER_NUMBER, DEB_LAND, EMAILADR, ENF_FLAG, GLOBAL_AC, INTTRA_CODE, NAVN," +
                            " POSTNR, SCAC_CODE, TELEFAX, TELEFON, VIRKNR1, VIRKNR2" +
                            " from stg.MSCRUS_adresse where SELSKAB = " + adresseRTest.getSELSKAB() + " and REF_TYPE = '" + adresseRTest.getREF_TYPE() + "' and REF_NR ="
                            + adresseRTest.getREF_NR() + " and NR=" + adresseRTest.getNR();
                    ResultSet rsFromSaMSCRUS = stFromSA.executeQuery(sql2);


                    while (rsFromSaMSCRUS.next()) {

                        adresseSaMSCRUS = new Adresse().setNR(rsFromSaMSCRUS.getInt("NR")).setREF_NR(rsFromSaMSCRUS.getInt("REF_NR"))
                                .setREF_TYPE(rsFromSaMSCRUS.getString("REF_TYPE")).setSELSKAB(rsFromSaMSCRUS.getInt("SELSKAB"))
                                .setADRESSE1(rsFromSaMSCRUS.getString("ADRESSE1")).setADRESSE2(rsFromSaMSCRUS.getString("ADRESSE2"))
                                .setADRESSE3(rsFromSaMSCRUS.getString("ADRESSE3")).setAMS_FLAG(rsFromSaMSCRUS.getString("AMS_FLAG"))
                                .setBYNAVN(rsFromSaMSCRUS.getString("BYNAVN")).setCITY_CODE(rsFromSaMSCRUS.getString("CITY_CODE"))
                                .setCUSTOMER_NUMBER(rsFromSaMSCRUS.getString("CUSTOMER_NUMBER")).setDEB_LAND(rsFromSaMSCRUS.getString("DEB_LAND"))
                                .setEMAILADR(rsFromSaMSCRUS.getString("EMAILADR")).setENF_FLAG(rsFromSaMSCRUS.getString("ENF_FLAG"))
                                .setGLOBAL_AC(rsFromSaMSCRUS.getString("GLOBAL_AC")).setINTTRA_CODE(rsFromSaMSCRUS.getString("INTTRA_CODE"))
                                .setNAVN(rsFromSaMSCRUS.getString("NAVN")).setPOSTNR(rsFromSaMSCRUS.getString("POSTNR"))
                                .setSCAC_CODE(rsFromSaMSCRUS.getString("SCAC_CODE")).setTELEFAX(rsFromSaMSCRUS.getString("TELEFAX"))
                                .setTELEFON(rsFromSaMSCRUS.getString("TELEFON")).setVIRKNR1(rsFromSaMSCRUS.getString("VIRKNR1"))
                                .setVIRKNR2(rsFromSaMSCRUS.getString("VIRKNR2"));
                    }
                    rsFromSaMSCRUS.close();

                    asserts.assertRowsAdresse(adresseSaMSCRUS, adresseRTest);

                }

            }

            rsRowsFromRTest.close();
            stFromRTest.close();
            stFromSA.close();
            connToRTest.close();
            connToSA.close();

        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
    }
}
