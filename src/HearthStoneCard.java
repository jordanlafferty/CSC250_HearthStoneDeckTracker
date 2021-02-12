
public class HearthStoneCard
{
	int cost;
	int attack;
	int defense;
	String name;
	
	public HearthStoneCard(String name, int cost, int attack, int defense)
	{
		this.cost = cost;
		this.attack = attack;
		this.defense = defense;
		this.name = name;
	}
	void display()
	{
		System.out.println( "Name: " + this.name + "\nCost: " + this.cost + "\n Attack:" + this.attack + "\nDefense: " + this.defense);
		System.out.format("Name: %s\n Cost: %d \nAttack: %d\n Defense: %d\n", this.name, this.cost, this.attack, this.defense);
	}

}
