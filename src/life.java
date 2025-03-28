public class life extends Policy {
    private String beneficiaryName;
    private double faceValue;

    public life() {
    }

    public life(String number, String owner, double yearlyPremium, String beneficiaryName, double faceValue) {
        super(number, owner, yearlyPremium);
        this.beneficiaryName = beneficiaryName;
        this.faceValue = faceValue;
    }

    // get
    public String getBeneficiaryName() {
        return this.beneficiaryName;
    }

    public double getFaceValue() {
        return this.faceValue;
    }

    // set
    public void setBeneficiaryName(String beneficiaryName) {
        if (!beneficiaryName.equals(""))
            this.beneficiaryName = beneficiaryName;
        else
            throw new IllegalArgumentException("Error, Beneficiary Nam can not be empty");
    }

    public void setFaceValue(double faceValue) {
        if (faceValue > 0)
            this.faceValue = faceValue;
        else
            throw new IllegalArgumentException("Error, Face Value can not be empty!!");
    }
    public String toString(){
        return super.toString() 
        + "Beneficiary Name: " + this.getBeneficiaryName() + " | "
        + "Face Value: " + this.getFaceValue() + "\n";
    }
}
