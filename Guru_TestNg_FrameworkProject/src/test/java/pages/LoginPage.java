package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.Config_Properties;

public class LoginPage {
    WebDriver driver;
    Config_Properties configProperties =new Config_Properties();

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    By userEmail = By.id("email");
    By userPass = By.id("pass");
    By submitButton = By.id("send2");
    By myDashboard=By.xpath("//h1[text()=\"My Dashboard\"]");
    By mobileLink=By.xpath("//a[text()=\"Mobile\"]");

    public void loginUser() {
        WebElement element = driver.findElement(userEmail);
        element.sendKeys(configProperties.getProperties("userEmail"));
        WebElement element1 = driver.findElement(userPass);
        element1.sendKeys(configProperties.getProperties("userPassword"));
        WebElement element2 = driver.findElement(submitButton);
        element2.click();
    }
    public boolean getMyDashboard(){
        WebElement element = driver.findElement(myDashboard);
        System.out.println(element.getText());
       return  element.getText().contains("MY DASHBOARD");
    }
    public MobilePage clickOnMobileLink(){
        WebElement element = driver.findElement(mobileLink);
        element.click();
        return new MobilePage(driver);
    }
}
