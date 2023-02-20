package steps;

import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import io.cucumber.datatable.DataTable;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import pages.TechGlobalBasePage;
import pages.TechGlobalFrontendTestingHomePage;
import pages.TechGlobalPaginationPage;
import utils.Driver;

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


    @And("user see {string} city with info below and an image and clicks on Next button")
    public void user_see_city_city_with_info_below_and_an_image_and_clicks_on_Next_button(String city, DataTable info) {
       List<List<String>> list = info.asList(String.class);
        switch(city){
            case "Tokyo":
            case "Delhi":
            case "Shangai":
            case "Sao Paulo":
            case "Mexico City":
                Assert.assertTrue(driver.findElement(By.cssSelector("img[alt='" + city + "']")).isDisplayed());

                /*
                  | City: Tokyo       | Country: Japan  | Population: 37,435,191 |
                  | City: Delhi       | Country: India  | Population: 29,399,141 |
                  | City: Shangai     | Country: China  | Population: 26,317,104 |
                  | City: Sao Paulo   | Country: Brasil | Population: 21,846,507 |
                  | City: Mexico City | Country: Mexico | Population: 21,671,908 |
                 */


                for (int i = 0; i < list.size(); i++) {
                    for (int j = 0; j < list.get(i).size(); j++) {
                        Assert.assertEquals(list.get(i).get(j), techGlobalPaginationPage.citiesData.get(i).getText());
                    }
                }
                break;
            default:
                throw new NotFoundException();
        }


    }
}
