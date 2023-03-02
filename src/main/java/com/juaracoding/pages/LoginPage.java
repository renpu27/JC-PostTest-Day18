package com.juaracoding.pages;

import com.juaracoding.drivers.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    private WebDriver driver;

    public LoginPage() {
        this.driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "/html/body/p/a")
    WebElement btnDismiss;

    @FindBy(xpath = "//a[normalize-space()='My Account']")
    WebElement myAccount;

    @FindBy(xpath = "//input[@id='username']")
    WebElement username;

    @FindBy(xpath = "//input[@id='password']")
    WebElement password;

    @FindBy(xpath = "//input[@id='rememberme']")
    WebElement chkRememberMe;

    @FindBy(xpath = "//button[@name='login']")
    WebElement btnLogin;

    @FindBy(xpath = "//a[normalize-space()='Dashboard']")
    WebElement txtDashboard;

    @FindBy(xpath = "//div[@id='primary']//li[1]")
    WebElement txtError;

    public String getTxtDashboard(){
        return txtDashboard.getText();
    }

    public String getTxtError(){
        return txtError.getText();
    }

    public void tologinpage(){
        btnDismiss.click();
        myAccount.click();
    }

    public void login(String username, String password){
        this.username.sendKeys(username);
        this.password.sendKeys(password);
        chkRememberMe.click();
        btnLogin.click();
    }

}