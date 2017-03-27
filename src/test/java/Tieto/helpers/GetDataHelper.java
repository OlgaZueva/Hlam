package Tieto.helpers;


import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class GetDataHelper {
    private Properties properties = new Properties();


    public  void assertRowCount() throws IOException {
        properties.load(new FileReader(new File(String.format("src/test/resources/sql.properties"))));
    }
}
