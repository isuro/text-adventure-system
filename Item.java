public class Item
{
	private String name;
	private String shortName;
	private String description;
	private String shortDescription;
	private String useEffect;
	private String [] usedWith;
	private int idX;
	private int idY;
	private int idZ;
	private int inventoryID;
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
    * @param itemIDX				item's x-coordinate location.
    * @param itemIDY				item's y-coordinate location.
    * @param itemIDZ				item's z-coordinate location.
    * @param itemCanTalk 			boolean.
    * @param itemDialogue 			a 2D string array for dialogue.
    */
	public Item (String itemName, String itemShortName, String itemDescription, String itemShortDescription, String itemUseEffect, 
				 String [] itemUsedWith, int itemIDX, int itemIDY, int itemIDZ, boolean itemCanTalk, String[][] itemDialogue)
	{
		name = itemName;
		shortName = itemShortName;
		description =  itemDescription;
		shortDescription = itemShortDescription;
		useEffect = itemUseEffect;
		usedWith = itemUsedWith;
		idX = itemIDX;
		idY = itemIDY;
		idZ = itemIDZ;
		canTalk = itemCanTalk;
		dialogue = itemDialogue;
	}

    /**
    * Creates an Item, faster.
    *
    * @param itemName 				the item's full name.
    * @param itemIDX				item's x-coordinate location.
    * @param itemIDY				item's y-coordinate location.
    * @param itemIDZ				item's z-coordinate location.
    * @param itemDescription 		the item's full description.
    * @param itemUseEffect 			the effect of using the item.
    * @param itemUsedWith 			a string array of things the item can be used with.
    */
	public Item (String itemName, int itemIDX, int itemIDY, int itemIDZ, String itemDescription, String itemUseEffect, String [] itemUsedWith)
	{
		name = itemName;
		idX = itemIDX;
		idY = itemIDY;
		idZ = itemIDZ;
		description =  itemDescription;
		useEffect = itemUseEffect;
		usedWith = itemUsedWith;
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
	* @return the item's x-coordinate ID.
	*/
	public int getIDX()
	{
		return idX;
	}

	/**
	* @return the item's y-coordinate ID.
	*/
	public int getIDY()
	{
		return idY;
	}

	/**
	* @return the item's z-coordinate ID.
	*/
	public int getIDZ()
	{
		return idZ;
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
	* @param x      the desired x-coordinate location for the item
	*/
	public void setItemIDX(int x)
	{
		idX = x;
	}

	/**
	* @param y      the desired y-coordinate location for the item
	*/
	public void setItemIDY(int y)
	{
		idY = y;
	}

	/**
	* @param z      the desired z-coordinate location for the item
	*/
	public void setItemIDZ(int z)
	{
		idZ = z;
	}
	
	/**
	* @param i 		the desired short name for the item
	*/
	public void setInInventory (int i)
	{
		inventoryID = i;
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
