package Lesson1;

import org.testng.annotations.DataProvider;

/**
 * Created by Artur on 07.05.2017.
 */
public class Providers {
    @DataProvider(name = "incorData")
    public Object[][] incorData(){
        return new Object[][]{
                {"abc", "def"},
                {"efg", "hij"},
        };
    };


    @DataProvider(name = "corData")
    public Object[][] corData(){
        return new Object[][]{
                {"arturgudiev93@yandex.ru", "1234NewAccount"},
        };
    };
}
