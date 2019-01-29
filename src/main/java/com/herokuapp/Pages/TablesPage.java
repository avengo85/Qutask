package com.herokuapp.Pages;

import com.herokuapp.framework.BasePage;
import com.herokuapp.framework.BaseTest;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import static org.testng.Assert.assertNotEquals;
import static org.testng.Assert.assertTrue;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TablesPage extends BasePage {

    public ExtentTest test = BaseTest.test;
    private static final String LAST_NAME_TABLE2_TITLE_XPATH = "//table[@id='table2']//span[@class='last-name']";
    private static final String LAST_NAMES_TABLE2_XPATH = "//table[@id='table2']//td[@class='last-name']";

    @FindBy(xpath = LAST_NAME_TABLE2_TITLE_XPATH)
    private WebElement lastNameSorting;

    @FindBy(xpath = LAST_NAMES_TABLE2_XPATH)
    private List<WebElement> lastNamesTable2;


    public TablesPage changeSortingOrderByLastName() {
        test.log(LogStatus.INFO, "Clicking at Last Name column title...");
        lastNameSorting.click();
        return initPage(TablesPage.class);
    }

    public void checkSortingLastNames() {

        List<String> sorts = getLastNamesList();
        Collections.sort(sorts);
        List sortedASC = new ArrayList(sorts);
        Collections.sort(sorts, Collections.reverseOrder());
        List sortedDES = new ArrayList(sorts);
        changeSortingOrderByLastName();
        List<String> after1Click = getLastNamesList();
        changeSortingOrderByLastName();
        List<String> after2Click = getLastNamesList();
        test.log(LogStatus.INFO, "Asserting that displayed last names are ordered alphabetically in an ascending or descending order...");
        assertTrue(after1Click.equals(sortedASC) || after1Click.equals(sortedDES));
        assertTrue(after2Click.equals(sortedASC) || after2Click.equals(sortedDES));
        test.log(LogStatus.INFO, "Asserting that clicking at the title Last Name changes sorting order...");
        assertNotEquals(after1Click, after2Click);
    }

    private List<String> getLastNamesList() {
        test.log(LogStatus.INFO, "Getting current Last Names from Example 2...");
        List<String> getList = new ArrayList<String>(lastNamesTable2.size());
        for (WebElement element : lastNamesTable2) {
            getList.add(element.getText());
        }
        test.log(LogStatus.INFO, "Last Names: \n" + getList);
        return getList;
    }


}
