package com.juaracoding.stepdefinitions;

import com.juaracoding.drivers.DriverSingleton;
import com.juaracoding.pages.LoginPage;
import com.juaracoding.pages.ShoppingPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestShopping {
    public static WebDriver driver;
    public LoginPage loginPage;
    public ShoppingPage shop;

    @BeforeClass
    public void setUp() {
        DriverSingleton.getInstance("chrome");
        driver = DriverSingleton.getDriver();
        driver.get("https://shop.demoqa.com/");
        loginPage = new LoginPage();
        loginPage.tologinpage();
        shop = new ShoppingPage();
        loginPage.login("renpu-27","@Renaldo27");
    }

    @Test
    public void testShop(){
        shop.toHome();
        shop.toItem();
        shop.shopping();
        Assert.assertEquals(shop.getTxtAdded(), "View cart");
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
