package AdminClass;

/**
 * @author <Le Trung Thanh - S3993494>
 */
import BankAccountClass.BankAccount;
import ClaimClass.Claim;
import ClaimSetForAdminClass.ClaimSetForAdmin;
import CustomerClass.Customer;
import CustomerSetClass.CustomerSet;
import DependentClass.Dependent;
import InsuranceCardClass.InsuranceCard;
import InsuranceCardSetClass.InsuranceCardSet;
import PolicyHolderClass.PolicyHolder;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


public class Admin
{
    // Attributes
    private CustomerSet listOfCustomer;
    private InsuranceCardSet listOfInsuranceCard;
    private ClaimSetForAdmin listOfClaimSet;



    // default constructor

    public Admin()
    {
        this.listOfCustomer = new CustomerSet();
        this.listOfInsuranceCard = new InsuranceCardSet();
        this.listOfClaimSet = new ClaimSetForAdmin();
    }



    // parameterized constructor

    public Admin(CustomerSet listOfCustomer, InsuranceCardSet listOfInsuranceCard, ClaimSetForAdmin listOfClaimSet)
    {
        this.listOfCustomer = listOfCustomer;
        this.listOfInsuranceCard = listOfInsuranceCard;
        this.listOfClaimSet = listOfClaimSet;
    }



    // define a class to save data to the file
    public void saveData()
    {
        try {
            FileWriter fileWriter1 = new FileWriter( "PolicyHolder.txt");
            FileWriter fileWriter2 = new FileWriter( "Dependent.txt");
            FileWriter fileWriter3 = new FileWriter( "InsuranceCard.txt");
            FileWriter fileWriter4 = new FileWriter( "Bank.txt" );
            FileWriter fileWriter5 = new FileWriter( "Claim.txt" );

            // save data of all customers
            for ( Customer customer : this.listOfCustomer.getListOfCustomer() )
            {
                if ( customer instanceof PolicyHolder )
                {
                    fileWriter1.write( ( ( PolicyHolder ) customer ).infoCustomerToString() );
                }
                else if( customer instanceof Dependent )
                {
                    fileWriter2.write( ( ( Dependent ) customer  ).infoDependentToString() );
                }

            }

            // save data of all insuranceCard
            for ( InsuranceCard insuranceCard : this.listOfInsuranceCard.getListOfInsurance() )
            {
                fileWriter3.write( insuranceCard.insuranceCardToString() );
            }


            // save bank accounts
            for ( Claim claim : this.listOfClaimSet.getListOfClaim() )
            {
                fileWriter4.write( claim.getReceiverBankingInfo().bankToString());
            }

            // save claim
            for ( Claim claim : this.listOfClaimSet.getListOfClaim() )
            {
                fileWriter5.write( claim.claimToString());
            }
            fileWriter1.close();
            fileWriter2.close();
            fileWriter3.close();
            fileWriter4.close();
            fileWriter5.close();
        }
        catch ( IOException e )
        {
            System.err.println( "Failed to save date to the file " + e.getMessage() );
            e.printStackTrace();
        }

    }







