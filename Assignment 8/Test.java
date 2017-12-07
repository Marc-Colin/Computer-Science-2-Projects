import java.util.Scanner;
import java.io.*;
public class Test
{
	public static void main(String[] args)
    {
     	Scanner i = new Scanner(System.in);
     	String fname;
	  	System.out.println("Hello World");

	  	System.out.println("Enter the name of the data file: ");
		fname = i.nextLine( );
		try
		{
			CarDealerShip theDealerShip= new CarDealerShip( fname );
			System.out.println("Now adding a Car.");
			try
			{
				Car m = new Car( 1992 , 3000 , "Ford", "5691044574HP");
				theDealerShip.Add( m );
				System.out.println("The current inventory of the car dealership is: \n" + theDealerShip);
				theDealerShip.Delete();
				System.out.println("The current inventory of the car dealership is: \n" + theDealerShip);
				Car b = new Car( 1992 , 3000 , "Ford", "5691044574HP");
				theDealerShip.Add( b );
				System.out.println("The current inventory of the car dealership is: \n" + theDealerShip);
				Car c = new Car( 2010 , 3000 , "blahhh", "5691044574HP");
				theDealerShip.Add( c );
				System.out.println("The current inventory of the car dealership is: \n" + theDealerShip);
				Car j = new Car( 1996 , 3000 , "nah nah", "5691044574HP");
				theDealerShip.Add( j );
				System.out.println("The current inventory of the car dealership is: \n" + theDealerShip);
				theDealerShip.finalize();
			}
			catch(CarException e)
			{
				System.out.println("Unable to create a car. " + e);
			}
		}
		catch(IOException f)
		{
			System.out.println("Sorry cannot open data file. Program terminating.");
		}
		catch(CarException e)
		{
			System.out.println("Unable to create a car. " + e);
		}
    }
}