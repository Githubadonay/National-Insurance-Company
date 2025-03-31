import javax.swing.JOptionPane;

public class PolicyImp {
    public static void main(String[] args) {
        Policy[] allPolicies = new Policy[100];

        int input = -1;

        do {
            input = Integer.parseInt(
                    JOptionPane.showInputDialog("1. Add Policies\n2.Remove Policies\n3.View Policies\n4.Quit"));
            switch (input) {
                case 1:
                    AddPolicy(allPolicies);
                    break;
                case 2:
                    removepolicy(allPolicies);
                    break;
                case 3:
                    viewPolicies(allPolicies);
                    break;
                case 4:
                    JOptionPane.showMessageDialog(null,"Thank you, come again!!");
                    System.exit(0);
                    break;
                default:

            }
        } while (input >= 1 && input <= 4);
    }
    public static int searchPolicy(Policy[] allPolicies, String number) {
        int searchIndex = -1;
        for (int i = 0; i < Policy.getNumOfPolicies(); i++) {
            if (allPolicies[i].getNumber().equalsIgnoreCase(number)) {
                searchIndex = i;
                break;
            }
        }
        return searchIndex;

    }
    public static void removepolicy(Policy[] allPolicies) {
        viewPolicies(allPolicies);
        String policyToRemove = JOptionPane.showInputDialog("Enter the policy number to remove");
        int index = searchPolicy(allPolicies, policyToRemove);
        for (int i = index; i < Policy.getNumOfPolicies(); i++) {
            allPolicies[i] = allPolicies[i + 1];
        }
        allPolicies[Policy.getNumOfPolicies()] = null;
        Policy.updateNumOfPolicy();
    }

    public static void AddPolicy(Policy[] allPolicies){

      String pNumber = JOptionPane.showInputDialog("Enter Policy Number");
      String pOwner = JOptionPane.showInputDialog("Enter Policy Owner name");
      double pYearlyPremium = Double.parseDouble(JOptionPane.showInputDialog("Enter the Yearly Premium"));

        String choice = JOptionPane.showInputDialog("Enter the policy you want to add\n1.Automobile Policy\n2.Home Policy\n3.Insurance Policy");

        if(choice.equals("1")){
            String aVIN = JOptionPane.showInputDialog("Enter Automobile VIN number");
            String aMake = JOptionPane.showInputDialog("Enter Automobile Make");
            String aModel = JOptionPane.showInputDialog("Enter Automobile Model");
            allPolicies[Policy.getNumOfPolicies()] = new automobile(pNumber, pOwner, pYearlyPremium, aVIN,aMake,aModel );
        }
        else if(choice.equals("2")){
            String hStreetAddress = JOptionPane.showInputDialog("Enter Home address: ");
            int hYearBuilt = Integer.parseInt(JOptionPane.showInputDialog("Enter the year the home was built: "));
            double hDeductible = Double.parseDouble(JOptionPane.showInputDialog("Enter the home deductuble: "));
            allPolicies[Policy.getNumOfPolicies()] = new home(pNumber, pOwner, pYearlyPremium,hStreetAddress,hYearBuilt,hDeductible);
        }
        else if(choice.equals("3")){
            String lBeneficiaryName = JOptionPane.showInputDialog("Enter the life beneficiary name: ");
            double lFaceValue = Double.parseDouble(JOptionPane.showInputDialog("Enter the life face value: "));
            allPolicies[Policy.getNumOfPolicies()] = new life(pNumber, pOwner, pYearlyPremium,lBeneficiaryName,lFaceValue);
        }
    }

    public static void viewPolicies(Policy[] allPolicies){
        String output = "";
        //String output = "Item Code | Item Name | Item base Price($) | Item sales price($)\n";
        for(int i=0; i<Policy.getNumOfPolicies(); i++){
        output+= allPolicies[i].toString() + "\n";
    }
    JOptionPane.showMessageDialog(null,output);
}
};
