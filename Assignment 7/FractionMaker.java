public class FractionMaker
{
 public static void main(String[] args)
 {
  try
  {
	int GCD;

  	Fraction f1 = new Fraction( 2 , 3 );
	Fraction f2 = new Fraction( 3 , -4 );
	Fraction f3 = Fraction.add( f1 , f2 );
	System.out.println("The sum is: " + f3 );

	Fraction k = new Fraction( 1 , 7 );
	Fraction r = new Fraction( 4 , 5 );
	r.subtract( k );
	System.out.println("r is: " + r );
	System.out.println("k is: " + k );

	Fraction b = new Fraction( -14 , 7 );
	Fraction s = new Fraction( 11 , 3 );
	Fraction result = Fraction.subtract( b , s );
	System.out.println("Result is: " + result );

	Fraction m = new Fraction( 1 , 4 );
	double q = m.toDouble( );
	System.out.println("q is: " + q );

	Fraction a = new Fraction( 1 , 4 );
	System.out.println("fraction m, expressed as percent is: " +
	a.toPercent() + "%" );

	Fraction y = new Fraction( 10 , 4 );
	System.out.println("Fraction m, expressed as a mixed fraction: " +
	y.toMixed() );
	Fraction d = new Fraction( 5 , -7 );
	System.out.println("Fraction q, expressed as a mixed fraction: " +
	d.toMixed() );

  }
  catch(FractionException e)
  {
	System.out.println(e.getMessage());
  }
 }
}