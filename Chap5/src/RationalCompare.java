//***********************************************************************************
//  Rajat Patel
//  Rational
//  2/27/2017
//  Used to represent rational numbers
//***********************************************************************************

public class RationalCompare implements Comparable
{
	private int numerator, denominator;
	
	//------------------------------------------------------------------------
	//	Sets up the rational number by ensuring a nonzero denominator and
	//	making only the numerator signed.
	//------------------------------------------------------------------------
	public RationalCompare(int numer,int denom)
	{
		if(denom == 0)
			denom = 1;
		
		//Make the numerator store the sign
		if(denom < 0)
		{
			numer *= -1;
			denom *= -1;
		}
		
		numerator = numer;
		denominator = denom;
		
		reduce();
	}
	
	//------------------------------------------------------------------------
	//	Returns the numerator.
	//------------------------------------------------------------------------
	public int getNumerator()
	{
		return numerator;
	}
	
	//------------------------------------------------------------------------
	//	Returns the denominator.
	//------------------------------------------------------------------------
	public int getDenominator()
	{
		return denominator;
	}
	
	//------------------------------------------------------------------------
	//	Returns the reciprocal.
	//------------------------------------------------------------------------
	public RationalCompare reciprocal()
	{
		return new RationalCompare(denominator,numerator);
	}
	
	//------------------------------------------------------------------------
	//	Adds this number to the one passed as a parameter.
	//------------------------------------------------------------------------
	public RationalCompare add(RationalCompare op2)
	{
		int commonDenominator = denominator*op2.getDenominator();
		int numerator1 = numerator*op2.getDenominator();
		int numerator2 = op2.getNumerator()*denominator;
		int sum = numerator1+numerator2;
		
		return new RationalCompare(sum,commonDenominator);
	}
	
	//------------------------------------------------------------------------
	//	Subtract the Rational passed as a parameter from this one.
	//------------------------------------------------------------------------
	public RationalCompare subtract(RationalCompare op2)
	{
		int commonDenominator = denominator*op2.getDenominator();
		int numerator1 = numerator*op2.getDenominator();
		int numerator2 = op2.getNumerator()*denominator;
		int difference = numerator1-numerator2;
		
		return new RationalCompare(difference,commonDenominator);
	}
	
	//------------------------------------------------------------------------
	//	Multiply the Rational passed as a parameter by this one.
	//------------------------------------------------------------------------
	public RationalCompare multiply(RationalCompare op2)
	{
		int numer = numerator*op2.getNumerator();
		int denom = denominator*op2.getDenominator();
		return new RationalCompare(numer,denom);
	}
	
	//------------------------------------------------------------------------
	//	Divide this Rational by the one passed as a parameter.
	//------------------------------------------------------------------------
	public RationalCompare divide(RationalCompare op2)
	{
		return multiply(op2.reciprocal());
	}
	
	//------------------------------------------------------------------------
	//	Compares this Rational to the one passed as a parameter.
	//------------------------------------------------------------------------
	public int compareTo(Object op2)
	{
		RationalCompare r2 = (RationalCompare) op2;
		if(equals(r2))
			return 0;
		if(((double)numerator)/denominator-((double)r2.getNumerator())/r2.getDenominator() > 0.0001)
			return 1;
		return -1;
	}
	
	//------------------------------------------------------------------------
	//	Determine if this rational number equals another one.
	//------------------------------------------------------------------------
	public boolean equals(RationalCompare op2)
	{
		return numerator==op2.getNumerator() && denominator==op2.getDenominator();
	}
	
	//------------------------------------------------------------------------
	//	Returns this rational number as a string.
	//------------------------------------------------------------------------
	public String toString()
	{
		String result;
		
		if(numerator == 0)
			result = "0";
		else
			if(denominator == 1)
				result = numerator+"";
			else
				result = numerator+"/"+denominator;
		return result;
	}
	
	//------------------------------------------------------------------------
	//	Reduces the numerator/denominator while maintaining the same value.
	//------------------------------------------------------------------------
	private void reduce()
	{
		if(numerator != 0)
		{
			int common = gcd(Math.abs(numerator),denominator);
			
			numerator /= common;
			denominator /= common;
		}
	}
	
	//------------------------------------------------------------------------
	//	Finds the GCD of 2 numbers using Euclid's algorithm.
	//------------------------------------------------------------------------
	private int gcd(int num1,int num2)
	{
		while(num1 != num2)
			if(num1 > num2)
				num1 = num1-num2;
			else
				num2 = num2-num1;
		
		return num1;
	}
}
