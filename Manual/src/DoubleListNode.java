//Rajat Patel

public class DoubleListNode<Type> extends ListNode<Type>
{
	private DoubleListNode<Type> previous;
	
	public DoubleListNode(Type initObj, DoubleListNode<Type> initNext) 
	{
		super(initObj, initNext);
		previous = null;
	}
	
	public DoubleListNode(Type initObj, DoubleListNode<Type> initNext, DoubleListNode<Type> initPrev) 
	{
		super(initObj, initNext);
		previous = initPrev;
	}
	
	public DoubleListNode<Type> getNext()
	{
		return (DoubleListNode<Type>) super.getNext();
	}
	
	public void setNext(DoubleListNode<Type> node)
	{
		super.setNext(node);
	}
	
	public DoubleListNode<Type> getPrevious()
	{
		return previous;
	}
	
	public void setPrevious(DoubleListNode<Type> node)
	{
		previous = node;
	}
}
