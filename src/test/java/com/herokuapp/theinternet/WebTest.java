package com.herokuapp.theinternet;

import com.herokuapp.Pages.SecureAreaPage;
import com.herokuapp.Pages.TablesPage;
import com.herokuapp.Pages.LoginPage;
import com.herokuapp.Pages.HoversPage;
import com.herokuapp.framework.BasePage;
import com.herokuapp.framework.BaseTest;
import org.testng.annotations.*;

public class WebTest extends BaseTest {
    private LoginPage loginPage;
    private static final String LOGINPAGE_ENDPOINT = "login";
    private static final String HOVERS_ENDPOINT = "hovers";
    private static final String TABLES_ENDPOINT = "tables";

    @Test
    public void loginSuccessTest() {
        getURL(LOGINPAGE_ENDPOINT);
        loginPage = BasePage.initPage(LoginPage.class);
        SecureAreaPage secureAreaPage = loginPage.signIn();
        secureAreaPage.assertSuccessLoginMessage();
    }

    @Test
    public void InvalidUsernameTest() {
        getURL(LOGINPAGE_ENDPOINT);
        loginPage = BasePage.initPage(LoginPage.class);
        loginPage.assertInvalidUsernameMessage();
    }

    @Test
    public void InvalidPasswordTest() {
        getURL(LOGINPAGE_ENDPOINT);
        loginPage = BasePage.initPage(LoginPage.class);
        loginPage.assertInvalidPasswordMessage();
    }

    @Test
    public void hoverTest() {
        getURL(HOVERS_ENDPOINT);
        HoversPage hoversPage = BasePage.initPage(HoversPage.class);
        hoversPage.validateUsers();
    }

    @Test
    public void tablesTest() {
        getURL(TABLES_ENDPOINT);
        TablesPage tablesPage = BasePage.initPage(TablesPage.class);
        tablesPage.checkSortingLastNames();
    }

    private void getURL(String endpoint) {
        BasePage.driver.get(settings.getBaseUrl() + endpoint);
    }
}

