package com.vytrack.test;
import com.vytrack.utilities.BrowserUtils;
import com.vytrack.utilities.ConfigurationReader;
import com.vytrack.utilities.Driver;
import com.vytrack.utilities.VyTrack_Login;
import org.apache.hc.core5.util.Asserts;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.vytrack.utilities.Driver.closeDriver;
import static com.vytrack.utilities.Driver.getDriver;
import static org.testng.Assert.assertEquals;

public class US_65 extends DP {
    @Test(dataProvider="VyTrackCredentials",dataProviderClass = DP.class,priority = 1)
    public void AC1_OdoCheck(String username,String password){
        getDriver().get(ConfigurationReader.getProperty("env"));
        BrowserUtils.sleep(2);
        VyTrack_Login.login(getDriver(),username,password);
        BrowserUtils.sleep(2);
        Actions action=new Actions(getDriver());
        BrowserUtils.sleep(2);
        action.moveToElement(getDriver().findElement(By.xpath("//li[@class='dropdown dropdown-level-1 first']/following-sibling::li"))).click().perform();
        BrowserUtils.sleep(2);
        getDriver().findElement(By.xpath("//span[.='Vehicle Odometer']")).click();
        BrowserUtils.sleep(2);
        WebElement errorMessage=getDriver().findElement(By.xpath("//*[@id=\"flash-messages\"]//div[2]/div"));
        BrowserUtils.sleep(2);
        String actual=errorMessage.getText();
        String expected="You do not have permission to perform this action.";
        assertEquals(actual,expected);
    }

    @Test(dataProvider ="VyTrackCredentials",dataProviderClass = DP.class,priority = 2)
    public void AC2_OdoCheck(String username,String password){
        getDriver().get(ConfigurationReader.getProperty("env"));
        VyTrack_Login.login(getDriver(),username,password);
        BrowserUtils.sleep(2);
        Actions action=new Actions(getDriver());
        action.moveToElement(getDriver().findElement(By.xpath("//*[@id=\"main-menu\"]/ul/li[1]/a/span"))).click().perform();
        getDriver().findElement(By.xpath("//span[.='Vehicle Odometer']")).click();
        BrowserUtils.sleep(2);
        Assert.assertTrue(getDriver().findElement(By.xpath("//input[@value='1']")).isDisplayed());
    }
    @Test(dataProvider ="VyTrackCredentials",dataProviderClass = DP.class,priority = 3)
    public void AC3_OdoCheckPage(String username,String password){
        getDriver().get(ConfigurationReader.getProperty("env"));
        VyTrack_Login.login(getDriver(),username,password);
        BrowserUtils.sleep(2);
        Actions action=new Actions(getDriver());
        action.moveToElement(getDriver().findElement(By.xpath("//*[@id=\"main-menu\"]/ul/li[1]/a/span"))).click().perform();
        getDriver().findElement(By.xpath("//span[.='Vehicle Odometer']")).click();
        BrowserUtils.sleep(2);
        String expected="25";
        BrowserUtils.sleep(2);
        Assert.assertEquals(getDriver().findElement(By.xpath("//button[@class='btn dropdown-toggle ']")).getText(),expected);
    }
}
