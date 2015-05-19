import java.io.IOException;
import java.net.MalformedURLException;


public class testDriver 
{
	public static void main(String[] args) throws IOException
	{
		urlObject object = new urlObject("http://www.amazon.com/Finding-Rachel-Davenport-Michael-Harling/dp/1480116408/ref=tmm_pap_title_0");
		object.scrapeSite();
		urlObject object1 = new urlObject("http://www.amazon.com/Cuckoos-Calling-Robert-Galbraith/dp/0316206849/ref=sr_1_1_title_1_har?s=books&ie=UTF8&qid=1396249063&sr=1-1&keywords=jk+rowling");
		object1.scrapeSite();
		System.out.println("Yo");
	}
}
