package pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import testlogger.TestResultLogger;
import utilities.Driver;

public class ProductDetailsPage {

    public ProductDetailsPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    private static final Logger logger = org.apache.log4j.Logger.getLogger(TestResultLogger.class);

    Actions actions =new Actions(Driver.getDriver());

    @FindBy(id="fav_Icon")
    private WebElement addToFavoriteListIcon;

    @FindBy(xpath = "//button[@class='btn btn-okey close-alert']")
    private WebElement removingFromFavoriteListTamamBtn;
    public void clickOnTheAddToFavoriteListIcon(){
            addToFavoriteListIcon.click();
            logger.info("Favorilere ekle icon has been clicked");
    }

    @FindBy(id="modal-favorite")
    private WebElement popUpWindow;

    public void verifyThatPopUpWindowHasBeenOpened(){
        try {
            Assert.assertTrue(popUpWindow.isDisplayed());
            logger.info("It has been verified that the pop up window has been displayed");
            actions.sendKeys(Keys.ESCAPE).perform();
            logger.info("The pop up window has been closed");
        }catch (Exception e){
            removingFromFavoriteListTamamBtn.click();
            logger.info("Tamam button in the remove pop up has been pressed");
            addToFavoriteListIcon.click();
            logger.info("Favorilere ekle icon has been clicked");
            Assert.assertTrue(popUpWindow.isDisplayed());
            logger.info("It has been verified that the pop up window has been displayed");
            actions.sendKeys(Keys.ESCAPE).perform();
            logger.info("The pop up window has been closed");
        }
    }

    @FindBy(xpath = "//span[text()='HESABIM']")
    private WebElement hesabimBtn;

    public void clickOnTheHesabimButton(){
        hesabimBtn.click();
        logger.info("Hesabım button has been hit");
    }

    @FindBy(xpath = "//a[text()='Favori Ürünlerim']")
    private WebElement favoriUrunlerimLink;

    public void clickOnThefavoriUrunlerimLink(){
        favoriUrunlerimLink.click();
        logger.info("Favori ürünlerim link has been hit");
    }
}
