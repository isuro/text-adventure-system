import java.lang.*;

public class ItemBag
{
	private Item [] items;
	private int numberOfItems;
	private final int INCREMENT;

	public ItemBag()
	{
		items = new Item [0];
		numberOfItems = 0;
		INCREMENT = 10;
	}

	public void addItem(Item i)
	{
		if (items.isFull())
			items.increaseCapacity(INCREMENT);
		else
		{
			i = items[numberOfItems];
			numberOfItems++;	
		}
	}

	public boolean isFull()
	{
		if ((items.length - 1) == numberOfItems)
			return true;
		else
			return false;	
	}

	public void increaseCapacity(int newSize)
	{
		Item [] old = items;
        items = (Item []) new Comparable[ newSize ];
        for(int i = 0; i < old.length; i++ )
            items[ i ] = old[ i ]; 
	}

}