package com.juaracoding.stepdefinitions;

import com.juaracoding.drivers.DriverSingleton;
import com.juaracoding.pages.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestLogin {

    public static WebDriver driver;
    public LoginPage loginPage;

    @BeforeClass
    public void setUp() {
        DriverSingleton.getInstance("chrome");
        driver = DriverSingleton.getDriver();
        driver.get("https://shop.demoqa.com/");
        loginPage = new LoginPage();

    }

    @Test (priority = 2)
    public void testValidLogin(){
        driver.findElement(By.xpath("//input[@id='username']")).sendKeys(Keys.CONTROL,"a");
        driver.findElement(By.xpath("//input[@id='username']")).sendKeys(Keys.DELETE);
        delay(2);
        loginPage.tologinpage();
        loginPage.login("renpu-27", "@Renaldo27");
        Assert.assertEquals(loginPage.getTxtDashboard(),"Dashboard");
    }

    @Test (priority = 1)
    public void testInvalidLogin(){
        loginPage.tologinpage();
        loginPage.login("renpu-27", "hehehe");
        Assert.assertEquals(loginPage.getTxtError(),"Lost your password");
    }

    @AfterClass
    public void quitBrowser(){
        delay(3);
        DriverSingleton.closeObjectInstance();
    }

    static void delay(long detik){
        try {
            Thread.sleep(detik*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}