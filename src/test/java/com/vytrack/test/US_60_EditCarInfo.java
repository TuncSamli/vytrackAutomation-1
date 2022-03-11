package com.vytrack.test;

import com.github.javafaker.Faker;
import com.vytrack.utilities.BrowserUtils;
import com.vytrack.utilities.Driver;
import com.vytrack.utilities.VytrackUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static com.vytrack.utilities.Driver.getDriver;

public class US_60_EditCarInfo extends TestBase {

    Faker faker = new Faker();
    Actions actions = new Actions(Driver.getDriver());
    JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver(); //down casting to JS

    @DataProvider(name = "US-60_Credentials")
    public Object[][] credentials() {
        return new Object[][]{
                 {"user" + faker.number().numberBetween(191, 197), "UserUser123"},//user191 --- user197
               /*{"storemanager" + faker.number().numberBetween(67, 72), "UserUser123"},//storemanager67  ---  storemanager72
               /*{"salesmanager" + faker.number().numberBetween(275, 278), "UserUser123"}*/}; //salesmanager275 --- salesmanager278

    }

    @Test(dataProvider = "US-60_Credentials")
    public void edit_car_info_test(String usernames, String passwords) {

        VytrackUtils.login(usernames, passwords); //it's for login to homepage
        BrowserUtils.sleep(2);
        //1. Find a Fleet tab and hover on it

        WebElement fleetTabs = Driver.getDriver().findElement(By.xpath("//span[normalize-space()='Fleet' and contains(@class, 'title title-level-1')]"));
        actions.moveToElement(fleetTabs).perform();
        BrowserUtils.sleep(2);

        WebElement vehicles = Driver.getDriver().findElement(By.xpath("//span[.='Vehicles']"));
        vehicles.click();
        BrowserUtils.sleep(2);

        List<WebElement> dots = Driver.getDriver().findElements(By.xpath("//a[.='...']"));

        int num = faker.number().numberBetween(1, dots.size());

        js.executeScript("arguments[0].scrollIntoView(true);", dots.get(num));
        getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        actions.moveToElement(dots.get(num)).pause(1000).click(dots.get(num)).pause(2000).perform();

        Driver.getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);


        WebElement deleteBtn = Driver.getDriver().findElement(By.xpath("//div[@class='dropdown']//li[3]//a"));
        WebElement editBtn = Driver.getDriver().findElement(By.xpath("//div[@class='dropdown']//li[2]//a"));
        WebElement viewBtn = Driver.getDriver().findElement(By.xpath("//div[@class='dropdown']//li[1]//a"));

        String delete = deleteBtn.getAttribute("title");
        String edit = editBtn.getAttribute("title");
        String view = viewBtn.getAttribute("title");

        String expectedDelete = "Delete";
        String expectedEdit = "Edit";
        String expectedView = "View";

        Assert.assertEquals(delete, expectedDelete);
        Assert.assertEquals(edit, expectedEdit);
        Assert.assertEquals(view, expectedView);

    }
}