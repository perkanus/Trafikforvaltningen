package SjukreseTests;

import Common.base.BaseTest;

import Common.data.TFWebbData;
import Common.data.TFWebbSJR;
import Common.sitemodel.Sjukresa.CSjukresaSjukresaHomePage;
import org.testng.Assert;
import org.testng.annotations.*;
import se.soprasteria.automatedtesting.webdriver.helpers.driver.AutomationDriver;

public class SjukresaTests extends BaseTest {
    TFWebbData TFWebbDataList;// = new TFWebbData();
    TFWebbSJR TFWebbSJRDataList = new TFWebbSJR();

    @Test(timeOut = 180000, dataProvider = "getDriver", groups = {"standard"})
    public void CreateSJRForResenarer(AutomationDriver driver) {
        Assert.assertTrue(loginPage.advanced(), "Wasn't clickable");
        Assert.assertTrue(loginPage.proceed(), "Wasn't clickable");
        sleep(2000);
        Assert.assertTrue(loginPage.isPageLoaded(), "Login page failed to load correctly");
        for (int i = 0; i < TFWebbSJRDataList.tfWebbUsers.size(); i++) {
            Assert.assertTrue(loginPage.logIn(), "Login page failed to load correctly");
            Assert.assertTrue(sjukReseHomePage.isPageLoaded(), "Login page failed to load correctly");
            Assert.assertTrue(sjukReseHomePage.selectFromUsers("Sigrid Vårdgivare"), "Test step: selectFromUsers passed");
            Assert.assertTrue(sjukReseHomePage.logInUser(), "Test step: logInUser passed");
            Assert.assertTrue(sjukReseHomePage.continueWithWorkplace(), "Test step: logInUser passed");
            Assert.assertTrue(sjukReseHomePage.isStartVisible(), "Start isn't visible");
            Assert.assertTrue(sjukReseHomePage.clickMenuTillstand(), "Couldn't click");
            Assert.assertTrue(sjukReseHomePage.clickMenuNyttTillstand(),"Couldn't click");
            Assert.assertTrue(sjukReseHomePage.logOutUser(), "Test step: logOutUser passed");

        }
    }



    @Test(timeOut = 180000, dataProvider = "getDriver", groups = {"standard"})
    public void PerformLogin(AutomationDriver driver) {
        Assert.assertTrue(loginPage.advanced(), "Wasn't clickable");
        Assert.assertTrue(loginPage.proceed(), "Wasn't clickable");
        sleep(2000);
        Assert.assertTrue(loginPage.isPageLoaded(), "Login page failed to load correctly");
        for (int i = 0; i < TFWebbDataList.tfWebbUsers.size(); i++) {
            Assert.assertTrue(loginPage.logIn(), "Login page failed to load correctly");
            Assert.assertTrue(sjukReseHomePage.isPageLoaded(), "Login page failed to load correctly");
            Assert.assertTrue(sjukReseHomePage.selectFromUsers("Kalle Kommun"), "Test step: selectFromUsers passed");
            Assert.assertTrue(sjukReseHomePage.logInUser(), "Test step: logInUser passed");
            Assert.assertTrue(sjukReseHomePage.continueWithWorkplace(), "Test step: logInUser passed");
            Assert.assertTrue(sjukReseHomePage.logOutUser(), "Test step: logOutUser passed");
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
        Assert.assertTrue(sjukReseHomePage.isPageLoaded(), "Login3 page failed to load correctly");
        Assert.assertTrue(sjukReseHomePage.selectFromUsers("Sigrid Vårdgivare"), "Test step: selectFromUsers passed");
        Assert.assertTrue(sjukReseHomePage.logInUser(), "Test step: logInUser passed");
        Assert.assertTrue(sjukReseHomePage.continueWithWorkplace(), "Test step: logInUser passed");
        Assert.assertTrue(sjukReseHomePage.isStartVisible(), "Start isn't visible");
        Assert.assertTrue(sjukReseHomePage.clickMenuTillstand(), "Couldn't click");
        Assert.assertTrue(sjukReseHomePage.clickMenuNyttTillstand(),"Couldn't click");
        Assert.assertTrue(sjukReseHomePage.fyllPersonnummer(),"Couldn't");
        sleep(2000);
        sjukReseHomePage.enter();
        Assert.assertTrue(sjukReseHomePage.selectArendetyp(),"Couldn't select ärendetyp");
        sleep(1000);
        sjukReseHomePage.arrowDown();
        sleep(1000);
        sjukReseHomePage.enter();



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
            Assert.assertTrue(sjukReseHomePage.isPageLoaded(), "Login page failed to load correctly");
            Assert.assertTrue(sjukReseHomePage.selectFromUsers("Sigrid Vårdgivare"), "Test step: selectFromUsers passed");
            Assert.assertTrue(sjukReseHomePage.logInUser(), "Test step: logInUser passed");
            Assert.assertTrue(sjukReseHomePage.continueWithWorkplace(), "Test step: logInUser passed");
            Assert.assertTrue(sjukReseHomePage.isStartVisible(), "Start isn't visible");
            Assert.assertTrue(sjukReseHomePage.selectInMenu13(CSjukresaSjukresaHomePage.Menu.Tillstand));
            Assert.assertTrue(sjukReseHomePage.selectInMenu13(CSjukresaSjukresaHomePage.Menu.Skapa));
            sleep(1000);


        }
    }
}
