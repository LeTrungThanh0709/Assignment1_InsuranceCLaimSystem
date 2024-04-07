package PolicyHolderClass;

import CustomerClass.Customer;

public class PolicyHolder extends Customer {
    // Attributes
    private DependentSet listOfDependent;


    // default constructor
    public PolicyHolder() {
        super();
        this.listOfDependent = new DependentSet();
    }


    // constructor with a parameter
    public PolicyHolder(String id, String fullName, InsuranceCard insuranceCard, ClaimSetForCustomer claimSetForCustomer, DependentSet listOfDependent) {
        super(id, fullName, insuranceCard, claimSetForCustomer);
        this.listOfDependent = listOfDependent;
    }


}
