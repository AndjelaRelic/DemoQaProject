package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class TextBoxPage extends BaseTest {

    public TextBoxPage (){
        PageFactory.initElements(driver, this);
    }

    @FindBy (id = "userName")
    public WebElement fullName;

    @FindBy(id = "userEmail")
    public WebElement email;

    @FindBy(id = "currentAddress")
    public WebElement currentAddress;

    @FindBy(id = "permanentAddress")
    public WebElement permanentAddress;

    @FindBy(id = "submit")
    public WebElement submitButton;

    //Elements that should appear after submit

    @FindBy(id = "name")
    public WebElement name;

    @FindBy(id = "email")
    public WebElement userEmail;

    @FindBy( id= "currentAddress")
    public List<WebElement> currentAddressField;

    @FindBy(id="permanentAddress")
    public List<WebElement>permanentAddressField;



    public void insertFullName(String user){
        fullName.clear();
        fullName.sendKeys(user);
    }

    public void insertEmail(String mail){
        email.clear();
        email.sendKeys(mail);
    }

    public void insertCurrentAddress(String currentAddress){
        currentAddressField.clear();
        currentAddressField.get(0).sendKeys(currentAddress);
    }

    public void insertPermanentAddress(String permanentAddress){
        permanentAddressField.clear();
        permanentAddressField.get(0).sendKeys(permanentAddress);
    }

    public void clickOnSubmitButton(){
        submitButton.click();
    }

}
