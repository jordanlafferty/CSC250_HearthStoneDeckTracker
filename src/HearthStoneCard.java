
public class HearthStoneCard
{
	String name;
	 int cost;
	 int attack;
	int defense;

	
	public HearthStoneCard(String name, int cost, int attack, int defense)
	{
		this.cost = cost;
		this.attack = attack;
		this.defense = defense;
		this.name = name;
	}
	
	//setters allow us to conditionally change the value of a private member
	public void setName(String name)
	{
		if(name.length() >= 5)
		{
			this.name = name;
		}
	}
	
	public int getCost()
 	{
 		return this.cost;
 	}
	
	public int getAttack()
 	{
 		return this.attack;
 	}
	
	void display()
	{
		//System.out.println("Name: " + this.name + "\nCost" + this.cost + "\nAttack: " + this.attack + " Defense: " + this.defense);
		System.out.format("Name: %s \nCost: %d \nAttack: %d Defense: %d\n", this.name, this.cost, this.attack,this.defense);
	}
}
