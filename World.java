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
    private static String worldPathName;
    private static String objectPathName;
    public static Room [][][] worldRooms;
    public static ItemBag worldItems;
    private static int startLocationX;
    private static int startLocationY;
    private static int startLocationZ;
    private static World world;

    //private constructor; World implements a singleton design pattern
    private World()
    {
        worldRooms = new Room[10][10][10];
        setWorldRooms();
    }

    /**
    * Returns a single world room.
    * 
    * @param x the x-coordinate of the room
    * @param y the y-coordinate of the room
    * @param z the z-coordinate of the room
    * @return an instance of Room 
    */
    public static Room getRoom(int x, int y, int z)
    {
        return worldRooms[x][y][z];
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
    * Passes the path name of a world file to readWorldFile.
    */
    private static void setWorldRooms()
    {
        worldPathName = "ExampleRooms1.txt";
        objectPathName = "ExampleObjects1.txt";
        readWorldFile(worldPathName);
        readObjectFile(objectPathName); 
    }

    /**
    * Reads in the file defining the rooms in the world. 
    * File should be in the following format:
    * 
    * "TOTALNUMBEROFROOMS<br />
    * 1 1 # 1 # 1 # This is a description of room 1. #F#F#F#F#T#F<br />
    * 2 1 # 2 # 1 # This is a description of room 2. #F#F#T#F#F#F<br />
    * 3 2 # 2 # 1 # This is a description of room 3. #F#F#T#F#F#F<br />
    * ...<br />
    * 1000 x # y # z # This is a description of room 1000. #NExit#SExit#EExit#WExit#UpExit#DownExit"
    * 
    * The first number is the room ID, and the last three numbers are the room's
    * x, y, and z coordinates, respectively. Worlds cannot exceed 1000 rooms 
    * (i.e. a 10x10x10 three dimension array). 
    *
    * @param pathname, the path to a user-specified world file.
    */
    private static void readWorldFile (String pathname)
    {
        try {
            Scanner scanNumberOfRooms = new Scanner(new File (pathname));
            Scanner scanRooms = new Scanner(new File (pathname));
            
            int totalRooms;
            int currentRoom;

            totalRooms = scanNumberOfRooms.nextInt();
            scanNumberOfRooms.close();
            scanRooms.nextInt();
            
            for (int i = 0; i < totalRooms; i++) 
            {
                currentRoom = scanRooms.nextInt();
                if (i+1 == currentRoom)
                {   
                    Room r = processLine (scanRooms.nextLine());
                    if (r != null)
                        worldRooms[r.getXCoord()][r.getYCoord()][r.getZCoord()] = r;
                    else
                        System.out.println("Error reading World file. Check file format.");
                }
                else
                    System.out.println("Error reading world file. Check file format.");
            }
            System.out.println("Loaded world file.");
        }     
        catch (FileNotFoundException ex)
        {
            System.out.println("File not found.");
        }
    }
    
    /**
    * Reads a line of text from a world file. Properly formatted world
    * files contain all data for one room in each line. If the world 
    * file is formatted properly, processLine will return a Room with
    * data read from the input parameter.
    *
    * @param aLine, a String of data
    * @return r, a newly contructed Room. Returns null if the world file is malformed.
    */
    private static Room processLine (String aLine)
    {
        Scanner scan = new Scanner (aLine);
        scan.useDelimiter("#");
        
        if (scan.hasNext())
        {   
            String xCoord = scan.next();
            String yCoord = scan.next();
            String zCoord = scan.next();
            
            int x = Integer.parseInt(xCoord.trim());
            int y = Integer.parseInt(yCoord.trim());
            int z = Integer.parseInt(zCoord.trim());
            

            String description = scan.next();
            boolean [] exits = new boolean[6];
            for (int j = 0; j < 6; j++)
            {
                if (scan.next().compareTo("T") == 0)
                    exits[j] = true;
            }
            Room r = new Room(x, y, z, description, exits);
            return r;
        }
        else
          return null;
  }

    /**
    * Reads in a file that contains information about the objects contained within the world.
    * File should be in the following format:<br />
    * <br /><code>
    *  NUMBEROFITEMS nameOfItem1#item1IDX#item1IDY#item1IDZ#This is a description of Item 1.#item1UseEffect#NUMBEROFITEMSUSEDWITH#someItem1#someItem2#someItem3<br />
    *  nameOfItem2#item2IDX#item2IDY#item2IDZ#This is a description of Item 2.#item2UseEffect#NUMBEROFITEMSUSEDWITH#someItem1#someItem2#someItem3<br />
    *  nameOfItem3#item3IDX#item3IDY#item3IDZ#This is a description of Item 3.#item3UseEffect#NUMBEROFITEMSUSEDWITH#someItem1#someItem2#someItem3<br />
    * ...<br />
    *  nameOfItemN#itemNIDX#itemNIDY#itemNIDZ#This is a description of Item N.#itemNUseEffect#someItem1#someItem2#someItem3</code>
    * 
    * @param pathname the path to a user-specified object file.
    */
    public static void readObjectFile (String pathname)
    {
        try {
            Scanner scanItems = new Scanner (new File(pathname));

            int numCurrentItems;
            numCurrentItems = scanItems.nextInt();
            worldItems = new ItemBag();

            for (int i = 0; i < numCurrentItems; i++)
            {
                Item item = processObjectFileLine(scanItems.nextLine());
                worldItems.addItem(item);
                int locatedAtX = item.getIDX();
                int locatedAtY = item.getIDY();
                int locatedAtZ = item.getIDZ();
                worldRooms[locatedAtX][locatedAtY][locatedAtZ].setAItem(item);
            }
            
            System.out.println("Loaded object file."); 
        }
        
        catch (FileNotFoundException ex)
        {
            System.out.println("File not found.");
        }
    }

   /**
    * Reads a line of text from a object file. Properly formatted object
    * files contain all data for a item in one line. If the object 
    * file is formatted properly, processLine will return a Item with
    * data read from the input parameter.
    *
    * @param aLine   a String of data
    * @return i, a newly contructed Item. Returns null if the world file is malformed.
    */
   public static Item processObjectFileLine (String aLine)
   {
    Scanner scan = new Scanner (aLine);
    scan.useDelimiter("#");
    
    if (scan.hasNext())
    {   
        String itemName = scan.next().trim();
        String itemIDX = scan.next();
        String itemIDY = scan.next();
        String itemIDZ = scan.next();
        int idX = Integer.parseInt(itemIDX.trim());
        int idY = Integer.parseInt(itemIDY.trim());
        int idZ = Integer.parseInt(itemIDZ.trim());
        String itemDescription = scan.next().trim();
        String itemUseEffect = scan.next().trim();
        String numberOfItemsUsedWith = scan.next();
        int numOfItemsUsedWith = Integer.parseInt(numberOfItemsUsedWith.trim());           
        String [] itemsUsedWith = new String [numOfItemsUsedWith];

        for (int j = 0; j < itemsUsedWith.length; j++)
        {
            itemsUsedWith[j] = scan.next();  
        }
        Item i = new Item (itemName, idX, idY, idZ, itemDescription, itemUseEffect, itemsUsedWith);
        return i;
    }
    else
        return null;
}


}