import Lesson2.User;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Created by Artur on 07.05.2017.
 */
public class DataProviders {
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
