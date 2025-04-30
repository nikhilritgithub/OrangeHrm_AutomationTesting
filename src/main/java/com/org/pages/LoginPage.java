package com.org.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(xpath = "//input[@name='username']")
    private WebElement usernameField;

    @FindBy(xpath = "//input[@name='password']")
    private WebElement passwordField;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement loginButton;

    @FindBy(xpath = "//div[@class='orangehrm-login-logo']//img")
    private WebElement logo;

    @FindBy(xpath = "//button[.=' Login ']")
    private WebElement signInText;

    @FindBy(xpath = "//p[.='Forgot your password? ']")
    private WebElement forgotPasswordLink;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public void enterUsername(String username) {
        wait.until(ExpectedConditions.visibilityOf(usernameField)).clear();
        usernameField.sendKeys(username);
    }

    public void enterPassword(String password) {
        wait.until(ExpectedConditions.visibilityOf(passwordField)).clear();
        passwordField.sendKeys(password);
    }

    public void clickLogin() {
        wait.until(ExpectedConditions.elementToBeClickable(loginButton)).click();
    }

    public boolean isLogoVisible() {
        return wait.until(ExpectedConditions.visibilityOf(logo)).isDisplayed();
    }

    public boolean isSignInTextEnabled() {
        return wait.until(ExpectedConditions.visibilityOf(signInText)).isEnabled();
    }

    public boolean isForgotPasswordVisible() {
        return wait.until(ExpectedConditions.visibilityOf(forgotPasswordLink)).isDisplayed();
    }
}
