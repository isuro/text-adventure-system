import java.util.Scanner;

public class Verbs{

	public void parse(String input){   //prints space, finds the verb

		Scanner scan = new Scanner(input.toLowerCase());
		String i = scan.next(); //first word
		String words = ""; //remaining words
		while(scan.hasNext()){words+= scan.next();}
		String eol = System.getProperty("line.separator");
		System.out.println(eol+eol+eol);

		//The following act on the verb, passing arguments if necessary
		//The string 'words' contains any arguments,
		if (i == "north" || i == "n") {north();}
		else if (i == "south" || i == "s") {south();}
		else if (i == "east" || i == "e") {east();}
		else if (i == "west" || i == "w") {west();}
		else if (i == "northeast" || i == "ne") {northeast();}
		else if (i == "northwest" || i == "nw") {northwest();}
		else if (i == "southeast" || i == "se") {southeast();}
		else if (i == "southwest" || i == "sw") {southwest();}
		else if (i == "up" || i == "u") {up();}
		else if (i == "down" || i == "d") {down();}
		else if (i == "use") {use(words);}
		else if (i == "talk") {talk(words);}
		else if (i == "examine" || i == "e") {examine(words);}
		else if (i == "look" || i == "l") {look();}
		else if (i == "inventory" || i == "i") {inventory();}
		else if (i == "exit" || i == "quit") {System.exit(0);}
		else {nope();}
	}
	
	public void north(){
		Exe.z++;
	}

	public void south(){
		Exe.z--;
	}

	public void east(){
		Exe.x++;
	}

	public void west(){
		Exe.x--;
	}

	public void northeast(){
		Exe.z++;
		Exe.x++;
	}

	public void northwest(){
		Exe.z++;
		Exe.x--;
	}

	public void southeast(){
		Exe.z--;
		Exe.x++;
	}

	public void southwest(){
		Exe.z--;
		Exe.x--;
	}

	public void up(){
		Exe.y++;
	}

	public void down(){
		Exe.y--;
	}

	public void use(String i){
		
	}

	public void talk(String i){
		Items.getItem(i).talk();
	}

	public void examine(String i){
		System.out.println(Items.getItem(i).description);
	}

	public void look(){
		System.out.println(Exe.world[Exe.x][Exe.y][Exe.z].examine);
	}

	public void inventory(){
		System.out.println(player.printinv());
	}

	public void nope(){
		System.out.println("Huh?");
	}
	
}