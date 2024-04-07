import AdminClass.Admin;
import BankAccountClass.BankAccount;
import ClaimClass.Claim;
import ClaimSetForAdminClass.ClaimSetForAdmin;
import ClaimSetForCustomerClass.ClaimSetForCustomer;
import CustomerClass.Customer;
import CustomerSetClass.CustomerSet;
import DependentClass.Dependent;
import DependentSetForPolicyHolder.DependentSet;
import InsuranceCardClass.InsuranceCard;
import InsuranceCardSetClass.InsuranceCardSet;
import PolicyHolderClass.PolicyHolder;

import java.text.SimpleDateFormat;
import java.util.*;

public class Main
{
    public static void main( String[] args )
    {
        Admin admin = new Admin();
        admin.userInterface();


    }
}