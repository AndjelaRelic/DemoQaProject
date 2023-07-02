package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DatePickerWidgetPage extends BaseTest {

    public DatePickerWidgetPage(){
        PageFactory.initElements(driver, this);
    }

    @FindBy (id = "datePickerMonthYearInput")
    public WebElement selectDateField;

    @FindBy(id = "react-datepicker__month-container")
    public WebElement calendar;

    @FindBy(css = ".react-datepicker__navigation.react-datepicker__navigation--next")
    public WebElement nextArrow;

    @FindBy(css = ".react-datepicker__navigation.react-datepicker__navigation--previous")
    public WebElement previousArrow;

    @FindBy(className = "react-datepicker__header")
    public WebElement currentMonthHeading;

    @FindBy(className = "react-datepicker-ignore-onclickoutside")
    public WebElement openedCalendar;

    //----------------------------------------------------

    public void clickOnSelectDateField(){
        selectDateField.click();
    }
    public void clickOnNextMonthArrow(){
        nextArrow.click();
    }
    public void clickOnPreviousMonthArrow(){
        previousArrow.click();
    }

}
