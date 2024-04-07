package PolicyHolderClass;

/**
 * @author <Le Trung Thanh - S3993494>
 */
import java.util.Iterator;
import java.util.Set;

import AdminClass.Admin;
import DependentClass.Dependent;

import ClaimSetForCustomerClass.ClaimSetForCustomer;
import CustomerClass.Customer;
import java.util.HashSet;
import  DependentSetForPolicyHolder.DependentSet;
import InsuranceCardClass.InsuranceCard;
public class PolicyHolder extends Customer
{
    // Attributes
    private DependentSet listOfDependent;



    // default constructor
    public PolicyHolder()
    {
        super();
        this.listOfDependent = new DependentSet();
    }



    // constructor with a parameter
    public PolicyHolder(String id, String fullName, InsuranceCard insuranceCard, ClaimSetForCustomer claimSetForCustomer, DependentSet listOfDependent )
    {
        super(id, fullName, insuranceCard, claimSetForCustomer );
        this.listOfDependent = listOfDependent;
    }



    // define a method to add an insurance card
    public boolean addInsuranceCard(InsuranceCard insuranceCard )
    {
        // check whether or not the policyholder had the insuranceCard
        if( this.getInsuranceCard() == null )
        {
            // the policyholder hasn't had the insuranceCard yet
            this.setInsuranceCard( insuranceCard );
            insuranceCard.setPolicyHolder( this );


            // add the insuranceCard to all the dependents
            Iterator <Dependent> iterator = this.listOfDependent.getListOfDependent().iterator();
            while ( iterator.hasNext() )
            {
                iterator.next().setInsuranceCard( insuranceCard );
            }
            return true;
        }

        return false;
    }



    // define a method to add a dependent
    public boolean addDependent( Dependent dependent )
    {
        if( this.listOfDependent.addDependent( dependent ) )
        {
            dependent.setPolicyHolder( this );
            return true;
        }

        return false;
    }


    // define a method to print a policyHolder
    public void printPolicyHolder()
    {
        System.out.printf("- %s(id: %s), dependents: ", this.getFullName(), this.getId());
        for ( Dependent dependent : this.listOfDependent.getListOfDependent() )
        {
            System.out.print( dependent.getFullName() + "(id: " + dependent.getId() + ")" + "   ");
        }
        System.out.println();
    }





}
