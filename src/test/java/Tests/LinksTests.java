package Tests;

import Base.BaseTest;
import Pages.HomepagePage;
import Pages.LinksPage;
import Pages.SideBarPage;
import jdk.jfr.Description;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class LinksTests extends BaseTest {

    public LinksPage linksPage;
    public HomepagePage homepagePage;
    public SideBarPage sideBarPage;

    @BeforeMethod
    public void pageSetUp(){
        linksPage = new LinksPage();
        homepagePage = new HomepagePage();
        sideBarPage = new SideBarPage();
        homepagePage.clickOnCards("Elements");
        clickOnDropdownButton("Links");
    }


    @Description("Following links will open new tab")

    @Test(priority = 10)
    public void userCanOpenNewTabWithHomeLink(){
        linksPage.clickOnHomeLink();
        ArrayList<String> listaTabova = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(listaTabova.get(1));
        Assert.assertEquals(driver.getCurrentUrl(), homeURL);
    }

    @Test(priority = 20)
    public void userCanOpenNewTabWithHomeBNKp9Link(){
        linksPage.clickOnHomeBNKp9Link();
        ArrayList<String> listaTabova = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(listaTabova.get(2));
        Assert.assertEquals(driver.getCurrentUrl(), homeURL);
    }

    @Description("Following links will send an api call")
    @Test(priority = 30)
    public void userCanSendCreatedApiCallWithink(){
        linksPage.clickOnCreatedLink();
        Assert.assertEquals(linksPage.responseMessage.getText(), "Link has responded with staus 201 and status text Created");
    }

    @Test(priority = 40)
    public void userCanSendNoContentApiCallWithink(){
        linksPage.clickOnNoContentLink();
        Assert.assertEquals(linksPage.responseMessage.getText(), "Link has responded with staus 204 and status text No Content");
    }
}
