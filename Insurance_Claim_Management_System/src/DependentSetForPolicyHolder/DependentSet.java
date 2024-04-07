package DependentSetForPolicyHolder;


import DependentClass.Dependent;

import java.util.HashSet;
import java.util.Set;

public class DependentSet
{
    // Attribute
    private Set<Dependent> listOfDependent;



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
