
public class TreeMain {

	public static void main(String[] args) {
		Node root = new Node(10);
		root.setRight(new Node(13));
		root.setLeft(new Node(6));
		
		BinaryTree tree = new BinaryTree(root);
		TreePrinter.printTree(tree);
		
		System.out.println();
		System.out.println();
		
		tree.insert(22);
		tree.insert(1);
		tree.insert(12);
		tree.insert(6);
		tree.insert(12);
		tree.insert(10);
		TreePrinter.printTree(tree);
		
		System.out.println();
		System.out.println();
		
		tree.delete(10);
		tree.delete(6);
		tree.deleteAll(12);
		TreePrinter.printTree(tree);
	}

}
