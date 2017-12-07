public class Shoe implements Cloneable
{
	public static int count;
	protected int color;
	protected double size;
	protected String id;
	private final int MINCOLOR = 1;
	private final double MINSIZE = 1.0;


	public Shoe(String id, double s, int c) throws ShoeException
	{
		setId(id);
		setSize(s);
		setColor(c);
		count++;
	}
	public Shoe(Shoe clone)
	{
		id = clone.id;
		size = clone.size;
		color = clone.color;
	}

	public void setId(String ID) throws ShoeException
	{
		if (ID == null)
		{
			throw new ShoeException("Invalid ID");
		}
		else
		{
			id = ID;
		}
	}
	public String getId()
	{
		return id;
	}

	public void setSize(double s) throws ShoeException
	{
		if (s >= MINSIZE)
		{
			size = s;
		}
		else
		{
			throw new ShoeException("Invalid Size");
		}
	}
	public double getSize()
	{
		return size;
	}

	public void setColor(int c) throws ShoeException
	{
		if (c >= MINCOLOR)
		{
			color = c;
		}
		else
		{
			throw new ShoeException("Invalid Color");
		}
	}
	public int getColor()
	{
		return color;
	}

	public String toString()
	{
		return "ID - " + id + ", Size - " + size + ", Color - " + color;
	}

	public boolean equals(Object obj)
	{
		if ((obj == null) || (obj.getClass() != this.getClass()))
		{
			return false;
		}
		else
		{
			Shoe temp = (Shoe)obj;
			return this.id.equals(temp.getId());
		}
	}

	public Object clone() throws CloneNotSupportedException
	{
		return super.clone();
	}

	protected void finalize()
	{
		System.out.println("The shoe with the id " + id + " and size of " + size + "and the color of " + color + " will be deleted now.");
		count--;
	}

	public static int getCount()
	{
		return count;
	}
}