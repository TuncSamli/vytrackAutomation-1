package com.vytrack.test;

import com.vytrack.utilities.BrowserUtils;
import com.vytrack.utilities.VyTrack_Login;
import com.vytrack.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

import static com.vytrack.utilities.ConfigurationReader.getProperty;

public class US_58_AutomationForAC1 {
    WebDriver driver;

    @BeforeMethod
    public void  setUpMethod(){
        driver = WebDriverFactory.getDriver(getProperty("browser"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(getProperty("env"));
    }
    @DataProvider(name="provider")
    public Object [][] dpMthd() {
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
    public void VyLogin(String name,String password) {
        VyTrack_Login.login(driver, getProperty(name),getProperty(password));
       driver.findElement(By.xpath("//li[@class='dropdown dropdown-level-1 first']/following-sibling::li[1]")).click();
        BrowserUtils.sleep(2);
        driver.findElement(By.xpath("//span[text()='Vehicle Contracts']")).click();
        BrowserUtils.sleep(3);
        String expectedUrl="https://qa2.vytrack.com/entity/Extend_Entity_VehicleContract";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl,expectedUrl);


    }
@AfterMethod
    public  void closeout(){
        driver.close();
}
}

