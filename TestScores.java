/**
 * Chapter 11 Programming Challenge 1 - TestScores Class
 * @author Mike Martin
 */
public class TestScores 
{

    /**
     * @param args the command line arguments
     */ 
    private final double[] testScores;
    
    /**
     * Constructor
     * @param array 
     * @throws IllegalArgumentException
     */
    public TestScores(double[] array) throws IllegalArgumentException
    {
        if (array.length > 100)
            throw new IllegalArgumentException();
        
        for (double i : array)
        {
            if (i < 0)
                throw new IllegalArgumentException();
        }
        
        testScores = new double[array.length];
        System.arraycopy(array, 0, testScores, 0, array.length);
    }
    
    /**
     * Average Score Method
     * @return - average test score
     */
    public double AverageScore(){
        double sum = 0.0;
        for (double i : testScores)
        {
            sum += i;
        }
        return (sum/testScores.length);
    }
    
   /**
    * @throws IllegalArgumentException
    */
    public static void main(String[] args) {
        
        // Test arrays
        double[] arr1 = new double[100];    // Valid argument
        double[] arr2 = new double[101];    // Throws IllegalArgumentException
        double[] arr3 = {1, 2, 3};          // Valid argument
        double[] arr4 = {-1, 0, 1};         // Throws IllegalArgumentException
        
        // Change argument to arr1, arr2, arr3, or arr4 to test
        TestScores demo = new TestScores(arr3);
        System.out.println(demo.AverageScore());
    }    
}