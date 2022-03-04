package com.vytrack.test;

import com.vytrack.utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import static com.vytrack.utilities.ConfigurationReader.getProperty;

public class DriverLauncher_DP {
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
    @DataProvider(name="VyTrackCredentials")
    public Object[][] credentials(Method VY){
        if (VY.getName().equals("AC1_OdoCheck")){
            return new Object[][]{{getProperty("usernameStoreManager4"),getProperty("password")},
                    {getProperty("usernameSalesManager4"), getProperty("password")},
            };}else
            return new Object[][]{{getProperty("usernameTruckDrivers4"),getProperty("password")},
                    {getProperty("usernameTruckDrivers5"), getProperty("password")},
            };
    }

}
