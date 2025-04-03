import javax.swing.JOptionPane;

public class PolicyImp {
    public static void main(String[] args) {
        Policy[] allPolicies = new Policy[100];

        int input = -1;

        do {
            input = Integer.parseInt(
                    JOptionPane.showInputDialog("1.Add Policies\n2.Remove Policies\n3.View Policies\n4.Quit"));
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
                    JOptionPane.showMessageDialog(null, "Thank you, come again!!");
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

    public static void AddPolicy(Policy[] allPolicies) {
        String pNumber = "";
        String pOwner = "";
        double pYearlyPremium = 0;

        try {
            pNumber = JOptionPane.showInputDialog("Enter Policy Number");
        } catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        try {
            pOwner = JOptionPane.showInputDialog("Enter Policy Owner name");
        } catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        try {
            pYearlyPremium = Double.parseDouble(JOptionPane.showInputDialog("Enter the Yearly Premium"));
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Invalid number format!");
        }

        String choice = JOptionPane.showInputDialog(
                "Enter the policy you want to add\n1.Automobile Policy\n2.Home Policy\n3.Insurance Policy");
        // Policy aPolicy = null;

        if (choice.equals("1")) {

            String aVIN = "";
            String aMake = "";
            String aModel = "";
            try {
                aVIN = JOptionPane.showInputDialog("Enter Automobile VIN number");
            } catch (IllegalArgumentException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }

            try {
                aMake = JOptionPane.showInputDialog("Enter Automobile Make");
            } catch (IllegalArgumentException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }

            try {
                aModel = JOptionPane.showInputDialog("Enter Automobile Model");
            } catch (IllegalArgumentException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
            allPolicies[Policy.getNumOfPolicies()] = new automobile(pNumber, pOwner,
                    pYearlyPremium, aVIN, aMake,
                    aModel);

        } else if (choice.equals("2")) {
            String hStreetAddress = "";
            int hYearBuilt = 0;
            double hDeductible = 0;

            try {
                hStreetAddress = JOptionPane.showInputDialog("Enter Home address: ");

            } catch (IllegalArgumentException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }

            try {
                hYearBuilt = Integer.parseInt(JOptionPane.showInputDialog("Enter the year the home was built: "));
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Invalid number format!");
            } catch (IllegalArgumentException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }

            try {
                hDeductible = Double.parseDouble(JOptionPane.showInputDialog("Enter the home deductuble: "));
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Invalid number format!");
            } catch (IllegalArgumentException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
            allPolicies[Policy.getNumOfPolicies()] = new home(pNumber, pOwner,
                    pYearlyPremium, hStreetAddress,
                    hYearBuilt, hDeductible);

        } else if (choice.equals("3")) {
            String lBeneficiaryName = "";
            double lFaceValue = 0;
            try {
                lBeneficiaryName = JOptionPane.showInputDialog("Enter the life beneficiary name: ");
            } catch (IllegalArgumentException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }

            try {
                lFaceValue = Double.parseDouble(JOptionPane.showInputDialog("Enter the life face value: "));
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Invalid number format!");
            } catch (IllegalArgumentException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
            allPolicies[Policy.getNumOfPolicies()] = new life(pNumber, pOwner,
                    pYearlyPremium, lBeneficiaryName,
                    lFaceValue);
        }
    }

    public static void viewPolicies(Policy[] allPolicies) {
        String output = "";
        for (int i = 0; i < Policy.getNumOfPolicies(); i++) {
            output += allPolicies[i].toString() + "\n";
        }
        JOptionPane.showMessageDialog(null, output);
    }
};
