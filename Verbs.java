import java.util.Scanner;

public class Verbs{

	static final String EOL = System.getProperty("line.separator");
	
	/**
	* Prints whitespace, finds the verb.
	*/
	public static void parse(String input)
	{
		Scanner scan = new Scanner(input.toLowerCase());
		String i = scan.next(); //first word
		String words = ""; //remaining words
		while(scan.hasNext()){words+= scan.next() + " ";}
		System.out.println(EOL+EOL);

		//The following act on the verb, passing arguments if necessary
		//The string 'words' contains any arguments,
		if (i.equals("north") || i.equals("n")) {north();}
		else if (i.equals("northeast") || i.equals("ne")) {northeast();}
		else if (i.equals("east") || i.equals("e")) {east();}
		else if (i.equals("southeast") || i.equals("se")) {southeast();}
		else if (i.equals("south") || i.equals("s")) {south();}
		else if (i.equals("southwest") || i.equals("sw")) {southwest();}
		else if (i.equals("west") || i.equals("w")) {west();}
		else if (i.equals("northwest") || i.equals("nw")) {northwest();}
		else if (i.equals("up") || i.equals("u")) {up();}
		else if (i.equals("down") || i.equals("d")) {down();}
		else if (i.equals("use")) {use(words);}
		else if (i.equals("talk")) {talk(words);}
		else if (i.equals("examine") || i.equals("e")) {examine(words);}
		else if (i.equals("look") || i.equals("l")) {look();}
		else if (i.equals("inventory") || i.equals("i")) {inventory();}
		else if (i.equals("exit") || i.equals("quit")) {System.exit(0);}
		else if (i.equals("help") || i.equals("?")) {help();}
		else {nope();}
	}
	
	public static void north()
	{
		int Z = Exe.getZ();
		Exe.setZ(Z++);
	}

	public static void northeast()
	{
		int[] xyz = Exe.getCoords();
		Exe.setCoords(new int[] {xyz[0]++, xyz[1], xyz[2]++});
	}

	public static void east()
	{
		int X = Exe.getX();
		Exe.setX(X++);
	}

	public static void southeast()
	{
		int[] xyz = Exe.getCoords();
		Exe.setCoords(new int[] {xyz[0]++, xyz[1], xyz[2]--});
	}

	public static void south()
	{
		int Z = Exe.getZ();
		Exe.setZ(Z--);
	}

	public static void southwest()
	{
		int[] xyz = Exe.getCoords();
		Exe.setCoords(new int[] {xyz[0]--, xyz[1], xyz[2]--});
	}

	public static void west()
	{
		int X = Exe.getX();
		Exe.setX(X--);
	}

	public static void northwest()
	{
		int[] xyz = Exe.getCoords();
		Exe.setCoords(new int[] {xyz[0]--, xyz[1], xyz[2]++});
	}

	public static void up()
	{
		int Y = Exe.getY();
		Exe.setY(Y++);
	}

	public static void down()
	{
		int Y = Exe.getY();
		Exe.setY(Y--);
	}

	public static void use(String i)
	{
		
	}

	public static void talk(String i)
	{
		try {
			if(Player.getInv().getItem(i).getCanTalk()) {
				Player.getInv().getItem(i).talk();
			}
			else {
				System.out.println("No response...");
			}
		}
		catch (IllegalArgumentException ex)
		{
			nope();
		}
	}

	public static void examine(String i)
	{
		try
		{
			System.out.println(Player.getInv().getItem(i).getDescription());
		}
		catch (IllegalArgumentException ex)
		{
			nope();
		}
	}

	public static void look(){
		System.out.println(World.getRoom(Exe.getX(),Exe.getY(),Exe.getZ()).examine());
	}

	public static void inventory(){
		Player.getInv().printItems();
	}

	public static void help(){
		System.out.println(
			"Here's what you can do: (type indicated letter or full word)" + EOL +
			"You can go (n)orth, (s)outh, (e)ast, or (w)est." + EOL +
			"Sometimes, you can even go (u)p or (d)own." + EOL +
			"You can (use) an item, or (e)xamine one in your (i)nventory." + EOL +
			"You can always take a (l)ook around, and if all else fails," + EOL +
			"you can always (quit) and never, ever, ever come back.");
	}

	public static void nope(){
		System.out.println("Huh?");
	}
	
}