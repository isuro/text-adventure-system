import java.util.Vector;
import java.util.Enumeration;

/**
* Rooms are stored in a <code>Vector<Item></code>.
* Operations are conducted using <code>Vector</code>'s built-in methods.
* @see ItemBag
*
* @author Alison Mayer
* @date April 4, 2012
* @version 1.1
*/
public class RoomBag
{
	private Vector<Room> rooms;

	public RoomBag()
	{
		rooms = new Vector<Room>();
	}

	public void addRoom(Room r)
	{
		rooms.add(r);
	}

	//returns room with user-given index from the array of rooms
	public Room getARoom(int i)
	{
		return rooms.elementAt(i);
	}

	public int getNumberOfRooms()
	{
		return rooms.size();
	}

	/**
	* Prints out contained items.
	* There are two possible outputs:<br />
	* <code>There are no rooms.</code><br />
	* or <br />
	* <code>There are currently <i>i</i> rooms: <i>x1, y1, z1</i>; <i>x2, y2, z2</i>; <i>x3, y3, z3</i>; <i>etc.</i></code>
	*/
	public void printRooms()
    { 
        if (rooms.size() == 0)
            System.out.println("There are no rooms.");
        else
        {
            System.out.println("\n There are currently "+ rooms.size() +" rooms:");
            for (Enumeration<Room> e = rooms.elements(); e.hasMoreElements();)
            	System.out.println(e.nextElement()+ "; ");

            System.out.println();
        }                
    }
}