package Common.data;

public class TFWebbSJR extends TFWebbData {
    public TFWebbSJR()
    {
        tfWebbUsers.add(new TFWebbUser("Sigrid Vårdgivare", "V"));
        if(this.findWebUser("Sigrid Vårdgivare", tfWebbUsers) != null) {
            this.findWebUser("Sigrid Vårdgivare", tfWebbUsers).addWorkplace("11362020004");
            this.findWebUser("Sigrid Vårdgivare", tfWebbUsers).addWorkplace("19104011000");
            // R1
            /*
            this.findWebUser("Sigrid Vårdgivare", tfWebbUsers).addResenar(
                    "199205202386",
                    "46505053",
                    "Personnummer",
                    "Sjukresekort",
                    12,
                    "Periklis Karolidis",
                    "Barnmorska");
            if(this.findResenar("199205202386",this.findWebUser("Sigrid Vårdgivare", tfWebbUsers).tfResenarer) != null)
            {
                this.findResenar("199205202386",this.findWebUser("Sigrid Vårdgivare", tfWebbUsers).tfResenarer).addReseinformation("RTVOB","Taxi",3,2,false,false,false, false);
            }

            // R2
            this.findWebUser("Sigrid Vårdgivare", tfWebbUsers).addResenar(
                    "199305172398",
                    "76977248",
                    "Personnummer",
                    "Sjukresekort",
                    12,
                    "Periklis Karolidis",
                    "Barnmorska");
            if(this.findResenar("199305172398",this.findWebUser("Sigrid Vårdgivare", tfWebbUsers).tfResenarer) != null)
            {
                this.findResenar("199305172398",this.findWebUser("Sigrid Vårdgivare", tfWebbUsers).tfResenarer).addReseinformation("RTVOB","Taxi",3,2,false,false,false, false);
            }
*/
            // R3
            this.findWebUser("Sigrid Vårdgivare", tfWebbUsers).addResenar(
                    "199303032388",
                    "70986666",
                    "Personnummer",
                    "Sjukresekort",
                    12,
                    "Periklis Karolidis",
                    "Barnmorska");
            if(this.findResenar("199303032388",this.findWebUser("Sigrid Vårdgivare", tfWebbUsers).tfResenarer) != null)
            {
                this.findResenar("199303032388",this.findWebUser("Sigrid Vårdgivare", tfWebbUsers).tfResenarer).addReseinformation("RTVOB","Taxi",3,2,false,false,false, false);
            }
            /*




199110202398
199104172391
199604182395
199401122388
199105162391
199206152390
195603032193
199704132399
194202269207




47396635
76834696
73797326
44868057
73787186
46474375
74330549
44056992
42304824
46545414
             */
        }
    }
}
