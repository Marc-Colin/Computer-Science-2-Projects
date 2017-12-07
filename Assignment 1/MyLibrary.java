import java.util.Scanner;
import java.lang.Math.*;

public class MyLibrary
{
	Scanner keyboard = new Scanner(System.in);
	//Method 1 attributes
	static int credits;
	static double bill;
	static int MINCREDITS = 0;
	static int MAXCREDITS = 33;
	static double LABFEE = 50.00;
	static double TECHFEE = 20.00;
	static double CREDITCOST = 110.00;
	static int FULLTIME = 12;
	//Method 2 attributes
	static int fac;
	static int facCounter;
	static long facReturn;
	static int MINFAC = 0;
	static int MAXFAC = 20;
	//Method 3 attributes
	static int index;
	//Method 4 attributes
	boolean check = false;
	String input;
	int number;
	//Method 5 attributes
	String returnPhrase;

// Method 1
	public static double CalcFee(int c) throws creditException
	{

		if (c >= MINCREDITS && c <= MAXCREDITS)
		{
			credits = c;
		}
		else
		{
			throw new creditException();
		}
		if (credits >= FULLTIME)
		{
			bill = (FULLTIME * CREDITCOST) + LABFEE + TECHFEE;
		}
		else if (credits == MINCREDITS)
		{
			bill = 0;
		}
		else
		{
			bill = (credits * CREDITCOST) + LABFEE;
		}
		return bill;
	}

// Method 2
	public long fac(int i) throws facException
	{
		if (i > MINFAC && i <= MAXFAC)
		{
			fac = i;
		}
		else if (i == MINFAC)
		{
			fac = 1;
		}
		else
		{
			throw new facException();
		}
		facCounter = (fac - 1);
		facReturn = fac;
		while (facCounter > 1)
		{
			facReturn = facReturn * facCounter;
			facCounter--;
		}
		return facReturn;
	}

// Method 3
	public static int locate(double[] array, double find) throws ArrayException
	{
		if (array == null)
		{
			throw new ArrayException();
		}
		else if (array.length == 0 || array.length < 0)
		{
			throw new ArrayException();
		}
		else
		{
			for(int c = 0; c < array.length; c++)
			{
				if (array[c] == find)
				{
					index = c;
					break;
				}
				else
				{
					index = -1;
				}
			}
			return index;
		}
	}

// Method 4
	public int getInteger()
	{
		while (check == false)
		{
			System.out.print("Please enter a integer: ");
			input = keyboard.nextLine();
			try
			{
				number = Integer.parseInt(input);
				check = true;
			}
			catch (NumberFormatException e)
			{
				System.out.println("Error. This value is not an integer.");
			}
		}
		return number;
	}

// Method 5
	public String substitute(String phrase, char replace, char sub) throws InvalidStringException
	{
		if (phrase == null)
		{
			throw new InvalidStringException();
		}
		else if (phrase.length() == 0 || phrase.length() < 0)
		{
			throw new InvalidStringException();
		}
		else
		{
			char[] newPhrase = new char[phrase.length()];
			for (int c = 0; c < phrase.length(); c++)
			{
				newPhrase[c] = phrase.charAt(c);
			}
			for (int c = 0; c < phrase.length(); c++)
			{
				if (phrase.charAt(c) == replace)
				{
					newPhrase[c] = sub;
				}
			}
			returnPhrase = new String(newPhrase);
			return returnPhrase;
		}
	}

//Method 6
	public double sin(double d, int n) throws angleException, facException
	{
		double sinV = d;
		fac(n);
		if ( d >= 0 && d < (2 * Math.PI))
		{
			for (int degree = 3, sign = -1; n >= 1; degree = degree + 2, n--, sign = sign * -1)
			{
				sinV += (sign * (Math.pow(d,degree) / fac(degree)));
			}
		}
		else
		{
			throw new angleException();
		}
		return sinV;
	}
}