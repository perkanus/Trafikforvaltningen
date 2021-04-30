package SjukresorTest.sitemodel.Sjukresa;

public interface IHomePage {
    public abstract boolean isPageLoaded ();
    public abstract boolean isStartVisible();
    public abstract boolean clickMenuTillstand();
    public abstract boolean clickMenuNyttTillstand();
    public abstract boolean fyllPersonnummer();
    public abstract void enter();
    public abstract void clickNext();
    public abstract boolean selectArendetyp();
    public abstract void arrowDown();


}
