package Tieto.helpers;


import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
            if (rsFromSA.getRow() == 0 || rsFromSA.getRow() > 1){
                System.err.println("Count rows got from SA: " + rsFromSA.getRow()
                        + ". If its > 1 check the unique key in sql query to SA! SQL: " + sql);
            }
            else {
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

    public  void assertRowCount() throws IOException {
        properties.load(new FileReader(new File(String.format("src/test/resources/sql.properties"))));
    }
}
