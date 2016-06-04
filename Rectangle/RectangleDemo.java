/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * This program demonstrates the Rectangle class's
 * setLength, setWidth, getLength, getWidth, and getArea methods.
 * @author Mike
 */
public class RectangleDemo 
{
    public static void main(String[] args) 
    {
        // Create a Rectangle object.
        Rectangle box = new Rectangle(5.0, 5.0);
        
        // Display the length.
        System.out.println("The box's length is " + box.getLength());
        
        // Display the length.
        System.out.println("The box's width is " + box.getWidth());
        
        // Display the area.
        System.out.println("The box's area is " + box.getArea());
        
        // set length to 10.0 and width to 20.0.
        System.out.println("------------------------");
        box.setLength(10.0);
        box.setWidth(10.0);
        
        // Display the length.
        System.out.println("The box's length is " + box.getLength());
        
        // Display the length.
        System.out.println("The box's width is " + box.getWidth());
        
        // Display the area.
        System.out.println("The box's area is " + box.getArea());
    }
    
}
