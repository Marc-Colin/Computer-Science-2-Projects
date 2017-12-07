public class FractionException extends Exception
{
	private String message;

	public FractionException( String m)
	{
		message = m;
	}
	public String getMessage()
	{
		return message;
	}
}