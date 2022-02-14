package context;

import page.SearchPage;

import static test.BaseTest.driver;

public class ContextSearch {

    public static SearchPage searchPage = new SearchPage(driver);

    public static void openSearchPage() {
        searchPage.clickSearchBtn();
    }

    public static void selectFromCities() {
        searchPage.clickSearchBtn();
        searchPage.clickCityField();
        searchPage.selectRegionInList();
        searchPage.selectCityInList();
    }

    public static void itemSearch(String keyword){
//        searchPage.clearSearchField();
//        searchPage.clickClearBtn();
        searchPage.clickSearchBtn();
        searchPage.searchByKeyword(keyword);
        searchPage.searchConfirm();
        searchPage.waiterPageReload();
    }
}
