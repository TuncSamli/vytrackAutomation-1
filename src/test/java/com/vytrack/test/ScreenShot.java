package com.vytrack.test;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static com.vytrack.utilities.Driver.getDriver;

public interface ScreenShot {
    default void screenShot() {
        try{
            Robot robot = new Robot();

            //downcast the driver to access TakesScreenshot method
            TakesScreenshot ts = (TakesScreenshot) getDriver();
            Rectangle rectangle = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
            BufferedImage bufferedImage = robot.createScreenCapture(rectangle);
            //capture screenshot as output type FILE
            File file = ts.getScreenshotAs(OutputType.FILE);


            //save the screenshot taken in destination path
            //C:\Users\BitFenix\Desktop


            FileUtils.copyFile(file, new File("C:\\Users\\BitFenix\\Desktop\\Screenshot\\Test1_Login.png"));
        } catch (AWTException| IOException e) {
            e.printStackTrace();
        }
        System.out.println("the login page screenshot is taken");
    }
}
