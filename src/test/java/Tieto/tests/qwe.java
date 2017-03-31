package Tieto.tests;

import Tieto.helpers.Asserts;
import Tieto.helpers.DBHelper;
import Tieto.helpers.GetDataHelper;
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
import java.util.*;

public class qwe {
    private Asserts asserts = new Asserts();
    private GetDataHelper dh =  new GetDataHelper();
    private DBHelper db = new DBHelper();
    private Properties properties = new Properties();

    private Map<String, Object> mapForRTest = new HashMap<String, Object>();
    private Map<String, Object> mapForMSCRUS = new HashMap<String, Object>();
    private Map<String, Object> mapForITest = new HashMap<String, Object>();
    private Map<String, Object> mapForUNITY = new HashMap<String, Object>();


    @Description("Сравнение данных записей таблиц BOOKGODS ")
    @Title("Сравнение данных записей таблиц BOOKGODS в RTest и MSCRUS")
    @Test
    public void RTestVsMSCRUS() throws SQLException, IOException {
        getPropertiesFile();
//BIG TABLE. Own its algoritm!
        int countRowsInSource = Integer.parseInt(properties.getProperty("system.RownumPool"));
        Connection connectionToRTest = db.connToRTest();
        Statement statmentForRTest = db.stFromConnection(connectionToRTest);
//BIG TABLE. Own its algoritm!
        String countSelectedRows = dh.getRoonumPool("bookgods.SOURCE.CountRow");
        ResultSet rsCountRowFromRTest = db.rsFromDB(statmentForRTest, countSelectedRows);

        while (rsCountRowFromRTest.next()) {
            ArrayList arrayRows = dh.getArray(countRowsInSource);

            for (int i = 0; i < arrayRows.size(); i++) {
                String sqlRowByRownum = (properties.getProperty("bookgods.SOURCE.RowByRownumPart1") + countRowsInSource
                        + properties.getProperty("bookgods.SOURCE.RowByRownumPart2") + arrayRows.get(i));
                ResultSet rsFromRTest = db.rsFromDB(statmentForRTest, sqlRowByRownum);

                while (rsFromRTest.next()) {
                    for (int k = 1; k <= rsFromRTest.getMetaData().getColumnCount(); k++) {
                        mapForRTest.put(rsFromRTest.getMetaData().getColumnName(k), rsFromRTest.getObject(k));
                    }
                    mapForRTest.remove("RN");
// Change UniqKey in SQL
                    String sql = (properties.getProperty("bookgods.MSCRUS.RowByPKFromSA") + rsFromRTest.getString("SELSKAB")
                            + " and BOOK_NR = " + rsFromRTest.getString("BOOK_NR") + " and VAREPOST_NR = " + rsFromRTest.getString("VAREPOST_NR"));
                    mapForMSCRUS =  dh.getMapFromSA(mapForRTest.size(), sql);
                }
                rsFromRTest.close();
                asserts.matchMaps(mapForRTest, mapForMSCRUS);
            }
        }
        //countRowsInSA = getCountRows(statmentForSA, properties.getProperty("bookgods.MSCRUS.CountRows"));
        //asserts.assertRowCount(countRowsInSource, countRowsInSA);

        rsCountRowFromRTest.close();
        statmentForRTest.close();
        connectionToRTest.close();
    }


    private void getPropertiesFile() throws IOException {
        properties.load(new FileReader(new File(String.format("src/test/resources/sql.properties"))));
    }

    private int getCountRows(Statement statment, String sql) throws SQLException {
        ResultSet rsCountRowsFromSA = db.rsFromDB(statment, sql);
        while (rsCountRowsFromSA.next()) {
            //countRowsInSource = rsCountRowsFromSA.getInt("c");
            //return countRowsInSource;
        }
        return 0;
    }


}

