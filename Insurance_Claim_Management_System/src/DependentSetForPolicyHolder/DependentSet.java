package DependentSetForPolicyHolder;


/**
 * @author <Le Trung Thanh - S3993494>
 */
import java.util.Set;
import java.util.HashSet;
import java.util.Iterator;
import DependentClass.Dependent;

public class DependentSet
{
    // Attribute
    private Set <Dependent> listOfDependent;



    // default constructor
    public DependentSet()
    {
        this.listOfDependent = new HashSet<Dependent>();
    }



    // constructor with a parameter
    public DependentSet( Set<Dependent> listOfDependent )
    {
        this.listOfDependent = new HashSet<Dependent>();
        this.listOfDependent.addAll( listOfDependent );
    }



    // define a method to get listOfDependent
    public Set <Dependent> getListOfDependent()
    {
        return this.listOfDependent;
    }



    // define a method to add a dependent
    public boolean addDependent( Dependent dependent )
    {
        // check whether or not the dependent is already in the list
        Iterator <Dependent> iterator = this.listOfDependent.iterator();
        while ( iterator.hasNext() )
        {
            if ( iterator.next().equals( dependent ) )
            {
                // the dependent is already in the list
                return false;
            }
        }

        // the dependent hasn't been in the list yet
        // add the dependent into the list
        this.listOfDependent.add( dependent );
        return true;

    }


}
