package listeners;

import base.BaseClass;
import io.qameta.allure.Allure;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.BeforeClass;
import utilities.ScreenShot;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import static utilities.ScreenShot.captureSS;

public class ListnerClass extends BaseClass implements ITestListener {
    Logger logger = LogManager.getLogger(ListnerClass.class.getName());


    public void onTestStart(ITestResult result) {
        logger.info("Test started" + result.getName());
    }

    public void onTestSuccess(ITestResult result) {
        logger.info("Test passed" + result.getName());

    }

    public void onTestFailure(ITestResult result) {
        logger.error("Test failed" + result.getName() + result.getThrowable());
        Object instance = result.getInstance();
        if (instance instanceof BaseClass) {

            WebDriver driver1 = ((BaseClass) instance).getDriver();
            File file = null;
            try {
                file = captureSS(driver1);
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
            try {
                FileInputStream fileInputStream = new FileInputStream(file);
                Allure.addAttachment("SS", fileInputStream);
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        }

    }

    public void onTestSkipped(ITestResult result) {
        logger.warn("Test failed" + result.getName());
    }

    public void onStart(ITestContext context) {
        logger.info("All Test Started" + context.getName());
    }

    public void onFinish(ITestContext context) {
        logger.info("All Tests finised " + context.getName());
    }
}
