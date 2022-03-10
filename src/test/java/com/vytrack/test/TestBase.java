package com.vytrack.test;

import com.vytrack.utilities.Driver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import java.lang.reflect.Method;

import static com.vytrack.utilities.ConfigurationReader.getProperty;

public class TestBase {
    @BeforeMethod
    public void setUp(){
        System.out.println("Test started!");
    }
    @AfterMethod
    public void tearDown(){
        Driver.closeDriver();
    }

    @DataProvider(name = "VyTrackCredentials")
    public static Object[][] credentials(Method VY) {
        if (VY.getName().equals("AC1_OdoCheckStoreManager")) {
            return new Object[][]{{"usernameStoreManager1", "password" },
                    {"usernameStoreManager2", "password"},
                    {"usernameStoreManager3","password" },
                    {"usernameStoreManager4","password" },
                    {"usernameStoreManager5","password" },
                    {"usernameStoreManager6","password" },
            };
        } else if(VY.getName().equals("AC1_OdoCheckSalesManager")){
            return new Object[][]{{"usernameSalesManager1","password" },
                    {"usernameSalesManager2","password" },
                    {"usernameSalesManager3","password" },
                    {"usernameSalesManager4","password" },

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

