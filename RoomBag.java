/**
* RoomBag class
*
* @author Alison Mayer
* @date April 4, 2012
* @version 1.1
*/
import java.util.Vector;
import java.util.Enumeration;

public class RoomBag
{
	public Vector<Room> rooms;

	public RoomBag()
	{
		rooms = new Vector<Room>();
	}

	public void addRoom(Room r)
	{
		rooms.add(r);
	}

	//returns array of rooms
	//public Room[] getRooms()
	//{
	//	return rooms; 
	//}

	//returns room with user-given index from the array of rooms
	public Room getARoom(int i)
	{
		return rooms.elementAt(i);
	}

	public int getNumberOfRooms()
	{
		return rooms.size();
	}

	//prints items
	public void printRooms()
    { 
        if (rooms.size() == 0)
            System.out.println("There are no rooms.");
        else
        {
            System.out.println("\n There are currently "+ rooms.size() +" rooms:");
            for (Enumeration<Room> e = rooms.elements(); e.hasMoreElements();)
            	System.out.println(e.nextElement()+ "; ");
            // for (int i = 0; i < rooms.size(); i++)
            //     System.out.print(rooms.elementAt(i)+ " ");
            System.out.println();
        }                
    }
}