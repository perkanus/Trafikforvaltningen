package DataLoading.SJR;

import Common.sitemodel.Sjukresa.CSjukresaSjukresaHomePage;

public interface ISJRDataload {
    public abstract boolean isPageLoaded ();
    public abstract boolean LoginToWebb(String user, String workplace);
    public abstract boolean CheckIfTopMenuIsVisible();
    public abstract boolean CreateSJRTillstand();

    public abstract boolean isStartVisible();
    public abstract boolean clickMenuTillstand();
    public abstract boolean clickMenuNyttTillstand();
    public abstract boolean FillIDNumber(String s_Personnummer);
    public abstract boolean SelectIDType(String s_ID_Type);
    public abstract boolean SelectPermitType(String s_PermitType);
    public abstract boolean FillCardNumber(String s_CardNumber);
    public abstract boolean PressNextButton();
    public abstract boolean SetDate(String s_Date, boolean bl_from);
    public abstract boolean FillMedicalTitleName(String s_MedicalTitleName);
    public abstract boolean FillMedicalTitle(String s_MedicalTitle);
    public abstract boolean AddReseinformation(String s_TypAvResa, String s_Fardsatt, int i_Enkelresor, int i_AntalMedfoljande, boolean bl_UHOL, boolean bl_Enamakning, boolean bl_Framstesplacering);
    public abstract void enter();
    public abstract void clickNext();
    public abstract boolean selectArendetyp();
    public abstract void arrowDown();
    public abstract boolean selectInMenu(CSjukresaSjukresaHomePage.menuItems item);
    public abstract boolean selectInMenu13(CSjukresaSjukresaHomePage.Menu item);
    public abstract boolean logInUser();
    public abstract boolean logOutUser();
    public abstract boolean selectFromWorkplace(String workplace);
    public abstract boolean selectFromUsers(String user);
    public abstract boolean continueWithWorkplace();
}
