package Common.data;

import java.util.ArrayList;
import java.util.List;


public class TFWebbData {

    public List<TFWebbUser> tfWebbUsers = new ArrayList<TFWebbUser>();


    public TFWebbData()
    {
        /*
        // Add The users
        tfWebbUsers.add(new TFWebbUser("Sigrid Vårdgivare", "V"));
        //tfWebbUsers.add(new TFWebbUser("Kalle Kommun", "K"));
       // tfWebbUsers.add(new TFWebbUser("Mårten Månsson", "K"));

        // Bajsanvändare, verkar inte fungera

        tfWebbUsers.add(new TFWebbUser("Harald Haraldsson", "X"));
        tfWebbUsers.add(new TFWebbUser("Anna Andersson", "X"));
        tfWebbUsers.add(new TFWebbUser("Håkan Håkansson", "X"));
        tfWebbUsers.add(new TFWebbUser("Konrad Kundservice", "X"));
        tfWebbUsers.add(new TFWebbUser("Sune Vårdgivare", "X"));
        tfWebbUsers.add(new TFWebbUser("Anmälan Vårdgivare", "X"));

        // Add the workplace and resenär for users
        if(this.findUsingEnhancedForLoop("Sigrid Vårdgivare", tfWebbUsers) != null) {
            this.findUsingEnhancedForLoop("Sigrid Vårdgivare", tfWebbUsers).addWorkplace("1234567890");
            this.findUsingEnhancedForLoop("Sigrid Vårdgivare", tfWebbUsers).addWorkplace("2345678901");
                    }

        if(this.findUsingEnhancedForLoop("Kalle Kommun", tfWebbUsers) != null) {
            this.findUsingEnhancedForLoop("Kalle Kommun", tfWebbUsers).addWorkplace("0180|08");
            this.findUsingEnhancedForLoop("Kalle Kommun", tfWebbUsers).addWorkplace("0160|");
        }

        if(this.findUsingEnhancedForLoop("Mårten Månsson", tfWebbUsers) != null) {
            this.findUsingEnhancedForLoop("Mårten Månsson", tfWebbUsers).addWorkplace("0180|08");
            this.findUsingEnhancedForLoop("Mårten Månsson", tfWebbUsers).addWorkplace("0160|");
        }

        if(tfWebbUsers.indexOf("Sigrid Vårdgivare") != -1) {

        }
*/

    }

    public TFWebbUser findWebUser(
        String name, List<TFWebbUser> customers) {

        for (TFWebbUser customer : customers) {
            if (customer.s_UserName.equals(name)) {
                return customer;
            }
        }
        return null;
    }

    public TFWebbResenar findResenar(
            String name, List<TFWebbResenar> customers) {

        for (TFWebbResenar customer : customers) {
            if (customer.s_ResenarPNR.equals(name)) {
                return customer;
            }
        }
        return null;
    }

    // Class to store TF Web user
    public class TFWebbUser
    {
        public String s_UserName;
        public String s_UserType;
        public List<TFWebbResenar> tfResenarer = new ArrayList<TFWebbResenar>();
        public List<TFWebbWorkplace> tfWebWorkplace  = new ArrayList<TFWebbWorkplace>(); // Ändra till List<String> och ta bort klassen. Behövs ingen klass

        public TFWebbUser(String s_UserName, String s_UserType)
        {
            this.s_UserName = s_UserName;
            this.s_UserType = s_UserType;
        }

        public void addWorkplace(String s_WorkplaceValue)
        {
            this.tfWebWorkplace.add(new TFWebbWorkplace(s_WorkplaceValue));
        }

        public void addResenar(String s_ResenarPNR, String s_SJRKortNummer, String s_IDType, String s_PermitType, int i_duration, String s_MedicinskTitelNamn, String s_MedicinskTitel)
        {
            this.tfResenarer.add(new TFWebbResenar(s_ResenarPNR, s_SJRKortNummer, s_IDType, s_PermitType, i_duration, s_MedicinskTitelNamn, s_MedicinskTitel));
        }

    }

