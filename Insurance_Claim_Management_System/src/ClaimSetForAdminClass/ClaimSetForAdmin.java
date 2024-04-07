package ClaimSetForAdminClass;


import ClaimClass.Claim;
import ClaimProcessManagerInterface.ClaimProcessManager;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class ClaimSetForAdmin implements ClaimProcessManager {
    // Attribute
    private Set<Claim> listOfClaim;


    // default constructor
    public ClaimSetForAdmin() {
        this.listOfClaim = new HashSet<Claim>();
    }


    // parameterized constructor
    public ClaimSetForAdmin(Set<Claim> listOfClaim) {
        this.listOfClaim = new HashSet<Claim>();
        this.listOfClaim.addAll(listOfClaim);
    }
    // define a method to add a claim
    public void addClaim( Claim claim )
    {
        this.listOfClaim.add( claim );
    }



    // define a method to update claim
    public boolean updateClaim( Claim claim, String newStatus )
    {
        Iterator<Claim> iterator = this.listOfClaim.iterator();
        while ( iterator.hasNext() )
        {
            if( iterator.next().equal( claim ) )
            {
                return claim.updateStatus( newStatus );
            }
        }

        return false;
    }



    // define a method to delete a claim
    public boolean deleteClaim(Claim claim)
    {
        return this.listOfClaim.remove( claim );
    }



    // define a method to get all claims
    public void getAll()
    {
        ArrayList<Claim> claimArrayList = new ArrayList<>( this.listOfClaim );
        // sorted in order of claim date
        for( int i = 0; i < claimArrayList.size(); i ++ )
        {
            for ( int j = i + 1; j < claimArrayList.size(); j ++ )
            {
                if(  claimArrayList.get( i ).getClaimDate().getTime() > claimArrayList.get( j ).getClaimDate().getTime()  )
                {
                    Claim temp = new Claim();
                    temp = claimArrayList.get( i );
                    claimArrayList.set( i, claimArrayList.get( j ) );
                    claimArrayList.set( j, temp );
                }
            }
        }

        for ( Claim claim : claimArrayList )
        {
            claim.printAClaim();
        }
    }






    // define a method to get a claim
    public Claim getOne( String id )
    {
        for ( Claim claim : this.listOfClaim )
        {
            if ( claim.getId().equals( id ) )
            {
                return claim;
            }
        }

        return null;

    }


    public Set<Claim> getListOfClaim() {
        return listOfClaim;
    }
}
