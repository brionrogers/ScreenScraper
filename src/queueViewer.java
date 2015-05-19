import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class queueViewer {
	
	public static void main(String[] args)
	{
		JFrame queueFrame = new JFrame();
		queueFrame.setSize(300, 200);
	    queueFrame.setTitle("UvrD Scraper");
	    queueFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    
	    JPanel panel = new JPanel();
	    JLabel label = new JLabel("Please wait while the URL is scraped.....");
	    panel.add(label);
	    queueFrame.add(panel);
	    
	    queueFrame.setVisible(true);
	    
	    
	}

}
