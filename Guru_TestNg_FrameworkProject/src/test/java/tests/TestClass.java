package tests;

import base.BaseClass;
import com.beust.ah.A;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.MobilePage;
import pages.ShoppingCartPage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TestClass extends BaseClass {

    HomePage homePage;
    LoginPage loginPage;
    MobilePage mobilePage;
    ShoppingCartPage shoppingCartPage;

    @BeforeClass
    public void setUp() {
        setDriver();
        homePage = new HomePage(driver);
        loginPage=new LoginPage(driver);
        mobilePage =new MobilePage(driver);
        shoppingCartPage=new ShoppingCartPage(driver);
    }

    @Test(priority = 1)
    public void testClickAccountLink() {
        homePage.clickAccountLink();
    }

    @Test(dependsOnMethods = "testClickAccountLink",priority = 2)
    public void testClickOnloginLink() {
        homePage.clickOnloginLink();
    }
    @Test(priority = 3)
    public void loginUser(){
        loginPage.loginUser();
    }
    @Test(priority = 4)
    public void validateLoginPage(){
        boolean myDashboard = loginPage.getMyDashboard();
        Assert.assertTrue(myDashboard);
    }
    @Test(priority = 5)
    public void clickOnMobileLink(){
        loginPage.clickOnMobileLink();
    }
    @Test(priority = 6)
    public void validateMobilePageTitle(){
        String mobilePageTitle = mobilePage.getMobilePageTitle();
        String expected="MOBILE";
        Assert.assertEquals(mobilePageTitle,expected);
    }
    @Test(priority = 7)
    public void selectNameFromDropDown(){
        mobilePage.clickOnselectDropDown();
    }
    @Test(priority = 8)
    public void getMobileList(){
        List<String> actual = Arrays.asList("IPHONE", "SAMSUNG GALAXY", "SONY XPERIA");
        List<WebElement> mobilePageList = mobilePage.getMobilePageList();
        List<String> list=new ArrayList<>();
        for(WebElement el :mobilePageList){
            list.add(el.getText());
        }
        Collections.sort(list);
        Assert.assertTrue(list.equals(actual));
    }
    @Test(priority = 9)
    public void clickOnCart(){
        mobilePage.clickOnCart();
    }
    @Test(priority = 10)
    public void getCartPageTitle(){
        String expected="SHOPPING CART";
        String cartPageTitle = shoppingCartPage.getCartPageTitle();
        Assert.assertEquals(cartPageTitle,expected);
    }
    @Test(priority = 11)
    public void setMobileQuantity(){
        shoppingCartPage.clickOnMobileQuantity("1000");
    }
    @Test(priority = 12)
    public void clickOnUpdatebutton(){
        shoppingCartPage.clickUpdateButton();
    }
    @Test(priority = 13)
    public void validateErrorMsg(){
        String errorMsg = shoppingCartPage.getErrorMsg();
        Assert.assertTrue(errorMsg.contains("The maximum quantity allowed"));
    }

    @AfterClass
    public void quitDriver() {
        tearDown();
    }
}
