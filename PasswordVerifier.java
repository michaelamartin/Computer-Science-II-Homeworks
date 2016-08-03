
import javax.swing.JOptionPane;

/**
 * Chapter 9 - Program Challenge 5: Password Verifier
 * @author Michael Martin
 * This program requires the user to enter their own password.  The program then
 * verifies the password and displays a message indicating whether it is valid
 * or not.
 */

public class PasswordVerifier 
{ 
    public static void Verify (String password) 
    {
        boolean valid = true;   // Set password as valid by default
        int lowercase = 0;
        int uppercase = 0;
        int digit = 0;
        if (password.length() < 6)
        {
            valid = false;
        }
        else
        {
            // This loop cycles through all of the characters in the given 
            // string and tallies the number of lowercase, uppercase, and digit
            // characters
            for (int i = 0; i < password.length(); i++)
            {
                if (Character.isLowerCase(password.charAt(i)))
                    lowercase++;
                if (Character.isUpperCase(password.charAt(i)))
                    uppercase++;
                if (Character.isDigit(password.charAt(i)))
                    digit++;
            }
            
            // Checks wheter password meets minimum requirements of 1 lowercase, 
            //1 uppercase, and 1 digit character
            if (lowercase < 1 || uppercase < 1 || digit < 1)
            {
                valid = false;
            }          
        }
        if (valid)
        {
            // Display the results of a valid password entry
            JOptionPane.showMessageDialog(null, "Success, the password "
                    + "is valid.");
        }
        else
        {
             // Display the results  of an invalid password entry
            JOptionPane.showMessageDialog(null, "Invalid password.");
        }
    }
    
    public static void main(String[] args) 
    {     
        // The program requires the user to enter a password
        String input = JOptionPane.showInputDialog("Enter a password: ");
        // The password is verified by the Verify class
        Verify(input);
        System.exit(0);
    }   
}
