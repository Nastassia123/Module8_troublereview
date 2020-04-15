package pages;

import abstractPackage.BasePageClass;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;


import static com.sun.xml.internal.ws.spi.db.BindingContextFactory.LOGGER;


public class StartPage extends BasePageClass {


    private static final String APPLICATION_URL = "https://products.office.com/en-us/onedrive/online-cloud-storage";


    private static final String ELEMENT_WITH_TEXT = "//*[text() = '%s']";


    private static final By SELECT_LANGUAGE_IN_THE_POPUP =  By.xpath("//button[@class = 'c-glyph glyph-cancel']");



    private static final By SIGN_IN_BUTTON_XPATH = By.xpath("//a[@class = 'c-button f-primary xs-ow-mr-0 ow-mt-25 ow-txt-trans-upper']");




    public StartPage openHomePage() {
        open(APPLICATION_URL);
        maximizeWindow();
        return this;
    }

    public StartPage selectLanguageInThePopUp() {
        WebElement selectLanguageButton = waitForExpectedElement(SELECT_LANGUAGE_IN_THE_POPUP);
        selectLanguageButton.click();
        return new LoginPage();
    }



    public LoginPage clickOnTheSignInButton() {
        WebElement googleDiscButton = waitForExpectedElement(SIGN_IN_BUTTON_XPATH);
        googleDiscButton.click();
        return new LoginPage();
    }




}




