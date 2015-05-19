import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import au.com.bytecode.opencsv.CSVWriter;


public class barnesObject 
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

	public barnesObject(String address)
	{
		urlString = address;
	}
	public static void main(String[] args) throws IOException
	{
		csvwriter = new CSVWriter(new FileWriter("barnesresults.csv"), ',');
    }
  
	public void scrape()
	{
		try {
			barnesObject.url = new URL(urlString);
	        urlStream = url.openStream();  // throws an IOException
	        br = new BufferedReader(new InputStreamReader(urlStream));
	        urlObject object = new urlObject(url);
	       
	        while ((line = br.readLine()) != null) 
	        {
	        	
	            if(line.contains('"'+"title"+'"'+":"))
	            {
	            	title = "";
	            	int i = line.indexOf(":");
	            	i=i+2;
	            	title=line.substring(i,line.length());
	            	//System.out.println(title);
	            	title = title.substring(1,title.length()-2);
	            	
	            	//System.out.println(title);
	            	object.setTitle(title);
	            }
	            
	            else if (line.contains("<meta name="+'"'+"keywords"+'"'))
	            {
	            	int i = line.indexOf("content="+'"');
	            	i = i +9;
	            	author=line.substring(i, line.length());
	            	//Copy out the book title
	            	i = author.indexOf(",");
	            	author = author.substring(0,i);
	            	
	            	object.setAuthor(author);
	            	//System.out.println("Author: "+author);
	            } 
	            else if (line.contains('"'+"salesRank"+'"'+" :"))
	            {	
	            	//System.out.println(line);
	            	rank = "";
	            	int i = line.indexOf(": ");
	            	i=i+2;
	            	rank = line.substring(i, line.length());
	            	i = rank.indexOf(",");
	            	rank = rank.substring(0, i);
	            	//System.out.println(rank);
	            	object.setRank(rank);
	            }
	        } 
	        System.out.println(object.toString());
	        
	    } catch (MalformedURLException mue) {
	         mue.printStackTrace();
	    } catch (IOException ioe) {
	         ioe.printStackTrace();
	    } catch (StringIndexOutOfBoundsException e) {

	    } finally {
	        try {
	        	
	        	 List<String[]> data = new ArrayList<String[]>();
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
	public static String getUrlString() {
		return urlString;
	}
	public static void setUrlString(String urlString) {
		barnesObject.urlString = urlString;
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
