package com.vytrack.test;

import com.vytrack.utilities.BrowserUtils;
import com.vytrack.utilities.VyTrack_Login;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

import static com.vytrack.utilities.ConfigurationReader.getProperty;
import static com.vytrack.utilities.Driver.getDriver;

public class US_62_AC1 extends TestBase {

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
        BrowserUtils.sleep(5);


        String expectedRepeatNumber ="1";
         // WebElement repeatEveryBox = getDriver().findElement(By.xpath("//input[@data-validation='{\"NotBlank\":{},\"Number\":{\"min\":1,\"max\":99},\"Type\":{\"type\":\"integer\"}}']"));
         WebElement repeatEveryBox = getDriver().findElement(By.xpath("//div[@class='controls recurrence-subview-control__items']/div/label/input[3]"));

        System.out.println("expectedRepeatNumber = " + expectedRepeatNumber);


        //

        String actualRepeat = repeatEveryBox.getText();

        System.out.println("actualRepeat = " + actualRepeat);

        Assert.assertEquals(actualRepeat,expectedRepeatNumber);

/*
        //downcast the driver to access TakesScreenshot method
        TakesScreenshot ts = (TakesScreenshot) driver;

        //capture screenshot as output type FILE
        File file = ts.getScreenshotAs(OutputType.FILE);

        try {
            //save the screenshot taken in destination path
            FileUtils.copyFile(file, new File("./ScreenShot_Folder/Test1_Login.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("the login page screenshot is taken");
}

 */
    }




}
