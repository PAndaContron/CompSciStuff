package vbInterface;

import java.io.Serializable;

public class Test implements Serializable
{
	private static final long serialVersionUID = 1L;

	public static void staticPrint(String s)
	{
		System.out.println(s);
	}
	
	public static void staticPrint()
	{
		System.out.println("Hello world!");
	}
	
	public static String staticEcho(String s)
	{
		return s;
	}
	
	private String s;
	
	public Test(String str)
	{
		s = str;
	}
	
	public void print(String s)
	{
		print();
		System.out.println(s);
	}
	
	public void print()
	{
		System.out.println(s);
	}
	
	public String echo(String s)
	{
		return s;
	}
}
