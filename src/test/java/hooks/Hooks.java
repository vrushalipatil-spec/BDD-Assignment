package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Hooks {

    public static WebDriver driver;

    @Before
    public void setUp() {
        // Initialize WebDriver before each scenario
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        System.out.println(">>> Browser launched for scenario");
    }

    @After
    public void tearDown(Scenario scenario) {
        // Capture screenshot if scenario fails
        if (scenario.isFailed()) {
            final byte[] screenshot = ((TakesScreenshot) driver)
                    .getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "Failure Screenshot");
            System.out.println(">>> Screenshot captured for failed scenario: " + scenario.getName());
        }

        // Close browser after each scenario
        if (driver != null) {
            driver.quit();
            System.out.println(">>> Browser closed after scenario");
        }
    }
}
