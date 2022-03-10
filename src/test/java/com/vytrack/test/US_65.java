package com.vytrack.test;
import com.vytrack.utilities.BrowserUtils;
import com.vytrack.utilities.ConfigurationReader;
import com.vytrack.utilities.Driver;
import com.vytrack.utilities.VytrackUtils;
import org.apache.hc.core5.util.Asserts;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.vytrack.utilities.ConfigurationReader.getProperty;
import static com.vytrack.utilities.Driver.closeDriver;
import static com.vytrack.utilities.Driver.getDriver;
import static com.vytrack.utilities.VytrackUtils.waitTillLoaderMaskDisappear;
import static org.testng.Assert.assertEquals;

public class US_65 extends TestBase {


    @Test(dataProvider="VyTrackCredentials",dataProviderClass = TestBase.class,priority = 1)
    public void AC1_OdoCheckStoreManager(String username,String password){
        VytrackUtils.login(getProperty(username),getProperty(password));
        waitTillLoaderMaskDisappear();
        Actions action=new Actions(getDriver());
        BrowserUtils.sleep(1);
        action.moveToElement(getDriver().findElement(By.xpath("//li[@class='dropdown dropdown-level-1 first']/following-sibling::li"))).perform();
        BrowserUtils.sleep(1);
        getDriver().findElement(By.xpath("//span[.='Vehicle Odometer']")).click();
        BrowserUtils.sleep(1);
        WebElement errorMessage=getDriver().findElement(By.xpath("//*[@id=\"flash-messages\"]//div[2]/div"));
        BrowserUtils.sleep(1);
        String actual=errorMessage.getText();
        String expected="You do not have permission to perform this action.";
        assertEquals(actual,expected);
    }
    @Test(dataProvider="VyTrackCredentials",dataProviderClass = TestBase.class,priority = 2)
    public void AC1_OdoCheckSalesManager(String username,String password){
        VytrackUtils.login(getProperty(username),getProperty(password));
        BrowserUtils.sleep(1);
        Actions action=new Actions(getDriver());
        BrowserUtils.sleep(1);
        action.moveToElement(getDriver().findElement(By.xpath("//li[@class='dropdown dropdown-level-1 first']/following-sibling::li"))).perform();
        BrowserUtils.sleep(1);
        getDriver().findElement(By.xpath("//span[.='Vehicle Odometer']")).click();
        BrowserUtils.sleep(1);
        WebElement errorMessage=getDriver().findElement(By.xpath("//*[@id=\"flash-messages\"]//div[2]/div"));
        BrowserUtils.sleep(1);
        String actual=errorMessage.getText();
        String expected="You do not have permission to perform this action.";
        assertEquals(actual,expected);
    }

    @Test(dataProvider ="VyTrackCredentials",dataProviderClass = TestBase.class,priority = 3)
    public void AC2_OdoCheckTruckDriver(String username,String password){
        getDriver().get(getProperty("env"));
        VytrackUtils.login(getProperty(username),getProperty(password));
        BrowserUtils.sleep(2);
        Actions action=new Actions(getDriver());
        action.moveToElement(getDriver().findElement(By.xpath("//*[@id=\"main-menu\"]/ul/li[1]/a/span"))).perform();
        getDriver().findElement(By.xpath("//span[.='Vehicle Odometer']")).click();
        BrowserUtils.sleep(2);
        Assert.assertTrue(getDriver().findElement(By.xpath("//input[@value='1']")).isDisplayed());
    }
    @Test(dataProvider ="VyTrackCredentials",dataProviderClass = TestBase.class,priority = 4)
    public void AC3_OdoCheckPageTruckDriver(String username,String password){
        getDriver().get(getProperty("env"));
        VytrackUtils.login(getProperty(username),getProperty(password));
        BrowserUtils.sleep(2);
        Actions action=new Actions(getDriver());
        action.moveToElement(getDriver().findElement(By.xpath("//*[@id=\"main-menu\"]/ul/li[1]/a/span"))).perform();
        getDriver().findElement(By.xpath("//span[.='Vehicle Odometer']")).click();
        BrowserUtils.sleep(2);
        String expected="25";
        BrowserUtils.sleep(2);
        Assert.assertEquals(getDriver().findElement(By.xpath("//button[@class='btn dropdown-toggle ']")).getText(),expected);
    }
}
