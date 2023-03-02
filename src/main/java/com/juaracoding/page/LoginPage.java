package com.juaracoding.page;

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

    @FindBy(xpath = "(//h2[normalize-space()='Login'])[1]")
    WebElement loginTitle;
    @FindBy(id = "username")
    WebElement username;
    @FindBy(id = "password")
    WebElement password;
    @FindBy(id = "rememberme")
    WebElement btnrememberme;
    @FindBy(xpath = "(//button[normalize-space()='Log in'])[1]")
    WebElement  btnLogin;
    @FindBy(xpath = "//div[@id='primary']//li[1]")
    WebElement txtInvalidCredentials;
    @FindBy(xpath = "(//p[contains(text(),'Hello')])[1]")
    WebElement txtDashboard;

    public String getLoginTitle(){
        return loginTitle.getText();
    }

    public String getTxtInvalidCredentials(){
        return txtInvalidCredentials.getText();
    }

    public String getTxtDashboard(){
        return txtDashboard.getText();
    }

    public void login(String username, String password){
        this.username.sendKeys(username);
        this.password.sendKeys(password);
        btnrememberme.click();
        btnLogin.click();
    }
}