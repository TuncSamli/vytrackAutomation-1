package com.vytrack.test;
import com.vytrack.utilities.Driver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import java.lang.reflect.Method;
import static com.vytrack.utilities.ConfigurationReader.getProperty;
public class DP {

    @BeforeMethod
    public void setUp(){
        Driver.getDriver().get(getProperty("env"));
    }
    @AfterMethod
    public void tearDown(){
        Driver.closeDriver();
    }
    @DataProvider(name = "VyTrackCredentials")
    public Object[][] credentials(Method VY) {
        if (VY.getName().equals("AC1_OdoCheck")) {
            return new Object[][]{{getProperty("usernameStoreManager4"), getProperty("password")},
                    {getProperty("usernameStoreManager3"), getProperty("password")},
            };
        } else
            return new Object[][]{{getProperty("usernameTruckDrivers5"), getProperty("password")},
                   {getProperty("usernameTruckDrivers5"), getProperty("password")},
            };
    }

}
