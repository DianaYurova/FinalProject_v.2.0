package context;

import org.openqa.selenium.JavascriptExecutor;
import page.MainPage;
import page.SearchPage;

import static test.BaseTest.driver;

public class ContextSearch {

    public static MainPage mainPage = new MainPage(driver);
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

    public static void byCategory() throws InterruptedException {
        mainPage.selectSearchCategory();
        Thread.sleep(3000);
        mainPage.selectSubCategory();
    }

    public static void openRandomAd() throws InterruptedException {
        Thread.sleep(1000);
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0, 500);");
        mainPage.explicitAdvt();
        mainPage.openAd();
    }
    public static void addToFavorites() throws InterruptedException {
        Thread.sleep(3000);
        searchPage.addToFavorite(); }

    public static String expectedCount() {
        String count = ContextAdOperations.getFavoriteCountBefore();
        int countBefore = Integer.parseInt(count);
        int countAfter = countBefore + 1;
        return Integer.toString(countBefore);
    }

    public static void setPriceFilters() throws InterruptedException {
        searchPage.selectRegion();
        Thread.sleep(10000);

        searchPage.selectMinPrice();
        searchPage.moveToMin1000();
        searchPage.selectThousandMin();
        Thread.sleep(5000);

        searchPage.clickMax1000();
        searchPage.setMax1000();
        Thread.sleep(5000);
    }

    public static String getPrice() { return searchPage.getAdvtPrice(); }
}

