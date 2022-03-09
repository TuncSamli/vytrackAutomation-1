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
        if (VY.getName().equals("AC1_OdoCheckStoreManager")) {
            return new Object[][]{{"usernameStoreManager1", "password","You do not have permission to perform this action."},
                    {"usernameStoreManager2", "password","You do not have permission to perform this action."},
                    {"usernameStoreManager3","password","You do not have permission to perform this action."},
                    {"usernameStoreManager4","password","You do not have permission to perform this action."},
                    {"usernameStoreManager5","password","You do not have permission to perform this action."},
                    {"usernameStoreManager6","password","You do not have permission to perform this action."},
            };
        } else if(VY.getName().equals("AC1_OdoCheckSalesManager")){
            return new Object[][]{{"usernameSalesManager1","password","You do not have permission to perform this action."},
                    {"usernameSalesManager2","password","You do not have permission to perform this action."},
                    {"usernameSalesManager3","password","You do not have permission to perform this action."},
                    {"usernameSalesManager4","password","You do not have permission to perform this action."},

        };}else
            return new Object[][]{{"usernameTruckDrivers1", "password"},
                   {"usernameTruckDrivers2", "password"},
                    {"usernameTruckDrivers3", "password"},
                    {"usernameTruckDrivers4", "password"},
                    {"usernameTruckDrivers5", "password"},
                    {"usernameTruckDrivers6", "password"},
                    {"usernameTruckDrivers7", "password"},
            };
    }
}