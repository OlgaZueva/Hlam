package Tieto.helpers;

import Tieto.models.Adgang;
import Tieto.models.Adresse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeMethod;
import ru.yandex.qatools.allure.annotations.Step;


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


}
