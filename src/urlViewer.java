import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class urlViewer {

		private static JTextArea urlField;
		private static boolean fieldProtection = true;
		private static JMenu menu;
		private static JMenuBar bar;
		private static JMenuItem queues;
		private static JPanel blankPanel;
		private static JFrame queueFrame;
		
		
		public static void main(String[] args)
		{
			JFrame scrapeFrame = new JFrame();
		    JPanel frameContent = new JPanel(new GridLayout(3,2));
		    JPanel buttonPanel = new JPanel();
		    
		    /*
		    queueFrame = new JFrame();
			queueFrame.setSize(600, 200);
		    queueFrame.setTitle("UvrD Scraper - Queues");
		    queueFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			*/
		    
		    JButton runScrape = new JButton("Scrape");
		      runScrape.addActionListener( new ActionListener()
		      {
		          public void actionPerformed(ActionEvent e)
		          {
		        	if(urlField.getText().contains("amazon"))
		        	{
		        		amazonObject site = new amazonObject(urlField.getText());
		        		site.scrape();
		        	}else if(urlField.getText().contains("barnes"))
		        	{
		        		barnesObject site = new barnesObject(urlField.getText());
		        		site.scrape();
		        	} else{
		        		JOptionPane.showMessageDialog (null, "Enter a valid Amazon or Barnes & Noble web address.");
		        	}
		          }
		      });
		    
		    
		    /*
		    bar = new JMenuBar();
		    menu = new JMenu("File");
		    queues = new JMenuItem("Queues");
		    queues.addActionListener( new ActionListener()
		      {
		          public void actionPerformed(ActionEvent e)
		          {
		        	 //queueFrame.setVisible(true);
		        	  SimpleFileChooser chooser = new SimpleFileChooser();
		          } 
		      });
		          
		    bar.add(menu);
		    menu.add(queues);
		    */
		    
		    urlField = new JTextArea("Enter a url here...");
		    urlField.addMouseListener(new MouseAdapter() {
		    	public void mouseClicked(MouseEvent e) {
		    		if(fieldProtection)
		    		{
		    		urlField.setText("");
		    		fieldProtection = false;
		    		}
		    		}
		    		});
		    
		    
		    String[] sites = new String[] {"Amazon", "Barnes & Noble"};
		    //JComboBox<String> siteSelector = new JComboBox(sites);
		    frameContent.add(urlField);
		    buttonPanel.add(runScrape);
		    //buttonPanel.add(siteSelector);
		    /*
		    blankPanel = new JPanel();
		    blankPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		    blankPanel.add(bar);
		    */
		    //scrapeFrame.add(blankPanel, BorderLayout.NORTH);
		    scrapeFrame.add(frameContent, BorderLayout.CENTER);
		    scrapeFrame.add(buttonPanel, BorderLayout.SOUTH);
		    
		      
		    scrapeFrame.setSize(600, 200);
		    scrapeFrame.setTitle("UvrD Scraper");
		    scrapeFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		    scrapeFrame.setVisible(true);
		}
	
}
