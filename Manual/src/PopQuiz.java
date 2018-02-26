
public class PopQuiz 
{

	public static void main(String[] args) 
	{
		int i;
		int[] x = new int[12];
		
		for(i=0;i<x.length;i++)
		{
			x[i] = i +1;
		}
		
		i=1;
		while(i<x.length/2)
		{
			x[i] = x[i*2];
			i = i*2;
		}
		
		for(i = x.length-1;i>=0;i=i-1)
		{
			System.out.print(x[i] + " ");
		}
		System.out.println();
		
		int y = 0;
		for(i = 0;i<x.length;i=i+2)
			y = y+x[i];
		System.out.println(y);
	}

}
