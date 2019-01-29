package com.herokuapp.Pages;

import com.herokuapp.framework.BasePage;
import com.herokuapp.framework.BaseTest;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import static org.testng.Assert.assertTrue;

public class LoginPage extends BasePage {
    public ExtentTest test = BaseTest.test;

    private static final String USERNAME_TEXTBOX_XPATH = "//input[@id='username']";
    private static final String PASSWORD_TEXTBOX_XPATH = "//input[@id='password']";
    private static final String USERNAME_CONTAINER_XPATH = "//em[1]";
    private static final String PASSWORD_CONTAINER_XPATH = "//em[2]";
    private static final String LOGIN_BUTTON_XPATH = "//*[contains(text(),'Login')]/..//button[@type='submit']";
    private static final String INVALID_CREDENTIALS = "wrongcred";
    private static final String INVALID_USERNAME_TEXT = "Your username is invalid!";
    private static final String INVALID_PASSWORD_TEXT = "Your password is invalid!";
    private static final String INVALID_USERNAME_MESSAGE_XPATH = "//*[contains(text(),'" + INVALID_USERNAME_TEXT + "')]/..//div[@class='flash error']";
    private static final String INVALID_PASSWORD_MESSAGE_XPATH = "//*[contains(text(),'" + INVALID_PASSWORD_TEXT + "')]/..//div[@class='flash error']";


    @FindBy(xpath = USERNAME_CONTAINER_XPATH)
    private WebElement usernameText;

    @FindBy(xpath = PASSWORD_CONTAINER_XPATH)
    private WebElement passwordText;

    @FindBy(xpath = LOGIN_BUTTON_XPATH)
    private WebElement loginButton;

    @FindBy(xpath = USERNAME_TEXTBOX_XPATH)
    private WebElement usernameTextField;

    @FindBy(xpath = PASSWORD_TEXTBOX_XPATH)
    private WebElement passwordTextField;


    private String getUsername() {
        String validUsername = usernameText.getText();
        test.log(LogStatus.INFO, "Valid username is: " + validUsername);
        return validUsername;
    }

    private String getPassword() {
        String validPassword = passwordText.getText();
        test.log(LogStatus.INFO, "Valid password is: " + validPassword);
        return validPassword;
    }

    public SecureAreaPage signIn() {
        test.log(LogStatus.INFO, "Entering valid username...");
        usernameTextField.sendKeys(getUsername());
        test.log(LogStatus.INFO, "Entering valid password...");
        passwordTextField.sendKeys(getPassword());
        test.log(LogStatus.INFO, "Signing in...");
        loginButton.click();
        return initPage(SecureAreaPage.class);
    }

    public void assertInvalidUsernameMessage() {
        test.log(LogStatus.INFO, "Entering invalid username...");
        usernameTextField.sendKeys(INVALID_CREDENTIALS);
        test.log(LogStatus.INFO, "Clicking Login button...");
        loginButton.click();
        test.log(LogStatus.INFO, "Asserting error message...");
        assertTrue(driver.findElements(By.xpath(INVALID_USERNAME_MESSAGE_XPATH)).size() > 0, "the message about invalid user is wrong or not displayed");
    }

    public void assertInvalidPasswordMessage() {
        test.log(LogStatus.INFO, "Entering valid username...");
        usernameTextField.sendKeys(getUsername());
        test.log(LogStatus.INFO, "Entering invalid password...");
        passwordTextField.sendKeys(INVALID_CREDENTIALS);
        test.log(LogStatus.INFO, "Clicking Login button...");
        loginButton.click();
        test.log(LogStatus.INFO, "Asserting error message...");
        assertTrue(driver.findElements(By.xpath(INVALID_PASSWORD_MESSAGE_XPATH)).size() > 0, "the message about invalid password is wrong or not displayed");

    }

}
