//***********************************************************************************
//  Rajat Patel
//  Linked List Driver
//  9/12/2017
//  Demonstrates MyLinkedList
//***********************************************************************************

public class LinkedListDriver 
{

	public static void main(String[] args) 
	{
		MyLinkedList<String> list = new MyLinkedList<String>();
		
		list.add("Namath");
		list.add("Sauer");
		list.add("Maynard");
		list.add("Snell");
		list.add("Dockery");
		list.add("Atkinson");
		list.add("Sample");
		list.add("Biggs");
		
		System.out.println("**********************************************\nGet Method:");
		
		try{System.out.println(list.get(-1));}
		catch(Exception e){System.out.println(e);}
		try{System.out.println(list.get(100));}
		catch(Exception e){System.out.println(e);}
		try{System.out.println(list.get(list.size()));}
		catch(Exception e){System.out.println(e);}

		list.resetCounterGet();
		list.resetCounterToString();
		
		System.out.println("\n**********************************************\ntoString vs. get Method (efficiency):");
		
		System.out.println(list);
		
		for(int i=0;i<list.size();i++)
			System.out.println(i%2==0 ? list.get(i).toUpperCase() : list.get(i).toLowerCase());
		
		System.out.println("\"get\" iterations: "+list.counterGet());
		System.out.println("\"toString\" iterations: "+list.counterToString());
		
		System.out.println("\n**********************************************\ntoStringMemory Method:");
		
		System.out.println(list.toStringMemory());
		
		System.out.println("\n**********************************************\nAdd Method:");
		
		list.addFirst("Gill");
		list.add(0, "Bradshaw");
		list.add(10, "Swann");
		list.add(4, "Lambert");
		list.add(7, "Tatum");
		list.add(10, "Harris");
		
		try{list.add(-4, "Monday");}
		catch(IllegalArgumentException e){System.out.println(e);}
		catch(IndexOutOfBoundsException e){System.out.println(e);}
		try{list.add(1000, "Tuesday");}
		catch(IllegalArgumentException e){System.out.println(e);}
		catch(IndexOutOfBoundsException e){System.out.println(e);}
		list.println();
		
		System.out.println("\n**********************************************\nRemove Method:");
		
		try{list.remove(-5);}
		catch(IllegalArgumentException e){System.out.println(e);}
		catch(IndexOutOfBoundsException e){System.out.println(e);}
		try{list.remove(1000);}
		catch(IllegalArgumentException e){System.out.println(e);}
		catch(IndexOutOfBoundsException e){System.out.println(e);}
		try{list.remove(list.size());}
		catch(IllegalArgumentException e){System.out.println(e);}
		catch(IndexOutOfBoundsException e){System.out.println(e);}
		
		System.out.println(list.remove(0));
		System.out.println(list.remove(list.size()-1));
		System.out.println(list.remove(2));
		System.out.println(list.remove(5));
		System.out.println(list.remove(7));
		System.out.println(list.remove(0));
		
		list.println();
		
		System.out.println("\n**********************************************\nTesting the Set Method:");
		
		System.out.println(list.set(0, "Bradshaw"));
		System.out.println(list.set(2, "Swann"));
		System.out.println(list.set(list.size()-1, "Harris"));
		System.out.println(list.set(4, "Stallworth"));
		try{System.out.println(list.set(list.size(), "Gill"));}
		catch(Exception e){System.out.println(e);}
		try{System.out.println(list.set(-2, "Gill"));}
		catch(Exception e){System.out.println(e);}
		
		list.println();
	}

}
