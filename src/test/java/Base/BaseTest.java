package Base;

import Pages.SideBarPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import java.io.IOException;
import java.time.Duration;


public class BaseTest {
    public static WebDriver driver;
    public WebDriverWait wait;
    public ExcelReader excelReader;
    public String homeURL;
    public SideBarPage sideBarPage;
    public static Actions actions;
    public JavascriptExecutor js;


    @BeforeClass
    public void setUp() throws IOException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        excelReader = new ExcelReader("src/test/java/TestData.xlsx");
        homeURL = excelReader.getStringData("URL", 1, 0);
        driver.get(homeURL);
        sideBarPage = new SideBarPage();
        actions = new Actions(driver);
        js = (JavascriptExecutor) driver;

    }

    //---------------------------------------------------

    public void clickOnDropdownButton(String name) {
        for (WebElement buttnos : sideBarPage.dropDownButtons) {
            if (buttnos.getText().equals(name)) {
                scrollIntoView(buttnos);
                buttnos.click();
                break;
            }
        }
    }

    public void scrollIntoView(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }
    public void waitForURL(String URL) {
        wait.until(ExpectedConditions.urlToBe(URL));
    }

    public void waitForVisibility(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForClickability(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public boolean elementIsPresent(WebElement element) throws Exception {
        boolean nonExistingElement = false;
        try {
            nonExistingElement = element.isDisplayed();
        } catch (Exception e) {
        }
        return nonExistingElement;
    }
    public boolean alertIsPresent() throws Exception {
        boolean nonExistingElement = false;
        try {
            Alert alert = driver.switchTo().alert();
            return true;
        } catch (Exception e) {
        }
        return nonExistingElement;
    }

    public void openNewTab() {
        js.executeScript("window.open()");
    }

    public void doubleClick(WebElement element) {
        actions.doubleClick(element).perform();
    }

    public void rightClick(WebElement element) {
        actions.contextClick(element).perform();
    }


    @AfterClass
    public void tearDown() {
//        driver.manage().deleteAllCookies();
//        driver.quit();
    }
}

