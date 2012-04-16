public class Item
{
	private String name;
	private String shortName;
	private String description;
	private String shortDescription;
	private String useEffect;
	private Item[] usedWith;
	private int id;
	private boolean canTalk;
	private String[][] dialogue;

	public Item (String itemName, String itemShortName, String itemDescription, String itemShortDescription, String itemUseEffect, Item[] itemUsedWith, int itemID, boolean itemCanTalk, String[][] itemDialogue)
	{
		name = itemName;
		shortName = itemShortName;
		description =  itemDescription;
		shortDescription = itemShortDescription;
		useEffect = itemUseEffect;
		usedWith = itemUsedWith;
		id = itemID;
		canTalk = itemCanTalk;
		dialogue = itemDialogue;
	}

	public Item (String data)
	{
		
	}

	public String getName ()
	{
		return name;
	}

	public String getShortName ()
	{
		return shortName;
	}

	public String getDescription()
	{
		return description;
	}

	public String getShortDescription()
	{
		return shortDescription;
	}

	public String getUseEffect()
	{
		return useEffect;
	}

	public int getID()
	{
		return id;
	}

	public boolean getCanTalk()
	{
		return canTalk;
	}

	public String[][] getDialogue(int x, int y)
	{
		return dialogue;
	}

	public void setName (String n)
	{
		name = n;
	}

	public void setShortName (String sN)
	{
		shortName = sN;
	}

	public void setDescription (String d)
	{
		description = d;
	}

	public void setShortDescription (String sD)
	{
		shortDescription = sD;
	}

	public void setUseEffect (String u)
	{
		useEffect = u;
	}

	public void setInInventory (int i)
	{
		id = i;
	}

	public void setDialogue(String[][] d)
	{
		dialogue = d;
		canTalk = true;
	}

	public void talk()
	{

	}

	public String toString(){
		return this.name;
	}

}
