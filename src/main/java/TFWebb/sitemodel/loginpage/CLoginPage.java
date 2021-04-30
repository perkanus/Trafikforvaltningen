package TFWebb.sitemodel.loginpage;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import se.soprasteria.automatedtesting.webdriver.api.base.BasePageObject;
import se.soprasteria.automatedtesting.webdriver.helpers.driver.AutomationDriver;

public class CLoginPage extends BasePageObject implements ILoginPage {

    WebDriverWait wait = new WebDriverWait(driver, 30);

    @FindBy(id = "details-button")
    protected WebElement advancedButton;

    @FindBy(id = "proceed-link")
    protected WebElement proceedButton;

    @FindBy(xpath = "//*[@class='form-group bmd-form-group']/a")
    protected WebElement linkLogin;

    @FindBy(xpath = "//*[@class='btn btn-secondary']")
    protected WebElement btnCookie;

    @Override
    public boolean isPageLoaded() {

        if (elementHelper.isElementDisplayedWithinTime(linkLogin, 15000)) {
            if (elementHelper.isElementDisplayedWithinTime(btnCookie, 15000)) {
                wait.until(ExpectedConditions.elementToBeClickable(btnCookie)).click();
            } else {
                return false;
            }
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean logIn() {
        if (elementHelper.isElementDisplayedWithinTime(linkLogin, 5000)) {
            wait.until(ExpectedConditions.elementToBeClickable(linkLogin)).click();
        } else {
            return false;
        }
        return true;
    }

    public CLoginPage(AutomationDriver driver) {
        super(driver);
    }

    @Override
    public boolean advanced() {
        if (elementHelper.isElementDisplayedWithinTime(advancedButton, 5000)) {
            wait.until(ExpectedConditions.elementToBeClickable(advancedButton)).click();
        } else {
            return false;
        }
        return true;
    }

    @Override
    public boolean proceed() {
        if (elementHelper.isElementDisplayedWithinTime(proceedButton, 5000)) {
            wait.until(ExpectedConditions.elementToBeClickable(proceedButton)).click();
        } else {
            return false;
        }
        return true;
    }

}
