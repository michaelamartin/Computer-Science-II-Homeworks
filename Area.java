/**
 * Chapter 8 Programming Challenge #1 - Area Class
 * @author Michael Martin
 */
import java.text.DecimalFormat;

public class Area {
    
    //Method calculates the area of a circle
    public static double getArea(double radius)
    {
        return Math.PI*radius*radius;
    }
    
    //Method calculates the area of a rectangle
    public static double getArea(int width, int length)
    {
        return width*length;
    }
    
    //Method calculates the area of a cylinder
    public static double getArea(double radius, double height)
    {
        return Math.PI*radius*radius*height;
    }
    
    public static void main (String[] args)
    {   
        //Formats doubles to display 2 decimal places
        DecimalFormat df = new DecimalFormat("0.00");
        
        //Area of a circle
        System.out.println("Area of a circle with a radius of 1.0: " 
                + df.format(Area.getArea(1.0)));
        
        //Area of a rectangle
        System.out.println("Area of a rectangle with a width of 10 and a "
                + "height of 5: " + df.format(Area.getArea(10, 5)));
        
        //Area of a cylinder
        System.out.println("Area of a cylinder with a radius of 10.0 and "
                + "height of 5.0: " + df.format(Area.getArea(10.0, 5.0)));
    }
}
