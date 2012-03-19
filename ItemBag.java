import java.lang.*;

public class ItemBag
{
	public Item [] items;
	public int numberOfItems;

	public ItemBag()
	{
		items = new Item [0];
		numberOfItems = 0;
	}

	public void addItem(Item i)
	{
		if (items.isFull)
			items.increaseCapacity(1);
		else
		{
			i = items[numberOfItems];
			numberOfItems++;	
		}
	}

	public boolean isFull()
	{
		if ((items.length() - 1) == numberOfItems)
			return true;
		else
			return false;	
	}

	public void increaseCapacity()
	{
		
	}
}