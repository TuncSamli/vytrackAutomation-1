package com.vytrack.test;

import com.vytrack.utilities.VyTrack_Login;
import com.vytrack.utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static com.vytrack.utilities.ConfigurationReader.getProperty;

public class US_58_AutomationForAC2 {
    WebDriver driver;
    @BeforeMethod
    public void  setUpMethod(){
        driver= WebDriverFactory.getDriver(getProperty("browser"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(getProperty("env"));
    }
    @DataProvider(name="provider")
    public Object [][] dpMthd() {
        return new Object[][]{
                {"usernameTruckDrivers1", "password"},
                {"usernameTruckDrivers2", "password"},
                {"usernameTruckDrivers3", "password"},
                {"usernameTruckDrivers4", "password"},
                {"usernameTruckDrivers5", "password"},
                {"usernameTruckDrivers6", "password"},
                {"usernameTruckDrivers7", "password"},
        };
    }

    @Test(dataProvider = "provider")
    public void VyLogin(String name,String password) {
        VyTrack_Login.login(driver, getProperty(name),getProperty(password));


    }
    @AfterMethod
    public void after(){
        driver.close();
    }
}


