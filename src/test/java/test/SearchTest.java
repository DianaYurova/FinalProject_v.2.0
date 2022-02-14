package test;

import context.ContextSearch;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.BasePage;

import static context.ContextSearch.*;

public class SearchTest extends BaseTest{

    @Test
    public void ensureFiltersPresented() {
        ContextSearch.openSearchPage();
        Assert.assertTrue(searchPage.isDispayedFilters());
    }

//    @Test
//    public void allRegionsPresented() {
//
//    }

    @Test
    public void selectCity() {
        ContextSearch.selectFromCities();
        Assert.assertTrue(searchPage.containsCityName().equals("Харьков"));
    }

    @Test
    public void search() throws InterruptedException {
        String keyword = "мишень";
        ContextSearch.itemSearch(keyword);
        Thread.sleep(1000);
//        searchPage.explicitWaiter();
        System.out.println(searchPage.headerContainsQuery());
        Assert.assertTrue(searchPage.headerContainsQuery().contains(keyword));
    }
}
