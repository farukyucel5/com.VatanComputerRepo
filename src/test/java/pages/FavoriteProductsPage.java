package pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import testlogger.TestResultLogger;
import utilities.Driver;

public class FavoriteProductsPage {

    public FavoriteProductsPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    private static final Logger logger = org.apache.log4j.Logger.getLogger(TestResultLogger.class);
    @FindBy(xpath = "//span[@class='favorite-box__title-prod-code']")
    private WebElement favoriteProduct;

    public void verifyThatTheProductHasBeenAddedIntoFavoriteList(){
        Assert.assertTrue(favoriteProduct.isDisplayed());
        logger.info("it has been verified that the product has been added into the favorite list");
    }

    @FindBy(xpath = "//*[text()='Sepete Ekle']")
    private WebElement sepeteEkleBtn;

    public void clickOntheSepeteEkle(){
        sepeteEkleBtn.click();
        logger.info("Sepete ekle button has been hit");
    }

    @FindBy(xpath = "//div[@class='col-xs-12 m-b-0 message-modal']")
    private WebElement sepeteEklendiPopUp;

    public void verifythatTheSepeteEklendiPopUpIsDisplayed(){
        Assert.assertTrue(sepeteEklendiPopUp.isDisplayed());
        logger.info("sepete eklendi pop up has been displayed");
    }

    @FindBy(xpath = "//input[@value='SEPETE GİT']")
    private WebElement sepeteGitBtn;


    public void ClickOnTheSepeteGitButton(){
        sepeteGitBtn.click();
        logger.info("Sepete git button has been hit");
    }


}
