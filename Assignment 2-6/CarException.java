public class CarException extends Exception
{
	private String message;
//error constructor
	public CarException(String m)
	{
		message = m;
	}
	public String getMessage()
	{
		return message;
	}
}