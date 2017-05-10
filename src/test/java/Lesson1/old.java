package Lesson1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

/**
 * Created by Artur on 07.05.2017.
 */
public class old {
    public WebDriver driver;

    @BeforeSuite(alwaysRun = true)
    public void setup(){
        System.setProperty("webdriver.gecko.driver", "C:\\Selenium\\geckodriver.exe");
        driver = new FirefoxDriver();
    }

    @AfterSuite(alwaysRun = true)
    public void tearDown(){
            driver.quit();
    }

    @Test()
    public void loadPage(){
        //driver.get("http://www.facebook.com");
//        System.out.println(driver.getTitle());
        //Assert.assertEquals(driver.getTitle(), "Добро пожаловать на Фейсбук - заходите, регистрируйтесь и находите друзей.");
    }

    @Test(dependsOnMethods = "loadPage", dataProvider = "corData", dataProviderClass = Lesson2.DataProviders.class)
    public void loginCorrect(String login, String pass){
        System.out.println(login + ":" + pass);
//        driver.findElement(By.cssSelector("#email")).sendKeys(login);
//        driver.findElement(By.cssSelector("#pass")).sendKeys(pass);
//        driver.findElement(By.id("loginbutton")).click();
//        System.out.println(driver.getTitle());

    }

    @Test(groups = {"positive"}, dependsOnMethods = "filloutEmailFld", dataProvider = "correctData")
    public void filloutPassFld(){
        String password = "1234567890facebook";
        WebElement passwordFld = driver.findElement(By.cssSelector("#pass"));
        passwordFld.sendKeys(password);
        Assert.assertEquals(passwordFld.getAttribute("value"), password);
    }

    @Test(groups = {"poisitive"}, dependsOnMethods = "filloutPassFld")
    public void logIn(){
        WebElement logInBtn = driver.findElement(By.id("loginbutton"));
        logInBtn.click();
        System.out.println(driver.getTitle());
    }
}
