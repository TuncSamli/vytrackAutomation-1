package com.vytrack.test;

import com.vytrack.utilities.BrowserUtils;
import com.vytrack.utilities.Driver;
import com.vytrack.utilities.VytrackUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;



public class US_57 extends TestBase{



    @Test
    public void TruckDriver (){
      /*  AC1:when users click click the “Learn how to use this space”
          link on the homepage, users should see:
          “How To Use Pinbar” and
          “Use pin icon on the right top corner of the page to create fast
           access link in the pinbar.”*/
          // VytrackUtils.login(username, password); ==> this is with dataProvider

       VytrackUtils.loginAsDriver();

        BrowserUtils.sleep(5);
        WebElement text = Driver.getDriver().findElement(By.xpath("//a[.='Learn how to use this space']"));
        text.click();
        BrowserUtils.sleep(5);
        WebElement textAfterClick1 = Driver.getDriver().findElement(By.xpath("//h3[.='How To Use Pinbar']"));
        WebElement textAfterClick2 = Driver.getDriver().findElement(By.xpath("//p[1]"));

        Assert.assertEquals(textAfterClick1.getText(),"How To Use Pinbar");
        Assert.assertEquals(textAfterClick2.getText(),
 "Use pin icon on the right top corner of page to create fast access link in the pinbar.");

/*
AC2: users should see an image on the page.
[in automation testing, just verify the image source.]
Expected source:
/bundles/oronavigation/images/pinbar-location.jp
 */

WebElement picture = Driver.getDriver().findElement(By.xpath("//img[@src='/bundles/oronavigation/images/pinbar-location.jpg']"));
        String expected = "/bundles/oronavigation/images/pinbar-location.jp";
        String actual = picture.getAttribute("src");
        Assert.assertTrue(actual.contains(expected));
        Assert.assertTrue(picture.isDisplayed());

}
    @Test
    public void StoreManer (){
      /*  AC1:when users click click the “Learn how to use this space”
          link on the homepage, users should see:
          “How To Use Pinbar” and
          “Use pin icon on the right top corner of the page to create fast
           access link in the pinbar.”*/
        // VytrackUtils.login(username, password); ==> this is with dataProvider

        VytrackUtils.loginAsStoreManager();

        BrowserUtils.sleep(5);
        WebElement text = Driver.getDriver().findElement(By.xpath("//a[.='Learn how to use this space']"));
        text.click();
        BrowserUtils.sleep(5);
        WebElement textAfterClick1 = Driver.getDriver().findElement(By.xpath("//h3[.='How To Use Pinbar']"));
        WebElement textAfterClick2 = Driver.getDriver().findElement(By.xpath("//p[1]"));

        Assert.assertEquals(textAfterClick1.getText(),"How To Use Pinbar");
        Assert.assertEquals(textAfterClick2.getText(),
                "Use pin icon on the right top corner of page to create fast access link in the pinbar.");

/*
AC2: users should see an image on the page.
[in automation testing, just verify the image source.]
Expected source:
/bundles/oronavigation/images/pinbar-location.jp
 */

        WebElement picture = Driver.getDriver().findElement(By.xpath("//img[@src='/bundles/oronavigation/images/pinbar-location.jpg']"));
        String expected = "/bundles/oronavigation/images/pinbar-location.jp";
        String actual = picture.getAttribute("src");
        Assert.assertTrue(actual.contains(expected));
        Assert.assertTrue(picture.isDisplayed());

    }

    @Test
    public void SalesManger (){
      /*  AC1:when users click click the “Learn how to use this space”
          link on the homepage, users should see:
          “How To Use Pinbar” and
          “Use pin icon on the right top corner of the page to create fast
           access link in the pinbar.”*/
        // VytrackUtils.login(username, password); ==> this is with dataProvider

        VytrackUtils.loginAsSalesManager();

        BrowserUtils.sleep(5);
        WebElement text = Driver.getDriver().findElement(By.xpath("//a[.='Learn how to use this space']"));
        text.click();
        BrowserUtils.sleep(5);
        WebElement textAfterClick1 = Driver.getDriver().findElement(By.xpath("//h3[.='How To Use Pinbar']"));
        WebElement textAfterClick2 = Driver.getDriver().findElement(By.xpath("//p[1]"));

        Assert.assertEquals(textAfterClick1.getText(),"How To Use Pinbar");
        Assert.assertEquals(textAfterClick2.getText(),
                "Use pin icon on the right top corner of page to create fast access link in the pinbar.");

/*
AC2: users should see an image on the page.
[in automation testing, just verify the image source.]
Expected source:
/bundles/oronavigation/images/pinbar-location.jp
 */

        WebElement picture = Driver.getDriver().findElement(By.xpath("//img[@src='/bundles/oronavigation/images/pinbar-location.jpg']"));
        String expected = "/bundles/oronavigation/images/pinbar-location.jp";
        String actual = picture.getAttribute("src");
        Assert.assertTrue(actual.contains(expected));
        Assert.assertTrue(picture.isDisplayed());

    }



}



























