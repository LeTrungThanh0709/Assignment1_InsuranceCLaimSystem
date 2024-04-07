package InsuranceCardClass;


import PolicyHolderClass.PolicyHolder;

import java.util.Date;

public class InsuranceCard {
    // Attributes
    private String cardNumber;
    private PolicyHolder policyHolder;
    private String policyOwner;
    private Date expirationDate;


    // default constructor
    public InsuranceCard() {
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

}