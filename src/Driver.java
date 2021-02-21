import java.net.URL;
import org.json.simple.JSONValue;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import java.util.Scanner;

public class Driver 
{

	public static void main(String[] args)
	{ 
		URLReader hearthstoneURLReader = new URLReader("https://api.hearthstonejson.com/v1/25770/enUS/cards.json");
		//System.out.println(hearthstoneURLReader.getTheURLContents());
		Object obj = JSONValue.parse(hearthstoneURLReader.getTheURLContents());
		HearthStoneCard[] theMinions = new HearthStoneCard[8000];
		
	    //System.out.println(obj instanceof JSONArray);
	    if(obj instanceof JSONArray)
	    {
	    	//I am only in here if obj IS a JSONArray
	    	JSONArray array = (JSONArray)obj;
	    	int count = 0;
	    	
		    for(int i = 0; i < array.size(); i++)
		    {
		    	JSONObject cardData = (JSONObject)array.get(i);
		    	if(cardData.containsKey("cost") && cardData.containsKey("name"))
		    	{
		    		if(cardData.containsKey("type") && cardData.get("type").equals("MINION"))
		    		{
		    			String name = String.valueOf(cardData.get("name"));
		    			String costS = String.valueOf(cardData.get("cost"));
		    			int cost = Integer.parseInt(costS);
		    			String attackS = String.valueOf(cardData.get("attack"));
		    			int attack = Integer.parseInt(attackS);
		    			String healthS = String.valueOf(cardData.get("health"));
		    			int health = Integer.parseInt(healthS);
		    			theMinions[i] = new HearthStoneCard(name, cost, attack, health);
		    			theMinions[i].display();
		    			count ++;
		    		

		    		}
		    		
		    	}
		    	
		    }
		    System.out.println(count);
	    }
	}
}