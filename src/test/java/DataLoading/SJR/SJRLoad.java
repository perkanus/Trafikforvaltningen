package DataLoading.SJR;

import Common.base.BaseTest;

import Common.data.Helpers;
import Common.data.TFWebbSJR;
import org.testng.Assert;
import org.testng.annotations.*;
import se.soprasteria.automatedtesting.webdriver.helpers.driver.AutomationDriver;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

public class SJRLoad extends BaseTest {

    TFWebbSJR TFWebbSJRDataList = new TFWebbSJR();


    @Test(timeOut = 180000, dataProvider = "getDriver", groups = {"standard"})
    public void CreateSJRForResenarer(AutomationDriver driver) {
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        Assert.assertTrue(loginPage.advanced(), "Wasn't clickable");
        Assert.assertTrue(loginPage.proceed(), "Wasn't clickable");
        sleep(2000);
        Assert.assertTrue(loginPage.isPageLoaded(), "Login page failed to load correctly");
        for (int i = 0; i < TFWebbSJRDataList.tfWebbUsers.size(); i++) {
            Assert.assertTrue(loginPage.logIn(), "Login page failed to load correctly");
            Assert.assertTrue(SJRDataLoad.isPageLoaded(), "Login page failed to load correctly");

            Assert.assertTrue(SJRDataLoad.LoginToWebb(TFWebbSJRDataList.tfWebbUsers.get(i).s_UserName, TFWebbSJRDataList.tfWebbUsers.get(i).tfWebWorkplace.get(0).s_WorkplaceValue), "Login page failed to load correctly");

            Assert.assertTrue(SJRDataLoad.CheckIfTopMenuIsVisible(), "Start isn't visible");

            //Assert.assertTrue(SJRDataLoad.isStartVisible(), "Start isn't visible");
            for (int j = 0; j < TFWebbSJRDataList.tfWebbUsers.get(i).tfResenarer.size(); j++) {
                logger.info(TFWebbSJRDataList.tfWebbUsers.get(i).tfResenarer.get(j).s_ResenarPNR);
                Assert.assertTrue(SJRDataLoad.clickMenuTillstand(), "CreateSJRForResenarer: Error in clickMenuTillstand()");
                Assert.assertTrue(SJRDataLoad.clickMenuNyttTillstand(),"CreateSJRForResenarer: Error in clickMenuNyttTillstand()");

                // Sida 1. Slå ihop sen
                Assert.assertTrue(SJRDataLoad.SelectIDType(TFWebbSJRDataList.tfWebbUsers.get(i).tfResenarer.get(j).s_IDType),"CreateSJRForResenarer: Error in SelectIDType");
                Assert.assertTrue(SJRDataLoad.FillIDNumber(TFWebbSJRDataList.tfWebbUsers.get(i).tfResenarer.get(j).s_ResenarPNR),"CreateSJRForResenarer: Error in FillIDNumber()");
                // Select permit type
                Assert.assertTrue(SJRDataLoad.SelectPermitType(TFWebbSJRDataList.tfWebbUsers.get(i).tfResenarer.get(j).s_PermitType),"CreateSJRForResenarer: Error in SelectPermitType()");
                // Add card number
                sleep(1000);
                Assert.assertTrue(SJRDataLoad.FillCardNumber(TFWebbSJRDataList.tfWebbUsers.get(i).tfResenarer.get(j).s_SJRKortNummer),"CreateSJRForResenarer: Error in SelectPermitType()");

                // Press next
                Assert.assertTrue(SJRDataLoad.PressNextButton(),"CreateSJRForResenarer: Error in PressNextButton()");



                // Add from date
                Assert.assertTrue(SJRDataLoad.SetDate(DateTimeFormatter.ofPattern("yyyy-MM-dd").format(LocalDateTime.now()), true),"CreateSJRForResenarer: Error in SetDate(Till)");
                // Add to date
                Assert.assertTrue(SJRDataLoad.SetDate(DateTimeFormatter.ofPattern("yyyy-MM-dd").format(LocalDateTime.now().plusDays(TFWebbSJRDataList.tfWebbUsers.get(i).tfResenarer.get(j).i_duration)), false),"CreateSJRForResenarer: Error in SetDate(Från)");
                // Add Name
                Assert.assertTrue(SJRDataLoad.FillMedicalTitleName(TFWebbSJRDataList.tfWebbUsers.get(i).tfResenarer.get(j).s_MedicinskTitelNamn),"CreateSJRForResenarer: Error in SetDate(Från)");


                // Add medical title

                Assert.assertTrue(SJRDataLoad.FillMedicalTitle(TFWebbSJRDataList.tfWebbUsers.get(i).tfResenarer.get(j).s_MedicinskTitel),"CreateSJRForResenarer: Error in SetDate(Från)");
                // Add reseinformation
                for (int k = 0; k < TFWebbSJRDataList.tfWebbUsers.get(i).tfResenarer.get(j).tfReseinformation.size(); k++) {
                    // Skapa kod för att lägga till anslutningsresa Båttaxi
                    Assert.assertTrue(SJRDataLoad.AddReseinformation(
                            TFWebbSJRDataList.tfWebbUsers.get(i).tfResenarer.get(j).tfReseinformation.get(k).s_TypAvResa,
                            TFWebbSJRDataList.tfWebbUsers.get(i).tfResenarer.get(j).tfReseinformation.get(k).s_Fardsatt,
                            TFWebbSJRDataList.tfWebbUsers.get(i).tfResenarer.get(j).tfReseinformation.get(k).i_Enkelresor,
                            TFWebbSJRDataList.tfWebbUsers.get(i).tfResenarer.get(j).tfReseinformation.get(k).i_AntalMedfoljande,
                            TFWebbSJRDataList.tfWebbUsers.get(i).tfResenarer.get(j).tfReseinformation.get(k).bl_UHOL,
                            TFWebbSJRDataList.tfWebbUsers.get(i).tfResenarer.get(j).tfReseinformation.get(k).bl_Enamakning,
                            TFWebbSJRDataList.tfWebbUsers.get(i).tfResenarer.get(j).tfReseinformation.get(k).bl_Framstesplacering
                            ),"CreateSJRForResenarer: Error in AddReseinformation");
                }
                sleep(10000);
            }





            Assert.assertTrue(SJRDataLoad.logOutUser(), "Test step: logOutUser passed");

        }
    }
}
