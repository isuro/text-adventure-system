import java.util.Vector;

public class Room{

	private int xCoord;
	private int yCoord;
	private int zCoord;
	private boolean[] exits = new boolean[6]; //list of exits
	private Vector items; //resizable list of items in the room
	private String description; //base description of room

	
	public Room(int x, int y, int z, String description)
	{
		this.xCoord = x;
		this.yCoord = y;
		this.zCoord = z;
		this.description = description;
	}

	public void setExits(boolean northExit, boolean southExit, boolean eastExit, boolean westExit, boolean upExit, boolean downExit)
	{
		this.exits[0] = northExit;
		this.exits[1] = southExit;
		this.exits[2] = eastExit;
		this.exits[3] = westExit;
		this.exits[4] = upExit;
		this.exits[5] = downExit;
	}

	public void setAExit(boolean exit, int i)
	{
		this.exits[i] = exit;
	}

	public int getXCoord ()
	{
		return xCoord;
	}

	public int getYCoord ()
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

}