public class ShoeTest
{
	public static void main(String[] args)
	{
		try
		{
			Shoe a = new Shoe("RR215", 6.5, 1);
			Shoe b = new Shoe(a);
			Shoe c = new Shoe("MR197", 4.0, 2);
			Shoe d = (Shoe) c.clone();
			Shoe e = new Shoe("YX231", 8.5, 1);
			Shoe f = new Shoe(e);
			System.out.println("Shoe a:" + a);
			System.out.println("Shoe b:" + b);
			System.out.println("Shoe c:" + c);
			System.out.println("Shoe d:" + d);
			System.out.println("Shoe e:" + e);
			System.out.println("Shoe f:" + f);
			ShoeType type1 = new ShoeType(a , 2);
			ShoeType type2 = new ShoeType(c , 2);
			ShoeType type3 = new ShoeType(e , 2);
			ShoeType type4 = new ShoeType("JR764", 7.5, 3, 4);
			ShoeType type5 = new ShoeType("MC233", 9.0, 2, 1);
			ShoeType type6 = new ShoeType("JR764", 7.5, 3, 4);
			ShoeInventory myStore = new ShoeInventory(5);
			if (myStore.isEmpty() == true)
			{
				System.out.println("The store is empty.");
			}
			System.out.println("Adding shoe type 1.");
			myStore.add(type1);
			System.out.println(myStore);
			System.out.println("Adding shoe type 2.");
			myStore.add(type2);
			System.out.println(myStore);
			System.out.println("Adding shoe type 3.");
			myStore.add(type3);
			System.out.println(myStore);
			System.out.println("Adding shoe type 4.");
			myStore.add(type4);
			System.out.println(myStore);
			System.out.println("The capacity of the store right now is " + myStore.getCapacity() + " types of shoes");
			System.out.println("The number of pairs of shoes in the store is " + myStore.getNumItems());
			System.out.println("Adding shoe type 5.");
			myStore.add(type5);
			System.out.println(myStore);
			System.out.println("Deleting shoe type 3.");
			myStore.delete(2);
			System.out.println(myStore);


			System.out.println("Adding shoe type 6, which is equal to type 4.");
			myStore.add(type6);
			System.out.println(myStore);
		}
		catch (ShoeException e)
		{
			System.out.println(e);
		}
		catch (CloneNotSupportedException e)
		{
			System.out.println("Unable to clone object.");
		}
	}
}