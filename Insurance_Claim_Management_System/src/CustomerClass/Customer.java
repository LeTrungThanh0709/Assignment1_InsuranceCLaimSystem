package CustomerClass;

/**
 * @author <Le Trung Thanh - S3993494>
 */
import ClaimSetForCustomerClass.ClaimSetForCustomer;
import java.util.Set;
import InsuranceCardClass.InsuranceCard;
import ClaimClass.Claim;
import AdminClass.Admin;

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



    // define a method to request a clam
    public boolean requestClaim( Claim claim, Admin admin )
    {
        // add the claim to the customer and add the claim to the admin
        if( this.aListOfClaims.checkClaim( claim ) && admin.checkClaim( claim ) )
        {
            claim.setInsuredPerson( this );
            this.aListOfClaims.addClaim( claim );
            admin.addClaim( claim );

            return true;
        }

        // can not add the claim to the customer as well as the admin
        return false;
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

    public String infoCustomerToString()
    {
        return this.id + "," + this.fullName + "\n";
    }
}
