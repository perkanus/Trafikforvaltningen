package FardtjanstTest;

import SjukresorTest.base.BaseTest;
import SjukresorTest.data.TFWebbData;
import org.testng.Assert;
import org.testng.annotations.Test;
import se.soprasteria.automatedtesting.webdriver.helpers.driver.AutomationDriver;

public class FardtjanstTest extends BaseTest {
    TFWebbData TFWebbDataList = new TFWebbData();



    @Test(timeOut = 180000, dataProvider = "getDriver", groups = {"standard"})
    public void PerformLogin(AutomationDriver driver) {
        Assert.assertTrue(loginPage.advanced(),"Wasn't clickable");
        Assert.assertTrue(loginPage.proceed(),"Wasn't clickable");
        sleep(2000);
        Assert.assertTrue(loginPage.isPageLoaded(), "Login page failed to load correctly");
        for (int i = 0; i < TFWebbDataList.tfWebbUsers.size(); i++) {
            Assert.assertTrue(loginPage.logIn(), "Login page failed to load correctly");
            Assert.assertTrue(fardtjanstHomePage.isPageLoaded(), "Login page failed to load correctly");
            Assert.assertTrue(fardtjanstHomePage.selectFromUsers("Kalle Kommun"), "Test step: selectFromUsers passed");
            Assert.assertTrue(fardtjanstHomePage.logInUser(), "Test step: logInUser passed");
            Assert.assertTrue(fardtjanstHomePage.continueWithWorkplace(), "Test step: logInUser passed");
            Assert.assertTrue(fardtjanstHomePage.logOutUser(), "Test step: logOutUser passed");
        }
    }


    @Test(timeOut = 180000, dataProvider = "getDriver", groups = {"standard"})
    public void CreateUtredning(AutomationDriver driver) {
        Assert.assertTrue(loginPage.advanced(),"Wasn't clickable");
        Assert.assertTrue(loginPage.proceed(),"Wasn't clickable");
        sleep(2000);
        Assert.assertTrue(loginPage.isPageLoaded(), "Login page failed to load correctly");
        for (int i = 0; i < TFWebbDataList.tfWebbUsers.size(); i++) {
            Assert.assertTrue(loginPage.logIn(), "Login page failed to load correctly");
            Assert.assertTrue(fardtjanstHomePage.isPageLoaded(), "Login page failed to load correctly");
            Assert.assertTrue(fardtjanstHomePage.selectFromUsers("Kalle Kommun"), "Test step: selectFromUsers passed");
            Assert.assertTrue(fardtjanstHomePage.logInUser(), "Test step: logInUser passed");
            Assert.assertTrue(fardtjanstHomePage.continueWithWorkplace(), "Test step: logInUser passed");
            Assert.assertTrue(fardtjanstHomePage.isStartVisible(),"Start isn't visible");
            Assert.assertTrue(fardtjanstHomePage.clickMenuFardtjanst(),"can't");
            Assert.assertTrue(fardtjanstHomePage.clickSokPerson(),"can't1");
            Assert.assertTrue(fardtjanstHomePage.fyllPersonnummer(),"Couldn't");
            sleep(1000);
            sjukReseHomePage.enter();
            sleep(1000);
            Assert.assertTrue(fardtjanstHomePage.clickCreateUtredning(),"coudln't");
            Assert.assertTrue(fardtjanstHomePage.clickTakeOwnership(),"couldn't");
            sleep(1000);

        }
    }



}
