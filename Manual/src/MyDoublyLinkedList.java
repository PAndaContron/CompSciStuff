//Rajat Patel

public class MyDoublyLinkedList<Type extends Comparable<Type>> extends MyLinkedList<Type> 
{
	protected DoubleListNode<Type> first;
	protected DoubleListNode<Type> last;
	
	public boolean add(Type t)
	{
		DoubleListNode<Type> node = new DoubleListNode<Type>(t, null, last);
		if(size==0)
			first = node;
		else
			last.setNext(node);
		last = node;
		size++;
		return true;
	}
	
	public DoubleListNode<Type> getNode(int index)
	{
		DoubleListNode<Type> current = first;
		for(int i=0;current!=null&&i<index;i++)
		{
			current = current.getNext();
			counterGet++;
		}
		return current;
	}
	
	public Type get(int i)
	{
		return getNode(i).getValue();
	}
	
	public String toString()
	{
		String s = "[";
		for(DoubleListNode<Type> current = first; current != null; current = current.getNext())
			s += current.getValue().toString()+",";
		s = s.substring(0, s.length()-1)+"]";
		return s;
	}
	
	public void printBackwards()
	{
		String s = "[";
		for(DoubleListNode<Type> current = last; current != null; current = current.getPrevious())
			s += current.getValue().toString()+",";
		s = s.substring(0, s.length()-1)+"]";
		System.out.println(s);
	}
}
