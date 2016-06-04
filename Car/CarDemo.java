/**
 * This program tests the Car class.
 * @author Mike Martin
 */
public class CarDemo {
    public static void main(String[] args) 
    {
        // Create a Car object using a constructor method.
        Car mikesCar = new Car("Mazda", "3", "Mike", 2013);
                
        // Display information about Mike's car using access methods.
        System.out.println(mikesCar.getOwner() + "'s car is a " + mikesCar.getYear() + " " + 
                mikesCar.getMake() + " " + mikesCar.getModel() + ".");
        
        // Update information about Mike's car using mutator methods.
        mikesCar.setMake("Buggatti");
        mikesCar.setModel("Type 57SC Sports Tourer");
        mikesCar.setYear(1937);
        
        System.out.println(mikesCar.getOwner() + "'s car magically transformed into a " + mikesCar.getYear() + " " + 
        mikesCar.getMake() + " " + mikesCar.getModel() + ".");
    }    
}
