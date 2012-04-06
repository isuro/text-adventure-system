public class Player
{
	private ItemBag inventory = new ItemBag();
	private String name;

	public Player(String name)
	{
		this.name = name;
	}

	public ItemBag getInv()
	{
		return this.inventory;
	}
}