package com.herokuapp.Pages;

import com.herokuapp.framework.BasePage;
import com.herokuapp.framework.BaseTest;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.*;
import static org.testng.Assert.assertTrue;

public class SecureAreaPage extends BasePage {

    public ExtentTest test = BaseTest.test;

    private static final String SUCCESS_TEXT = "You logged into a secure area!";
    private static final String SUCCESS_MESSAGE_XPATH = "//*[contains(text(),'" + SUCCESS_TEXT + "')]/..//div[@class='flash success']";

    public void assertSuccessLoginMessage() {
        test.log(LogStatus.INFO, "Asserting success message...");
        assertTrue(driver.findElements(By.xpath(SUCCESS_MESSAGE_XPATH)).size() > 0, "the message is wrong or not displayed");
    }


}

