import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Chapter 14, Exercise 1 - FollowMe Applet
 * @author Mike Martin
 */

public class FollowMe extends JApplet 
{
    // Hello is initially positioned at the center of the window
    private int currentX = 110;
    private int currentY = 100;

    /**
     * init method
     */
    
    public void init()
    {
        // Set size of applet window to 300 by 200 pixels
        this.setSize(300, 200);
        
        // Add a mouse listner and a mouse motion listner
        addMouseListener(new MyMouseListener());
        addMouseMotionListener(new MyMouseMotionListener());
        this.add(new PaintContainer());
    }
    
    /**
     * PaintContainer class
     * @param g The applet's Graphics object
     */
      
    private class PaintContainer extends JPanel 
    {
        protected void paintComponent(Graphics g) {  
            
        // Draw a Hello
        g.setFont(new Font("SansSerif", Font.BOLD, 35));
        g.drawString("Hello", currentX, currentY);
        }
    }
    
    /**
     * Mouse listener class
     */
    
    private class MyMouseListener implements MouseListener
    {
        
        //
        // The following methods are unused, but still required by the
        // MouseListener interface.
        //
        
        public void mouseClicked(MouseEvent e){}
        public void mouseReleased(MouseEvent e){}
        public void mouseEntered(MouseEvent e){}
        public void mouseExited(MouseEvent e)
        {
            currentX = 110;
            currentY = 100;
            repaint();
        }
        public void mousePressed(MouseEvent e){}
        }
    
     /**
      * Mouse Motion listener class
      */
    
    private class MyMouseMotionListener implements MouseMotionListener
    {
        public void mouseDragged(MouseEvent e){}
        public void mouseMoved(MouseEvent e)
        {
            // Get the current mouse curosr coordinates
            currentX = e.getX();
            currentY = e.getY();
            
            // Repaint the window
            repaint();
        }  
    }
}
