package chapter5;

public class Proj5_3 
{

	public static void main(String[] args) 
	{
		Fraction f1 = new Fraction(1, 2);
		Fraction f2 = new Fraction(2, 4);
		Fraction f3 = new Fraction(5, 2);
		Fraction f4 = new Fraction(0, 2);
		
		System.out.println("f1:\t" + f1);
		System.out.println("f2:\t" + f2);
		System.out.println("f3:\t" + f3);
		System.out.println("f4:\t" + f4);
		System.out.println("f1+f2:\t" + f1.add(f2));
		System.out.println("f3-f2:\t" + f3.subtract(f2));
		System.out.println("f1/f3:\t" + f1.divide(f3));
		System.out.println("f1*f4:\t" + f1.multiply(f4));
	}

	private static class Fraction
	{
		private int numerator;
		private int denominator;
		
		public Fraction(int num, int den)
		{
			if(den==0)
				throw new IllegalArgumentException();
			numerator = num;
			denominator = den;
			simplify();
		}
		
		public int getNumerator()
		{
			return numerator;
		}
		
		public int getDenominator()
		{
			return denominator;
		}
		
		public Fraction add(Fraction other)
		{
			return new Fraction(numerator*other.getDenominator() + denominator*other.getNumerator(),
					denominator*other.getDenominator());
		}
		
		public Fraction subtract(Fraction other)
		{
			return new Fraction(numerator*other.getDenominator() - denominator*other.getNumerator(),
					denominator*other.getDenominator());
		}
		
		public Fraction multiply(Fraction other)
		{
			return new Fraction(numerator*other.getNumerator(), denominator*other.getDenominator());
		}
		
		public Fraction divide(Fraction other)
		{
			return multiply(other.reciprocal());
		}
		
		public Fraction reciprocal()
		{
			return new Fraction(denominator, numerator);
		}
		
		public String toString()
		{
			return numerator + "/" + denominator;
		}
		
		private void simplify()
		{
			if(numerator*denominator > 0)
				numerator = Math.abs(numerator);
			else
				numerator = -Math.abs(numerator);
			denominator = Math.abs(denominator);
			
			if(numerator != 0)
			{
				int common = gcd(Math.abs(numerator),denominator);
				
				numerator /= common;
				denominator /= common;
			}
		}
		
		private static int gcd(int num1,int num2)
		{
			while(num1 != num2)
				if(num1 > num2)
					num1 -= num2;
				else
					num2 -= num1;
			return num1;
		}
	}
}
