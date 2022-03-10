package com.vytrack.test;

import com.vytrack.utilities.BrowserUtils;
import com.vytrack.utilities.VyTrack_Login;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static com.vytrack.utilities.ConfigurationReader.getProperty;
import static com.vytrack.utilities.Driver.getDriver;

public class US_58_AutomationForAC1 {
    @DataProvider(name = "provider")
    public Object[][] dpMthd() {
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
    public void VyLogin(String username, String password) throws Exception {
        VyTrack_Login.login(getDriver(), getProperty(username),getProperty(password));
        getDriver().findElement(By.xpath("//li[@class='dropdown dropdown-level-1 first']/following-sibling::li[1]")).click();
        BrowserUtils.sleep(2);
        getDriver().findElement(By.xpath("//span[text()='Vehicle Contracts']")).click();
        BrowserUtils.sleep(2);
        String actualTitle = getDriver().getTitle();
        String expectedTitle = "All - Vehicle Contract - Entities - System - Car - Entities - System";
        Assert.assertEquals(actualTitle, expectedTitle);
        BrowserUtils.sleep(3);
        String expectedUrl = "https://qa1.vytrack.com/entity/Extend_Entity_VehicleContract";
        String actualUrl = getDriver().getCurrentUrl();
         Assert.assertEquals(actualUrl, expectedUrl);
         System.out.println("Current URL is: " + actualUrl);

        System.out.println("Current title has been verified and is: " + actualTitle);
        screenShot();

    }
    public void screenShot() {
        try{
            Robot robot = new Robot();

            //downcast the driver to access TakesScreenshot method
            TakesScreenshot ts = (TakesScreenshot) getDriver();
            Rectangle rectangle = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
            BufferedImage bufferedImage = robot.createScreenCapture(rectangle);
            //capture screenshot as output type FILE
            File file = ts.getScreenshotAs(OutputType.FILE);


            //save the screenshot taken in destination path
            //C:\Users\BitFenix\Desktop


            FileUtils.copyFile(file, new File("C:\\Users\\BitFenix\\Desktop\\Screenshot\\Test1_Login.png"));
        } catch (AWTException| IOException e) {
            e.printStackTrace();
        }
        System.out.println("the login page screenshot is taken");
    }
}


