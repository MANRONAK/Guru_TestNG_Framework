package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ShoppingCartPage {
    WebDriver driver;

    public ShoppingCartPage(WebDriver driver) {
        this.driver = driver;
    }

    By cartPageTitle = By.xpath("//h1[text()=\"Shopping Cart\"]");
    By mobileQuantity = By.xpath("//input[@title=\"Qty\"]");
    By updateButton = By.xpath("//button[@title=\"Update\"]");
    By errorMsg=By.xpath("//p[contains(text(),\"  * The maximum quantity allowed for purchase is 500.            \")]");

    public String getCartPageTitle(){
        WebElement element = driver.findElement(cartPageTitle);
        String text = element.getText();
        return text;
    }
    public void clickOnMobileQuantity(String text){
        WebElement element = driver.findElement(mobileQuantity);
        element.sendKeys(text);
    }
    public void clickUpdateButton(){
        WebElement element = driver.findElement(updateButton);
        element.click();
    }
    public String getErrorMsg(){
        WebElement element = driver.findElement(errorMsg);
        String text = element.getText();
        return text;
    }


}
