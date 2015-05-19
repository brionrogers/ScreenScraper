import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.swing.JOptionPane;

import au.com.bytecode.opencsv.CSVWriter;


public class amazonObject 
{
	static URL url;
	static String urlString;
	static String rank;
	static String title;
	static String author;
	static String price;
	static ArrayList<String> urlStringList;
	static InputStream urlStream = null;
	static BufferedReader br;
	static String line;
	//static List<String[]> entry;
	static urlObject object;
	static File output;
	static BufferedWriter writer;
	static FileWriter fwriter;
	static CSVWriter csvwriter;

	public amazonObject(String webURL)
	{
		urlString = webURL;
	}
  
	public void scrape()
	{
		try {
			
	        amazonObject.url = new URL(urlString);
	        urlStream = url.openStream();  // throws an IOException
	        br = new BufferedReader(new InputStreamReader(urlStream));
	        csvwriter = new CSVWriter(new FileWriter("results.csv"), ',');
	        
	        urlObject object = new urlObject(url);
	       
	        while ((line = br.readLine()) != null) 
	        {
	        	
	            if(line.contains("in Books"))
	            {
	            	rank = "";
	            	int i = line.indexOf(' ');
	            	rank=line.substring(0,i);
	            	rank=rank.substring(1, rank.length());
	            	object.setRank(rank);
	            	
	            	//writer.write('"'+rank+'"'+",");
	            	System.out.println("#########");
	            }
	            
	            else if (line.contains("<meta name="+'"'+"description"))
	            {
	            	System.out.println(line);
	            	int i = line.lastIndexOf("content="+'"');
	            	i = i +9;
	            	author=line.substring(i, line.length());
	            	System.out.println(author);
	            	//Copy out the book title
	            	i = author.indexOf("[");
	            	i = i - 1;
	            	title = author.substring(0,i);
	            	//writer.write('"'+title+'"'+",");
	            	
	            	System.out.println(title);
	            	
	            	i = author.indexOf("[");
	            	i = i + 1;
	            	int n = author.indexOf("]");
	            	author=author.substring(i,n);
	            	System.out.println(author);
	            	object.setAuthor(author);
	            	//writer.write('"'+author+'"'+",");
	            }
	        } 
	        System.out.println(object.toString());
	        
	    } catch (MalformedURLException mue) {
	         mue.printStackTrace();
	    } catch (IOException ioe) {
	    	JOptionPane.showMessageDialog(null,"UvrD Scrape cannot recognize that web address. Please confirm the address and try again.");
	    } catch (StringIndexOutOfBoundsException e) {
	    	if (line.contains("<meta name="+'"'+"description"))
	        {
	    		//Copy out the author
	        	int i = line.lastIndexOf("Kindle edition by");
	        	i = i +18;
	        	author=line.substring(i, line.length());
	        	int n = author.indexOf(".");
	        	author=author.substring(0, n);
	        	System.out.println("Finally:"+author);
	        	//writer.write('"'+author+'"'+",");
	        	
	        	//Copy out the book title
	        	i = line.indexOf("content="+'"');
	        	i = i + 9;
	        	n = line.indexOf("- Kindle edition by");
	        	title = line.substring(i,n);
	        	System.out.println("Finally:"+title);
	        	//writer.write(title);
	        	//writer.write('"'+title+'"'+",");
	        } 
	    } finally {
	        try {
	        	 while ((line = br.readLine()) != null) 
	             {
	            	 if(line.contains("in Kindle Store"))
		            {
		             	rank = "";
		             	int i = line.indexOf(' ');
		             	rank=line.substring(0,i);
		             	rank=rank.substring(1, rank.length());
		             	System.out.println("Finally:"+rank);
		             	//writer.write('"'+rank+'"'+"\n");
		             	//object.setRank(rank);
		             	System.out.println("#########");
		             }
	            }
	        	 
	        	 List<String[]> data = new ArrayList<String[]>();
	        	 System.out.println(title);
	        	 System.out.println(author);
	        	 System.out.println(rank);
	        	 data.add(new String[] {title});
	        	 data.add(new String[] {author});
	        	 data.add(new String[] {rank});
	        	  
	        	 csvwriter.writeAll(data);
	        	 csvwriter.close();
	        	  
	 	 
	        }catch (MalformedURLException mu) {
	                mu.printStackTrace();
	            } catch (IOException io) {
	                 io.printStackTrace();
	            } catch (StringIndexOutOfBoundsException k) {
	            	k.printStackTrace();
	            }
	        }
	}
	public String toString()
	{
		return "Client Info: "+this.getTitle()+", "+this.getAuthor()+", "+", "+this.getRank();
	}
	
	public String getTimeStamp()
	{
		String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
		return timeStamp;
	}
	
	public URL getUrl() {
		return url;
	}
	public void setUrl(URL url) {
		urlObject.url = url;
	}
	public String getRank() {
		return rank;
	}
	public void setRank(String rank) {
		urlObject.rank = rank;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		urlObject.price = price;
	}
	public InputStream getUrlStream() {
		return urlStream;
	}
	public void setUrlStream(InputStream urlStream) {
		urlObject.urlStream = urlStream;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String t1)
	{
		title = t1;
	}
	
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		urlObject.author = author;
	}

	
	
}
