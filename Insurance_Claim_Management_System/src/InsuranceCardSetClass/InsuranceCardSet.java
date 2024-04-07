package InsuranceCardSetClass;

import InsuranceCardClass.InsuranceCard;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class InsuranceCardSet
{
    // Attribute
    private Set<InsuranceCard> listOfInsurance;



    // default constructor
    public InsuranceCardSet()
    {
        this.listOfInsurance = new HashSet<InsuranceCard>();
    }



    // parameterized constructor

    public InsuranceCardSet(Set<InsuranceCard> listOfInsurance)
    {
        this.listOfInsurance = new HashSet<InsuranceCard>();
        this.listOfInsurance.addAll( listOfInsurance );
    }



    // define a method to add the insurance card
    public boolean addInsuranceCard( InsuranceCard insuranceCard )
    {
        Iterator<InsuranceCard> iterator = this.listOfInsurance.iterator();
        while ( iterator.hasNext() )
        {
            if( iterator.next().equal( insuranceCard ) )
            {
                // the insurance card is already in the list
                return false;
            }
        }


        // the insurance card hasn't added into the list yet
        // add the insurance into the list
        this.listOfInsurance.add( insuranceCard );
        return true;
    }



    // define a method to print all insurance card in expirationDate order
    public void getAll()
    {
        ArrayList<InsuranceCard> insuranceCardArrayList = new ArrayList<>(this.listOfInsurance);
        for ( int i = 0; i < insuranceCardArrayList.size(); i ++ )
        {
            for ( int j = i + 1; j < insuranceCardArrayList.size(); j ++ )
            {
                if( insuranceCardArrayList.get( i ).getExpirationDate().getTime() > insuranceCardArrayList.get( j ).getExpirationDate().getTime() )
                {
                    InsuranceCard temp = new InsuranceCard();
                    temp = insuranceCardArrayList.get( j );
                    insuranceCardArrayList.set( j, insuranceCardArrayList.get( i ) );
                    insuranceCardArrayList.set( i, temp  );
                }
            }
        }

        for ( InsuranceCard insuranceCard : insuranceCardArrayList )
        {
            insuranceCard.printAInsuranceCard();
        }
    }



    // define a method to get a insurance card
    public InsuranceCard getAInsuranceCard( String cardNumber )
    {
        for ( InsuranceCard insuranceCard : this.listOfInsurance )
        {
            if( insuranceCard.getCardNumber().equals( cardNumber ) )
            {
                return  insuranceCard;
            }
        }

        return null;
    }


    public Set<InsuranceCard> getListOfInsurance() {
        return listOfInsurance;
    }
}