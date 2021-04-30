package SjukresorTest.sitemodel.Sjukresa;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import se.soprasteria.automatedtesting.webdriver.api.base.BasePageObject;
import se.soprasteria.automatedtesting.webdriver.helpers.driver.AutomationDriver;

public class CHomePage extends BasePageObject implements IHomePage {

    WebDriverWait wait = new WebDriverWait(driver, 30);

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







    public CHomePage(AutomationDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageLoaded() {
        return false;
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






}