package Tieto;

import Tieto.models.Adgang;
import org.testng.annotations.Test;

import java.sql.*;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


public class DBConnectionTest {
    @Test
    public void dbConnection() throws ClassNotFoundException {
        Connection connToSA = null;
        Connection connToRTest = null;
        try {
            //Class.forName("oracle.jdbc.OracleDriver");
            connToSA = DriverManager.getConnection("jdbc:sqlserver://10.45.1.122;databaseName=BIFROST;user=sa;password=JGdedf&#fsqwhdc");
            connToRTest = DriverManager.getConnection("jdbc:oracle:thin:dwh_etl/T4M2iJfRGw@10.45.1.223:1566:RTEST");
            //connToITest = DriverManager.getConnection("jdbc:oracle:thin:dwh_etl/T4M2iJfRGw@10.45.101.220:1551:ITEST");

            Statement stTest = connToSA.createStatement();
            Statement stFromSA = connToSA.createStatement();
            Statement stFromRTest = connToRTest.createStatement();

            //ResultSet rsRTestAdresse = stFromRTest.executeQuery("select t.* from adresse_etl_v t where  ROWNUM < 100 order by t.selskab, t.ref_type, t.ref_nr, t.nr");

            ResultSet rsTest = stTest.executeQuery("select count(*) c from stg.MSCRUS_Adgang");
            ResultSet rsFromSaMSCRUS = stFromSA.executeQuery("select VOR_REF, UTS_LEVEL, UTS_ADMIN, START_SEL, UTS_GROUP, FGAC, ACCOUNTANT, AD_LOGIN, AD_USER_ONLY from stg.MSCRUS_Adgang where VOR_REF = 'NOINRU'");
            ResultSet rsFromRTest = stFromRTest.executeQuery("select * from adgang_etl_v where VOR_REF = 'NOINRU'");
            ResultSet rsCountFromRTest = stFromRTest.executeQuery("select count(*) c from adgang_etl_v");

            Adgang adgangSaMSCRUS = null;
            Adgang adgangRTest = null;

            while (rsCountFromRTest.next()) {
                int count = rsCountFromRTest.getInt("c");
                System.out.println("Всего: " + count);
                System.out.println("Первые два из выборки. Первый: " + (count - (count - 1)) + " Второй: " + (count - (count - 2)));
                System.out.println("Два из середины. Первый: " + (count / 2 - 1) + " Второй: " + (count / 2));
                System.out.println("Два с конца. Первый: " + (count - 1) + " Второй: " + count);
            }


            while (rsFromSaMSCRUS.next()) {
                adgangSaMSCRUS = new Adgang().setVOR_REF(rsFromSaMSCRUS.getString("VOR_REF")).setUTS_LEVEL(rsFromSaMSCRUS.getInt("UTS_LEVEL"))
                        .setUTS_ADMIN(rsFromSaMSCRUS.getString("UTS_ADMIN")).setSTART_SEL(rsFromSaMSCRUS.getByte("START_SEL"))
                        .setUTS_GROUP(rsFromSaMSCRUS.getString("UTS_GROUP")).setFGAC(rsFromSaMSCRUS.getString("FGAC"))
                        .setACCOUNTANT(rsFromSaMSCRUS.getString("ACCOUNTANT")).setAD_LOGIN(rsFromSaMSCRUS.getString("AD_LOGIN"))
                        .setAD_USER_ONLY(rsFromSaMSCRUS.getString("AD_USER_ONLY"));
                System.out.println(adgangSaMSCRUS);
            }

            while (rsFromRTest.next()) {
                adgangRTest = new Adgang().setVOR_REF(rsFromRTest.getString("VOR_REF")).setUTS_LEVEL(rsFromRTest.getInt("UTS_LEVEL"))
                        .setUTS_ADMIN(rsFromRTest.getString("UTS_ADMIN")).setSTART_SEL(rsFromRTest.getByte("START_SEL"))
                        .setUTS_GROUP(rsFromRTest.getString("UTS_GROUP")).setFGAC(rsFromRTest.getString("FGAC"))
                        .setACCOUNTANT(rsFromRTest.getString("ACCOUNTANT")).setAD_LOGIN(rsFromRTest.getString("AD_LOGIN"))
                        .setAD_USER_ONLY(rsFromRTest.getString("AD_USER_ONLY"));
                System.out.println(adgangRTest);
            }

            assertThat(adgangSaMSCRUS, equalTo(adgangRTest));

            rsTest.close();
            rsFromSaMSCRUS.close();
            rsFromRTest.close();
            stTest.close();
            stFromSA.close();
            stFromRTest.close();
            connToSA.close();
            connToRTest.close();


        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
    }

    private void getRowToIndex(int index) {
    }
}
