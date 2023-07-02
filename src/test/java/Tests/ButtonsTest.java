package Tests;

import Base.BaseTest;
import Pages.ButtonsPage;
import Pages.HomepagePage;
import Pages.SideBarPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ButtonsTest extends BaseTest {

    public SideBarPage sideBarPage;
    public HomepagePage homepagePage;
    public ButtonsPage buttonsPage;

    @BeforeMethod
    public void pageSetUp() throws InterruptedException {
        homepagePage = new HomepagePage();
        sideBarPage = new SideBarPage();
        buttonsPage = new ButtonsPage();
        driver.get(homeURL);
        homepagePage.clickOnCards("Elements");
        sideBarPage.clickOnSubmenuButton("Buttons");
        Thread.sleep(1000);
    }

    @Test(priority = 10)
    public void doubleClickMe() {
        buttonsPage.doubleClickOnButton();
        Assert.assertTrue(buttonsPage.doubleClickMessage.isDisplayed());
        Assert.assertEquals(buttonsPage.doubleClickMessage.getText(), "You have done a double click");
    }

    @Test(priority = 20)
    public void rightClickMe() {
        buttonsPage.rightClickOnButton();
        Assert.assertTrue(buttonsPage.rightClickMessage.isDisplayed());
        Assert.assertEquals(buttonsPage.rightClickMessage.getText(), "You have done a right click");
    }

    @Test(priority = 30)
    public void clickMe() {
        buttonsPage.clickOnClickButton();
        Assert.assertTrue(buttonsPage.dynamicClickMessage.isDisplayed());
        Assert.assertEquals(buttonsPage.dynamicClickMessage.getText(), "You have done a dynamic click");
    }

    @AfterMethod
    public void pageTearDown() {
        driver.manage().deleteAllCookies();
    }
}

