package CustomerSetClass;

/**
 * @author <Le Trung Thanh - S3993494>
 */
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import CustomerClass.Customer;
import DependentClass.Dependent;
import PolicyHolderClass.PolicyHolder;

import java.util.Iterator;
public class CustomerSet
{
    // Attributes
    private Set <Customer> listOfCustomer;



    // default constructor
    public CustomerSet()
    {
        this.listOfCustomer = new HashSet<Customer>();
    }




    // parameterized constructor
    public CustomerSet(Set<Customer> listOfCustomer)
    {
        this.listOfCustomer = listOfCustomer;
    }



    // define a method to add a customer
    public boolean addCustomer( Customer customer )
    {
        Iterator <Customer> iterator = this.listOfCustomer.iterator();
        while ( iterator.hasNext() )
        {
            if ( iterator.next().getId().equals( customer.getId() ) )
            {
                // the customer has already been in the list
                return false;
            }
        }

        // the customer hasn't been added into the list yet
        // add the customer into the list
        this.listOfCustomer.add( customer );
        return true;
    }



    // define a method to print all customers
    public void printAllCustomer()
    {
        System.out.println("\nCustomer: ");


        ArrayList <PolicyHolder> arrayList = new ArrayList<>();

        for ( Customer customer : this.listOfCustomer )
        {
            if( customer instanceof  PolicyHolder )
            {
                arrayList.add( ( ( PolicyHolder) customer) );
            }

        }

        for ( int i = 0; i < arrayList.size(); i ++ )
        {
            for ( int j = i + 1; j < arrayList.size(); j ++ )
            {
                if( arrayList.get( i ).getFullName().compareTo( arrayList.get( j ).getFullName() ) > 0)
                {
                    PolicyHolder customer = arrayList.get(  j  );
                    arrayList.set( j, arrayList.get( i ) );
                    arrayList.set( i, customer);
                }
            }
        }

        for ( PolicyHolder policyHolder : arrayList )
        {
            policyHolder.printPolicyHolder();
        }
        System.out.println();
    }




    // define a method to get the listOfCustomer
    public Set <Customer> getListOfCustomer()
    {
        return this.listOfCustomer;
    }


    // define a method to get a customer
    public Customer getACustomer( String id )
    {
        for ( Customer customer : this.listOfCustomer )
        {
            if ( customer.getId().equals( id ) )
            {
                return customer;
            }
        }

        return null;
    }
}
