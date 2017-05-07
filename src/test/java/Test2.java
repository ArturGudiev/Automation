import org.testng.annotations.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;
import sun.util.locale.LocaleUtils;

import java.util.Locale;

import static org.junit.Assert.assertEquals;

/**
 * Created by Artur on 04.05.2017.
 */
public class Test2 {
    @BeforeMethod
    public void before(){
        System.out.println("BeforeMethod");
    }

    @AfterMethod
    public void after(){
        System.out.println("AfterMethod");
    }

    @Test(dataProvider = "getUsers")
    public void test1(String userName, String password, boolean exist){
        System.out.println("Test 1" + userName + ":" + password);
        //        System.out.println("Before test1");
//        System.out.println("test1" + 0.0/0.0);
//        System.out.println("After test1");
        //        System.setProperty("webdriver.gecko.driver", "C:\\Selenium\\geckodriver.exe");
//        WebDriver driver = new FirefoxDriver();
//        driver.navigate().to("https://www.epam.com");
//
//        assertEquals(driver.getTitle(), "EPAM | Software Product Development Services");
//        driver.close();
    }

    @Test(invocationCount = 10, threadPoolSize = 5)
    public void test2(){
        System.out.println(hello());
    }

    public static int id = 0;

    private String hello(){
        return "hello" + id++ + ":" + Thread.currentThread().getId();
    }


    @DataProvider
    public Object[][] getUsers() {
        return new Object[][]{
                {"user1", "psw1", false},// for login function
                {"user2", "psw2", true},// false or true if exists the user
        };
    }

}
