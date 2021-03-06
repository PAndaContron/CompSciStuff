package dataStructures;

import java.util.Arrays;
import java.util.LinkedList;

public class DataStructuresDriver
{
	public static void main(String[] args)
	{
		System.out.println("*********************TESTING STACK*********************");
		LinkedListStack<Integer> stack = new LinkedListStack<>();
		System.out.println("Pushing values: 123456789");
		for(int i=1; i<10; i++)
			stack.push(i);
		System.out.println("Popping values:");
		for(int i=0; i<9; i++)
			System.out.println(stack.pop());
		System.out.println("Pushing values: 123456789");
		for(int i=1; i<10; i++)
			stack.push(i);
		System.out.println("Popping values:");
		for(int i=0; i<9; i++)
			System.out.println(stack.pop());
		System.out.println();

		System.out.println("*********************TESTING QUEUE*********************");
		LinkedListQueue<Integer> queue = new LinkedListQueue<>();
		System.out.println("Enqueueing values: 123456789");
		for(int i=1; i<10; i++)
			queue.enqueue(i);
		System.out.println("Dequeueing values:");
		for(int i=0; i<9; i++)
			System.out.println(queue.dequeue());
		System.out.println("Enqueueing values: 123456789");
		for(int i=1; i<10; i++)
			queue.enqueue(i);
		System.out.println("Dequeueing values:");
		for(int i=0; i<9; i++)
			System.out.println(queue.dequeue());
		System.out.println();

		System.out.println("*****************TESTING BINARY TREE*******************");
		BinaryTree<Integer> tree = new BinaryTree<>();
		System.out.println("Inserting values: 123456789");
		for(int i=1; i<10; i++)
			tree.insert(i);
		System.out.println("Preorder: ");
		tree.printPreorder();
		System.out.println("Postorder: ");
		tree.printPostorder();
		System.out.println("Inorder: ");
		tree.printInorder();
		System.out.println("Breadth First: ");
		tree.printBreadthFirst();
		System.out.println("Breadth First Queue: ");
		tree.printBreadthFirstQ();
		System.out.println();

		System.out.println("***************TESTING BINARY SEARCH TREE**************");
		BinarySearchTree<Integer> searchTree = new BinarySearchTree<>();
		System.out.println("Inserting values: 56387214");
		searchTree.insert(5);
		searchTree.insert(6);
		searchTree.insert(3);
		searchTree.insert(8);
		searchTree.insert(7);
		searchTree.insert(2);
		searchTree.insert(1);
		searchTree.insert(4);
		System.out.println("Breadth First:");
		searchTree.printBreadthFirstQ();
		System.out.println("Is valid: "+searchTree.isValid());
		System.out.println("Does it contain 0?\t"+searchTree.search(0));
		System.out.println("Does it contain -1?\t"+searchTree.search(-1));
		System.out.println("Does it contain 9?\t"+searchTree.search(9));
		System.out.println("Does it contain 5?\t"+searchTree.search(5));
		System.out.println("Does it contain 1?\t"+searchTree.search(1));
		System.out.println("Does it contain 7?\t"+searchTree.search(7));
		System.out.println("Deleting 1...");
		searchTree.remove(1);
		System.out.println("Breadth First:");
		searchTree.printBreadthFirstQ();
		System.out.println("Is valid: "+searchTree.isValid());
		System.out.println("Deleting 8...");
		searchTree.remove(8);
		System.out.println("Breadth First:");
		searchTree.printBreadthFirstQ();
		System.out.println("Is valid: "+searchTree.isValid());
		System.out.println("Deleting 3...");
		searchTree.remove(3);
		System.out.println("Breadth First:");
		searchTree.printBreadthFirstQ();
		System.out.println("Is valid: "+searchTree.isValid());
		System.out.println("Conversions:");
		Integer[] array = {6, 7, 2, 9, 1, 0, 12, 4};
		BinarySearchTree.sort(array);
		LinkedList<Integer> list = new LinkedList<>();
		list.addAll(Arrays.asList(array));
		System.out.printf("Original Array/LinkedList: %s%n", Arrays.toString(array));
		System.out.print("Converting array: (Printed Inorder)");
		BinarySearchTree.convert(array).printInorder();
		System.out.print("Converting list: (Printed Inorder)");
		BinarySearchTree.convert(list).printInorder();
		System.out.print("Converting tree: (Printed Inorder)");
		BinarySearchTree.convert(tree).printInorder();
	}
}
