package com.org.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AdminPage {
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(xpath = "//h6[@class='oxd-text oxd-text--h6 oxd-topbar-header-breadcrumb-module']")
    private WebElement adminHeader;

    @FindBy(xpath = "//li[@class='oxd-topbar-body-nav-tab --parent --visited']//span[@class='oxd-topbar-body-nav-tab-item']")
    private WebElement userManagementHeader;

    @FindBy(xpath = "//label[ .='User Role']")
    private WebElement rolesHeader;

    @FindBy(xpath = "//i[@class='oxd-icon bi-plus oxd-button-icon']")
    private WebElement addUserButton;

    @FindBy(xpath = "//button[@class='oxd-icon-button oxd-table-cell-action-space']")
    private WebElement deleteUserButton;

    public AdminPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public boolean isAdminHeaderDisplayed() {
        return wait.until(ExpectedConditions.visibilityOf(adminHeader)).isDisplayed();
    }

    public boolean isUserManagementHeaderDisplayed() {
        return wait.until(ExpectedConditions.visibilityOf(userManagementHeader)).isDisplayed();
    }

    public boolean isRolesHeaderDisplayed() {
        return wait.until(ExpectedConditions.visibilityOf(rolesHeader)).isDisplayed();
    }

    public void clickAddUser() {
        wait.until(ExpectedConditions.elementToBeClickable(addUserButton)).click();
    }

    public void clickDeleteUser() {
        wait.until(ExpectedConditions.elementToBeClickable(deleteUserButton)).click();
    }
}
