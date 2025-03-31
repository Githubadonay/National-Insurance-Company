public class automobile extends Policy {
    private String VIN;
    private String make;
    private String model;

    public automobile(){}
    public automobile(String number, String owner, double yearlyPremium, String VIN, String make, String model){
        super(number,owner,yearlyPremium);
        this.VIN = VIN;
        this.make = make;
        this.model = model;
    }
    //get
    public String getVIN(){ return this.VIN;}
    public String getMake(){ return this.make;}
    public String getModel(){return this.model;}

    //set 
    public void setVIN(String VIN){
        if(!VIN.equals("") && VIN.length() == 7)
        this.VIN = VIN;
        else
        throw new IllegalArgumentException("Error, VIN must be 7 characters long. \nVIN can not be empty");
    };
    public void setMake(String make){
        if(!make.equals(""))
        this.make = make;
        else
        throw new IllegalArgumentException("Error, Make can not be empty");
    };
    public void setModel(String model){
        if(!model.equals(""))
        this.model = model;
        else
        throw new IllegalArgumentException("Error, Model can not be empty");
    };
    public String toString(){
        return super.toString()
        + "Vehicle ID: " + this.getVIN() + " | "
        + "Make: " + this.getMake() + " | "
        + "Model: " + this.getModel() + "\n";
    }


}
