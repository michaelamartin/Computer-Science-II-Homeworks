import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.NumberFormat;

/**
 * The RetailPriceCalculator class lets the user enter a wholesale price
 * and percent markup.  When the calculate retail price button is selected
 * the program displays the retail price.
 */

public class RetailPriceCalculator extends JFrame
{
    private final int WINDOW_WIDTH = 300;
    private final int WINDOW_HEIGHT = 150;
    private JTextField wholesaleField;
    private JTextField markupField;
    private JLabel wholesaleLabel;
    private JLabel markupLabel;
    private JButton calcButton;
    
    /**
     * Constructor
     */
    
    public RetailPriceCalculator()
    {
    setTitle("Retail Price Calculator");
    setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    buildPanel();
    setVisible(true);
    }
    
    /**
     * The buildPanel method adds labels, text fields, and the calculate 
     * button to a panel
     */
    
    private void buildPanel()
    {
        // Createing labels, text fields, and button
        wholesaleLabel = new JLabel("Wholesale Price ($): ");
        markupLabel = new JLabel("Markup % : ");
        wholesaleField = new JTextField(10);
        markupField = new JTextField(10);
        calcButton = new JButton("Calculate retail price");
        
        // Applying a grid layout of 3 rows and 1 column
        setLayout(new GridLayout(3, 1));
        
        // Add action listener to button
        calcButton.addActionListener(new ButtonListener());
        
        // Create a panels and add the components
        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();
        JPanel panel3 = new JPanel();
        panel1.add(wholesaleLabel);
        panel1.add(wholesaleField);
        panel2.add(markupLabel);
        panel2.add(markupField);
        panel3.add(calcButton);
        
        // Add the panels to the content pane
        add(panel1);
        add(panel2);
        add(panel3);
    }
    
    /**
     * Private inner class that handles the button click event
     */
    
    private class ButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            String wholesalePrice;      // To hold user input for wholesale price
            String markupPercent;       // To hold user input for markup
            double result = 0.0;        // To hold resulting retail price

            // Get text field inputs
            wholesalePrice = wholesaleField.getText();
            markupPercent = markupField.getText();

            // Calculates retail price
            result = Double.parseDouble(wholesalePrice) + 
                    Double.parseDouble(wholesalePrice) * 
                    Double.parseDouble(markupPercent)/100;
            
            // Format to local currency
            NumberFormat formatter = NumberFormat.getCurrencyInstance();
            
            // Display the formatted retail price
            JOptionPane.showMessageDialog(null, "The retail price is " 
                    + formatter.format(result));
        }
    }
    
    /**
     * The main method creates an instance of the RetailPriceCalculator class, 
     * displaying its window
     */
    
    public static void main(String[] args) 
    {
        new RetailPriceCalculator();
    }
    
}
