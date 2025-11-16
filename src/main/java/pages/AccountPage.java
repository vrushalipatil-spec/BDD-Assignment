package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountPage {
    WebDriver driver;
    private By yourOrders = By.linkText("Your Orders");
    private By paymentMethods = By.linkText("Payment options");
    private By addAddress = By.linkText("Add address");

    public AccountPage(WebDriver driver) { this.driver = driver; }

    public void goToOrders() { driver.findElement(yourOrders).click(); }
    public void goToPaymentOptions() { driver.findElement(paymentMethods).click(); }
    public void goToAddAddress() { driver.findElement(addAddress).click(); }
}
