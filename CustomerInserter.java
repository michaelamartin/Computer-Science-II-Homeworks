import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
  This program lets the user insert a row into the
  CoffeeDB database's Coffee table.
*/

public class CustomerInserter extends JFrame
{
    private JPanel fieldsPanel, buttonPanel, labelPanel;
    private JLabel instructions, customerNumberLabel, nameLabel, addressLabel, 
            cityLabel, stateLabel, zipLabel;
    private JTextField customerNumberField, nameField, addressField, 
            cityField, zipField;
    private JComboBox stateCB;
    // Populate combo box with states
    private final String [] states = {"AL", "AK", "AZ", "AR", "CA", "CO", 
            "CT", "DE", "FL", "GA", "HI", "ID", "IL", "IN", "IA", "KS", "KY", 
            "LA", "ME", "MD", "MA", "MI", "MN", "MS", "MO", "MT", "NE", "NV", 
            "NH", "NH", "NM", "NY", "NC", "ND", "OH", "OK", "OR", "PA", "RI", 
            "SC", "SD", "TN", "TX", "UT", "VT", "VA", "WA", "WV", "WI", "WY"};
    private JButton button;
    
    /*
        Constructor
    */
    
    public CustomerInserter()
    {
        // Set the title
        setTitle("Customer Inserter");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Build panels
        buildInstructionPanel();
        buildButtonPanel();
        buildFieldsPanel();

        // Add the panels to the content pane
        add(labelPanel, BorderLayout.NORTH);
        add(fieldsPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
        
        // Pack and display the window
        pack();
        setVisible(true);
    }
    
    private void buildInstructionPanel()
    {
        labelPanel = new JPanel();
        labelPanel.setBorder(BorderFactory.createTitledBorder("Instructions"));
        
        // Create label for instructions
        instructions = new JLabel("<html>Fill in the fields and click submit to"
         + " add a new row to the Customer table.</html>"); 
        
        labelPanel.add(instructions);
    }
    
    private void buildFieldsPanel()
    {
        fieldsPanel = new JPanel();
        fieldsPanel.setLayout(new GridLayout(6,1));
        fieldsPanel.setBorder(BorderFactory.createTitledBorder("Customer Information"));
        
        // Create text fields for name, address, and city
        customerNumberField = new JTextField(10);
        customerNumberLabel = new JLabel("Number"); 
        nameField = new JTextField(25);
        nameLabel = new JLabel("Name"); 
        addressField = new JTextField(25);
        addressLabel = new JLabel("Address"); 
        cityField = new JTextField(12);
        cityLabel = new JLabel("City"); 
        
        // Create combo box containing all 50 states
        stateCB = new JComboBox(states);
        stateLabel = new JLabel("State"); 
        
        // Create 5 character wide text field for zip code input
        zipField = new JTextField(5);
        zipLabel = new JLabel("Zip Code");
        
        JPanel customerNumberPanel;
        customerNumberPanel = new JPanel();
        buildSubPanel(customerNumberPanel, customerNumberLabel,customerNumberField);
        
        // Create a customer name subpanel
        JPanel namePanel;
        namePanel = new JPanel();
        buildSubPanel(namePanel, nameLabel, nameField);

        // Create a customer addrss subpanel 
        JPanel addressPanel;
        addressPanel = new JPanel();
        buildSubPanel(addressPanel, addressLabel, addressField);

        // Create a city subpanel 
        JPanel cityPanel;
        cityPanel = new JPanel();
        buildSubPanel(cityPanel, cityLabel, cityField);
        
        // Create a state subpanel 
        JPanel statePanel;
        statePanel = new JPanel();  
        buildSubPanel(statePanel, stateLabel, stateCB);

        // Create a zip code subpanel
        JPanel zipPanel;
        zipPanel = new JPanel();
        buildSubPanel(zipPanel, zipLabel, zipField);
        
        // Add all of the subpanels to the fields panel
        fieldsPanel.add(customerNumberPanel);
        fieldsPanel.add(namePanel);
        fieldsPanel.add(addressPanel);
        fieldsPanel.add(cityPanel);
        fieldsPanel.add(statePanel);
        fieldsPanel.add(zipPanel);
    }
    
    // Builds subpanel with 2 by 1 grid layout
    private void buildSubPanel(JPanel panel, JLabel label, JTextField textField)
    {
        panel.setLayout(new BorderLayout());
        panel.add(textField);
        label.setLabelFor(textField);
        panel.add(label, BorderLayout.NORTH);
    }
    
    // Overloaded method for combo boxes
    private void buildSubPanel(JPanel panel, JLabel label, JComboBox comboBox)
    {
        panel.setLayout(new BorderLayout());
        panel.add(comboBox);
        label.setLabelFor(comboBox);
        panel.add(label, BorderLayout.NORTH);
    }
    
    private void buildButtonPanel()
    {
        // Create a panel to button
        buttonPanel = new JPanel();
        button = new JButton("Submit");
        button.addActionListener(new ButtonListener());
        buttonPanel.add(button);
    }
    
    /*
        A private inner class that creates a CustomerInfo object with
        parameters matching the textfields and combo boxes
    */
    
    public class CustomerInfo
    {
        private String customerNumber, name, address, city, state, zip;
    }
    
    private class ButtonListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            // Creates a customerInfo object of type CustomerInfo
            CustomerInfo customerInfo = new CustomerInfo();
            
            // Sets the properties of updatedInfo to the input provided by the user
            customerInfo.customerNumber = customerNumberField.getText();
            customerInfo.name = nameField.getText();
            customerInfo.address = addressField.getText();
            customerInfo.city = cityField.getText();
            customerInfo.state = stateCB.getSelectedItem().toString();
            customerInfo.zip = zipField.getText();
            
            // Pass the customerInfo object to the insertCustomer method
            insertCustomer(customerInfo);            
        }
    }
    
    /*
        The insertCustomer method updates the DB with the provided CustomerInfo
        object
    */
    
    public void insertCustomer(CustomerInfo customerInfo)
    {
        try
        {
            final String DB_URL = "jdbc:derby:CoffeeDB";
            
            // Create a connection to the database.
            Connection conn = DriverManager.getConnection(DB_URL);

            // Create a Statement object.
            Statement stmt = conn.createStatement();
            
            // Create a string with an INSERT INTO statement
            String sqlStatement = "INSERT INTO CUSTOMER " +
            "VALUES ('" + customerInfo.customerNumber + "', '" + 
            customerInfo.name + "', '" + customerInfo.address + "', '" + 
            customerInfo.city + "', '" + customerInfo.state +
            "', '" + customerInfo.zip + "')";
            
            // Print the SQL statement to the output window
            System.out.println("SQL Statement: " + sqlStatement);
            
            // Send the statement to the DBMS.
            int rows = stmt.executeUpdate(sqlStatement);
            
            // Close the connection.
            conn.close();
            
            JOptionPane.showMessageDialog(null, "Successfully inserted row.");
        }
        
        // Print an error message if there is an exception
        catch(Exception ex)
        {
           System.out.println("ERROR: " + ex.getMessage());
        }
    }
    
    /*
        The main method creates an instance of the CustomerInserter class, 
        which causes it to display a window.
    */
    
    public static void main(String[] args)
    {    
        new CustomerInserter();
   }
}
