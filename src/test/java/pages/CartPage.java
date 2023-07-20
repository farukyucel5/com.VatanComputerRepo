package pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import testlogger.TestResultLogger;
import utilities.Driver;

public class CartPage {

    public CartPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    private static final Logger logger = org.apache.log4j.Logger.getLogger(TestResultLogger.class);

    @FindBy(id = "closePop")
    private WebElement closePopBtn;


    public void clickOnTheClosePopButton(){
        closePopBtn.click();
        logger.info("Close pop button has been hit");
    }

    @FindBy(className = "icon-trash-ico")
    private WebElement deleteButton;


    public void clickOnTheDeleteButton(){
        deleteButton.click();
        logger.info("Trash button has been hit");
    }

    @FindBy(xpath = "//h3[text()='SEPETİNİZDE ÜRÜN YOK!']")
    private WebElement verificationTextForRemovedProduct;

    public void verifyThatTheProductHasBeenRemoved(){
        Assert.assertTrue(verificationTextForRemovedProduct.isDisplayed());
        logger.info("It has been verified that the product is removed");
    }


}
