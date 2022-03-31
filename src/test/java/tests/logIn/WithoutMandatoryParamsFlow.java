package tests.logIn;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

public class WithoutMandatoryParamsFlow extends BaseTest {
    TestData testData = new TestData();
    LoginPage loginPage = new LoginPage();

    @Test
    public void logInWithoutUsername(){
        openPage(testData.getUrl());
        maximizeWindow();
        waitSomeSeconds(10);
        loginPage.loginAsUser("",testData.getPassword());
        Assert.assertEquals(loginPage.getErrorMessage(),"Epic sadface: Username is required");
    }

    @Test
    public void logInWithoutPassword(){
        openPage(testData.getUrl());
        maximizeWindow();
        waitSomeSeconds(10);
        loginPage.loginAsUser(testData.getUsername(),"");
        Assert.assertEquals(loginPage.getErrorMessage(),"Epic sadface: Password is required");
    }
}
