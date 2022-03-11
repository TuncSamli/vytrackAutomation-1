package com.vytrack.test;

import com.vytrack.utilities.BrowserUtils;
import com.vytrack.utilities.ConfigurationReader;
import com.vytrack.utilities.Driver;
import com.vytrack.utilities.VyTrack_Login;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class US_57 extends TestBase{


//    @DataProvider(name = "TruckDrivers")
//    public Object[][] provideData1() {
//       return new Object[][]{
//{ConfigurationReader.getProperty("usernameTruckDrivers1"), ConfigurationReader.getProperty("password")},
//
//        };
//    }
//
//   @DataProvider(name="StoreManger")
//    public Object[][] provideData2() {
//       return new Object[][]{
//               {ConfigurationReader.getProperty("usernameStoreManager1"), ConfigurationReader.getProperty("password")},
//
//       };
//   }
//
//   @DataProvider(name="SalesManager")
//    public Object[][] provideData3(){
//        return new Object[][]{
//{ConfigurationReader.getProperty("usernameSalesManager1"), ConfigurationReader.getProperty("password")},
//
//        };
//    }
//


 @DataProvider(name = "provider")
 public Object[][] newOne(){
        return new Object[][]{
                {ConfigurationReader.getProperty("usernameTruckDrivers1"), ConfigurationReader.getProperty("password")},
                {ConfigurationReader.getProperty("usernameStoreManager1"), ConfigurationReader.getProperty("password")},
                {ConfigurationReader.getProperty("usernameSalesManager1"), ConfigurationReader.getProperty("password")},
        };
 }

    @Test(dataProvider = "provider")
    public void vyLogin1 (String username,String password){
      /*  AC1:when users click click the “Learn how to use this space”
          link on the homepage, users should see:
          “How To Use Pinbar” and
          “Use pin icon on the right top corner of the page to create fast
           access link in the pinbar.”*/
        VyTrack_Login.login(Driver.getDriver(),username,password);

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

//    @Test(dataProvider = "StoreManger")
//    public void vyLogin2 (String username,String password){
//      /*  AC1:when users click click the “Learn how to use this space”
//          link on the homepage, users should see:
//          “How To Use Pinbar” and
//          “Use pin icon on the right top corner of the page to create fast
//           access link in the pinbar.”*/
//        VyTrack_Login.login(Driver.getDriver(),username,password);
//
//        BrowserUtils.sleep(5);
//        WebElement text = Driver.getDriver().findElement(By.xpath("//a[.='Learn how to use this space']"));
//        text.click();
//        BrowserUtils.sleep(5);
//        WebElement textAfterClick1 = Driver.getDriver().findElement(By.xpath("//h3[.='How To Use Pinbar']"));
//        WebElement textAfterClick2 = Driver.getDriver().findElement(By.xpath("//p[1]"));
//
//        Assert.assertEquals(textAfterClick1.getText(),"How To Use Pinbar");
//        Assert.assertEquals(textAfterClick2.getText(),
//                "Use pin icon on the right top corner of page to create fast access link in the pinbar.");
//
///*
//AC2: users should see an image on the page.
//[in automation testing, just verify the image source.]
//Expected source:
///bundles/oronavigation/images/pinbar-location.jp
// */
//
//        WebElement picture = Driver.getDriver().findElement(By.xpath("//img[@src='/bundles/oronavigation/images/pinbar-location.jpg']"));
//        String expected = "/bundles/oronavigation/images/pinbar-location.jp";
//        String actual = picture.getAttribute("src");
//        Assert.assertTrue(actual.contains(expected));
//        Assert.assertTrue(picture.isDisplayed());
//
//    }
//
//    @Test(dataProvider = "TruckDrivers")
//    public void vyLogin3 (String username,String password){
//      /*  AC1:when users click click the “Learn how to use this space”
//          link on the homepage, users should see:
//          “How To Use Pinbar” and
//          “Use pin icon on the right top corner of the page to create fast
//           access link in the pinbar.”*/
//        VyTrack_Login.login(Driver.getDriver(),username,password);
//
//        BrowserUtils.sleep(5);
//        WebElement text = Driver.getDriver().findElement(By.xpath("//a[.='Learn how to use this space']"));
//        text.click();
//        BrowserUtils.sleep(5);
//        WebElement textAfterClick1 = Driver.getDriver().findElement(By.xpath("//h3[.='How To Use Pinbar']"));
//        WebElement textAfterClick2 = Driver.getDriver().findElement(By.xpath("//p[1]"));
//
//        Assert.assertEquals(textAfterClick1.getText(),"How To Use Pinbar");
//        Assert.assertEquals(textAfterClick2.getText(),
//                "Use pin icon on the right top corner of page to create fast access link in the pinbar.");
//
///*
//AC2: users should see an image on the page.
//[in automation testing, just verify the image source.]
//Expected source:
///bundles/oronavigation/images/pinbar-location.jp
// */
//
//        WebElement picture = Driver.getDriver().findElement(By.xpath("//img[@src='/bundles/oronavigation/images/pinbar-location.jpg']"));
//        String expected = "/bundles/oronavigation/images/pinbar-location.jp";
//        String actual = picture.getAttribute("src");
//        Assert.assertTrue(actual.contains(expected));
//        Assert.assertTrue(picture.isDisplayed());
//
//    }


}



























