package ClaimClass;

/**
 * @author <Le Trung Thanh - S3993494>
 */
import CustomerClass.Customer;
import InsuranceCardClass.InsuranceCard;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import BankAccountClass.BankAccount;



public class Claim
{
    // Attributes
    private String id;
    private Date claimDate;
    private Customer insuredPerson;
    private String cardNumber;
    private Date examDate;
    private Set <String> listOfDocuments;
    private double claimAmount;
    private String status;
    private BankAccount receiverBankingInfo;



    // default constructor
    public Claim()
    {
        this.id = "Default";
        this.claimDate = null;
        this.insuredPerson = null;
        this.cardNumber = "Default";
        this.examDate = null;
        this.listOfDocuments = new HashSet<String>();
        this.claimAmount = 0;
        this.status = "Default";
        this.receiverBankingInfo = null;
    }



    // parameterized constructor
    public Claim(String id, Date claimDate, Customer insuredPerson, String cardNumber, Date examDate, Set<String> listOfDocuments, double claimAmount, String status, BankAccount receiverBankingInfo)
    {
        this.id = id;
        this.claimDate = claimDate;
        this.insuredPerson = insuredPerson;
        this.cardNumber = cardNumber;
        this.examDate = examDate;
        this.listOfDocuments = listOfDocuments;
        this.claimAmount = claimAmount;
        this.status = status;
        this.receiverBankingInfo = receiverBankingInfo;
    }



    // define a method to update status of a claim
    public boolean updateStatus( String newStatus )
    {
        String[] statusList = { "Processing" };
        boolean checked = false;
        for ( String availableStatus : statusList )
        {
            if( newStatus.equals( availableStatus ) )
            {
                checked = true;
            }
        }


        if( checked )
        {
            this.status = newStatus;
            return true;
        }

        return false;

    }



    // define a method to pay claim
    public boolean payingClaim( double amount )
    {
        if( amount == this.claimAmount )
        {
            this.receiverBankingInfo.updateBalance( amount );
            return true;
        }

        return false;
    }





    // override equals() method
    public boolean equal( Claim claim )
    {
        if ( claim.id.equals( this.id ) )
        {
            return true;
        }
        return false;
    }



    // define a method to get claimDate
    public Date getClaimDate()
    {
        return this.claimDate;
    }


    // define a method to get id
    public String getId()
    {
        return this.id;
    }


    public BankAccount getReceiverBankingInfo() {
        return receiverBankingInfo;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setClaimDate(Date claimDate) {
        this.claimDate = claimDate;
    }

    public void setInsuredPerson(Customer insuredPerson) {
        this.insuredPerson = insuredPerson;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public void setExamDate(Date examDate) {
        this.examDate = examDate;
    }

    public void setListOfDocuments(Set<String> listOfDocuments) {
        this.listOfDocuments = listOfDocuments;
    }

    public void setClaimAmount(double claimAmount) {
        this.claimAmount = claimAmount;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setReceiverBankingInfo(BankAccount receiverBankingInfo) {
        this.receiverBankingInfo = receiverBankingInfo;
    }


    public Customer getInsuredPerson() {
        return insuredPerson;
    }


    public Set<String> getListOfDocuments() {
        return listOfDocuments;
    }



    public String getStatus() {
        return status;
    }

    // define a method to print out a claim
    public void printAClaim()
    {
        System.out.printf( "\nClaim: \n- Id: %s\n- Claim date: %s\n- Insured person: %s\n- Card number: %s\n- Exam date: %s\n- List Of Documents: \n", this.id, this.claimDate.toString(), this.insuredPerson.getFullName(), this.cardNumber, this.examDate.toString());
        for (String document : this.listOfDocuments )
        {
            System.out.println("+ " + document );
        }
        System.out.printf( "- Claim amount %.2f\n- Status: %s\n- Bank account: ", this.claimAmount, this.status );
        this.receiverBankingInfo.printtABank();
    }



    public String claimToString() {


        ArrayList <String> documents = new ArrayList<>(this.listOfDocuments);
        String documentString = new String();
        for ( int i = 0; i < documents.size(); i ++ )
        {
            if( i == documents.size() - 1 )
            {
                documentString += documents.get( i );
            }
            else
            {
                documentString += documents.get( i ) + "/";
            }
        }
        return id + "," + claimDate.toString() +
                "," + insuredPerson.getId() +
                "," + cardNumber + "," + examDate.toString() + "," + documentString +
                "," + claimAmount +
                "," + status + "," + receiverBankingInfo.bankToString();
    }
}
