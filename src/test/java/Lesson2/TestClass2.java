package Lesson2;

import org.junit.Before;
import org.testng.ITestResult;
import org.testng.TestNG;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

import static org.junit.Assert.assertEquals;

/**
 * Created by Artur on 06.05.2017.
 */
public class TestClass2 {
    public static WebDriver driver;
    @BeforeMethod
    public void before(){
        System.out.println("beforeMethod");
        System.setProperty("webdriver.gecko.driver", "C:\\Selenium\\geckodriver.exe");
        driver = new FirefoxDriver();
    }
    @BeforeMethod
    public void before(Method method){
        System.out.println("Before method from " + method.getName());
    }
    @Test
    public void simpleTest(){
        driver.navigate().to("https://www.epam.com");
        assertEquals(driver.getTitle(), "EPAM | Software Product Development Services");
    }

    @Test
    public void simpleTest2(){
        driver.navigate().to("https://www.epam.com");
        assertEquals(driver.getTitle(), "EPAM | Software Product Development Services");
    }

    @AfterMethod
    public void after(ITestResult result){
        System.out.println("result");
        if(!result.isSuccess()){
            //takeScreenshot(result.getMethod().getMethodName());
        }
    }

    @AfterMethod
    public void after(){
        System.out.println("afterMethod");
        driver.close();
    }
}
