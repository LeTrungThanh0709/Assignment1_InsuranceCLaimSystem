package BankAccountClass;

/**
 * @author <Le Trung Thanh - S3993494>
 */

public class BankAccount
{
    // Attributes
    private String BankName;
    private String ownerName;
    private String cardNumber;
    private double balance;



    // default constructor
    public BankAccount()
    {
        this.BankName = "Default";
        this.ownerName = "Default";
        this.cardNumber = "Default";
        this.balance = 0;
    }



    // parameterized constructor
    public BankAccount(String bankName, String ownerName, String cardNumber, double balance)
    {
        BankName = bankName;
        this.ownerName = ownerName;
        this.cardNumber = cardNumber;
        this.balance = balance;
    }



    // define a method to update the balance
    public void updateBalance( double amount )
    {
        this.balance += amount;
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


    // define a method to print a bank account
    public void printtABank()
    {
        System.out.printf( "%s, %s, %s\n\n", this.BankName, this.ownerName, this.cardNumber);
    }

    public String bankToString() {
        return BankName + ',' + ownerName + ',' + cardNumber + ',' + balance  + "\n";
    }
}
