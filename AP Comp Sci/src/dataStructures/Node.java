package dataStructures;

public class Node<T>
{
	private T data;
	private Node<T> next;
	
	public Node()
	{
		this(null);
	}
	
	public Node(T data)
	{
		this(data, null);
	}
	
	public Node(T data, Node<T> next)
	{
		this.data = data;
		this.next = next;
	}
	
	public T getData()
	{
		return data;
	}
	
	public Node<T> getNext()
	{
		return next;
	}
	
	public void setNext(Node<T> next)
	{
		this.next = next;
	}
}