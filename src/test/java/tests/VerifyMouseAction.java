package tests;

import org.testng.annotations.Test;
import pages.LoginPage;
import pages.StartPage;


public class VerifyMouseAction extends StartPage {

    @Test
    public void verifyMouseAction() {
        LoginPage googleDiscPage = new StartPage()
                .openHomePage()
                .selectLanguageInThePopUp()
                .clickOnTheSignInButton()
                .fillOutEmailField()
                .clickNextButton();
    }
}
