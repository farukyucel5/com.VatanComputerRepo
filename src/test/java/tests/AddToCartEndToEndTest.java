package tests;

import Hooks.HookClass;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;
import pages.*;
import testlogger.TestResultLogger;
import utilities.ConfigReader;

public class AddToCartEndToEndTest extends HookClass {

    Homapage homapage =new Homapage();
    LoginPage loginPage=new LoginPage();

    LoggedInPage loggedInPage=new LoggedInPage();

    SearchResultsPage searchResultsPage=new SearchResultsPage();

    ProductDetailsPage productDetailsPage=new ProductDetailsPage();

    FavoriteProductsPage favoriteProductsPage=new FavoriteProductsPage();

    CartPage cartPage=new CartPage();

    private static final Logger logger = Logger.getLogger(TestResultLogger.class);
    @Test
    public void addToCartEndToEndTest(){
        homapage.navigateToTheWebsite(ConfigReader.getProperty("vatanUrl"));
        homapage.verifyThatThePageIsAccessible();
        homapage.acceptCookies();
        homapage.clickOnTheGirisYap();
        homapage.clickOnTheGirisYapLink();
        loginPage.enterTheEmail();
        loginPage.enterThePassword();
        loginPage.clickOnTheGirisYapBtnUnderTheInput();
        loggedInPage.verifyTheLoginSuccess();
        loggedInPage.typeTheSearchKeywordInTheSearchBox();
        loggedInPage.hitTheSearchBtn();
        searchResultsPage.checkTheCepTelefonu();
        searchResultsPage.verifyThatProductsOfSamsungHaveBeenListed();
        searchResultsPage.clickOnTheFifthProduct();
        productDetailsPage.clickOnTheAddToFavoriteListIcon();
        productDetailsPage.verifyThatPopUpWindowHasBeenOpened();
        productDetailsPage.clickOnTheHesabimButton();
        productDetailsPage.clickOnThefavoriUrunlerimLink();
        favoriteProductsPage.verifyThatTheProductHasBeenAddedIntoFavoriteList();
        favoriteProductsPage.clickOntheSepeteEkle();
        favoriteProductsPage.verifythatTheSepeteEklendiPopUpIsDisplayed();
        favoriteProductsPage.ClickOnTheSepeteGitButton();
        cartPage.clickOnTheClosePopButton();
        cartPage.clickOnTheDeleteButton();
        cartPage.verifyThatTheProductHasBeenRemoved();

    }



}
