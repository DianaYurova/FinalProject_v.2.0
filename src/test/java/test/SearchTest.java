package test;

import configuration.ConfigProperties;
import context.ContextAdOperations;
import context.ContextSearch;
import org.testng.annotations.Test;

import static context.ContextSearch.searchPage;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class SearchTest extends BaseTest{

    @Test(priority = 4)
    public void eensureFiltersPresented() {
        driver.get(ConfigProperties.getProperty("mainPage"));
        ContextSearch.openSearchPage();
        assertTrue(searchPage.isDispayedFilters());
    }

    @Test(priority = 5)
    public void fselectCity() {
        driver.get(ConfigProperties.getProperty("mainPage"));
        ContextSearch.selectFromCities();
        assertTrue(searchPage.containsCityName().equals("Харьков"));
    }

    @Test(priority = 6)
    public void gsearch() throws InterruptedException {
        driver.get(ConfigProperties.getProperty("mainPage"));
        String keyword = "мишень";
        ContextSearch.itemSearch(keyword);
        Thread.sleep(1000);
//        searchPage.explicitWaiter();
        System.out.println(searchPage.headerContainsQuery());
        assertTrue(searchPage.headerContainsQuery().contains(keyword));
    }

    @Test(priority = 7)
    public void hsearchByCategory() throws InterruptedException {
        driver.get(ConfigProperties.getProperty("mainPage"));
        ContextSearch.byCategory();
        assertTrue(searchPage.headerContainsQuery().contains("Все для сада и огорода"));
    }

    @Test(priority = 16)
    public void qfavoriteAds() throws InterruptedException {
//        LoginTest.loginZTest();
        driver.get(ConfigProperties.getProperty("mainPage"));
        ContextSearch.byCategory();
        String countBefore = ContextAdOperations.getFavoriteCountBefore();
        ContextSearch.addToFavorites();
        String countAfter = ContextAdOperations.getFavoriteCountAfter();
        assertEquals(countAfter, ContextSearch.expectedCount());
    }



}
