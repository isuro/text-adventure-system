import java.util.Vector;

public class Room{

	private int xCoord;
	private int yCoord;
	private int zCoord;
	private boolean[] exits = new boolean[10]; //list of exits
	private Vector items; //resizable list of items in the room
	private String description; //base description of room

	
	public Room(int x, int y, int z, String description){

		this.xCoord = x;
		this.yCoord = y;
		this.zCoord = z;
		this.description = description;
	}

	public String examine(){
		return description;
	} 

}