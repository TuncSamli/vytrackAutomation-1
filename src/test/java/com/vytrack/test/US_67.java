package com.vytrack.test;

import com.vytrack.utilities.BrowserUtils;
import com.vytrack.utilities.ConfigurationReader;
import com.vytrack.utilities.Driver;
import com.vytrack.utilities.VyTrack_Login;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class US_67 extends TestBase {

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

    @Test(dataProvider = "userTruckDriversProvider", priority = 1)
    public void truckDriversTest(String username, String password) {
        //AC #1: Users should see three columns on the Vehicle Costs page.
            //step1:
        VyTrack_Login.login(Driver.getDriver(), username, password);
        BrowserUtils.sleep(2);
        Actions actions = new Actions(Driver.getDriver());
        WebElement fleetTabElm = Driver.getDriver().findElement(By.xpath("//*[@id=\"main-menu\"]/ul/li[1]/a/span"));
        actions.moveToElement(fleetTabElm).perform();
        Assert.assertTrue(fleetTabElm.isDisplayed(), "Fleet tab is not displayed on the webpage after log in");
            //step2:
        BrowserUtils.sleep(1);
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
        try{
            WebElement firstCheckBox = Driver.getDriver().findElement(By.xpath("//button[@class='btn btn-default btn-small dropdown-toggle']//input[@type='checkbox']"));
            firstCheckBox.click();
        }catch (NoSuchElementException e){
            System.out.println("There is no first check box on the user TruckDrivers");
        }


    }

    @Test(dataProvider = "userStoreManagerProvider", priority = 2)
    public void storeManagerTest(String username, String password){
        //AC #1: Users should see three columns on the Vehicle Costs page.
            //step1:
        VyTrack_Login.login(Driver.getDriver(), username, password);
        BrowserUtils.sleep(2);
        Actions actions = new Actions(Driver.getDriver());
        WebElement fleetTabElm = Driver.getDriver().findElement(By.xpath("//*[@id=\"main-menu\"]/ul/li[2]/a/span"));
        actions.moveToElement(fleetTabElm).perform();
        Assert.assertTrue(fleetTabElm.isDisplayed(), "Fleet tab is not displayed on the webpage after log in");
            //step2:
        BrowserUtils.sleep(1);
        fleetTabElm.click();
            //step3:
        WebElement vehicleCostsOption = Driver.getDriver().findElement(By.xpath("//*[@id=\"main-menu\"]/ul/li[2]/div/div/ul/li[5]/a/span"));
        vehicleCostsOption.click();
        WebElement typeColumn = Driver.getDriver().findElement(By.xpath("//thead[@class='grid-header']//th[2]//span[.='Type']"));
        Assert.assertTrue(typeColumn.isDisplayed(), "Type column is not displayed on the Vehicle Costs page");
        WebElement totalPriceColumn = Driver.getDriver().findElement(By.xpath("//thead[@class='grid-header']//th[3]//span[.='Total Price']"));
        Assert.assertTrue(totalPriceColumn.isDisplayed(), "Total price column is not displayed on the Vehicle Costs page");
        WebElement dateColumn = Driver.getDriver().findElement(By.xpath("//thead[@class='grid-header']//th[4]//span[.='Date']"));
        Assert.assertTrue(dateColumn.isDisplayed(), "Date column is not displayed on the Vehicle Costs page");

        //AC #2: users check the first checkbox to check all the Vehicle Costs
        WebElement firstCheckBox = Driver.getDriver().findElement(By.xpath("//button[@class='btn btn-default btn-small dropdown-toggle']//input[@type='checkbox']"));
        firstCheckBox.click();
        BrowserUtils.sleep(2);
        Assert.assertTrue(firstCheckBox.isSelected(), "First check box is not selected");

    }

    @Test(dataProvider = "userSalesManagerProvider", priority = 3)
    public void salesManagerTest(String username, String password){
        //AC #1: Users should see three columns on the Vehicle Costs page.
        //step1:
        VyTrack_Login.login(Driver.getDriver(), username, password);
        BrowserUtils.sleep(2);
        Actions actions = new Actions(Driver.getDriver());
        WebElement fleetTabElm = Driver.getDriver().findElement(By.xpath("//*[@id=\"main-menu\"]/ul/li[2]/a/span"));
        actions.moveToElement(fleetTabElm).perform();
        Assert.assertTrue(fleetTabElm.isDisplayed(), "Fleet tab is not displayed on the webpage after log in");
        //step2:
        BrowserUtils.sleep(1);
        fleetTabElm.click();
        //step3:
        WebElement vehicleCostsOption = Driver.getDriver().findElement(By.xpath("//*[@id=\"main-menu\"]/ul/li[2]/div/div/ul/li[5]/a/span"));
        vehicleCostsOption.click();
        WebElement typeColumn = Driver.getDriver().findElement(By.xpath("//thead[@class='grid-header']//th[1]//span[.='Type']"));
        Assert.assertTrue(typeColumn.isDisplayed(), "Type column is not displayed on the Vehicle Costs page");
        WebElement totalPriceColumn = Driver.getDriver().findElement(By.xpath("//thead[@class='grid-header']//th[2]//span[.='Total Price']"));
        Assert.assertTrue(totalPriceColumn.isDisplayed(), "Total price column is not displayed on the Vehicle Costs page");
        WebElement dateColumn = Driver.getDriver().findElement(By.xpath("//thead[@class='grid-header']//th[3]//span[.='Date']"));
        Assert.assertTrue(dateColumn.isDisplayed(), "Date column is not displayed on the Vehicle Costs page");

        //AC #2: users check the first checkbox to check all the Vehicle Costs
        // There is no first check box on sales manager users
        try{
            WebElement firstCheckBox = Driver.getDriver().findElement(By.xpath("//button[@class='btn btn-default btn-small dropdown-toggle']//input[@type='checkbox']"));
            firstCheckBox.click();
        }catch (NoSuchElementException e){
            System.out.println("There is no first check box on the user sales managers");
        }

    }


















}
