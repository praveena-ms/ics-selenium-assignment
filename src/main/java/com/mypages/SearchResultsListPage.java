package com.mypages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SearchResultsListPage extends BasePage {

    public SearchResultsListPage(WebDriver driver) {
        super(driver);
    }

    //Page locators
    private By resultWebLinks = By.xpath("//*[@class='MjjYud']//*[@jscontroller='SC7lYd']//*[@class='LC20lb MBeuO DKV0Md']");

    //public getters: encapsulation
    public WebElement getFirstWebLink() {
        waitForElementsPresent(resultWebLinks);
        return getNthElement(getElements(resultWebLinks), 0);
    }

    //Login and return the next page instance.
    public String clickFirstLink() {
        getFirstWebLink().click();
        waitForURLChange();
        return getPageTitle();
    }
}
