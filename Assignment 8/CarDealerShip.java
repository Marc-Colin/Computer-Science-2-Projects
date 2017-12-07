import java.io.*;
import java.util.Scanner;
public class CarDealerShip
{
	File file;
	public int counter;
	public int num = 1;
	private boolean space = true;
	private boolean full = false;
	private double price;
	private int year;
	private String make;
	private String vin;
	private String inventory;
	private Car[] DealerShip = new Car[5];

	public CarDealerShip(String filename) throws IOException, CarException
	{
		file = new File(filename);
      	Scanner inputFile = new Scanner(file);
      	while (inputFile.hasNext())
      	{
			if (space == true)
			{
				make = inputFile.nextLine();
				year = Integer.parseInt(inputFile.nextLine());
				price = Double.parseDouble(inputFile.nextLine());
				vin = inputFile.nextLine();
				Car add = new Car(year, price, make, vin);
				space = Add(add);
			}
			else if (space == false)
			{
				inputFile.close();
				throw new CarException("Dealership is full.");
			}
		}
		inputFile.close();
	}
	public boolean Add(Car store)
	{
		if (counter != DealerShip.length)
		{
			space = true;
			DealerShip[counter] = store;
			counter++;
			return space;
		}
		else
		{
			space = false;
			return space;
		}
	}
	public boolean Delete()
	{
		if (DealerShip[0] == null)
		{
			full = false;
			return full;
		}
		else
		{
			DealerShip[counter - 1] = null;
			full = true;
			counter--;
			return full;
		}
	}
	public String toString()
	{
		int k = counter;
		inventory = ("Car " + num + ": " + DealerShip[k - 1] + " \n");
		k--;
		while (k > 0)
		{
			inventory += ("Car " + num + ": " + DealerShip[k - 1] + " \n");
			num++;
			k--;
		}
		num = 1;
		return inventory;
	}
	protected void finalize() throws IOException
	{
		int k = counter;
		PrintWriter outputFile = new PrintWriter(file);
		outputFile.println("Car " + num + ": " + DealerShip[k - 1]);
		k--;
		while (k > 0)
		{
			outputFile.println("Car " + num + ": " + DealerShip[k - 1]);
			num++;
			k--;
		}
		outputFile.close();
	}
}