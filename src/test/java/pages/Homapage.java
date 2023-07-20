package pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import testlogger.TestResultLogger;
import utilities.Driver;
import utilities.ReusableMethods;

public class Homapage {

    private static final Logger logger = Logger.getLogger(TestResultLogger.class);

     public Homapage(){
         PageFactory.initElements(Driver.getDriver(),this);
     }
     Actions actions=new Actions(Driver.getDriver());
     ReusableMethods reUse=new ReusableMethods(Driver.driver);

     public void navigateToTheWebsite(String url){

         Driver.driver.get(url);
         logger.info("Navigated to the page");
     }
     public void verifyThatThePageIsAccessible(){
         String expectedUrl="https://www.vatanbilgisayar.com/";
         Assert.assertEquals(Driver.driver.getCurrentUrl(),expectedUrl);
         logger.info("The page is accessible");

     }
     @FindBy(className = "banner-accept-button")
     private WebElement cookies;
     public void acceptCookies(){
         cookies.click();
         logger.info("All the cookies have been accepted");
     }
     @FindBy(id = "btnMyAccount")
     public WebElement girisYapElement;

     public void clickOnTheGirisYap(){
         girisYapElement.click();
         logger.info("Giris Yap element has been clicked");

     }

     @FindBy(xpath = "//a[text()='Giriş Yap']")
     private WebElement girisYapLink;

    public void clickOnTheGirisYapLink(){
        girisYapLink.click();
        logger.info("Giris Yap link has been clicked");

    }


     @FindBy(id="login")
     private WebElement loginLink;
     public void clickOnTheLoginLink(){
         loginLink.click();
         logger.info("The login link has been clicked");
     }









}
