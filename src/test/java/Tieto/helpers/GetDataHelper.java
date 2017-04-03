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

    private Map<String, Object> mapForSA = new HashMap<String, Object>();
    private Map<String, Object> mapForSource = new HashMap<String, Object>();

    public Map<String, Object> getMapFromSA(int mapForRTestSize, String sql) throws SQLException {
        Connection connectionToSA = db.connToSA();
        Statement stForSA = db.stFromConnection(connectionToSA);
        System.out.println("SQL из SA: " + sql);
        ResultSet rsFromSA = db.rsFromDB(stForSA, sql);

        while (rsFromSA.next()) {
            if (rsFromSA.getRow() > 1) {
                System.err.println("Count rows got from SA: " + rsFromSA.getRow()
                        + ". If its > 1 check the unique key in sql query to SA! SQL: " + sql);
            } else {
                for (int l = 1; l <= mapForRTestSize; l++) {
                    mapForSA.put(rsFromSA.getMetaData().getColumnName(l), rsFromSA.getObject(l));
                }
            }
        }
     /*
            while (rsFromSA.next()) {
                System.out.println("rsFromSA.getRow(): " + rsFromSA.getRow());
                if (rsFromSA.getRow() > 1) {
                    System.err.println("Count rows got from SA: " + rsFromSA.getRow()
                            + ". If its > 1 check the unique key in sql query to SA! SQL: " + sql);
                    return null;
                } else {
                    for (int l = 1; l <= mapForRTestSize; l++) {
                        mapForSA.put(rsFromSA.getMetaData().getColumnName(l), rsFromSA.getObject(l));
                    }
                }
            }
            */
        rsFromSA.close();
        stForSA.close();
        connectionToSA.close();
        return mapForSA;
    }


    public Map<String, Object> getMapFromSource(ResultSet rsFromSource) throws SQLException {
        for (int k = 1; k <= rsFromSource.getMetaData().getColumnCount(); k++) {
            mapForSource.put(rsFromSource.getMetaData().getColumnName(k), rsFromSource.getObject(k));
        }
        mapForSource.remove("RN");
        return mapForSource;
    }


    public String getRoonumPool(String parametrForTable) throws IOException {
        getPropertiesFile();
        String sql = properties.getProperty(parametrForTable) + properties.getProperty("system.RownumPool");
        System.out.println("Запрос для пула, из которого будут выбраны записи: " + sql);
        return sql;
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

    public int getCountRowsInITest(String table) throws SQLException, IOException {
        getPropertiesFile();
        String sql = properties.getProperty(table);
        System.out.println("Запрос колв-ва строк из ITest: " + sql);
        Connection connectionToITest = db.connToITest();
        Statement statmentForITest = db.stFromConnection(connectionToITest);
        ResultSet rsCountRowFromITest = db.rsFromDB(statmentForITest, sql);
        int countRowInITest = 0;
        while (rsCountRowFromITest.next()) {
            countRowInITest = Integer.parseInt(rsCountRowFromITest.getString("c"));
        }
        rsCountRowFromITest.close();
        statmentForITest.close();
        connectionToITest.close();
        return countRowInITest;
    }

    public int getCountRowsInSA(String table) throws IOException, SQLException {
        getPropertiesFile();
        String sql = properties.getProperty(table);
        System.out.println("Запрос кол-ва строк из SA: " + sql);
        Connection connectionToSA = db.connToSA();
        Statement statmentForSA = db.stFromConnection(connectionToSA);
        ResultSet rsCountRowFromSA = db.rsFromDB(statmentForSA, sql);
        int countRowInITest = 0;
        while (rsCountRowFromSA.next()) {
            countRowInITest = Integer.parseInt(rsCountRowFromSA.getString("c"));
        }
        rsCountRowFromSA.close();
        statmentForSA.close();
        connectionToSA.close();
        return countRowInITest;
    }

    public int getCountRowsInRTest(String table) throws IOException, SQLException {
        getPropertiesFile();
        String sql = properties.getProperty(table);
        System.out.println("Запрос кол-ва строк из RTest: " + sql);
        Connection connectionToRTest = db.connToRTest();
        Statement statmentForRTest = db.stFromConnection(connectionToRTest);
        ResultSet rsCountRowFromRTest = db.rsFromDB(statmentForRTest, sql);
        int countRowInRTest = 0;
        while (rsCountRowFromRTest.next()) {
            countRowInRTest = Integer.parseInt(rsCountRowFromRTest.getString("c"));
        }
        rsCountRowFromRTest.close();
        statmentForRTest.close();
        connectionToRTest.close();
        return countRowInRTest;
    }


    public String getRoonumPoolForSmallTable(String parametrForTable ) throws IOException {
        getPropertiesFile();
        String sql = properties.getProperty(parametrForTable);
        System.out.println("Запрос для пула, из которого будут выбраны записи: " + sql);
        return sql;
    }
}
