package com.juaracoding.stepdefinitions;

import com.juaracoding.drivers.DriverSingleton;
import com.juaracoding.page.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestLogin {

    public static WebDriver driver;
    public LoginPage loginPage;

    @BeforeClass
    public void setUp(){
        DriverSingleton.getInstance("chrome");
        driver = DriverSingleton.getDriver();
        loginPage = new LoginPage();
    }

    @Test(priority = 1)
    public void testurl(){
        driver.get("https://shop.demoqa.com/my-account/");
        //step verify
        Assert.assertEquals(loginPage.getLoginTitle(),"LOGIN");
    }
    @Test(priority = 2)
    public void testInvalidLogin() {
        delay(1);
        loginPage.login("kukuh", "invalid");
        Assert.assertEquals(loginPage.getTxtInvalidCredentials(), "ERROR: The username or password you entered is incorrect. Lost your password?");
    }

    @Test(priority = 3)
    public void testValidLogin(){
        loginPage.login("","Nasiudk123");
        Assert.assertEquals(loginPage.getTxtDashboard(),"Dashboard");
    }

    @AfterClass
    public void quitBrowser(){
        delay(2);
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
