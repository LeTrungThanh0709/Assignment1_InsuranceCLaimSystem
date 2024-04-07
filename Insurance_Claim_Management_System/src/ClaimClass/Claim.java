package ClaimClass;


import BankAccountClass.BankAccount;
import CustomerClass.Customer;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Claim {
    // Attributes
    private String id;
    private Date claimDate;
    private Customer insuredPerson;
    private String cardNumber;
    private Date examDate;
    private Set<String> listOfDocuments;
    private double claimAmount;
    private String status;
    private BankAccount receiverBankingInfo;


    // default constructor
    public Claim() {
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
    public Claim(String id, Date claimDate, Customer insuredPerson, String cardNumber, Date examDate, Set<String> listOfDocuments, double claimAmount, String status, BankAccount receiverBankingInfo) {
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
}