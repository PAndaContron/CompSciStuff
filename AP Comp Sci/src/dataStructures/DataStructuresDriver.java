package dataStructures;

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

		System.out.println("*********************TESTING TREE**********************");
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
	}
}
