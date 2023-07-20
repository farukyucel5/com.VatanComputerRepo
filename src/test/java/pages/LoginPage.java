package pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import testlogger.TestResultLogger;
import utilities.Driver;
import utilities.ReusableMethods;

import java.io.IOException;

public class LoginPage {

    ReusableMethods reUse=new ReusableMethods(Driver.driver);
    private static final Logger logger = Logger.getLogger(TestResultLogger.class);
    public LoginPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//input[@id='email']")
    private WebElement emailBox;

    public void enterTheEmail(){
        String emailAddress= String.valueOf(reUse.dataFetching(0,0));
        logger.info("The email has been fetched from the Excel file?");
        emailBox.sendKeys(emailAddress);
        logger.info("The email has been passed in the input box");
    }

    @FindBy(css = "#pass")
    private WebElement passwordBox;

    public void enterThePassword(){
        String password= String.valueOf(reUse.dataFetching(1,0));
        logger.info("The password has been retrieved from the Excel file");
        passwordBox.sendKeys(password.trim());
        logger.info("The password has been passed in the input box");
    }

    @FindBy(css="#login-button")
    private WebElement girisYapBtnUnderTheInput;

    public void clickOnTheGirisYapBtnUnderTheInput(){
        girisYapBtnUnderTheInput.click();
        logger.info("Giris yap button has been hit");
    }


}
