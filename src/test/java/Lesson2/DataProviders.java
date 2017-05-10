package Lesson2;

import org.testng.annotations.DataProvider;

/**
 * Created by Artur on 07.05.2017.
 */
public class DataProviders {
    @DataProvider(name = "correctData")
    public Object[][] correctDataFacebook(){
        return new Object[][]{
                {"arturgudiev93@yandex.ru", "12345678test"},
        };
    };

    @DataProvider(name = "incorrectData")
    public Object[][] incorrectData(){
        return new Object[][]{
                {"arturgudiev93@yandex.ru", "12345678910"},
                {"arturgudiev@yandex.ru", "1234"},
        };
    };

    @DataProvider(name= "correctDataComapping")
    public Object[][] correctData(){
        return new Object[][]{
                {"arturgudiev93@yandex.ru", "12345678"},
        };
    };
}
