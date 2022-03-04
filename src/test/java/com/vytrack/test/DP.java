package com.vytrack.test;

import org.testng.annotations.DataProvider;

import java.lang.reflect.Method;

import static com.vytrack.utilities.ConfigurationReader.getProperty;

public class DP {
    @DataProvider(name="VyTrackCredentials")
    public Object[][] credentials(Method VY){
        if (VY.getName().equals("")){
            return new Object[][]{{getProperty("usernameStoreManager4"),getProperty("password")},
                    {getProperty("username2"), getProperty("password")},
            };}else
            return new Object[][]{{getProperty("username"),getProperty("password")},
                    {getProperty("username2"), getProperty("password")},
            };
    }
}
