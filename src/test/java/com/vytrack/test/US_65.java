package com.vytrack.test;
import com.vytrack.utilities.BrowserUtils;
import com.vytrack.utilities.VyTrack_Login;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class US_65 extends DriverLauncher_DP {
    @Test(dataProvider="VyTrackCredentials",dataProviderClass = DriverLauncher_DP.class,priority = 1)
    public void AC1_OdoCheck(String username,String password){
        VyTrack_Login.login(driver,username,password);
        Actions action=new Actions(driver);
        action.moveToElement(driver.findElement(By.xpath("//*[@id=\"main-menu\"]/ul/li[2]/a/span"))).click().perform();
        BrowserUtils.sleep(2);
        driver.findElement(By.xpath("//span[.='Vehicle Odometer']")).click();
        BrowserUtils.sleep(4);
        WebElement errorMessage=driver.findElement(By.xpath("//div[.='You do not have permission to perform this action.']"));
        BrowserUtils.sleep(4);
        String actual=errorMessage.getText();
        String expected="You do not have permission to perform this action.";
        assertEquals(actual,expected);
    }

    @Test(dataProvider ="VyTrackCredentials",dataProviderClass = DriverLauncher_DP.class,priority = 2)
    public void AC2_OdoCheck(String username,String password){
        VyTrack_Login.login(driver,username,password);
    }
    @Test(dataProvider ="VyTrackCredentials",dataProviderClass = DriverLauncher_DP.class,priority = 3)
    public void AC3_OdoCheckPage(String username,String password){
        VyTrack_Login.login(driver,username,password);
    }
}
