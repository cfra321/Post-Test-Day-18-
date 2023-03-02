package com.juaracoding.page;

import com.juaracoding.drivers.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Addtochart {
    private WebDriver driver;
    public Addtochart() {
        this.driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id=\"noo-site\"]/section/div/div/h1")
    WebElement addTitle;

    public String getLoginTitle(){
        return addTitle.getText();
    }
}
