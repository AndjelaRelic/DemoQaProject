package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SideBarPage extends BaseTest {

    public SideBarPage(){
        PageFactory.initElements(driver,this);
    }

    @FindBy(css = ".btn.btn-light")
    public List<WebElement> dropDownButtons;

    @FindBy(className = "header-text")
    public List<WebElement> buttons;

    public void clickOnMenuButton(String name) {
        for (WebElement sideBarButton : buttons) {
            if (sideBarButton.getText().equals(name)) {
                scrollIntoView(sideBarButton);
                sideBarButton.click();
                break;
            }
        }
    }

    public void clickOnSubmenuButton(String name) {
        for (WebElement sideBarButton : dropDownButtons) {
            if (sideBarButton.getText().equals(name)) {
                scrollIntoView(sideBarButton);
                sideBarButton.click();
                break;
            }
        }
    }

}
