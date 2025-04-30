package com.org.testpages;

import com.org.base.Base;
import com.org.pages.AdminPage;
import com.org.pages.HomePage;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class HomePageTest extends Base {

    @BeforeClass
    public void setUpPage() {
        super.setUp();
        login();
        homePage = new HomePage(driver);
        adminPage = new AdminPage(driver);
    }

    @Test(priority = 1)
    public void verifyWelcomeMessageDisplayed() {
        Assert.assertTrue(homePage.isWelcomeMessageDisplayed(), "Welcome message is not displayed");
    }

    @Test(priority = 2)
    public void verifyWelcomeMessageText() {
        Assert.assertEquals(homePage.getWelcomeMessageText(), "Welcome Admin", "Welcome message text is incorrect");
    }

    @Test(priority = 3)
    public void testNavigateToAdminPage() {
        homePage.clickAdminMenu();
        Assert.assertTrue(adminPage.isAdminHeaderDisplayed(), "Admin header is not displayed after navigation");
    }

    @Test(priority = 4)
    public void verifyAdminMenuIsEnabled() {
        Assert.assertTrue(homePage.isAdminMenuEnabled(), "Admin menu is not enabled");
    }

    @Test(priority = 5)
    public void verifyWelcomeMessageAfterLogin() {
        Assert.assertEquals(homePage.getWelcomeMessageText(), "Welcome Admin", "Welcome message is incorrect after login");
    }

    @AfterClass
    public void tearDown() {
        super.tearDown();
    }
}
