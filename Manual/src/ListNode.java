//***********************************************************************************
//  Rajat Patel
//  List Node
//  9/12/2017
//  A single node of a linked list
//***********************************************************************************

public class ListNode<Type>
{
	private Type value;
	private ListNode<Type> next;
	
	public ListNode(Type initObj, ListNode<Type> initNext)
	{
		value = initObj;
		next = initNext;
	}
	
	public Type getValue()
	{
		return value;
	}
	
	public ListNode<Type> getNext()
	{
		return next;
	}
	
	public void setValue(Type newValue)
	{
		value = newValue;
	}
	
	public void setNext(ListNode<Type> newNext)
	{
		next = newNext;
	}
	
	public ListNode<Type> clone()
	{
		return new ListNode<Type>(value, next==null ? null : next.clone());
	}
}
