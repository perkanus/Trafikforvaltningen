package Common.data;

public class TFWebbSJR extends TFWebbData {
    public TFWebbSJR()
    {
        tfWebbUsers.add(new TFWebbUser("Sigrid Vårdgivare", "V"));
        if(this.findWebUser("Sigrid Vårdgivare", tfWebbUsers) != null) {
            this.findWebUser("Sigrid Vårdgivare", tfWebbUsers).addWorkplace("11362020004");
            this.findWebUser("Sigrid Vårdgivare", tfWebbUsers).addWorkplace("19104011000");
            this.findWebUser("Sigrid Vårdgivare", tfWebbUsers).addResenar(
                    "201603122381",
                    "73300642",
                    "Personnummer",
                    "Sjukresekort",
                    12,
                    "Periklis Karolidis",
                    "Barnmorska");
            if(this.findResenar("201603122381",this.findWebUser("Sigrid Vårdgivare", tfWebbUsers).tfResenarer) != null)
            {
                this.findResenar("201603122381",this.findWebUser("Sigrid Vårdgivare", tfWebbUsers).tfResenarer).addReseinformation("RTVOB","Taxi",3,2,false,false,false, false);
            }

            /*
            this.findUsingEnhancedForLoop("Sigrid Vårdgivare", tfWebbUsers).addResenar("201602292383", "70444559" ); // UToläns
            this.findUsingEnhancedForLoop("Sigrid Vårdgivare", tfWebbUsers).addResenar("201602282392", "72956212");
            this.findUsingEnhancedForLoop("Sigrid Vårdgivare", tfWebbUsers).addResenar("201602262394", "85945681");
            this.findUsingEnhancedForLoop("Sigrid Vårdgivare", tfWebbUsers).addResenar("201602242396", "74663055");
            this.findUsingEnhancedForLoop("Sigrid Vårdgivare", tfWebbUsers).addResenar("201602192385","77941110");
            this.findUsingEnhancedForLoop("Sigrid Vårdgivare", tfWebbUsers).addResenar("201602142398", "82205600");
             */
        }
    }
}