    // define a method to load the data to the system
    public void loadData()
    {
        try
        {
            // load data of all policyHolders
            BufferedReader reader1 = new BufferedReader( new FileReader( "PolicyHolder.txt" ) );
            String line;
            while ( ( line = reader1.readLine() ) != null )
            {
                PolicyHolder policyHolder = new PolicyHolder();
                StringTokenizer inReader = new StringTokenizer( line, "," );
                policyHolder.setId( inReader.nextToken() );
                policyHolder.setFullName( inReader.nextToken() );
                this.listOfCustomer.addCustomer( policyHolder );
            }
            reader1.close();


            // load data of all dependent
            BufferedReader reader2 = new BufferedReader( new FileReader( "Dependent.txt" ) );
            while ( ( line = reader2.readLine() ) != null )
            {
                Dependent dependent = new Dependent();
                StringTokenizer inReader = new StringTokenizer( line, "," );
                String idPolicyHolder = inReader.nextToken();
                dependent.setId( inReader.nextToken() );
                dependent.setFullName( inReader.nextToken() );
                // find the policy holder
                for ( Customer policyHolder : this.listOfCustomer.getListOfCustomer() )
                {
                    if ( policyHolder instanceof PolicyHolder && ( ( PolicyHolder ) policyHolder ).getId().equals( idPolicyHolder ) )
                    {
                        ( ( PolicyHolder )policyHolder).addDependent( dependent );
                    }
                }
                this.listOfCustomer.addCustomer( dependent );
            }
            reader2.close();



            // load data for all insurance card
            BufferedReader reader3 = new BufferedReader( new FileReader( "InsuranceCard.txt" ) );
            while ( ( line = reader3.readLine() ) != null )
            {
                StringTokenizer inReader = new StringTokenizer( line, "," );

                String idPolicyHolder = inReader.nextToken();

                InsuranceCard insuranceCard = new InsuranceCard();
                insuranceCard.setCardNumber( inReader.nextToken() );
                insuranceCard.setPolicyOwner( inReader.nextToken()  );
                String expirationDateString = inReader.nextToken();

                SimpleDateFormat simpleDateFormat = new SimpleDateFormat( "EEE MMM dd HH:mm:ss zzz yyyy" );
                Date expirationDate = new Date();
                try {
                    expirationDate = simpleDateFormat.parse( expirationDateString );
                }
                catch ( ParseException e )
                {
                    e.printStackTrace();
                }

                insuranceCard.setExpirationDate( expirationDate );

                // find policyHolder who own this card
                for ( Customer policyHolder : this.listOfCustomer.getListOfCustomer() )
                {
                    if ( policyHolder instanceof  PolicyHolder )
                    {
                        if ( idPolicyHolder.equals( ( ( PolicyHolder ) policyHolder).getId() ) )
                        {
                            ( ( PolicyHolder ) policyHolder ).addInsuranceCard( insuranceCard );
                        }
                    }
                }
                this.listOfInsuranceCard.addInsuranceCard( insuranceCard );

            }
            reader3.close();



            // load data for all claims
            BufferedReader reader4 = new BufferedReader( new FileReader( "Claim.txt" ) );
            while ( ( line = reader4.readLine() ) != null )
            {
                StringTokenizer inReader = new StringTokenizer( line, "," );
                Claim claim = new Claim();

                claim.setId( inReader.nextToken() );
                // claim date
                Date claimDate = new Date();
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat( "EEE MMM dd HH:mm:ss zzz yyyy");
                try {
                    claimDate = simpleDateFormat.parse( inReader.nextToken() );
                }
                catch ( ParseException e)
                {
                    e.printStackTrace();
                }
                claim.setClaimDate( claimDate );

                String idPolicyHolder = inReader.nextToken();

                claim.setCardNumber( inReader.nextToken() );

                // exam date
                Date examDate = new Date();
                SimpleDateFormat simpleDateFormatExamDate = new SimpleDateFormat( "EEE MMM dd HH:mm:ss zzz yyyy");
                try {
                    examDate = simpleDateFormatExamDate.parse( inReader.nextToken() );
                }
                catch ( ParseException e)
                {
                    e.printStackTrace();
                }
                claim.setExamDate( examDate );


                // list of documents( seperated by - )
                String listOfDocuments = inReader.nextToken();
                StringTokenizer inReader1 = new StringTokenizer( listOfDocuments, "/" );
                Set <String> documents = new HashSet<String>();
                while ( inReader1.hasMoreElements() )
                {
                    documents.add( inReader1.nextToken() );
                }
                claim.setListOfDocuments( documents );


                // load claim amount
                String claimAmountString = inReader.nextToken();
                double claimAmount = Double.parseDouble( claimAmountString ) ;
                claim.setClaimAmount( claimAmount );

                // load status
                claim.setStatus( inReader.nextToken() );

                // load bank acount
                BankAccount bankAccount = new BankAccount();
                bankAccount.setBankName( inReader.nextToken() );
                bankAccount.setOwnerName( inReader.nextToken() );
                bankAccount.setCardNumber( inReader.nextToken() );
                double balance;
                String doubleString = inReader.nextToken();
                balance = Double.parseDouble( doubleString );
                bankAccount.setBalance( balance );
                claim.setReceiverBankingInfo( bankAccount );

                // find the policyHolder who requested this claim
                for ( Customer customer : this.listOfCustomer.getListOfCustomer() )
                {
                    if( customer.getId().equals( idPolicyHolder ) )
                    {
                        customer.requestClaim( claim, this  );
                    }
                }



            }
            reader4.close();


        }
        catch ( IOException e )
        {
            System.err.println( "Failed to load data: " + e.getMessage() );
            e.printStackTrace();
        }

    }



    // define a method to check a claim
    public boolean checkClaim( Claim claim )
    {
        if( this.listOfClaimSet.checkClaim( claim ) )
        {
            return true;
        }
        return false;
    }

    // define a method to add a claim
    public void addClaim( Claim claim )
    {
        this.listOfClaimSet.addClaim( claim );
    }






    // define a method to update a claim
    public boolean updateClaim( Claim claim, String newStatus )
    {
        if( this.listOfClaimSet.updateClaim( claim , newStatus ))
        {
            return true;
        }

        return false;
    }

    // define a method to pay the money
    public boolean payMoney( Claim claim, double amount )
    {
        if ( this.listOfClaimSet.payingProcess( claim, amount ) )
        {
            return true;
        }
        return false;
    }



