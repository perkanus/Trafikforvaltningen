package Common.sitemodel.Sjukresa;

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

    /*
     * Logga in knapp
     */
    @FindBy(xpath = "//*[@id='submit']")
    protected WebElement button_Log_In;

    /*
     * Välj användare lista
     */
    @FindBy(xpath = "//*[@id='userList']")
    protected WebElement select_User;

    /*
     * Välj arbetsplats lista
     */
    @FindBy(xpath = "//*[@id='SelectedOption']")
    protected WebElement select_Workplace;

    /*
     * Logga ut knapp
     */
    @FindBy(xpath = "//*[@class='float-right']/a")
    protected WebElement link_Log_Out;

    /*
     * Fortsätt knapp efter man valt arbetsplats
     */
    @FindBy(xpath = "//*[@id='btnContinue']")
    protected WebElement button_Continue;

    /*
     * Webelements i menyn för Sjukresewebben
     */
    @FindBy (id = "MenuStart")
    protected WebElement button_Menu_Start;

    /*
     * Meny Tillstånd
     */
    @FindBy (xpath = "//*[@id='MenuTillstand']")
    protected WebElement button_Menu_Tillstand;

    @FindBy (xpath = "//*[@id='MenuNyttTillstand']")
    protected WebElement button_Menu_Nytt_Tillstand;

    @FindBy (xpath = "//*[@id='MenuSokTillstand']")
    protected WebElement button_Menu_Sok_Tillstand;

    /*
     * Meny Sjukresekort
     */

    @FindBy (xpath = "//*[@id='MenuSjukresekort']")
    protected WebElement button_Menu_Sjukresekort;

    @FindBy (xpath = "//*[@id='MenuRegistreraSjukresekort']")
    protected WebElement button_Menu_Registrera_Sjukresekort;

    @FindBy (xpath = "//*[@id='MenuSokSjukresekort']")
    protected WebElement button_Menu_Sok_Sjukresekort;

    /*
     * Meny Uppgifter
     */

    @FindBy (xpath = "//*[@id='MenuUppgifterVardgivarwebb']")
    protected WebElement button_Menu_Uppgifter;

    @FindBy (xpath = "//*[@id='MenuBytArbetsplats']")
    protected WebElement button_Menu_Byt_Arbetsplats;

    @FindBy (xpath = "//*[@id='MenuMinaUppgifter']")
    protected WebElement button_Menu_Mina_Uppgifter;





    @FindBy (id = "Personnummer")
    protected WebElement textfield_Personnummer;

    @FindBy (id = "btnNext")
    protected WebElement button_Next;

    @FindBy (xpath = "//*[@id=\"collapsePatient\"]/div/div/div[2]")
    protected WebElement collapsed;

    @FindBy (id = "SelectedArendetyp")
    protected WebElement select_Arendetyp;

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
        if (elementHelper.isElementDisplayedWithinTime(button_Log_In, 15000))
        {
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public boolean selectFromUsers(String user) {
        if (elementHelper.isElementDisplayedWithinTime(select_User, 15000))
        {
            new Select(select_User).selectByVisibleText(user);
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public boolean selectFromWorkplace(String workplace) {
        if (elementHelper.isElementDisplayedWithinTime(select_Workplace, 15000))
        {
            new Select(select_Workplace).selectByVisibleText(workplace);
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public boolean logOutUser() {
        if (elementHelper.isElementDisplayedWithinTime(link_Log_Out, 15000))
        {
            wait.until(ExpectedConditions.elementToBeClickable(link_Log_Out)).click();
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public boolean logInUser() {
        if (elementHelper.isElementDisplayedWithinTime(button_Log_In, 15000))
        {
            wait.until(ExpectedConditions.elementToBeClickable(button_Log_In)).click();
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public boolean continueWithWorkplace() {
        if (elementHelper.isElementDisplayedWithinTime(button_Continue, 15000))
        {
            wait.until(ExpectedConditions.elementToBeClickable(button_Continue)).click();
            return true;
        }
        else {
            return false;
        }
    }


    @Override
    public boolean isStartVisible(){
        elementHelper.isElementDisplayedWithinTime(button_Menu_Start,5000);
        return true;
    }

    @Override
    public boolean clickMenuTillstand(){
        if (elementHelper.isElementDisplayedWithinTime(button_Menu_Tillstand,15000))
        {
            wait.until(ExpectedConditions.elementToBeClickable(button_Menu_Tillstand)).click();
            return true;
        }
        else {
            return false;
        }
    }


    @Override
    public boolean clickMenuNyttTillstand(){
        if (elementHelper.isElementDisplayedWithinTime(button_Menu_Nytt_Tillstand,15000))
        {
            wait.until(ExpectedConditions.elementToBeClickable(button_Menu_Nytt_Tillstand)).click();
            return true;
        }
        else {
            return false;
        }
    }

    @Override
   public boolean fyllPersonnummer(){
        if (elementHelper.isElementDisplayedWithinTime(textfield_Personnummer,10000))
        {
            wait.until(ExpectedConditions.elementToBeClickable(textfield_Personnummer)).sendKeys("191212121212");
        }

        else {
            return false;
        }
       return true;
   }

   @Override
   public void enter(){
        textfield_Personnummer.sendKeys(Keys.ENTER);
   }

   @Override
   public void arrowDown(){
        select_Arendetyp.sendKeys(Keys.ARROW_DOWN);
   }



    @Override
   public void clickNext(){
        elementHelper.clickWithinTime(button_Next,2000);
   }

   @Override
   public boolean selectArendetyp(){
        if (elementHelper.isElementDisplayedWithinTime(select_Arendetyp,2000))
        {
            wait.until(ExpectedConditions.elementToBeClickable(select_Arendetyp)).click();
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