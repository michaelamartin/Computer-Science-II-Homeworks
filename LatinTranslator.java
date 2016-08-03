import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * The LatinTranslator class lets the user select one of three buttons (one
 * for each Latin word).  When the user clicks a button, the program displays
 * the English translation label.
 */

public class LatinTranslator extends JFrame 
{
    private final int WINDOW_WIDTH = 300;
    private final int WINDOW_HEIGHT = 150;
    JPanel panel1;
    JPanel panel2;
    JPanel panel3;
    JLabel titleLabel;
    JLabel englishLabel;
    JLabel translationLabel;
    JButton sinisterButton;
    JButton dexterButton;
    JButton mediumButton;
    
    /**
     * Constructor
     */
    
    public LatinTranslator() {
        setTitle("Latin to English Translator");
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT); 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);       
        setVisible(true);
        buildPanel();
    }

    /**
     * The buildPanel method adds labels, text fields, and buttons
     */
    
    private void buildPanel(){
        // Creating labels, text fields, and buttons
        panel1 = new JPanel();
        panel2 = new JPanel();
        panel3 = new JPanel();
        titleLabel = new JLabel("Latin to English Translator");
        translationLabel = new JLabel("English translation: ");
        englishLabel = new JLabel(""); 
        sinisterButton = new JButton("Sinister");
        dexterButton = new JButton("Dexter");
        mediumButton = new JButton("Medium");
        
        // Add action listeners to buttons
        sinisterButton.addActionListener(new SinisterListener());        
        dexterButton.addActionListener(new DexterListener());        
        mediumButton.addActionListener(new MediumListener());
        
        // Applying a grid layout of 3 rows and 1 column
        setLayout(new GridLayout(3, 1));
        
        // Create a panels and add the components
        panel1.add(titleLabel);
        panel2.add(sinisterButton);        
        panel2.add(dexterButton);
        panel2.add(mediumButton);
        panel3.add(translationLabel);
        panel3.add(englishLabel);
        
        // Add the panels to the content pane
        add(panel1);
        add(panel2);
        add(panel3);
    }
    
    /**
     * Private inner classes that handle specific button click events
     */
    
    private class SinisterListener implements ActionListener 
    {
        public void actionPerformed(ActionEvent e){
            englishLabel.setText("Left");
        }
    }
    
    private class DexterListener implements ActionListener 
    {
        public void actionPerformed(ActionEvent e){
            englishLabel.setText("Right");
        }
    }
    
    private class MediumListener implements ActionListener 
    {
        public void actionPerformed(ActionEvent e){
            englishLabel.setText("Center");
        }
    }
    
    /**
     * The main method creates an instance of the LatinTranslator class, 
     * displaying its window
     */
    
    public static void main(String[] args)
    {
    new LatinTranslator();
    }
}