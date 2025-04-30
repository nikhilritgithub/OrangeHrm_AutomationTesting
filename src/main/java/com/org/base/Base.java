package com.org.base;

import com.org.pages.LoginPage;
import com.org.pages.HomePage;
import com.org.pages.AdminPage;
import com.org.util.ConfigReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class Base {
    protected WebDriver driver;
    protected ConfigReader configReader;
    protected LoginPage loginPage;
    protected HomePage homePage;
    protected AdminPage adminPage;

    @BeforeClass
    public void setUp() {
        configReader = new ConfigReader();
        String browser = configReader.getBrowser();

        if (browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("edge")) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        }

        driver.manage().window().maximize();
        driver.get(configReader.getUrl());

        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        adminPage = new AdminPage(driver);
    }

    public void login() {
        loginPage.enterUsername(configReader.getUsername());
        loginPage.enterPassword(configReader.getPassword());
        loginPage.clickLogin();
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
