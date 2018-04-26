import java.util.LinkedList;
import java.util.NoSuchElementException;

/**
 * Binary tree of integers.
 * 
 * @author Eduardo
 * @author Alex
 * @author Josué
 *
 */
public class BinaryTree {
	private Node root;

	public BinaryTree() {
	}

	public BinaryTree(Node root) {
		this.root = root;
	}

	public Node getRoot() {
		return root;
	}

	public void setRoot(Node root) {
		this.root = root;
	}

	/**
	 * Returns true if the entered value is in the tree.
	 * 
	 * @param value
	 *            entered integer.
	 * @return true or false.
	 * @author Eduardo
	 */
	public boolean contains(int value) {
		return this.contains(value, this.root);
	}

	private boolean contains(int value, Node current) {
		if (current == null) {
			return false;
		} else if (value < current.getValue()) {
			return contains(value, current.getLeft());
		} else if (value > current.getValue()) {
			return contains(value, current.getRight());
		} else {
			return true;
		}
	}

	/**
	 * Adds a node with the given value to the binary tree.
	 * 
	 * @param value
	 *            given integer.
	 * @author Eduardo
	 */
	public void insert(int value) {
		this.root = this.insert(value, this.root);
	}

	private Node insert(int value, Node current) {
		if (current == null) {
			return new Node(value);
		} else if (value < current.getValue()) {
			current.setLeft(this.insert(value, current.getLeft()));
		} else if (value > current.getValue()) {
			current.setRight(this.insert(value, current.getRight()));
		} else if (value == current.getValue()) {
			current.setAmount(current.getAmount() + 1);
		}
		return current;
	}

	/**
	 * Deletes one of the given values. If the value has only been added once,
	 * deletes the node with that value.
	 * 
	 * @param value
	 *            given integer.
	 * @author Eduardo
	 */
	public void delete(int value) {
		this.root = this.delete(value, this.root);
	}

	private Node delete(int value, Node current) {
		if (current == null) {
			throw new NoSuchElementException("Value not found in the binary tree.");
		} else if (value < current.getValue()) {
			current.setLeft(delete(value, current.getLeft()));
		} else if (value > current.getValue()) {
			current.setRight(delete(value, current.getRight()));
		} else {
			if (current.getAmount() > 1) {
				current.setAmount(current.getAmount() - 1);
			} else if (current.getLeft() == null || current.getRight() == null) {
				Node temp = null;
				temp = current.getLeft() == null ? current.getRight() : current.getLeft();

				if (temp == null) {
					return null;
				} else {
					return temp;
				}
			} else {
				Node successor = this.getSuccessor(current);
				current.setValue(successor.getValue());
				current.setAmount(successor.getAmount());
				current.setRight(this.deleteAll(successor.getValue(), current.getRight()));
				return current;
			}
		}
		return current;
	}

	/**
	 * Deletes the node with the given value.
	 * 
	 * @param value
	 *            given integer.
	 * @author Eduardo
	 */
	public void deleteAll(int value) {
		this.root = deleteAll(value, this.root);
	}

	private Node deleteAll(int value, Node current) {
		if (current == null) {
			throw new NoSuchElementException("Value not found in the binary tree.");
		} else if (value < current.getValue()) {
			current.setLeft(deleteAll(value, current.getLeft()));
		} else if (value > current.getValue()) {
			current.setRight(deleteAll(value, current.getRight()));
		} else {
			if (current.getLeft() == null || current.getRight() == null) {
				Node temp = null;
				temp = current.getLeft() == null ? current.getRight() : current.getLeft();

				if (temp == null) {
					return null;
				} else {
					return temp;
				}
			} else {
				Node successor = this.getSuccessor(current);
				current.setValue(successor.getValue());
				current.setAmount(successor.getAmount());
				current.setRight(this.deleteAll(successor.getValue(), current.getRight()));
				return current;
			}
		}
		return current;
	}

	/**
	 * Returns the successor of a node that has to be deleted and has left and right
	 * nodes.
	 * 
	 * @param node
	 *            node to be deleted.
	 * @return the successor.
	 * @author Eduardo
	 */
	private Node getSuccessor(Node node) {
		Node temp = node.getRight();

		while (temp.getLeft() != null) {
			temp = temp.getLeft();
		}

		return temp;
	}

	/**
	 * Prints the binary tree.
	 * 
	 * @author Eduardo
	 */
	public void print() {
		TreePrinter.print(this.root);
		System.out.println("\n" + "\n");
	}

	/**
	 * Finds the node with the minimum value.
	 * 
	 * @return node with the minimum value.
	 * @author Eduardo
	 */
	public Node findMin() {
		return findMin(this.root);
	}

