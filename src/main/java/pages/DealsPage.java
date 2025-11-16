package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.util.List;
import org.openqa.selenium.WebElement;

public class DealsPage {
    WebDriver driver;
    private By dealItems = By.cssSelector("div[data-testid='deal-card'], div.dealItem, .DealGridItem");

    public DealsPage(WebDriver driver) { this.driver = driver; }

    public void selectThirdDeal() {
        List<WebElement> items = driver.findElements(dealItems);
        if (items.size() >= 3) {
            items.get(2).click();
        } else if (!items.isEmpty()) {
            items.get(0).click();
        }
    }
}
