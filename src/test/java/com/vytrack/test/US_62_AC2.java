package com.vytrack.test;


import com.vytrack.utilities.BrowserUtils;
import com.vytrack.utilities.Driver;
import com.vytrack.utilities.VyTrack_Login;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static com.vytrack.utilities.ConfigurationReader.getProperty;
import static com.vytrack.utilities.Driver.getDriver;

public class US_62_AC2 extends TestBase {

    @DataProvider(name = "provider")
    public Object[][] credentialMethod() {
        return new Object[][]{
                {"usernameStoreManager1", "password"},
                {"usernameStoreManager2", "password"},
                {"usernameStoreManager3", "password"},
                {"usernameStoreManager4", "password"},
                {"usernameStoreManager5", "password"},
                {"usernameStoreManager6", "password"},
                {"usernameSalesManager1", "password"},
                {"usernameSalesManager2", "password"},
                {"usernameSalesManager3", "password"},
                {"usernameSalesManager4", "password"},
        };
    }

    @Test(dataProvider = "provider")

    public void vyLogin(String userName, String password) {

        VyTrack_Login.login(getDriver(), getProperty(userName), getProperty(password));

        getDriver().findElement(By.xpath("//li[@class='dropdown dropdown-level-1'][4]")).click();
        BrowserUtils.sleep(5);
        getDriver().findElement(By.xpath("//span[text()='Calendar Events']")).click();
        BrowserUtils.sleep(5);
        getDriver().findElement(By.xpath("//a[@title='Create Calendar event']")).click();
        BrowserUtils.sleep(5);
        getDriver().findElement(By.xpath(" //input[@data-name='recurrence-repeat']")).click();
        BrowserUtils.sleep(2);
        WebElement recurrenceRepeatBox = Driver.getDriver().findElement(By.xpath(" //div[@class='controls recurrence-subview-control__items']/div/label/input[3]"));
        recurrenceRepeatBox.clear();
        BrowserUtils.sleep(5);
        WebElement errorMessage = Driver.getDriver().findElement(By.xpath("//*[@id=\"temp-validation-name-454-error\"]"));
        System.out.println(errorMessage.getText());
        String actualErrorMessage = errorMessage.getText();
        String expectedErrorMessage = "This value should not be blank.";
        Assert.assertEquals(actualErrorMessage, expectedErrorMessage);

    }


}
