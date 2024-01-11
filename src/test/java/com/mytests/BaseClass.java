package com.mytests;

import com.mypages.BasePage;
import com.mypages.Page;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

public class BaseClass {

    WebDriver driver;
    public Page page;

    @BeforeClass
    @Parameters(value = {"browser"})
    public void setUpTest(String browser) {
        if(browser.equals("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if(browser.equals("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else {
            System.out.println("no browser is defined in XML file");
        }

        driver.manage().window().maximize();
        //Can be defined in configuration.properties
        driver.get("https://www.google.com/");

        try {
            Thread.sleep(6000);
        } catch (Exception e) {

        }

        // Passing the created driver to the page class constructor so that it will be given to the base page and other pages
        // As page class is abstract class, we cannot directly create the cosntructor, isntead using the base page
        // We will get null pointer error if this line is missed
        page = new BasePage(driver);
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
