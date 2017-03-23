package Tieto.tests;

import Tieto.models.Adgang;
import Tieto.helpers.Asserts;

import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Title;

import java.sql.*;

public class AdgangTestsFirstEditon {
 Asserts asserts =  new Asserts();
    @Description("Сравнение данных записей таблиц ADGAND ")
    @Title("Сравнение данных записей таблиц ADGAND в RTest и MSCRUS")
    @Test
    public void RTestVsMSCRUS() throws SQLException {
        Connection connToRTest = null;
        Connection connToSA = null;
       // try {

            connToRTest = DriverManager.getConnection("jdbc:oracle:thin:dwh_etl/T4M2iJfRGw@10.45.1.223:1566:RTEST");
            connToSA = DriverManager.getConnection("jdbc:sqlserver://10.45.1.122;databaseName=BIFROST;user=sa;password=JGdedf&#fsqwhdc");

            Statement stFromRTest = connToRTest.createStatement();
            Statement stFromSA = connToSA.createStatement();


            ResultSet rsCountFromRTest = stFromRTest.executeQuery("select count(*) c from adgang_etl_v");

            Adgang adgangRTest = null;
            Adgang adgangSaMSCRUS = null;
            int array[];


            while (rsCountFromRTest.next()) {
                int count = rsCountFromRTest.getInt("c");
                array = new int[]{(count - (count - 1)), (count - (count - 2)), (count / 2 - 1), (count / 2), (count - 1), count};

                for (int i = 0; i < array.length; i++) {
                    String sql = "select * from (select rownum rn, t.* from adgang_etl_v t order by t.vor_ref) where rn = " + array[i];
                    ResultSet rsFromRTest = stFromRTest.executeQuery(sql);
                    while (rsFromRTest.next()) {
                        adgangRTest = new Adgang().setVOR_REF(rsFromRTest.getString("VOR_REF")).setUTS_LEVEL(rsFromRTest.getInt("UTS_LEVEL"))
                                .setUTS_ADMIN(rsFromRTest.getString("UTS_ADMIN")).setSTART_SEL(rsFromRTest.getByte("START_SEL"))
                                .setUTS_GROUP(rsFromRTest.getString("UTS_GROUP")).setFGAC(rsFromRTest.getString("FGAC"))
                                .setACCOUNTANT(rsFromRTest.getString("ACCOUNTANT")).setAD_LOGIN(rsFromRTest.getString("AD_LOGIN"))
                                .setAD_USER_ONLY(rsFromRTest.getString("AD_USER_ONLY"));

                    }
                    rsFromRTest.close();
                    String sql1 = "select VOR_REF, UTS_LEVEL, UTS_ADMIN, START_SEL, UTS_GROUP, FGAC, ACCOUNTANT, AD_LOGIN, AD_USER_ONLY from stg.MSCRUS_Adgang where VOR_REF = '" + adgangRTest.getVOR_REF() + "'";
                    ResultSet rsFromSaMSCRUS = stFromSA.executeQuery(sql1);

                    while (rsFromSaMSCRUS.next()) {
                        adgangSaMSCRUS = new Adgang().setVOR_REF(rsFromSaMSCRUS.getString("VOR_REF")).setUTS_LEVEL(rsFromSaMSCRUS.getInt("UTS_LEVEL"))
                                .setUTS_ADMIN(rsFromSaMSCRUS.getString("UTS_ADMIN")).setSTART_SEL(rsFromSaMSCRUS.getInt("START_SEL"))
                                .setUTS_GROUP(rsFromSaMSCRUS.getString("UTS_GROUP")).setFGAC(rsFromSaMSCRUS.getString("FGAC"))
                                .setACCOUNTANT(rsFromSaMSCRUS.getString("ACCOUNTANT")).setAD_LOGIN(rsFromSaMSCRUS.getString("AD_LOGIN"))
                                .setAD_USER_ONLY(rsFromSaMSCRUS.getString("AD_USER_ONLY"));
                    }
                    rsFromSaMSCRUS.close();

                    asserts.assertRowsAdgang(adgangSaMSCRUS, adgangRTest);

                }

            }

            rsCountFromRTest.close();
            stFromRTest.close();
            stFromSA.close();
            connToRTest.close();
            connToSA.close();

       // } catch (SQLException ex) {
            // handle any errors
        //    System.out.println("SQLException: " + ex.getMessage());
        //    System.out.println("SQLState: " + ex.getSQLState());
        //    System.out.println("VendorError: " + ex.getErrorCode());
        //}
    }


}

