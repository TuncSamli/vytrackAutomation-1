package com.vytrack.test;
import org.testng.annotations.DataProvider;
import java.lang.reflect.Method;
import static com.vytrack.utilities.ConfigurationReader.getProperty;
public class DP {
    @DataProvider(name = "VyTrackCredentials")
    public Object[][] credentials(Method VY) {
        if (VY.getName().equals("AC1_OdoCheck")) {
            return new Object[][]{{getProperty("usernameStoreManager4"), getProperty("password")},
                  //  {getProperty("usernameStoreManager5"), getProperty("password")},
            };
        } else
            return new Object[][]{{getProperty("usernameTruckDrivers5"), getProperty("password")},
                 //   {getProperty("usernameTruckDrivers5"), getProperty("password")},
            };
    }

}
