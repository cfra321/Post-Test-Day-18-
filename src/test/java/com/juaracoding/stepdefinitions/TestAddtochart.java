package com.juaracoding.stepdefinitions;

import com.juaracoding.drivers.DriverSingleton;
import com.juaracoding.page.Addtochart;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestAddtochart {
    public static WebDriver driver;
    public Addtochart addtochart;

    @BeforeClass
    public void setUp() {
        DriverSingleton.getInstance("chrome");
        driver = DriverSingleton.getDriver();
        addtochart = new Addtochart();
    }

    @Test
    public void testUrladd() {
        driver.get("https://shop.demoqa.com/product/black-cross-back-maxi-dress/");
        //step verify
        Assert.assertEquals(addtochart.getLoginTitle(), "BLACK CROSS BACK MAXI DRESS");
        delay(1);
    }

    @AfterClass
    public void quitBrowser() {
        delay(2);
        DriverSingleton.closeObjectInstance();
    }

    static void delay(long detik) {
        try {
            Thread.sleep(detik * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

