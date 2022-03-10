package com.vytrack.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class VyTrack_Login{
        public static void login(WebDriver driver, String username, String password){
            WebElement user=driver.findElement(By.id("prependedInput"));
            user.clear();
            user.sendKeys(username);
            WebElement pass=driver.findElement(By.id("prependedInput2"));
            pass.clear();
            pass.sendKeys(password);

            ScreenShoot.screenShot(username+"_Login_Page");

            driver.findElement(By.id("_submit")).click();

        }
    }

