package Lesson1;

import Lesson2.DataProviders;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/**
 * Created by Artur on 10.05.2017.
 */
public class LoginTestComapping {
    public static WebDriver driver;

    @BeforeSuite(alwaysRun = true)
    public void setup(){
        System.setProperty("webdriver.gecko.driver", "C:\\Selenium\\geckodriver.exe");
        driver = new FirefoxDriver();
    }

    @Test(dataProvider = "correctData", dataProviderClass = DataProviders.class)
    public void positiveTest(String login, String passwd){
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.get("http://www.comapping.com");
        System.out.println(driver.getTitle());

        WebElement emailFId = driver.findElement(By.name("username"));
        emailFId.sendKeys(login);
        Assert.assertEquals(emailFId.getAttribute("value"), login);

        WebElement passwordFld = driver.findElement(By.name("passwd"));
        passwordFld.sendKeys(passwd);
        Assert.assertEquals(passwordFld.getAttribute("value"), passwd);

        driver.findElement(By.name("Submit")).click();
        driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
//        WebDriverWait.until(condition-that-finds-the-element);
        String bodyText = driver.findElement(By.tagName("body")).getText();
        System.out.println(bodyText);
        //        Assert.assertEquals(true, bodyText.contains("Welcome"));

    }

    public static boolean isAlertPresent()
    {
        try
        {
            driver.switchTo().alert();
            return true;
        }   // try
        catch (Exception Ex)
        {
            return false;
        }   // catch
    }   // isAlertPresent()

    @Test(dataProvider = "incorrectData", dataProviderClass = DataProviders.class)
    public void negativeTest(String login, String passwd){
        driver.get("http://www.comapping.com");
        System.out.println(driver.getTitle());

        WebElement emailFId = driver.findElement(By.name("username"));
        emailFId.sendKeys(login);

        WebElement passwordFld = driver.findElement(By.name("passwd"));
        passwordFld.sendKeys(passwd);

        driver.findElement(By.name("Submit")).click();
        System.out.println(driver.findElement(By.name("Submit")).isEnabled());
        System.out.println(isAlertPresent());

//        Alert al = driver.switchTo().alert();
//        al.accept();
        String bodyText = driver.findElement(By.tagName("body")).getText();
        Assert.assertEquals(true, bodyText.contains("Welcome"));
//        Assert.assertEquals(isAlertPresent(), true);
    }

        @AfterSuite(alwaysRun = true)
    public void tearDown(){
//        driver.quit();
    }
}
