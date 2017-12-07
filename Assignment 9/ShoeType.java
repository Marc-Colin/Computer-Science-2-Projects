public class ShoeType extends Shoe
{
	private Shoe type;
	private int quantity;
	private final int MINQUANTITY = 1;

	public ShoeType(Shoe t, int q) throws ShoeException, CloneNotSupportedException
	{
		super(t);
		type = (Shoe) super.clone();
		setQuantity(q);
	}
	public ShoeType(String id, double p, int c, int q) throws ShoeException, CloneNotSupportedException
	{
		super(id, p, c);
		type = (Shoe) super.clone();
		setQuantity(q);
	}

	public void setQuantity(int q) throws ShoeException
	{
		if (q >= MINQUANTITY)
		{
			quantity = q;
		}
		else
		{
			throw new ShoeException("Invalid Quantity");
		}
	}
	public int getQuantity()
	{
		return quantity;
	}

	public Shoe getShoe()
	{
		return type;
	}

	public String toString()
	{
		return "ID - " + id + ", Size - " + size + ", Color - " + color + ", Quantity - " + quantity;
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
			return type.id.equals(temp.getId());
		}
	}

	public Object clone() throws CloneNotSupportedException
	{
		return super.clone();
	}
}