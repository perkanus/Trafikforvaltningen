package DataLoading.SJR;

import Common.data.Helpers;
import Common.sitemodel.Sjukresa.CSjukresaSjukresaHomePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import se.soprasteria.automatedtesting.webdriver.api.base.BasePageObject;
import se.soprasteria.automatedtesting.webdriver.helpers.driver.AutomationDriver;

public class CSJRDataload extends BasePageObject implements ISJRDataload {
    boolean VISUAL_DEBUG = true;
    boolean TIME_DELAY = true;
    int DELAY_LENGTH = 1000;

    WebDriverWait wait = new WebDriverWait(driver, 30);
    Helpers helper = new Helpers();

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


    /*
     * Meny SJRÄrendeuppgifter
     */

    // radio_PNR och radioRNR är på full xpath. Kanske be utvecklarna att byta ID eller namn på dem eftersom de har densamma

    @FindBy (xpath = "/html/body/main/div/form/div[1]/div/div[2]/div/div/div[1]/div[1]/div[1]/div[1]/label/input")
    protected WebElement radio_PNR;

    @FindBy (xpath = "/html/body/main/div/form/div[1]/div/div[2]/div/div/div[1]/div[1]/div[1]/div[2]/label/input")
    protected WebElement radio_RNR;

    @FindBy (id = "Personnummer")
    protected WebElement textfield_Personnummer;

    @FindBy (xpath = "//*[@id='SelectedArendetyp']")
    protected WebElement select_Arendetyp;

    @FindBy (xpath = "//*[@id='Kortnummer']")
    protected WebElement textfield_Kortnummer;

    @FindBy (xpath = "//*[@id='btnNext']")
    protected WebElement button_Next;

    @FindBy (xpath = "//*[@id='GiltigtFran']")
    protected WebElement datePicker_GiltigtFran;

    @FindBy (xpath = "//*[@id='GiltigtTill']")
    protected WebElement datePicker_GiltigtTill;

    @FindBy (xpath = "//*[@id='MedicinskTitelNamn']")
    protected WebElement textfield_MedicinskTitelNamn;

    @FindBy (xpath = "//div[@id='divMedicinskTitel']/span/span/span/span[2]")
    protected WebElement button_MedicinskTitel;

    @FindBy (xpath = "//input[@type='search']")
    protected WebElement textfield_MedicinskTitel;

    /*
    * Reseinformation
     */
    // Radioknappar

    @FindBy (xpath = "//*[@value='2600']")
    protected WebElement radio_RTVOB;

    @FindBy (xpath = "//*[@value='2601']")
    protected WebElement radio_RTAVFPA;

    @FindBy (xpath = "//*[@value='2602']")
    protected WebElement radio_RMV;

    @FindBy (xpath = "//*[@value='2604']")
    protected WebElement radio_RTVIAL;

    // Färdsätt
    @FindBy (xpath = "//*[@id='SelectedFardsatt']")
    protected WebElement select_Fardsatt;

    // Antal resor
    @FindBy (xpath = "//*[@id='AntalResor']")
    protected WebElement textfield_AntalResor;

    // Antal medföljande
    @FindBy (xpath = "//*[@id='SelectedAntalMedfoljande']")
    protected WebElement select_AntalMedfoljande;

    // Uttökad hämtning/lämning, Ensamåkning, Framsätesplacering
    @FindBy (xpath = "//*[@id='UtokadHamtningLamning']")
    protected WebElement check_UtokadHamtningLamning;

    @FindBy (xpath = "//*[@id='Ensamakning']")
    protected WebElement check_Ensamakning;

    @FindBy (xpath = "//*[@id='Framsatesplacering']")
    protected WebElement check_Framsatesplacering;

    // Lägg till reseinformation
    @FindBy (xpath = "//*[@id='btnAddReseinformation']")
    protected WebElement button_AddReseinformation;


    public CSJRDataload(AutomationDriver driver) {
        super(driver);
    }


    @Override
    public boolean LoginToWebb(String user, String workplace) {
        try {
            // Välj användare från listan
            if (elementHelper.isElementDisplayedWithinTime(select_User, 15000))
                new Select(select_User).selectByVisibleText(user);
            // Tryck Log in knappen
            if (elementHelper.isElementDisplayedWithinTime(button_Log_In, 15000))
                wait.until(ExpectedConditions.elementToBeClickable(button_Log_In)).click();
            // Välj arbetsplats
            if (elementHelper.isElementDisplayedWithinTime(select_Workplace, 15000))
                new Select(select_Workplace).selectByValue(workplace);
            // Tryck fortsätt knappen
            if (elementHelper.isElementDisplayedWithinTime(button_Continue, 15000))
                wait.until(ExpectedConditions.elementToBeClickable(button_Continue)).click();
            return true;
        }
        catch (Exception ex)
        {
            return false;
        }
        finally
        {

        }

    }

