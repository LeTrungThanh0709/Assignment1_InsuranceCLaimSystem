package DependentClass;


import CustomerClass.Customer;
import PolicyHolderClass.PolicyHolder;

public class Dependent extends Customer {
    // Attribute
    private PolicyHolder policyHolder;


    // default constructor
    public Dependent() {
        super();
        this.policyHolder = null;
    }


    // constructor with  parameters
    public Dependent(String id, String fullName, InsuranceCard insuranceCard, ClaimSetForCustomer claimSetForCustomer, PolicyHolder policyHolder) {
        super(id, fullName, insuranceCard, claimSetForCustomer);
        this.policyHolder = policyHolder;
    }


    // define a method to set policyHolder
    public void setPolicyHolder( PolicyHolder policyHolder )
    {
        this.policyHolder = policyHolder;
    }




}
