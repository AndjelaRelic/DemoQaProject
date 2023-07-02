package Tests;

import Base.BaseTest;
import Pages.HomepagePage;
import Pages.RadioButtonPage;
import Pages.SideBarPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RadioButtonTest extends BaseTest {

    public HomepagePage homepagePage;
    public SideBarPage sideBarPage;
    public RadioButtonPage radioButtonPage;

    @BeforeMethod
    public void pageSetUp() {
        homepagePage = new HomepagePage();
        sideBarPage = new SideBarPage();
        radioButtonPage = new RadioButtonPage();
        driver.get(homeURL);
        homepagePage.clickOnCards("Elements");
        sideBarPage.clickOnSubmenuButton("Radio Button");
    }

    @Test(priority = 10)
    public void clickOnYes() {
        radioButtonPage.clickOnYesRadio();
        Assert.assertTrue(radioButtonPage.yesRadio.isSelected());
        Assert.assertTrue(radioButtonPage.message.isDisplayed());
        Assert.assertEquals(radioButtonPage.message.getText(), "Yes");
    }

    @Test(priority = 20)
    public void clickOnImpressive() {
        radioButtonPage.clickOnImpressiveRadio();
        Assert.assertTrue(radioButtonPage.impressiveRadio.isSelected());
        Assert.assertTrue(radioButtonPage.message.isDisplayed());
        Assert.assertEquals(radioButtonPage.message.getText(), "Impressive");
    }

    @Test(priority = 30)
    public void clickOnNo() throws Exception {
        radioButtonPage.clickOnNoRadio();
        Assert.assertFalse(radioButtonPage.noRadio.isSelected());
        Assert.assertFalse(elementIsPresent(radioButtonPage.message));
    }

    @AfterMethod
    public void pageTearDown() {
        driver.manage().deleteAllCookies();
    }
}

