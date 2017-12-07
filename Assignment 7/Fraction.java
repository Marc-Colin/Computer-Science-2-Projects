public class Fraction
{
	private int numerator;
	private int denominator;
	private static int num3;
	private static int den3;
	private static int tempN3;
	private static int count;
	private int n1;
	private int n2;
	private int tempD;
	private int tempN;
	private double Dnum;
	private double Dden;
	private double decimal;
	private double percent;
	private String mixedNum;
	private int Mnum;
	private int Mden;
	private int wholeNum;
	private boolean signN;
	private boolean signD;
	private boolean sign;
	private int GCD;

	public Fraction(int n, int d) throws FractionException
	{
		setNumerator(n);
		setDenominator(d);
		checkSign();
		count++;
	}
	public Fraction(Fraction clone)
	{
		numerator = clone.numerator;
		denominator = clone.denominator;
		checkSign();
		count++;
	}
	public void setNumerator(int n)
	{
		if (n > 0)
		{
		 signN = true;
		}
		else
		{
		 signN = false;
		}
		numerator = n;
	}
	public int getNumerator()
	{
		return numerator;
	}
	public void setDenominator(int d) throws FractionException
	{
		if (d > 0)
		{
		 signD = true;
		}
		else
		{
		 signD = false;
		}
		if (d == 0 )
		{
		 throw new FractionException("Error. Attempt to set denominator to 0");
		}
		denominator = d;
	}
	public int getDenominator()
	{
		return denominator;
	}
	public String toString()
	{
	 GCD = GCD(numerator, denominator);
	 ReduceFraction(GCD);
	 if (sign == false)
	 {
	  return ("[-" +  java.lang.Math.abs(numerator) + "/" +  java.lang.Math.abs(denominator) + "]" );
	 }
	 else
	 {
	  return ("[+" +  java.lang.Math.abs(numerator) + "/" +  java.lang.Math.abs(denominator) + "]" );
	 }
	}
	public void checkSign()
	{
	 if (signN == false && signD == false)
	 {
	  sign = true;
	 }
	 else if (signN == false && signD == true)
	 {
	  sign = false;
	 }
	 else if (signN == true && signD == false)
	 {
	  sign = false;
	 }
	 else if (signN == true && signD == true)
	 {
	  sign = true;
	 }
	}
	public int GCD (int n, int d)
	{
		n1 = java.lang.Math.abs(n);
		n2 = java.lang.Math.abs(d);
		while (n1 != n2)
		{
			if (n1 > n2)
			{
				n1 = n1 - n2;
			}
			else
			{
				n2 = n2 - n1;
			}
		}
		GCD = n1;
		return GCD;
	}
	public void ReduceFraction(int x)
	{
		numerator = numerator / x;
		denominator = denominator / x;
    }
    public void opposite()
    {
		if (sign == true)
			sign = false;
		else
			sign = true;
	}
	public void inverse() throws FractionException
	{
		tempD = denominator;
		setDenominator(numerator);
		setNumerator(tempD);
	}
	public void add(Fraction k)
	{
		numerator = numerator * k.denominator;
		tempN = k.numerator * denominator;
		numerator = numerator + tempN;
		denominator = denominator * k.denominator;
	}
	public static Fraction add(Fraction f1, Fraction f2) throws FractionException
	{
		num3 = f1.numerator * f2.denominator;
		tempN3 = f2.numerator * f1.denominator;
		num3 = num3 + tempN3;
		den3 = f1.denominator * f2.denominator;
		Fraction f3 = new Fraction(num3, den3);
		count++;
		return f3;
	}
	public void subtract(Fraction k) throws FractionException
	{
		numerator = numerator * k.denominator;
		tempN = k.numerator * denominator;
		setNumerator(tempN - numerator);
		setDenominator(denominator * k.denominator);
		checkSign();
	}
	public static Fraction subtract(Fraction f1, Fraction f2) throws FractionException
	{
		num3 = f1.numerator * f2.denominator;
		tempN3 = f2.numerator * f1.denominator;
		num3 = num3 - tempN3;
		den3 = f1.denominator * f2.denominator;
		Fraction f3 = new Fraction(num3, den3);
		count++;
		return f3;
	}
	public void multiply(Fraction k) throws FractionException
	{
		setNumerator(numerator * k.numerator);
		setDenominator(denominator * k.denominator);
		checkSign();
	}
	public static Fraction multiply(Fraction f1, Fraction f2) throws FractionException
	{
		num3 = f1.numerator * f2.numerator;
		den3 = f1.denominator * f2.denominator;
		Fraction f3 = new Fraction(num3, den3);
		count++;
		return f3;
	}
	public void divide(Fraction k) throws FractionException
	{
		setNumerator(numerator * k.denominator);
		setDenominator(denominator * k.numerator);
		checkSign();
	}
	public static Fraction divide(Fraction f1, Fraction f2) throws FractionException
	{
		num3 = f1.numerator * f2.denominator;
		den3 = f1.denominator * f2.numerator;
		Fraction f3 = new Fraction(num3, den3);
		count++;
		return f3;
	}
	public static int getCount()
	{
		return count;
	}
	public double toDouble()
	{
		Dnum = numerator;
		Dden = denominator;
		decimal = (Dnum / Dden);
		return decimal;
	}
	public double toPercent()
	{
		percent = toDouble();
		percent = percent * 100;
		return percent;
	}
	public String toMixed()
	{
		Mnum = java.lang.Math.abs(numerator);
		Mden = java.lang.Math.abs(denominator);
		wholeNum = (Mnum / Mden);
		Mnum = (Mnum % Mden);
		if (sign == true)
		{
			mixedNum = ("[+" + wholeNum + " " + Mnum + "/" + Mden + "]");
		}
		else if (sign == false)
		{
			mixedNum = ("[-" + wholeNum + " " + Mnum + "/" + Mden + "]");
		}
		return mixedNum;
	}
}