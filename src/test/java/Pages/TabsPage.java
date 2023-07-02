package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TabsPage extends BaseTest {

    public TabsPage(){
        PageFactory.initElements(driver, this);
    }
    @FindBy (className = "tab-content")
    public WebElement tabContent;

    @FindBy(id = "demo-tab-what")
    public WebElement whatTab;

    @FindBy(id = "demo-tab-origin")
    public WebElement originTab;

    @FindBy(id = "demo-tab-use")
    public WebElement useTab;

    @FindBy(css =".fade.tab-pane.active.show")
    public WebElement activatedTabText;

    //---------------------------------------------------


    public void clickOnWhatTab(){
        whatTab.click();
    }
    public void clickOnOriginTab(){
        originTab.click();
    }
    public void clickOnUseTab(){
        useTab.click();
    }


}
