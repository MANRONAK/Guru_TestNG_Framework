package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class MobilePage {
    WebDriver driver;
    public MobilePage(WebDriver driver) {
        this.driver=driver;
    }

    By mobilePageTitle=By.xpath("//div[@class=\"page-title category-title\"]/h1[text()=\"Mobile\"]");
    By selectDropDown=By.xpath("//select[@title=\"Sort By\"]");
    By mobileList=By.xpath("//h2[@class=\"product-name\"]");
    By addToCartMobile=By.xpath("(//span[text()=\"Add to Cart\"])[1]");

    public String getMobilePageTitle(){
        WebElement element = driver.findElement(mobilePageTitle);
        String text = element.getText();
        return text;
    }
    public void clickOnselectDropDown(){
        WebElement element = driver.findElement(selectDropDown);
        Select select=new Select(element);
        select.selectByVisibleText("Name");
    }
    public List<WebElement> getMobilePageList(){
        List<WebElement> elements = driver.findElements(mobileList);
        return elements;
    }
    public ShoppingCartPage clickOnCart(){
        WebElement element = driver.findElement(addToCartMobile);
        element.click();
        return new ShoppingCartPage(driver);
    }

}
