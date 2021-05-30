package com.bookdepository.pages;

import com.bookdepository.core.BrowserFactory;
import com.bookdepository.core.Constants;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class BookPage {

    private final String path;

    @FindBy(css = ".checkout-tools .btn-primary")
    private WebElement addToBasketButton;

    public BookPage(String path) {
        this.path = path;
    }

    public void open() {
        BrowserFactory.get(Constants.URL + path);
        Assert.assertTrue(isOpened(), "Search result page is not opened");
    }

    public boolean isOpened() {
        PageFactory.initElements(BrowserFactory.driver(), this);
        return addToBasketButton.isEnabled();
    }
}
