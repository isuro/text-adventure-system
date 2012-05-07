import java.io.*;
import java.util.Scanner;

public class Exe{

	static int x = 1;
	static int y = 1;
	static int z = 1;
    static int[][][] location;
    static World world;
    static Player player;
    static final String EOL = System.getProperty("line.separator");

    public static void main (String[] args)
    {
        world = world.getWorld();
        player = player.getPlayer();
        System.out.println("Do you need some help getting started? (y/n)");
        System.out.print(EOL + ">"); if(readInput().equals("y"))
        {
          System.out.println(
            "Hello there. Welcome to Isaac and Alison's " + EOL +
            "Glorious Text Adventure For Great Victory (TM & C)!" + EOL +
            "To get started, please type your character's name.");
          System.out.print(EOL + ">"); player.setName(readInput());
          System.out.println(EOL +
            "Why hello there " + player.getName() + ". Why don't you " + EOL +
            "check out your surroundings by typing 'look'?");
          System.out.print(EOL + ">"); Verbs.parse(readInput());
          System.out.println(EOL +
            "Wow! What a cool place. Why don't you examine the" + EOL +
            "box? Type 'examine box' to take a closer look at the box.");
          System.out.print(EOL + ">"); Verbs.parse(readInput());
        }
        System.out.println(EOL +
            "Alright, from here on you're on your own." + EOL +
            "You can type 'help' or '?' to see a list of commands.");
        while(true){
            System.out.println();
            System.out.print(">"); Verbs.parse(readInput());
        }
    }

    /**
    * @return the player's current [x, y, z] coordinates as an int array.
    */
    public static int[] getCoords(){
        return new int[] {x, y, z};
    }

    /**
    * @return the player's current x coordinate.
    */
    public static int getX(){
        return x;
    }

    /**
    * @return the player's current y coordinate.
    */
    public static int getY(){
        return y;
    }

    /**
    * @return the player's current z coordinate.
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
        return new Scanner(System.in).nextLine(); 
    } 
    
   /**
    * Reads in a file that contains information about the previous game session. 
    * File should be in the following format:<br />
    * <br /><code>
    *  NAME#SCORE#CURRENTX#CURRENTY#CURRENTZ#NUMBERCURRENTITEMS#<br />
    *  nameOfItem1 # This is a description of Item 1. # item1UseEffect # NUMBEROFITEMSUSEDWITH # someItem1 # someItem2 # someItem3<br />
    *  nameOfItem2 # This is a description of Item 2. # item2UseEffect # NUMBEROFITEMSUSEDWITH # someItem1 # someItem2 # someItem3<br />
    *  nameOfItem3 # This is a description of Item 3. # item3UseEffect # NUMBEROFITEMSUSEDWITH # someItem1 # someItem2 # someItem3<br />
    * ...<br />
    *  nameOfItemN # This is a description of Item N. # itemNUseEffect # NUMBEROFITEMSUSEDWITH # someItem1 # someItem2 # someItem3</code>
    *
    * @param pathname    the path to a user-specified save file.
    */
   public static void readSaveFile (String pathname)
   {
     try {
        Scanner scanner = new Scanner(new File (pathname));
        scanner.useDelimiter("#");

        String name;
        String currentScore;
        String currentLocationX;
        String currentLocationY;
        String currentLocationZ;
        String numCurrentItems;
        ItemBag currentItems = new ItemBag();

        name = scanner.next().trim();
        currentScore = scanner.next().trim(); 
        currentLocationX = scanner.next().trim();
        currentLocationY = scanner.next().trim();
        currentLocationZ = scanner.next().trim();
        numCurrentItems = scanner.next().trim();

        int score = Integer.parseInt(currentScore);
        int locX = Integer.parseInt(currentLocationX);
        int locY = Integer.parseInt(currentLocationY);
        int locZ = Integer.parseInt(currentLocationZ);
        int numItems = Integer.parseInt(numCurrentItems);

        for (int i = 0; i < numItems; i++)
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
    * @return a newly contructed Item. Returns null if the world file is malformed.
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
    else{
        return null;
    }
   }

    /**
    * Saves game data in proper save format. File is saved as "adventure_save.txt"
    */
    public static void saveFile ()
    {
        try
        {
            FileWriter newSave = new FileWriter("adventure_save.txt");
            BufferedWriter newSaveOut = new BufferedWriter(newSave);
            newSaveOut.write(player.getName() + "#" + player.getScore() + "#" + getX() + "#" + getY() + "#" + getZ() + "#" + player.getInv().getNumberOfItems()); 
            newSaveOut.close();
            System.out.println("Game saved.");
        }
        catch (IOException io)
        {
            System.out.println("Error saving game!");  
        }
    }     
}

