package com.mypages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage {
    public HomePage(WebDriver driver) {
        super(driver);
    }

    private By searchBarLocator = By.id("APjFqb");
    private By googleSearchButtonLocator = By.name("btnK");

    public WebElement getSearchBar() {
        waitForElementClickable(searchBarLocator);
        return getElement(searchBarLocator);
    }
    public WebElement getGoogleSearchButton() {
        waitForElementClickable(googleSearchButtonLocator);
        return getElement(googleSearchButtonLocator);
    }

    public String getHomePageTitle() {
        return getPageTitle();
    }

    public SearchResultsListPage searchText(String searchKey) {
        getSearchBar().sendKeys(searchKey);
        getGoogleSearchButton().click();
        return getInstance(SearchResultsListPage.class);
    }
}
