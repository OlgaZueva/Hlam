package Tieto.tests.LoadFromXLS;

import Tieto.helpers.DBHelper;
import Tieto.helpers.ExcelHelpers;
import Tieto.models.CleanUp;
import org.testng.annotations.Test;

import java.io.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * Created by zuevaolg on 28.03.2017.
 */
public class CleanUpTests {

    private DBHelper db = new DBHelper();
    private ExcelHelpers eh = new ExcelHelpers();
    private Properties properties = new Properties();

    private Map<String, Object> mapFromExcel = new HashMap<String, Object>();
    private ResultSet rsFromSA;
    private CleanUp cleanUp;


    @Test
    public void RTestVsMSCRUS() throws IOException, SQLException {
        properties.load(new FileReader(new File(String.format("src/test/resources/excel.properties"))));

        cleanUp = eh.getDataFromExcelByBufferedReader(properties.getProperty("cleanUpDataFile"));


        //Connection connectionToSA = db.connToSA();
        //Statement statmentForSA = db.stFromConnection(connectionToSA);
//change sql
        String sql = (properties.getProperty("cleanUpFromSA") + " BL_NUMBER = '" + cleanUp.getBlNumber()
                + "' and CUSTOMER = '" + cleanUp.getCustomer() + "' and VALID_FROM ='" + cleanUp.getValidFrom()
                + "' and NVOBCOFRW ='" + cleanUp.getNvoBcoFrw() + "'");

        System.out.println(sql);

        //statmentForSA.close();
        //connectionToSA.close();
    }


}
