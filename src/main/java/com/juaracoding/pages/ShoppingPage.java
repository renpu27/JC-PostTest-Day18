package com.juaracoding.pages;

import com.juaracoding.drivers.DriverSingleton;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ShoppingPage {

    private WebDriver driver;

    public ShoppingPage() {
        this.driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id=\"noo-site\"]/section/div/div/div/span[1]/a/span")
    WebElement btnHome;

    @FindBy(xpath = "//*[@id=\"noo-site\"]/div[2]/div[3]/div/div[2]/div/div/div/div[2]/div[2]/div[3]/div/h3/a")
    WebElement btnItem;

    @FindBy(xpath = "//select[@id='pa_color']")
//    @FindBy(id = "pa_color")
    WebElement btnColor;

    @FindBy(xpath = "//select[@id='pa_size']")
//    @FindBy(id = "pa_size")
    WebElement btnSize;

    @FindBy(xpath = "//*[@id=\"product-1485\"]/div[1]/div[2]/form/div/div[2]/button")
    WebElement btnAdd;

    @FindBy(xpath = "//*[@id=\"noo-site\"]/div[2]/div/div/div[1]/div")
    WebElement txtAdded;

public String getTxtAdded(){return txtAdded.getText();
}
public void toHome(){btnHome.click();}
public void toItem(){btnItem.click();}

public void shopping(){
    btnColor.sendKeys("Black");
////    WebElement selectColor = btnColor;
//    WebElement selectColor = driver.findElement(By.id("pa_color"));
//    Select color = new Select(selectColor);
//    color.selectByIndex(1);
    btnSize.sendKeys("34");
////    WebElement selectSize = btnSize;
//    WebElement selectSize = driver.findElement(By.id("pa_size"));
//    Select size =new Select(selectSize);
//    size.selectByIndex(2);
    btnAdd.click();
}

}
