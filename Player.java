public class Player
{
	private static ItemBag inventory = new ItemBag();
	private static int score;

	private Player()
	{
		score = 0;
	}

	public static ItemBag getInv()
	{
		return this.inventory;
	}

	public static void changeScore(int x)
	{
		score+=x;
	}

	public static void printScore()
	{
		System.out.println("Your score is " + score);
	}
}