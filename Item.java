public class Item
{
	private String name;
	private String shortName;
	private String description;
	private String shortDescription;
	private String useEffect;
	private String [] usedWith;
	private int id;
	private boolean canTalk;
	private String[][] dialogue;

    /**
    * Creates an Item, all at once.
    *
    * @param itemName 				the item's full name.
    * @param itemShortName			the item's short name.
    * @param itemDescription 		the item's full description.
    * @param itemShortDescription	the item's short description.
    * @param itemUseEffect 			the effect of using the item.
    * @param itemUsedWith 			a string array of things the item can be used with.
    * @param itemID					an int ID number.
    * @param itemCanTalk 			boolean.
    * @param itemDialogue 			a 2D string array for dialogue.
    */
	public Item (String itemName, String itemShortName, String itemDescription, String itemShortDescription, String itemUseEffect, String [] itemUsedWith, int itemID, boolean itemCanTalk, String[][] itemDialogue)
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

    /**
    * Creates an Item, faster.
    *
    * @param itemName 				the item's full name.
    * @param itemDescription 		the item's full description.
    * @param itemUseEffect 			the effect of using the item.
    * @param itemUsedWith 			a string array of things the item can be used with.
    */
	public Item (String itemName, String itemDescription, String itemUseEffect, String [] itemUsedWith)
	{
		name = itemName;
		description =  itemDescription;
		useEffect = itemUseEffect;
		usedWith = itemUsedWith;
	}

	public Item (String data)
	{
		
	}

	/**
	* @return name 		the item's name.
	*/
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
