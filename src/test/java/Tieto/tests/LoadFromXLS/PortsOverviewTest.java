package Tieto.tests.LoadFromXLS;

import Tieto.helpers.DBHelper;
import Tieto.models.PortsOverview;
import org.testng.annotations.Test;

import java.io.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;


public class PortsOverviewTest {

    private DBHelper db = new DBHelper();
    private Properties properties = new Properties();
    private BufferedReader reader = null;
    private Map<String, Object> mapFromXLS = new HashMap<String, Object>();
    private Statement statmentForSA;
    private Connection connectionToSA;
    private ResultSet rsFromSA;
    private PortsOverview portsOverview;


    @Test
    public void RTestVsMSCRUS() throws IOException, SQLException {
try{
        reader = new BufferedReader(new InputStreamReader(new FileInputStream("src/test/resources/PORTS_overview_CSV.csv"), "UTF-8"));
        String line = reader.readLine();
        while (line != null) {
            String[] split = line.split(";");
            for (int i = 0; i < split.length; i++) {
                //System.out.println(split[i]);
               portsOverview = new PortsOverview(split[0], split[1], split[2], split[3], split[4], split[5],
                        split[6], split[7], split[8], split[9], split[10], split[11], split[12], split[13], split[14]);
            }
            System.out.println(split[0] + "  " + split[1] + "  " + split[2] + "  " + split[3] + "  " + split[4]
                    + "  " + split[5] + "  " + split[6] + "  " + split[7] + "  " + split[8] + "  " + split[9]
                    + "  " + split[10] + "  " + split[11] + "  " + split[12] + "  " + split[13] + "  " + split[14]);
            line = reader.readLine();
        }
    } finally {
        if (reader != null) {
            reader.close();
        }
    }

        properties.load(new FileReader(new File(String.format("src/test/resources/excel.properties"))));
        connectionToSA = db.connToSA();
        statmentForSA = db.stFromConnection(connectionToSA);
//change sql
        String sql = (properties.getProperty("portsOverviewFromSA") + "Location_Code = '" + portsOverview.getLocationCode()
                + "' and Liner = '" + portsOverview.getLiner() + "' and Liner_Assistant ='" + portsOverview.getLinerAssistant()
                + "' and Destination_Region ='" + portsOverview.getDestinationRegion()
                + "' and Trade_Name_GVA_Style_For_EMED_statistic ='" + portsOverview.getTradeNameGVAStyleForEMEDstatistic()
                + "' and LAND_LOCKED_Country ='" + portsOverview.getLANDLOCKEDCountry() + "' and Agency_Region='" + portsOverview.getAgencyRegion()
                + "' and Agency_ID ='" + portsOverview.getAgencyCode()+ "' and CTSTier5 ='" + portsOverview.getCTSTier5()
                + "' and CTSTier4 ='" + portsOverview.getCTSTier4() + "' and USPiersUSPORT ='" + portsOverview.getUSPiersUSPORT()
                + "' and USPiersULT_CODE ='" + portsOverview.getUSPiersULTCODE() + "' and DKEXPTEAM ='" + portsOverview.getDKEXPTEAM()
                + "' and VALID_FROM ='" + portsOverview.getVALID_FROM()
                +"' and DeepseaFlag ='" + portsOverview.getDeepseaFlag()+ "'");

        System.out.println(sql);

        statmentForSA.close();
        connectionToSA.close();
    }

}