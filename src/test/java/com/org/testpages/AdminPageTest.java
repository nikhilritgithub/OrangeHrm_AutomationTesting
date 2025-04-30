package com.org.testpages;

import com.org.base.Base;
import com.org.pages.AdminPage;
import com.org.pages.HomePage;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AdminPageTest extends Base {
	private AdminPage adminPage;
	private HomePage homePage;

	@BeforeClass
	public void setUpPage() {
		setUp();
		login();
		adminPage = new AdminPage(driver);
		homePage = new HomePage(driver);

		homePage.clickAdminMenu();
	}

	@Test(priority = 1)
	public void verifyAdminHeaderDisplayed() {
		Assert.assertTrue(adminPage.isAdminHeaderDisplayed(), "Admin header is not displayed");
	}

	@Test(priority = 2)
	public void verifyUserManagementHeaderDisplayed() {
		Assert.assertTrue(adminPage.isUserManagementHeaderDisplayed(), "User Management header is not displayed");
	}

	@Test(priority = 3)
	public void verifyRolesHeaderDisplayed() {
		Assert.assertTrue(adminPage.isRolesHeaderDisplayed(), "Roles header is not displayed");
	}

	@Test(priority = 4)
	public void testAddUserFunctionality() {
		adminPage.clickAddUser();
		// Assertions for the Add User functionality can be added here
	}

	@Test(priority = 5)
	public void testDeleteUserFunctionality() {
		adminPage.clickDeleteUser();
		// Assertions for the Delete User functionality can be added here
	}

	@AfterClass
	public void tearDown() {
		super.tearDown();
	}
}
