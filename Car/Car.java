/**
 * This program demonstrates the Car class's
 * setMake, setModel, getYear, getMake, getMake, and getYear methods.
 * @author Mike Martin
 */

public class Car {
    private String make;
    private String model;
    private String owner;
    private int year;
    
    // Constructor method
    public Car(String ma, String mo, String o, int y)
    {
        make = ma;
        model = mo;
        owner = o;
        year = y;
    }
    
    // Mutator method to set owner
    public void setOwner(String o)
    {
        owner = o;
    }
    
    // Mutator method to set make
    public void setMake(String m)
    {
        make = m;
    }
    
    // Mutator method to set model
    public void setModel(String m)
    {
        model = m;
    }
    
    // Mutator method to set year
    public void setYear(int y)
    {
        year = y;
    }
    
    // Accessor method to get make
    public String getMake()
    {
        return make;
    }
    
    // Accessor method to get model
    public String getModel()
    {
        return model;
    }
    
    // Accessor method to get owner
    public String getOwner()
    {
        return owner;
    }
    
    // Accessor method to get year
    public int getYear()
    {
        return year;
    }
}
