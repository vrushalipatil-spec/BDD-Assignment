package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.util.List;
import org.openqa.selenium.WebElement;

public class SearchPage {
    WebDriver driver;
    private By productItems = By.cssSelector("div.s-main-slot div[data-component-type='s-search-result']");
    private By lastItemTitle = By.cssSelector("h2 a span");

    public SearchPage(WebDriver driver) { this.driver = driver; }

    public void scrollToLastItem() {
        List<WebElement> items = driver.findElements(productItems);
        if (!items.isEmpty()) {
            WebElement last = items.get(items.size()-1);
            ((org.openqa.selenium.JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", last);
        }
    }

    public String getLastItemTitle() {
        List<WebElement> items = driver.findElements(productItems);
        if (!items.isEmpty()) {
            WebElement last = items.get(items.size()-1);
            try {
                return last.findElement(lastItemTitle).getText();
            } catch (Exception e) {
                return "<title-not-found>";
            }
        }
        return "<no-items>";
    }
}
