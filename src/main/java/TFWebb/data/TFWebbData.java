package TFWebb.data;

import java.util.ArrayList;
import java.util.List;

public class TFWebbData {

    public List<TFWebbUser> tfWebbUsers = new ArrayList<TFWebbUser>();

    public TFWebbData()
    {
        // Add The users
        tfWebbUsers.add(new TFWebbUser("Sigrid Vårdgivare", "V"));
        //tfWebbUsers.add(new TFWebbUser("Kalle Kommun", "K"));
        //tfWebbUsers.add(new TFWebbUser("Mårten Månsson", "K"));

        // Bajsanvändare, verkar inte fungera
        /*
        tfWebbUsers.add(new TFWebbUser("Harald Haraldsson", "X"));
        tfWebbUsers.add(new TFWebbUser("Anna Andersson", "X"));
        tfWebbUsers.add(new TFWebbUser("Håkan Håkansson", "X"));
        tfWebbUsers.add(new TFWebbUser("Konrad Kundservice", "X"));
        tfWebbUsers.add(new TFWebbUser("Sune Vårdgivare", "X"));
        tfWebbUsers.add(new TFWebbUser("Anmälan Vårdgivare", "X"));
*/
        // Add the workplace and resenär for users
        if(this.findUsingEnhancedForLoop("Sigrid Vårdgivare", tfWebbUsers) != null) {
            this.findUsingEnhancedForLoop("Sigrid Vårdgivare", tfWebbUsers).addWorkplace("1234567890");
            this.findUsingEnhancedForLoop("Sigrid Vårdgivare", tfWebbUsers).addWorkplace("2345678901");
            this.findUsingEnhancedForLoop("Sigrid Vårdgivare", tfWebbUsers).tfResenarer.add("191212121212");
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

    }

    public TFWebbUser findUsingEnhancedForLoop(
        String name, List<TFWebbUser> customers) {

        for (TFWebbUser customer : customers) {
            if (customer.s_UserName.equals(name)) {
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
        List<String> tfResenarer = new ArrayList<String>();
        List<TFWebbWorkplace> tfWebWorkplace  = new ArrayList<TFWebbWorkplace>(); // Ändra till List<String> och ta bort klassen. Behövs ingen klass

        public TFWebbUser(String s_UserName, String s_UserType)
        {
            this.s_UserName = s_UserName;
            this.s_UserType = s_UserType;
        }

        public void addWorkplace(String s_WorkplaceValue)
        {
            this.tfWebWorkplace.add(new TFWebbWorkplace(s_WorkplaceValue));
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
}
