package com.mypages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

public abstract class Page {

    WebDriver driver;
    WebDriverWait wait;

    public  Page(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(this.driver, Duration.ofSeconds(10)); // explicit wait
    }

    //abstract methods - without method body
    // Rule that every page should have these methods
    public abstract String getPageTitle();

    public abstract String getPageHeader(By locator);

    public abstract WebElement getElement(By locator);

    public abstract List<WebElement> getElements(By locator);

    public abstract void waitForURLChange();

    public abstract void waitForElementPresent(By locator);

    public abstract void waitForElementClickable(By locator);

    public abstract void waitForElementsPresent(By locator);

    public abstract void waitForPageTitle(String title);

    //Using generics
    //At runtime, whatever the page class we are passing, we are passing the webdriver instance and creating object of that class
    //newInstance is used to create the object
    public <TPage extends BasePage> TPage getInstance(Class<TPage> pageClass) {
        try {
            return pageClass.getDeclaredConstructor(WebDriver.class).newInstance(this.driver);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
