package BankAccountClass;


public class BankAccount {
    // Attributes
    private String BankName;
    private String ownerName;
    private String cardNumber;
    private double balance;


    // default constructor
    public BankAccount() {
        this.BankName = "Default";
        this.ownerName = "Default";
        this.cardNumber = "Default";
        this.balance = 0;
    }


    // parameterized constructor
    public BankAccount(String bankName, String ownerName, String cardNumber, double balance) {
        BankName = bankName;
        this.ownerName = ownerName;
        this.cardNumber = cardNumber;
        this.balance = balance;
    }




    public void setBankName(String bankName) {
        BankName = bankName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}