package regression;

import com.bookdepository.core.BrowserFactory;
import com.bookdepository.pages.BookPage;
import com.bookdepository.pages.HomePage;
import com.bookdepository.pages.SearchResultPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTest extends BrowserFactory {

    private final String bookTitle = "Harry Potter and the Cursed Child - Parts I & II";
    private final String searchTerm = "Potter";

    HomePage homePage = new HomePage();
    SearchResultPage searchResultPage = new SearchResultPage(searchTerm);
    BookPage bookPage = new BookPage(bookTitle);

    @Test
    public void searchBook() {
        homePage.open();
        homePage.search(searchTerm);
        searchResultPage.selectBook(bookTitle);
        Assert.assertTrue(bookPage.isOpened(), "Book page is not opened");
    }
}
