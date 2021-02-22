import java.util.ArrayList;
import java.util.Collections;

import org.json.simple.JSONArray;
 import org.json.simple.JSONObject;
 import org.json.simple.JSONValue;

 public class CardParser 
 {
 	private String urlString;
 	private ArrayList<HearthStoneCard> theMinions;
 	private ArrayList<HearthStoneCard> Sorted;

 	public CardParser(String urlString)
 	{
 		//initial fields
 		this.urlString = urlString;
 		theMinions = new ArrayList<HearthStoneCard>();

 		URLReader hearthstoneURLReader = new URLReader(this.urlString);
 		Object obj = JSONValue.parse(hearthstoneURLReader.getTheURLContents());

 	    if(obj instanceof JSONArray)
 	    {
 	    	//I am only in here if obj IS a JSONArray
 	    	JSONArray array = (JSONArray)obj;

 		    for(int i = 0; i < array.size(); i++)
 		    {
 		    	JSONObject cardData = (JSONObject)array.get(i);
 		    	if(cardData.containsKey("cost") && cardData.containsKey("name"))
 		    	{
 		    		if(cardData.containsKey("type") && cardData.get("type").equals("MINION"))
 		    		{
 		    			//I am only here is this is a minion card!!!
 		    			//System.out.println(cardData.keySet().toString());
 		    			String name = (String)cardData.get("name");
 		    			int cost = Integer.parseInt(cardData.get("cost").toString());
 		    			int attack = Integer.parseInt(cardData.get("attack").toString());
 		    			int health = Integer.parseInt(cardData.get("health").toString());
 		    			HearthStoneCard temp = new HearthStoneCard(name, cost, attack, health);
 		    			theMinions.add(temp);
 		    		}
 		    	}

 		    }
 	    }
 	}

 	public void showMinions()
 	{
 		for(int i = 0; i < this.theMinions.size(); i++)
 		{
 			this.theMinions.get(i).display();
 		}
 	}

 	public void sortLowestCostToHighestCost()
 	{
 		Sorted = new ArrayList<HearthStoneCard>();
 		int x = 0;
 		
 		for(int i = 0; i < this.theMinions.size(); i++)
 		{
 			
 			for(int j = 0; j < this.theMinions.size(); j++)
 			{
 				int cost = this.theMinions.get(j).getCost();
 				if (cost == x)
 	 			{
 					
 	 				Sorted.add(this.theMinions.get(j));
 	 				this.theMinions.remove(j);
 	 				
 	 		     }

 			}
 			x++;
 	    }

 		
 		for(int i = 0; i < this.Sorted.size(); i++)
 		{
 			this.Sorted.get(i).display();
 		}


 	}
 	
 	
 	
 }
