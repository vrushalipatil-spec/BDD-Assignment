package stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.en.*;

import java.util.List;

public class AmazonSteps {

    WebDriver driver;

    @Given("I open Amazon.in")
    public void i_open_amazon_in() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.amazon.in/");
    }

    @When("I click on {string}")
    public void i_click_on(String linkText) {
        driver.findElement(By.linkText(linkText)).click();
    }

    @When("I select the {int}rd deal")
    public void i_select_the_deal(int index) {
        List<WebElement> deals = driver.findElements(By.cssSelector(".DealCard"));
        deals.get(index - 1).click(); // index starts at 1 in Gherkin
    }

    @When("I add the minimum required quantity of the item to the cart")
    public void i_add_min_quantity() {
        WebElement qtyDropdown = driver.findElement(By.id("quantity"));
        qtyDropdown.sendKeys("1"); // minimum quantity
        driver.findElement(By.id("add-to-cart-button")).click();
    }

    @Then("the cart should display the expected quantity")
    public void verify_cart_quantity() {
        driver.findElement(By.id("nav-cart")).click();
        WebElement qty = driver.findElement(By.cssSelector(".sc-update-quantity-input"));
        assert qty.getAttribute("value").equals("1");
    }

    @When("I search for {string}")
    public void i_search_for(String keyword) {
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys(keyword);
        driver.findElement(By.id("nav-search-submit-button")).click();
    }

    @When("I scroll down to the last displayed item")
    public void i_scroll_to_last_item() {
        List<WebElement> items = driver.findElements(By.cssSelector(".s-result-item"));
        WebElement lastItem = items.get(items.size() - 1);
        System.out.println("Last item details: " + lastItem.getText());
    }

    @Then("I should see the details of the last mobile item")
    public void verify_last_item_details() {
        // Assertion example: ensure details are not empty
        List<WebElement> items = driver.findElements(By.cssSelector(".s-result-item"));
        WebElement lastItem = items.get(items.size() - 1);
        assert !lastItem.getText().isEmpty();
    }

    @When("I navigate from the left nav to {string}")
    public void i_navigate_left_nav(String category) {
        driver.findElement(By.linkText(category)).click();
    }

    @When("I select {string}")
    public void i_select(String subCategory) {
        driver.findElement(By.linkText(subCategory)).click();
    }

    @When("I return to the main menu")
    public void i_return_to_main_menu() {
        driver.findElement(By.id("nav-logo-sprites")).click();
    }

    @Then("I should be back at the homepage")
    public void verify_homepage() {
        assert driver.getTitle().contains("Amazon.in");
        driver.quit();
    }
}
