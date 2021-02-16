import java.net.URL;
import java.util.Scanner;

 public class Driver 
 {

 	public static void main(String[] args)
 	{ 
 		HearthStoneCard c1 = new HearthStoneCard("Armor Vendor", 1, 1, 3);
 		HearthStoneCard c2 = new HearthStoneCard("Wandmaker", 2, 2, 2);
 		c1.display();
 		c2.display();

 		c1.setName("woot");
 		c1.display();


 		String cardJson = Driver.getJSON("https://api.hearthstonejson.com/v1/25770/enUS/cards.json");
 		System.out.println(cardJson);
 		//Let's make a json parser

 		//name = input("Enter your name:")
 		//Scanner input = new Scanner(System.in);
 		//System.out.print("Enter your age:");
 		//String age = input.nextLine(); //reads the next String from the keyboard in this case
 		//System.out.println(Integer.parseInt(age) + 2);
 		//int age = input.nextInt();
 		//System.out.println(age + 2);

 	}

 	//open a URL and read its contents as a String
 	static String getJSON(String urlString)
 	{	    
 		String line = "";
 		try
 		{
 			URL url = new URL(urlString);
 		    Scanner input = new Scanner(url.openStream());
 		    // open the url stream, wrap it an a few "readers"
 		    //BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));

 		    //keep reading from the scanner as long as their is something to read
 		    while (input.hasNext())
 		    {
 		    	line += input.nextLine();
 		    }

 		    // close our reader
 		    input.close();

 		    //reader.close();
 		}
 	    catch(Exception e)
 		{
 	    	e.printStackTrace();
 	    	line = "Can't Connect";
 		}
 		return line;
 	}
 }
