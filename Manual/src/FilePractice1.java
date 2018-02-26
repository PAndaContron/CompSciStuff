//***********************************************************************************
//  Rajat Patel
//  FilePractice1
//  12/13/2017
//***********************************************************************************

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class FilePractice1 
{

	public static void main(String[] args)  throws FileNotFoundException
	{
		Scanner scan = new Scanner(new File("FilePractice2.txt"));
		while(scan.hasNextLine())
		{
			String s = scan.nextLine();
			System.out.println(s);
			StringTokenizer tokenizer = new StringTokenizer(s);
			int sum = 0,count=0;
			while(tokenizer.hasMoreTokens())
			{
				sum += Integer.parseInt(tokenizer.nextToken());
				count++;
			}
			System.out.println(" The average is: "+sum/count);
		}
		scan.close();
	}

}
