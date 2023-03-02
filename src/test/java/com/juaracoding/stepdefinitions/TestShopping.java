package com.juaracoding.stepdefinitions;

import com.juaracoding.drivers.DriverSingleton;
import com.juaracoding.pages.LoginPage;
import com.juaracoding.pages.ShoppingPage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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
        loginPage = new LoginPage();
        driver.get("https://shop.demoqa.com/");
        loginPage.tologinpage();
        loginPage.login("renpu-27","@Renaldo27");
    }

    @Test
    public void testShop(){
//        shop.toHome();
        driver.findElement(By.xpath("//*[@id=\"noo-site\"]/section/div/div/div/span[1]/a/span")).click();
//        shop.toItem();
        driver.findElement(By.xpath("//*[@id=\"noo-site\"]/div[2]/div[3]/div/div[2]/div/div/div/div[2]/div[2]/div[3]/div/h3/a")).click();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 800)");
        shop.shopping();
        Assert.assertEquals(shop.getTxtAdded(), "“black lux graphic t-shirt” has been added to your cart.");
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
