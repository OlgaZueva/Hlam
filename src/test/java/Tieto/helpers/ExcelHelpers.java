package Tieto.helpers;

import Tieto.models.CleanUp;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by zuevaolg on 28.03.2017.
 */
public class ExcelHelpers {
    private BufferedReader reader = null;
    private CleanUp cleanUp;


    public CleanUp getDataFromExcelByBufferedReader(String file) throws IOException {
        try {
            reader = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"));
            String line = reader.readLine();
            while (line != null) {
                String[] split = line.split(";");
                for (int i = 0; i < split.length; i++) {
                    //System.out.println(split[i]);
                    cleanUp = new CleanUp(split[0], split[1], split[2], split[3]);
                }
                System.out.println(split[0] + "  " + split[1] + "  " + split[2] + "  " + split[3]);
                line = reader.readLine();
            }
            return cleanUp;
        } finally {
            if (reader != null) {
                reader.close();
            }
        }
    }
}
