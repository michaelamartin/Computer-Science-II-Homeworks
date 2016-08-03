import javax.swing.JApplet;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 * Triangle Fractal
 * @author Mike Martin
 */

public class TriangleFractal extends JApplet {
    private JPanel submitPanel;
    private JPanel overallPanel;
    private JLabel orderLabel;
    private JTextField orderText;
    private FPanel fractalPanel;

    public void init() 
    {
        // Set applet frame size
        this.setSize(500, 500);
        
        // Set applet title
        Frame title = (Frame)this.getParent().getParent();
        title.setTitle("Sierpinski Triangle");

        // Panel instantiation
        overallPanel = new JPanel(new BorderLayout());
        fractalPanel = new FPanel();
        buildSubmitPanel();
        
        // Arrange Fractal Panel above Submit Panel using BorderLayout
        overallPanel.add(fractalPanel, BorderLayout.CENTER);
        overallPanel.add(submitPanel, BorderLayout.SOUTH);
        
        // Add overall panel to content pane
        this.add(overallPanel);
    }
    
    private void buildSubmitPanel()
    {
        
        // Create Submit panel
        submitPanel = new JPanel(new BorderLayout());
        JPanel labelPanel = new JPanel(new FlowLayout());
        JPanel textPanel = new JPanel(new FlowLayout());
        JPanel buttonPanel = new JPanel(new FlowLayout());
        
        // Create a text field
        orderText = new JTextField(5);
        
        // Create a label for the text field
        orderLabel = new JLabel("Define the recursion limit (max of 10):", SwingConstants.CENTER);
        
        // Create a button with text "Submit"
        JButton submitButton = new JButton("Submit");
        
        // Add action listener for the button
        submitButton.addActionListener(new ButtonListener());
        
        // Add button to the submit panel
        labelPanel.add(orderLabel);
        textPanel.add(orderText);
        buttonPanel.add(submitButton);
        submitPanel.add(labelPanel, BorderLayout.NORTH);
        submitPanel.add(textPanel, BorderLayout.CENTER);
        submitPanel.add(buttonPanel, BorderLayout.SOUTH);
        
    }
    
    /**
     *   Button listener refreshes fractal panel when textfield is changed and 
     *   submit button is clicked
     */
    
    private class ButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            int order = Integer.parseInt(orderText.getText());
            if (order > 0 && order <= 10)
            {
                fractalPanel.setOrder(order);
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Enter a positive integer less than or equal to 10.");
            }
        }   
    }
    
    /**
     *   This class creates a panel that contains the Sierpinski Triangle fractal.
     */
    
    private class FPanel extends JPanel 
    {
        private int order;  // determines number of recursions
        
        // This method allows the user to set the number of recursions and 
        // repaints the panel
        public void setOrder(int order)
        {
            this.order = order;
            repaint();
        }
        
        /**
         *   This method paints the panel.
         */
        
        @Override
        protected void paintComponent(Graphics g) 
        {  
            // Panel background color set to black
            setBackground(Color.BLACK);
            
            // Pen color set to white
            g.setColor(Color.white);
            super.paintComponent(g);
            
            // Triangles are painted based on panel size.
            // These points represent the top, bottom left, and bottom right 
            // points of the triangle being drawn.
            Point p1 = new Point(getWidth()/2, getWidth()/50);
            Point p2 = new Point(getWidth()/50, getHeight() - getHeight()/50);
            Point p3 = new Point(getWidth() - getWidth()/50, getHeight() - getHeight()/50);
            
            // The triangle is drawn using the displayTriangle method
            displayTriangles(g, order, p1, p2, p3);  
        }
       
        /**
         *   This method recursively calls itself to draw Sierpinski Triangles
         *   until the base case is reached.
         */
        
        private void displayTriangles(Graphics g, int order, Point p1, 
                Point p2, Point p3)
        {
            // Recursion base case
            if (order == 0)
            {
                g.drawLine(p1.x, p1.y, p2.x, p2.y);
                g.drawLine(p1.x, p1.y, p3.x, p3.y);
                g.drawLine(p2.x, p2.y, p3.x, p3.y);
            }
 
            else 
            {
                Point p12 = midpoint(p1, p2);
                Point p23 = midpoint(p2, p3);
                Point p13 = midpoint(p3, p1);
                
                displayTriangles(g, order - 1, p1, p12, p13);
                displayTriangles(g, order - 1, p12, p2, p23);
                displayTriangles(g, order - 1, p13, p23, p3);
            }
        }
        
        /**
         *   The midpoint method find the midpoint between two given points.
         */
       
        private Point midpoint(Point p1, Point p2)
        {
            return new Point((p1.x + p2.x)/2, (p1.y + p2.y)/2);
        }
    }
}