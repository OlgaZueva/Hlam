package Tieto.helpers;

import Tieto.models.Adgang;
import Tieto.models.Adresse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeMethod;
import ru.yandex.qatools.allure.annotations.Step;


import java.util.Map;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


public class Asserts {

    @Step ("Сравнение общего числа записей в таблицах: В Source: {0}, в SA: {1} ")
    public  void assertRowCount(int countInSource, int countInSA){
        assertThat(countInSource, equalTo(countInSA));
    }

    @Step("Сравнение записи в таблицах ADGANG.")
    public void assertRowsAdgang(Adgang adgangSaMSCRUS, Adgang adgangRTest) {
    //    Logger logger = LoggerFactory.getLogger(Asserts.class);
        assertThat(adgangSaMSCRUS, equalTo(adgangRTest));
        //logger.info(String.valueOf(adgangSaMSCRUS) + String.valueOf(adgangRTest));
    }

    @Step("Сравнение записи в таблицах ADRESSE.")
    public void assertRowsAdresse(Adresse adresseSaMSCRUS, Adresse adresseRTest) {
        assertThat(adresseSaMSCRUS, equalTo(adresseRTest));
    }

    @Step ("Сравнение данных записи в таблицах")
    public void matchMaps(Map<String, Object> mapSource, Map<String, Object> mapSA) {
        // System.out.println("Map from Source = " + mapSource);
        // System.out.println("Map from StArea = " + mapSA);
        for (Map.Entry entry : mapSource.entrySet()) {
            Object q1 = entry.getKey();
            Object q2 = entry.getValue();
            if (q2 == null) {
                if (mapSA.get(q1) != null) {
                    // error
                    System.err.println("Column [" + q1  + "] expected null but was [" + mapSA.get(q1).toString() + "]");
                } else if (!mapSA.keySet().contains(q1)) {
                    System.err.println("Column [" + q1  + "] not exist");
                }
            } else {
                if(!q2.equals(mapSA.get(q1))){
                    Object secondValue = mapSA.get(q1);
                    if(!q2.toString().equals(secondValue!=null?secondValue.toString():null)){
                        System.err.println("Column [" + q1.toString() + "] does not match. Expected [" + q2 + "], actual - [" + mapSA.get(q1) + "]");
                    }
                }
            }
        }
    }

}
