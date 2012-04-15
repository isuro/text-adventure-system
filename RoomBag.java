/**
* RoomBag class
*
* @author Alison Mayer
* @date April 4, 2012
* @version 1.1
*/

public class RoomBag
{
	public Room[] rooms;
	int numberOfRooms;
	final int INCREMENT;

	public RoomBag()
	{
		rooms = new Room[0];
		numberOfRooms = 0;
		INCREMENT = 10;
	}

	public void addRoom(Room r)
	{
		if (isFull())
			increaseCapacity(INCREMENT);
		else
		{
			r = rooms[numberOfRooms];
			numberOfRooms++;	
		}
	}

	public boolean isFull()
	{
		if ((rooms.length - 1) == numberOfRooms)
			return true;
		else
			return false;	
	}

	public void increaseCapacity(int newSize)
	{
		Room [] old = rooms;
        rooms = (Room []) new Comparable[ newSize ];
        for(int i = 0; i < old.length; i++ )
            rooms[ i ] = old[ i ]; 
	}

	//returns array of rooms
	public Room[] getRooms()
	{
		return rooms; 
	}

	//returns room with user-given index from the array of rooms
	public Room getARoom(int i)
	{
		return rooms[i];
	}

	public int getNumberOfRooms()
	{
		return numberOfRooms;
	}

	//prints items
	public void printRooms()
    { 
        if (numberOfRooms == 0)
            System.out.println("There are no rooms.");
        else
        {
            System.out.println("\n There are currently "+ numberOfRooms +" rooms:");
            for (int i = 0; i < numberOfRooms; i++)
                System.out.print(rooms[i]+ " ");
            System.out.println();
        }                
    }
}