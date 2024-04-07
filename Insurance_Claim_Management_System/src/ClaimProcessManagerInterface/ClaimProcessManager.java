package ClaimProcessManagerInterface;

/**
 * @author <Le Trung Thanh - S3993494>
 */
import ClaimClass.Claim;
import java.util.Set;

public interface ClaimProcessManager
{
    public void addClaim( Claim claim );
    public boolean updateClaim( Claim claim, String newStatus );
    public boolean deleteClaim( Claim claim );
    public void getAll();
    public  Claim getOne( String id );
}
