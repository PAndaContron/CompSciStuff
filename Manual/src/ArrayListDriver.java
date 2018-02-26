//***********************************************************************************
//  Rajat Patel
//  Array List
//  11/3/2017
//  A copy of Java ArrayList
//***********************************************************************************

import java.util.LinkedList;
import java.util.Random;

public class ArrayListDriver 
{
	public static void main(String[] args)
	{
		MyArrayList<Integer> list = new MyArrayList<Integer>();
		
		//Add & Reallocate
		Random generator = new Random();
		for(int i=0;i<21;i++)
			list.add(new Integer(generator.nextInt()));
		
		System.out.println("*****************************************************\nOriginal list:");
		
		//Print
		list.print();
		
		System.out.println("*****************************************************\nInserting 5 at index 3:");
		
		//Add at index
		list.add(3,new Integer(5));
		list.print();
		
		System.out.println("*****************************************************\nAdding 6 as the first element:");
		
		//Add First
		list.addFirst(new Integer(6));
		list.print();
		
		System.out.println("*****************************************************\nRemoving the last element:");
		
		//Remove
		System.out.println(list.remove());
		list.print();
		
		System.out.println("*****************************************************\nRemoving the element at index 3:");
		
		//Remove at index
		System.out.println(list.remove(3));
		list.print();
		
		System.out.println("*****************************************************\nSetting index 0 to 2:");
		
		//Set
		list.set(0,new Integer(2));
		list.print();
		
		System.out.println("*****************************************************\nCloning the list then printing out both:");
		
		//Clone
		MyArrayList<Integer> list2 = list.clone();
		list.print();
		list2.print();
		
		System.out.println("*****************************************************\nGetting the element at index 2:");
		
		//Get
		System.out.println(list.get(2));
		
		System.out.println("*****************************************************\nChecking if 2 is in the list:");
		
		//Contains
		System.out.println(list.contains(new Integer(2)));
		
		System.out.println("*****************************************************\nForeach loop to demonstrate iterator:");
		
		//Iterator
		System.out.println("Using print method: "+list+"\nUsing foreach:");
		for(Integer i : list)
			System.out.println(i);
		
		System.out.println("*****************************************************\nClearing the whole list:");
		
		//Clear
		list.clear();
		System.out.println("List size: " + list.size());
		
		LinkedList<String> lList = new LinkedList<String>();
		lList.
	}
}
