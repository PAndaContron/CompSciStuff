import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.stream.Stream;

//***********************************************************************************
//  Rajat Patel
//  MyLinkedList
//  9/12/2017
//  A linked list
//***********************************************************************************

public class MyLinkedList<Type extends Comparable<Type>> implements Iterable<Type>
{
	protected ListNode<Type> first;
	protected int size = 0;
	
	protected int counterGet = 0, counterToString = 0;
	
	public MyLinkedList()
	{
	}
	
	public MyLinkedList(Collection<Type> c)
	{
		addAll(c);
	}
	
	public MyLinkedList(Type[] array)
	{
		addAll(array);
	}
	
	protected MyLinkedList(ListNode<Type> first)
	{
		this.first = first.clone();
	}
	
	protected ListNode<Type> getNode(int index)
	{
		ListNode<Type> current = first;
		for(int i=0;current!=null&&i<index;i++)
		{
			current = current.getNext();
			counterGet++;
		}
		return current;
	}

	public Type get(int index)
	{
		if(index<0 || index>=size)
			throw new IndexOutOfBoundsException();
		ListNode<Type> node = getNode(index);
		if(node==null)
			return null;
		return node.getValue();
	}
	
	public Type getFirst()
	{
		return first.getValue();
	}
	
	public Type getLast()
	{
		return get(size-1);
	}
	
	public Iterator<Type> iterator()
	{
		return new LinkedIterator();
	}
	
	protected MemoryIterable memoryIterable()
	{
		return new MemoryIterable();
	}
	
	public Type[] toArray()
	{
		Type[] array = (Type[])new Comparable[size];
		int i = 0;
		for(Type t : this)
		{
			counterToString++;
			array[i] = t;
			i++;
		}
		return array;
	}
	
	public Stream<Type> stream()
	{
		return Stream.of(toArray());
	}
	
	public boolean add(Type nextObj)
	{
		if(nextObj==null)
			throw new NullPointerException();
		if(first==null)
			first = new ListNode<Type>(nextObj,null);
		else
			getNode(size-1).setNext(new ListNode<Type>(nextObj,null));
		
		size++;
		return true;
	}
	
	public boolean add(int index,Type nextObj)
	{
		if(index<0)
			throw new IllegalArgumentException("Index must be greater than 0");
		if(index>size)
			throw new IndexOutOfBoundsException("Index: "+index+" Size: "+size);
		if(first==null)
			first = new ListNode<Type>(nextObj,null);
		if(index==0)
			return addFirst(nextObj);
		ListNode<Type> previous = getNode(index-1);
		ListNode<Type> after = previous.getNext();
		previous.setNext(new ListNode<Type>(nextObj,after));
		size++;
		return true;
	}

	public boolean addFirst(Type newFirstValue)
	{
		if(newFirstValue==null)
			throw new NullPointerException();
		ListNode<Type> newFirst = new ListNode<Type>(newFirstValue,first);
		first = newFirst;
		size++;
		return true;
	}
	
	public void addLast(Type nextObj)
	{
		add(nextObj);
	}
	
	public boolean addAll(Collection<Type> tList)
	{
		for(Type t : tList)
			add(t);
		return true;
	}
	
	public boolean addAll(Type[] array)
	{
		for(Type t : array)
			add(t);
		return true;
	}
	
	public boolean addAll(int i, Collection<Type> tList)
	{
		for(Type t : tList)
		{
			add(i, t);
			i++;
		}
		return true;
	}
	
	public boolean addAll(int i, Type[] array)
	{
		for(Type t : array)
		{
			add(i, t);
			i++;
		}
		return true;
	}
	
	public Type set(int i, Type newObj)
	{
		if(i<0 || i>=size)
			throw new IndexOutOfBoundsException();
		ListNode<Type> current = getNode(i);
		Type output = current.getValue();
		current.setValue(newObj);
		return output;
	}

	public Type remove()
	{
		if(size==0)
			throw new IllegalStateException("List is empty");
		ListNode<Type> previous = getNode(--size - 1);
		ListNode<Type> output = previous.getNext();
		previous.setNext(null);
		return output.getValue();
	}
	
	public Type remove(int index)
	{
		if(index<0)
			throw new IllegalArgumentException("Index must be greater than 0");
		if(index>=size)
			throw new IndexOutOfBoundsException("Index: "+index+" Size: "+size);
		if(index==0)
			return removeFirst();
		size--;
		ListNode<Type> previous = getNode(index-1);
		Type output = previous.getNext().getValue();
		previous.setNext(previous.getNext().getNext());
		return output;
	}
	
	public boolean remove(Type element)
	{
		if(size==0)
			throw new IllegalStateException("List is empty");
		if(!contains(element))
			return false;
		remove(indexOf(element));
		return true;
	}
	
