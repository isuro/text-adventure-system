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
	* @return the item's full name.
	*/
	public String getName ()
	{
		return name;
	}

	/**
	* @return the item's short name.
	*/
	public String getShortName ()
	{
		return shortName;
	}
	
	/**
	* @return the item's full description.
	*/
	public String getDescription()
	{
		return description;
	}
	
	/**
	* @return the item's short description.
	*/
	public String getShortDescription()
	{
		return shortDescription;
	}
	
	/**
	* @return the item's use effect.
	*/
	public String getUseEffect()
	{
		return useEffect;
	}
	
	/**
	* @return the item's ID.
	*/
	public int getID()
	{
		return id;
	}
	
	/**
	* @return the item's ability to talk.
	*/
	public boolean getCanTalk()
	{
		return canTalk;
	}
	
	/**
	* @return the item's dialogue.
	*/
	public String[][] getDialogue(int x, int y)
	{
		return dialogue;
	}
	
	/**
	* @param n 		the full desired name for the item
	*/
	public void setName (String n)
	{
		name = n;
	}
	
	/**
	* @param sN 	the desired short name for the item
	*/
	public void setShortName (String sN)
	{
		shortName = sN;
	}
	
	/**
	* @param d 		the desired full description for the item
	*/
	public void setDescription (String d)
	{
		description = d;
	}
	
	/**
	* @param sD 	the desired short description for the item
	*/
	public void setShortDescription (String sD)
	{
		shortDescription = sD;
	}
	
	/**
	* @param u  	the desired use effect for the item
	*/
	public void setUseEffect (String u)
	{
		useEffect = u;
	}
	
	/**
	* @param i 		the desired short name for the item
	*/
	public void setInInventory (int i)
	{
		id = i;
	}
	
	/**
	* Sets dialogue. Also sets canTalk to true.
	*
	* @param d  	the dialogue array for the item
	*/
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
