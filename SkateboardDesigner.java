import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;
import javax.swing.*;
import javax.swing.event.*;

/**
 * Chapter 13, Exercise 4 - Skateboard Designer
 * @author Mike Martin
 */

// Creating a shop item object that contains item name and pricing information
class ShopItem 
{
    private final String name;
    private final double price;
    public final static DecimalFormat fmt = new DecimalFormat("#0.00");  // Format price to US dollar
    public ShopItem(String name, double price) 
    {
        this.name = name;
        this.price = price;
    }
    
    @Override
    // Returns a string containing the item name and formated price
    public String toString() { return name + " $" + fmt.format(price); }
    
    // Returns the item name
    public String getName() { return name; }
    
    // Returns the item price
    public double getPrice() { return price; }    
}

public class SkateboardDesigner extends JFrame
{
    private final JLabel subTotal, salesTax, orderTotal;
    // The cart array holds decks, trucks, and wheels.  Miscellanious items 
    // are handled by a list since the number of items may vary.
    private final ShopItem[] cart = new ShopItem[3];    
    private final java.util.List<ShopItem> misc;
    
    /**
     * Constructor
     */
    
    public SkateboardDesigner()
    {                  
        this.subTotal = new JLabel();
        this.salesTax = new JLabel();
        this.orderTotal = new JLabel();
        
        setLayout(new GridLayout(3, 1));
        
        // Populating the Deck Panel
        JPanel deckPanel = getCbPanel(
            0,
            "Decks",
            new ShopItem [] {
                new ShopItem("The Dictator",  45),
                new ShopItem("The Street King", 50),
                new ShopItem("The Master Thrasher", 60)
        });   
        
        // Populating the Truck Panel
        JPanel truckPanel = getCbPanel(
            1,
            "Trucks",
            new ShopItem [] {
                new ShopItem("7.75 inch axle", 35),
                new ShopItem("8 inch axle",  40),
                new ShopItem("8.5 inch axle", 45)
        });   
        
        // Populating the Wheel Panel        
        JPanel wheelPanel = getCbPanel(
        2,
        "Wheels",
        new ShopItem [] {
            new ShopItem("51 mm", 20),
            new ShopItem("55 mm", 22),
            new ShopItem("58 mm", 24),
            new ShopItem("61 mm", 28)
        });   
        
        // Populating the Miscellaneous Panel
        this.misc = new java.util.ArrayList<ShopItem>();
        JPanel miscPanel = getListPanel(misc, "Misc", 
        new ShopItem [] {
            new ShopItem("Riser pads", 2),
            new ShopItem("Nuts & bolts kit", 3),
            new ShopItem("Grip tape", 10),
            new ShopItem("Bearings", 30)
        });
        
        // Populating the Total Panel
        JPanel totalPanel = new JPanel();
        totalPanel.setBorder(BorderFactory.createTitledBorder("Total"));
        totalPanel.setLayout(new GridLayout(3,1));
        totalPanel.add(subTotal);
        totalPanel.add(salesTax);
        totalPanel.add(orderTotal);
        
        // Setting the Deck Panel and Truck Panel in-line
        JPanel panel1 = new JPanel();
        panel1.setLayout(new GridLayout(1,2));
        panel1.add(deckPanel);
        panel1.add(truckPanel);
        
        // Setting the Wheel Panel and the Miscellaneous Panel in-line
        JPanel panel2 = new JPanel();
        panel2.setLayout(new GridLayout(1,2));
        panel2.add(wheelPanel);
        panel2.add(miscPanel);
      
        // Adding the panels to the content pane
        add(panel1);
        add(panel2);
        add(totalPanel);
        
        // Setting the title
        setTitle("Skate Shop");
        
        // Specifiying the action for the close button
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        // Setting the size and display
        setSize(600, 350);
        setVisible(true);
    }
    
    public static void main(String[] args)
    {
        new SkateboardDesigner();
    }
    
    // This method returns a combobox
    private JPanel getCbPanel(int index, String name, ShopItem[] items)
    {
        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createTitledBorder(name));
        final JComboBox<ShopItem> cb = new JComboBox<>(items);
        cb.addActionListener(new ActionListener()
        {
           public void actionPerformed(ActionEvent e)
           {
               // adds the selected item to the cart array
               cart[index] = (ShopItem)cb.getSelectedItem();
               updateTotal();
           } 
        });
        panel.add(cb);
        return panel;
    }
    
    // This method returns a panel with a scrolling multiple interval selection list pane
    private JPanel getListPanel(java.util.List<ShopItem> selected, String name, ShopItem[] items)
    {
        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createTitledBorder(name));
        final JList<ShopItem> list = new JList<>(items);
        list.setVisibleRowCount(4);
        list.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        list.addListSelectionListener(new ListSelectionListener(){
            public void valueChanged(ListSelectionEvent e)
            {
                selected.clear();
                for(ShopItem item : list.getSelectedValuesList())
                {
                    selected.add(item);
                }
                updateTotal();
            }
        });
        panel.add(new JScrollPane(list));
        return panel;
    }
    
    // This method returns the subtotal
    private double getSubTotal()
    {
        double subTot = 0;
        for (ShopItem item : cart)
        {
            // Error handling null item values
            subTot += (item==null) ? 0 : item.getPrice();
        }
        for(ShopItem item : misc) { subTot += item.getPrice(); }
        return subTot;
    }
    
    // This method updates the subtotal, tax, and total
    private void updateTotal()
    {
        double subtotal = getSubTotal();
        double tax = subtotal * 0.06;
        subTotal.setText("Subtotal: $" + ShopItem.fmt.format(subtotal));
        salesTax.setText("Tax: $" + ShopItem.fmt.format(tax));
        orderTotal.setText("Total: $" + ShopItem.fmt.format(subtotal + tax));
    }
}
