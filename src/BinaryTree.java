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
	 */
	public void print() {
		TreePrinter.print(this.root);
		System.out.println("\n" + "\n");
	}

	/**
	 * Finds the node with the minimum value.
	 * 
	 * @return node with the minimum value.
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
	 */
	public int dif() {
		return findMax().getValue() - findMin().getValue();
	}
}
