package chapter6;

public class Proj6_7 
{

	public static void main(String[] args) 
	{
		System.out.println("Length\tWidth\tArea\tPerimeter");
		for(int i = 1; i < 11; i++)
		{
			for(int j = 1; j < 11; j++)
			{
				System.out.println(i+"ft.\t" + j+"ft.\t" + i*j+"sq. ft.\t" + 2*(i+j)+"ft.\t");
			}
		}
	}

}
