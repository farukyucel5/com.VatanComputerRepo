package pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import testlogger.TestResultLogger;
import utilities.Driver;

import java.util.List;
import java.util.stream.Collectors;

public class SearchResultsPage {

    public SearchResultsPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    private static final Logger logger = org.apache.log4j.Logger.getLogger(TestResultLogger.class);

    @FindBy(xpath = "//span[contains(text(),'Cep Telefonu')]")
    private WebElement cepTelefonuOption;

    public void checkTheCepTelefonu(){
        cepTelefonuOption.click();
        logger.info("Cep Telefonu option has been checked");

    }

    @FindBy(xpath = "//div[@class='product-list product-list--list-page']//h3")
    List<WebElement> searchResultList;
    public void verifyThatProductsOfSamsungHaveBeenListed(){
        List<String> productTexts=searchResultList.stream().map(WebElement::getText).collect(Collectors.toList());
        logger.info("All the text contents of the products listed have been added into a list");
        productTexts.forEach(n-> Assert.assertTrue(n.toLowerCase().contains("samsung")));
        logger.info("It has been verified that all the products listed are Samsung branded");
    }

    @FindBy(xpath = "(//div[@class='col-lg-2 col-md-3 col-sm-4 col-xs-6 search-result-product'])[5]")
    WebElement fifthProduct;

    public void clickOnTheFifthProduct(){
        fifthProduct.click();
        logger.info("The fifth product from the top has been clicked");
    }




}