    @Override
    public boolean CheckIfTopMenuIsVisible() {
        try
        {
            wait.until(ExpectedConditions.elementToBeClickable(button_Menu_Start));
            wait.until(ExpectedConditions.elementToBeClickable(button_Menu_Tillstand));
                //wait.until(ExpectedConditions.elementToBeClickable(button_Menu_Nytt_Tillstand));
                //wait.until(ExpectedConditions.elementToBeClickable(button_Menu_Sok_Tillstand));
            wait.until(ExpectedConditions.elementToBeClickable(button_Menu_Sjukresekort));
                //wait.until(ExpectedConditions.elementToBeClickable(button_Menu_Registrera_Sjukresekort));
                //wait.until(ExpectedConditions.elementToBeClickable(button_Menu_Sok_Sjukresekort));
            wait.until(ExpectedConditions.elementToBeClickable(button_Menu_Uppgifter));
                //wait.until(ExpectedConditions.elementToBeClickable(button_Menu_Byt_Arbetsplats));
                //wait.until(ExpectedConditions.elementToBeClickable(button_Menu_Mina_Uppgifter));
            return true;
        }
        catch (Exception ex)
        {
            return false;
        }
        finally
        {

        }
    }

    @Override
    public boolean CreateSJRTillstand() {
        try
        {
            return true;
        }
        catch (Exception ex) {
            return false;
        }
        finally {

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
    public boolean FillIDNumber(String s_Personnummer) {
        if (elementHelper.isElementDisplayedWithinTime(textfield_Personnummer,10000))
        {
            helper.drawBorder(driver,textfield_Personnummer,"red",3);
            wait.until(ExpectedConditions.elementToBeClickable(textfield_Personnummer)).sendKeys(s_Personnummer);
            wait.until(ExpectedConditions.elementToBeClickable(textfield_Personnummer)).sendKeys(Keys.ENTER);
        }
        else {
            return false;
        }
        return true;
    }

    @Override
    public boolean SelectIDType(String s_ID_Type) {
        if(s_ID_Type == "Personnummer")
        {
            if (elementHelper.isElementDisplayedWithinTime(radio_PNR, 10000)) {
                wait.until(ExpectedConditions.elementToBeClickable(radio_PNR)).click();
            } else {
                return false;
            }
        }
        else
        {
            if (elementHelper.isElementDisplayedWithinTime(radio_RNR, 10000)) {
                wait.until(ExpectedConditions.elementToBeClickable(radio_RNR)).click();
            } else {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean SelectPermitType(String s_PermitType) {
        if(s_PermitType == "Sjukresekort")
        {
            if (elementHelper.isElementDisplayedWithinTime(select_Arendetyp, 10000)) {
                new Select(select_Arendetyp).selectByVisibleText("Sjukresa med sjukresekort");
            } else {
                return false;
            }
        }
        else
        {
            if (elementHelper.isElementDisplayedWithinTime(select_Arendetyp, 10000)) {
                new Select(select_Arendetyp).selectByVisibleText("Ersättning för utförd resa");
            } else {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean FillCardNumber(String s_CardNumber) {
        if (elementHelper.isElementDisplayedWithinTime(textfield_Kortnummer,10000))
        {
            wait.until(ExpectedConditions.elementToBeClickable(textfield_Kortnummer)).sendKeys(s_CardNumber);
            //wait.until(ExpectedConditions.elementToBeClickable(textfield_Kortnummer)).sendKeys(Keys.ENTER);
        }
        else {
            return false;
        }
        return true;
    }

    @Override
    public boolean PressNextButton() {
        if (elementHelper.isElementDisplayedWithinTime(button_Next, 10000)) {
            wait.until(ExpectedConditions.elementToBeClickable(button_Next)).click();
        } else {
            return false;
        }
        return true;
    }

    @Override
    public boolean SetDate(String s_Date, boolean bl_from) {
        if(bl_from == true)
        {
            if (elementHelper.isElementDisplayedWithinTime(datePicker_GiltigtFran,10000))
            {
                wait.until(ExpectedConditions.elementToBeClickable(datePicker_GiltigtFran)).sendKeys(s_Date);
                wait.until(ExpectedConditions.elementToBeClickable(datePicker_GiltigtFran)).sendKeys(Keys.ENTER);
            }
            else {
                return false;
            }
        }
        else
        {
            if (elementHelper.isElementDisplayedWithinTime(datePicker_GiltigtTill,10000))
            {
                wait.until(ExpectedConditions.elementToBeClickable(datePicker_GiltigtTill)).sendKeys(s_Date);
                wait.until(ExpectedConditions.elementToBeClickable(datePicker_GiltigtTill)).sendKeys(Keys.ENTER);
            }
            else {
                return false;
            }
        }

        return true;
    }

    @Override
    public boolean FillMedicalTitleName(String s_MedicalTitleName) {
        if (elementHelper.isElementDisplayedWithinTime(textfield_MedicinskTitelNamn,10000))
        {
            wait.until(ExpectedConditions.elementToBeClickable(textfield_MedicinskTitelNamn)).sendKeys(s_MedicalTitleName);
            //wait.until(ExpectedConditions.elementToBeClickable(textfield_Kortnummer)).sendKeys(Keys.ENTER);
        }
        else {
            return false;
        }
        return true;
    }
    //*[@id="divMedicinskTitel"]/span[1]/span[1]/span
    //*[@id="SelectedMedicinskTitel"]

    @Override
    public boolean FillMedicalTitle(String s_MedicalTitle) {
        if (elementHelper.isElementDisplayedWithinTime(button_MedicinskTitel,10000))
        {
            wait.until(ExpectedConditions.elementToBeClickable(button_MedicinskTitel)).click();
            wait.until(ExpectedConditions.elementToBeClickable(textfield_MedicinskTitel)).sendKeys(s_MedicalTitle);
            wait.until(ExpectedConditions.elementToBeClickable(textfield_MedicinskTitel)).sendKeys(Keys.ENTER);
            //new Select(select_MedicinskTitel).selectByVisibleText(s_MedicalTitle);
        }
        else {
            return false;
        }
        return true;
    }

    @Override
    public boolean AddReseinformation(String s_TypAvResa, String s_Fardsatt, int i_Enkelresor, int i_AntalMedfoljande, boolean bl_UHOL, boolean bl_Enamakning, boolean bl_Framstesplacering) {
        /* *** TYP AV RESA *** */
        try
        {
            switch (s_TypAvResa)
            {
                case "RTVOB":
                    if (elementHelper.isElementDisplayedWithinTime(radio_RTVOB, 10000)) {
                        if(VISUAL_DEBUG)
                            helper.drawBorder(driver,radio_RTVOB, "red", 3);
                        if (TIME_DELAY)
                            sleep(DELAY_LENGTH);
                        wait.until(ExpectedConditions.elementToBeClickable(radio_RTVOB)).click();
                    } else {
                        return false;
                    }
                    break;
                case "RMV":
                    if (elementHelper.isElementDisplayedWithinTime(radio_RMV, 10000)) {
                        wait.until(ExpectedConditions.elementToBeClickable(radio_RMV)).click();
                    } else {
                        return false;
                    }
                    break;
                case "RTAVFPA":
                    if (elementHelper.isElementDisplayedWithinTime(radio_RTAVFPA, 10000)) {
                        wait.until(ExpectedConditions.elementToBeClickable(radio_RTAVFPA)).click();
                    } else {
                        return false;
                    }
                    break;
                case "RTVIAL":
                    if (elementHelper.isElementDisplayedWithinTime(radio_RTVIAL, 10000)) {
                        wait.until(ExpectedConditions.elementToBeClickable(radio_RTVIAL)).click();
                    } else {
                        return false;
                    }
                    break;
                default:
                    break;
            }

        }
        catch (Exception ex1)
        {
            logger.error("TYP AV RESA EXCEPTION:" + ex1.getMessage());
            return false;
        }
        finally
        {
            logger.info("TYP AV RESA");
        }

        /* *** FÄRDSÄTT *** */
        try
        {

            if (elementHelper.isElementDisplayedWithinTime(select_Fardsatt, 15000))
            {
                if(VISUAL_DEBUG)
                    helper.drawBorder(driver,select_Fardsatt, "red", 3);
                if (TIME_DELAY)
                    sleep(DELAY_LENGTH);
                new Select(select_Fardsatt).selectByVisibleText(s_Fardsatt);

            }
        }

        catch (Exception ex1)
        {
            logger.error("FÄRDSÄTT EXCEPTION:" + ex1.getMessage());
            return false;
        }
        finally
        {
            logger.info("FÄRDSÄTT");
        }

        /* *** ANTAL ENKELRESOR *** */
        try
        {
            if (elementHelper.isElementDisplayedWithinTime(textfield_AntalResor,10000))
            {
                if(VISUAL_DEBUG)
                    helper.drawBorder(driver,textfield_AntalResor, "red", 3);
                if (TIME_DELAY)
                    sleep(DELAY_LENGTH);
                wait.until(ExpectedConditions.elementToBeClickable(textfield_AntalResor)).sendKeys(String.valueOf(i_Enkelresor));
            }
        }

        catch (Exception ex1)
        {
            logger.error("ANTAL ENKELRESOR EXCEPTION:" + ex1.getMessage());
            return false;
        }
        finally
        {
            logger.info("ANTAL ENKELRESOR");
        }

        /* *** ANTAL MEDFÖLJANDE *** */
        try
        {
            if(i_AntalMedfoljande !=0)
            {
                if (elementHelper.isElementDisplayedWithinTime(select_AntalMedfoljande, 15000)) {
                    if(VISUAL_DEBUG)
                    helper.drawBorder(driver,select_AntalMedfoljande, "red", 3);
                    if (TIME_DELAY)
                        sleep(DELAY_LENGTH);
                    new Select(select_AntalMedfoljande).selectByValue(String.valueOf(i_AntalMedfoljande));
                }
            }
        }

        catch (Exception ex1)
        {
            logger.error("ANTAL MEDFÖLJANDE EXCEPTION:" + ex1.getMessage());
            return false;
        }
        finally
        {
            logger.info("ANTAL MEDFÖLJANDE");
        }

        /* *** UTÖKAD HÄMTNING OCH LÄMNING *** */
        try
        {
            if((bl_UHOL))
                if (elementHelper.isElementDisplayedWithinTime(check_UtokadHamtningLamning, 10000)) {
                    if(VISUAL_DEBUG)
                        helper.drawBorder(driver,check_UtokadHamtningLamning, "red", 3);
                    if (TIME_DELAY)
                        sleep(DELAY_LENGTH);
                    wait.until(ExpectedConditions.elementToBeClickable(check_UtokadHamtningLamning)).click();
                }
        }

        catch (Exception ex1)
        {
            logger.error("UTÖKAD HÄMTNING OCH LÄMNING EXCEPTION:" + ex1.getMessage());
            return false;
        }
        finally
        {
            logger.info("UTÖKAD HÄMTNING OCH LÄMNING");
        }

        /* *** ENSAMÅKNING *** */
        try
        {
            if((bl_Enamakning && !bl_UHOL))
                if (elementHelper.isElementDisplayedWithinTime(check_Ensamakning, 10000)) {
                    if(VISUAL_DEBUG)
                        helper.drawBorder(driver,check_Ensamakning, "red", 3);
                    if (TIME_DELAY)
                        sleep(DELAY_LENGTH);
                    wait.until(ExpectedConditions.elementToBeClickable(check_Ensamakning)).click();
                }
        }

        catch (Exception ex1)
        {
            logger.error("ENSAMÅKNING EXCEPTION:" + ex1.getMessage());
            return false;
        }
        finally
        {
            logger.info("ENSAMÅKNING");
        }

        /* *** FRAMSÄTESPLACERING *** */
        try
        {
            if((bl_Framstesplacering))
                if (elementHelper.isElementDisplayedWithinTime(check_Framsatesplacering, 10000)) {
                    if(VISUAL_DEBUG)
                        helper.drawBorder(driver,check_Framsatesplacering, "red", 3);
                    if (TIME_DELAY)
                        sleep(DELAY_LENGTH);
                    wait.until(ExpectedConditions.elementToBeClickable(check_Framsatesplacering)).click();
                }
        }

        catch (Exception ex1)
        {
            logger.error("FRAMSÄTESPLACERING EXCEPTION:" + ex1.getMessage());
            return false;
        }
        finally
        {
            logger.info("FRAMSÄTESPLACERING");
        }

        /* *** LÄGG TILL RESEINFORMATION *** */
        try
        {
            if (elementHelper.isElementDisplayedWithinTime(button_AddReseinformation, 10000)) {
                if(VISUAL_DEBUG)
                    helper.drawBorder(driver,button_AddReseinformation, "red", 3);
                if (TIME_DELAY)
                    sleep(DELAY_LENGTH);
                wait.until(ExpectedConditions.elementToBeClickable(button_AddReseinformation)).click();
            }
            return true;
        }
        catch (Exception ex1)
        {
            logger.error("LÄGG TILL RESEINFORMATION EXCEPTION:" + ex1.getMessage());
            return false;
        }
        finally
        {
            logger.info("LÄGG TILL RESEINFORMATION");
        }
    }

    @Override
    public void enter() {

    }

    @Override
    public void clickNext() {

    }

    @Override
    public boolean selectArendetyp() {
        return false;
    }

    @Override
    public void arrowDown() {

    }

    @Override
    public boolean selectInMenu(CSjukresaSjukresaHomePage.menuItems item) {
        return false;
    }

    @Override
    public boolean selectInMenu13(CSjukresaSjukresaHomePage.Menu item) {
        return false;
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
    public boolean isPageLoaded() {
        if (elementHelper.isElementDisplayedWithinTime(button_Log_In, 15000))
        {
            return true;
        }
        else {
            return false;
        }
    }
}
