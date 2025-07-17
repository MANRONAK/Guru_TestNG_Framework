package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
    WebDriver driver;
    public  HomePage(WebDriver driver) {
        this.driver=driver;
    }

    By AccountLink=By.xpath("//a[@class='skip-link skip-account']/descendant::span[text()='Account']");
    By loginLink=By.xpath("//a[text()=\"Log In\"]");

    public void clickAccountLink(){
        WebElement element = driver.findElement(AccountLink);
        element.click();
    }
    public LoginPage clickOnloginLink(){
        WebElement element = driver.findElement(loginLink);
        element.click();

        return new LoginPage(driver);
    }
}
