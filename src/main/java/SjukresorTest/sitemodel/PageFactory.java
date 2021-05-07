package SjukresorTest.sitemodel;

import org.openqa.selenium.WebDriver;
import SjukresorTest.sitemodel.loginpage.CLoginPage;
import SjukresorTest.sitemodel.loginpage.ILoginPage;
import SjukresorTest.sitemodel.Fardtjanst.IFardtjanstHomePage;
import SjukresorTest.sitemodel.Fardtjanst.CFardtjanstHomePage;
import SjukresorTest.sitemodel.Sjukresa.ISjukresaHomePage;
import SjukresorTest.sitemodel.Sjukresa.CSjukresaSjukresaHomePage;
import se.soprasteria.automatedtesting.webdriver.api.utility.Errors;
import se.soprasteria.automatedtesting.webdriver.helpers.driver.AutomationDriver;

public class PageFactory {

    public static ILoginPage getLoginPage(AutomationDriver driver) {
        if (driver.isWeb()) {
            return new CLoginPage(driver);
        }
        if (driver.isAndroid()) {
            //return Android login page
        }
        if (driver.isIos()) {
            //return iOS login page
        }
        throw new RuntimeException(getInvalidDriverError(driver));
    }

    public static IFardtjanstHomePage getMainPage(AutomationDriver driver) {
        if (driver.isWeb()) {
            return new CFardtjanstHomePage(driver);
        }
        if (driver.isAndroid()) {
            //return Android main page
        }
        if (driver.isIos()) {
            //return iOS main page
        }
        throw new RuntimeException(getInvalidDriverError(driver));
    }

    public static ISjukresaHomePage getHomePage(AutomationDriver driver) {
        if (driver.isWeb()) {
            return new CSjukresaSjukresaHomePage(driver);
        }
        if (driver.isAndroid()) {
            //return Android main page
        }
        if (driver.isIos()) {
            //return iOS main page
        }
        throw new RuntimeException(getInvalidDriverError(driver));
    }

    private static String getInvalidDriverError(WebDriver webDriver) {
        String[] fixes = {"Change webdriver configuration to a valid one for this project",
                "Implement support for webdriver: " + webDriver.toString()};
        return Errors.getErrorMessage("Tried to start unsupported webdriver", fixes);
    }

}
