package chapter12;

public class Proj12_1 
{

	public static void main(String[] args) 
	{
		for(int i=1; i<=10; i++)
		{
			for(int j=1; j<i; j++)
			{
				System.out.printf("The gcd of %d and %d is %d%n", i, j, gcd(j, i));
			}
		}
	}
	
	public static int gcd(int greater, int lower)
	{
		return lower==0 ? greater : gcd(lower, greater % lower);
	}
}
