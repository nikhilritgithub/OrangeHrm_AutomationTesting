package com.org.testpages;

import com.org.base.Base;
import com.org.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginPageTest extends Base {
    private LoginPage loginPage;

    @BeforeClass
    public void setUpPage() {
        setUp(); 
        login();
        loginPage = new LoginPage(driver);
        
    }

    @Test(priority = 1)
    public void verifyPageTitle() {
        String title = driver.getTitle();
        Assert.assertEquals(title, "OrangeHRM");
    }

    @Test(priority = 2)
    public void verifyLogoIsVisible() {
        Assert.assertTrue(loginPage.isLogoVisible(), "Logo is not visible");
    }

    @Test(priority = 3)
    public void verifySignInTextIsEnabled() {
        Assert.assertTrue(loginPage.isSignInTextEnabled(), "'Sign In' button is not enabled");
    }

    @Test(priority = 4)
    public void testInvalidLogin() {
        loginPage.enterUsername("invalidUser");
        loginPage.enterPassword("invalidPass");
        loginPage.clickLogin();
        // Verify error message for invalid login
        Assert.assertTrue(driver.getPageSource().contains("Invalid credentials"), "Error message not displayed for invalid login");
    }

    @Test(priority = 5)
    public void testValidLogin() {
        loginPage.enterUsername(configReader.getUsername());
        loginPage.enterPassword(configReader.getPassword());
        loginPage.clickLogin();
        // Assert login success by checking the welcome message on the home page
        Assert.assertTrue(driver.getTitle().contains("Dashboard"), "Login failed; Dashboard not displayed");
    }

    @AfterClass
    public void tearDown() {
        super.tearDown();
    }
}
