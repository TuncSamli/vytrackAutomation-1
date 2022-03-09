package com.vytrack.test;

import com.vytrack.utilities.BrowserUtils;
import com.vytrack.utilities.ConfigurationReader;
import com.vytrack.utilities.Driver;
import com.vytrack.utilities.VyTrack_Login;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class US_67 {

    @BeforeTest
    public void openWebsite(){
        Driver.getDriver().get(ConfigurationReader.getProperty("env"));
    }

    @AfterTest
    public void closeWebsite(){
        Driver.closeDriver();
    }

    @DataProvider(name="userTruckDriversProvider")
    public Object[][] provideData(){
        return new Object[][]{
                {ConfigurationReader.getProperty("usernameTruckDrivers1"), ConfigurationReader.getProperty("password")},
                {ConfigurationReader.getProperty("usernameTruckDrivers2"), ConfigurationReader.getProperty("password")},
                {ConfigurationReader.getProperty("usernameTruckDrivers3"), ConfigurationReader.getProperty("password")},
                {ConfigurationReader.getProperty("usernameTruckDrivers4"), ConfigurationReader.getProperty("password")},
                {ConfigurationReader.getProperty("usernameTruckDrivers5"), ConfigurationReader.getProperty("password")},
                {ConfigurationReader.getProperty("usernameTruckDrivers6"), ConfigurationReader.getProperty("password")},
                {ConfigurationReader.getProperty("usernameTruckDrivers7"), ConfigurationReader.getProperty("password")}
        };
    }

    @DataProvider(name="userStoreManagerProvider")
    public Object[][] provideData1(){
        return new Object[][]{
                {ConfigurationReader.getProperty("usernameStoreManager1"), ConfigurationReader.getProperty("password")},
                {ConfigurationReader.getProperty("usernameStoreManager2"), ConfigurationReader.getProperty("password")},
                {ConfigurationReader.getProperty("usernameStoreManager3"), ConfigurationReader.getProperty("password")},
                {ConfigurationReader.getProperty("usernameStoreManager4"), ConfigurationReader.getProperty("password")},
                {ConfigurationReader.getProperty("usernameStoreManager5"), ConfigurationReader.getProperty("password")},
                {ConfigurationReader.getProperty("usernameStoreManager6"), ConfigurationReader.getProperty("password")}
        };

    }

    @DataProvider(name="userSalesManagerProvider")
    public Object[][] provideData2(){
        return new Object[][]{
                {ConfigurationReader.getProperty("usernameSalesManager1"), ConfigurationReader.getProperty("password")},
                {ConfigurationReader.getProperty("usernameSalesManager2"), ConfigurationReader.getProperty("password")},
                {ConfigurationReader.getProperty("usernameSalesManager3"), ConfigurationReader.getProperty("password")},
                {ConfigurationReader.getProperty("usernameSalesManager4"), ConfigurationReader.getProperty("password")}
        };
    }
    @Test(dataProvider = "userTruckDriversProvider" )
    public void truckDriversTest(String username, String password) {
        //AC #1: Users should see three columns on the Vehicle Costs page.
            //step1:

        VyTrack_Login.login(Driver.getDriver(), username, password);
        BrowserUtils.sleep(2);
        WebElement fleetTabElm = Driver.getDriver().findElement(By.xpath("//*[@id=\"main-menu\"]/ul/li[1]/a/span"));
        Assert.assertTrue(fleetTabElm.isDisplayed(), "Fleet tab is not displayed on the webpage after log in");
            //step2:
        fleetTabElm.click();
            //step3:
        WebElement vehicleCostsOption = Driver.getDriver().findElement(By.xpath("//*[@id=\"main-menu\"]/ul/li[1]/div/div/ul/li[5]/a/span"));
        vehicleCostsOption.click();
        WebElement typeColumn = Driver.getDriver().findElement(By.xpath("//thead[@class='grid-header']//th[1]//span[.='Type']"));
        Assert.assertTrue(typeColumn.isDisplayed(), "Type column is not displayed on the Vehicle Costs page");
        WebElement totalPriceColumn = Driver.getDriver().findElement(By.xpath("//thead[@class='grid-header']//th[2]//span[.='Total Price']"));
        Assert.assertTrue(totalPriceColumn.isDisplayed(), "Total price column is not displayed on the Vehicle Costs page");
        WebElement dateColumn = Driver.getDriver().findElement(By.xpath("//thead[@class='grid-header']//th[3]//span[.='Date']"));
        Assert.assertTrue(dateColumn.isDisplayed(), "Date column is not displayed on the Vehicle Costs page");

        //AC #2: users check the first checkbox to check all the Vehicle Costs
        //There is no first check box on the user TruckDrivers

        Driver.closeDriver();

    }


















}
