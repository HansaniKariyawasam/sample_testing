package tests.logIn;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

public class SuccessFlow extends BaseTest {
    TestData testData = new TestData();
    LoginPage loginPage = new LoginPage();

    @Test
    public void logIn() throws InterruptedException{
        openPage(testData.getUrl());
        maximizeWindow();
        waitSomeSeconds(10);
        loginPage.loginAsUser(testData.getUsername(),testData.getPassword());
        waitSomeSeconds(10);
        Assert.assertTrue(loginPage.isHomePageLoaded());
    }
}
