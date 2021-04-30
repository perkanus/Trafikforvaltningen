package TFWebb.sitemodel;

import org.openqa.selenium.WebDriver;
import TFWebb.sitemodel.loginpage.CLoginPage;
import TFWebb.sitemodel.loginpage.ILoginPage;
import TFWebb.sitemodel.mainpage.IMainPage;
import TFWebb.sitemodel.mainpage.CMainPage;
import TFWebb.sitemodel.homepage.IHomePage;
import TFWebb.sitemodel.homepage.CHomePage;
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

    public static IMainPage getMainPage(AutomationDriver driver) {
        if (driver.isWeb()) {
            return new CMainPage(driver);
        }
        if (driver.isAndroid()) {
            //return Android main page
        }
        if (driver.isIos()) {
            //return iOS main page
        }
        throw new RuntimeException(getInvalidDriverError(driver));
    }

    public static IHomePage getHomePage(AutomationDriver driver) {
        if (driver.isWeb()) {
            return new CHomePage(driver);
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
