package com.vytrack.test;

import com.vytrack.utilities.BrowserUtils;
import com.vytrack.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static com.vytrack.utilities.ConfigurationReader.getProperty;

public class US_65 {
    WebDriver driver;
    @BeforeMethod
    public void setupMethod(){
        driver = WebDriverFactory.getDriver(getProperty("browser"));
        driver.manage().window().maximize();
        driver.get(getProperty("env"));
        driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);

    }
    @AfterMethod
    public void teardown() {
        driver.close();
    }

    @Test(dataProvider="VyTrackCredentials",dataProviderClass = DP.class,priority = 1)
    public void AC1_OdoCheck(String username,String password){
        driver.findElement(By.id("prependedInput")).sendKeys(username);
        driver.findElement(By.id("prependedInput2")).sendKeys(password);
        driver.findElement(By.xpath("//button[@id='_submit']")).click();
    }


}
