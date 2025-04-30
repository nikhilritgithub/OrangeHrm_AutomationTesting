package com.org.testpages;

import com.org.base.Base;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class TestBase extends Base {
    @BeforeClass
    public void init() {
        setUp(); // Initialize WebDriver and settings
    }

    @AfterClass
    public void cleanUp() {
        tearDown(); // Quit WebDriver
    }
}
