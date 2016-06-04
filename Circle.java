/**
 * Algorithm Workbench #1 - Circle
 * @author - Michael Martin
 */
public class Circle 
{
    private double radius;
    
    //Constructor method requring radius parameter
    public Circle(double r)
    {
        radius = r;
    }
    
    //Returns the Circle object's area
    public double getArea()
    {
        return Math.PI * radius * radius;
    }
    
    //Returns a the Circle object's radius
    public double getRadius()
    {
        return radius;
    }
    
    //Returns a string indicating the object's radius and area
    public String toString()
    {
        String str = "Radius: " + radius +
                "\nArea: " + getArea() + "\n";
        
        return str;
    }
    
    //Compars 2 Circle objects to deterimine if they are equal
    public boolean equals(Circle object2)
    {
        return this.radius == object2.radius;
    }
    
    //Compares the area of 2 Circle objects; returns true if object 1 > object 2
    public boolean greaterThan(Circle object2)
    {
        return this.getArea() > object2.getArea();
    }
    
     public static void main(String[] args)
     {
        //Creating 3 circle objects, displaying their radius and area and
        //comparing them using an equals method.
        System.out.println("Circle 1");
        System.out.println("--------");
        Circle circle1 = new Circle(5);
        System.out.println(circle1.toString());
        
        System.out.println("Circle 2");
        System.out.println("--------");
        Circle circle2 = new Circle(5);
        System.out.println(circle2.toString());
        
        System.out.println("Circle 3");
        System.out.println("--------");
        Circle circle3 = new Circle(6);
        System.out.println(circle3.toString());
        
        //Comparing the 3 circle objects' data using the equals method
        System.out.println("The data of Circle 1 is equal to Circle 2: "
                + circle1.equals(circle2));
        System.out.println("The data of Circle 1 is equal to Circle 3: "
                + circle1.equals(circle3));
        System.out.println("The data of Circle 2 is equal to Circle 3: "
                + circle2.equals(circle3) + "\n");
        
        //Comparing the three circles' areas using the greaterThan method
        System.out.println("The area of Circle 1 is greater than Circle 2: "
                + circle1.greaterThan(circle2));
        System.out.println("The area of Circle 1 is greater than Circle 3: "
                + circle1.greaterThan(circle3));
        System.out.println("The area of Circle 2 is greater than Circle 1: "
                + circle2.greaterThan(circle1));
        System.out.println("The area of Circle 2 is greater than Circle 3: "
                + circle2.greaterThan(circle3));
        System.out.println("The area of Circle 3 is greater than Circle 1: "
                + circle3.greaterThan(circle1));
        System.out.println("The area of Circle 3 is greater than Circle 2: "
                + circle3.greaterThan(circle2));
     }
}