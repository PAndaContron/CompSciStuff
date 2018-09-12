package chapter12;

public class Proj12_6 
{
	private static int calls;

	public static void main(String[] args) 
	{
		System.out.printf("%-10s%-20s%n", "Rings", "Calls");
		for(int i=1; i<64; i++)
		{
			calls = 0;
			move(i, 1, 3, 2);
			System.out.printf("%-10d%-20d%n", i, calls);
		}
	}

	private static void move(int n, int i, int j, int k)
	{
		if(n > 0)
		{
			move(n - 1, i, k, j);
			calls++;
			move(n - 1, k, j, i);
		}
	}
}
