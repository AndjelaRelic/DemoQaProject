package Tests;

import Base.BaseTest;
import Pages.HomepagePage;
import Pages.SelectablePage;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SelectableTests extends BaseTest {

    public SelectablePage selectablePage;
    public HomepagePage homepagePage;

    public String activeColor = "rgba(0, 123, 255, 1)";

    @BeforeMethod
    public void pageSetUp() {
        selectablePage = new SelectablePage();
        homepagePage = new HomepagePage();
        homepagePage.clickOnCards("Interactions");
        clickOnDropdownButton("Selectable");
    }

    @Test (priority = 10)
    public void clickOnItemsFromList() {
        for (WebElement item : selectablePage.listItems) {
            WebElement selectedItem = selectablePage.selectListItems(item.getText());
            Assert.assertTrue(selectedItem.getAttribute("class").contains("active"));  //when item is selected, class name get "active" word in class name
            Assert.assertEquals(selectedItem.getCssValue("background-color"), activeColor);
        }
    }

    @Test (priority = 10)
    public void clickOnItemsFromGrid() {
        scrollIntoView(selectablePage.gridContainer);
        selectablePage.clickOnGrid();
        for (WebElement item : selectablePage.gridItems) {
            WebElement selectedItem = selectablePage.selectGridItems(item.getText());
            Assert.assertTrue(selectedItem.getAttribute("class").contains("active"));  //when item is selected, class name get "active" word in class name
            Assert.assertEquals(selectedItem.getCssValue("background-color"), activeColor);
        }
    }
}