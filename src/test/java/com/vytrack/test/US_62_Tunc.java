package com.vytrack.test;

import com.vytrack.utilities.BrowserUtils;
import com.vytrack.utilities.VyTrack_Login;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static com.vytrack.utilities.ConfigurationReader.getProperty;
import static com.vytrack.utilities.Driver.getDriver;


public class US_62_Tunc extends TestBase {
    @DataProvider(name = "provider")
    public Object[][] credentialMethod() {
        return new Object[][]{
                {"usernameTruckDrivers2", "password"},
                {"usernameStoreManager6", "password"},
                {"usernameSalesManager1", "password"},
        };
    }
    @Test(dataProvider = "provider")
    public void vyLogin(String userName, String password) {
        if
        (getProperty(userName).equals("storemanager72") || getProperty(userName).equals("salesmanager275")) {
            VyTrack_Login.login(getDriver(), getProperty(userName), getProperty(password));
            //getDriver().findElement(By.xpath("//li[@class='dropdown dropdown-level-1'][4]")).click();
            getDriver().findElement(By.xpath("/html/body/div[2]/div[2]/header/div[2]/ul/li[5]")).click();
        } else {
            VyTrack_Login.login(getDriver(), getProperty(userName), getProperty(password));
            getDriver().findElement(By.xpath("//*[@id=\"main-menu\"]/ul/li[3]/a/span")).click();//Truck driver
        }
        BrowserUtils.sleep(3);
        getDriver().findElement(By.xpath("//span[text()='Calendar Events']")).click();
        BrowserUtils.sleep(3);
        getDriver().findElement(By.xpath("//a[@title='Create Calendar event']")).click();
        BrowserUtils.sleep(3);
        getDriver().findElement(By.xpath(" //input[@data-name='recurrence-repeat']")).click();
        BrowserUtils.sleep(3);
        WebElement repeatEveryBox = getDriver().findElement(By.xpath("//div[@class='controls recurrence-subview-control__items']//label/input[3]"));
        String expectedRepeatNumber = "1";
        String actualValue = repeatEveryBox.getAttribute("value");
        Assert.assertEquals(actualValue, expectedRepeatNumber);
        BrowserUtils.sleep(3);
        WebElement recurrenceRepeatBox = getDriver().findElement(By.xpath(" //div[@class='controls recurrence-subview-control__items']/div/label/input[3]"));
        recurrenceRepeatBox.clear();
        BrowserUtils.sleep(3);
        WebElement errorMessage = getDriver().findElement(By.xpath("//*[@class=\"validation-failed\"]"));
        System.out.println(errorMessage.getText());
        String actualErrorMessage = errorMessage.getText();
        String expectedErrorMessage = "This value should not be blank.";
        Assert.assertEquals(actualErrorMessage, expectedErrorMessage);
    }
}