import java.io.*;
import java.util.Scanner;

public class Exe
{
	public int x = 5;
	public int y = 5;
	public int z = 5;
	public Room[][][] world = new Room[10][10][10];
    public String chName = "";

	public static void main (String[] args)
	{
		System.out.println("Hello there. Welcome to Isaac and Alison's Glorious
        Text Adventure For Great Victory! To get started, please type your
        character's name.")
        chName = readInput();
        System.out.println("Why hello there " + chName + ". Why don't you check
        out your surroundings by typing 'look'?");
		Verbs.parse(System.in);
        System.out.println("Wow! What a cool place. Why don't you examine the
        box? Type 'examine' to take a closer look at the box.");
        Verbs.parse(System.in);			
	}

	public String readInput ()
	{
        Scanner scan = new Scanner(System.in);
        String input = "";

        while (scan.hasNext())
        	input += scan.next();
       	if (input != null)
        	return input;
        else
        	return null;	
    } 
    
    // File should be in the following format:
    // 
    
    public void readFile (String pathname)
    {
    	try {
            Scanner scanPlace = new Scanner(new File (pathname));
            Scanner scanItems = new Scanner(new File (pathname)).useDelimiter("\\d");

            int currentLocationX;
            int currentLocationY;
            int currentLocationZ;
            int numCurrentItems;
            Item [] currentItems = new Item [numCurrentItems];
             
            currentLocationX = scanPlace.nextInt();
            currentLocationY = scanPlace.nextInt();
            currentLocationZ = scanPlace.nextInt();
            numCurrentItems = scanItems.nextInt();

            for (int i = 0; i < numCurrentItems; i++) 
                currentItems[i] = new Item (scanItems.next());
            }
        catch (FileNotFoundException ex)
        {
            System.out.println("File not found.");
        }
    }
    
    public void saveFile ()
    {
        
    }     
 
	public void addRoom (Room r)
	{
		
	}
}

