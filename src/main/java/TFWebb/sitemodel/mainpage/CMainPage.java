package TFWebb.sitemodel.mainpage;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import se.soprasteria.automatedtesting.webdriver.api.base.BasePageObject;
import se.soprasteria.automatedtesting.webdriver.helpers.driver.AutomationDriver;

public class CMainPage extends BasePageObject implements IMainPage {

    WebDriverWait wait = new WebDriverWait(driver,10);

    @FindBy(xpath = "//*[@id='submit']")
    protected WebElement btnLogin;

    @FindBy(xpath = "//*[@id='userList']")
    protected WebElement selectUsers;

    @FindBy(xpath = "//*[@id='SelectedOption']")
    protected WebElement selectWorkplace;

    @FindBy(xpath = "//*[@class='float-right']/a")
    protected WebElement linkLogOut;

    @FindBy(xpath = "//*[@id='btnContinue']")
    protected WebElement btnContinue;

    public CMainPage(AutomationDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageLoaded() {
        if (elementHelper.isElementDisplayedWithinTime(btnLogin, 15000))
        {
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public boolean selectFromUsers(String user) {
        if (elementHelper.isElementDisplayedWithinTime(selectUsers, 15000))
        {
            new Select(selectUsers).selectByVisibleText(user);
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public boolean selectFromWorkplace(String workplace) {
        if (elementHelper.isElementDisplayedWithinTime(selectWorkplace, 15000))
        {
            new Select(selectWorkplace).selectByVisibleText(workplace);
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public boolean logOutUser() {
        if (elementHelper.isElementDisplayedWithinTime(linkLogOut, 15000))
        {
            wait.until(ExpectedConditions.elementToBeClickable(linkLogOut)).click();
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public boolean logInUser() {
        if (elementHelper.isElementDisplayedWithinTime(btnLogin, 15000))
        {
            wait.until(ExpectedConditions.elementToBeClickable(btnLogin)).click();
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public boolean continueWithWorkplace() {
        if (elementHelper.isElementDisplayedWithinTime(btnContinue, 15000))
        {
            wait.until(ExpectedConditions.elementToBeClickable(btnContinue)).click();
            return true;
        }
        else {
            return false;
        }
    }

    @FindBy(xpath = "//*[@id=\"MenuTillstand\"]")
    protected WebElement menuTillstand;

    @FindBy(xpath = "//*[@id=\"MenuNyttTillstand\"]")
    protected WebElement menuNyttTillstand;

    @FindBy(xpath = "//*[@id=\"Personnummer\"]")
    protected WebElement editPNR;

    @Override
    public boolean skapaSjukresetillstånd() {

        try {
            if (elementHelper.isElementDisplayedWithinTime(menuTillstand, 15000))
            {
                wait.until(ExpectedConditions.elementToBeClickable(menuTillstand)).click();
                wait.until(ExpectedConditions.elementToBeClickable(menuNyttTillstand)).click();
                wait.until(ExpectedConditions.elementToBeClickable(editPNR)).sendKeys("192703039202");
            }
            return true;
        }
        catch (Exception e){
            return false;
        }

    }

    @Override
    public boolean sokSjukresetillstånd() {
        return false;
    }

    @Override
    public boolean skapaSjukresekort() {
        return false;
    }

    @Override
    public boolean sokSjukresekort() {
        return false;
    }
}
