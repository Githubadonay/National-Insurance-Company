
public class Policy{
private String number;
private String owner;
private double yearlyPremium;
private static int numOfPolicies;

public Policy(){
    this.number = "";
    this.owner ="";
    this.yearlyPremium = 0;
    numOfPolicies++;
}

public Policy(String number, String owner, double yearlyPremium ){
    this.number = number;
    this.owner = owner;
    this.yearlyPremium = yearlyPremium;
    numOfPolicies++;
}

//get
public String getNumber(){return this.number;}
public String getOwner(){return this.owner;}
public double getYearlyPremium(){return this.yearlyPremium;}
public static int getNumOfPolicies(){return numOfPolicies;}
public static void updateNumOfPolicy() {
    numOfPolicies--;
}

//set
public void setNumer( String number){
     if(!number.equals("") && number.length() == 5)
     this.number = number;
     else 
     throw new IllegalArgumentException("Error, Policy number must be 5 characters long");
    }

public void setOwner( String owner){
        if(!owner.equals(""))
        this.owner = owner;
        else 
        throw new IllegalArgumentException("Error, Policy owner can not be empty");
       }
public void setYearlyPremium( double yearlyPremium){
        if(yearlyPremium > 0)
        this.yearlyPremium = yearlyPremium;
        else 
        throw new IllegalArgumentException("Error, Yearly premium can not less 0");
       }

//toString
public String toString(){
 return "Policy number: " + this.getNumber() + " | "
 + "Policy Owner: " + this.getOwner() + " | "
 + "Yearly Premium:  " + this.getYearlyPremium() + "\n";
}
}
