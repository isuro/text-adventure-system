public class Item
{
	String name;
	String shortName;
	String description;
	String shortDescription;
	String useEffect;
	Item [] usedWith;
	int id;

	public Item (String itemName, String itemShortName, String itemDescription,
	String itemShortDescription, String itemUseEffect, Item [] itemUsedWith,
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

}

