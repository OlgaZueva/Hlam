package Tieto.helpers;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class GetDataHelper {
    private Properties properties = new Properties();
    private DBHelper db = new DBHelper();

    private Map<String, Object> mapForMSCRUS = new HashMap<String, Object>();

    public Map<String, Object> getMapFromSA(int mapForRTestSize, String sql) throws SQLException {
        Connection connectionToSA = db.connToSA();
        Statement stForSA = db.stFromConnection(connectionToSA);
        System.out.println("SQL из SA: " + sql);
        ResultSet rsFromSA = db.rsFromDB(stForSA, sql);
        while (rsFromSA.next()) {
            if (rsFromSA.getRow() == 0 || rsFromSA.getRow() > 1) {
                System.err.println("Count rows got from SA: " + rsFromSA.getRow()
                        + ". If its > 1 check the unique key in sql query to SA! SQL: " + sql);
            } else {
                for (int l = 1; l <= mapForRTestSize; l++) {
                    mapForMSCRUS.put(rsFromSA.getMetaData().getColumnName(l), rsFromSA.getObject(l));
                }
            }
        }
        rsFromSA.close();
        stForSA.close();
        connectionToSA.close();
        return mapForMSCRUS;

    }

    public String getRoonumPool(String parametrForTable) throws IOException {
        getPropertiesFile();
        String qwe = properties.getProperty(parametrForTable) + properties.getProperty("system.RownumPool");
        System.out.println("Запрос для пула, из которого будут выбраны записи: " + qwe);
        return qwe;
    }


    public ArrayList getArray(int countRowsInTable) throws IOException {
        getPropertiesFile();
        int percent = Integer.parseInt(properties.getProperty("system.PercentOfRows"));
        int countRowsForMatch = (countRowsInTable * percent) / 100;
        int increment = countRowsInTable / countRowsForMatch;
        ArrayList arrayRows = new ArrayList();
        for (int i = 1; i < (countRowsInTable - increment); i = i + increment) {
            arrayRows.add(i);
        }
        System.out.println("Кол-во записей пула, которые будут сравниваться: " + arrayRows.size());
        return arrayRows;
    }

    private void getPropertiesFile() throws IOException {
        properties.load(new FileReader(new File(String.format("src/test/resources/sql.properties"))));
    }
}