	public Type removeFirst()
	{
		if(size==0)
			throw new IllegalStateException("List is empty");
		size--;
		Type value = first.getValue();
		first = first.getNext();
		return value;
	}
	
	public Type removeLast()
	{
		return remove();
	}

	public boolean removeAll(Collection<Type> c)
	{
		if(c==null)
			throw new NullPointerException();
		boolean modified = false;
		for(Type t : c)
			if(remove(t))
				modified = true;
		return modified;
	}
	
	public void clear()
	{
		first = null;
		size = 0;
	}
	
	public boolean contains(Type element)
	{
		if(element==null)
			throw new NullPointerException();
		for(Type t : this)
			if(t.equals(element))
				return true;
		return false;
	}
	
	public boolean containsAll(Collection<Type> c)
	{
		if(c==null)
			throw new NullPointerException();
		return c.stream().allMatch(element -> contains(element));
	}
	
	public int indexOf(Type element)
	{
		if(element==null)
			throw new NullPointerException();
		int i = 0;
		for(Type t : this)
		{
			if(t.equals(element))
				return i;
			i++;
		}
		return -1;
	}
	
	public int lastIndexOf(Type element)
	{
		if(element==null)
			throw new NullPointerException();
		for(int i = size-1;i>=0;i--)
			if(get(i).equals(element))
				return i;
		return -1;
	}
	
	public MyLinkedList<Type> subList(int i, int j)
	{
		if(i<0 || j<0)
			throw new IllegalArgumentException("Indexes must be greater than 0");
		if(i>=size)
			throw new IndexOutOfBoundsException("1st Index: "+i+" Size: "+size);
		if(j>=size)
			throw new IndexOutOfBoundsException("2nd Index: "+j+" Size: "+size);
		int size = j-i;
		MyLinkedList<Type> list = new MyLinkedList<Type>(getNode(i));
		while(list.size()>size)
			list.remove();
		return list;
	}
	
	public int size()
	{
		return size;
	}
	
	public void print()
	{
		System.out.print(this);
	}
	
	public void println()
	{
		System.out.println(this);
	}
	
	public void printBackwards()
	{
		printBackwards(first);
	}
	
	public int counterGet()
	{
		return counterGet;
	}
	
	public void resetCounterGet()
	{
		counterGet = 0;
	}
	
	public int counterToString()
	{
		return counterToString;
	}
	
	public void resetCounterToString()
	{
		counterToString = 0;
	}
	
	protected void printBackwards(ListNode<Type> node)
	{
		if(node.getNext()!=null)
			printBackwards(node.getNext());
		System.out.println(node.getValue());
	}
	
	public String toString()
	{
		return Arrays.toString(toArray());
	}
	
	public String toStringMemory()
	{
		ListNode<Type>[] array = (ListNode<Type>[]) new ListNode[size];
		int i = 0;
		for(ListNode<Type> t : memoryIterable())
		{
			array[i] = t;
			i++;
		}
		return Arrays.toString(array);
	}
	
	public MyLinkedList<Type> clone()
	{
		return new MyLinkedList<Type>(first);
	}
	
	public boolean equals(Object o)
	{
		if(!o.getClass().equals(getClass()))
			return false;
		MyLinkedList list = (MyLinkedList) o;
		if(size != list.size())
			return false;
		int i = 0;
		for(Type t : this)
		{
			if(!t.equals(list.get(i)))
				return false;
			i++;
		}
		return true;
	}
	
	public int hashCode()
	{
		int hashCode = 1;
	    for (Type type : this)
	        hashCode = 31*hashCode + (type==null ? 0 : type.hashCode());
	    return hashCode;
	}

	protected class LinkedIterator implements Iterator<Type>
	{
		Iterator<ListNode<Type>> iterator;
		public LinkedIterator()
		{
			iterator = memoryIterable().iterator();
		}
		
		public boolean hasNext() 
		{
			return iterator.hasNext();
		}

		public Type next()
		{
			return iterator.next().getValue();
		}
	}
	
	protected class MemoryIterable implements Iterable<ListNode<Type>>
	{
		public Iterator<ListNode<Type>> iterator()
		{
			return new NodeIterator();
		}
		
		private class NodeIterator implements Iterator<ListNode<Type>>
		{
			ListNode<Type> current;
			public NodeIterator()
			{
				current = first;
			}
			
			public boolean hasNext() 
			{
				return current != null;
			}
	
			public ListNode<Type> next()
			{
				if(!hasNext())
					throw new NoSuchElementException();
				ListNode<Type> output = current;
				current = current.getNext();
				return output;
			}
		}
	}
}
