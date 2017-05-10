package com.facebook.tests;

import org.junit.AfterClass;
import org.junit.BeforeClass;
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
public class LoginTestFacebook {
    public WebDriver driver;

    @BeforeSuite(alwaysRun = true)
    public void setup(){
        System.setProperty("webdriver.gecko.driver", "C:\\Selenium\\geckodriver.exe");
        driver = new FirefoxDriver();
    }

    @AfterSuite(alwaysRun = true)
    public void tearDown(){
    //    driver.quit();
    }

    @Test(groups = {"p1"})
    public void loadPage(){
        driver.get("http://www.facebook.com");
        System.out.println(driver.getTitle());
        Assert.assertEquals(driver.getTitle(), "Добро пожаловать на Фейсбук - заходите, регистрируйтесь и находите друзей.");
    }

    @Test(groups = {"p2", "field"}, dependsOnMethods = "loadPage")
    public void filloutEmailFld(){
        String email = "artur15rus@yandex.ru";
        WebElement emailFId = driver.findElement(By.cssSelector("#email"));
        emailFId.sendKeys(email);
        Assert.assertEquals(emailFId.getAttribute("value"), email);
    }

    @Test(groups = {"p2", "field"}, dependsOnMethods = "filloutEmailFld")
    public void filloutPassFld(){
        String password = "1234567890facebook";
        WebElement passwordFld = driver.findElement(By.cssSelector("#pass"));
        passwordFld.sendKeys(password);
        Assert.assertEquals(passwordFld.getAttribute("value"), password);
    }

    @Test(groups = {"p3", "action"}, dependsOnMethods = "filloutPassFld")
    public void logIn(){
        WebElement logInBtn = driver.findElement(By.id("loginbutton"));
        logInBtn.click();
        System.out.println(driver.getTitle());
    }
}
