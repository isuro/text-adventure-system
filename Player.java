public class Player
{
	private static ItemBag inventory = new ItemBag();
	private static int score = 0;

	private Player()
	{
		score = 0;
	}

	public static ItemBag getInv()
	{
		return inventory;
	}

	public static void changeScore(int x)
	{
		score+=x;
	}

	public static void printScore()
	{
		System.out.println("Your score is " + score);
	}

	public static void getItem(Item i){
		inventory.addItem(i);
	}

	public static void dropItem(Item i){
		inventory.removeItem(i);
	}
}