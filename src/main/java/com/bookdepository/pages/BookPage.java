package com.bookdepository.pages;

import com.bookdepository.core.BrowserFactory;
import com.bookdepository.core.Constants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class BookPage extends Page{

    private final String path;

    @FindBy(css = ".checkout-tools .btn-primary")
    private WebElement addToBasketButton;

    @FindBy(xpath = "//a[@class='basket-btn']/span[@class='item-count']")
    private WebElement basketItemCounter;

    private int basketItemNumber;

    public BookPage(String path) {
        this.path = path;
    }

    public void open() {
        BrowserFactory.get(Constants.URL + path);
        Assert.assertTrue(isOpened(), "Search result page is not opened");
    }

    public boolean isOpened() {
        return addToBasketButton.isEnabled();
    }

    public void addBookToBasket() {
        PageFactory.initElements(BrowserFactory.driver(), this);
        basketItemNumber = Integer.parseInt(basketItemCounter.getAttribute("textContent").trim());
        addToBasketButton.click();
        find(By.cssSelector(".modal-title"));
    }

    public boolean isBookAddedToBasket() {
        int currentBasketItemNumber = Integer.parseInt(basketItemCounter.getAttribute("textContent").trim());
        return currentBasketItemNumber == ++ basketItemNumber;
    }
}
