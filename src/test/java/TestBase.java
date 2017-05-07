import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Artur on 04.05.2017.
 */
public class TestBase {
    public static WebDriver driver;

    @BeforeSuite(alwaysRun=true)
    public static void setUp(){
        System.out.println("Before Suite");
//        System.setProperty("webdriver.gecko.driver", "C:\\Selenium\\geckodriver.exe");
//        driver = new FirefoxDriver();
    }

    @Test
    public void simpleTest(){
        System.out.println("SimpleTest1");
//        driver.navigate().to("https://www.epam.com");
//        assertEquals(driver.getTitle(), "EPAM | Software Product Development Services");
    }

    @Test
    public void simpleTest2(){
        System.out.println("SimpleTest2");
//        driver.navigate().to("https://www.google.com");
        //assertEquals(driver.getTitle(), "EPAM | Software Product Development Services");
    }


    @AfterSuite(alwaysRun = true)
    public static void setDown(){
        System.out.println("After suite");
//        driver.close();
    }
}
