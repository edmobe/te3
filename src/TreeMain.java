
/**
 * Main class for tests.
 * 
 * @author Eduardo
 *
 */
public class TreeMain {

	public static void main(String[] args) {
		// Create the tree.
		BinaryTree tree = new BinaryTree();

		// Insert values to the tree. For example:
		tree.insert(100);
		tree.insert(20);
		tree.insert(140);
		tree.insert(160);
		tree.insert(220);
		tree.insert(20);
		tree.insert(120);
		tree.insert(60);
		tree.insert(10);
		tree.insert(120);
		tree.insert(110);
		tree.insert(140);
		tree.insert(140);
		tree.insert(140);
		tree.insert(130);
		tree.insert(100);

		// Print the tree.
		tree.print();
		
		// Test here.
		/*
		 * Test
		 * Test
		 * Test
		 */

		// Print the tree again if needed.
		// tree.print();
	}

}
