package Common.sitemodel.Fardtjanst;

public interface IFardtjanstHomePage {
    public abstract boolean isPageLoaded ();
    public abstract boolean selectFromUsers (String user);
    public abstract boolean selectFromWorkplace (String workplace);
    public abstract boolean logOutUser ();
    public abstract boolean logInUser ();
    public abstract boolean continueWithWorkplace ();
    public abstract boolean clickMenuFardtjanst();
    public abstract boolean clickSokPerson();
    public abstract boolean clickCreateUtredning();
    public abstract boolean clickTakeOwnership();
    public abstract boolean isStartVisible();
    public abstract boolean fyllPersonnummer();


}
