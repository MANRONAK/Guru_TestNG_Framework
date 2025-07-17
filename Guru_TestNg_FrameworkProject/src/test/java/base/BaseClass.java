package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import utilities.Config_Properties;
import utilities.ImplicitlyWait;

import java.time.Duration;


public class BaseClass {


    public WebDriver driver;
    Config_Properties configProperties = new Config_Properties();


    //driver added
    public void setDriver() {
        try {
            if (configProperties.getProperties("driver").equalsIgnoreCase("chrome")) {
                 System.setProperty("webdriver.chrome.driver","src/test/resources/chromedriver.exe");
                driver = new ChromeDriver();

            } else {
                driver = new EdgeDriver();
            }
            driver.get(configProperties.getProperties("browserUrl"));
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(ImplicitlyWait.time_Unit));
        } catch (Exception e) {
            System.out.println("driver not started yet!");
        }
    }
    public WebDriver getDriver(){
        return driver;
    }

    public void tearDown() {
        driver.quit();
    }
}
