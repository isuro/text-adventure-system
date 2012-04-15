import java.io.*;
import java.util.Scanner;


/**
* World describes the world of the game, including the array of rooms contained
* within the world. It also includes variables such as start location, goal
* location, and general world structure. It implements the singleton design 
* pattern, as there is only ever one instance of World in any given game.
* @author Alison Mayer
* @date April 4, 2012
* @version 1.1
*/
public class World
{
	private String roomPathName;
	private static Room[][][] worldRooms;
	private static RoomBag roomArray;
	private static int startLocationX;
	private static int startLocationY;
	private static int startLocationZ;

	//private constructor; World implements a singleton design pattern
	private World()
	{
		worldRooms = new Room[10][10][10];
		setWorldRooms();
	}

	/**
	* Returns the singleton World to user. If there is no instance of World,
	* constructs a new World.
	* 
	* @return world, the instance of World
	*/
	public static World getWorld() 
	{
		if (world == null) 
			world = new World();
		return world;
	}

	/**
	*
	*
	*
	*
	*/
	private static void setWorldRooms()
	{
		roomPathName = "C:\\Users\\Alison\\Documents\\Clark\\Computer Science"+
			"\\SoftwareEngineeing\\text-adventure-system\\ExampleRooms1.txt";
		readRoomFile(roomPathName);	
		for (int i = 0; i < roomArray.numberOfRooms; i++)
		{
			worldRooms[roomArray.getARoom(i).getXCoord][roomArray.getARoom(i).getYCoord][roomArray.getARoom(i).getZCoord] = new Room ();
		}
	}
	
	/**
    * File should be in the following format:
    * 
    * "TOTALNUMBEROFROOMS 3
    *  1 1 1 1
    *  This is a description of room 1.
    *  F F F F T F
    *  2 1 2 1
    *  This is a description of room 2.
    *  F F T F F F
    *  3 2 2 1
    *  This is a description of room 3.
    *  F F T F F F
    *  ...
    *  1000 x y z
    *  This is a description of room 1000.
    *  NExit SExit EExit WExit UpExit DownExit"
    *  
    *  The first number is the room ID, and the last three numbers are the room's
    *  x, y, and z coordinates, respectively. Worlds cannot exceed 1000 rooms 
    *  (i.e. a 10x10x10 three dimension array).
    *  
    */
    private static void readRoomFile (String pathname)
    {
        try {
            Scanner scanLocation = new Scanner(new File (pathname));
            Scanner scanDescription = new Scanner(new File(pathname)).useDelimiter("\\d");
            Scanner scanExits = new Scanner (new File(pathname)).useDelimiter("\\d");

            int xCoord;
            int yCoord;
            int zCoord;
            int totalRooms;
            String roomDescription;

            totalRooms = scanLocation.nextInt();
            for (int i = 0; i < totalRooms; i++) 
                {                
                scanLocation.nextInt();
                Room r = new Room(scanLocation.nextInt(), scanLocation.nextInt(), 
                    scanLocation.nextInt(), scanDescription.next());
                
                //adds newly created room to roomArray
                roomArray.addRoom(r);
                
                //sets exits for newly created room based on scanned input
                for (int j = 0; j < 6; j++)
                    {
                    if (scanExits.next() == "T")
                        roomArray.getARoom(i).setAExit(true, j);    
                    }
                }      
            }
        catch (FileNotFoundException ex)
        {
            System.out.println("File not found.");
        }
    }

}