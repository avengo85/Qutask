package com.herokuapp.Pages;

import com.herokuapp.framework.BasePage;
import com.herokuapp.framework.BaseTest;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

import static org.testng.Assert.assertTrue;

public class HoversPage extends BasePage {

    public ExtentTest test = BaseTest.test;
    private Actions action = new Actions(driver);


    public void validateHover(int userNumber) {
        test.log(LogStatus.INFO, "Hovering over user" + userNumber + "...");
        action.moveToElement(driver.findElement(By.xpath(getImageXPATH(userNumber)))).build().perform();
        test.log(LogStatus.INFO, "Asserting appearing the message 'user" + userNumber + "'...");
        assertTrue(driver.findElements(By.xpath(getUsernameTextXPATH(userNumber))).size() > 0, "the message with name of user" + userNumber + " is wrong or not displayed");
    }

    public void validateUsers() {
        for (int userNumber = 1; userNumber <= 3; userNumber++) {
            validateHover(userNumber);
        }
    }


    private String getImageXPATH(int userNumber) {
        return "//*[contains(text(),'user" + userNumber + "')]/ancestor::div[@class='figure']";
    }

    private String getUsernameTextXPATH(int userNumber) {
        return "//h5[contains(text(),'user" + userNumber + "')]";
    }
}
