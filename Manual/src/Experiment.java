import java.util.*;
public class Experiment 
{

	public static void main(String[] args) 
	{
		MyArrayList<String> list = new MyArrayList<String>();
		list.add("Jim");
		list.add("Sam");
		list.add("Paul");
		list.add("Kelsey");
		
		for(int i=0;i<list.size();i++)
			System.out.println(list.get(i).toUpperCase());
	}

}
