package Common.sitemodel;

import DataLoading.SJR.CSJRDataload;
import DataLoading.SJR.ISJRDataload;
import org.openqa.selenium.WebDriver;
import Common.sitemodel.loginpage.CLoginPage;
import Common.sitemodel.loginpage.ILoginPage;
import Common.sitemodel.Fardtjanst.IFardtjanstHomePage;
import Common.sitemodel.Fardtjanst.CFardtjanstHomePage;
import Common.sitemodel.Sjukresa.ISjukresaHomePage;
import Common.sitemodel.Sjukresa.CSjukresaSjukresaHomePage;
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

    public static ISJRDataload getSJRPage(AutomationDriver driver) {
        if (driver.isWeb()) {
            return new CSJRDataload(driver);
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
