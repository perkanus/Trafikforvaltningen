package SjukresorTest.sitemodel.Sjukresa;

public interface ISjukresaHomePage {
    public abstract boolean isPageLoaded ();
    public abstract boolean isStartVisible();
    public abstract boolean clickMenuTillstand();
    public abstract boolean clickMenuNyttTillstand();
    public abstract boolean fyllPersonnummer();
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
