package dataStructures;

import java.util.EmptyStackException;

public class LinkedListStack<T>
{
	private Node<T> first;
	
	public LinkedListStack()
	{
		first = null;
	}
	
	public T pop()
	{
		if(first == null)
			throw new EmptyStackException();
		
		T value = first.getData();
		first = first.getNext();
		return value;
	}
	
	public boolean push(T data)
	{
		first = new Node<>(data, first);
		return true;
	}
}
