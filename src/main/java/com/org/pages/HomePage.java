package com.org.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(xpath = "//h6[contains(text(), 'Welcome')]")
    private WebElement welcomeMessage;

    @FindBy(xpath = "//a[contains(@href, '/admin')]")
    private WebElement adminMenu;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public boolean isWelcomeMessageDisplayed() {
        return wait.until(ExpectedConditions.visibilityOf(welcomeMessage)).isDisplayed();
    }

    public void clickAdminMenu() {
        wait.until(ExpectedConditions.elementToBeClickable(adminMenu)).click();
    }

    public String getWelcomeMessageText() {
        return welcomeMessage.getText();
    }

    public boolean isAdminMenuEnabled() {
        return wait.until(ExpectedConditions.elementToBeClickable(adminMenu)).isEnabled();
    }
}
