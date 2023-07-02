package Tests;

import Base.BaseTest;
import Pages.DatePickerWidgetPage;
import Pages.HomepagePage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DatePickerWidgetTests extends BaseTest {

    public DatePickerWidgetPage datePickerWidgetPage;
    public HomepagePage homepagePage;

    @BeforeMethod
    public void pageSetUp(){
        datePickerWidgetPage = new DatePickerWidgetPage();
        homepagePage = new HomepagePage();
        homepagePage.clickOnCards("Widgets");
        clickOnDropdownButton("Date Picker");
    }

    @Test (priority = 10)
    public void calendarShowsWhenClickOnSelectDateField(){
        datePickerWidgetPage.clickOnSelectDateField();
        Assert.assertTrue(datePickerWidgetPage.openedCalendar.isDisplayed());
    }
    @Test(priority = 20)
    public void userCanGoToNextMonth(){
        datePickerWidgetPage.clickOnSelectDateField();
        String month = datePickerWidgetPage.currentMonthHeading.getText();
        datePickerWidgetPage.clickOnNextMonthArrow();
        Assert.assertFalse(datePickerWidgetPage.currentMonthHeading.getText().equals(month));
    }
    @Test(priority = 30)
    public void userCanGoToPreviousMonth(){
        datePickerWidgetPage.clickOnSelectDateField();
        String month = datePickerWidgetPage.currentMonthHeading.getText();
        datePickerWidgetPage.clickOnPreviousMonthArrow();
        Assert.assertFalse(datePickerWidgetPage.currentMonthHeading.getText().equals(month));
    }

}
