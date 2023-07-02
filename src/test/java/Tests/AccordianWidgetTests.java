package Tests;

import Base.BaseTest;
import Pages.AccordianWidgetPage;
import Pages.HomepagePage;
import Pages.SideBarPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AccordianWidgetTests extends BaseTest {

    public AccordianWidgetPage accordianWidgetPage;
    public HomepagePage homepagePage;

    @BeforeMethod
    public void pageSetUp(){
        accordianWidgetPage = new AccordianWidgetPage();
        homepagePage = new HomepagePage();
        homepagePage.clickOnCards("Widgets");
        clickOnDropdownButton("Accordian");
    }


    @Test (priority = 10)
    public void whatIsLoremIpsumCanExpand(){
        accordianWidgetPage.clickOnHeading("What is Lorem Ipsum?");   //close collapsed heading
        accordianWidgetPage.clickOnHeading("What is Lorem Ipsum?");   //again open it
        Assert.assertTrue(accordianWidgetPage.collapsedText.isDisplayed());
    }

    @Test (priority = 20)
    public void whereDoesItComeFromCanExpand(){
        accordianWidgetPage.clickOnHeading("What is Lorem Ipsum?");   //close collapsed heading
        accordianWidgetPage.clickOnHeading("Where does it come from?");
        Assert.assertTrue(accordianWidgetPage.collapsedText.isDisplayed());
    }

    @Test (priority = 30)
    public void whyDoWeUseItCanExpand(){
        accordianWidgetPage.clickOnHeading("What is Lorem Ipsum?");   //close collapsed heading
        accordianWidgetPage.clickOnHeading("Why do we use it?");
        Assert.assertTrue(accordianWidgetPage.collapsedText.isDisplayed());
    }
}
