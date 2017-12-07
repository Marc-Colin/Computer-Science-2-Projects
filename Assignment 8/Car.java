public class Car
{
	private double price;
	private int year;
	private String make;
	private String vin;
	private final double MINPRICE = 0;
	private final double MAXPRICE = 100000;
	private final int MINYEAR = 1970;
	private final int MAXYEAR = 2011;
	private final String DMAKE = new String ("N/A");
	private final String DVIN = new String ("N/A");
	private static int Count = 0;
//class constructors
	public Car()
	{
		price = MINPRICE;
		year = MINYEAR;
		make = DMAKE;
		vin = DVIN;
		Count++;
	}
	public Car(int y, double p, String m, String v) throws CarException
	{
		setPrice(p);
		setYear(y);
		setMake(m);
		setVin(v);
		Count++;
	}
	public Car(Car cloneCar)
	{
		price = cloneCar.price;
		year = cloneCar.year;
		make = cloneCar.make;
		vin = cloneCar.vin;
		Count++;
	}
//setter-getters
	public void setPrice(double p) throws CarException
	{
		if (p >= MINPRICE && p <= MAXPRICE)
			price = p;
		else
			throw new CarException("Invalid Price");
	}
	public double getPrice()
	{
		return price;
	}
	public void setYear(int y) throws CarException
	{
		if (y >= MINYEAR && y <= MAXYEAR)
			year = y;
		else
			throw new CarException("Invalid Year");
	}
	public double getYear()
	{
		return year;
	}
	public void setMake(String m) throws CarException
	{
		if (m == null)
			throw new CarException("Invalid Make");
		else
			make = m;
	}
	public String getMake()
	{
		return make;
	}
	public void setVin(String v) throws CarException
	{
		if (v == null)
			throw new CarException("Invalid Vin");
		else
			vin = v;
	}
	public String getVin()
	{
		return vin;
	}
//getCount method
	public static int getCount()
	{
		return Count;
	}
//toString method
	public String toString()
	{
		return "[Year: " + year + ", Price: " + price + ", Make: " + make + ", Vin: " + vin;
	}
//finalize method
	protected void finalize()
	{
		System.out.println("The finalize is called.");
		Count--;
	}
}