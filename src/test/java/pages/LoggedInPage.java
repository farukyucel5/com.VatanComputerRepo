package pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import testlogger.TestResultLogger;
import utilities.Driver;
import utilities.ReusableMethods;

public class LoggedInPage {

    public LoggedInPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    ReusableMethods reUse=new ReusableMethods(Driver.driver);
    private static final Logger logger = Logger.getLogger(TestResultLogger.class);
    @FindBy(css = "#type")
    private WebElement userName;
    public void verifyTheLoginSuccess(){
        String expectedText= String.valueOf(reUse.dataFetching(2,0));
        logger.info("Assertion text has been obtained from the Excel file");
        Assert.assertEquals(userName.getText(),expectedText.trim());
        logger.info("Login has been successfully executed");
    }

    @FindBy(xpath = "//*[@*='Aramak istediğiniz ürünü yazın']")
    private WebElement searchBox;

    public void typeTheSearchKeywordInTheSearchBox(){
        String searchKeyword=String.valueOf(reUse.dataFetching(3,0));
        logger.info("Search keyword has been obtained from the Excel file");
        searchBox.sendKeys(searchKeyword);
        logger.info("Search keyword has been passed in the search box");
    }

    @FindBy(className = "search__button")
    private WebElement searchBtn;

    public void hitTheSearchBtn(){
        searchBox.click();
        logger.info("search button has been hit");
    }
}
