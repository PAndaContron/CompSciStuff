package chapter12;

public class Proj12_4 
{

	public static void main(String[] args) 
	{
		for(int n=1; n<=10; n++)
		{
			for(int k=0; k<=n; k++)
			{
				System.out.printf("%d choose %d is %d%n", n, k, choose(n, k));
			}
		}
	}
	
	private static int choose(int n, int k)
	{
		if(k==0 || k==n)
			return 1;
		return choose(n-1, k-1) + choose(n-1, k);
	}

}
