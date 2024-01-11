package com.mypages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.lang.Override;
import java.util.List;

public class BasePage extends Page {

    public BasePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public String getPageTitle() {
        return driver.getTitle();
    }

   @Override
    public String getPageHeader(By locator) {
        return getElement(locator).getText();
    }

    // Wrapper classes
    @Override
    public WebElement getElement(By locator) {
        WebElement element = null;
        try {
            this.waitForElementPresent(locator);
            element = driver.findElement(locator);
            return element;
        } catch (Exception e) {
            System.out.println("some error occurred while finding element: " + locator.toString());
            e.printStackTrace();
        }
        return element;
    }

    @Override
    public List<WebElement> getElements(By locator) {
        List<WebElement> elements = null;
        try {
            this.waitForElementsPresent(locator);
            elements = driver.findElements(locator);
            return elements;
        } catch (Exception e) {
            System.out.println("some error occurred while finding elements: " + locator.toString());
            e.printStackTrace();
        }
        return elements;
    }

    public WebElement getNthElement(List<WebElement> elements, int n) {
        if (n >= 0 && n < elements.size()) {
            return elements.get(n);
        } else {
            return null;
        }
    }

    @Override
    public void waitForURLChange() {
        String originalURL = driver.getCurrentUrl();
        int timeoutInSeconds = 10;
        int pollingIntervalInMillis = 500;
        int elapsedTime = 0;

        while (elapsedTime < timeoutInSeconds * 1000) {
            if (!driver.getCurrentUrl().equals(originalURL)) {
                // URL has changed, break out of the loop
                break;
            }

            try {
                Thread.sleep(pollingIntervalInMillis);
                elapsedTime += pollingIntervalInMillis;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void waitForElementPresent(By locator) {
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        } catch (Exception e) {
            System.out.println("Some error occurred while waiting for the element: " + locator.toString());
        }
    }

    @Override
    public void waitForElementClickable(By locator) {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(locator));
        } catch (Exception e) {
            System.out.println("Some error occurred while clicking the element: " + locator.toString());
        }
    }

    @Override
    public void waitForElementsPresent(By locator) {
        try {
            wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
        } catch (Exception e) {
            System.out.println("Some error occurred while waiting for the element: " + locator.toString());
        }
    }

    @Override
    public void waitForPageTitle(java.lang.String title) {
        try {
            wait.until(ExpectedConditions.titleContains(title));
        } catch (Exception e) {
            System.out.println("some exception occurred while waiting for element: " + title);
        }
    }
}
