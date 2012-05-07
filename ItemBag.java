import java.util.Vector;
import java.util.Enumeration;
/**
* Items are stored in a <code>Vector<Item></code>.
* Operations are conducted using <code>Vector</code>'s built-in methods.
*/
public class ItemBag
{
	private Vector<Item> items;

    //Creates an empty instance of ItemBag
	public ItemBag()
	{
		items = new Vector<Item>();
	}

	public void addItem(Item i)
	{
		items.add(i);
	}

	public void removeItem(Item i){
		items.remove(i);
	}

	/**
	* Prints out contained items.
	* There are two possible outputs:<br />
	* <code>You have no items :(</code><br />
	* or <br />
	* <code>You have <i>x</i> items: <i>item1 item2 item3 etc.</i></code>
	*/
	public void printItems()
	{ 
		if (items.size() == 0)
			System.out.println("You have no items :(");
		else
		{
			System.out.println("You currently have "+ items.size() +" items:");
            for (Enumeration<Item> e = items.elements(); e.hasMoreElements();)
            	System.out.println(e.nextElement()+ " ");
			// for (int i = 0; i < items.size(); i++)
			// 	System.out.println(items.elementAt(i)+ " ");
			System.out.println();
		}                
	}

	/**
	* Prints out items contained in room.
	* There are two possible outputs:<br />
	* <code>There are no items in this room</code><br />
	* or <br />
	* <code>There are <i>x</i> items in this room: <i>item1 item2 item3 etc.</i></code>
	*/
	public void printRoomItems()
	{ 
		if (items.size() == 0)
			System.out.println("There are no items in this room.");
		else
		{
			System.out.println("There are "+ items.size() +" items in this room:");
            for (Enumeration<Item> e = items.elements(); e.hasMoreElements();)
            	System.out.println(e.nextElement()+ " ");
			// for (int i = 0; i < items.size(); i++)
			// 	System.out.println(items.elementAt(i)+ " ");
			System.out.println();
		}                
	}

	public int getNumberOfItems()
	{
		return items.size();
	}

	/**
	* Finds an item in the bag by searching for it's exact name.
	* @param name 	the name of the item to be returned
	* @throws IllegalArgumentException If an item with the given name
	* can't be found.
	*/
	public Item getItem(String name) throws	IllegalArgumentException
	{
		int i = 0;
		String itemName = "";
		Item nextItem = new Item();
		for (Enumeration<Item> e = items.elements(); e.hasMoreElements();){
			nextItem = e.nextElement();
			itemName = nextItem.getName().toLowerCase();
			if(itemName.equals(name))
				return items.elementAt(i);
			i++;
		}
		throw new IllegalArgumentException("No such item!");
	}

}