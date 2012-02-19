import java.util.Scanner;

public class Verbs{

	public void parse(String input){   //finds the verb

		Scanner scan = new Scanner(input.toLowerCase());
		String i = scan.next(); //first word
		String words = ""; //remaining words
		while(scan.hasNext()){words+= scan.next();}

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
		else {nope();}
	}
	
	public void north(){
		
	}

	public void south(){
		

	}

	public void east(){
		
	}

	public void west(){
		
	}

	public void northeast(){
		
	}

	public void northwest(){
		
	}

	public void southeast(){
		
	}

	public void southwest(){
		
	}

	public void up(){
		
	}

	public void down(){
		
	}

	public void nope(){
		System.out.println("Huh?");
	}
	
}