	private Node findMin(Node current) {
		if (current == null) {
			return null;
		} else if (current.getLeft() == null) {
			return current;
		} else {
			return findMin(current.getLeft());
		}
	}

	/**
	 * Finds the node with the maximum value.
	 * 
	 * @return node with the maximum value.
	 * @author Eduardo
	 */
	public Node findMax() {
		return findMax(this.root);
	}

	private Node findMax(Node current) {
		if (current == null) {
			return null;
		} else if (current.getRight() == null) {
			return current;
		} else {
			return findMax(current.getRight());
		}
	}

	/**
	 * Gives the difference between the maximum and minimum values in the tree.
	 * 
	 * @return an integer.
	 * @author Eduardo
	 */
	public int dif() {
		return findMax().getValue() - findMin().getValue();
	}

	/**
	 * Goes through the binary tree in this order: 1. Visits the root. 2. Crosses
	 * the left sub-tree. 3. Crosses the right sub-tree.
	 * 
	 * @author Josué
	 */
	public synchronized void preorder() {

		preorderAux(this.root);

	}

	/**
	 * Auxiliary function to travel the binary tree in the preorder way.
	 * 
	 * @param Node
	 *            current
	 * @author Josué
	 */

	private void preorderAux(Node current) {

		if (current == null)
			return;

		System.out.print(current.getValue() + " ");
		preorderAux(current.getLeft());
		preorderAux(current.getRight());
	}

	/**
	 * Travel the binary tree in such a way that: 1. Crosses the left sub-tree 2.
	 * Visits the root 3. Crosses the right sub-tree.
	 * 
	 * @author Josué
	 */
	public synchronized void inorder() {

		inorderAux(this.root);
	}

	/**
	 * Auxiliary function to travel the binary tree in the inorder way.
	 * 
	 * @param Node
	 *            current
	 * @author Josué
	 */
	private void inorderAux(Node current) {

		if (current == null)
			return;

		inorderAux(current.getLeft());
		System.out.print(current.getValue() + " ");
		inorderAux(current.getRight());
	}

	/**
	 * Visits the binary tree in such a way that: 1. Crosses the left sub-tree. 2.
	 * Crosses the right sub-tree. 3. Visits the root.
	 * 
	 * @author Josué
	 */
	public synchronized void postorder() {

		postorderAux(this.root);
	}

	/**
	 * Auxiliary function to travel the binary tree in the postorder way.
	 * 
	 * @param Node
	 *            current
	 * @author Josué
	 */
	private void postorderAux(Node current) {

		if (current == null)
			return;

		postorderAux(current.getLeft());
		postorderAux(current.getRight());
		System.out.print(current.getValue() + " ");
	}

	/**
	 * Adds this tree to the given binary search tree.
	 * 
	 * @param B2
	 *            A given BT to be merged with.
	 * @author Alex
	 */

	public void merge(BinaryTree B2) {
		LinkedList<Integer> tempL = new LinkedList<Integer>();
		this.inorderB(tempL);
		BinaryTree temp = B2;
		for (int i = 0; i < tempL.size(); i++) {
			temp.insert(tempL.get(i));
		}
	}

	/**
	 * Converts this tree to a combination of two given binary search trees.
	 * 
	 * @param B1
	 *            A given BinaryTree
	 * @param B2
	 *            A given BinaryTree
	 * @author Alex
	 * @author Eduardo (changed method to void)
	 */
	public void merge(BinaryTree B1, BinaryTree B2) {
		LinkedList<Integer> tempL = new LinkedList<Integer>();
		B1.inorderB(tempL);
		BinaryTree temp = B2;
		for (int i = 0; i < tempL.size(); i++) {
			temp.insert(tempL.get(i));
		}

		this.setRoot(temp.root);
	}

	/**
	 * Travels the binary tree in such a way that: 1. Visits the left sub-tree
	 * adding each element to a list as it returns. 2. Visits the root and adds it
	 * to the list. 3. Visits the right sub-tree adding each element to a list as it
	 * returns.
	 * 
	 * @author Alex
	 */

	public synchronized void inorderB(LinkedList<Integer> tempL) {

		inorderAuxB(this.root, tempL);
	}

	/**
	 * Auxiliary function to travel the binary tree in the inorder way.
	 * 
	 * @param Node
	 *            current, LinkedList tempL
	 * @author Alex
	 */
	private void inorderAuxB(Node current, LinkedList<Integer> tempL) {

		if (current == null)
			return;
		inorderAuxB(current.getLeft(), tempL);
		tempL.add(current.getValue());
		inorderAuxB(current.getRight(), tempL);

	}
}
