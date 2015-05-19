import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import javax.swing.JComponent;
import java.util.Random;
/*
   A component that draws two rectangles.
*/
public class RectangleComponent extends JComponent
{  
   public void paintComponent(Graphics g)
   {  
      // Recover Graphics2D
      Graphics2D g2 = (Graphics2D) g;
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
    }
}
