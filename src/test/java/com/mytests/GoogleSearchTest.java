package com.mytests;

import com.mypages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GoogleSearchTest extends BaseClass {

    @Test
    public void verifyGoogleSearchPage() {
        //page is coming from base class
        String title = page.getInstance(HomePage.class).getHomePageTitle();
        Assert.assertEquals(title, "Google");
    }

    @Test
    public void verifyClickingSearchResults() {
        String currentPageTitle = page.getInstance(HomePage.class).getHomePageTitle();
        String newPageTitle = page.getInstance(HomePage.class).searchText("Selenium")
                .clickFirstLink();
        Assert.assertNotNull(newPageTitle, "New Page title is null");
        Assert.assertNotEquals(newPageTitle, currentPageTitle, "new page is not loaded");
    }

}
