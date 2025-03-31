import javax.swing.JOptionPane;

public class PolicyImp {
    public static void main(String[] args){
        Policy[] allPolicies = new Policy[100];

        int input = -1;
         
        do {
            input = Integer.parseInt(JOptionPane.showInputDialog("1. Add Policies\n2.Remove Policies\n3.View Policies\n4.Quit"));
        switch(input){
            case 1:
            AddPolicy(allPolicies);
            break;
            case 2:
            break;
            case 3:
            break;
            case 4:
            break;
            default:

         }
    } while(input >= 1 && input <= 4);
}
    public static Policy AddPolicy(Policy[] allPolicies){
        Policy aPolicy = new Policy();

        try{
            String pNumber = JOptionPane.showInputDialog("Enter Policy Number");
            aPolicy.setNumer(pNumber);
        }catch(IllegalArgumentException ex){
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        try {
            String pOwner = JOptionPane.showInputDialog("Enter Policy Owner name");
            aPolicy.setOwner(pOwner);
        }catch(IllegalArgumentException ex){
            JOptionPane.showMessageDialog( null,ex.getMessage());
        }
        try{
            double pYearlyPremium = Double.parseDouble(JOptionPane.showInputDialog("Enter the Yearly Premium"));
            aPolicy.setYearlyPremium(pYearlyPremium);
        }catch(IllegalArgumentException ex){
            JOptionPane.showMessageDialog(null,ex.getMessage());
        }
        return aPolicy;

        String choice = JOptionPane.showInputDialog("Enter the policy you want to add\n1.Automobile Policy\n2.Home Policy\n3.Insurance Policy");

        if(choice.equals("1")){
            String aVIN = JOptionPane.showInputDialog("Enter Automobile VIN number");
            String aMake = JOptionPane.showInputDialog("Enter Automobile Make");
            String aModel = JOptionPane.showInputDialog("Enter Automobile Model");
            allPolicies[Policy.getNumOfPolicies()] = new automobile(pNumber, pOwner, pYearlyPremium,aVIN,aMake,aModel )
        }
    }


}
