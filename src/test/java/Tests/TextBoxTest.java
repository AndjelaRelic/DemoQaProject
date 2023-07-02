package Tests;

import Base.BaseTest;
import Pages.HomepagePage;
import Pages.SideBarPage;
import Pages.TextBoxPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TextBoxTest extends BaseTest {

    public HomepagePage homepagePage;
    public TextBoxPage textBoxPage;
    public SideBarPage sideBarPage;

    @BeforeMethod
    public void pageSetUp() {
        homepagePage = new HomepagePage();
        textBoxPage = new TextBoxPage();
        sideBarPage = new SideBarPage();
    }

    @Test(priority = 10)

    public void fillingTextBoxForm() {
        homepagePage.clickOnCards("Elements");
        clickOnDropdownButton("Text Box");
        String fullName = excelReader.getStringData("TextBox", 1, 0);
        String email = excelReader.getStringData("TextBox", 1, 1);
        String currentAddress = excelReader.getStringData("TextBox", 1, 2);
        String permanentAddress = excelReader.getStringData("TextBox", 1, 3);
        textBoxPage.insertFullName(fullName);
        textBoxPage.insertEmail(email);
        textBoxPage.insertCurrentAddress(currentAddress);
        textBoxPage.insertPermanentAddress(permanentAddress);
        textBoxPage.clickOnSubmitButton();
        System.out.println();
        Assert.assertEquals(textBoxPage.name.getText(), "Name:Andjela");
        Assert.assertTrue(textBoxPage.name.isDisplayed());
        Assert.assertTrue(textBoxPage.email.isDisplayed());
        Assert.assertTrue(textBoxPage.currentAddressField.get(1).isDisplayed());
        Assert.assertTrue(textBoxPage.permanentAddressField.get(1).isDisplayed());

    }
}


