//***********************************************************************************
//  Rajat Patel
//  Final Recursion
//  10/12/2017
//  Combines & shows all recursion and stringBuilder methods
//***********************************************************************************

import java.util.Scanner;
import java.util.StringTokenizer;

public class RecursionFinal 
{

	public static void main(String[] args) 
	{
		int[] a = {10,20,30,40,50,60,70,80,90,100};
		System.out.print("Original Array: ");	printArray(a);
		reverseArray(a,0,a.length-1);
		System.out.print("Reversed Array: ");	printArray(a);
		selectionSort(a);
		System.out.print("Sorted Array: ");	printArray(a);
		System.out.println("Index of 20 in sorted array: " + binarySearch(20,a,0,a.length-1));
		System.out.println("Index of 35 in sorted array: " + binarySearch(35,a,0,a.length-1));
		
		System.out.println("\n**************************************************************************\n");
		
		System.out.println("Factorial of 8 using factorial_1: " + factorial_1(8));
		System.out.println("Factorial of 6 using factorial_2: " + factorial_2(6,1));
		System.out.println("Sum of all positive integers <= 7: " + sum(7));
		
		System.out.println("\n**************************************************************************\n");
		
		String s1 = "racecar", s2 = "computer";
		System.out.println("Checking if \"racecar\" is a palindrome with method 1: " + palindrome_1(s1,0,s1.length()-1));
		System.out.println("Checking if \"computer\" is a palindrome with method 1: " + palindrome_1(s2,0,s2.length()-1));
		System.out.println("Checking if \"racecar\" is a palindrome with method 2: " + palindrome_2(s1));
		System.out.println("Checking if \"computer\" is a palindrome with method 2: " + palindrome_2(s2));
		
		System.out.println("\n**************************************************************************\n");
		
		String s3 = "I, have not.'yet!begun to/fight";
		System.out.println("Original String: "+s3);
		System.out.println("Removing punctuation with stringBuilder1: " + stringBuilder1(s3));
		System.out.println("Removing punctuation with stringBuilder2: " + stringBuilder2(s3));
		System.out.println("Removing punctuation with stringBuilder3: " + stringBuilder3(s3));
	}

	public static void printArray(int[] array)
	{
		for(int i=0;i<array.length;i++)
			System.out.print(array[i]+" ");
		System.out.println();
	}

	public static void reverseArray(int[] array, int i, int j)
	{
		if(i<j)
		{
			int temp = array[i];
			array[i] = array[j];
			array[j] = temp;
			
			i++;
			j--;
		}
		else
			return;
		reverseArray(array,i,j);
	}

	public static void selectionSort(int[] array)
	{
		for(int i=0;i<array.length;i++)
		{
			int least = array[i];
			int leastJ = i;
			for(int j=i+1;j<array.length;j++)
				if(array[j]<least)
				{
					least=array[j];
					leastJ=j;
				}	
			int temp = array[i];
			array[i] = array[leastJ];
			array[leastJ] = temp;
		}
	}

	public static int binarySearch(int num,int[] array,int start,int end)
	{
		int middle = (start+end)/2;
		
		if(start==middle)
			if(num==array[start])
				return start;
			else if(num==array[end])
				return end;
			else
				return -1;
		
		if(num==array[middle])
			return middle;
		if(num<array[middle])
			return binarySearch(num,array,start,middle);
		return binarySearch(num,array,middle,end);
	}

	public static int factorial_1(int n)
	{
		if(n==1)
			return 1;
		else
			return n*factorial_1(n-1);
	}

	public static int factorial_2(int i,int running)
	{
		if(i==0)
			return running;
		return factorial_2(i-1,running*i);
	}

	public static int sum(int n)
	{
		if(n==1)
			return 1;
		else
			return n+sum(n-1);
	}

	public static boolean palindrome_1(String s, int i, int j)
	{
		if(i>=j)
			return true;
		if(s.charAt(i)!=s.charAt(j))
			return false;
		i++;
		j--;
		
		return palindrome_1(s,i,j);
	}

	public static boolean palindrome_2(String s)
	{
		int i = 0,j = s.length();
		if(s.length()==1||(s.length()==2 && s.charAt(0)==s.charAt(1)))
			return true;
		if(s.charAt(i)!=s.charAt(j-1))
			return false;
		return palindrome_2(s.substring(i+1,j-1));
	}

	public static String stringBuilder1(String str)
	{
		String output = "";
		
		for(int i=0;i<str.length();i++)
		{
			int current = str.charAt(i);
			
			if(current>=65 && current<=90)			//Capital letters
				output += (char)current;
			else if(current>=97 && current<=122)	//Lowercase letters
				output += (char)current;
			else if(current>=48 && current<=57)		//Digits
				output += (char)current;
			else if(current==32 || current==10 || current==9 || current==13)	//Whitespace
				output += (char)current;
		}
		
		return output;
	}
	
	public static String stringBuilder2(String str)
	{
		String output = "";
		StringTokenizer token = new StringTokenizer(str,"\\\"\'!@#$%^&*(),./;[]<>?:{}|-=_+`~");
		
		while(token.hasMoreTokens())
			output += token.nextToken();
		
		return output;
	}
	
	public static String stringBuilder3(String str)
	{
		String output = "";
		Scanner scan = new Scanner(str);
		scan.useDelimiter("[\\\\\\\"\\\'!@#\\$%\\^&\\*\\(\\)\\,\\./;\\[\\]<>\\?:\\{\\}\\|\\-=_\\+`~]");
		
		while(scan.hasNext())
			output += scan.next();
		
		scan.close();
		return output;
	}
	
	/* Output:
	Original Array: 10 20 30 40 50 60 70 80 90 100 
	Reversed Array: 100 90 80 70 60 50 40 30 20 10 
	Sorted Array: 10 20 30 40 50 60 70 80 90 100 
	Index of 20 in sorted array: 1
	Index of 35 in sorted array: -1
	
	 **************************************************************************
	
	Factorial of 8 using factorial_1: 40320
	Factorial of 6 using factorial_2: 720
	Sum of all positive integers <= 7: 28
	
	**************************************************************************
	
	Checking if "racecar" is a palindrome with method 1: true
	Checking if "computer" is a palindrome with method 1: false
	Checking if "racecar" is a palindrome with method 2: true
	Checking if "computer" is a palindrome with method 2: false
	
	**************************************************************************
	
	Original String: I, have not.'yet!begun to/fight
	Removing punctuation with stringBuilder1: I have notyetbegun tofight
	Removing punctuation with stringBuilder2: I have notyetbegun tofight
	Removing punctuation with stringBuilder3: I have notyetbegun tofight
	
	*/
}
