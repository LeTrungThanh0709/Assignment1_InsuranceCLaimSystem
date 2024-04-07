package ClaimSetForCustomerClass;


import ClaimClass.Claim;

import java.util.HashSet;
import java.util.Set;

public class ClaimSetForCustomer {
    // Attribute
    private Set<Claim> aListOfClaim;


    // default constructor
    public ClaimSetForCustomer() {
        this.aListOfClaim = new HashSet<Claim>();
    }


    // constructor with a parameter
    public ClaimSetForCustomer(Set<Claim> aListOfClaim) {
        this.aListOfClaim = new HashSet<Claim>();
        this.aListOfClaim.addAll(aListOfClaim);
    }
}
