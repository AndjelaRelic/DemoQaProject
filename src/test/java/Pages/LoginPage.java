package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BaseTest {

    public LoginPage (){
        PageFactory.initElements(driver, this);
    }

    @FindBy (id = "userName")
    public WebElement username;

    @FindBy (id = "password")
    public WebElement password;

    @FindBy (id = "login")
    public WebElement loginButton;
    @FindBy(className= "mb-1")
    public WebElement messageInvalid;

    //-----------------------------------------------------------

    public void insertUsername(String user){
        username.clear();
        username.sendKeys(user);
    }

    public void insertPassword(String pass){
        password.clear();
        password.sendKeys(pass);
    }

    public void clickOnLoginButton(){
        loginButton.click();
    }
}
