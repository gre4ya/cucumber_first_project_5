package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

public class TechGlobalPaginationPage extends TechGlobalBasePage{

    public TechGlobalPaginationPage(){PageFactory.initElements(Driver.getDriver(),this);}

    @FindBy(id = "main_heading")
    public WebElement mainHeading;
    @FindBy(id = "sub_heading")
    public WebElement subHeading;
    @FindBy(id = "content")
    public WebElement contentParagraph;
    @FindBy(id = "previous")
    public WebElement previousButton;
    @FindBy(id = "next")
    public WebElement nextButton;
    @FindBy(css = "div[class*='up2c0'] p")
    public WebElement citiesData;


}
