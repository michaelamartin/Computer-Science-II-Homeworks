import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

/**
  This program lets the user insert a row into the
  CoffeeDB database's Coffee table.
*/

public class CustomerUpdater extends JFrame
{
    private JPanel fieldsPanel, buttonPanel, labelPanel;
    private JLabel instructions, customerNumberLabel, nameLabel, addressLabel, 
            cityLabel, stateLabel, zipLabel;
    private JTextField customerNumberField, addressField, 
            cityField, zipField;
    private JComboBox nameCB, stateCB; 
    // Populate combo box with states
    private final String [] states = {"AL", "AK", "AZ", "AR", "CA", "CO", 
            "CT", "DE", "FL", "GA", "HI", "ID", "IL", "IN", "IA", "KS", "KY", 
            "LA", "ME", "MD", "MA", "MI", "MN", "MS", "MO", "MT", "NE", "NV", 
            "NH", "NH", "NM", "NY", "NC", "ND", "OH", "OK", "OR", "PA", "RI", 
            "SC", "SD", "TN", "TX", "UT", "VT", "VA", "WA", "WV", "WI", "WY"};
    private JButton button;
    private CustomerInfo customerInfos[];
    
    /*
        Constructor
    */
    
    public CustomerUpdater()
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
    
    /*
        The buildInstructionPanel builds a panel containing the instructions
        for the program.
    */
    
    private void buildInstructionPanel()
    {
        labelPanel = new JPanel();
        labelPanel.setBorder(BorderFactory.createTitledBorder("Instructions"));
        
        // Create label for instructions
        instructions = new JLabel("Fill in the fields and click submit to"
         + " update the selected customer's information in the Customer table."); 
        
        labelPanel.add(instructions);
    }

    /*
        The buildFieldsPanel builds a panel containing the all
        of the fields, combo boxes, and their respective labels.
    */
    
