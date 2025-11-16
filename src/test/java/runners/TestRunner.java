package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        features = "src/test/resources/features",   // Path to your .feature files
        glue = {"stepDefinitions"},                 // Step definitions + Hooks
        plugin = {
                "pretty",                           // Console output
                "html:target/cucumber-html-report", // Default Cucumber HTML
                "json:target/cucumber.json"         // JSON for Extent/Allure
        },
        monochrome = true,
        tags = "@smoke or @regression or @negative or @edgecase" // Run selected tags
)
public class TestRunner extends AbstractTestNGCucumberTests {

    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        // Enables parallel execution of scenarios
        return super.scenarios();
    }
}
