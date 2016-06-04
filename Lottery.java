/**
 * This program simulates a lottery.
 * @author Mike
 */

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Lottery 
{
    private int[] lotteryNumbers = new int[5];
    private int[] userNumbers = new int[5];
    
    public Lottery()
    {
        // Creates a Random object to generate random numbers
        Random rand = new Random();
        for (int i = 0; i < lotteryNumbers.length; i++)
        {
            //Random number upper limit set to 10
            lotteryNumbers[i] = rand.nextInt(10);
        }
        // User is asked to enter 5 lottery picks to populate userNumbers array
        for (int i = 0; i < userNumbers.length; i++)
        {
            int num;
            System.out.print("Enter lottery pick #" + (i+1) + ": ");
            Scanner sc = new Scanner(System.in);
            // Error handling for any input that is not an integer
            while (!sc.hasNextInt())
            {
                System.out.println("Error. Please enter a positive integer "
                        + "between 0 and 9 (inclusive).");
                sc.nextLine();
            }
            // Error handling for any integers less than 0 or greater than 10
            num = sc.nextInt();
            while (num < 0 || num > 10)
            {
                System.out.println("Error. Please enter a positive integer "
                    + "between 0 and 9 (inclusive).");
                num = sc.nextInt();
            }
            userNumbers[i] = num;
        }
        // Seperate input and output
        System.out.println("--------------------------------");
    }
    
    // This method returns lotteryNumbers as an int array
    public int[] getLotteryNumbers()
    {
        return lotteryNumbers;
    }
    
    public int[] getUserNumbers()
    {
        return userNumbers;
    }
    // This method returns the number of matching intigers between the randomly
    // generate lottery array and the user defined array
    public int getMatches(){
        int matches = 0;      
        for (int i = 0; i < userNumbers.length; i++)
        {
            if (userNumbers[i] == lotteryNumbers[i])
            {
                matches++;
            }
        }
        return matches;
    }
    
    public static void main(String[] args)
    {
        System.out.println("Lottery Application");
        System.out.println("-------------------");
        System.out.println("Enter five integers between 0 and 9 (inclusive) that represent lottery picks. The picks will be compared");
        System.out.println("to a randomly generated lottery number. The program will return the number of digits that match.\n");
        Lottery numbers = new Lottery();
        int matches = numbers.getMatches();
        System.out.println("Lottery numbers: " + 
            Arrays.toString(numbers.getLotteryNumbers()));
        System.out.println("User numbers:    " + 
            Arrays.toString(numbers.getUserNumbers()));
        System.out.println("Number of matches: " + 
            matches);
        // If all 5 integers match between the user picks and the randomly
        // generated lottery numbers, a message proclaiming the user a grand
        // prize winner appears.
        if (matches == 5)
        {
            System.out.println("Congratulations! You've won the grand prize!");
        }
    }
}