    private void buildFieldsPanel()
    {
        fieldsPanel = new JPanel();
        fieldsPanel.setLayout(new GridLayout(6,1));
        fieldsPanel.setBorder(BorderFactory.createTitledBorder("Customer Information"));
        
        // Create text fields for name, address, and city
        customerNumberField = new JTextField(10);
        customerNumberLabel = new JLabel("Number");
        customerNumberField.setEditable(false);
        addressField = new JTextField(25);
        addressLabel = new JLabel("Address"); 
        cityField = new JTextField(12);
        cityLabel = new JLabel("City"); 
        
        // Create combo box containing all 50 states
        nameCB = new JComboBox(CustomerNamesToArray());
        nameLabel = new JLabel("Name");
        
        // Action listener for change in combo box selection
        // Shows correct customer number in customer number text field when
        // a customer name is selected
        ActionListener CBActionListener = new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                int selected = nameCB.getSelectedIndex();
                customerNumberField.setText(customerInfos[selected].customerNumber);
                addressField.setText(customerInfos[selected].address.trim());
                cityField.setText(customerInfos[selected].city.trim());
                stateCB.setSelectedItem(customerInfos[selected].state.trim());
                zipField.setText(customerInfos[selected].zip.trim());
                
            }
        };
        
        nameCB.addActionListener(CBActionListener);
        
        // Create a combo box populated by the states array
        stateCB = new JComboBox(states);
        stateLabel = new JLabel("State"); 
        
        // Create 5 character wide text field for zip code input
        zipField = new JTextField(5);
        zipLabel = new JLabel("Zip Code");
        
        // Create a customer number subpanel
        JPanel customerNumberPanel;
        customerNumberPanel = new JPanel();
        buildSubPanel(customerNumberPanel, customerNumberLabel,customerNumberField);
        
        // Create a customer name subpanel
        JPanel namePanel;
        namePanel = new JPanel();
        buildSubPanel(namePanel, nameLabel, nameCB);

        // Create a customer address subpanel
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
    
    /*
        The buildSubPanel method builds a subpanel with a border layout
    */

    private void buildSubPanel(JPanel panel, JLabel label, JTextField textField)
    {
        panel.setLayout(new BorderLayout());
        panel.add(textField);
        label.setLabelFor(textField);
        panel.add(label, BorderLayout.NORTH);
    }
    
    /*
        An overloaded version of the buildSubPanel for combo boxes
    */

    private void buildSubPanel(JPanel panel, JLabel label, JComboBox comboBox)
    {
        panel.setLayout(new BorderLayout());
        panel.add(comboBox);
        label.setLabelFor(comboBox);
        panel.add(label, BorderLayout.NORTH);
    }

    /*
        The buildButtionPanel method builds a panel containing the submit
        button
    */
    
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

    private class CustomerInfo
    {
        private String customerNumber, name, address, city, state, zip;              
    }
    
    /*
        A private inner class that handles the event that is generated when the
        submit button is clicked
    */

    private class ButtonListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            // Get the index of the name selected in the combo box
            int selected = nameCB.getSelectedIndex();
            
            // Use the selected index to find the corresponding customer number
            customerNumberField.setText(customerInfos[selected].customerNumber);
            
            // Creates a updatedInfo object of type CustomerInfo
            CustomerInfo updatedInfo = new CustomerInfo();
            
            // Sets the properties of updatedInfo to the input provided by the user
            updatedInfo.customerNumber = customerNumberField.getText();
            updatedInfo.name = nameCB.getSelectedItem().toString();
            updatedInfo.address = addressField.getText();
            updatedInfo.city = cityField.getText();
            updatedInfo.state = stateCB.getSelectedItem().toString();
            updatedInfo.zip = zipField.getText();
            
            // Pass the updatedInfo object to the updateCustomer method
            updateCustomer(updatedInfo);            
        }
    }

    /*
        The CustomerNamesToArray method creates an array of the available 
        customer names queried from the DB
    */
    
    private String[] CustomerNamesToArray()
    {
        setCustomerInfos();
        
        String[] CustomerNames = new String[customerInfos.length];
        
        for (int i = 0; i < customerInfos.length; i++)
        {
            CustomerNames[i] = (customerInfos[i].name.trim());
        }
        return CustomerNames;
    }

    /*
        The setCustomerInfos method queries all of the rows in the DB and stores
        customer information into the customerInfos array
    */
    
    private void setCustomerInfos()
    {
        try
        {
            final String DB_URL = "jdbc:derby:CoffeeDB";
            
            // Create a connection to the database.
            Connection conn = DriverManager.getConnection(DB_URL);

            // Create a Statement object.
            Statement stmt = conn.createStatement();
            
            ArrayList<CustomerInfo> customerInfosArrayList = new ArrayList<>();
            
            ResultSet rs = stmt.executeQuery("SELECT * FROM CUSTOMER");
            while (rs.next())
            {
                CustomerInfo customerInfo = new CustomerInfo();
                
                String number = rs.getString("CUSTOMERNUMBER");
                customerInfo.customerNumber = number;
                
                String name = rs.getString("NAME");
                customerInfo.name = name;

                String address = rs.getString("ADDRESS");
                customerInfo.address = address;
                        
                String city = rs.getString("CITY");
                customerInfo.city = city;
                
                String state = rs.getString("STATE");
                customerInfo.state = state;
                
                String zip = rs.getString("ZIP");
                customerInfo.zip = zip;
                
                customerInfosArrayList.add(customerInfo);
            }
        
            // Close the connection.
            conn.close();
            
            // Convert array list to regular array and return result
            customerInfos = customerInfosArrayList.toArray(new CustomerInfo[customerInfosArrayList.size()]);
        }
        catch(Exception ex)
        {
            System.out.println("ERROR: " + ex.getMessage());
        }
    }

    /*
        The updateInfos method updates the DB with the provided CustomerInfo
        object
    */
    
    public void updateCustomer(CustomerInfo updatedInfo)
    {
        try
        {
            final String DB_URL = "jdbc:derby:CoffeeDB";
            
            // Create a connection to the database.
            Connection conn = DriverManager.getConnection(DB_URL);

            // Create a Statement object.
            Statement stmt = conn.createStatement();
            
            // Create a string with an UPDATE statement
            String sqlStatement = "UPDATE CUSTOMER " +
            "SET NAME = '" + updatedInfo.name + "', ADDRESS = '" + updatedInfo.address + 
            "', CITY = '" + updatedInfo.city + "', STATE = '" + updatedInfo.state +
            "', ZIP = '" + updatedInfo.zip + "' " +
            "WHERE Name = '" + updatedInfo.name + "'";
            
            // Print the SQL statement to the output window
            System.out.println("SQL Statement: " + sqlStatement);
            
            // Send the statement to the DBMS.
            int rows = stmt.executeUpdate(sqlStatement);
            
            // Close the connection.
            conn.close();
            
            JOptionPane.showMessageDialog(null, "Successfully updated row.");
            
            // Query the DB to update cached customer information array
            setCustomerInfos();
        }
        
        // Print an error message if there is an exception
        catch(Exception ex)
        {
           System.out.println("ERROR: " + ex.getMessage());
        }
    }
    
    /*
        The main method creates an instance of the CustomerUpdater class, 
        which causes it to display a window.
    */
    
    public static void main(String[] args)
    {    
        new CustomerUpdater();
    }
}
