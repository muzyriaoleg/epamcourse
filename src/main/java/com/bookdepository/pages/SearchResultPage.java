package com.bookdepository.pages;

import com.bookdepository.core.BrowserFactory;
import com.bookdepository.core.Constants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class SearchResultPage extends Page {

    private final String searchTerm;
    private WebElement book;
    private String path;

    public SearchResultPage(String searchTerms) {
        this.searchTerm = searchTerms;
        this.path = "search?searchTerm=" + searchTerm + "&search=Find+book";
    }

    public void open() {
        BrowserFactory.get(Constants.URL + path);
        Assert.assertTrue(isOpened(), "Search result page is not opened");
    }

    public boolean isOpened() {
        return BrowserFactory.driver().getCurrentUrl().contains(Constants.URL + path);
    }

    public void selectBook(String bookTitle) {
        book = find(By.cssSelector(String.format("img[alt='%s']", bookTitle)));
        book.click();
    }


}
