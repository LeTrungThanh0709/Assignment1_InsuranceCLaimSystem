package ClaimProcessManagerInterface;


import ClaimClass.Claim;

public interface ClaimProcessManager
{
    public void addClaim( Claim claim );
    public boolean updateClaim( Claim claim, String newStatus );
    public boolean deleteClaim( Claim claim );
    public void getAll();
    public  Claim getOne( String id );
}