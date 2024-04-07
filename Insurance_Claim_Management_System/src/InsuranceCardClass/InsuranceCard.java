package InsuranceCardClass;

/**
 * @author <Le Trung Thanh - S3993494>
 */
import PolicyHolderClass.PolicyHolder;
import java.util.Date;

public class InsuranceCard
{
    // Attributes
    private String cardNumber;
    private PolicyHolder policyHolder;
    private String policyOwner;
    private Date expirationDate;



    // default constructor
    public InsuranceCard()
    {
        this.cardNumber = "Default";
        this.policyHolder = null;
        this.policyOwner = "Default";
        this.expirationDate = new Date();
    }


    // parameterized constructor


    public InsuranceCard(String cardNumber, PolicyHolder policyHolder, String policyOwner, Date expirationDate) {
        this.cardNumber = cardNumber;
        this.policyHolder = policyHolder;
        this.policyOwner = policyOwner;
        this.expirationDate = expirationDate;
    }



    // define a method to compare two insurances card
    public boolean equal( InsuranceCard insuranceCard )
    {
        if( this.cardNumber.equals( insuranceCard.cardNumber ) )
        {
            return true;
        }
        return false;
    }


    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public void setPolicyOwner(String policyOwner) {
        this.policyOwner = policyOwner;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    // define a method to set policyHolder
    public void setPolicyHolder(PolicyHolder policyHolder)
    {
        this.policyHolder = policyHolder;
    }

    public String getCardNumber() {
        return cardNumber;
    }


    public Date getExpirationDate() {
        return expirationDate;
    }


    // define a method to print a insurance card
    public void printAInsuranceCard()
    {
        System.out.printf("\nInsurance card:\n- Card number: %s\n- Policy holder: %s\n- Policy owner: %s\n- Expiration date: %s\n\n", this.cardNumber, this.policyHolder.getFullName(), this.policyOwner, this.expirationDate.toString());
    }


    public String insuranceCardToString() {
        return policyHolder.getId() + "," + cardNumber + "," + policyOwner + "," + expirationDate.toString() + "\n";
    }
}
