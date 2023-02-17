package steps;

import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import pages.TechGlobalBasePage;
import pages.TechGlobalFrontendTestingHomePage;
import pages.TechGlobalPaginationPage;
import utils.ConfigReader;
import utils.Driver;
import utils.Waiter;
import utils.WindowHandler;

public class TechGlobalSteps {

    WebDriver driver;
    TechGlobalFrontendTestingHomePage techGlobalFrontendTestingHomePage;
    TechGlobalPaginationPage techGlobalPaginationPage;
    TechGlobalBasePage techGlobalBasePage;

    @Before
    public void setup(){
        driver = Driver.getDriver();
        techGlobalFrontendTestingHomePage = new TechGlobalFrontendTestingHomePage();
        techGlobalPaginationPage = new TechGlobalPaginationPage();
        techGlobalBasePage = new TechGlobalBasePage();
    }

    @Given("user is on {string}")
    public void userIsOn(String url) {
        driver.get(url);
    }

    @When("user moves to Practices header dropdown")
    public void userMovesToHeaderDropdown() {
        techGlobalBasePage.headerDropdown.click();
    }

    @And("user clicks on Frontend Testing header dropdown option")
    public void userClicksOnFrontendTestingHeaderDropdownOption() {
        techGlobalFrontendTestingHomePage.getFrontendTestingPage();
    }

    @Then("user should be navigated to {string}")
    public void userShouldBeNavigatedTo(String url) {
        WindowHandler.switchToChildWindow();
        Assert.assertEquals(url, driver.getCurrentUrl());
    }

    @And("user clicks on {string} card")
    public void userClicksOnCard(String card) {
        techGlobalFrontendTestingHomePage.clickOnCard(card);
    }

    @And("user should see {string} heading")
    public void userShouldSeeHeading(String heading) {
        switch (heading) {
            case "Pagination":
                Assert.assertEquals(heading, techGlobalPaginationPage.mainHeading.getText());
                break;
            case "World City Populations 2022":
                Assert.assertEquals(heading, techGlobalPaginationPage.subHeading.getText());
                break;
            default:
                throw new NotFoundException();
        }
    }

    @And("user should see {string} paragraph")
    public void userShouldSeeParagraph(String paragraph) {
            Assert.assertEquals(paragraph, techGlobalPaginationPage.contentParagraph.getText());
    }

    @And("user should see {string} button is disabled")
    public void userShouldSeeButtonIsDisabled(String button) {
        switch(button){
            case "Previous":
                Assert.assertFalse(techGlobalPaginationPage.previousButton.isEnabled());
                break;
            case "Next" :
                Assert.assertFalse(techGlobalPaginationPage.nextButton.isEnabled());
                break;
            default:
                throw new NotFoundException();
        }
    }

    @And("user should see {string} button is enabled")
    public void userShouldSeeButtonIsEnabled(String button) {
        switch(button){
            case "Previous":
                Assert.assertTrue(techGlobalPaginationPage.previousButton.isEnabled());
                break;
            case "Next":
                Assert.assertTrue(techGlobalPaginationPage.nextButton.isEnabled());
                break;
            default:
                throw new NotFoundException();
        }
    }

    @When("user clicks on Next button")
    public void userClicksOnButton() {
        techGlobalPaginationPage.nextButton.click();
    }

    @When("user clicks on Next button till it becomes disabled")
    public void userClicksOnButtonTillItBecomesDisabled() {
        while(techGlobalPaginationPage.nextButton.isEnabled()){
            techGlobalPaginationPage.nextButton.click();
        }
    }

    @And("user should see Tokyo city with info below and an image")
    public void userShouldSeeTokyoCityWithInfoBelowAndAnImage(DataTable cityData) {
        Assert.assertTrue(driver.findElement(By.cssSelector("img[alt='Tokyo']")).isDisplayed());
                for (int i = 0; i < cityData.asList().size(); i++) {
                    Assert.assertEquals(cityData.asList().get(i), techGlobalPaginationPage.citiesData.get(i).getText());
                }
    }

    @And("user should see Delhi city with info below and an image")
    public void userShouldSeeDelhiCityWithInfoBelowAndAnImage(DataTable cityData) {
        Assert.assertTrue(driver.findElement(By.cssSelector("img[alt='Delhi']")).isDisplayed());
        for (int i = 0; i < cityData.asList().size(); i++) {
            Assert.assertEquals(cityData.asList().get(i), techGlobalPaginationPage.citiesData.get(i).getText());
        }
    }

    @And("user should see Shangai city with info below and an image")
    public void userShouldSeeShangaiCityWithInfoBelowAndAnImage(DataTable cityData) {
        Assert.assertTrue(driver.findElement(By.cssSelector("img[alt='Shangai']")).isDisplayed());
        for (int i = 0; i < cityData.asList().size(); i++) {
            Assert.assertEquals(cityData.asList().get(i), techGlobalPaginationPage.citiesData.get(i).getText());
        }
    }

    @And("user should see Sao Paulo city with info below and an image")
    public void userShouldSeeSaoPauloCityWithInfoBelowAndAnImage(DataTable cityData) {
        Assert.assertTrue(driver.findElement(By.cssSelector("img[alt='Sao Paulo']")).isDisplayed());
        for (int i = 0; i < cityData.asList().size(); i++) {
            Assert.assertEquals(cityData.asList().get(i), techGlobalPaginationPage.citiesData.get(i).getText());
        }
    }

    @And("user should see Mexico City city with info below and an image")
    public void userShouldSeeMexicoCityCityWithInfoBelowAndAnImage(DataTable cityData) {
        Assert.assertTrue(driver.findElement(By.cssSelector("img[alt='Mexico City']")).isDisplayed());
        for (int i = 0; i < cityData.asList().size(); i++) {
            Assert.assertEquals(cityData.asList().get(i), techGlobalPaginationPage.citiesData.get(i).getText());
        }
    }


//    @And("user should see {string} city with info below and an image")
//    public void userShouldSeeCityWithInfoBelowAndAnImage(DataTable cityData, String city) {
//        switch(city){
//            case "Tokyo":
//            case "Delhi":
//            case "Shangai":
//            case "Sao Paulo":
//            case "Mexico City":
//                Assert.assertTrue(driver.findElement(By.cssSelector("img[alt='" + city + "']")).isDisplayed());
//                for (int i = 0; i < cityData.asList().size(); i++) {
//                    Assert.assertEquals(cityData.asList().get(i), techGlobalPaginationPage.citiesData.get(i).getText());
//                }
//                break;
//            default:
//                throw new NotFoundException();
//        }
//    }


}

