//Rajat Patel

public class DoublyLinkedListDriver 
{

	public static void main(String[] args) 
	{
		MyDoublyLinkedList<String> list = new MyDoublyLinkedList<>();
		
		list.add("Namath");
		list.add("Sauer");
		list.add("Maynard");
		list.add("Snell");
		list.add("Boozer");
		list.add("Atkinson");
		list.add("Dockery");
		list.add("Lammons");
		
		System.out.println(list);
		list.printBackwards();
		
		MyDoublyLinkedList<Integer> list2 = new MyDoublyLinkedList<>();
		
		list2.add(42);
		list2.add(55);
		list2.add(76);
		list2.add(13);
		list2.add(84);
		list2.add(72);
		list2.add(65);
		list2.add(115);
		
		System.out.println(list2);
		list2.printBackwards();
	}

}
