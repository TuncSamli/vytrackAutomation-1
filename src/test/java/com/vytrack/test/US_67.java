package com.vytrack.test;

import com.vytrack.utilities.BrowserUtils;
import com.vytrack.utilities.ConfigurationReader;
import com.vytrack.utilities.VyTrack_Login;
import com.vytrack.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

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
        VyTrack_Login.login(driver, username, password);
        BrowserUtils.sleep(2);
        WebElement fleetTabElm = driver.findElement(By.xpath("//*[@id=\"main-menu\"]/ul/li[1]/a/span"));
        Assert.assertTrue(fleetTabElm.isDisplayed(), "Fleet tab is not displayed on the webpage after log in");
            //step2:
        fleetTabElm.click();
            //step3:
        WebElement vehicleCostsOption = driver.findElement(By.xpath("//*[@id=\"main-menu\"]/ul/li[1]/div/div/ul/li[5]/a/span"));
        vehicleCostsOption.click();
        WebElement typeColumn = driver.findElement(By.xpath("//thead[@class='grid-header']//th[1]//span[.='Type']"));
        Assert.assertTrue(typeColumn.isDisplayed(), "Type column is not displayed on the Vehicle Costs page");
        WebElement totalPriceColumn = driver.findElement(By.xpath("//thead[@class='grid-header']//th[2]//span[.='Total Price']"));
        Assert.assertTrue(totalPriceColumn.isDisplayed(), "Total price column is not displayed on the Vehicle Costs page");
        WebElement dateColumn = driver.findElement(By.xpath("//thead[@class='grid-header']//th[3]//span[.='Date']"));
        Assert.assertTrue(dateColumn.isDisplayed(), "Date column is not displayed on the Vehicle Costs page");
        //AC #2: users check the first checkbox to check all the Vehicle Costs
        //There is no first check box on the user TruckDrivers
    }


















}
