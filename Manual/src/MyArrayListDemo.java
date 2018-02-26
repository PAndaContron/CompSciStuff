//try{thing that throws exception;}
//catch(Exception e){System.out.println(e);}

//***********************************************************************************
//  Rajat Patel
//  Array List
//  11/3/2017
//  A copy of Java ArrayList
//***********************************************************************************

public class MyArrayListDemo 
{

	public static void main(String[] args) 
	{
		System.out.println("Assignment 1:");
		MyArrayList listRawString = new MyArrayList();
		String[] arrayString = {"Namath","Sauer","Lammons","Maynard","Bouzer","Snell","Atkinson","Dockery","Ewback","Elliot","Grantham","Herman","Hill","Biggs","Parker","Rasmussen","Philbin","Gordon","Richards","Finnie"};
		for(Object o : arrayString)
			listRawString.add(o);
		System.out.println("Raw ArrayList:");
		for(Object o : listRawString)
			System.out.println(((String)o).toUpperCase());
		System.out.println();
		
		MyArrayList<String> listString = new MyArrayList<String>();
		for(String s : arrayString)
			listString.add(s);
		System.out.println("Generic ArrayList:");
		for(String s : listString)
			System.out.println(s.toUpperCase());
		
		arrayString = null;
		listRawString = null;
		
		System.out.println();
		
		MyArrayList<Integer> listInteger = new MyArrayList<Integer>();
		MyArrayList<String> listIntString = new MyArrayList<String>();
		
		for(int i=0;i<25;i++)
		{
			listInteger.add(new Integer(i));
			listIntString.add(listInteger.get(i).toString());
		}
		
		System.out.println("Integer List: "+listInteger);
		System.out.println("String List: "+listIntString);
		
		System.out.println("******************************************************************************************\nAssignment 2:");
		
		try{System.out.println(listString.remove(-1));}
		catch(Exception e){System.out.println(e);}
		System.out.println(listString.remove(0));
		System.out.println(listString.remove(3));
		System.out.println(listString.remove(5));
		try{System.out.println(listString.remove(25));}
		catch(Exception e){System.out.println(e);}
		listString.add("Gill");
		System.out.println("Final list: "+listString);
		
		System.out.println("******************************************************************************************\nAssignment 3");
		
		try{listString.add(-2,"Joe");}
		catch(Exception e){System.out.println(e);}
		listString.add(0,"Bill");
		listString.add(5,"Unitas");
		listString.add(12,"Smith");
		int num = listString.size();
		listString.add(num,"Gill");
		try{listString.add(101,"Bradley");}
		catch(Exception e){System.out.println(e);}
		
		for(String s : listString)
			System.out.println(s.toUpperCase());
		
		System.out.println("******************************************************************************************\nAssignment 4");
		
		System.out.println(listString.set(9,"Sam"));
		System.out.println(listString.set(5,"Namath"));
		try{System.out.println(listString.set(18,"Manning"));}
		catch(Exception e){System.out.println(e);}
		try{System.out.println(listString.set(22,"Rivers"));}
		catch(Exception e){System.out.println(e);}
		try{System.out.println(listString.set(50,"Bond"));}
		catch(Exception e){System.out.println(e);}
		for(String s : listString)
			System.out.println(s.toLowerCase());
		
		System.out.println("******************************************************************************************\nAssignment 5");
		
		System.out.println(listString.remove("Sansa"));
		System.out.println(listString.remove("Herman"));
		System.out.println(listString.remove("Namath"));
		for(String s : listString)
			System.out.println(s.toUpperCase());
	}

}

/*
Assignment 1:
Running "reallocate"
Raw ArrayList:
NAMATH
SAUER
LAMMONS
MAYNARD
BOUZER
SNELL
ATKINSON
DOCKERY
EWBACK
ELLIOT
GRANTHAM
HERMAN
HILL
BIGGS
PARKER
RASMUSSEN
PHILBIN
GORDON
RICHARDS
FINNIE

Running "reallocate"
Generic ArrayList:
NAMATH
SAUER
LAMMONS
MAYNARD
BOUZER
SNELL
ATKINSON
DOCKERY
EWBACK
ELLIOT
GRANTHAM
HERMAN
HILL
BIGGS
PARKER
RASMUSSEN
PHILBIN
GORDON
RICHARDS
FINNIE

Running "reallocate"
Running "reallocate"
Running "reallocate"
Running "reallocate"
Integer List: [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24]
String List: [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24]
******************************************************************************************
Assignment 2:
java.lang.IndexOutOfBoundsException: Index: -1 Size: 20
Namath
Bouzer
Dockery
java.lang.IndexOutOfBoundsException: Index: 25 Size: 17
Final list: [Sauer, Lammons, Maynard, Snell, Atkinson, Ewback, Elliot, Grantham, Herman, Hill, Biggs, Parker, Rasmussen, Philbin, Gordon, Richards, Finnie, Gill]
******************************************************************************************
Assignment 3
java.lang.IndexOutOfBoundsException: Index: -2 Size: 18
java.lang.IndexOutOfBoundsException: Index: 101 Size: 18
BILL
SAUER
LAMMONS
MAYNARD
SNELL
UNITAS
ATKINSON
EWBACK
ELLIOT
GRANTHAM
HERMAN
HILL
SMITH
BIGGS
PARKER
RASMUSSEN
PHILBIN
GORDON
******************************************************************************************
Assignment 4
Grantham
Unitas
java.lang.IndexOutOfBoundsException: Index: 18 Size: 18
java.lang.IndexOutOfBoundsException: Index: 22 Size: 18
java.lang.IndexOutOfBoundsException: Index: 50 Size: 18
bill
sauer
lammons
maynard
snell
namath
atkinson
ewback
elliot
sam
herman
hill
smith
biggs
parker
rasmussen
philbin
gordon
******************************************************************************************
Assignment 5
false
true
true
BILL
SAUER
LAMMONS
MAYNARD
SNELL
ATKINSON
EWBACK
ELLIOT
SAM
HILL
SMITH
BIGGS
PARKER
RASMUSSEN
PHILBIN
GORDON

*/