    // define a method to track the status of the
    public void trackingStatus()
    {
        System.out.print( "\nEnter id of the claim: ");
        String id;
        Scanner scanner = new Scanner( System.in );
        id = scanner.nextLine();

        if( this.listOfClaimSet.getOne( id ) != null )
        {
            System.out.println(  "- Status: " + this.listOfClaimSet.getOne( id ).getStatus() );
        }
        else
        {
            System.out.println( "The claim doesn't exit!");
        }
    }


    // define a method to track documents
    public void trackingDocuments( )
    {
        System.out.print( "\nEnter id of the claim: ");
        String id;
        Scanner scanner = new Scanner( System.in );
        id = scanner.nextLine();
        System.out.println("List of documents: ");

        if( this.listOfClaimSet.getOne( id ) != null )
        {
            for ( String document : this.listOfClaimSet.getOne( id ).getListOfDocuments() )
            {
                System.out.println(  "- "+ document );
            }
        }
        else
        {
            System.out.println( "The claim doesn't exist!");
        }
    }



    // define a method to view a claim
    public void viewAClaim()
    {
        System.out.print( "\nEnter id of the claim: ");
        Scanner scanner = new Scanner( System.in );
        String id;
        id = scanner.nextLine();

        if ( this.listOfClaimSet.getOne( id ) != null )
        {
            this.listOfClaimSet.getOne( id ).printAClaim();
        }
        else
        {
            System.out.println( "The claim doesn't exist");
        }

    }



    // define a method to view a insurance card
    public void viewAInsuranceCard()
    {
        System.out.print( "\nEnter card number: ");
        Scanner scanner = new Scanner( System.in );
        String cardNumber;
        cardNumber = scanner.nextLine();


        if ( this.listOfInsuranceCard.getAInsuranceCard( cardNumber ) != null )
        {
            this.listOfInsuranceCard.getAInsuranceCard( cardNumber ).printAInsuranceCard();
        }
        else
        {
            System.out.println( "The insurance card doesn't exist");
        }
    }



    // define a method to view a customer
    public void viewACustomer()
    {
        System.out.print( "\nEnter id of a customer: ");
        Scanner scanner = new Scanner( System.in );
        String id;
        id = scanner.nextLine();

        if( this.listOfCustomer.getACustomer( id ) != null )
        {
            if( this.listOfCustomer.getACustomer( id ) instanceof  PolicyHolder )
            {
                ( ( PolicyHolder ) this.listOfCustomer.getACustomer( id ) ).printPolicyHolder();
            }
            else
            {
                ( ( Dependent ) this.listOfCustomer.getACustomer( id ) ).printDependent();
            }
        }
        else
        {
            System.out.println( "The customer doesn't exist");
        }
    }



