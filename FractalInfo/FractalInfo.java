import java.awt.*;
import javax.swing.*;

/**
 * FractalInfo - displays a fractal image and provide the definition of a fractal
 * @author Mike Martin
 */

public class FractalInfo extends JFrame 
{
    private JPanel imagePanel;
    private JLabel imageLabel;

    /**
     * Constructor
     */    
    
    public FractalInfo()
    {
        // Set the title
        setTitle("Fractal Information");
        
        // Specify an action for the close button
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Create a grid layout manager
        setLayout(new GridLayout(1, 1));
        
        // Build the panel
        buildImagePanel();
        
        // Add the panel to the content pane
        add(imagePanel);
        setVisible(true);
             
        // Pack the frame
        pack();
    }
 
    /**
     * The buildImagePanel method adds the image and its label to a panel.
     * @param args 
     */
    
    private void buildImagePanel()
    {
        imagePanel = new JPanel();
        
        // Display fractal definition 
        imageLabel = new JLabel("<html><center>A fractal is a natural "
                + "phenomenon or a mathematical set that exhibits a repeating "
                + "pattern that displays at every scale. <br> It is also known "
                + "as expanding symmetry or evolving symmetry. In theory fractals are infinitely recursive.</center></html>");
        
        // Set fractal image icon relative to project location
        ImageIcon fractalImage = new ImageIcon(this.getClass().getResource("/FractalFlower.jpeg"));
        imageLabel.setIcon(fractalImage);
        imageLabel.setVerticalTextPosition(JLabel.BOTTOM);
        imageLabel.setHorizontalTextPosition(JLabel.CENTER);
        imagePanel.add(imageLabel);
    }
    
    /**
     * The main method creates an instance of the FractalInfo class and
     * displays it to a window.
     * @param args 
     */
    
    public static void main(String[] args)
    {
        new FractalInfo();
    }
}
