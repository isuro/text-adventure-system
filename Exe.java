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

    public static String getChName(){
        return chName;
    }

    public static int[] getCoords(){
        return new int[] {x, y, z};
    }

    public static int getX(){
        return x;
    }

    public static int getY(){
        return y;
    }

    public static int getZ(){
        return z;
    }

    public static void setCoords(int[] coords){
        x = coords[0];
        y = coords[1];
        z = coords[2];
    }
	
    public static void setX(int x){
        x = x;
    }

    public static void setY(int y){
        y = y;
    }

    public static void setZ(int z){
        z = z;
    }

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
    
   
    public static void readSaveFile (String pathname)
    {
    	try {
            Scanner scanPlace = new Scanner(new File (pathname));
            Scanner scanItems = new Scanner(new File (pathname)).useDelimiter("\\d");

            int currentLocationX;
            int currentLocationY;
            int currentLocationZ;
            int numCurrentItems;
            ItemBag currentItems = new ItemBag();
            // currentItems.numberOfItems = numCurrentItems; Is this needed?
             
            currentLocationX = scanPlace.nextInt();
            currentLocationY = scanPlace.nextInt();
            currentLocationZ = scanPlace.nextInt();
            numCurrentItems = scanItems.nextInt();

            for (int i = 0; i < numCurrentItems; i++) 
                currentItems.addItem(new Item(scanItems.next()));
            }
        catch (FileNotFoundException ex)
        {
            System.out.println("File not found.");
        }
    }
    
    public static void saveFile ()
    {
        
    }     
 
	public static void addRoom (Room r)
	{
		
	}
}

