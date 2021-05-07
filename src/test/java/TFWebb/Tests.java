package TFWebb;

import TFWebb.base.BaseTest;

import TFWebb.data.TFWebbData;
import org.testng.Assert;
import org.testng.annotations.*;
import se.soprasteria.automatedtesting.webdriver.helpers.driver.AutomationDriver;


public class Tests extends BaseTest {
    TFWebbData TFWebbDataList = new TFWebbData();

    @Test(timeOut = 180000, dataProvider = "getDriver", groups = {"standard"})
    public void PerformLogin(AutomationDriver driver) {
        Assert.assertTrue(loginPage.isPageLoaded(), "Login page failed to load correctly");
        for (int i = 0; i < TFWebbDataList.tfWebbUsers.size(); i++) {
            Assert.assertTrue(loginPage.logIn(), "Login page failed to load correctly");
            Assert.assertTrue(mainPage.isPageLoaded(), "Login page failed to load correctly");
            Assert.assertTrue(mainPage.selectFromUsers(TFWebbDataList.tfWebbUsers.get(i).s_UserName), "Test step: selectFromUsers passed");
            Assert.assertTrue(mainPage.logInUser(), "Test step: logInUser passed");
            Assert.assertTrue(mainPage.continueWithWorkplace(), "Test step: logInUser passed");
            Assert.assertTrue(mainPage.skapaSjukresetillstånd(), "Test step: logInUser passed");
            Assert.assertTrue(mainPage.logOutUser(), "Test step: logOutUser passed");
        }
    }

    @Test(timeOut = 180000, dataProvider = "getDriver", groups = {"standard"})
    public void SkapaSjukreseTillstandKort(AutomationDriver driver) {
        Assert.assertTrue(loginPage.isPageLoaded(), "Login page failed to load correctly");
        for (int i = 0; i < TFWebbDataList.tfWebbUsers.size(); i++) {
            Assert.assertTrue(loginPage.logIn(), "Login page failed to load correctly");
            Assert.assertTrue(mainPage.isPageLoaded(), "Login page failed to load correctly");
            Assert.assertTrue(mainPage.selectFromUsers(TFWebbDataList.tfWebbUsers.get(i).s_UserName), "Test step: selectFromUsers passed");
            Assert.assertTrue(mainPage.logInUser(), "Test step: logInUser passed");
            Assert.assertTrue(mainPage.continueWithWorkplace(), "Test step: logInUser passed");
            // Skapa funktion för navigering till specifik del
            Assert.assertTrue(mainPage.skapaSjukresetillstånd(), "Test step: logInUser passed");
            sleep(10000);
            Assert.assertTrue(mainPage.logOutUser(), "Test step: logOutUser passed");
        }
    }
}
