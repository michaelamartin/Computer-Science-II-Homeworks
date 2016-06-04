/**
 * Programming Challenges Exercise 5 - Month Class
 * @author Michael Martin
 */
public class Month {

    private int monthNumber;
    private String [] monthNames = {"January", "February", "March", "April", "May", 
        "June", "July", "August", "September", "October", "November", 
        "December" };
    
    public Month ()
    {
        monthNumber = 1;
    }
    
    public Month (int m)
    {
        monthNumber = m;
        if (monthNumber < 1 || monthNumber > 12)
        {
            monthNumber = 1;
        }
    }
    
    public Month (String m)
    {
        for (int i=0; i<monthNames.length; i++)
        {
            if (monthNames[i].toLowerCase().equals(m.toLowerCase()))
            {
                monthNumber = i + 1;
            }
        }
    }
    
    public int getMonth()
    {
        return monthNumber;
    }
    
    public String getMonthName()
    {
        return monthNames[monthNumber - 1];
    }
    
    public String toString()
    {
        return getMonthName();
    }
    
    public boolean equals(Month object2)
    {
        return this.monthNumber == object2.monthNumber;
    }
    
    public static void main(String[] args) {
        Month test1 = new Month();
        Month test2 = new Month(2);
        Month test3 = new Month("February");
        System.out.println("Test 1: "+ test1.toString());
        System.out.println("Test 2: " + test2.toString());
        System.out.println("Test 3: " + test3.getMonthName());
        System.out.println("Test 1 equals Test 2: " + test1.equals(test2));
        System.out.println("Test 2 equals Test 3: " + test2.equals(test3));
    }
    
}
