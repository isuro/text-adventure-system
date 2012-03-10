import java.io.*;
import java.util.Scanner;

public class Exe
{
	static int x = 5;
	static int y = 5;
	static int z = 5;
	public static Room[][][] world = new Room[10][10][10];
    public static String chName = "";

	public static void main (String[] args)
	{
		System.out.println("Hello there. Welcome to Isaac and Alison's Glorious Text Adventure For Great Victory (TM & C)! To get started, please type your character's name.");
        chName = readInput();
        System.out.println("Why hello there " + chName + ". Why don't you check out your surroundings by typing 'look'?");
		Verbs.parse(System.in.toString());
        System.out.println("Wow! What a cool place. Why don't you examine the box? Type 'examine box' to take a closer look at the box.");
        Verbs.parse(System.in.toString());
        while(true){
            Verbs.parse(System.in.toString());
        }
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

    public static String readInput ()
	{
        Scanner scan = new Scanner(System.in.toString());
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
    
    public static void readFile (String pathname)
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
    
    public static void saveFile ()
    {
        
    }     
 
	public static void addRoom (Room r)
	{
		
	}
}

