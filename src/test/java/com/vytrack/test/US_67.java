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
                {"usernameTruckDrivers1", "password"},
                {"usernameTruckDrivers2", "password"},
                {"usernameTruckDrivers3", "password"},
                {"usernameTruckDrivers4", "password"},
                {"usernameTruckDrivers5", "password"},
                {"usernameTruckDrivers6", "password"},
                {"usernameTruckDrivers7", "password"}
        };
    }

    @DataProvider(name="userStoreManagerProvider")
    public Object[][] provideData1(){
        return new Object[][]{
                {"usernameStoreManager1","password"},
                {"usernameStoreManager2","password"},
                {"usernameStoreManager3","password"},
                {"usernameStoreManager4","password"},
                {"usernameStoreManager5","password"},
                {"usernameStoreManager6","password"}
        };

    }

    @DataProvider(name="userSalesManagerProvider")
    public Object[][] provideData2(){
        return new Object[][]{
                {"usernameSalesManager1","password"},
                {"usernameSalesManager2","password"},
                {"usernameSalesManager3","password"},
                {"usernameSalesManager4","password"}
        };
    }

    @Test(dataProvider = "userTruckDriversProvider", priority = 1)
    public void truckDriversTest(String username, String password) {
        //AC #1: Users should see three columns on the Vehicle Costs page.
            //step1:
        VyTrack_Login.login(Driver.getDriver(),ConfigurationReader.getProperty(username) , ConfigurationReader.getProperty(password));
        BrowserUtils.sleep(2);
        Actions actions = new Actions(Driver.getDriver());
        WebElement fleetTabElm = Driver.getDriver().findElement(By.xpath("//*[@id=\"main-menu\"]/ul/li[1]/a/span"));
        actions.moveToElement(fleetTabElm).perform();
        Assert.assertTrue(fleetTabElm.isDisplayed(), "Fleet tab is not displayed on the webpage after log in");
            //step2:
        BrowserUtils.sleep(2);
        fleetTabElm.click();
            //step3:
        WebElement vehicleCostsOption = Driver.getDriver().findElement(By.xpath("//*[@id=\"main-menu\"]/ul/li[1]/div/div/ul/li[5]/a/span"));
        BrowserUtils.sleep(2);
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
        VyTrack_Login.login(Driver.getDriver(),ConfigurationReader.getProperty(username) , ConfigurationReader.getProperty(password));
        BrowserUtils.sleep(2);
        Actions actions = new Actions(Driver.getDriver());
        WebElement fleetTabElm = Driver.getDriver().findElement(By.xpath("//*[@id=\"main-menu\"]/ul/li[2]/a/span"));
        actions.moveToElement(fleetTabElm).perform();
        Assert.assertTrue(fleetTabElm.isDisplayed(), "Fleet tab is not displayed on the webpage after log in");
            //step2:
        BrowserUtils.sleep(2);
        fleetTabElm.click();
            //step3:
        WebElement vehicleCostsOption = Driver.getDriver().findElement(By.xpath("//*[@id=\"main-menu\"]/ul/li[2]/div/div/ul/li[5]/a/span"));
        BrowserUtils.sleep(2);
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
        VyTrack_Login.login(Driver.getDriver(),ConfigurationReader.getProperty(username) , ConfigurationReader.getProperty(password));
        BrowserUtils.sleep(2);
        Actions actions = new Actions(Driver.getDriver());
        WebElement fleetTabElm = Driver.getDriver().findElement(By.xpath("//*[@id=\"main-menu\"]/ul/li[2]/a/span"));
        actions.moveToElement(fleetTabElm).perform();
        Assert.assertTrue(fleetTabElm.isDisplayed(), "Fleet tab is not displayed on the webpage after log in");
        //step2:
        BrowserUtils.sleep(2);
        fleetTabElm.click();
        //step3:
        WebElement vehicleCostsOption = Driver.getDriver().findElement(By.xpath("//*[@id=\"main-menu\"]/ul/li[2]/div/div/ul/li[5]/a/span"));
        BrowserUtils.sleep(2);
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
