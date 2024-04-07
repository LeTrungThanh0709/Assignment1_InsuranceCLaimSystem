package DependentClass;

/**
 * @author <Le Trung Thanh - S3993494>
 */
import CustomerClass.Customer;
import PolicyHolderClass.PolicyHolder;
import ClaimSetForCustomerClass.ClaimSetForCustomer;
import InsuranceCardClass.InsuranceCard;

public class Dependent extends Customer
{
    // Attribute
    private PolicyHolder policyHolder;



    // default constructor
    public Dependent()
    {
        super();
        this.policyHolder = null;
    }



    // constructor with  parameters
    public Dependent( String id, String fullName, InsuranceCard insuranceCard, ClaimSetForCustomer claimSetForCustomer, PolicyHolder policyHolder)
    {
        super(id, fullName, insuranceCard, claimSetForCustomer);
        this.policyHolder = policyHolder;
    }




    // define a method to set policyHolder
    public void setPolicyHolder( PolicyHolder policyHolder )
    {
        this.policyHolder = policyHolder;
    }

    public String infoDependentToString() {


        return this.policyHolder.getId() + "," + this.getId() + "," + this.getFullName() + "\n";
    }


    // define a method to print a dependent
    public void printDependent()
    {
        System.out.printf( "- %s, policy holder: %s\n", this.getFullName(), this.policyHolder.getFullName());
    }

}
