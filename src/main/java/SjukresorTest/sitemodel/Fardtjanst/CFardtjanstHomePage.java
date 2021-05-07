package SjukresorTest.sitemodel.Fardtjanst;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import se.soprasteria.automatedtesting.webdriver.api.base.BasePageObject;
import se.soprasteria.automatedtesting.webdriver.helpers.driver.AutomationDriver;

public class CFardtjanstHomePage extends BasePageObject implements IFardtjanstHomePage {

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

    @FindBy (id = "MenuStart")
    protected WebElement startMenu;

    @FindBy (id = "MenuFardtjanstarende")
    protected WebElement fardtjanstMenu;

    @FindBy (id = "MenuNyttTillstand")
    protected WebElement skapaTillstandMenu;

    @FindBy (id = "MenuSokTillstand")
    protected WebElement sokTillstandMenu;

    @FindBy (id = "MenuSkapaArende")
    protected WebElement sokPerson;

    @FindBy (id = "ConfirmSkapaArendeOchUtredning")
    protected WebElement createUtredning;

    @FindBy (id = "TaAgarskapOchStartaUtredning")
    protected WebElement takeOwnership;

    @FindBy (id = "Personnummer")
    protected WebElement personnummer;

    public CFardtjanstHomePage(AutomationDriver driver) {
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

    @Override
    public boolean clickMenuFardtjanst(){
        if (elementHelper.isElementDisplayedWithinTime(fardtjanstMenu,5000))
        {
            wait.until(ExpectedConditions.elementToBeClickable(fardtjanstMenu)).click();
            return true;
        }
        else {
            return false;
        }

    }






    @Override
    public boolean clickSokPerson(){
        if (elementHelper.isElementDisplayedWithinTime(sokPerson,5000))
        {
            wait.until(ExpectedConditions.elementToBeClickable(sokPerson)).click();
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public boolean clickCreateUtredning(){
        if (elementHelper.isElementDisplayedWithinTime(createUtredning,5000))
        {
            wait.until(ExpectedConditions.elementToBeClickable(createUtredning)).click();
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public boolean clickTakeOwnership(){
        if (elementHelper.isElementDisplayedWithinTime(takeOwnership,5000))
        {
            wait.until(ExpectedConditions.elementToBeClickable(takeOwnership)).click();
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public boolean isStartVisible(){
        elementHelper.isElementDisplayedWithinTime(startMenu,5000);
        return true;
    }

    public boolean fyllPersonnummer(){
        if (elementHelper.isElementDisplayedWithinTime(personnummer,10000))
        {
            wait.until(ExpectedConditions.elementToBeClickable(personnummer)).sendKeys("191212121212");
        }

        else {
            return false;
        }
        return true;
    }










}