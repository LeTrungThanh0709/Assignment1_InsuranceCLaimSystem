package CustomerClass;

public abstract class Customer
{
    // Attributes for a customer
    private String id; // format c-numbers; 7 numbers
    private String fullName;
    private InsuranceCard insuranceCard;
    private ClaimSetForCustomer aListOfClaims;




    // default constructor
    public Customer()
    {
        this.id = "Default";
        this.fullName  = "Default";
        this.insuranceCard = null;
        this.aListOfClaims = new ClaimSetForCustomer();
    }



    // constructor with 4 parameters
    public Customer( String id, String fullName, InsuranceCard insuranceCard, ClaimSetForCustomer aListOfClaims )
    {
        this.id = id;
        this.fullName = fullName;
        this.insuranceCard = insuranceCard;
        this.aListOfClaims = aListOfClaims;
    }


    // define a method to set insuranceCard
    public void setInsuranceCard( InsuranceCard insuranceCard )
    {
        this.insuranceCard = insuranceCard;
    }



    // define a method to get the insuranceCard
    public InsuranceCard getInsuranceCard()
    {
        return this.insuranceCard;
    }



    // define a method to get Id
    public String getId()
    {
        return this.id;
    }


    public void setId(String id) {
        this.id = id;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }


    public String getFullName()
    {
        return fullName;
    }


    public ClaimSetForCustomer getaListOfClaims() {
        return aListOfClaims;
    }

}
