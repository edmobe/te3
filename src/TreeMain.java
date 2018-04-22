
public class TreeMain {

	public static void main(String[] args) {
		Node root = new Node(10);
		root.setRight(new Node(13));
		root.setLeft(new Node(6));
		
		BinaryTree tree = new BinaryTree(root);
		TreePrinter.printTree(tree);
	}

}
