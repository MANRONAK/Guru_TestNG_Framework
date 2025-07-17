package utilities;

import base.BaseClass;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.FileNotFoundException;

public class ScreenShot  {
    public static File captureSS(WebDriver driver) throws FileNotFoundException {
        TakesScreenshot driver1 = (TakesScreenshot) driver;
        File screenshotAs = driver1.getScreenshotAs(OutputType.FILE);
        return screenshotAs;
    }
}
