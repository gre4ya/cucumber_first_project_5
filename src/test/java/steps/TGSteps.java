package steps;

import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import io.cucumber.datatable.DataTable;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import pages.TechGlobalBasePage;
import pages.TechGlobalFrontendTestingHomePage;
import pages.TechGlobalPaginationPage;
import utils.Driver;

import java.util.ArrayList;
import java.util.List;

public class TGSteps {

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


    @Then("^user see cities with info below and an image and clicks on Next button$")
    public void user_see_city_city_with_info_below_and_an_image_and_clicks_on_Next_button(DataTable info) {
       List<List<String>> list = info.asList(String.class);

       String[] cities = {"Tokyo", "Delhi", "Shangai", "Sao Paulo", "Mexico City"};

        for (int i = 0; i < list.size(); i++) {
            Assert.assertTrue(driver.findElement(By.cssSelector("img[alt='" + cities[i] + "']")).isDisplayed());

/*                j = 0                  j = 1                 j = 2
  i = 0      {{"City: Tokyo",      "Country: Japan", "Population: 37,435,191"},
  i = 1      {"City: Delhi",       "Country: India", "Population: 29,399,141"},
  i = 2      {"City: Shangai",     "Country: China", "Population: 26,317,104"},
  i = 3      {"City: Sao Paulo",   "Country: Brasil", "Population: 21,846,507"},
  i = 4      {"City: Mexico City", "Country: Mexico", "Population: 21,671,908}}
 */


            for (int j = 0; j < 3; j++) {
                Assert.assertEquals(list.get(i).get(j), techGlobalPaginationPage.citiesData.get(j).getText());
            }
            techGlobalPaginationPage.nextButton.click();
        }
    }
}
