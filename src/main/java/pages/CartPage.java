package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {
    WebDriver driver;
    private By qtySelector = By.name("quantity");
    private By cartCount = By.id("nav-cart-count");

    public CartPage(WebDriver driver) { this.driver = driver; }

    public int getCartCount() {
        try {
            String text = driver.findElement(cartCount).getText();
            return Integer.parseInt(text.trim());
        } catch (Exception e) {
            return -1;
        }
    }
}
