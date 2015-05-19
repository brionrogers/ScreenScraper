import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class urlObject 
{
	static URL url;
	static String rank;
	static String title;
	static String author;
	static String price;
	static ArrayList<String> urlStringList;
	static InputStream urlStream = null;
	static BufferedReader br;
	static String line;
	static String[] lineArray;
	static urlObject object;
	static File output;
	static PrintWriter writer;

	public urlObject(URL webURL)
	{
		url = webURL;
	}
	public static void main(String[] args) throws FileNotFoundException
	{
		writer = new PrintWriter("output.txt");
	try {
        url = new URL("http://www.amazon.com/Threads-West-American-Lance-Rosenthal/dp/B0044DF1R6/ref=tmm_kin_swatch_0?_encoding=UTF8&sr=8-1&qid=1396363907");
        urlStream = url.openStream();  // throws an IOException
        br = new BufferedReader(new InputStreamReader(urlStream));
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
            	writer.print(rank+", ");
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
            	writer.print(title+", ");
            	
            	System.out.println(title);
            	
            	i = author.indexOf("[");
            	i = i + 1;
            	int n = author.indexOf("]");
            	author=author.substring(i,n);
            	System.out.println(author);
            	object.setAuthor(author);
            	writer.print(author+", ");
            }
        } 
        System.out.println(object.toString());
        
    } catch (MalformedURLException mue) {
         mue.printStackTrace();
    } catch (IOException ioe) {
         ioe.printStackTrace();
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
   
        	//Copy out the book title
        	i = line.indexOf("content="+'"');
        	i = i + 9;
        	n = line.indexOf("- Kindle edition by");
        	title = line.substring(i,n);
        	System.out.println("Finally:"+title);
        	writer.println(title);
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
	             	writer.println(rank);
	             	//object.setRank(rank);
	             	System.out.println("#########");
	             }
            }
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
