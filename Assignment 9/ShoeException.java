public class ShoeException extends Exception
{
	private String message;
	public ShoeException(String m)
	{
		message = m;
	}
	public String toString()
	{
		return message;
	}
}