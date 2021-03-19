package TFWebb.base;
import TFWebb.sitemodel.*;
import TFWebb.sitemodel.loginpage.ILoginPage;
import TFWebb.sitemodel.mainpage.IMainPage;
import se.soprasteria.automatedtesting.webdriver.api.base.BaseTestCase;
import se.soprasteria.automatedtesting.webdriver.api.base.BaseTestConfig;
import se.soprasteria.automatedtesting.webdriver.helpers.driver.AutomationDriver;

public class BaseTest extends BaseTestCase {

    protected IMainPage mainPage;
    protected ILoginPage loginPage;

    @Override
    protected String getDriverConfigId() {
        return "chromedriver";
    }

    @Override
    protected String getConfigFile() {
        return "TFWebb/TFWebb_config.xml";
    }

    @Override
    protected void initPages(AutomationDriver driver) {
        logger.info("Initialising pages to be used in test");
        loginPage = PageFactory.getLoginPage(driver);
        mainPage = PageFactory.getMainPage(driver);
    }

    @Override
    protected void initializeDriver(AutomationDriver driver) {
        if (driver.isWeb()) {
            driver.navigate().to(BaseTestConfig.getConfigurationOption("url_mainpage"));
        } else if (driver.isAndroid()){
            driver.navigate().to("https://mobile.twitter.com/login");
        } else if (driver.isIos()){
            driver.navigate().to("https://mobile.twitter.com/login");
        }
        sleep(1000);
        logger.info("Navigated to login-page, sleeping for 1s to allow it to initiliaze");
    }
}
