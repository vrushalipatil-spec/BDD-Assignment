package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    WebDriver driver;

    private By todaysDeals = By.linkText("Today's Deals");
    private By leftNav = By.id("nav-hamburger-menu");
    private By searchBox = By.id("twotabsearchtextbox");
    private By searchBtn = By.id("nav-search-submit-button");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickTodaysDeals() { driver.findElement(todaysDeals).click(); }
    public void openLeftNav() { driver.findElement(leftNav).click(); }
    public void search(String q) {
        driver.findElement(searchBox).clear();
        driver.findElement(searchBox).sendKeys(q);
        driver.findElement(searchBtn).click();
    }
}
