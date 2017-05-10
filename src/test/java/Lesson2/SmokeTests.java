import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Created by Artur on 04.05.2017.
 */
public class SmokeTests {
    @DataProvider
    public Object[][] correctData(){
        return new Object[][]{{1, "Roman"}, {2, "Admin"}};
    }

    @Test(dataProvider = "correctData")
    public void simpleTest(int num, String name){
        System.out.println(num +": " + name);
    }
}
