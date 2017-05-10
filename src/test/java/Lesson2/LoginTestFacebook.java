package Lesson2;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/**
 * Created by Artur on 10.05.2017.
 */
public class LoginTestFacebook {
    public static WebDriver driver;

    @BeforeSuite(alwaysRun = true)
    public void setup(){
        System.setProperty("webdriver.gecko.driver", "C:\\Selenium\\geckodriver.exe");
        driver = new FirefoxDriver();
    }

    @Test(groups = {"poisitive"}, dataProvider = "correctData", dataProviderClass = DataProviders.class)
    public void positiveTest(String login, String passwd){
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.get("http://www.facebook.com");


        WebElement emailFId = driver.findElement(By.cssSelector("#email"));
        emailFId.sendKeys(login);

        WebElement passwordFld = driver.findElement(By.cssSelector("#pass"));
        passwordFld.sendKeys(passwd);

        driver.findElement(By.id("loginbutton")).click();
        final String previousURL = driver.getCurrentUrl();
        ExpectedCondition e = new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return (!d.getCurrentUrl().equals(previousURL));
            }
        };
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(e);

        driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
    Assert.assertEquals(driver.getTitle(), "");
    }


    @Test(groups = {"poisitive"}, dataProvider = "incorrectData", dataProviderClass = DataProviders.class)
    public void negativeTest(String login, String passwd){
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.get("http://www.facebook.com");
        System.out.println(driver.getCurrentUrl());

        WebElement emailFId = driver.findElement(By.cssSelector("#email"));
        emailFId.sendKeys(login);

        WebElement passwordFld = driver.findElement(By.cssSelector("#pass"));
        passwordFld.sendKeys(passwd);

        driver.findElement(By.id("loginbutton")).click();
        final String previousURL = driver.getCurrentUrl();
        ExpectedCondition e = new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return (!d.getCurrentUrl().equals(previousURL));
            }
        };
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(e);
        System.out.println(driver.getCurrentUrl());

        driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);

        Assert.assertEquals(driver.getTitle(), "Войдите на Facebook | Facebook");
    }

    @AfterSuite(alwaysRun = true)
    public void tearDown(){
        driver.quit();
    }
}
