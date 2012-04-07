public class Player
{
	private ItemBag inventory = new ItemBag();
	private int score;

	private Player()
	{
		score = 0;
	}

	public ItemBag getInv()
	{
		return this.inventory;
	}

	public void changeScore(int x)
	{
		score+=x;
	}

	public void printScore()
	{
		System.out.println("Your score is " + score);
	}
}