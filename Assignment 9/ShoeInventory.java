public class ShoeInventory
{
	private ShoeType[] ShoeInventory;
	private int counter;
	private int cells;

	public ShoeInventory(int length) throws ShoeException
	{
		if (length >= 1)
		{
			cells = length;
			counter = 0;
			ShoeInventory = new ShoeType[cells];
		}
		else
		{
			throw new ShoeException("Invalid amount of types of shoes.");
		}
	}

	public boolean isFull()
	{
		if (counter == ShoeInventory.length)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	public boolean isEmpty()
	{
		if(ShoeInventory[0] == null)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	public int getCapacity()
	{
		return counter - 1;
	}

	public int getNumItems()
	{
		int numItems;
		int k = 0;
		numItems = ShoeInventory[k].getQuantity();
		k++;
		while (k < counter)
		{
			numItems += ShoeInventory[k].getQuantity();
			k++;
		}
		return numItems;
	}

	public int find(Shoe refrence)
	{
		int k = 0;
		int c = 0;
		if (refrence == null)
		{
			k = -2;
			return k;
		}
		else if (isEmpty() == true)
		{
			k = -3;
			return k;
		}
		else
		{
			while (c != counter)
			{
				if (refrence.equals(ShoeInventory[c]) == true)
				{
					k = c;
					return k;
				}
				c++;
			}
			k = -1;
			return k;
		}
	}

	public void add(ShoeType type) throws ShoeException
	{
		if (isFull() == true)
		{
			throw new ShoeException("The store inventory is full.");
		}
		else if (find(type) >= 0)
		{
			throw new ShoeException("There already is this type of shoe in the store.");
		}
		else
		{
			ShoeInventory[counter] = type;
			counter++;
		}
	}

	public void delete(int index) throws ShoeException
	{
		if (isEmpty() == true)
		{
			throw new ShoeException("The store inventory is empty.");
		}
		else if (index < 0 || index >= counter)
		{
			throw new ShoeException("Invalid Index");
		}
		else
		{
			while (index < counter - 1)
			{
				ShoeInventory[index] = ShoeInventory[index + 1];
				index++;
			}
			counter--;
		}
	}

	public String toString()
	{
		if (isEmpty() == true)
		{
			return "The store inventory is empty.";
		}
		else
		{
			int k = 0;
			String inventory;
			inventory = ("Item " + (k + 1) + ": " + ShoeInventory[k] + " \n");
			k++;
			while (k < counter)
			{
				inventory += ("Item " + (k + 1) + ": " + ShoeInventory[k] + " \n");
				k++;
			}
			return inventory;
		}
	}

	public boolean equals(Object obj)
	{
		if ((obj == null) || (obj.getClass() != this.getClass()))
		{
			return false;
		}
		else
		{
			return true;
		}
	}

	public Object clone() throws CloneNotSupportedException
	{
		return super.clone();
	}
}