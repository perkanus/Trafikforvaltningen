package Common.base;
import Common.sitemodel.*;
import Common.sitemodel.Sjukresa.ISjukresaHomePage;
import Common.sitemodel.loginpage.ILoginPage;
import Common.sitemodel.Fardtjanst.IFardtjanstHomePage;
import DataLoading.SJR.ISJRDataload;
import se.soprasteria.automatedtesting.webdriver.api.base.BaseTestCase;
import se.soprasteria.automatedtesting.webdriver.api.base.BaseTestConfig;
import se.soprasteria.automatedtesting.webdriver.helpers.driver.AutomationDriver;

public class BaseTest extends BaseTestCase {

    protected IFardtjanstHomePage fardtjanstHomePage;
    protected ILoginPage loginPage;
    protected ISjukresaHomePage sjukReseHomePage;
    protected ISJRDataload SJRDataLoad;

    @Override
    protected String getDriverConfigId() {
        return "chromedriver";
    }

    @Override
    protected String getConfigFile() {
        return "TFWebb_config.xml";
    }

    @Override
    protected void initPages(AutomationDriver driver) {
        logger.info("Initialising pages to be used in test");
        loginPage = PageFactory.getLoginPage(driver);
        fardtjanstHomePage = PageFactory.getMainPage(driver);
        sjukReseHomePage = PageFactory.getHomePage(driver);
        SJRDataLoad = PageFactory.getSJRPage(driver);
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
