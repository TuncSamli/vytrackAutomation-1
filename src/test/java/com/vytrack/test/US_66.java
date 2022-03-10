package com.vytrack.test;

import com.vytrack.utilities.BrowserUtils;
import com.vytrack.utilities.VytrackUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.*;
import java.util.stream.Collectors;

import static com.vytrack.utilities.ConfigurationReader.getProperty;
import static com.vytrack.utilities.Driver.getDriver;

public class US_66 extends TestBase{
    @Test(dataProvider="VyTrackCredentials",dataProviderClass = TestBase.class,priority = 1)
    public void AC1_OdoCheckStoreManager(String username,String password) {
        VytrackUtils.login(getProperty(username),getProperty(password));
        BrowserUtils.sleep(2);
        Actions action=new Actions(getDriver());
        BrowserUtils.sleep(2);
        action.moveToElement(getDriver().findElement(By.xpath("//li[@class='dropdown dropdown-level-1 first']/following-sibling::li[2]"))).click().perform();
        BrowserUtils.sleep(2);
        getDriver().findElement(By.xpath("//a[.='Accounts']/span")).click();
        BrowserUtils.sleep(2);
        getDriver().findElement(By.xpath("//a[@title='Filters']")).click();
        List<WebElement>filterBtn=new ArrayList<>(getDriver().findElements(By.xpath("//div[contains(@class,'btn filter-criteria-selector')]")));
        List<String> actualBtnTexts=new ArrayList<>();
        BrowserUtils.sleep(2);
        List<String>expected=new ArrayList<>(Arrays.asList("Account Name","Contact Name","Contact Email","Contact Phone","Owner","Business Unit","Created At","Updated At"));
        BrowserUtils.sleep(2);
        actualBtnTexts=filterBtn.stream().limit(8).map(p->p.getText().substring(0,p.getText().length()-5)).collect(Collectors.toList());
        BrowserUtils.sleep(2);
        Assert.assertEquals(actualBtnTexts,expected);
    }
    @Test(dataProvider="VyTrackCredentials",dataProviderClass = TestBase.class,priority = 2)
    public void AC1_OdoCheckSalesManager(String username,String password) {
        VytrackUtils.login(getProperty(username),getProperty(password));
        BrowserUtils.sleep(2);
        Actions action=new Actions(getDriver());
        BrowserUtils.sleep(2);
        action.moveToElement(getDriver().findElement(By.xpath("//li[@class='dropdown dropdown-level-1 first']/following-sibling::li[2]"))).click().perform();
        BrowserUtils.sleep(2);
        getDriver().findElement(By.xpath("//a[.='Accounts']/span")).click();
        BrowserUtils.sleep(2);
        getDriver().findElement(By.xpath("//a[@title='Filters']")).click();
        List<WebElement>filterBtn=new ArrayList<>(getDriver().findElements(By.xpath("//div[contains(@class,'btn filter-criteria-selector')]")));
        List<String> actualBtnTexts=new ArrayList<>();
        BrowserUtils.sleep(2);
        List<String>expected=new ArrayList<>(Arrays.asList("Account Name","Contact Name","Contact Email","Contact Phone","Owner","Business Unit","Created At","Updated At"));
        BrowserUtils.sleep(2);
        actualBtnTexts=filterBtn.stream().limit(8).map(p->p.getText().substring(0,p.getText().length()-5)).collect(Collectors.toList());
        BrowserUtils.sleep(2);
        Assert.assertEquals(actualBtnTexts,expected);
    }
}

