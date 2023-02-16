package steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.TechGlobalFrontendTestingHomePage;
import pages.TechGlobalPaginationPage;
import utils.Driver;

public class TechGlobalSteps {

    WebDriver driver;
    TechGlobalFrontendTestingHomePage techGlobalFrontendTestingHomePage;

    TechGlobalPaginationPage techGlobalPaginationPage;

    public void setup(){
        driver = Driver.getDriver();
        techGlobalFrontendTestingHomePage = new TechGlobalFrontendTestingHomePage();
        techGlobalPaginationPage = new TechGlobalPaginationPage();
    }

    @Given("user is on {string}")
    public void userIsOn(String arg0) {
    }

    @When("user moves to {string} header dropdown")
    public void userMovesToHeaderDropdown(String arg0) {
    }

    @And("user clicks on \"Frontend Testing” header dropdown option")
    public void userClicksOnFrontendTestingHeaderDropdownOption() {

    }

    @Then("user should be navigated to {string}")
    public void userShouldBeNavigatedTo(String arg0) {
    }

    @And("user clicks on {string} card")
    public void userClicksOnCard(String arg0) {
    }

    @And("user should see {string} heading")
    public void userShouldSeeHeading(String arg0) {
    }

    @And("user should see {string} paragraph")
    public void userShouldSeeParagraph(String arg0) {
    }


}

