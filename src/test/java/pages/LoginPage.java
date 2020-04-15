package pages;

import com.google.common.collect.Iterables;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import static com.sun.xml.internal.ws.spi.db.BindingContextFactory.LOGGER;

public class LoginPage extends StartPage {


    private static final By EMAIL_FIELD_XPATH = By.xpath("//input[@class = 'form-control']");


    private static final By NEXT_BUTTON_XPATH = By.xpath("//button[@class = 'btn btn-block btn-primary']");


    private String getParamFromProperty(String propertyName) {
        FileInputStream fis;
        Properties properties = new Properties();
        String emailFromPropertyFile = "";
        try {
            fis = new FileInputStream("./src/test/java/resources/application.properties");
            properties.load(fis);
            emailFromPropertyFile = properties.getProperty(propertyName);
        } catch (FileNotFoundException e) {
            LOGGER.warning("Check out file's path");
        } catch (IOException e) {
            LOGGER.warning(e.getMessage());
        }
        return emailFromPropertyFile;
    }


    public LoginPage fillOutEmailField() {
        switchToLastOpenedWindow();
        WebElement emailField = waitForExpectedElement(EMAIL_FIELD_XPATH);

        emailField.sendKeys(getParamFromProperty("email"), Keys.ENTER);
        waitPageIsLoadedAndJQueryIsProcessed();
        return this;


    }



    public LoginPage clickNextButton() {
        switchToLastOpenedWindow();
        WebElement emailField = waitForExpectedElement(NEXT_BUTTON_XPATH);
        emailField.click();
        return this;
    }

    public void switchToLastOpenedWindow() {
        String baseWindowHandle = getDriver().getWindowHandle();
        String lastWindowHandle = Iterables.getLast(getDriver().getWindowHandles());
        if (!lastWindowHandle.equals(baseWindowHandle)) {
            getDriver().switchTo().window(lastWindowHandle);
            LOGGER.info("Execution was switch to latest opened window");

        }
    }
}
