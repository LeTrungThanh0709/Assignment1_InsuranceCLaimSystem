package CustomerSetClass;

import CustomerClass.Customer;

import java.util.HashSet;
import java.util.Set;

public class CustomerSet {
    // Attributes
    private Set<Customer> listOfCustomer;


    // default constructor
    public CustomerSet() {
        this.listOfCustomer = new HashSet<Customer>();
    }


    // parameterized constructor
    public CustomerSet(Set<Customer> listOfCustomer) {
        this.listOfCustomer = listOfCustomer;
    }


    // define a method to get the listOfCustomer
    public Set <Customer> getListOfCustomer()
    {
        return this.listOfCustomer;
    }
}