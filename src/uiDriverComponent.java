import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.io.IOException;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import java.util.Random;
/*
   A component that draws two rectangles.
*/
public class uiDriverComponent extends JComponent
{  
	
	public static JFrame mainFrame = new JFrame();
	public static JPanel subPanel = new JPanel();
	
	public static void main(String[] args) throws IOException
	{
		prepareGUI();
		
	}
	
   public void paintComponent(Graphics g)
   {  
	   //prepareGUI();
	   
      // Recover Graphics2D
      Graphics2D g2 = (Graphics2D) g;
      
      /*
      Random r = new Random();
      // Construct a rectangle and draw it
      Rectangle box = new Rectangle(150, 150, 20, 30);
		g2.draw(box);
		for(int i = 0; i < 500; i++)
		{
		  int x =  r.nextInt(500);
		  int y = r.nextInt(500);

		  box.setLocation(x, y);
		  g2.draw(box);
		}
     */
    }
   
   private static void prepareGUI() throws IOException
   {
	   mainFrame = new JFrame("Java Swing Examples");
	   mainFrame.setSize(800,900);
	   mainFrame.setLayout(new GridLayout(3, 1));
	  JTextArea area = new JTextArea(30, 70);
	   
	   JPanel mainPanel = new JPanel();
	   mainPanel.add(area);
	   
	   mainFrame.add(mainPanel);
	   buildObjectInput();
	   mainFrame.add(subPanel);
	   mainFrame.setVisible(true);
	   
	   urlObject object = new urlObject("http://www.amazon.com/Finding-Rachel-Davenport-Michael-Harling/dp/1480116408/ref=tmm_pap_title_0");
	   object.scrapeSite();
		
		area.append(object.getAuthor());
   }
   
   public static void buildObjectInput()
   {
	   JLabel webUrl = new JLabel("Web Address");
	   JTextField webBox = new JTextField("Enter url", 10);
	   
	   subPanel.add(webUrl);
	   subPanel.add(webBox);
	   
   }
}
