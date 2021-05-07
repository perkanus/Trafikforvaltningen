package SjukresorTest.sitemodel.Sjukresa;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import se.soprasteria.automatedtesting.webdriver.api.base.BasePageObject;
import se.soprasteria.automatedtesting.webdriver.helpers.driver.AutomationDriver;

public class CSjukresaSjukresaHomePage extends BasePageObject implements ISjukresaHomePage {

    WebDriverWait wait = new WebDriverWait(driver, 30);

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
    protected WebElement startButton;

    @FindBy (xpath = "//*[@id=\"MenuTillstand\"]")
    protected WebElement menuTillstand;

    @FindBy (xpath = "//*[@id=\"MenuNyttTillstand\"]")
    protected WebElement skapaNyttTillstand;

    @FindBy (id = "Personnummer")
    protected WebElement personnummer;

    @FindBy (id = "btnNext")
    protected WebElement nextButton;

    @FindBy (xpath = "//*[@id=\"collapsePatient\"]/div/div/div[2]")
    protected WebElement collapsed;

    @FindBy (id = "SelectedArendetyp")
    protected WebElement selectArendetyp;

    @FindBy (linkText = "Sjukresa med sjukresekort")
    protected WebElement sjukresaMedSjukresekort;

    @FindBy (id = "MenuStart")
    protected WebElement startMenu;

    @FindBy(id = "MenuTillstand")
    protected WebElement tillstandtMenu;

    @FindBy (id = "MenuSjukresekort")
    protected WebElement sjukresekorteMenu;

    @FindBy (id = "MenuUppgifterVardgivarwebb")
    protected WebElement uppgifterMenu;

    @FindBy (id = "MenuFardtjanst")
    protected WebElement fardtjanstMenu;

    @FindBy (id = "MenuNyttTillstand")
    protected WebElement skapaTillstandMenu;

    @FindBy (id = "MenuSokTillstand")
    protected WebElement sokTillstandMenu;


    @FindBy (id = "MenuSkapaArende")
    protected WebElement sokPerson;







    public CSjukresaSjukresaHomePage(AutomationDriver driver) {
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
    public boolean isStartVisible(){
        elementHelper.isElementDisplayedWithinTime(startButton,5000);
        return true;
    }

    @Override
    public boolean clickMenuTillstand(){
        if (elementHelper.isElementDisplayedWithinTime(menuTillstand,15000))
        {
            wait.until(ExpectedConditions.elementToBeClickable(menuTillstand)).click();
            return true;
        }
        else {
            return false;
        }
    }


    @Override
    public boolean clickMenuNyttTillstand(){
        if (elementHelper.isElementDisplayedWithinTime(skapaNyttTillstand,15000))
        {
            wait.until(ExpectedConditions.elementToBeClickable(skapaNyttTillstand)).click();
            return true;
        }
        else {
            return false;
        }
    }

    @Override
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

   @Override
   public void enter(){
        personnummer.sendKeys(Keys.ENTER);
   }

   @Override
   public void arrowDown(){
        selectArendetyp.sendKeys(Keys.ARROW_DOWN);
   }



    @Override
   public void clickNext(){
        elementHelper.clickWithinTime(nextButton,2000);
   }

   @Override
   public boolean selectArendetyp(){
        if (elementHelper.isElementDisplayedWithinTime(selectArendetyp,2000))
        {
            wait.until(ExpectedConditions.elementToBeClickable(selectArendetyp)).click();
           //wait.until(ExpectedConditions.elementToBeClickable(sjukresaMedSjukresekort)).click();
           return true;
       }
        else {
            return false;
       }

   }


    public enum menuItems {
        START, TILLSTAND, SJUKRESEKORT, UPPGIFTER
    }


    public enum Menu {
        Tillstand(null),
        Skapa(Tillstand),
        Sok(Tillstand),
        Sjukresekort(null) {
        },
        Registera(Sjukresekort),
        //Sok(Sjukresekort),

        ;
        private CSjukresaSjukresaHomePage.Menu parent = null;

        private Menu(CSjukresaSjukresaHomePage.Menu parent) {
            this.parent = parent;
        }
    }




    public boolean selectInMenu13(CSjukresaSjukresaHomePage.Menu item) {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        try {
            switch (item) {
                case Tillstand:
                    wait.until(ExpectedConditions.elementToBeClickable(tillstandtMenu)).click();
                    break;
                case Skapa:
                    wait.until(ExpectedConditions.elementToBeClickable(skapaTillstandMenu)).click();
                    break;
                case Sok:
                    wait.until(ExpectedConditions.elementToBeClickable(sokTillstandMenu)).click();
                    break;
            }
            return true;
        } catch (Exception e) {
            logger.error("Johnny B good" + e.getMessage());
            return false;
        }
    }





    public boolean selectInMenu(CSjukresaSjukresaHomePage.menuItems item) {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        try {
            switch (item) {
                case START:
                    wait.until(ExpectedConditions.elementToBeClickable(startMenu)).click();
                    break;
                case TILLSTAND:
                    wait.until(ExpectedConditions.elementToBeClickable(tillstandtMenu)).click();
                    break;
                case SJUKRESEKORT:
                    wait.until(ExpectedConditions.elementToBeClickable(sjukresekorteMenu)).click();
                    break;
                case UPPGIFTER:
                    wait.until(ExpectedConditions.elementToBeClickable(uppgifterMenu)).click();
                    break;
                default:
                    break;
            }
            return true;
        } catch (Exception e) {
            logger.error("Johnny B good" + e.getMessage());
            return false;
        }
    }


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










}