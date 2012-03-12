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

	public Item (String itemName, String itemShortName, String itemDescription,
	String itemShortDescription, String itemUseEffect, Item[] itemUsedWith,
	int itemID)
	{
		this.name = itemName;
		this.shortName = itemShortName;
		this.description =  itemDescription;
		this.shortDescription = itemShortDescription;
		this.useEffect = itemUseEffect;
		this.usedWith = itemUsedWith;
		this.id = itemID;
	}

	public Item getItem (Item i)
	{
		return i;
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

	public String[][] getDialogue(int x, int y){
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

}

