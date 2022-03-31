package tests.shopping_cart;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import tests.logIn.TestData;

public class AddToCart extends BaseTest {
    TestData testData = new TestData();
    LoginPage loginPage = new LoginPage();
    HomePage homePage = new HomePage();

    @Test
    public void logIn() throws InterruptedException{
        openPage(testData.getUrl());
        maximizeWindow();
        waitSomeSeconds(10);
        loginPage.loginAsUser(testData.getUsername(),testData.getPassword());
        waitSomeSeconds(20);
        successfullyAddOneItemToCart();
    }

    private void successfullyAddOneItemToCart(){
        homePage.addOneItemToCart();
        Assert.assertEquals(homePage.getAvailableNoItemsInCart(),"1");
    }
}