    // Class to store workplace(s) for a web user
    public class TFWebbWorkplace
    {
        public String s_WorkplaceValue;
        public TFWebbWorkplace(String s_WorkplaceValue)
        {
            this.s_WorkplaceValue = s_WorkplaceValue;
        }
    }

    public class TFWebbResenar
    {
        public String s_ResenarPNR;
        public String s_IDType;
        public String s_PermitType;
        public String s_TillstandTyp;
        public String s_SJRKortNummer;
        public String s_LMANummer;
        public int i_duration;
        public String s_MedicinskTitelNamn;
        public String s_MedicinskTitel;

        public TFWebbResenar(String s_ResenarPNR) { this.s_ResenarPNR = s_ResenarPNR; }
        public List<TFReseinformation> tfReseinformation = new ArrayList<TFReseinformation>();

        public TFWebbResenar(String s_ResenarPNR, String s_SJRKortNummer, String s_IDType, String s_PermitType, int i_duration, String s_MedicinskTitelNamn, String s_MedicinskTitel) {
            this.s_ResenarPNR = s_ResenarPNR;
            this.s_SJRKortNummer = s_SJRKortNummer;
            this.s_IDType = s_IDType;
            this.s_PermitType = s_PermitType;
            this.i_duration = i_duration;
            this.s_MedicinskTitelNamn = s_MedicinskTitelNamn;
            this.s_MedicinskTitel = s_MedicinskTitel;
        }
        public void addReseinformation(String s_TypAvResa, String s_Fardsatt, int i_Enkelresor, int i_AntalMedfoljande, boolean bl_UHOL, boolean bl_Enamakning, boolean bl_Framstesplacering, boolean bl_Anslutning)
        {
            this.tfReseinformation.add(new TFReseinformation(s_TypAvResa, s_Fardsatt, i_Enkelresor, i_AntalMedfoljande, bl_UHOL, bl_Enamakning, bl_Framstesplacering, bl_Anslutning));
        }
    }
    public class TFReseinformation
    {
        /*
         * RTVOB - Resa till vård och behandling
         * RMV - Resa mellan vårdgivare
         * RTAVFPA - Resa till annan vårdgivare från patientens adress
         * RTVIAL - Resa till vård i annat län
         */
        public String s_TypAvResa;

        /* Färdsätt
         * Resa till vård och behandling Taxi, Båttaxi, Rullstolstaxi
         * Resa mellan vårdgivare Taxi, Rullstolstaxi
         * Resa till annan vårdgivare från patientens adress Taxi, Båttaxi, Rullstolstaxi
         * Resa till vård i annat län Taxi, Rullstolstaxi
         */
        public String s_Fardsatt;

        /*
         * Antal Enkelresor
         */
        public int i_Enkelresor;
        /*
         * Antal Medföljande
         */
        public int i_AntalMedfoljande;

        /*
         * Utökad hämtning och lämning
         * Ensamåkning
         * Framsätesplacering
         */
        public boolean bl_UHOL;
        public boolean bl_Enamakning;
        public boolean bl_Framstesplacering;

        public boolean bl_Anslutning;

        public TFReseinformation(String s_TypAvResa, String s_Fardsatt, int i_Enkelresor, int i_AntalMedfoljande, boolean bl_UHOL, boolean bl_Enamakning, boolean bl_Framstesplacering, boolean bl_Anslutning)
        {
            this.s_TypAvResa = s_TypAvResa;
            this.s_Fardsatt = s_Fardsatt;
            this.i_Enkelresor = i_Enkelresor;
            this.i_AntalMedfoljande = i_AntalMedfoljande;
            this.bl_UHOL = bl_UHOL;
            this.bl_Enamakning = bl_Enamakning;
            this.bl_Framstesplacering = bl_Framstesplacering;
            this.bl_Anslutning = bl_Anslutning;
        }
    }

}
