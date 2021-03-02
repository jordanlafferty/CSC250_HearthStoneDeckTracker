import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

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

 	
 	
 	public void binarySearch()
 	{
 		Sorted = new ArrayList<HearthStoneCard>();
 		

 		
 		
 		sortAttack();
 		Scanner input = new Scanner(System.in);
		System.out.println("Enter attack: ");
		String num  = input.nextLine();
		int attack = Integer.parseInt(num);
		
		
		
		
		int size = this.theMinions.size()/2;
		int attackCard = this.theMinions.get(size).getAttack();
		
		for (int i = 2; i < this.theMinions.size()+2; i++)
		{
			attackCard = this.theMinions.get(size).getAttack();
			
			if (attack == attackCard)
			{
				i = 2000;
				Sorted.add(this.theMinions.get(size));
				int attackf = this.theMinions.get(size+1).getAttack();
				int attackb = this.theMinions.get(size-1).getAttack();
				
				// if there are more cards with the same attack forward
				if (attack == attackf)
				{	
					
					
					for (int x = 0; x < 962; x++ )
					{
						
						size ++;
						int attackPlus = this.theMinions.get(size).getAttack();
						if (attack == attackPlus)
						{
							Sorted.add(this.theMinions.get(size));
							
						}
					}
				}
				
				// if there are more cards with the same attack backward
				if (attack == attackb)
				{	
					size = this.theMinions.size()/2;
					
					for (int x=0; x < 962; x++ )
					{
						
						size --;
						int attackMinus = this.theMinions.get(size).getAttack();
						if (attack == attackMinus)
						{
							Sorted.add(this.theMinions.get(size));
							
						}
					}
				}
				
				
			
				
			
			}
			
			if (attack < attackCard)
			{
				
				int intResult = (int) Math.pow(2, i);
				int divide = this.theMinions.size()/intResult;
				size = size + divide;
				
				
				
			}
			
			if (attack > attackCard)
			{
				int intResult = (int) Math.pow(2, i);
				int divide = this.theMinions.size()/intResult;
				size = size - divide;
				
				
				
			}
			
			
			
		}
		
		for(int i = 0; i < this.Sorted.size(); i++)
 		{
 			this.Sorted.get(i).display();
 		}
 		
		
		
		

 	}
 	
 	public void sortAttack()
 	{
 		HearthStoneCard temp;
 		
 		for(int i = 0; i < this.theMinions.size()-1; i++)
 		{
 			int minIndex = i;
 			
 			for(int j = i+1; j < this.theMinions.size(); j++)
 			{
 				
 				if (this.theMinions.get(j).getAttack() > this.theMinions.get(minIndex).getAttack())
 				{
 					minIndex= j;
 						
 				}
 				
	 			
 			}
 			temp = this.theMinions.get(minIndex);
 			this.theMinions.set(minIndex, this.theMinions.get(i));
 			this.theMinions.set(i, temp);
 		}
 	}

 	public void insertionSortLowestToHighestCost()
 	{
 		//this is a simpler way to sort
 		
 		for(int currStart = 1; currStart < this.theMinions.size(); currStart++)
 		{
 			//try to move the value at currStart as far up the array as possible
 			// then move on to next currStart 
 			int currIndex = currStart;
 			HearthStoneCard temp;
 			while(currIndex > 0 && this.theMinions.get(currIndex).getCost() < 
 					this.theMinions.get(currIndex-1).getCost())
 			{
 				//we swap the 2 places
 				temp = this.theMinions.get(currIndex);
 				this.theMinions.set(currIndex, this.theMinions.get(currIndex-1));
 				this.theMinions.set(currIndex-1,  temp);
 				currIndex--;
 			}
 			
 			
 		}
 	}
 	
 	public void selectionSortHighestToLowestCost()
 	{
 		HearthStoneCard temp;
 		
 		for(int i = 0; i < this.theMinions.size()-1; i++)
 		{
 			int minIndex = i;
 			
 			for(int j = i+1; j < this.theMinions.size(); j++)
 			{
 				
 				if (this.theMinions.get(j).getCost() > this.theMinions.get(minIndex).getCost())
 				{
 					minIndex= j;
 						
 				}
 				
	 			
 			}
 			temp = this.theMinions.get(minIndex);
 			this.theMinions.set(minIndex, this.theMinions.get(i));
 			this.theMinions.set(i,  temp);
 		}
 		
 	}
 	
 	
 	
 	
 	
 	public void sortLowestCostToHighestCost()
 	{
 		ArrayList<HearthStoneCard> theSortedList = new ArrayList<HearthStoneCard>();
 		HearthStoneCard nextSmallest;
 		while(this.theMinions.size()>0)
 		{
 			nextSmallest = this.findSmallest();
 			theSortedList.add(nextSmallest);
 		}
 		//this is making var theMinions point to the same place
 		// as theSortedList in Memory
 		
 		this.theMinions =theSortedList;
 		
 		// Other way to accomplish this 
 		
 		/*Sorted = new ArrayList<HearthStoneCard>();
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
	*/

 	}
 	
 	
 	
 	private HearthStoneCard findSmallest()
 	{
 		//go through Minions and add & remove cards
 		HearthStoneCard currWinner = this.theMinions.get(0);
 		int indexOfWinner = 0;
 		
 		for(int i = 0; i < this.theMinions.size(); i++)
 		{
 			if (this.theMinions.get(i).getCost()< currWinner.getCost())
 			{
 				currWinner = this.theMinions.get(i);
 				indexOfWinner = i;
 				
 			}
 		}
 		//the card with the smallest cost should be in currWinner
 		//the position of the card with the smallest cost should be in indexOfWinner
 		this.theMinions.remove(indexOfWinner);
 		return currWinner;
 	}
 	
 	
 	
 }
