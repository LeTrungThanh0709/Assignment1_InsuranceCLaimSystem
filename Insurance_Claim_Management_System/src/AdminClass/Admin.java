package AdminClass;


public class Admin {
    // Attributes
    private CustomerSet listOfCustomer;
    private InsuranceCardSet listOfInsuranceCard;
    private ClaimSetForAdmin listOfClaimSet;


    // default constructor

    public Admin() {
        this.listOfCustomer = new CustomerSet();
        this.listOfInsuranceCard = new InsuranceCardSet();
        this.listOfClaimSet = new ClaimSetForAdmin();
    }


    // parameterized constructor

    public Admin(CustomerSet listOfCustomer, InsuranceCardSet listOfInsuranceCard, ClaimSetForAdmin listOfClaimSet) {
        this.listOfCustomer = listOfCustomer;
        this.listOfInsuranceCard = listOfInsuranceCard;
        this.listOfClaimSet = listOfClaimSet;
    }
}