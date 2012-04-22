import java.io.*;
import java.util.Scanner;

public class Exe
{
	static int x = 5;
	static int y = 5;
	static int z = 5;
    static int[][][] location;
    static World world;
    static String chName = "";
    static final String EOL = System.getProperty("line.separator");

	public static void main (String[] args)
	{
        world = world.getWorld();
		System.out.println(
            "Hello there. Welcome to Isaac and Alison's " + EOL +
            "Glorious Text Adventure For Great Victory (TM & C)!" + EOL +
            "To get started, please type your character's name.");
        System.out.print(EOL + ">"); chName = readInput();
        System.out.println(EOL +
            "Why hello there " + chName + ". Why don't you " + EOL +
            "check out your surroundings by typing 'look'?");
		System.out.print(EOL + ">"); Verbs.parse(readInput());
        System.out.println(EOL +
            "Wow! What a cool place. Why don't you examine the" + EOL +
            "box? Type 'examine box' to take a closer look at the box.");
        System.out.print(EOL + ">"); Verbs.parse(readInput());
        System.out.println(EOL +
            "Alright, from here on you're on your own." + EOL +
            "You can type 'help' or '?' to see a list of commands.");
        while(true){
            System.out.println();
            System.out.print(">"); Verbs.parse(readInput());
        }
    }

    /**
    * @return chName     the player's name.
    */
    public static String getChName(){
        return chName;
    }

    /**
    * @return coords  the player's current [x, y, z] coordinates as an int array.
    */
    public static int[] getCoords(){
        return new int[] {x, y, z};
    }

    /**
    * @return x     the player's current x coordinate.
    */
    public static int getX(){
        return x;
    }

    /**
    * @return y     the player's current y coordinate.
    */
    public static int getY(){
        return y;
    }

    /**
    * @return z     the player's current z coordinate.
    */
    public static int getZ(){
        return z;
    }

    /**
    * Sets the player's current location manually.
    *
    * @param coords     the desired [x, y, z] coordinates as an int array.
    */
    public static void setCoords(int[] coords){
        x = coords[0];
        y = coords[1];
        z = coords[2];
    }
	
    /**
    * @param x  the desired x coordinate.
    */
    public static void setX(int x){
        x = x;
    }

    /**
    * @param y  the desired y coordinate.
    */
    public static void setY(int y){
        y = y;
    }

    /**
    * @param z   the desired z coordinate.
    */
    public static void setZ(int z){
        z = z;
    }

    /**
    * Reads the next line from System.in using a scanner.
    */
    public static String readInput()
	{
//      Scanner scan = new Scanner(System.in);
//      String input = scan.nextLine();
        return new Scanner(System.in).nextLine(); 
//      return input;

//      while (scan.hasNext())
//      	input += scan.next();
//      	if (input != null)
//       	  return input;
//          else
//       	  return null;	
//

    } 
    
   /**
    * Reads in a file that contains information about the previous game session. 
    * File should be in the following format:
    * 
    * "SCORE someNumber<br />
    *  CURRENTROOM someNumberX # someNumberY # someNumberZ<br />
    *  NUMBERCURRENTITEMS someNumber<br />
    *  nameOfItem1 # This is a description of Item 1. # item1UseEffect # NUMBEROFITEMSUSEDWITH # someItem1 # someItem2 # someItem3<br />
    *  nameOfItem2 # This is a description of Item 2. # item2UseEffect # NUMBEROFITEMSUSEDWITH # someItem1 # someItem2 # someItem3<br />
    *  nameOfItem3 # This is a description of Item 3. # item3UseEffect # NUMBEROFITEMSUSEDWITH # someItem1 # someItem2 # someItem3<br />
    * ...<br />
    *  nameOfItemN # This is a description of Item N. # itemNUseEffect # someItem1 # someItem2 # someItem3"
    * 
    * @param pathname   the path to a user-specified world file.
    */
    public static void readSaveFile (String pathname)
    {
    	try {
            Scanner scanner = new Scanner(new File (pathname));

            int currentScore;
            int currentLocationX;
            int currentLocationY;
            int currentLocationZ;
            int numCurrentItems;
            ItemBag currentItems = new ItemBag();

            currentScore = scanner.nextInt(); 
            currentLocationX = scanner.nextInt();
            currentLocationY = scanner.nextInt();
            currentLocationZ = scanner.nextInt();
            numCurrentItems = scanner.nextInt();

            for (int i = 0; i < numCurrentItems; i++)
            {
                Item item = processLine(scanner.nextLine());
                currentItems.addItem(item);
            }
            
            System.out.println("Loaded save file."); 
        }
                
        catch (FileNotFoundException ex)
        {
            System.out.println("File not found.");
        }
    }

   /**
    * Reads a line of text from a save file. Properly formatted save
    * files contain all data for a item in one line. If the save 
    * file is formatted properly, processLine will return an Item with
    * data read from the input parameter.
    *
    * @param aLine  a String of data
    * @return i     a newly contructed Item. Returns null if the world file is malformed.
    */
    public static Item processLine (String aLine)
    {
        Scanner scan = new Scanner (aLine);
        scan.useDelimiter("#");
        
        if (scan.hasNext())
        {   
            String itemName = scan.next().trim();
            String itemDescription = scan.next().trim();
            String itemUseEffect = scan.next().trim();
            String numberOfItemsUsedWith = scan.next();
            int numOfItemsUsedWith = Integer.parseInt(numberOfItemsUsedWith.trim());           
            String [] itemsUsedWith = new String [numOfItemsUsedWith];
            for (int j = 0; j < itemsUsedWith.length; j++)
                    {
                        itemsUsedWith[j] = scan.next();  
                    }
              Item i = new Item (itemName, itemDescription, itemUseEffect, itemsUsedWith);
              return i;
          }
          else
            return null;
    }
    
    public static void saveFile ()
    {
        
    }     
 
	public static void addRoom (Room r)
	{
		
	}
}

