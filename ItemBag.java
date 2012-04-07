import java.lang.*;

public class ItemBag
{
	private Item [] items;
	private int numberOfItems;
	private final int INCREMENT;

    //Creates an empty instance of ItemBag
	public ItemBag()
	{
		items = new Item [0];
		numberOfItems = 0;
		INCREMENT = 10;
	}

	public void addItem(Item i)
	{
		if (isFull())
			increaseCapacity(INCREMENT);
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

	//prints items
	public void printItems()
	{ 
		if (numberOfItems == 0)
			System.out.println("\n You have no items :(");
				else
				{
					System.out.println("\n You currently have "+ numberOfItems +" items:");
					for (int i = 0; i < numberOfItems; i++)
						System.out.println(items[i]+ " ");
					System.out.println();
				}                
			}

	public int countItems()
	{

		return numberOfItems;

	}

	public Item getItem(String name)
	{

		for(int i = 0; i<numberOfItems; i++)
			if(items[i].getName() == name)
				return items[i];

		throw new IllegalArgumentException("No such item!");
	}

}