    // define a method to create a user interface based text
    public void userInterface()
    {
        this.loadData();
        System.out.println( "\n\n**********INSURANCE CLAIM MANAGEMENT SYSTEM APPLICATION**********");
        System.out.println( "Here are 4 options: ");
        while( true )
        {
            // create three options
            System.out.print( "\n\n0. Exit\n1. Managing\n2. Tracking\n3. Processing\n\n" );
            System.out.print( "Enter your choice: ");
            int choice;
            Scanner scanner = new Scanner( System.in );
            choice = scanner.nextInt();


            if( choice == 0 )
            {
                this.saveData();
                break;
            }
            else if( choice == 1 )
            {
                while ( true )
                {
                    System.out.print( "\n\n0. Back\n1. View all claims\n2. View all insurance cards\n3. View all customers\n4. View a claim\n5. View a insurance card\n6. View a customer\n");
                    System.out.print( "Enter your choice: ");
                    int managingChoice;
                    Scanner scanner1 = new Scanner( System.in );
                    managingChoice = scanner1.nextInt();

                    if( managingChoice == 0 )
                    {
                        break;
                    }
                    else if( managingChoice == 1 )
                    {
                        this.listOfClaimSet.getAll();
                    }
                    else if( managingChoice == 2 )
                    {
                        this.listOfInsuranceCard.getAll();
                    }
                    else if( managingChoice == 3 )
                    {
                        this.listOfCustomer.printAllCustomer();
                    }
                    else if( managingChoice == 4 )
                    {
                        this.viewAClaim();
                    }
                    else if( managingChoice == 5 )
                    {
                        this.viewAInsuranceCard();
                    }
                    else if( managingChoice == 6 )
                    {
                        this.viewACustomer();
                    }
                    else
                    {
                        System.out.println( "Invalid choice!. Please choose the valid choice( 0-3 )");
                    }

                }


            }
            else if( choice == 2 )
            {

                while ( true )
                {
                    System.out.print( "\n\n0. Back\n1. Tracking status\n2. Tracking documents\n\n");
                    System.out.print( "Enter your choice: ");
                    int trackingChoice;
                    Scanner scanner2 = new Scanner( System.in );
                    trackingChoice = scanner2.nextInt();


                    if( trackingChoice == 0 )
                    {
                        break;
                    }
                    else if( trackingChoice == 1 )
                    {
                        this.trackingStatus();
                    }
                    else   if( trackingChoice == 2 )
                    {
                        this.trackingDocuments();
                    }
                    else
                    {
                        System.out.println( "Invalid choice! Please choose a valid choice( 0-2 )");
                    }
                }
            }
            else if( choice == 3 )
            {
                while ( true )
                {
                    System.out.print( "\n\n0. Back\n1. Paying Money\n2. Update status\n3. Delete a Claim\n\n");
                    System.out.print( "Enter your choice: ");
                    int processChoice;
                    Scanner scanner3 = new Scanner( System.in );
                    processChoice = scanner3.nextInt();


                    if( processChoice == 0 )
                    {
                        break;
                    }
                    else if( processChoice == 1 )
                    {
                        System.out.print( "\nEnter the id of the claim: ");
                        String id;
                        Scanner scanner4 = new Scanner( System.in );
                        id = scanner4.nextLine();

                        if( this.listOfClaimSet.getOne( id ) != null && !this.listOfClaimSet.getOne( id ).getStatus().equals( "Done"))
                        {
                            System.out.print("- Enter correct amount: ");
                            double amount;
                            Scanner scanner5 = new Scanner( System.in );
                            amount = scanner5.nextDouble();
                            this.payMoney( this.listOfClaimSet.getOne( id ), amount );
                            System.out.println("The claim is paid successfully and The status claim is also updated into Done");
                        }
                        else if( this.listOfClaimSet.getOne( id ) != null && this.listOfClaimSet.getOne( id ).getStatus().equals("Done"))
                        {
                            System.out.println( "\nThe claim was paid before ");
                        }
                        else if( this.listOfClaimSet.getOne( id ) == null )
                        {
                            System.out.println( "\nThe claim doesn't exit.");
                        }
                    }
                    else if( processChoice == 2 )
                    {

                        System.out.print( "\nEnter the id of the claim: ");
                        String id;
                        Scanner scanner6 = new Scanner( System.in );
                        id = scanner6.nextLine();

                        if( this.listOfClaimSet.getOne( id ) != null && this.listOfClaimSet.getOne( id ).getStatus().equals( "New") )
                        {
                            System.out.print("\nEnter status( just Processing not Done beacause when we pay money, Done status automatically is updated ): ");
                            String status = new String();
                            Scanner scanner7 = new Scanner( System.in );
                            status = scanner7.nextLine();
                            if( this.updateClaim( this.listOfClaimSet.getOne( id ), status ) )
                            {
                                System.out.println( "Updated successfully!");
                            }
                            else
                            {
                                System.out.println( "Updated unsuccessfully!");
                            }
                        }
                        else if ( this.listOfClaimSet.getOne( id ) != null && !this.listOfClaimSet.getOne( id ).getStatus().equals( "New"))
                        {
                            System.out.println( "\nThe status of claim is " + this.listOfClaimSet.getOne( id ).getStatus());
                            if ( this.listOfClaimSet.getOne(id).getStatus().equals("Processing") )
                            {
                                System.out.println("Please pay the claim to automatically get Done status");
                            }
                            else
                            {
                                System.out.println("Failed to update the status");
                            }
                        }
                        else if( this.listOfClaimSet.getOne( id ) == null)
                        {
                            System.out.println( "\nThe claim doesn't exist");
                        }
                    }
                    else if( processChoice == 3 )
                    {
                        System.out.print( "\nEnter id of a claim: " );
                        String id;
                        Scanner scanner9 = new Scanner( System.in );
                        id = scanner9.nextLine();

                        if( this.listOfClaimSet.getOne( id ) != null )
                        {
                            this.listOfClaimSet.getOne( id ).getInsuredPerson().getaListOfClaims().deleteClaim( this.listOfClaimSet.getOne( id));
                            this.listOfClaimSet.deleteClaim( this.listOfClaimSet.getOne( id ) );
                            System.out.println( "\nDeleted successfully");
                        }
                        else
                        {
                            System.out.println( "The claim doesn't exist");
                        }
                    }
                    else
                    {
                        System.out.println( "\nInvalid choice! Please choose the valid choice( 0-3 )");
                    }

                }

            }
            else
            {
                System.out.println( "\nInvalid choice! Please choose the valid choice( 0-3 )");
            }
        }

    }
}
