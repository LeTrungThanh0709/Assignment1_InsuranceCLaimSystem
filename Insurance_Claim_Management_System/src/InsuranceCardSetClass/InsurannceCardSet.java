package InsuranceCardSetClass;


import InsuranceCardClass.InsuranceCard;

import java.util.HashSet;
import java.util.Set;

public class InsuranceCardSet {
    // Attribute
    private Set<InsuranceCard> listOfInsurance;


    // default constructor
    public InsuranceCardSet() {
        this.listOfInsurance = new HashSet<InsuranceCard>();
    }


    // parameterized constructor

    public InsuranceCardSet(Set<InsuranceCard> listOfInsurance) {
        this.listOfInsurance = new HashSet<InsuranceCard>();
        this.listOfInsurance.addAll(listOfInsurance);
    }

    public Set<InsuranceCard> getListOfInsurance() {
        return listOfInsurance;
    }
}