package com.vytrack.test;

import com.vytrack.utilities.ConfigurationReader;
import com.vytrack.utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import java.util.concurrent.TimeUnit;

public class US_67 {

    public WebDriver driver;
    @BeforeMethod
    public void setup(){
        driver = WebDriverFactory.getDriver(ConfigurationReader.getProperty("browser"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(ConfigurationReader.getProperty("env1"));
    }

    @AfterMethod
    public void teardown(){
        driver.quit();
    }

    @DataProvider(name="userProvider")
    public Object[][] provideData(){
        return new Object[][]{
                {"usernameTruckDrivers1", "password"},
        };
    }
















}
