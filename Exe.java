import java.util.Scanner;

public class Exe
{
	public int x = 5;
	public int y = 5;
	public int z = 5;
	public Room[][][] world = new Room[10][10][10];

	public static void main (String[] args)
	{
		
		Verb.look();
		Verb.parse(new Scanner.toString());			
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
    
    public void readFile (String pathname)
    {
    	try {
            Scanner scanPlace = new Scanner(new File (pathname));
            Scanner scanItems = new Scanner(new File (pathname)).useDelimiter("\\d");

            Room currentLocation = new Room();
             
            currentLocation = scanPlace.nextInt();
            scanItems = scanItems.next();

            for (int i = 0; i < numEdges; i++) 
                    edges[i] = new Edge (scanEdges.next(), scanEdges.next(), scanEdges.nextInt());
            while (scanNodes.hasNext())
            {
                    if (nodesscanNodes.next())
                        nodes += scanNodes.next();
              }
            }
        catch (FileNotFoundException ex)
        {
            System.out.println("File not found.");
        }
    }     
 
	public void addRoom (Room r)
	{
		
	}
}

