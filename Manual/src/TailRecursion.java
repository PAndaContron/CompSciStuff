//***********************************************************************************
//  Rajat Patel
//  Tail Recursion
//  9/20/2017
//  Several methods that may or may not have to do with Tail Recursion
//***********************************************************************************

public class TailRecursion 
{
	public static void main(String[] args) 
	{
		//factorialTailRec
		System.out.println(factorialTailRec(5,1));
		
		System.out.println("\n\n\n\n");
		
		//reverseArray
		int[] array1 = {1,2,3,4,5};
		int[] array2 = {1,2,3,4,5,6};
		
		for(int i=0;i<5;i++)
			System.out.println(array1[i]);
		System.out.println();
		for(int i=0;i<6;i++)
			System.out.println(array2[i]);
		
		reverseArray(array1,0,4);
		reverseArray(array2,0,5);
		
		System.out.println("\n\n");
		
		for(int i=0;i<5;i++)
			System.out.println(array1[i]);
		System.out.println();
		for(int i=0;i<6;i++)
			System.out.println(array2[i]);
		
		System.out.println("\n\n\n\n");
		
		//palindrome
		String string1 = "aba";
		String string2 = "abba";
		String string3 = "abbba";
		String string4 = "abc";
		String string5 = "abbc";
		String string6 = "abbbc";
		
		System.out.println(palindrome(string1,0,2));
		System.out.println(palindrome(string2,0,3));
		System.out.println(palindrome(string3,0,4));
		System.out.println(palindrome(string4,0,2));
		System.out.println(palindrome(string5,0,3));
		System.out.println(palindrome(string6,0,4));
		
		System.out.println();
		
		System.out.println(palindrome(string1));
		System.out.println(palindrome(string2));
		System.out.println(palindrome(string3));
		System.out.println(palindrome(string4));
		System.out.println(palindrome(string5));
		System.out.println(palindrome(string6));
		
		System.out.println("\n\n\n\n");
		
		//binarySearch
		int[] odd = {78,23,56,34,37};
		int[] odd1 = {64,76,64,73,56};
		int[] even = {78,23,56,34,37,89};
		int[] even1 = {64,76,64,73,56,89};
		
		System.out.println("odd");
		System.out.println(binarySearch(78,odd,0,4));
		System.out.println(binarySearch(56,odd,0,4));
		System.out.println(binarySearch(88,odd,0,4));
		
		System.out.println();

		System.out.println("odd1");
		System.out.println(binarySearch(64,odd1,0,4));
		System.out.println(binarySearch(73,odd1,0,4));
		System.out.println(binarySearch(88,odd1,0,4));
		
		System.out.println();

		System.out.println("even");
		System.out.println(binarySearch(78,even,0,5));
		System.out.println(binarySearch(56,even,0,5));
		System.out.println(binarySearch(88,even,0,5));
		
		System.out.println();

		System.out.println("even1");
		System.out.println(binarySearch(64,even1,0,5));
		System.out.println(binarySearch(73,even1,0,5));
		System.out.println(binarySearch(88,even1,0,5));
	}
	
	public static int factorialTailRec(int i,int running)
	{
		if(i==0)
			return running;
		return factorialTailRec(i-1,running*i);
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
	
	public static boolean palindrome(String s, int i, int j)
	{
		if(i>=j)
			return true;
		if(s.charAt(i)!=s.charAt(j))
			return false;
		i++;
		j--;
		
		return palindrome(s,i,j);
	}
	
	public static boolean palindrome(String s)
	{
		int i = 0,j = s.length();
		if(s.length()==1||(s.length()==2 && s.charAt(0)==s.charAt(1)))
			return true;
		if(s.charAt(i)!=s.charAt(j-1))
			return false;
		return palindrome(s.substring(i+1,j-1));
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
}
