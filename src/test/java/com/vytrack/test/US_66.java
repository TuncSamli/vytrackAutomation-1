package com.vytrack.test;

import com.vytrack.utilities.BrowserUtils;
import com.vytrack.utilities.ConfigurationReader;
import com.vytrack.utilities.VyTrack_Login;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.*;

import static com.vytrack.utilities.Driver.getDriver;

public class US_66 {
    @Test(dataProvider="VyTrackCredentials",dataProviderClass = DP.class,priority = 1)
    public void AC1_OdoCheck(String username,String password) {
        getDriver().get(ConfigurationReader.getProperty("env"));
        BrowserUtils.sleep(2);
        VyTrack_Login.login(getDriver(),username,password);
        BrowserUtils.sleep(2);
        Actions action=new Actions(getDriver());
        BrowserUtils.sleep(2);
        action.moveToElement(getDriver().findElement(By.xpath("//li[@class='dropdown dropdown-level-1 first']/following-sibling::li[2]"))).click().perform();
        BrowserUtils.sleep(2);
        getDriver().findElement(By.xpath("//a[.='Accounts']/span")).click();
        BrowserUtils.sleep(2);
        getDriver().findElement(By.xpath("//a[@title='Filters']")).click();
        List<WebElement>filterBtn=new ArrayList<>(getDriver().findElements(By.xpath("//span[@class='filter-items']/div")));
        filterBtn.remove(filterBtn.size()-1);
        List<String> actualBtnTexts=new ArrayList<>();
        List<String>expected=new ArrayList<>(Arrays.asList("Account Name","Contact Name","Contact Email","Contact Phone","Owner","Business Unit","Created At","Updated At"));
        for (WebElement functions : filterBtn) {
            actualBtnTexts.add(functions.getText().substring(0,functions.getText().length()-5));
        }
        Assert.assertEquals(actualBtnTexts,expected);

    }
}
