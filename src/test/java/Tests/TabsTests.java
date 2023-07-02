package Tests;

import Base.BaseTest;
import Pages.HomepagePage;
import Pages.TabsPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TabsTests extends BaseTest {

    public HomepagePage homepagePage;
    public TabsPage tabsPage;

    @BeforeMethod
    public void pageSetUp(){
        homepagePage = new HomepagePage();
        tabsPage = new TabsPage();
        homepagePage.clickOnCards("Widgets");
        clickOnDropdownButton("Tabs");
    }

    @Test
    public void userCanClickOnOriginTab(){
        tabsPage.clickOnOriginTab();
        Assert.assertTrue(tabsPage.activatedTabText.isDisplayed());
        Assert.assertTrue(tabsPage.activatedTabText.getText().contains("origin"));
    }

    @Test
    public void userCanClickOnWhatTab(){
        tabsPage.clickOnOriginTab();
        tabsPage.clickOnWhatTab();
        Assert.assertTrue(tabsPage.activatedTabText.isDisplayed());
    }

}
