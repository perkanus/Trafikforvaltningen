package TFWebb.sitemodel.mainpage;

public interface IMainPage {
    public abstract boolean isPageLoaded ();
    public abstract boolean selectFromUsers (String user);
    public abstract boolean selectFromWorkplace (String workplace);
    public abstract boolean logOutUser ();
    public abstract boolean logInUser ();
    public abstract boolean continueWithWorkplace ();
}
