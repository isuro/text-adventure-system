/**
* A room is represented by its coordinates, a boolean array of exits,
* an ItemBag (if applicable), and a description.<br />
* Exits are ordered & referenced as follows: N=0 S=1 E=2 W=3 U=4 D=5.
*/
public class Room{

	private int xCoord;
	private int yCoord;
	private int zCoord;
	private boolean[] exits = new boolean[6]; //list of exits
	private ItemBag items = new ItemBag(); //list of items in the room
	private String description; //base description of room

	
	public Room(int x, int y, int z, String description)
	{
		this.xCoord = x;
		this.yCoord = y;
		this.zCoord = z;
		this.description = description;
	}

	public Room(int x, int y, int z, String description, boolean [] exits)
	{
		this.xCoord = x;
		this.yCoord = y;
		this.zCoord = z;
		this.description = description;
		this.exits = exits;
	}

	public Room(int x, int y, int z, String description, boolean nEx, boolean sEx, boolean eEx, boolean wEx, boolean upEx, boolean dnEx)
	{
		this.xCoord = x;
		this.yCoord = y;
		this.zCoord = z;
		this.description = description;
		this.exits[0] = nEx;
		this.exits[1] = sEx;
		this.exits[2] = eEx;
		this.exits[3] = wEx;
		this.exits[4] = upEx;
		this.exits[5] = dnEx;
	}

	public void setExits(boolean nEx, boolean sEx, boolean eEx, boolean wEx, boolean upEx, boolean dnEx)
	{
		this.exits[0] = nEx;
		this.exits[1] = sEx;
		this.exits[2] = eEx;
		this.exits[3] = wEx;
		this.exits[4] = upEx;
		this.exits[5] = dnEx;
	}

	public void setAnExit(boolean exit, int i)
	{
		this.exits[i] = exit;
	}

	public void setAItem(Item newItem)
	{
		if (items == null)
		{
			items = new ItemBag();
			items.addItem(newItem);
		}
		else
			items.addItem(newItem);
	}

	public int getXCoord()
	{
		return xCoord;
	}

	public int getYCoord()
	{
		return yCoord;
	}

	public int getZCoord()
	{
		return zCoord;
	}

	public String examine()
	{
		return description;
	} 

	public ItemBag getItems(){
		return this.items;
	}

	public boolean checkExit(int i)
	{
		return exits[i];
	}

	/**
	* Prints <code><i>x</i>, <i>y</i>, <i>z</i></code>.
	*/
	public String toString(){
		return xCoord + ", " + yCoord + ", " + zCoord;
	}


	public void printRoom()
	{
		System.out.println("Room located at: " + xCoord + ", " + yCoord + ", " + zCoord);
		System.out.println("Room description: " + description);
		System.out.println("Exits at: ");

		boolean exitsExist = false;
		if (exits[0] == true)
		{
			System.out.println("North");
			exitsExist = true;	
		}			
		if (exits[1] == true)
		{
			System.out.println("South");
			exitsExist = true;
		}
		if (exits[2] == true)
		{
			System.out.println("East");
			exitsExist = true;
		}
		if (exits[3] == true)
		{
			System.out.println("West");
			exitsExist = true;
		}
		if (exits[4] == true)
		{
			System.out.println("Up");
			exitsExist = true;
		}
		if (exits[5] == true)
		{
			System.out.println("Down");
			exitsExist = true;
		}
		if (exitsExist = false)
			System.out.println("No exits. You're trapped!");
		items.printRoomItems();
	}

}