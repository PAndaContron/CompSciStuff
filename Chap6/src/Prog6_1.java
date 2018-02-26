//***********************************************************************************
//  Rajat Patel
//  Prog6_1
//  4/26/2017
//  Lets the user enter in numbers and counts how many times each is entered.
//***********************************************************************************

import java.util.Scanner;

public class Prog6_1 
{

	public static void main(String[] args) 
	{
		//Scanner object
		Scanner scan = new Scanner(System.in);
		
		//Variables
		boolean again = true;
		
		//Counting array
		int[] numEntered = new int[51];
		for(int i=0;i<51;i++)
			numEntered[i] = 0;
		
		//Prompt the user for input
		while(again)
		{
			System.out.print("Enter a number from 0 to 50 inclusive. ");
			numEntered[scan.nextInt()]++;
			System.out.print("Enter another number? (y/n) ");
			again = scan.next().equals("y");
		}
		
		//Print the output
		System.out.println("Number\tTimes Entered");
		for(int i=0;i<51;i++)
			System.out.println(i+"\t"+numEntered[i]);
		
		scan.close();
	}

}
/*
Enter a number from 0 to 50 inclusive. 14
Enter another number? (y/n) y
Enter a number from 0 to 50 inclusive. 16
Enter another number? (y/n) y
Enter a number from 0 to 50 inclusive. 2
Enter another number? (y/n) y
Enter a number from 0 to 50 inclusive. 3
Enter another number? (y/n) y
Enter a number from 0 to 50 inclusive. 5
Enter another number? (y/n) y
Enter a number from 0 to 50 inclusive. 16
Enter another number? (y/n) y
Enter a number from 0 to 50 inclusive. 28
Enter another number? (y/n) y
Enter a number from 0 to 50 inclusive. 50
Enter another number? (y/n) y
Enter a number from 0 to 50 inclusive. 1
Enter another number? (y/n) y
Enter a number from 0 to 50 inclusive. 2
Enter another number? (y/n) y
Enter a number from 0 to 50 inclusive. 33
Enter another number? (y/n) y
Enter a number from 0 to 50 inclusive. 16
Enter another number? (y/n) y
Enter a number from 0 to 50 inclusive. 1
Enter another number? (y/n) y
Enter a number from 0 to 50 inclusive. 2
Enter another number? (y/n) y
Enter a number from 0 to 50 inclusive. 50
Enter another number? (y/n) y
Enter a number from 0 to 50 inclusive. 42
Enter another number? (y/n) y
Enter a number from 0 to 50 inclusive. 48
Enter another number? (y/n) y
Enter a number from 0 to 50 inclusive. 50
Enter another number? (y/n) y
Enter a number from 0 to 50 inclusive. 1
Enter another number? (y/n) y
Enter a number from 0 to 50 inclusive. 16
Enter another number? (y/n) n
Number	Times Entered
0	0
1	3
2	3
3	1
4	0
5	1
6	0
7	0
8	0
9	0
10	0
11	0
12	0
13	0
14	1
15	0
16	4
17	0
18	0
19	0
20	0
21	0
22	0
23	0
24	0
25	0
26	0
27	0
28	1
29	0
30	0
31	0
32	0
33	1
34	0
35	0
36	0
37	0
38	0
39	0
40	0
41	0
42	1
43	0
44	0
45	0
46	0
47	0
48	1
49	0
50	3
*/