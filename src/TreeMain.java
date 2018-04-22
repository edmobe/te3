
public class TreeMain {

	public static void main(String[] args) {
		// Create the tree.
		BinaryTree tree = new BinaryTree(new Node(10));

		// Insert values to the tree. For example:
		tree.insert(14);
		tree.insert(16);
		tree.insert(22);
		tree.insert(2);
		tree.insert(12);
		tree.insert(6);
		tree.insert(1);
		tree.insert(12);
		tree.insert(11);
		tree.insert(14);
		tree.insert(14);
		tree.insert(14);
		tree.insert(13);
		tree.insert(10);

		// Print the tree.
		tree.print();

		// Test here.
		/*
		 * Some tests.
		 */

		// Print the tree again.
		tree.print();

	}

}
