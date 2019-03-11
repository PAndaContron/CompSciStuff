package dataStructures;

import java.util.NoSuchElementException;

public class LinkedListQueue<T>
{
	private Node<T> first, last;
	
	public LinkedListQueue()
	{
		first = null;
		last = first;
	}
	
	public T dequeue()
	{
		if(first == null)
			throw new NoSuchElementException();
		
		T value = first.getData();
		first = first.getNext();
		
		if(first == null)
			last = null;
		
		return value;
	}
	
	public boolean enqueue(T data)
	{
		Node<T> newNode = new Node<>(data);
		
		if(first == null)
			first = newNode;
		else
			last.setNext(newNode);
		last = newNode;
		
		return true;
	}
}
