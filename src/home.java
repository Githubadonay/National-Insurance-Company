public class home extends Policy {
    private String streetAddress;
    private int yearBuilt;
    private double deductible;

    public home() {
    }

    public home(String number, String owner, double yearlyPremium, String streetAddress, int yearBuilt,
            double deductible) {
        super(number, owner, yearlyPremium);
        this.streetAddress = streetAddress;
        this.yearBuilt = yearBuilt;
        this.deductible = deductible;
    }

    // get
    public String getStreetAddress() {
        return this.streetAddress;
    }

    public int getYearBuilt() {
        return this.yearBuilt;
    }

    public double getDeductible() {
        return this.deductible;
    }
    // set

    public void setStreetAddress(String streetAddress) {
        if (!streetAddress.equals(""))
            this.streetAddress = streetAddress;
        else
            throw new IllegalArgumentException("Error, Street Address can not be empty!!");
    }

    public void setYearBuilt(int yearBuilt) {
        if (yearBuilt >= 1800 && yearBuilt <= 2022)
            this.yearBuilt = yearBuilt;
        else
            throw new IllegalArgumentException("Error, Year Built must be in between 1800 to 2022");
    }

    public void setDeductible(double deductible) {
        if (deductible > 0)
            this.deductible = deductible;
        else
            throw new IllegalArgumentException("Error, Deductible can not be empty");
    }
    public String toString(){
        return super.toString() 
        + "Street Address: " + this.getStreetAddress() + " | "
        + "Year Built: " + this.getYearBuilt() + " | "
        + "Deductible: " + this.getDeductible() + "\n";
    }
}
