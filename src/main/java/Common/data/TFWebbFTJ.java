package Common.data;

public class TFWebbFTJ extends TFWebbData {
    public TFWebbFTJ()
    {
        tfWebbUsers.add(new TFWebbUser("Kalle Kommun", "K"));
        if(this.findWebUser("Kalle Kommun", tfWebbUsers) != null) {
            this.findWebUser("Kalle Kommun", tfWebbUsers).addWorkplace("0180|08");
            this.findWebUser("Kalle Kommun", tfWebbUsers).addWorkplace("0160|");
            //this.findUsingEnhancedForLoop("Kalle Kommun", tfWebbUsers).addResenar("196906269573", "","");
        }
    }
}
