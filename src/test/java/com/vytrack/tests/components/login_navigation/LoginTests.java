package com.vytrack.tests.components.login_navigation;

import com.vytrack.pages.login_navigation.LoginPage;
import com.vytrack.utilities.ConfigurationReader;
import com.vytrack.utilities.SeleniumUtils;
import com.vytrack.utilities.TestBase;
import com.vytrack.utilities.VYTrackUtils;
import org.testng.Assert;
import org.testng.annotations.Test;
public class LoginTests extends TestBase {
    @Test
    public void loginTest1(){
        //this is required, otherwise you will get null pointer exception
        extentLogger = report.createTest("Login as a store manager");
        //we are instantiating page class inside a tests class,
        //because for second test, if we run all tests in a row, driver will have null session
        LoginPage loginPage = new LoginPage();
        String username = ConfigurationReader.getProperty("storemanagerusername");
        String password = ConfigurationReader.getProperty("storemanagerpassword");
        extentLogger.info("Clicking on remember me");
        loginPage.clickRememberMe();
        loginPage.login(username, password);
        //to verify that Dashboard page opened
        //Once page name Dashboard displays, means that we are logged successfully
        Assert.assertEquals(VYTrackUtils.getPageSubTitle(), "Dashboard");
        extentLogger.pass("Verified that page name is Dashboard");
    }
    @Test
    public void negativeLoginTest1(){
        extentLogger = report.createTest("Login with invalid credentials");
        LoginPage loginPage = new LoginPage();
        extentLogger.info("Logging with username: wrongusername, and password: wrongpassword");
        loginPage.login("wrongusername", "wrongpassword");
        Assert.assertEquals(loginPage.getErrorMessage(), "Invalid user name or password.");
        extentLogger.pass("Verified that warning message displayed: Invalid user name or password.");
    }
}
