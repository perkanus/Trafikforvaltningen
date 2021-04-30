package SjukresorTest;

import SjukresorTest.base.BaseTest;

import SjukresorTest.data.TFWebbData;
import SjukresorTest.sitemodel.Fardtjanst.CMainPage;
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
            Assert.assertTrue(mainPage.logOutUser(), "Test step: logOutUser passed");
        }
    }

    @Test(timeOut = 180000, dataProvider = "getDriver", groups = {"standard"})
    public void CheckSjukreseHomepage(AutomationDriver driver) {
        Assert.assertTrue(loginPage.advanced(), "Wasn't clickable");
        Assert.assertTrue(loginPage.proceed(), "Wasn't clickable");
        sleep(2000);
        Assert.assertTrue(loginPage.isPageLoaded(), "Login1 page failed to load correctly");
        for (int i = 0; i < TFWebbDataList.tfWebbUsers.size(); i++){
            Assert.assertTrue(loginPage.logIn(), "Login2 page failed to load correctly");
        Assert.assertTrue(mainPage.isPageLoaded(), "Login3 page failed to load correctly");
        Assert.assertTrue(mainPage.selectFromUsers(TFWebbDataList.tfWebbUsers.get(i).s_UserName), "Test step: selectFromUsers passed");
        Assert.assertTrue(mainPage.logInUser(), "Test step: logInUser passed");
        Assert.assertTrue(mainPage.continueWithWorkplace(), "Test step: logInUser passed");
        Assert.assertTrue(homePage.isStartVisible(), "Start isn't visible");
        Assert.assertTrue(homePage.clickMenuTillstand(), "Couldn't click");
        Assert.assertTrue(homePage.clickMenuNyttTillstand(),"Couldn't click");
        Assert.assertTrue(homePage.fyllPersonnummer(),"Couldn't");
        sleep(2000);
        homePage.enter();
        Assert.assertTrue(homePage.selectArendetyp(),"Couldn't select ärendetyp");
        sleep(1000);
        homePage.arrowDown();
        sleep(1000);
        homePage.enter();



        }
    }


    @Test(timeOut = 180000, dataProvider = "getDriver", groups = {"standard"})
    public void TestarN(AutomationDriver driver) {
        Assert.assertTrue(loginPage.advanced(),"Wasn't clickable");
        Assert.assertTrue(loginPage.proceed(),"Wasn't clickable");
        sleep(2000);
        Assert.assertTrue(loginPage.isPageLoaded(), "Login page failed to load correctly");
        for (int i = 0; i < TFWebbDataList.tfWebbUsers.size(); i++) {
            Assert.assertTrue(loginPage.logIn(), "Login page failed to load correctly");
            Assert.assertTrue(mainPage.isPageLoaded(), "Login page failed to load correctly");
            Assert.assertTrue(mainPage.selectFromUsers(TFWebbDataList.tfWebbUsers.get(i).s_UserName), "Test step: selectFromUsers passed");
            Assert.assertTrue(mainPage.logInUser(), "Test step: logInUser passed");
            Assert.assertTrue(mainPage.continueWithWorkplace(), "Test step: logInUser passed");
            Assert.assertTrue(homePage.isStartVisible(),"Start isn't visible");
            Assert.assertTrue(mainPage.clickMenuFardtjanst(),"can't");
            Assert.assertTrue(mainPage.clickSokPerson(),"can't1");
            Assert.assertTrue(homePage.fyllPersonnummer(),"Couldn't");
            sleep(1000);
            homePage.enter();
            sleep(1000);
            Assert.assertTrue(mainPage.clickCreateUtredning(),"coudln't");
            Assert.assertTrue(mainPage.clickTakeOwnership(),"couldn't");
            sleep(1000);

        }
    }

    @Test(timeOut = 180000, dataProvider = "getDriver", groups = {"standard"})
    public void TestarN1337(AutomationDriver driver) {
        Assert.assertTrue(loginPage.advanced(), "Wasn't clickable");
        Assert.assertTrue(loginPage.proceed(), "Wasn't clickable");
        sleep(2000);
        Assert.assertTrue(loginPage.isPageLoaded(), "Login page failed to load correctly");
        for (int i = 0; i < TFWebbDataList.tfWebbUsers.size(); i++) {
            Assert.assertTrue(loginPage.logIn(), "Login page failed to load correctly");
            Assert.assertTrue(mainPage.isPageLoaded(), "Login page failed to load correctly");
            Assert.assertTrue(mainPage.selectFromUsers(TFWebbDataList.tfWebbUsers.get(i).s_UserName), "Test step: selectFromUsers passed");
            Assert.assertTrue(mainPage.logInUser(), "Test step: logInUser passed");
            Assert.assertTrue(mainPage.continueWithWorkplace(), "Test step: logInUser passed");
            Assert.assertTrue(homePage.isStartVisible(), "Start isn't visible");
            Assert.assertTrue(mainPage.selectInMenu13(CMainPage.Menu.Tillstand));
            Assert.assertTrue(mainPage.selectInMenu13(CMainPage.Menu.Skapa));
            sleep(1000);


        }
    }
}
