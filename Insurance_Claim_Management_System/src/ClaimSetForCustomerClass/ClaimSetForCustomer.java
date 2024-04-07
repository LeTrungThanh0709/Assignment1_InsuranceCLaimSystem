package ClaimSetForCustomerClass;

/**
 * @author <Le Trung Thanh - S3993494>
 */
import java.util.Iterator;
import java.util.Set;
import java.util.HashSet;
import InsuranceCardClass.InsuranceCard;
import ClaimClass.Claim;

public class ClaimSetForCustomer
{
    // Attribute
    private Set <Claim> aListOfClaim;



    // default constructor
    public ClaimSetForCustomer()
    {
        this.aListOfClaim = new HashSet <Claim>();
    }



    // constructor with a parameter
    public ClaimSetForCustomer( Set <Claim> aListOfClaim )
    {
        this.aListOfClaim = new HashSet<Claim>();
        this.aListOfClaim.addAll( aListOfClaim );
    }



    // define a method to check a claim
    public boolean checkClaim( Claim claim )
    {
        // check whether  the claim is already in the list or not
        Iterator <Claim> iterator = this.aListOfClaim.iterator();
        while ( iterator.hasNext() )
        {
            if ( iterator.next().equal( claim ) )
            {
                // the claim is already in the list
                return false;
            }
        }


        // the claim has not been in the list yet

        return true;
    }

    // define a method to add a claim
    public void addClaim( Claim claim )
    {
        this.aListOfClaim.add( claim );
    }

    public boolean deleteClaim( Claim claim )
    {
        return this.aListOfClaim.remove( claim );
    }



}
