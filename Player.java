/**
* Player describes the player/character of the game, including the player's name,
* score, and inventory. It implements the singleton design 
* pattern, as there is only ever one instance of Player in any given game.
* @author Alison Mayer
* @date May 6, 2012
* @version 1.1
*/
public class Player
{
	private static ItemBag inventory;
	private static int score;
	private static String name;
	private static Player player;

	//private constructor; Player implements a singleton design pattern
	private Player()
	{
		name = "";
		score = 0;
		inventory = new ItemBag();
	}

	/**
    * Returns the singleton Player to user. If there is no instance of Player,
    * constructs a new Player.
    * 
    * @return player, the instance of Player
    */
	public static Player getPlayer()
	{
		if (player == null)
			player = new Player();
		return player;
	}

	public static void changeScore(int x)
	{
		score+=x;
	}

	public static void printScore()
	{
		System.out.println("Your score is " + score);
	}

	/**
	* Returns the player name.
	*
	* @return name
	*/
	public String getName()
	{
		return name;
	}

	/**
	* Returns the player score.
	*
	* @return score
	*/
	public int getScore()
	{
		return score;
	}

	/**
	* Returns the player inventory.
	*
	* @return inventory
	*/
	public static ItemBag getInv()
	{
		return inventory;
	}

	/**
	* Sets the player name to user-specified String.
	*
	* @param newName the new name of the player
	*/
	public void setName(String newName)
	{
		name = newName;
	}

	public static void addItem(Item i)
	{
		inventory.addItem(i);
	}

	public static void dropItem(Item i)
	{
		inventory.removeItem(i);
	}
}