package com.vytrack.test;

import com.vytrack.utilities.Driver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

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
}
