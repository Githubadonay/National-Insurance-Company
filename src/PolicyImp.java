import javax.swing.JOptionPane;

public class PolicyImp {
    public static void main(String[] args){
        Policy[] allPolicies = new Policy[100];

        int input = -1;
         
        do {
            input = Integer.parseInt(JOptionPane.showInputDialog("1. Add Policies\n2.Remove Policies\n3.View Policies\n4.Quit"));
        switch(input){
            case 1:
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
}
